package sw_wansikcam;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MergeImage {
	protected BufferedImage mergeImage;
	private int fileCnt = 0;
	private int minX = 100000;
	private int minY = 100000;
	
	public MergeImage(){
		openfile();
	}
	
	private void openfile(){
		JFileChooser chooser = new JFileChooser();
		chooser.setMultiSelectionEnabled(true);
		
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
				"Images", "jpg", "gif", "jpeg", "png", "bmp");
		chooser.setFileFilter(filter);
		
		int ret = chooser.showOpenDialog(null);
		if (ret != JFileChooser.APPROVE_OPTION) {
			JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다.", "경고",
					JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		// 여러개의 파일 선택
		File[] fileList = chooser.getSelectedFiles();
		fileCnt = fileList.length;	
		searchImageMinSize(fileList);
	}
	
	
	private void searchImageMinSize(File[] fileList){
		ImageIcon[] iconArray = new ImageIcon[fileCnt];
		
		// 제일 작은 이미지를 찾아 크기를 저장

		for(int i = 0; i < fileCnt; i++){
			String filePath = fileList[i].getPath();
			iconArray[i] = new ImageIcon(filePath);
			int x = iconArray[i].getIconWidth();
			int y = iconArray[i].getIconHeight();
			if (x < minX){
				minX = x;						
			}
			if(y < minY){
				minY = y;
			}
		}//for
		
		modulateSmallestSize(fileList, iconArray);
	}
	
	private void modulateSmallestSize(File[] fileList, ImageIcon[] iconArray) {
		
		// 제일 작은 이미지와 동일한 크기로 모든 이미지의 크기를 조정해준다
		ImageIcon[] convIconArray = new ImageIcon[fileList.length];
		CropImage cropIm = new CropImage();
		cropIm.cutInable = true;
		for(int i = 0; i < fileList.length; i++){
			int width = iconArray[i].getIconWidth();
			int height = iconArray[i].getIconHeight();
			
			// 이미지는 1/3지점부터 시작
			int positionX = (int)width * 1/3;
			int positionY = (int)height * 1/3;
			
			// 원본이미지 크기를 초과했다면 0에서부터 시작
			if (positionX+minX > width){
				positionX = 0;
			}
			if (positionY+minY > height){
				positionY = 0;
			}
			cropIm.setSize(positionX, positionY, minX, minY);
			convIconArray[i] = cropIm.cutImage(iconArray[i]);		
		}
		cropIm.cutInable = false;
		
		mergeImages(convIconArray);
	}
	
	private void mergeImages(ImageIcon[] convIconArray){
		mergeImage = new BufferedImage(
					minX*fileCnt, minY,	BufferedImage.TYPE_INT_RGB);
		
		Graphics2D graphics = (Graphics2D) mergeImage.getGraphics();
		graphics.setBackground(Color.WHITE);
		
		for(int i = 0; i < fileCnt; i++){
			Image img = convIconArray[i].getImage();
			
			// Image -> BufferedImage 변환
			BufferedImage bIm = new BufferedImage
					(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_RGB);
			bIm.getGraphics().drawImage(img, 0, 0, null);
			
			graphics.drawImage(bIm, minX*i, 0, null);
		}//for
	}
}
