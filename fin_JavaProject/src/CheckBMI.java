import java.awt.*;
import java.awt.event.*; // 이벤트 처리를 위해

public class CheckBMI extends Frame {
	String str1, str2; // 입력한 키, 몸무게 저장할 변수
	
	Panel p0, p1, p2, p3;
	
	// 패널 0에서 사용할 멤버 변수 선언
	Canvas cvs0;
	Label p0_str1, p0_str2, p0_str3;
	Button p0_b1;
	
	// 패널 1에서 사용할 멤버 변수 선언
	Label p1_cm1, p1_kg1, p1_cm2, p1_kg2;
	TextField p1_tf1, p1_tf2;
	Button result, reset;
	
	// 패널 2에서 사용할 멤버 변수 선언
	Label p2_l1, p2_l2;
	
	// 패널 3에서 사용할 멤버 변수 선언
	Image img0, img = null;

	// 폰트 객체 추가
	Font f1 = new Font("Serif", Font.BOLD, 27);
	Font f2 = new Font("Serif", Font.BOLD + Font.ITALIC, 22);
	Font f3 = new Font("Serif", Font.BOLD, 20);
	
	CheckBMI(String title) {
		super(title);
		
		p0 = new Panel();
		p1 = new Panel();
		p2 = new Panel();
		p3 = new Panel();
		
		p0.setBackground(Color.white);
		p1.setBackground(new Color(210,200,175));
		p2.setBackground(new Color(220,230,210));
		p3.setBackground(Color.white);
		
		
		/*************** 패널 p0 부분 ****************/
		p0.setLayout(null);
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		img0 = tk.getImage("images/img_bmi0.jpg"); 

		p0_b1 = new Button("이미지 변경");
		p0_b1.setBounds(600, 50, 210, 100);
		p0_b1.setFont(f3);
		p0_b1.setBackground(new Color(220, 200, 180));
		
	    cvs0 = new Canvas() {
			public void paint(Graphics g) {
				g.drawImage(img0, 50, 0, this);
			}
		};
		
	    cvs0.setSize(550,200);
	    cvs0.repaint();
		
	    // 이미지 변경 버튼 이벤트 리스너(감지기) 달기
	    p0_b1.addActionListener(new EventImageChange());

	    
	    p0.add(cvs0);
	    p0.add(p0_b1);
		
		
		
		/*************** 패널 p1 부분 ****************/
		p1.setLayout(null); // 패널 p1은 레이아웃 사용 안함
		
		p1_cm1 = new Label("신장", Label.RIGHT);
		p1_cm2 = new Label("cm");
		p1_kg1 = new Label("몸무게", Label.RIGHT);
		p1_kg2 = new Label("kg");
		
		p1_tf1 = new TextField(5);
		p1_tf2 = new TextField(5);
		
		result = new Button("계산");
		reset = new Button("초기화");
		
		p1_cm1.setBounds(70, 35, 100, 35);
		p1_cm1.setFont(f1);
		p1_cm1.setForeground(new Color(50,30,50));
		
		p1_tf1.setBounds(200, 35, 150, 35);
		p1_tf1.setFont(f1);
		p1_tf1.setForeground(new Color(50,30,50));
		
		p1_kg1.setBounds(70, 110, 100, 35);
		p1_kg1.setFont(f1);
		p1_kg1.setForeground(new Color(50,30,50));
		
		p1_tf2.setBounds(200, 110, 150, 35);
		p1_tf2.setFont(f1);
		p1_tf2.setForeground(new Color(50,30,50));
		
		p1_cm2.setBounds(370, 35, 100, 35);
		p1_cm2.setFont(f1);
		p1_cm2.setForeground(new Color(50,30,50));
		
		p1_kg2.setBounds(370, 110, 100, 35);
		p1_kg2.setFont(f1);
		p1_kg2.setForeground(new Color(50,30,50));
		
		result.setBounds(500, 35, 150, 110);
		result.setFont(f1);
		result.setForeground(new Color(50,30,50));
				
		reset.setBounds(680, 35, 150, 110);
		reset.setFont(f1);
		reset.setForeground(new Color(50,30,50));		
		
		
		// 계산, 초기화 버튼 이벤트 리스너(감지기) 달기
		result.addActionListener(new EventResult());
		reset.addActionListener(new EventReset());
	
		
		// 패널 p1에 컴포넌트 붙이기
		p1.add(p1_cm1); p1.add(p1_tf1); p1.add(p1_cm2);
		p1.add(p1_kg1); p1.add(p1_tf2); p1.add(p1_kg2);
		p1.add(result); p1.add(reset);
		
		
		/*************** 패널 p2 부분 ****************/
		
		p2.setLayout(new GridLayout(2,1)); // 패널 p2는 2행1열로 사용

		p2_l1 = new Label("계산 버튼을 눌러주세요.", Label.CENTER);
		p2_l2 = new Label("체질량지수는 자신의 몸무게(kg)를 키의 제곱(m)으로 나눈 값입니다.", Label.CENTER); 
		
		p2_l1.setFont(f1);	
		p2_l2.setFont(f2);
		p2_l2.setForeground(Color.blue);
		
		// 패널 p2에 컴포넌트 붙이기
		p2.add(p2_l1); p2.add(p2_l2);
		
		
		
		
		/*************** 패널 p3 부분 ****************/	
		// Toolkit tk = Toolkit.getDefaultToolkit();
		img = tk.getImage("images/img_bmi.jpg"); 
		
		
	    Canvas cvs = new Canvas() {
			public void paint(Graphics g) {
				g.drawImage(img, 0, 0, this);
			}
		};
		
	    cvs.setSize(800,200);
	    cvs.repaint();
		
	    p3.add(cvs);
		
	    
	    
		// 프레임에 패널 붙이기
	    add(p0); add(p1); add(p2); add(p3);
		
		
		// 프레임 닫기 버튼 누르면 이벤트 처리
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose(); // 커피자판기 프레임만 메모리에서 해제(닫기)
			}
		});
		
		
		// 프레임 설정 부분
		setLayout(new GridLayout(4,1)); // 4행 1열로 구성된 레이아웃!
		
		// 프레임 중앙에 위치시키기
		//Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize(); // 화면의 너비와 높이를 구함
		setBounds(screenSize.width/2-450, screenSize.height/2-420, 900, 840);

		setVisible(true); // 프레임 화면에 보이기
	}
	

	// 이벤트 처리를 위한 내부클래스 작성
	
	
	// 이미지 변경 버튼 이벤트 처리기
	class EventImageChange implements ActionListener {	
		public void actionPerformed(ActionEvent e) {
			String imgArr[] = {"images/img_bmi0.jpg", "images/img_b1.jpg", "images/img_b2.jpg", "images/img_b3.jpg", "images/img_b4.jpg", "images/img_b5.jpg", "images/img_b6.jpg", "images/img_b7.jpg"};
			Color colorArr[] = {Color.pink, Color.cyan, Color.yellow, Color.orange, Color.gray, Color.blue, Color.magenta};
			int random_str, color_cnt;
			
			random_str = (int)(Math.random()*8); // 0~7 사이의 랜덤값 발생
			color_cnt = (int)(Math.random()*7); // 0~6 사이의 랜덤값 발생
			
			img0 = Toolkit.getDefaultToolkit().getImage(imgArr[random_str]); // 버튼 누를때마다 img0 이미지 변경
			p0_b1.setBackground(colorArr[color_cnt]); // 버튼의 배경색 변경
			
		    cvs0.repaint(); // cvs0 지웠다가 다시 그리기!
		}
	}
	
	
	// 계산 버튼 이벤트 처리기
	class EventResult implements ActionListener {	
		public void actionPerformed(ActionEvent e) {
			String str; // 비만도 결과 저장할 변수
			double bmi, h, w; 
			// h: 키, w: 몸무게 (TextField 에서 입력받은 값은 String(문자열)이기 때문에 실수로 변경된 값 저장할 변수)
			
			p2_l2.setFont(f1);
			
			str1 = p1_tf1.getText(); // 키
			str2 = p1_tf2.getText(); // 몸무게
			
			try {
				h = Double.parseDouble(str1); // 키를 문자열로 입력받아 double형으로 변경하여 h에 대입(입력시 실수가 아니면 예외 발생할 수 있음)
				w = Double.parseDouble(str2);
				
				// BMI 지수 계산하기
				// 몸무게 / (키(미터) * 키(미터))
				bmi = w / ((h/100) * (h/100));
				
				if(bmi < 18.5) {
					str = "저체중";
				} else if(bmi < 23) {
					str = "정상";
				} else if(bmi < 25) {
					str = "과제중";
				} else {
					str = "비만";
				}
				
				p2_l1.setForeground(Color.black);
				p2_l1.setText("비만도 결과는 " + str + " 입니다.");
				p2_l2.setText("BMI 지수는 " + String.format("%.2f", bmi));
			} catch(NumberFormatException nfe) {
				p2_l1.setForeground(Color.red);
				p2_l1.setText("키와 몸무게는 숫자(정수,실수) 입력만 가능합니다.");
				p2_l2.setFont(f2);
				p2_l2.setText("★ 다시 입력해주세요. ★");
				
				p1_tf1.setText("");
				p1_tf2.setText("");
				p1_tf1.requestFocus(); // 키 입력 부분에 포커스 이동
			}
		}
	}
	
	// 초기화 버튼 이벤트 처리기
	class EventReset implements ActionListener {	
		public void actionPerformed(ActionEvent e) {
			p2_l1.setText("계산 버튼을 눌러주세요.");
			p2_l2.setFont(f2);
			p2_l2.setText("체질량지수는 자신의 몸무게(kg)를 키의 제곱(m)으로 나눈 값입니다.");
			
			
			p1_tf1.setText("");
			p1_tf2.setText("");
			p1_tf1.requestFocus(); // 키 입력 부분에 포커스 이동
		}
	}

}
