import java.awt.*;
import java.awt.event.*;

public class Test10 extends Frame implements MouseMotionListener {
	int x, y; // 멤버변수는 초기화 하지 않으면 기본값 설정
	
	Test10(String title) {
		super(title);
		
		// 마우스 포인터 움직이면 감지기에서 이벤트 처리기로 보냄!
		addMouseMotionListener(this);	
		
		// 프레임 닫기 버튼 누르면 이벤트 처리
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0); // 프로그램 종료
			}
		});

		// 프레임 설정
		setBounds(500, 500, 700, 700);
		setVisible(true);
	}

	// paint()메소드 자동 호출 시기
	// 1. 처음 화면이 보여질 때
	// 2. 다른 화면에 가려졌다가 다시 보여질 때
	// 3. 최소화됐다가 다시 보여질 때
	public void paint(Graphics g) { // paint() 오버라이딩
		g.drawString("마우스를 움직여보세요.", 50, 100);
		g.drawString("*", x, y);
	}
	
	public void update(Graphics g) {
		paint(g); // 원래 update의 경우 화면을 지우고 paint()호출하는데 오버라이딩 하여 화면지우지 않고 paint()호출하게 함!
	}

	public void mouseDragged(MouseEvent e) {}
	public void mouseMoved(MouseEvent e) {
		x = e.getX(); 
		y = e.getY();
		repaint(); // repaint() -> update() -> paint()
	}

	public static void main(String[] args) {
		Test10 t = new Test10("Graphics Test");
	}
}

