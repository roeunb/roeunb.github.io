import java.awt.*;
import java.awt.event.*; // 이벤트 처리를 위해

public class MusicBox extends Frame {
	String str1, str2;
	Label p1_name, p1_comment, p1_result;
	Panel p1;
	Button b1, b2;
	Canvas cvs0;
	TextField txt1;
	
	Image img0, img = null;
	
	// 폰트 객체 추가
		Font f1 = new Font("Serif", Font.BOLD, 20);
		Font f2 = new Font("Serif", Font.BOLD, 20);
		
	
	MusicBox(String title){
		super(title);
		
		p1 = new Panel();
		
		p1.setBackground(Color.black);
		p1.setLayout(null);	
		 
		 Toolkit tk = Toolkit.getDefaultToolkit();
			img0 = tk.getImage(""); 
			
			p1_comment = new Label("♬당신에게 어울리는 음악 추천♪",Label.CENTER);
			p1_name = new Label("이름: ");
		    p1_result = new Label("이름을 입력하세요.", Label.CENTER);
		    txt1 = new TextField(5);
			b1 = new Button("결과확인");
			b2 = new Button("입력");
			 
			
			 
			 cvs0 = new Canvas() {
				public void paint(Graphics g) {
					g.drawImage(img0, 50, 220, this);
					
				}
			};
			
						 
			 cvs0.setSize(50, 50);
			 cvs0.repaint();
		    
			 p1_comment.setBounds(140, 70, 300, 30);
			 p1_comment.setFont(f1);
			 p1_comment.setForeground(Color.darkGray);
			 p1_comment.setBackground(Color.orange);
			
			 p1_name.setBounds(150, 120, 40, 30);
			 			 
			 txt1.setBounds(200, 120, 130,30);
			 
			 b2.setBounds(330, 120, 50, 30);
			 b1.setBounds(380, 120, 50, 30);
			 p1_result.setBounds(50, 180, 500, 50);
			
		  
		 // 버튼 이벤트 리스너(감지기) 달기
			b1.addActionListener(new EventResult());
			b2.addActionListener(new EventResult2());
			
		// 패널 p1에 컴포넌트 붙이기                     
		p1.add(p1_comment);p1.add(p1_name);
		p1.add(txt1); p1.add(b1); p1.add(b2);
		p1.add(p1_result); p1.add(cvs0);
	    
		
		add(p1);add(p1_comment);add(p1_name);
		add(txt1); add(b1); add(b2);
		add(p1_result); add(cvs0);
		
		
		// 프레임 닫기 버튼 누르면 이벤트 처리
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose(); }
		});
		
		// 프레임 중앙에 위치시키기
		//Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize(); // 화면의 너비와 높이를 구함
		setBounds(screenSize.width/2-450, screenSize.height/2-420, 600, 840);
				setVisible(true);
	}

		// 이미지 변경 버튼 이벤트 처리기
		class EventResult implements ActionListener {	
			public void actionPerformed(ActionEvent e) {
				String imgArr[] = {"images/img1.jpg", "images/img2.jpg", "images/img3.jpg", "images/img4.jpg", "images/img5.jpg", "images/img6.jpg","images/img7.jpg"};
				int random_str;
			
				random_str = (int)(Math.random()*7); 
			
				img0 = Toolkit.getDefaultToolkit().getImage(imgArr[random_str]); // 버튼 누를때마다 img0 이미지 변경
			
				cvs0.repaint(); // cvs0 지웠다가 다시 그리기!
			}
		}
	
		class EventResult2 implements ActionListener {	
			public void actionPerformed(ActionEvent e) {
						
				str1 = txt1.getText();
			
				p1_result.setText( "▼" + str1 + "님에게 어울리는 음악은!!▼");
				p1_result.setFont(f2);
				p1_result.setBounds(50, 180, 500, 50);
			
				
				txt1.setText("");
				txt1.requestFocus(); // 키 입력 부분에 포커스 이동
			
			}
		}
}
	

