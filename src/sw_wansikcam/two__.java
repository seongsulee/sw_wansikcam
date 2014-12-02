package sw_wansikcam;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Window;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

import javax.swing.event.*;
import javax.swing.filechooser.*;

import java.io.*;
//import java.net.MalformedURLException;
import java.net.URL;
import java.io.File;
import java.awt.image.BufferedImageOp;
import java.awt.image.ConvolveOp;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.awt.image.ImageProducer;
import java.awt.image.Kernel;
import java.awt.image.LookupOp;
import java.awt.image.ByteLookupTable;
import java.awt.image.BandCombineOp;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ByteLookupTable;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.awt.image.LookupOp;
import java.awt.image.Raster;
import java.awt.image.RescaleOp;
import java.awt.image.WritableRaster;

import javax.swing.JSlider;

public class two__ {
	//  private MyFilter colorFilter = new ColorFilter();

	private JFrame frmWansikcam;
	private JTextField RotauserText;
	private JTextField textField;
	private JTextField textField_1;
	public JLabel ImageLabel; //占쌓몌옙占쏙옙 占쌀뤄옙占쏙옙 Label
	
	JRadioButton GifRadio;
	JRadioButton PngRadio;
	JRadioButton BmpRadio;
	JRadioButton JpgRadio;
	JRadioButton JpegRadio;
	String form ;
	public JPanel Pn;
	ImageIcon icon; //遺덈윭�삩 �궗吏꾩쓽 媛믪쓣 媛뽯뒗 �븿�닔
	String filePath ;
	Image origin;
	BufferedImage temp =null;
	ImageIcon tempIcon =null;
	
	JSlider Brightslider;
	JLabel BrightvalueLabel;//0 占쏙옙
	
