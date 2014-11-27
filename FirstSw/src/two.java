import java.awt.*;

import javax.swing.*;
import javax.imageio.ImageIO;

import java.io.*;

import javax.imageio.*;

import java.awt.event.*;
import java.awt.image.BufferedImage;

import javax.swing.event.*;
import javax.swing.filechooser.*;

import java.util.*;

public class ImSWproject {

	private JFrame frmWansikcam;
	private JTextField RotauserText;
	private JTextField textField;
	private JTextField textField_1;
	public JLabel ImageLabel; // ????? ????? Label
	public JLabel ImageLabel2;
	public JLabel ImageLabel3;
	public JLabel ImageLabel4;
	public JLabel ImageLabel5;
	public JPanel Pn;
	ImageIcon icon; // 불러온 사진의 값을 갖는 함수
	int global_width;
	int global_height;
	String filePath;
	ImageIcon Deco_icon;
	ImageIcon change_icon;
	BufferedImage temp =null;
	
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {

			public void run() {
				try {
					ImSWproject window = new ImSWproject();
					window.frmWansikcam.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ImSWproject() {

		initialize();
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

		JLabel DecoLabel = new JLabel("꾸미기");
		DecoLabel.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		DecoLabel.setBounds(20, 12, 57, 15);
		setpanel2.add(DecoLabel);

		JLabel FrameLabel = new JLabel("액자 꾸미기");
		FrameLabel.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		FrameLabel.setBounds(30, 34, 81, 15);
		setpanel2.add(FrameLabel);

		ButtonGroup g = new ButtonGroup();

		JRadioButton DecoRadio1 = new JRadioButton("액자1");
		DecoRadio1.setFont(new Font("굴림", Font.PLAIN, 12));
		DecoRadio1.setBackground(Color.WHITE);
		DecoRadio1.setBounds(40, 56, 71, 23);

		JRadioButton DecoRadio2 = new JRadioButton("액자2");
		DecoRadio2.setFont(new Font("굴림", Font.PLAIN, 12));
		DecoRadio2.setBackground(Color.WHITE);
		DecoRadio2.setBounds(126, 56, 71, 23);

		JRadioButton DecoRadio3 = new JRadioButton("액자3");
		DecoRadio3.setFont(new Font("굴림", Font.PLAIN, 12));
		DecoRadio3.setBackground(Color.WHITE);
		DecoRadio3.setBounds(212, 56, 71, 23);
		JRadioButton DecoRadio4 = new JRadioButton("액자4");
		DecoRadio4.setBackground(Color.WHITE);
		DecoRadio4.setFont(new Font("굴림", Font.PLAIN, 12));
		DecoRadio4.setBounds(301, 56, 71, 23);

		g.add(DecoRadio1);
		setpanel2.add(DecoRadio1);
		g.add(DecoRadio2);
		setpanel2.add(DecoRadio2);
		g.add(DecoRadio3);
		setpanel2.add(DecoRadio3);
		g.add(DecoRadio4);
		setpanel2.add(DecoRadio4);

		DecoRadio1.addItemListener(new MyItemListener());
		DecoRadio2.addItemListener(new MyItemListener());
		DecoRadio3.addItemListener(new MyItemListener());
		DecoRadio4.addItemListener(new MyItemListener());


		JButton DecosetBut = new JButton("적용");
		DecosetBut.setFont(new Font("굴림", Font.PLAIN, 12));
		DecosetBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (icon == null) {
					JOptionPane.showMessageDialog(null, "사진을 불러오세요.", "경고",
							JOptionPane.ERROR_MESSAGE);// 경고창 발생
				}
				else
				{
					if(Deco_icon != null)
					{
						System.out.println(Deco_icon);
						change_icon = Deco_icon;
						Image img = change_icon.getImage();
						BufferedImage bi = new BufferedImage(img.getWidth(null),img.getHeight(null),BufferedImage.TYPE_INT_RGB);
						Graphics2D g2 = bi.createGraphics();
						g2.drawImage(img, 0, 0, null);
						g2.dispose();
						try {
							ImageIO.write(bi, "png", new File("images/change_icon.png"));
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						ImageLabel.setIcon(change_icon);
					}
				}
				/*try {
					// 배경이미지를 불러온다.
					BufferedImage bg = ImageIO.read(new File("images/44.png"));
					// 그 위에 덮씌울 이미지를 불러온다.
					BufferedImage front = ImageIO.read(new File(
							"images/rolloverIcon.gif"));
					// 오리지날 이미지의 크기보다 크게 메모리이미지 크기를 구성한다.
					int width_1 = front.getWidth();
					int height_1 = front.getHeight();
					int width_2 = front.getWidth() + 10;
					int height_2 = front.getHeight() + 10;
					BufferedImage tmp = new BufferedImage(width_2, height_2,
							BufferedImage.TYPE_INT_RGB);
					// 메모리이미지에서 Graphics2D를 얻어온다.
					Graphics2D g1 = tmp.createGraphics();
					// 메모리이미지에 그림을 그리자. 으싸 으싸~
					g1.drawImage(bg, null, 0, 0);
					g1.drawImage(front, (width_2 - width_1) / 2,
							(height_2 - height_1) / 2, width_1, height_1, null);
					// 메모리 이미지를 파일로 저장한다.

					File file = new File("images/3.jpg");
					ImageIO.write(tmp, "jpeg", file);
				} catch (IOException ioe) {
					ioe.printStackTrace();
				}
				icon = new ImageIcon("images/3.jpg");

				
				 * String s = "images/3.jpg"; File f = new File(s); if
				 * (f.delete()) { System.out.println("파일 또는 디렉토리를 성공적으로 지웠습니다: "
				 * + s); } else { System.err.println("파일 또는 디렉토리 지우기 실패: " + s);
				 * }

				System.out.println("이미지 합성이 완료되었습니다... 에헤라 디야~~");

			}*/
			}
		});

		DecosetBut.setBounds(384, 56, 97, 23);
		setpanel2.add(DecosetBut);

		JLabel AddLabel = new JLabel("사진 합치기	");
		AddLabel.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		AddLabel.setBounds(30, 85, 81, 15);
		setpanel2.add(AddLabel);

		JButton AddBut = new JButton("사진 불러오기");
		AddBut.setFont(new Font("굴림", Font.PLAIN, 12));
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

		JLabel BrightLabel = new JLabel("밝기 조절");
		BrightLabel.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		BrightLabel.setBounds(20, 20, 67, 15);
		setpanel1.add(BrightLabel);

		JSlider Brightslider = new JSlider();
		Brightslider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
			}
		});
		Brightslider.setValue(0);
		Brightslider.setMinimum(-50);
		Brightslider.setMaximum(50);
		Brightslider.setBackground(Color.WHITE);
		Brightslider.setBounds(30, 50, 231, 23);
		setpanel1.add(Brightslider);

		JLabel BrightvalueLabel = new JLabel("0");
		BrightvalueLabel.setFont(new Font("굴림", Font.PLAIN, 12));
		BrightvalueLabel.setHorizontalAlignment(SwingConstants.CENTER);
		BrightvalueLabel.setBounds(273, 53, 45, 15);
		setpanel1.add(BrightvalueLabel);

		JButton BirightsetBut = new JButton("적용");
		BirightsetBut.setFont(new Font("굴림", Font.PLAIN, 12));
		BirightsetBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		BirightsetBut.setBounds(330, 50, 80, 23);
		setpanel1.add(BirightsetBut);

		JLabel FilterLabel = new JLabel("필터 효과");
		FilterLabel.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		FilterLabel.setBounds(20, 95, 67, 15);
		setpanel1.add(FilterLabel);

		JButton FiltergrayBut = new JButton("그레이");
	      FiltergrayBut.setFont(new Font("굴림", Font.PLAIN, 12));
	      FiltergrayBut.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent arg0) {
	        	 try{
	        	BufferedImage Origin = ImageIO.read(new File(filePath));
	        	temp = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(), BufferedImage.TYPE_BYTE_GRAY);
	            Graphics2D g2 = temp.createGraphics();
	            g2.drawImage(Origin,null,0,0);
	            g2.dispose();
	            ImageIcon tempIcon = new ImageIcon(temp);
	            ImageLabel.setIcon(tempIcon);
	        	 }
	        	 catch (IOException ioe) {
						ioe.printStackTrace();
					}
	         }
	      });
	      FiltergrayBut.setBounds(30, 125, 97, 23);
	      setpanel1.add(FiltergrayBut);

		JButton FilterBlurBut = new JButton("흐림");
		FilterBlurBut.setFont(new Font("굴림", Font.PLAIN, 12));
		FilterBlurBut.setBounds(174, 125, 97, 23);
		setpanel1.add(FilterBlurBut);

		JButton FilterSepBut = new JButton("세피아");
		FilterSepBut.setFont(new Font("굴림", Font.PLAIN, 12));
		FilterSepBut.setBounds(313, 125, 97, 23);
		setpanel1.add(FilterSepBut);

		JButton FilterSharBut = new JButton("선명");
		FilterSharBut.setFont(new Font("굴림", Font.PLAIN, 12));
		FilterSharBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		FilterSharBut.setBounds(30, 158, 97, 23);
		setpanel1.add(FilterSharBut);

		JButton FilterRevBut = new JButton("반전");
		FilterRevBut.setFont(new Font("굴림", Font.PLAIN, 12));
		FilterRevBut.setBounds(174, 158, 97, 23);
		setpanel1.add(FilterRevBut);

		JLabel TransLabel = new JLabel("사진 변형");
		TransLabel.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		TransLabel.setBounds(20, 201, 67, 15);
		setpanel1.add(TransLabel);

		JRadioButton RotacwRadio = new JRadioButton("시계 방향"); // RotaRadio =
																// ?ð???? ???
		RotacwRadio.setFont(new Font("굴림", Font.PLAIN, 12));
		RotacwRadio.setBackground(Color.WHITE);
		RotacwRadio.setBounds(30, 254, 121, 23);
		setpanel1.add(RotacwRadio);

		JRadioButton RotaccwRadio = new JRadioButton("반시계 방향");
		RotaccwRadio.setFont(new Font("굴림", Font.PLAIN, 12));
		RotaccwRadio.setBackground(Color.WHITE);
		RotaccwRadio.setBounds(174, 254, 121, 23);
		setpanel1.add(RotaccwRadio);

		JRadioButton RotauserRadio = new JRadioButton("사용자 지정 : ");
		RotauserRadio.setFont(new Font("굴림", Font.PLAIN, 12));
		RotauserRadio.setBackground(Color.WHITE);
		RotauserRadio.setBounds(30, 287, 108, 23);
		setpanel1.add(RotauserRadio);

		JLabel RotationLabel = new JLabel("회전");
		RotationLabel.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		RotationLabel.setBounds(30, 226, 57, 15);
		setpanel1.add(RotationLabel);

		RotauserText = new JTextField();
		RotauserText.setFont(new Font("굴림", Font.PLAIN, 12));
		RotauserText.setBounds(146, 287, 143, 23);
		setpanel1.add(RotauserText);
		RotauserText.setColumns(10);

		JButton RotasetBut = new JButton("적용");
		RotasetBut.setFont(new Font("굴림", Font.PLAIN, 12));
		RotasetBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		RotasetBut.setBounds(313, 287, 97, 23);
		setpanel1.add(RotasetBut);

		JLabel RevLabel = new JLabel("반전");
		RevLabel.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		RevLabel.setBounds(30, 320, 80, 15);
		setpanel1.add(RevLabel);

		JButton RevRLBut = new JButton("좌우 반전");
		RevRLBut.setFont(new Font("굴림", Font.PLAIN, 12));
		RevRLBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		RevRLBut.setBounds(78, 345, 97, 23);
		setpanel1.add(RevRLBut);

		JButton RevTBBut = new JButton("상하 반전");
		RevTBBut.setFont(new Font("굴림", Font.PLAIN, 12));
		RevTBBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		RevTBBut.setBounds(252, 345, 97, 23);
		setpanel1.add(RevTBBut);

		JLabel SizeLabel = new JLabel("크기 조절");
		SizeLabel.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		SizeLabel.setBounds(30, 380, 57, 15);
		setpanel1.add(SizeLabel);

		JLabel SizeXLabel = new JLabel("가로 :");
		SizeXLabel.setFont(new Font("Gulim", Font.PLAIN, 12));
		SizeXLabel.setBounds(40, 405, 40, 15);
		setpanel1.add(SizeXLabel);

		textField = new JTextField();
		textField.setBounds(85, 404, 80, 16);
		textField.setColumns(10);
		textField.addKeyListener(new KeyListener()// KeyListener 리스너 구현
				{

					public void keyTyped(KeyEvent e) // Key 이벤트가 발생했을 시
					{
						char c = e.getKeyChar();// 받아들인 값을 c에 저장
						if (!(Character.isDigit(c)
								|| (c == KeyEvent.VK_BACK_SPACE)
								|| (c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_ENTER))) {// 만약
																							// 눌러진
																							// 키가
																							// 백스페이스,
																							// 델리트,
																							// 엔터키가
																							// 아닐시
							JOptionPane.showMessageDialog(null, "" + c
									+ "는 숫자 키가 아닙니다.\n숫자를 입력하세요.", "경고",
									JOptionPane.ERROR_MESSAGE);// 경고창 발생
							e.consume();// 눌러진키는 사라지게 설정
						}
					}

					public void keyPressed(KeyEvent ke) {
					}

					public void keyReleased(KeyEvent ke) {
					}
				});
		setpanel1.add(textField);

		JLabel SizeYLabel = new JLabel("세로 :");
		SizeYLabel.setFont(new Font("굴림", Font.PLAIN, 12));
		SizeYLabel.setBounds(181, 405, 40, 15);
		setpanel1.add(SizeYLabel);

		textField_1 = new JTextField();
		textField_1.setBounds(225, 404, 80, 16);
		textField_1.setColumns(10);

		textField_1.addKeyListener(new KeyListener()// KeyListener 리스너 구현
				{
					public void keyTyped(KeyEvent e) // Key 이벤트가 발생했을 시
					{

						char c = e.getKeyChar();// 받아들인 값을 c에 저장
						if (!(Character.isDigit(c)
								|| (c == KeyEvent.VK_BACK_SPACE)
								|| (c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_ENTER))) {// 만약
																							// 눌러진
																							// 키가
																							// 백스페이스,
																							// 델리트,
																							// 엔터키가
																							// 아닐시
							JOptionPane.showMessageDialog(null, "" + c
									+ "는 숫자 키가 아닙니다.\n숫자를 입력하세요.", "경고",
									JOptionPane.ERROR_MESSAGE);// 경고창 발생
							e.consume();// 눌러진키는 사라지게 설정
						}
					}

					public void keyPressed(KeyEvent ke) {
					}

					public void keyReleased(KeyEvent ke) {
					}
				});
		setpanel1.add(textField_1);

		JButton SizesetBut = new JButton("적용");
		SizesetBut.setFont(new Font("굴림", Font.PLAIN, 12));

		SizesetBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = textField.getText();
				String str_1 = textField_1.getText();
				int int_str = 0;
				int int_str_1 = 0;

				if (icon == null) {
					JOptionPane.showMessageDialog(null, "사진이 선택되지 않았습니다.",
							"경고", JOptionPane.WARNING_MESSAGE);
					return;
				} else if (str.length() == 0 && str_1.length() == 0) {
					JOptionPane.showMessageDialog(null,
							"가로값과 세로값을 입력하지 않았습니다.", "경고",
							JOptionPane.WARNING_MESSAGE);
					return;
				} else if (str.length() == 0) {
					JOptionPane.showMessageDialog(null, "가로값을 입력하지 않았습니다.",
							"경고", JOptionPane.WARNING_MESSAGE);
					return;
				} else if (str_1.length() == 0) {
					JOptionPane.showMessageDialog(null, "세로값을 입력하지 않았습니다.",
							"경고", JOptionPane.WARNING_MESSAGE);
					return;
				} else if (str.length() != 0 || str_1.length() != 0) {
					int_str = Integer.parseInt(str);
					int_str_1 = Integer.parseInt(str_1);
				}
				if (int_str == 0 || int_str_1 == 0) {
					JOptionPane.showMessageDialog(null, "0값은 입력될 수 없습니다.",
							"경고", JOptionPane.WARNING_MESSAGE);
					return;
				}

				int width = Integer.parseInt(str);
				int length = Integer.parseInt(str_1);

				if(change_icon == null)
				{
					ImageIcon icon2 = icon;
					Image im = icon2.getImage();
					Image resize = im.getScaledInstance(width, length,
							java.awt.Image.SCALE_SMOOTH);
					change_icon = new ImageIcon(resize);
				}
				else
				{
					ImageIcon icon2 = change_icon;
					Image im = icon2.getImage();
					Image resize = im.getScaledInstance(width, length,
							java.awt.Image.SCALE_SMOOTH);
					change_icon = new ImageIcon(resize);
				}

				Image img = change_icon.getImage();
				BufferedImage bi = new BufferedImage(img.getWidth(null),img.getHeight(null),BufferedImage.TYPE_INT_RGB);
				Graphics2D g2 = bi.createGraphics();
				g2.drawImage(img, 0, 0, null);
				g2.dispose();
				try {
					ImageIO.write(bi, "png", new File("images/change_icon.png"));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ImageLabel.setIcon(change_icon);
			}
		});

		SizesetBut.setBounds(313, 401, 97, 23);
		setpanel1.add(SizesetBut);

		JLabel FormLabel = new JLabel("포멧 변경");
		FormLabel.setFont(new Font("맑은 고딕", Font.BOLD, 12));
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

		JButton FormsetBut = new JButton("적용");
		FormsetBut.setFont(new Font("굴림", Font.PLAIN, 12));
		FormsetBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		FormsetBut.setBounds(313, 495, 97, 23);
		setpanel1.add(FormsetBut);

		JLabel CutLabel = new JLabel("자르기");
		CutLabel.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		CutLabel.setBounds(30, 531, 57, 15);
		setpanel1.add(CutLabel);

		JButton CutBut = new JButton("자르기");
		CutBut.setFont(new Font("굴림", Font.PLAIN, 12));
		CutBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		CutBut.setBounds(40, 556, 97, 23);
		setpanel1.add(CutBut);

		JButton ResetBut = new JButton("원본 되돌리기");
		ResetBut.setFont(new Font("굴림", Font.PLAIN, 12));
		ResetBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		ResetBut.setBounds(283, 601, 127, 23);
		setpanel1.add(ResetBut);

		Pn = new JPanel();
		// Pn.setOpaque(true);
		Pn.setBackground(Color.WHITE);
		Pn.setBounds(12, 10, 512, 512);
		frmWansikcam.getContentPane().add(Pn);
		Pn.setLayout(new BorderLayout());

		// /////////////////요기 밑에부분 이미지라벨을 PN패널에 중앙에 위치하게끔만 하면 됨
		ImageLabel = new JLabel();
		ImageLabel.setOpaque(true);
		ImageLabel.setBackground(Color.WHITE);
		// ImageLabel.setSize(300, 300);

		// ImageLabel.setBounds(0, 0, 300, 300);

		// Pn.setLayout(null);
		// Pn.add(ImageLabel);

		// ImageLabel.setLayout(new FlowLayout(FlowLayout.CENTER));
		// Pn.add(ImageLabel, BorderLayout.CENTER);
		// Pn.setLayout(new FlowLayout(FlowLayout.CENTER));

		// ImageLabel2.setSize(300, 300);
		// Pn.setLayout(new BorderLayout());
		// ImageLabel.setBounds(0, 0, 300, 300);

		// Pn.setLayout(null);
		// Pn.add(ImageLabel);

		Pn.add(ImageLabel, BorderLayout.CENTER);
		/*
		 * ImageLabel2 = new JLabel("       "); ImageLabel2.setOpaque(true);
		 * ImageLabel2.setBackground(Color.BLUE); ImageLabel3 = new
		 * JLabel("       "); ImageLabel3.setOpaque(true);
		 * ImageLabel3.setBackground(Color.BLUE); ImageLabel4 = new
		 * JLabel("       "); ImageLabel4.setOpaque(true);
		 * ImageLabel4.setBackground(Color.BLUE); ImageLabel5 = new
		 * JLabel("       "); ImageLabel5.setOpaque(true);
		 * ImageLabel5.setBackground(Color.BLUE); Pn.add(ImageLabel2,
		 * BorderLayout.WEST); Pn.add(ImageLabel3, BorderLayout.NORTH);
		 * Pn.add(ImageLabel4, BorderLayout.EAST); Pn.add(ImageLabel5,
		 * BorderLayout.SOUTH);
		 */
		frmWansikcam.getContentPane().add(Pn);

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

	class MyItemListener implements ItemListener {

		public void itemStateChanged(ItemEvent e) {
			AbstractButton sel = (AbstractButton) e.getItemSelectable();
			int width_1 = 0;
			int height_1 = 0;
			int width_2 = 0;
			int height_2 = 0;
			
			if (e.getStateChange() == ItemEvent.DESELECTED)
				return;
			if (e.getStateChange() == ItemEvent.SELECTED) {
				if (icon == null) {
					JOptionPane.showMessageDialog(null, "사진을 불러오세요.", "경고",
							JOptionPane.ERROR_MESSAGE);// 경고창 발생
				} else {
					if (sel.getText().equals("액자1")) {
						try {
							if(change_icon == null)
							{
								// 배경이미지를 불러온다.
								BufferedImage bg = ImageIO.read(new File("images/deco_1.png"));
								System.out.println("11111");
								// 그 위에 덮씌울 이미지를 불러온다.
								BufferedImage front = ImageIO.read(new File(filePath));
								width_1 = front.getWidth();
								height_1 = front.getHeight();
								System.out.println(bg);
								width_2 = front.getWidth() + 30;
								height_2 = front.getHeight() + 30;
								BufferedImage tmp = new BufferedImage(width_2,height_2, BufferedImage.TYPE_INT_RGB);
								// 메모리이미지에서 Graphics2D를 얻어온다.
								Graphics2D g1 = tmp.createGraphics();
								// 메모리이미지에 그림을 그리자. 으싸 으싸~
								g1.drawImage(bg, null, 0, 0);
								g1.drawImage(front, (width_2 - width_1) / 2,
										(height_2 - height_1) / 2, width_1,
										height_1, null);
								// 메모리 이미지를 파일로 저장한다.
								File file = new File("images/Deco_image.png");
								ImageIO.write(tmp, "png", file);
								Deco_icon = new ImageIcon("images/Deco_image.png");
							}
							else
							{
								BufferedImage bg = ImageIO.read(new File("images/deco_1.png"));
								System.out.println("22222");
								BufferedImage front = ImageIO.read(new File("images/change_icon.png"));
								width_1 = front.getWidth();
								height_1 = front.getHeight();
								System.out.println(width_1);
								width_2 = front.getWidth() + 30;
								height_2 = front.getHeight() + 30;
								BufferedImage tmp = new BufferedImage(width_2,height_2, BufferedImage.TYPE_INT_RGB);
								// 메모리이미지에서 Graphics2D를 얻어온다.
								Graphics2D g1 = tmp.createGraphics();
								// 메모리이미지에 그림을 그리자. 으싸 으싸~
								g1.drawImage(bg, null, 0, 0);
								g1.drawImage(front, (width_2 - width_1) / 2,
										(height_2 - height_1) / 2, width_1,
										height_1, null);
								// 메모리 이미지를 파일로 저장한다.
								File file = new File("images/Deco_image.png");
								ImageIO.write(tmp, "png", file);
								Deco_icon = new ImageIcon("images/Deco_image.png");
							}							
						} catch (IOException ioe) {
							ioe.printStackTrace();
						}
						//ImageLabel.setIcon(Deco_icon);
						//String s = "images/3.jpg"; 
						//File f = new File(s);
						//f.delete();
						System.out.println(Deco_icon);
						ImageLabel.setIcon(Deco_icon);
						System.out.println("하이1");
						
						
					} else if (sel.getText().equals("액자2")) {
						try {
							if(change_icon == null)
							{
								// 배경이미지를 불러온다.
								BufferedImage bg = ImageIO.read(new File("images/deco_2.png"));
								System.out.println("11111");
								// 그 위에 덮씌울 이미지를 불러온다.
								BufferedImage front = ImageIO.read(new File(filePath));
								width_1 = front.getWidth();
								height_1 = front.getHeight();
								System.out.println(bg);
								width_2 = front.getWidth() + 30;
								height_2 = front.getHeight() + 30;
								BufferedImage tmp = new BufferedImage(width_2,height_2, BufferedImage.TYPE_INT_RGB);
								// 메모리이미지에서 Graphics2D를 얻어온다.
								Graphics2D g1 = tmp.createGraphics();
								// 메모리이미지에 그림을 그리자. 으싸 으싸~
								g1.drawImage(bg, null, 0, 0);
								g1.drawImage(front, (width_2 - width_1) / 2,
										(height_2 - height_1) / 2, width_1,
										height_1, null);
								// 메모리 이미지를 파일로 저장한다.
								File file = new File("images/Deco_image.png");
								ImageIO.write(tmp, "png", file);
								Deco_icon = new ImageIcon("images/Deco_image.png");
							}
							else
							{
								BufferedImage bg = ImageIO.read(new File("images/deco_2.png"));
								System.out.println("22222");
								BufferedImage front = ImageIO.read(new File("images/change_icon.png"));
								width_1 = front.getWidth();
								height_1 = front.getHeight();
								System.out.println(width_1);
								width_2 = front.getWidth() + 30;
								height_2 = front.getHeight() + 30;
								BufferedImage tmp = new BufferedImage(width_2,height_2, BufferedImage.TYPE_INT_RGB);
								// 메모리이미지에서 Graphics2D를 얻어온다.
								Graphics2D g1 = tmp.createGraphics();
								// 메모리이미지에 그림을 그리자. 으싸 으싸~
								g1.drawImage(bg, null, 0, 0);
								g1.drawImage(front, (width_2 - width_1) / 2,
										(height_2 - height_1) / 2, width_1,
										height_1, null);
								// 메모리 이미지를 파일로 저장한다.
								File file = new File("images/Deco_image.png");
								ImageIO.write(tmp, "png", file);
								Deco_icon = new ImageIcon("images/Deco_image.png");
							}							
						} catch (IOException ioe) {
							ioe.printStackTrace();
						}
						//ImageLabel.setIcon(Deco_icon);
						//String s = "images/3.jpg"; 
						//File f = new File(s);
						//f.delete();
						System.out.println(Deco_icon);
						ImageLabel.setIcon(Deco_icon);
						System.out.println("하이2");
					} else if (sel.getText().equals("액자3")) {
						try {
							if(change_icon == null)
							{
								// 배경이미지를 불러온다.
								BufferedImage bg = ImageIO.read(new File("images/deco_3.png"));
								System.out.println("11111");
								// 그 위에 덮씌울 이미지를 불러온다.
								BufferedImage front = ImageIO.read(new File(filePath));
								width_1 = front.getWidth();
								height_1 = front.getHeight();
								System.out.println(bg);
								width_2 = front.getWidth() + 30;
								height_2 = front.getHeight() + 30;
								BufferedImage tmp = new BufferedImage(width_2,height_2, BufferedImage.TYPE_INT_RGB);
								// 메모리이미지에서 Graphics2D를 얻어온다.
								Graphics2D g1 = tmp.createGraphics();
								// 메모리이미지에 그림을 그리자. 으싸 으싸~
								g1.drawImage(bg, null, 0, 0);
								g1.drawImage(front, (width_2 - width_1) / 2,
										(height_2 - height_1) / 2, width_1,
										height_1, null);
								// 메모리 이미지를 파일로 저장한다.
								File file = new File("images/Deco_image.png");
								ImageIO.write(tmp, "png", file);
								Deco_icon = new ImageIcon("images/Deco_image.png");
							}
							else
							{
								BufferedImage bg = ImageIO.read(new File("images/deco_3.png"));
								System.out.println("22222");
								BufferedImage front = ImageIO.read(new File("images/change_icon.png"));
								width_1 = front.getWidth();
								height_1 = front.getHeight();
								System.out.println(width_1);
								width_2 = front.getWidth() + 30;
								height_2 = front.getHeight() + 30;
								BufferedImage tmp = new BufferedImage(width_2,height_2, BufferedImage.TYPE_INT_RGB);
								// 메모리이미지에서 Graphics2D를 얻어온다.
								Graphics2D g1 = tmp.createGraphics();
								// 메모리이미지에 그림을 그리자. 으싸 으싸~
								g1.drawImage(bg, null, 0, 0);
								g1.drawImage(front, (width_2 - width_1) / 2,
										(height_2 - height_1) / 2, width_1,
										height_1, null);
								// 메모리 이미지를 파일로 저장한다.
								File file = new File("images/Deco_image.png");
								ImageIO.write(tmp, "png", file);
								Deco_icon = new ImageIcon("images/Deco_image.png");
							}							
						} catch (IOException ioe) {
							ioe.printStackTrace();
						}
						//ImageLabel.setIcon(Deco_icon);
						//String s = "images/3.jpg"; 
						//File f = new File(s);
						//f.delete();
						System.out.println(Deco_icon);
						ImageLabel.setIcon(Deco_icon);
						System.out.println("하이3");
					} else if (sel.getText().equals("액자4")) {
						try {
							if(change_icon == null)
							{
								// 배경이미지를 불러온다.
								BufferedImage bg = ImageIO.read(new File("images/deco_4.png"));
								System.out.println("11111");
								// 그 위에 덮씌울 이미지를 불러온다.
								BufferedImage front = ImageIO.read(new File(filePath));
								width_1 = front.getWidth();
								height_1 = front.getHeight();
								System.out.println(bg);
								width_2 = front.getWidth() + 30;
								height_2 = front.getHeight() + 30;
								BufferedImage tmp = new BufferedImage(width_2,height_2, BufferedImage.TYPE_INT_RGB);
								// 메모리이미지에서 Graphics2D를 얻어온다.
								Graphics2D g1 = tmp.createGraphics();
								// 메모리이미지에 그림을 그리자. 으싸 으싸~
								g1.drawImage(bg, null, 0, 0);
								g1.drawImage(front, (width_2 - width_1) / 2,
										(height_2 - height_1) / 2, width_1,
										height_1, null);
								// 메모리 이미지를 파일로 저장한다.
								File file = new File("images/Deco_image.png");
								ImageIO.write(tmp, "png", file);
								Deco_icon = new ImageIcon("images/Deco_image.png");
							}
							else
							{
								BufferedImage bg = ImageIO.read(new File("images/deco_4.png"));
								System.out.println("22222");
								BufferedImage front = ImageIO.read(new File("images/change_icon.png"));
								width_1 = front.getWidth();
								height_1 = front.getHeight();
								System.out.println(width_1);
								width_2 = front.getWidth() + 30;
								height_2 = front.getHeight() + 30;
								BufferedImage tmp = new BufferedImage(width_2,height_2, BufferedImage.TYPE_INT_RGB);
								// 메모리이미지에서 Graphics2D를 얻어온다.
								Graphics2D g1 = tmp.createGraphics();
								// 메모리이미지에 그림을 그리자. 으싸 으싸~
								g1.drawImage(bg, null, 0, 0);
								g1.drawImage(front, (width_2 - width_1) / 2,
										(height_2 - height_1) / 2, width_1,
										height_1, null);
								// 메모리 이미지를 파일로 저장한다.
								File file = new File("images/Deco_image.png");
								ImageIO.write(tmp, "png", file);
								Deco_icon = new ImageIcon("images/Deco_image.png");
							}							
						} catch (IOException ioe) {
							ioe.printStackTrace();
						}
						//ImageLabel.setIcon(Deco_icon);
						//String s = "images/3.jpg"; 
						//File f = new File(s);
						//f.delete();
						System.out.println(Deco_icon);
						ImageLabel.setIcon(Deco_icon);
						System.out.println("하이4");
					}
				}
			}
		}
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
				JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다.", "경고",
						JOptionPane.WARNING_MESSAGE);
				return;
			}

			// ?????? ?????? ??????? "????"????? ???? ???
			filePath = chooser.getSelectedFile().getPath();
			icon = new ImageIcon(filePath);
			// Image image = ImageIO.read(icon);
			global_width = icon.getIconWidth();
			global_height = icon.getIconHeight();

			// System.out.println(global_width+","+global_height);
			// Image im = icon.getImage();
			// Image resize =
			// im.getScaledInstance(100,1000,java.awt.Image.SCALE_SMOOTH);
			// ImageIcon reicon = new ImageIcon(resize);
			// ImageLabel.setIcon(icon);

			ImageLabel.setIcon(icon);
			// ImageLabel.setBounds(100, 50, 50, 50);
			// ImageLabel.setLayout(new BorderLayout());
			Pn.add(ImageLabel, BorderLayout.CENTER);// , BorderLayout.CENTER
			ImageLabel.setHorizontalAlignment(0);
			frmWansikcam.getContentPane().add(Pn);

			// Pn.setLayout(null);

			// Pn.add(ImageLabel, BorderLayout.CENTER);
			// frmWansikcam.getContentPane().add(Pn);
			// Pn.add(ImageLabel, BorderLayout.CENTER);
			// ImageLabel.setLocation(icon, 10);

			// ImageLabel.setIcon(icon);
			// label = new JLabel(icon, JLabel.CENTER);
			// ImageLabel.add(label);

		}
	}
}
