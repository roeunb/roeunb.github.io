import java.awt.*;
import java.awt.event.*;

public class Test11 extends Frame {
	Image img;
	
	Test11(String title){
		super(title);
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		img = tk.getImage("java.png");
		
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
		
		//화면에 프레임 보여지면서 자동으로 paint()호출
		public void paint(Graphics g) { //오버라이딩
			int imgWidth = img.getWidth(this); // img 너비를 구해서 imgwidth에 대입
			int imgHegiht = img.getHeight(this);
			
			if(img == null) {
				return;
			}
			
			g.drawImage(img, 100, 100, this); //this(프레임)에 img를 (100,100)에 보이기
		}
		
	
	
	public static void main(String[] args) {
		Test11 t = new Test11("프레임에 그림붙이기");

	}

}
