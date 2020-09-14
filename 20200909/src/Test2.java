// 간단한 거피 자판기 프로그램
// 버튼을 누르면 선택한 제품을 알려주는 프로그램

import java.awt.*; // 컴포넌트, 컨테이너, 메뉴 사용하기 위해
import java.awt.event.*; // 이벤트 처리를 위해

class EventCoffee1 implements ActionListener {
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("아메리카노를 선택하셨습니다.");
	}
}

class EventCoffee2 implements ActionListener {
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("카페라떼를 선택하셨습니다.");
	}
}

public class Test2 {
	public static void main(String[] args) {
		Frame f = new Frame("♡ 간단한 커피 자판기 ♡");
		f.setBounds(500, 500, 750, 500);
		f.setBackground(new Color(224,224,192));
		f.setLayout(null); // 프레임 레이아웃 사용 안함
		
		// 프레임 닫기 버튼 누르면 종료하는 부분!
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.out.println("종료합니다.");
				System.exit(0); // 프로그램 종료
			} 
		});
		
		Font f1 = new Font("Serif", Font.BOLD, 22);
		Font f2 = new Font("Serif", Font.BOLD + Font.ITALIC, 25);
			
		Button coffee1 = new Button("아메리카노");
		Button coffee2 = new Button("카페라뗴");
		Button coffee3 = new Button("카푸치노");
		
		coffee1.addActionListener(new EventCoffee1());
		coffee2.addActionListener(new EventCoffee2());
		coffee3.addActionListener(new ActionListener() { // 익명클래스 사용
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("카푸치노를 선택하셨습니다.");
				coffee3.setBackground(Color.red);
			}
		});
		
		coffee1.setBounds(100, 120, 150, 120);
		coffee1.setBackground(new Color(112,146,190));
		coffee1.setForeground(Color.white);
		coffee1.setFont(f1);
		
		coffee2.setBounds(300, 120, 150, 120);
		coffee2.setBackground(new Color(112,146,190));
		coffee2.setForeground(Color.white);
		coffee2.setFont(f1);
		
		coffee3.setBounds(500, 120, 150, 120);
		coffee3.setBackground(new Color(112,146,190));
		coffee3.setForeground(Color.white);
		coffee3.setFont(f1);

		
		Label result = new Label("♥ 버튼을 누르세요 ♥", Label.CENTER);
		result.setBounds(100, 290, 550, 130);
		result.setBackground(new Color(124,124,92));
		result.setForeground(Color.white);
		result.setFont(f2);
		
		
		// 프레임에 컴포넌트 붙이기
		f.add(coffee1); f.add(coffee2); f.add(coffee3); f.add(result);
		
		f.setVisible(true); // 프레임 화면에 보이기
	}
}
