import java.awt.*; // 컴포넌트, 컨테이너, 메뉴 사용하기 위해
import java.awt.event.*; // 이벤트 처리를 위해

// 프레임(윈도우)의 x(닫기)버튼을 누르면 이벤트 처리를 위해 EventA 클래스 정의
// windowClosing()을 구현하기 위해서 인터페이스인 WindowListener를 구현(implements)해야 함!
// 인터페이스 내에 있는 모든 추상메소드를 구현해야 함!
/*
class EventA implements WindowListener { // 3. 이벤트 처리기
	public void windowActivated(WindowEvent arg0) {}
	public void windowClosed(WindowEvent arg0) {}
	public void windowClosing(WindowEvent arg0) {
		System.out.println("종료합니다.");
		arg0.getWindow().setVisible(false); // 화면에서 숨겨짐
		arg0.getWindow().dispose(); // 메모리에서 제거
		System.exit(0); // 프로그램 종료
	}
	public void windowDeactivated(WindowEvent arg0) {}
	public void windowDeiconified(WindowEvent arg0) {}
	public void windowIconified(WindowEvent arg0) {}
	public void windowOpened(WindowEvent arg0) {} 
}*/


// WindowAdapter 클래스는 인터페이스 WindowListener의 추상메소드를 모두 구현해놓은 클래스임!
class EventA extends WindowAdapter {
	public void windowClosing(WindowEvent arg0) { // 오버라이딩
		System.out.println("WindowAdapter 클래스 상속받은 EventA에서 종료합니다.");
		System.exit(0); // 프로그램 종료
	} 
}


// 확인 버튼을 누르면 이벤트 처리해 주는 부분~ 
// 3. 이벤트 처리기
class EventB implements ActionListener {
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("확인 버튼을 눌렀습니다.");
	}
}

public class Test1 {
	public static void main(String[] args) {
		Frame f = new Frame("이벤트 처리 연습"); // 1. 이벤트 소스(프레임의 닫기 버튼 누를 때)
		f.setBounds(500, 500, 700, 700);
		f.setBackground(new Color(177,188,199));
		f.setLayout(null); // 프레임 레이아웃 사용 안함(직접 좌표 사용)
		f.addWindowListener(new EventA()); // 2. 이벤트 감지기(리스너) 달기
		
		Button ok = new Button("확인"); // 1. 이벤트 소스
		ok.setBounds(100, 100, 200, 200);
		ok.setBackground(new Color(123,200,100));
		ok.addActionListener(new EventB()); // 2. 이벤트 감지기(리스너)

		Button ok2 = new Button("확인2"); // 1. 이벤트 소스
		ok2.setBounds(350, 100, 200, 200);
		ok2.setBackground(new Color(223,100,200));
		ok2.addActionListener(new ActionListener() { // 익명클래스 사용한 이벤트 처리(클래스 정의하지 않고 바로 사용하고 끝)
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("확인2 버튼을 눌렀습니다.");
			}
		}); // 2. 이벤트 감지기(리스너)

		
		// 프레임에 컴포넌트 붙이기
		f.add(ok); 
		f.add(ok2);
			
		f.setVisible(true);
	}
}