	public void BrightImage(float Value)
	{
		Image BrIm = icon.getImage();
		
		// Image -> BufferedImage 占쏙옙환
	    BufferedImage temp = new BufferedImage
	            (BrIm.getWidth(null), BrIm.getHeight(null), BufferedImage.TYPE_INT_RGB);
	    temp.getGraphics().drawImage(BrIm, 0, 0, null);
	    
	    float scaleFactor = (float) (1.0 + (Value / 120.0));
	    RescaleOp op = new RescaleOp(scaleFactor, 0, null);
	    temp = op.filter(temp, null);
	    Image cutIm = Toolkit.getDefaultToolkit().createImage(temp.getSource());
	    ImageIcon tempIcon = new ImageIcon(cutIm);
	    ImageLabel.setIcon(tempIcon);
	    icon = tempIcon;
	}
	 
	
    /**
 * This method reads an image from the file
 * @param fileLocation -- > eg. "C:/testImage.jpg"
 * @return BufferedImage of the file read
 */
    public BufferedImage readImage(String fileLocation) 
    {
        BufferedImage img = null;
        try 
        {
            img = ImageIO.read(new File(fileLocation));
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
 
        return img;
 
    }
 
    /**
 * This method writes a buffered image to a file
 * @param img -- > BufferedImage
 * @param fileLocation --> e.g. "C:/testImage.jpg"
 * @param extension --> e.g. "jpg","gif","png"
 */
public void writeImage(BufferedImage img, String fileLocation,
        String extension) {
    try {
        BufferedImage bi = img;
        File outputfile = new File(fileLocation);
        ImageIO.write(bi, extension, outputfile);
    } catch (IOException e) {
        e.printStackTrace();
    }
}

public BufferedImage horizontalflip(BufferedImage img) {
    int w = img.getWidth();
    int h = img.getHeight();
    BufferedImage dimg = new BufferedImage(w, h, img.getType());
    Graphics2D g = dimg.createGraphics();
    /**
     * img - the specified image to be drawn. This method does nothing if
     * img is null. dx1 - the x coordinate of the first corner of the
     * destination rectangle. dy1 - the y coordinate of the first corner of
     * the destination rectangle. dx2 - the x coordinate of the second
     * corner of the destination rectangle. dy2 - the y coordinate of the
     * second corner of the destination rectangle. sx1 - the x coordinate of
     * the first corner of the source rectangle. sy1 - the y coordinate of
     * the first corner of the source rectangle. sx2 - the x coordinate of
     * the second corner of the source rectangle. sy2 - the y coordinate of
     * the second corner of the source rectangle. observer - object to be
     * notified as more of the image is scaled and converted.
     *
     */
        g.drawImage(img, 0, 0, w, h, w, 0, 0, h, null);
        g.dispose();
        return dimg;
    }
 
    /**
 * This method flips the image vertically
 * @param img --> BufferedImage object to be flipped
 * @return
 */
    public BufferedImage verticalflip(BufferedImage img) 
    {
        int w = img.getWidth();
        int h = img.getHeight();
        BufferedImage dimg = new BufferedImage(w, h, img.getColorModel()
                .getTransparency());
        Graphics2D g = dimg.createGraphics();
        g.drawImage(img, 0, 0, w, h, 0, h, w, 0, null);
        g.dispose();
        return dimg;
    }
    
    public void VerticalFlipImage()
    {
    	Image BrIm = icon.getImage();
		
		// Image -> BufferedImage 占쏙옙환
	    BufferedImage temp = new BufferedImage(BrIm.getWidth(null), BrIm.getHeight(null), BufferedImage.TYPE_INT_RGB);
	    temp.getGraphics().drawImage(BrIm, 0, 0, null);
	    /*
		String inputImageLocation = "C:\\Users\\Y\\workspace\\Wansikcam_Filter\\src\\123.jpg";
        String outputImageLocationHF = "C:\\Users\\Y\\workspace\\Wansikcam_Filter\\src\\myImageHorizontalFlip.jpg";
        String outputImageLocationVF = "C:\\Users\\Y\\workspace\\Wansikcam_Filter\\src\\myImageVerticalFlip.jpg";
        String extension = "jpg";
	     */
        two__ flipper = new two__();
 
        /**
         * Reading image from the file
         */
        /*
        System.out.println("Reading Image From :" + inputImageLocation);
        BufferedImage inputImage = flipper.readImage(inputImageLocation);
        BufferedImage img = inputImage;
        */
                
        //占쏙옙占쏙옙 占쏙옙占쏙옙
        temp = flipper.verticalflip(temp);
        //flipper.writeImage(img, outputImageLocationVF, extension);
        
        ImageIcon tempIcon = new ImageIcon(temp);
	    ImageLabel.setIcon(tempIcon);
	    icon = tempIcon;
    }
    
    public void HorizontalGlipImage()
    {
    	Image BrIm = icon.getImage();
		
		// Image -> BufferedImage 占쏙옙환
	    BufferedImage temp = new BufferedImage(BrIm.getWidth(null), BrIm.getHeight(null), BufferedImage.TYPE_INT_RGB);
	    temp.getGraphics().drawImage(BrIm, 0, 0, null);
	    
        two__ flipper = new two__();
 
        //占승울옙 占쏙옙占쏙옙
        temp = flipper.horizontalflip(temp);
        //flipper.writeImage(temp, outputImageLocationHF, extension);
        
        ImageIcon tempIcon = new ImageIcon(temp);
	    ImageLabel.setIcon(tempIcon);
	    icon = tempIcon;
    }
	
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() {
				try {
					two__ window = new two__();
					window.frmWansikcam.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		);
	}


	public two__() 
	{
		initialize();
	}

	public void initialize() {
		frmWansikcam = new JFrame();
		frmWansikcam.setTitle("Wansikcam");
		frmWansikcam.setBounds(100, 100, 1002, 729);
		frmWansikcam.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmWansikcam.getContentPane().setLayout(null);
		
		JPanel setpanel2 = new JPanel();
		setpanel2.setBackground(Color.WHITE);
		setpanel2.setBounds(12, 532, 512, 124);
		frmWansikcam.getContentPane().add(setpanel2);
		setpanel2.setLayout(null);
		
		JLabel DecoLabel = new JLabel("袁몃�멸린");
		DecoLabel.setFont(new Font("留묒� 怨좊뵓", Font.BOLD, 14));
		DecoLabel.setBounds(20, 12, 57, 15);
		setpanel2.add(DecoLabel);
		
		JLabel FrameLabel = new JLabel("�븸�옄 袁몃�멸린");
		FrameLabel.setFont(new Font("留묒� 怨좊뵓", Font.BOLD, 12));
		FrameLabel.setBounds(30, 34, 81, 15);
		setpanel2.add(FrameLabel);
		
		JRadioButton DecoRadio1 = new JRadioButton("�븸�옄1");
		DecoRadio1.setFont(new Font("援대┝", Font.PLAIN, 12));
		DecoRadio1.setBackground(Color.WHITE);
		DecoRadio1.setBounds(40, 56, 71, 23);
		setpanel2.add(DecoRadio1);
		
		JRadioButton DecoRadio2 = new JRadioButton("�븸�옄2");
		DecoRadio2.setFont(new Font("援대┝", Font.PLAIN, 12));
		DecoRadio2.setBackground(Color.WHITE);
		DecoRadio2.setBounds(126, 56, 71, 23);
		setpanel2.add(DecoRadio2);
		
		JRadioButton DecoRadio3 = new JRadioButton("�븸�옄3");
		DecoRadio3.setFont(new Font("援대┝", Font.PLAIN, 12));
		DecoRadio3.setBackground(Color.WHITE);
		DecoRadio3.setBounds(212, 56, 71, 23);
		setpanel2.add(DecoRadio3);
		
		JRadioButton DecoRadio4 = new JRadioButton("�븸�옄4");
		DecoRadio4.setBackground(Color.WHITE);
		DecoRadio4.setFont(new Font("援대┝", Font.PLAIN, 12));
		DecoRadio4.setBounds(301, 56, 71, 23);
		setpanel2.add(DecoRadio4);
		
		JButton DecosetBut = new JButton("�쟻�슜");
		DecosetBut.setFont(new Font("援대┝", Font.PLAIN, 12));
		DecosetBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		DecosetBut.setBounds(384, 56, 97, 23);
		setpanel2.add(DecosetBut);
		
		JLabel AddLabel = new JLabel("�궗吏� �빀移섍린	");
		AddLabel.setFont(new Font("留묒� 怨좊뵓", Font.BOLD, 12));
		AddLabel.setBounds(30, 85, 81, 15);
		setpanel2.add(AddLabel);
		
		JButton AddBut = new JButton("�궗吏� 遺덈윭�삤湲�");
		AddBut.setFont(new Font("援대┝", Font.PLAIN, 12));
		AddBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		AddBut.setBounds(206, 91, 130, 23);
		setpanel2.add(AddBut);
		
		JPanel setpanel1 = new JPanel();
		setpanel1.setBackground(Color.WHITE);
		setpanel1.setBounds(536, 10, 438, 646);
		frmWansikcam.getContentPane().add(setpanel1);
		setpanel1.setLayout(null);
		
		JLabel BrightLabel = new JLabel("諛앷린 議곗젅");
		BrightLabel.setFont(new Font("留묒� 怨좊뵓", Font.BOLD, 14));
		BrightLabel.setBounds(20, 20, 67, 15);
		setpanel1.add(BrightLabel);
		
		BrightvalueLabel = new JLabel("0");//0 �씪踰�
		BrightvalueLabel.setFont(new Font("援대┝", Font.PLAIN, 12));
		BrightvalueLabel.setHorizontalAlignment(SwingConstants.CENTER);
		BrightvalueLabel.setBounds(273, 53, 45, 15);
		setpanel1.add(BrightvalueLabel);
		
		Brightslider = new JSlider();
		Brightslider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				int Value = Brightslider.getValue();
				BrightvalueLabel.setText(Value+"");
			}
		});
		
		Brightslider.setValue(0);
		Brightslider.setMinimum(-100);
		Brightslider.setMaximum(100);
		Brightslider.setBackground(Color.WHITE);
		Brightslider.setBounds(30, 50, 231, 23);
		setpanel1.add(Brightslider);
		
	
		JButton BirightsetBut = new JButton("�쟻�슜");//�쟻�슜
		BirightsetBut.setFont(new Font("援대┝", Font.PLAIN, 12));
		BirightsetBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				float value = (float)Brightslider.getValue();
				BrightImage(value);
			}
		});
		BirightsetBut.setBounds(330, 50, 80, 23);
		setpanel1.add(BirightsetBut);
		
		JLabel FilterLabel = new JLabel("�븘�꽣 �슚怨�");
		FilterLabel.setFont(new Font("留묒� 怨좊뵓", Font.BOLD, 14));
		FilterLabel.setBounds(20, 95, 67, 15);
		setpanel1.add(FilterLabel);
		
		JButton FiltergrayBut = new JButton("洹몃젅�씠");
        FiltergrayBut.setFont(new Font("援대┝", Font.PLAIN, 12));
        FiltergrayBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
	//			BufferedImage Origin = ImageIO.read(new File(filePath));
				temp = new BufferedImage(tempIcon.getIconWidth(), tempIcon
						.getIconHeight(), BufferedImage.TYPE_BYTE_GRAY);
				Graphics2D g2 = temp.createGraphics();
				g2.drawImage(temp, null, 0, 0);
				g2.dispose();
				tempIcon = new ImageIcon(temp);
				ImageLabel.setIcon(tempIcon);
			}
		});
        FiltergrayBut.setBounds(30, 125, 97, 23);
        setpanel1.add(FiltergrayBut);

		
		FiltergrayBut.setBounds(30, 125, 97, 23);
		setpanel1.add(FiltergrayBut);
		
		JButton FilterBlurBut = new JButton("�쓲由�");
		FilterBlurBut.setFont(new Font("援대┝", Font.PLAIN, 12));
		FilterBlurBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				temp = blurFilter(temp);
				tempIcon = new ImageIcon(temp);
				ImageLabel.setIcon(tempIcon);
			}
			private BufferedImage blurFilter(BufferedImage temp) 
			{
				float[] blurMatrix = { 1.0f / 9.0f, 1.0f / 9.0f, 1.0f / 9.0f,
						1.0f / 9.0f, 1.0f / 9.0f, 1.0f / 9.0f, 1.0f / 9.0f,
						1.0f / 9.0f, 1.0f / 9.0f };
				BufferedImageOp blurFilter = new ConvolveOp(new Kernel(3, 3,
						blurMatrix), ConvolveOp.EDGE_NO_OP, null);
				return blurFilter.filter(temp, null);
			}
		});
		FilterBlurBut.setBounds(174, 125, 97, 23);
		setpanel1.add(FilterBlurBut);
		
		JButton FilterSepBut = new JButton("�꽭�뵾�븘");
		FilterSepBut.setFont(new Font("援대┝", Font.PLAIN, 12));
		FilterSepBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				temp = sepiaFilter(temp);
				tempIcon = new ImageIcon(temp);
				ImageLabel.setIcon(tempIcon);
			}
			private BufferedImage sepiaFilter(BufferedImage image) 
			{
				BufferedImage original = image;
				image = new BufferedImage(image.getWidth(),image.getHeight(),BufferedImage.TYPE_INT_RGB);
				for (int i=0;i<image.getWidth();i++)
				    for (int j=0;j<image.getHeight();j++) {
						int rgb = original.getRGB(i, j);

						 int alpha = ((rgb >> 24) & 0xff);
						 int red = ((rgb >> 16) & 0xff);
						 int green = ((rgb >> 8) & 0xff);
						 int blue = ((rgb ) & 0xff);

						 int r = (int)(0.393*red+0.769*green+0.189*blue + 0.5);
						 if (r>255) r = 255;
						 int g = (int)(0.349*red+0.686*green+0.168*blue + 0.5);
						 if (g>255) g = 255;
						 int b = (int)(0.272*red+0.534*green+0.131*blue + 0.5);
						 rgb = (alpha << 24) | (r << 16) | (g << 8) | b;
						 image.setRGB(i,j, rgb);
					 }
				return image;
			}
		});
		FilterSepBut.setBounds(313, 125, 97, 23);
		setpanel1.add(FilterSepBut);
		
		JButton FilterSharBut = new JButton("�꽑紐�");
		FilterSharBut.setFont(new Font("援대┝", Font.PLAIN, 12));
		FilterSharBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				temp = sharpenFilter(temp);
				tempIcon = new ImageIcon(temp);
				ImageLabel.setIcon(tempIcon);
			}
			private BufferedImage sharpenFilter(BufferedImage temp) {
				float[] sharpenMatrix = { 0.0f, -1.0f, 0.0f, -1.0f, 5.0f,
						-1.0f, 0.0f, -1.0f, 0.0f };
				BufferedImageOp sharpenFilter = new ConvolveOp(new Kernel(3, 3,
						sharpenMatrix), ConvolveOp.EDGE_NO_OP, null);
				return sharpenFilter.filter(temp, null);
			}
			
		});
		FilterSharBut.setBounds(30, 158, 97, 23);
		setpanel1.add(FilterSharBut);
		
		JButton FilterRevBut = new JButton("諛섏쟾");
		FilterRevBut.setFont(new Font("援대┝", Font.PLAIN, 12));
		FilterRevBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				temp = invertFilter(temp);
				tempIcon = new ImageIcon(temp);
				ImageLabel.setIcon(tempIcon);
			}
			private BufferedImage invertFilter(BufferedImage temp) {
				byte[] invertArray = new byte[256];
			    for (int counter = 0; counter < 256; counter++)
			      invertArray[counter] = (byte) (255 - counter);
			    BufferedImageOp invertFilter = new LookupOp(new ByteLookupTable(0, invertArray), null);
			    return invertFilter.filter(temp, null);
			}
		});
		FilterRevBut.setBounds(174, 158, 97, 23);
		setpanel1.add(FilterRevBut);
		
		JLabel TransLabel = new JLabel("�궗吏� 蹂��삎");
		TransLabel.setFont(new Font("留묒� 怨좊뵓", Font.BOLD, 14));
		TransLabel.setBounds(20, 201, 67, 15);
		setpanel1.add(TransLabel);
		
		JRadioButton RotacwRadio = new JRadioButton("�떆怨� 諛⑺뼢");
		RotacwRadio.setFont(new Font("援대┝", Font.PLAIN, 12));
		RotacwRadio.setBackground(Color.WHITE);
		RotacwRadio.setBounds(30, 254, 121, 23);
		setpanel1.add(RotacwRadio);
		
		JRadioButton RotaccwRadio = new JRadioButton("諛섏떆怨� 諛⑺뼢");
		RotaccwRadio.setFont(new Font("援대┝", Font.PLAIN, 12));
		RotaccwRadio.setBackground(Color.WHITE);
		RotaccwRadio.setBounds(174, 254, 121, 23);
		setpanel1.add(RotaccwRadio);
		
		JRadioButton RotauserRadio = new JRadioButton("�궗�슜�옄 吏��젙 : ");
		RotauserRadio.setFont(new Font("援대┝", Font.PLAIN, 12));
		RotauserRadio.setBackground(Color.WHITE);
		RotauserRadio.setBounds(30, 287, 108, 23);
		setpanel1.add(RotauserRadio);
		
		JLabel RotationLabel = new JLabel("�쉶�쟾");
		RotationLabel.setFont(new Font("留묒� 怨좊뵓", Font.BOLD, 12));
		RotationLabel.setBounds(30, 226, 57, 15);
		setpanel1.add(RotationLabel);
		
		RotauserText = new JTextField();
		RotauserText.setFont(new Font("援대┝", Font.PLAIN, 12));
		RotauserText.setBounds(146, 287, 143, 23);
		setpanel1.add(RotauserText);
		RotauserText.setColumns(10);
		
		JButton RotasetBut = new JButton("�쟻�슜");
		RotasetBut.setFont(new Font("援대┝", Font.PLAIN, 12));
		RotasetBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		RotasetBut.setBounds(313, 287, 97, 23);
		setpanel1.add(RotasetBut);
		
		JLabel RevLabel = new JLabel("諛섏쟾");
		RevLabel.setFont(new Font("留묒� 怨좊뵓", Font.BOLD, 12));
		RevLabel.setBounds(30, 320, 80, 15);
		setpanel1.add(RevLabel);
		
		JButton RevRLBut = new JButton("醫뚯슦 諛섏쟾");
		RevRLBut.setFont(new Font("援대┝", Font.PLAIN, 12));
		RevRLBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HorizontalGlipImage();
			}
		});
		RevRLBut.setBounds(78, 345, 97, 23);
		setpanel1.add(RevRLBut);
		
		JButton RevTBBut = new JButton("�긽�븯 諛섏쟾");
		RevTBBut.setFont(new Font("援대┝", Font.PLAIN, 12));
		RevTBBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VerticalFlipImage();
			}
		});
		RevTBBut.setBounds(252, 345, 97, 23);
		setpanel1.add(RevTBBut);
		
		JLabel SizeLabel = new JLabel("�겕湲� 議곗젅");
		SizeLabel.setFont(new Font("留묒� 怨좊뵓", Font.BOLD, 12));
		SizeLabel.setBounds(30, 380, 57, 15);
		setpanel1.add(SizeLabel);
		
		JLabel SizeXLabel = new JLabel("媛�濡� :");
		SizeXLabel.setFont(new Font("Gulim", Font.PLAIN, 12));
		SizeXLabel.setBounds(40, 405, 40, 15);
		setpanel1.add(SizeXLabel);
		
		textField = new JTextField();
		textField.setBounds(85, 404, 80, 16);
		setpanel1.add(textField);
		textField.setColumns(10);
		
		JLabel SizeYLabel = new JLabel("�꽭濡� :");
		SizeYLabel.setFont(new Font("援대┝", Font.PLAIN, 12));
		SizeYLabel.setBounds(181, 405, 40, 15);
		setpanel1.add(SizeYLabel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(225, 404, 80, 16);
		setpanel1.add(textField_1);
		textField_1.setColumns(10);
		
		JButton SizesetBut = new JButton("�쟻�슜");
		SizesetBut.setFont(new Font("援대┝", Font.PLAIN, 12));
		SizesetBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		SizesetBut.setBounds(313, 401, 97, 23);
		setpanel1.add(SizesetBut);
		
//////////////�씗�젙/////////////////////////////////////////////////////////
		
		JLabel FormLabel = new JLabel("�룷硫� 蹂�寃�");
		FormLabel.setFont(new Font("留묒� 怨좊뵓", Font.BOLD, 12));
		FormLabel.setBounds(30, 440, 57, 15);
		setpanel1.add(FormLabel);
		
		ButtonGroup formg = new ButtonGroup();
		
		JpegRadio = new JRadioButton("JPEG");
		JpegRadio.setBackground(Color.WHITE);
		JpegRadio.setBounds(40, 464, 87, 23);
		setpanel1.add(JpegRadio);
		
		JpgRadio = new JRadioButton("JPG");
		JpgRadio.setBackground(Color.WHITE);
		JpgRadio.setBounds(174, 464, 87, 23);
		setpanel1.add(JpgRadio);
		
		BmpRadio = new JRadioButton("BMP");
		BmpRadio.setBackground(Color.WHITE);
		BmpRadio.setBounds(313, 464, 80, 23);
		setpanel1.add(BmpRadio);
		BmpRadio.addItemListener(new MyItemListener());
		
		PngRadio = new JRadioButton("PNG");
		PngRadio.setBackground(Color.WHITE);
		PngRadio.setBounds(40, 495, 87, 23);
		setpanel1.add(PngRadio);
		
		GifRadio = new JRadioButton("GIF");
		GifRadio.setBackground(Color.WHITE);
		GifRadio.setBounds(174, 495, 87, 23);
		setpanel1.add(GifRadio);
		
		formg.add(GifRadio);
		formg.add(PngRadio);
		formg.add(BmpRadio);
		formg.add(JpgRadio);
		formg.add(JpegRadio);		
		GifRadio.addItemListener(new MyItemListener());
		PngRadio.addItemListener(new MyItemListener());
		BmpRadio.addItemListener(new MyItemListener());
		JpgRadio.addItemListener(new MyItemListener());
		JpegRadio.addItemListener(new MyItemListener());
		
		  	if(GifRadio.isSelected())
				form = "gif";
			else if(PngRadio.isSelected())
				form = "png";
			else if(BmpRadio.isSelected())
				form = "bmp";
			else if(JpgRadio.isSelected())
				form = "jpg";
			else if(JpegRadio.isSelected())
				form = "jpeg";
		  	
		JButton FormsetBut = new JButton("�쟻�슜");
		FormsetBut.setFont(new Font("援대┝", Font.PLAIN, 12));
		FormsetBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				System.out.println("泥댄겕 踰꾪듉 : "+form);
				//�뙆�씪紐� �옄瑜닿린
				String fileNm = filePath.substring(0,filePath.lastIndexOf("."));
				System.out.println(fileNm+"泥댄겕踰꾪듉");
				
				BufferedImage image = null;
				try {
					image = ImageIO.read(new File(filePath));
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}		
			  	try {
						ImageIO.write(image, form, new File(fileNm+"_copy."+form));
			  	} 
			  	catch (IOException e1) 
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		FormsetBut.setBounds(313, 495, 97, 23);
		setpanel1.add(FormsetBut);
		
/////////////////////////////////////////////////////////////////////////////
		
		JLabel CutLabel = new JLabel("�옄瑜닿린");
		CutLabel.setFont(new Font("留묒� 怨좊뵓", Font.BOLD, 12));
		CutLabel.setBounds(30, 531, 57, 15);
		setpanel1.add(CutLabel);
		
		JButton CutBut = new JButton("�옄瑜닿린");
		CutBut.setFont(new Font("援대┝", Font.PLAIN, 12));
		CutBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
			}
		});
		CutBut.setBounds(40, 556, 97, 23);
		setpanel1.add(CutBut);
		
		JButton ResetBut = new JButton("�썝蹂� �릺�룎由ш린");
		ResetBut.setFont(new Font("援대┝", Font.PLAIN, 12));
		ResetBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try {
					temp = ImageIO.read(new File(filePath));
					tempIcon = new ImageIcon(temp);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ImageLabel.setIcon(icon);
			}
		});
		ResetBut.setBounds(283, 601, 127, 23);
		setpanel1.add(ResetBut);
		
		ImageLabel = new JLabel();
		ImageLabel.setBackground(Color.DARK_GRAY);
		ImageLabel.setBounds(12, 10, 512, 512);
		frmWansikcam.getContentPane().add(ImageLabel);
		
		JMenuBar menuBar = new JMenuBar();
		frmWansikcam.setJMenuBar(menuBar);
		
		JMenu FileMenu = new JMenu("File");		
		JMenuItem openItem = new JMenuItem("Open");
		JMenuItem saveItem = new JMenuItem("Save");

		//Open ActionListener
		openItem.addActionListener(new OpenActionListener());
		saveItem.addActionListener(new SaveActionListener());
		FileMenu.add(openItem);
		FileMenu.add(saveItem);
		
		menuBar.add(FileMenu);
		//this.setJMenuBar(menuBar);
		
		
		JMenu mnNewMenu_1 = new JMenu("New menu");
		menuBar.add(mnNewMenu_1);
	}
	
	//�씗�젙 - �룷硫㏓�寃�
	class MyItemListener implements ItemListener
	{		
		public void itemStateChanged(ItemEvent e) 
		{		
			if (e.getStateChange() == ItemEvent.DESELECTED)
				return;
			if(GifRadio.isSelected())
				form = "gif";
			else if(PngRadio.isSelected())
				form = "png";
			else if(BmpRadio.isSelected())
				form = "bmp";
			else if(JpgRadio.isSelected())
				form = "jpg";
			else if(JpegRadio.isSelected())
				form = "jpeg";	
		}
	}
	//�씗�젙- MenuBarEvent
	class OpenActionListener implements ActionListener 
	{
		
		JFileChooser chooser;

		OpenActionListener() 
		{
			chooser = new JFileChooser();
		}

		public void actionPerformed(ActionEvent e) 
		{
			FileNameExtensionFilter filter = new FileNameExtensionFilter(
					"Images", "jpg", "gif", "jpeg", "png", "bmp");
			chooser.setFileFilter(filter);
			int ret = chooser.showOpenDialog(null);
			if (ret != JFileChooser.APPROVE_OPTION) {
				JOptionPane.showMessageDialog(null, "�뙆�씪�쓣 �꽑�깮�븯吏� �븡�븯�뒿�땲�떎.",
						"寃쎄퀬", JOptionPane.WARNING_MESSAGE);
				return;
			}
			filePath = chooser.getSelectedFile().getPath();
			
			try 
			{
				temp = ImageIO.read(new File(filePath));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
            // 洹� �쐞�뿉 �뜮�뵆�슱 �씠誘몄�瑜� 遺덈윭�삩�떎.
			icon = new ImageIcon(filePath);
			ImageLabel.setIcon(icon);
			
		}
			
	}
	class SaveActionListener implements ActionListener 
	{
		
		JFileChooser chooser;

		SaveActionListener() 
		{
			chooser = new JFileChooser();
		}

		public void actionPerformed(ActionEvent e) 
		{
			FileNameExtensionFilter filter = new FileNameExtensionFilter(
					"Images", "jpg", "gif", "jpeg", "png", "bmp");
			chooser.setFileFilter(filter);
			
			int ret = chooser.showSaveDialog(null);
			if (ret != JFileChooser.APPROVE_OPTION) 
			{
				JOptionPane.showMessageDialog(null, "�뙆�씪�쓣 �꽑�깮�븯吏� �븡�븯�뒿�땲�떎.",
						"寃쎄퀬", JOptionPane.WARNING_MESSAGE);
				return;
			}
		}	
	}
}
