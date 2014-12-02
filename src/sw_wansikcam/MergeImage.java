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
			JOptionPane.showMessageDialog(null, "������ �������� �ʾҽ��ϴ�.", "���",
					JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		// �������� ���� ����
		File[] fileList = chooser.getSelectedFiles();
		fileCnt = fileList.length;	
		searchImageMinSize(fileList);
	}
	
	
	private void searchImageMinSize(File[] fileList){
		ImageIcon[] iconArray = new ImageIcon[fileCnt];
		
		// ���� ���� �̹����� ã�� ũ�⸦ ����

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
		
		// ���� ���� �̹����� ������ ũ��� ��� �̹����� ũ�⸦ �������ش�
		ImageIcon[] convIconArray = new ImageIcon[fileList.length];
		CropImage cropIm = new CropImage();
		cropIm.cutInable = true;
		for(int i = 0; i < fileList.length; i++){
			int width = iconArray[i].getIconWidth();
			int height = iconArray[i].getIconHeight();
			
			// �̹����� 1/3�������� ����
			int positionX = (int)width * 1/3;
			int positionY = (int)height * 1/3;
			
			// �����̹��� ũ�⸦ �ʰ��ߴٸ� 0�������� ����
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
			
			// Image -> BufferedImage ��ȯ
			BufferedImage bIm = new BufferedImage
					(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_RGB);
			bIm.getGraphics().drawImage(img, 0, 0, null);
			
			graphics.drawImage(bIm, minX*i, 0, null);
		}//for
	}
}
