package sw_project_wansikcam;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

public class CutImage {
	// �����ʵ�� ���콺 ��ǥ��, �ڸ��� ���ɿ��� ����
	public boolean cutInable = false;
	private int x, y, x_, y_;
	
	public ImageIcon cutImage(ImageIcon _icon){
		Image img = _icon.getImage();
				
		// Image -> BufferedImage ��ȯ
		BufferedImage bIm = new BufferedImage
				(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_RGB);
		bIm.getGraphics().drawImage(img, 0, 0, null);
		
		// ������(x,y)���� ������ ����(x_, y_)���� �ڸ���
		bIm = bIm.getSubimage(x, y, x_, y_);
		
		// BufferedImage -> Image ��ȯ
		Image cutIm = Toolkit.getDefaultToolkit().createImage(bIm.getSource());
		
		// �̹����󺧿� ���
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
		// ������ ��ġ�� ã�´�.
		if (cutInable == true){
			int width = (512 - _icon.getIconWidth()) / 2;
			int height = (512- _icon.getIconHeight()) / 2;
			x_ = _x-width;
			y_ = _y-height;
			
			// ũ�⸦ ���Ѵ�
			int xDistance = Math.abs(x - x_);
			int yDistance = Math.abs(y - y_);
			
			// ���� ���� �����Ͽ� ������������ �����Ѵ� 
			x = x < x_? x : x_;
			y = y < y_? y : y_;
			
			// �ӽ������ʵ忡 �������ش�
			x_ = xDistance;
			y_ = yDistance;
			
			// �ڸ��� �޼ҵ� ȣ��
			return cutImage(_icon);
		}
		return null;
	}
}
