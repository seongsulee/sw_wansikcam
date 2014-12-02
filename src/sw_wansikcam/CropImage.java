package sw_wansikcam;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

public class CropImage {
	// �쟾�뿭�븘�뱶濡� 留덉슦�뒪 醫뚰몴媛�, �옄瑜닿린 媛��뒫�뿬遺� ���옣
	public boolean cutInable = false;
	public int x, y, x_, y_;
	
	public void setSize(int positionX, int positionY, int width, int height){
		x = positionX;
		y = positionY;
		x_ = width;
		y_ = height;
	}
	
	public void printSize(){
		System.out.println(x + " ");
		System.out.println(y + " ");
		System.out.println(x_ + " ");
		System.out.println(x_ + " ");
	}
	
	public ImageIcon cutImage(ImageIcon _icon){
		Image img = _icon.getImage();
				
		// Image -> BufferedImage 蹂��솚
		BufferedImage bIm = new BufferedImage
				(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_RGB);
		bIm.getGraphics().drawImage(img, 0, 0, null);
		
		// �떆�옉�젏(x,y)�뿉�꽌 �걹�굹�뒗 吏��젏(x_, y_)源뚯� �옄瑜몃떎
		bIm = bIm.getSubimage(x, y, x_, y_);
		
		// BufferedImage -> Image 蹂��솚
		Image cutIm = Toolkit.getDefaultToolkit().createImage(bIm.getSource());
		
		// �씠誘몄��씪踰⑥뿉 異쒕젰
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
		// �걹�굹�뒗 �쐞移섎�� 李얜뒗�떎.
		if (cutInable == true){
			int width = (512 - _icon.getIconWidth()) / 2;
			int height = (512- _icon.getIconHeight()) / 2;
			x_ = _x-width;
			y_ = _y-height;
			
			// �겕湲곕�� 援ы븳�떎
			int xDistance = Math.abs(x - x_);
			int yDistance = Math.abs(y - y_);
			
			// �옉�� 媛믪쓣 �꽑�깮�븯�뿬 �떆�옉吏��젏�쑝濡� 吏��젙�븳�떎 
			x = x < x_? x : x_;
			y = y < y_? y : y_;
			
			// �엫�떆�쟾�뿭�븘�뱶�뿉 ���엯�빐以��떎
			x_ = xDistance;
			y_ = yDistance;
			
			// �옄瑜닿린 硫붿냼�뱶 �샇異�
			return cutImage(_icon);
		}
		return null;
	}
}
