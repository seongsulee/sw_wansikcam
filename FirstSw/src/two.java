import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

import javax.swing.event.*;
import javax.swing.filechooser.*;



public class ImSWproject {

	private JFrame frmWansikcam;
	private JTextField RotauserText;
	private JTextField textField;
	private JTextField textField_1;
	public JLabel ImageLabel; // ????? ????? Label
	public JPanel Pn;
	ImageIcon icon; //불러온 사진의 값을 갖는 함수
	
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

		JRadioButton DecoRadio1 = new JRadioButton("액자1");
		DecoRadio1.setFont(new Font("굴림", Font.PLAIN, 12));
		DecoRadio1.setBackground(Color.WHITE);
		DecoRadio1.setBounds(40, 56, 71, 23);
		setpanel2.add(DecoRadio1);

		JRadioButton DecoRadio2 = new JRadioButton("액자2");
		DecoRadio2.setFont(new Font("굴림", Font.PLAIN, 12));
		DecoRadio2.setBackground(Color.WHITE);
		DecoRadio2.setBounds(126, 56, 71, 23);
		setpanel2.add(DecoRadio2);

		JRadioButton DecoRadio3 = new JRadioButton("액자3");
		DecoRadio3.setFont(new Font("굴림", Font.PLAIN, 12));
		DecoRadio3.setBackground(Color.WHITE);
		DecoRadio3.setBounds(212, 56, 71, 23);
		setpanel2.add(DecoRadio3);

		JRadioButton DecoRadio4 = new JRadioButton("액자4");
		DecoRadio4.setBackground(Color.WHITE);
		DecoRadio4.setFont(new Font("굴림", Font.PLAIN, 12));
		DecoRadio4.setBounds(301, 56, 71, 23);
		setpanel2.add(DecoRadio4);

		JButton DecosetBut = new JButton("적용");
		DecosetBut.setFont(new Font("굴림", Font.PLAIN, 12));
		DecosetBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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

		JButton FilterBrackBut = new JButton("흑백");
		FilterBrackBut.setFont(new Font("굴림", Font.PLAIN, 12));
		FilterBrackBut.setBounds(30, 125, 97, 23);
		setpanel1.add(FilterBrackBut);

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
		textField.addKeyListener(new KeyListener()//KeyListener 리스너 구현
         {
             public void keyTyped(KeyEvent e) //Key 이벤트가 발생했을 시
             {  
                 char c = e.getKeyChar();//받아들인 값을 c에 저장
                 if(!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE)|| (c == KeyEvent.VK_ENTER)))
                 {//만약 눌러진 키가 백스페이스, 델리트, 엔터키가 아닐시
                 	JOptionPane.showMessageDialog(null, ""+c+"는 숫자 키가 아닙니다.\n숫자를 입력하세요.", "경고", JOptionPane.ERROR_MESSAGE);// 경고창 발생
                 	e.consume();//눌러진키는 사라지게 설정
                 }
             }
             public void keyPressed(KeyEvent ke) {}
             public void keyReleased(KeyEvent ke) {}
         });
		setpanel1.add(textField);
		
		JLabel SizeYLabel = new JLabel("세로 :");
		SizeYLabel.setFont(new Font("굴림", Font.PLAIN, 12));
		SizeYLabel.setBounds(181, 405, 40, 15);
		setpanel1.add(SizeYLabel);

		textField_1 = new JTextField();
		textField_1.setBounds(225, 404, 80, 16);
		textField_1.setColumns(10);
		
		textField_1.addKeyListener(new KeyListener()//KeyListener 리스너 구현
        {
            public void keyTyped(KeyEvent e) //Key 이벤트가 발생했을 시
            {  
                char c = e.getKeyChar();//받아들인 값을 c에 저장
                if(!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE)|| (c == KeyEvent.VK_ENTER)))
                {//만약 눌러진 키가 백스페이스, 델리트, 엔터키가 아닐시
                	JOptionPane.showMessageDialog(null, ""+c+"는 숫자 키가 아닙니다.\n숫자를 입력하세요.", "경고", JOptionPane.ERROR_MESSAGE);// 경고창 발생
                	e.consume();//눌러진키는 사라지게 설정
                }
            }
            public void keyPressed(KeyEvent ke) {}
            public void keyReleased(KeyEvent ke) {}
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
				} 
				else if(str.length() == 0 && str_1.length() == 0) {
					JOptionPane.showMessageDialog(null, "가로값과 세로값을 입력하지 않았습니다.",
							"경고", JOptionPane.WARNING_MESSAGE);
					return;
				}
				else if(str.length() == 0) {
					JOptionPane.showMessageDialog(null, "가로값을 입력하지 않았습니다.",
							"경고", JOptionPane.WARNING_MESSAGE);
					return;
				}
				else if(str_1.length() == 0) {
					JOptionPane.showMessageDialog(null, "세로값을 입력하지 않았습니다.",
							"경고", JOptionPane.WARNING_MESSAGE);
					return;
				}
				else if(str.length() != 0 || str_1.length() != 0) {
					int_str = Integer.parseInt(str);
					int_str_1 = Integer.parseInt(str_1);
				}
				if(int_str == 0 || int_str_1 == 0) {
					JOptionPane.showMessageDialog(null, "0값은 입력될 수 없습니다.",
							"경고", JOptionPane.WARNING_MESSAGE);
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
				JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다.", "경고",
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
}
