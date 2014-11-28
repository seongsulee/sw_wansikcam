import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.RescaleOp;
import java.awt.image.LookupOp;
import java.awt.image.ShortLookupTable;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ImSWproject {

	int count = 0;
	
	private JFrame frmWansikcam;
	private JTextField RotauserText;
	private JTextField textField;
	private JTextField textField_1;
	public JLabel ImageLabel; // ????? ????? Label
	public JPanel Pn;
	static ImageIcon icon; //�ҷ��� ������ ���� ���� �Լ�
	JSlider Brightslider;
	JLabel BrightvalueLabel;//0 ��
	
	/*
	private static final short[] invertTable;

	static
	{
		invertTable = new short[256];
		for(int i = 0; i<256; i++)
		{
			invertTable[i] = (short)(255-i);
		}
	}
	*/
	

	public ImSWproject() {
		initialize();
	}
	
	
	public void BrightImage(float Value)
	{
		Image BrIm = icon.getImage();
		
		// Image -> BufferedImage ��ȯ
	    BufferedImage bIm = new BufferedImage
	            (BrIm.getWidth(null), BrIm.getHeight(null), BufferedImage.TYPE_INT_RGB);
	    bIm.getGraphics().drawImage(BrIm, 0, 0, null);
	    
	    float scaleFactor = (float) (1.0 + (Value / 120.0));
	    RescaleOp op = new RescaleOp(scaleFactor, 0, null);
	    bIm = op.filter(bIm, null);
	    Image cutIm = Toolkit.getDefaultToolkit().createImage(bIm.getSource());
	    ImageIcon reicon = new ImageIcon(cutIm);
	    ImageLabel.setIcon(reicon);

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
		
		// Image -> BufferedImage ��ȯ
	    BufferedImage bIm = new BufferedImage(BrIm.getWidth(null), BrIm.getHeight(null), BufferedImage.TYPE_INT_RGB);
	    bIm.getGraphics().drawImage(BrIm, 0, 0, null);
	    /*
		String inputImageLocation = "C:\\Users\\Y\\workspace\\Wansikcam_Filter\\src\\123.jpg";
        String outputImageLocationHF = "C:\\Users\\Y\\workspace\\Wansikcam_Filter\\src\\myImageHorizontalFlip.jpg";
        String outputImageLocationVF = "C:\\Users\\Y\\workspace\\Wansikcam_Filter\\src\\myImageVerticalFlip.jpg";
        String extension = "jpg";
	     */
        ImSWproject flipper = new ImSWproject();
 
        /**
         * Reading image from the file
         */
        /*
        System.out.println("Reading Image From :" + inputImageLocation);
        BufferedImage inputImage = flipper.readImage(inputImageLocation);
        BufferedImage img = inputImage;
        */
                
        //���� ����
        bIm = flipper.verticalflip(bIm);
        //flipper.writeImage(img, outputImageLocationVF, extension);
        
        ImageIcon reicon = new ImageIcon(bIm);
	    ImageLabel.setIcon(reicon);
	    icon = reicon;
    }
    
    public void HorizontalGlipImage()
    {
    	Image BrIm = icon.getImage();
		
		// Image -> BufferedImage ��ȯ
	    BufferedImage bIm = new BufferedImage(BrIm.getWidth(null), BrIm.getHeight(null), BufferedImage.TYPE_INT_RGB);
	    bIm.getGraphics().drawImage(BrIm, 0, 0, null);
	    
        ImSWproject flipper = new ImSWproject();
 
        //�¿� ����
        bIm = flipper.horizontalflip(bIm);
        //flipper.writeImage(bIm, outputImageLocationHF, extension);
        
        ImageIcon reicon = new ImageIcon(bIm);
	    ImageLabel.setIcon(reicon);
	    icon = reicon;
    }
	
    
	private int checkColorRange(int i) {
		// TODO Auto-generated method stub
		return 0;
	}

	private void initialize() {
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

		JLabel DecoLabel = new JLabel("�ٹ̱�");
		DecoLabel.setFont(new Font("���� ���", Font.BOLD, 14));
		DecoLabel.setBounds(20, 12, 57, 15);
		setpanel2.add(DecoLabel);

		JLabel FrameLabel = new JLabel("���� �ٹ̱�");
		FrameLabel.setFont(new Font("���� ���", Font.BOLD, 12));
		FrameLabel.setBounds(30, 34, 81, 15);
		setpanel2.add(FrameLabel);

		JRadioButton DecoRadio1 = new JRadioButton("����1");
		DecoRadio1.setFont(new Font("����", Font.PLAIN, 12));
		DecoRadio1.setBackground(Color.WHITE);
		DecoRadio1.setBounds(40, 56, 71, 23);
		setpanel2.add(DecoRadio1);

		JRadioButton DecoRadio2 = new JRadioButton("����2");
		DecoRadio2.setFont(new Font("����", Font.PLAIN, 12));
		DecoRadio2.setBackground(Color.WHITE);
		DecoRadio2.setBounds(126, 56, 71, 23);
		setpanel2.add(DecoRadio2);

		JRadioButton DecoRadio3 = new JRadioButton("����3");
		DecoRadio3.setFont(new Font("����", Font.PLAIN, 12));
		DecoRadio3.setBackground(Color.WHITE);
		DecoRadio3.setBounds(212, 56, 71, 23);
		setpanel2.add(DecoRadio3);

		JRadioButton DecoRadio4 = new JRadioButton("����4");
		DecoRadio4.setBackground(Color.WHITE);
		DecoRadio4.setFont(new Font("����", Font.PLAIN, 12));
		DecoRadio4.setBounds(301, 56, 71, 23);
		setpanel2.add(DecoRadio4);

		JButton DecosetBut = new JButton("����");
		DecosetBut.setFont(new Font("����", Font.PLAIN, 12));
		DecosetBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		DecosetBut.setBounds(384, 56, 97, 23);
		setpanel2.add(DecosetBut);

		JLabel AddLabel = new JLabel("���� ��ġ��	");
		AddLabel.setFont(new Font("���� ���", Font.BOLD, 12));
		AddLabel.setBounds(30, 85, 81, 15);
		setpanel2.add(AddLabel);

		JButton AddBut = new JButton("���� �ҷ�����");
		AddBut.setFont(new Font("����", Font.PLAIN, 12));
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

		JLabel BrightLabel = new JLabel("��� ����");
		BrightLabel.setFont(new Font("���� ���", Font.BOLD, 14));
		BrightLabel.setBounds(20, 20, 67, 15);
		setpanel1.add(BrightLabel);

		BrightvalueLabel = new JLabel("0");//0 ��
		BrightvalueLabel.setFont(new Font("����", Font.PLAIN, 12));
		BrightvalueLabel.setHorizontalAlignment(SwingConstants.CENTER);
		BrightvalueLabel.setBounds(273, 53, 45, 15);
		setpanel1.add(BrightvalueLabel);

		Brightslider = new JSlider();
		Brightslider.addChangeListener(new ChangeListener() 
		{
			public void stateChanged(ChangeEvent arg0) 
			{
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


		JButton BirightsetBut = new JButton("����");//�����ư
		BirightsetBut.setFont(new Font("����", Font.PLAIN, 12));
		BirightsetBut.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				float value = (float)Brightslider.getValue();
				BrightImage(value);
			}
		});
		BirightsetBut.setBounds(330, 50, 80, 23);
		setpanel1.add(BirightsetBut);


		JLabel FilterLabel = new JLabel("���� ȿ��");
		FilterLabel.setFont(new Font("���� ���", Font.BOLD, 14));
		FilterLabel.setBounds(20, 95, 67, 15);
		setpanel1.add(FilterLabel);

		JButton FilterBrackBut = new JButton("���");
		FilterBrackBut.setFont(new Font("����", Font.PLAIN, 12));
		FilterBrackBut.setBounds(30, 125, 97, 23);
		setpanel1.add(FilterBrackBut);
		
		    
		JButton FilterBlurBut = new JButton("�帲");
		FilterBlurBut.setFont(new Font("����", Font.PLAIN, 12));
		FilterBlurBut.setBounds(174, 125, 97, 23);
		setpanel1.add(FilterBlurBut);
		
		JButton FilterSepBut = new JButton("���Ǿ�");
		FilterSepBut.setFont(new Font("����", Font.PLAIN, 12));
		FilterSepBut.setBounds(313, 125, 97, 23);
		setpanel1.add(FilterSepBut);

		JButton FilterSharBut = new JButton("����");
		FilterSharBut.setFont(new Font("����", Font.PLAIN, 12));
		FilterSharBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		FilterSharBut.setBounds(30, 158, 97, 23);
		setpanel1.add(FilterSharBut);

		JButton FilterRevBut = new JButton("����");
		FilterRevBut.setFont(new Font("����", Font.PLAIN, 12));
		FilterRevBut.setBounds(174, 158, 97, 23);
		setpanel1.add(FilterRevBut);

		JLabel TransLabel = new JLabel("���� ����");
		TransLabel.setFont(new Font("���� ���", Font.BOLD, 14));
		TransLabel.setBounds(20, 201, 67, 15);
		setpanel1.add(TransLabel);

		JRadioButton RotacwRadio = new JRadioButton("�ð� ����"); // RotaRadio =
		// ?��???? ???
		RotacwRadio.setFont(new Font("����", Font.PLAIN, 12));
		RotacwRadio.setBackground(Color.WHITE);
		RotacwRadio.setBounds(30, 254, 121, 23);
		setpanel1.add(RotacwRadio);

		JRadioButton RotaccwRadio = new JRadioButton("�ݽð� ����");
		RotaccwRadio.setFont(new Font("����", Font.PLAIN, 12));
		RotaccwRadio.setBackground(Color.WHITE);
		RotaccwRadio.setBounds(174, 254, 121, 23);
		setpanel1.add(RotaccwRadio);

		JRadioButton RotauserRadio = new JRadioButton("����� ���� : ");
		RotauserRadio.setFont(new Font("����", Font.PLAIN, 12));
		RotauserRadio.setBackground(Color.WHITE);
		RotauserRadio.setBounds(30, 287, 108, 23);
		setpanel1.add(RotauserRadio);

		JLabel RotationLabel = new JLabel("ȸ��");
		RotationLabel.setFont(new Font("���� ���", Font.BOLD, 12));
		RotationLabel.setBounds(30, 226, 57, 15);
		setpanel1.add(RotationLabel);

		RotauserText = new JTextField();
		RotauserText.setFont(new Font("����", Font.PLAIN, 12));
		RotauserText.setBounds(146, 287, 143, 23);
		setpanel1.add(RotauserText);
		RotauserText.setColumns(10);

		JButton RotasetBut = new JButton("����");
		RotasetBut.setFont(new Font("����", Font.PLAIN, 12));
		RotasetBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		RotasetBut.setBounds(313, 287, 97, 23);
		setpanel1.add(RotasetBut);

		JLabel RevLabel = new JLabel("����");
		RevLabel.setFont(new Font("���� ���", Font.BOLD, 12));
		RevLabel.setBounds(30, 320, 80, 15);
		setpanel1.add(RevLabel);

		JButton RevRLBut = new JButton("�¿� ����");
		RevRLBut.setFont(new Font("����", Font.PLAIN, 12));
		RevRLBut.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				HorizontalGlipImage();
			}
		});
		RevRLBut.setBounds(78, 345, 97, 23);
		setpanel1.add(RevRLBut);

		JButton RevTBBut = new JButton("���� ����");
		RevTBBut.setFont(new Font("����", Font.PLAIN, 12));
		RevTBBut.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				VerticalFlipImage();		        
			}
		});
		RevTBBut.setBounds(252, 345, 97, 23);
		setpanel1.add(RevTBBut);

		JLabel SizeLabel = new JLabel("ũ�� ����");
		SizeLabel.setFont(new Font("���� ���", Font.BOLD, 12));
		SizeLabel.setBounds(30, 380, 57, 15);
		setpanel1.add(SizeLabel);

		JLabel SizeXLabel = new JLabel("���� :");
		SizeXLabel.setFont(new Font("Gulim", Font.PLAIN, 12));
		SizeXLabel.setBounds(40, 405, 40, 15);
		setpanel1.add(SizeXLabel);

		textField = new JTextField();
		textField.setBounds(85, 404, 80, 16);
		textField.setColumns(10);
		textField.addKeyListener(new KeyListener()//KeyListener ������ ����
		{
			public void keyTyped(KeyEvent e) //Key �̺�Ʈ�� �߻����� ��
			{  
				char c = e.getKeyChar();//�޾Ƶ��� ���� c�� ����
				if(!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE)|| (c == KeyEvent.VK_ENTER)))
				{//���� ������ Ű�� �齺���̽�, ����Ʈ, ����Ű�� �ƴҽ�
					JOptionPane.showMessageDialog(null, ""+c+"�� ���� Ű�� �ƴմϴ�.\n���ڸ� �Է��ϼ���.", "���", JOptionPane.ERROR_MESSAGE);// ���â �߻�
					e.consume();//������Ű�� ������� ����
				}
			}
			public void keyPressed(KeyEvent ke) {}
			public void keyReleased(KeyEvent ke) {}
		});
		setpanel1.add(textField);

		JLabel SizeYLabel = new JLabel("���� :");
		SizeYLabel.setFont(new Font("����", Font.PLAIN, 12));
		SizeYLabel.setBounds(181, 405, 40, 15);
		setpanel1.add(SizeYLabel);

		textField_1 = new JTextField();
		textField_1.setBounds(225, 404, 80, 16);
		textField_1.setColumns(10);

		textField_1.addKeyListener(new KeyListener()//KeyListener ������ ����
		{
			public void keyTyped(KeyEvent e) //Key �̺�Ʈ�� �߻����� ��
			{  
				char c = e.getKeyChar();//�޾Ƶ��� ���� c�� ����
				if(!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE)|| (c == KeyEvent.VK_ENTER)))
				{//���� ������ Ű�� �齺���̽�, ����Ʈ, ����Ű�� �ƴҽ�
					JOptionPane.showMessageDialog(null, ""+c+"�� ���� Ű�� �ƴմϴ�.\n���ڸ� �Է��ϼ���.", "���", JOptionPane.ERROR_MESSAGE);// ���â �߻�
					e.consume();//������Ű�� ������� ����
				}
			}
			public void keyPressed(KeyEvent ke) {}
			public void keyReleased(KeyEvent ke) {}
		});
		setpanel1.add(textField_1);


		JButton SizesetBut = new JButton("����");
		SizesetBut.setFont(new Font("����", Font.PLAIN, 12));

		SizesetBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = textField.getText();
				String str_1 = textField_1.getText();
				int int_str = 0;
				int int_str_1 = 0;

				if (icon == null) {
					JOptionPane.showMessageDialog(null, "������ ���õ��� �ʾҽ��ϴ�.",
							"���", JOptionPane.WARNING_MESSAGE);
					return;
				} 
				else if(str.length() == 0 && str_1.length() == 0) {
					JOptionPane.showMessageDialog(null, "���ΰ��� ���ΰ��� �Է����� �ʾҽ��ϴ�.",
							"���", JOptionPane.WARNING_MESSAGE);
					return;
				}
				else if(str.length() == 0) {
					JOptionPane.showMessageDialog(null, "���ΰ��� �Է����� �ʾҽ��ϴ�.",
							"���", JOptionPane.WARNING_MESSAGE);
					return;
				}
				else if(str_1.length() == 0) {
					JOptionPane.showMessageDialog(null, "���ΰ��� �Է����� �ʾҽ��ϴ�.",
							"���", JOptionPane.WARNING_MESSAGE);
					return;
				}
				else if(str.length() != 0 || str_1.length() != 0) {
					int_str = Integer.parseInt(str);
					int_str_1 = Integer.parseInt(str_1);
				}
				if(int_str == 0 || int_str_1 == 0) {
					JOptionPane.showMessageDialog(null, "0���� �Էµ� �� �����ϴ�.",
							"���", JOptionPane.WARNING_MESSAGE);
					return;
				} 

				int width = Integer.parseInt(str);
				int length = Integer.parseInt(str_1);

				ImageIcon icon2 = icon;
				Image im = icon2.getImage();
				Image resize = im.getScaledInstance(width, length, java.awt.Image.SCALE_SMOOTH);
				ImageIcon reicon = new ImageIcon(resize);
				ImageLabel.setIcon(reicon);
			}
		});

		SizesetBut.setBounds(313, 401, 97, 23);
		setpanel1.add(SizesetBut);

		JLabel FormLabel = new JLabel("���� ����");
		FormLabel.setFont(new Font("���� ���", Font.BOLD, 12));
		FormLabel.setBounds(30, 440, 57, 15);
		setpanel1.add(FormLabel);

		JRadioButton JpegRadio = new JRadioButton("JPEG");
		JpegRadio.setBackground(Color.WHITE);
		JpegRadio.setBounds(40, 464, 87, 23);
		setpanel1.add(JpegRadio);

		JRadioButton JpgRadio = new JRadioButton("JPG");
		JpgRadio.setBackground(Color.WHITE);
		JpgRadio.setBounds(174, 464, 87, 23);
		setpanel1.add(JpgRadio);

		JRadioButton BmpRadio = new JRadioButton("BMP");
		BmpRadio.setBackground(Color.WHITE);
		BmpRadio.setBounds(313, 464, 80, 23);
		setpanel1.add(BmpRadio);

		JRadioButton PngRadio = new JRadioButton("PNG");
		PngRadio.setBackground(Color.WHITE);
		PngRadio.setBounds(40, 495, 87, 23);
		setpanel1.add(PngRadio);

		JRadioButton GifRadio = new JRadioButton("GIF");
		GifRadio.setBackground(Color.WHITE);
		GifRadio.setBounds(174, 495, 87, 23);
		setpanel1.add(GifRadio);

		JButton FormsetBut = new JButton("����");
		FormsetBut.setFont(new Font("����", Font.PLAIN, 12));
		FormsetBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		FormsetBut.setBounds(313, 495, 97, 23);
		setpanel1.add(FormsetBut);

		JLabel CutLabel = new JLabel("�ڸ���");
		CutLabel.setFont(new Font("���� ���", Font.BOLD, 12));
		CutLabel.setBounds(30, 531, 57, 15);
		setpanel1.add(CutLabel);

		JButton CutBut = new JButton("�ڸ���");
		CutBut.setFont(new Font("����", Font.PLAIN, 12));
		CutBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		CutBut.setBounds(40, 556, 97, 23);
		setpanel1.add(CutBut);

		JButton ResetBut = new JButton("���� �ǵ�����");
		ResetBut.setFont(new Font("����", Font.PLAIN, 12));
		ResetBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		ResetBut.setBounds(283, 601, 127, 23);
		setpanel1.add(ResetBut);

		ImageLabel = new JLabel();
		ImageLabel.setOpaque(true);
		ImageLabel.setBackground(Color.WHITE);
		ImageLabel.setBounds(12, 10, 512, 512);
		frmWansikcam.getContentPane().add(ImageLabel);

		JMenuBar menuBar = new JMenuBar();
		frmWansikcam.setJMenuBar(menuBar);

		JMenu FileMenu = new JMenu("File");
		JMenuItem openItem = new JMenuItem("Open");

		// Open ActionListener
		openItem.addActionListener(new OpenActionListener());
		FileMenu.add(openItem);

		menuBar.add(FileMenu);
		// this.setJMenuBar(menuBar);

		JMenu mnNewMenu_1 = new JMenu("New menu");
		menuBar.add(mnNewMenu_1);
	}

	// ???? - MenuBarEvent
	class OpenActionListener implements ActionListener {
		JFileChooser chooser;

		OpenActionListener() {
			chooser = new JFileChooser();
		}

		public void actionPerformed(ActionEvent e) {
			FileNameExtensionFilter filter = new FileNameExtensionFilter(
					"Images", "jpg", "gif", "jpeg", "png", "bmp");
			chooser.setFileFilter(filter);
			int ret = chooser.showOpenDialog(null);
			if (ret != JFileChooser.APPROVE_OPTION) {
				JOptionPane.showMessageDialog(null, "������ �������� �ʾҽ��ϴ�.", "���",
						JOptionPane.WARNING_MESSAGE);
				return;
			}

			// ?????? ?????? ??????? "????"????? ???? ???
			String filePath = chooser.getSelectedFile().getPath();
			icon = new ImageIcon(filePath);
			// Image im = icon.getImage();
			// Image resize =
			// im.getScaledInstance(100,1000,java.awt.Image.SCALE_SMOOTH);
			// ImageIcon reicon = new ImageIcon(resize);
			//ImageLabel.setIcon(icon);

			ImageLabel.setIcon(icon);
			//Pn.add(ImageLabel);
			//ImageLabel.setLocation(icon, 10);


			//			ImageLabel.setIcon(icon);
			//			label = new JLabel(icon, JLabel.CENTER);
			//			ImageLabel.add(label);

		}


	}
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					ImSWproject window = new ImSWproject();
					window.frmWansikcam.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}
}
