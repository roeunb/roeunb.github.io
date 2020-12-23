import java.awt.*;
import java.awt.event.*; // 이벤트 처리를 위해

public class ColorEvent extends Frame {
	Button b1, b2, b3, b4, r;
	Font f1 = new Font("Serif", Font.BOLD, 32);
	
	ColorEvent(String title) {
		super(title);
		
		b1 = new Button("파랑");
		b2 = new Button("노랑");
		b3 = new Button("주황");
		b4 = new Button("초록");
		r = new Button("랜덤");
		
		
		b1.setBounds(150, 150, 150, 150);
		b2.setBounds(400, 150, 150, 150);
		b3.setBounds(150, 350, 150, 150);
		b4.setBounds(400, 350, 150, 150);
		r.setBounds(150, 550, 400, 150);
		
		
		b1.setFont(f1);
		b2.setFont(f1);
		b3.setFont(f1);
		b4.setFont(f1);
		r.setFont(f1);
		
		b1.setBackground(new Color(64,128,128));
		b2.setBackground(new Color(64,128,128));
		b3.setBackground(new Color(64,128,128));
		b4.setBackground(new Color(64,128,128));
		r.setBackground(new Color(164,228,228));
		
		b1.setForeground(Color.white);
		b2.setForeground(Color.white);
		b3.setForeground(Color.white);
		b4.setForeground(Color.white);
		r.setForeground(Color.BLUE);
		
		// 버튼을 클릭했을 때 이벤트 처리 부분
		b1.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				setBackground(Color.blue);
			}
		});

		b2.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				setBackground(Color.yellow);
			}
		});
		
		b3.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				setBackground(Color.orange);
			}
		});
		
		b4.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				setBackground(Color.green);
			}
		});
		
		r.addActionListener(new EventColor());
		
		// 프레임 닫기 버튼 누르면 이벤트 처리
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose(); 
			}
		});
		
		
		// 프레임에 버튼 붙이기
		add(b1); add(b2); add(b3); add(b4); add(r);
		this.setLayout(null); // 프레임 레이아웃 사용 안함(좌표 사용)
		
		// 프레임 중앙에 위치시키기
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize(); // 화면의 너비와 높이를 구함
		setBounds(screenSize.width/2-350, screenSize.height/2-400, 700, 800);

		setVisible(true); // 프레임 화면에 보이기
	}

	// 이벤트 처리를 위한 내부클래스 작성
	class EventColor implements ActionListener {	
		public void actionPerformed(ActionEvent e) {
			Color color[] = {Color.blue, Color.yellow, Color.orange, Color.green};
			int random = (int)(Math.random()*4); // 0,1,2,3
			
			setBackground(color[random]);
		}
	}

}














