package sw_project_wansikcam;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

public class CutImage {
	// 전역필드로 마우스 좌표값, 자르기 가능여부 저장
	public boolean cutInable = false;
	private int x, y, x_, y_;
	
	public ImageIcon cutImage(ImageIcon _icon){
		Image img = _icon.getImage();
				
		// Image -> BufferedImage 변환
		BufferedImage bIm = new BufferedImage
				(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_RGB);
		bIm.getGraphics().drawImage(img, 0, 0, null);
		
		// 시작점(x,y)에서 끝나는 지점(x_, y_)까지 자른다
		bIm = bIm.getSubimage(x, y, x_, y_);
		
		// BufferedImage -> Image 변환
		Image cutIm = Toolkit.getDefaultToolkit().createImage(bIm.getSource());
		
		// 이미지라벨에 출력
		ImageIcon reicon = new ImageIcon(cutIm);
		return reicon;
		
	}
	
	public void mousePress(int _width, int _height, int _x, int _y){
		if (cutInable == true){
			int width = (512 - _width) / 2;
			int height = (512- _height) / 2;
			x = _x - width;
			y = _y - height;				
		}
	}
	
	public ImageIcon mouseReleased(ImageIcon _icon, int _x, int _y){
		// 끝나는 위치를 찾는다.
		if (cutInable == true){
			int width = (512 - _icon.getIconWidth()) / 2;
			int height = (512- _icon.getIconHeight()) / 2;
			x_ = _x-width;
			y_ = _y-height;
			
			// 크기를 구한다
			int xDistance = Math.abs(x - x_);
			int yDistance = Math.abs(y - y_);
			
			// 작은 값을 선택하여 시작지점으로 지정한다 
			x = x < x_? x : x_;
			y = y < y_? y : y_;
			
			// 임시전역필드에 대입해준다
			x_ = xDistance;
			y_ = yDistance;
			
			// 자르기 메소드 호출
			return cutImage(_icon);
		}
		return null;
	}
}
