import java.awt.*; //컴포넌트, 컨테이너, 메뉴사용하기 위해
import java.awt.event.*; //이벤트 처리

public class Test4 extends Frame{
	Label location;
	Font f1 = new Font("Serif", Font.BOLD, 25);
	
	
	Test4(String title){
		super(title);
		
		//레이블 설정부분
		location = new Label("Mouse Pointer Location : ");
		location.setBounds(20, 80, 430, 55);
		location.setBackground(Color.yellow);
		location.setFont(f1);
		
		//이벤트 처리 부분
		this.addMouseMotionListener(new EventMouse());
		
		//프레임 설정 부분
		this.setBounds(800,500,300,200);//프레임 시작 위치, 크기
		this.setLayout(null); //프레임 레이아웃 사용안함(좌표사용)
		this.add(location); //프레임에 label 붙이기
		this.setVisible(true);
	}
	
	class EventMouse extends MouseMotionAdapter {
		public void mouseDragged(MouseEvent e) {}
		public void mouseMoved (MouseEvent e) {
			location.setText("Mouse Pointer Location : (" + e.getX() +","+ e.getY()+")");
			location.setBackground(Color.orange);
		}
		
	}
	
	public static void main(String[] args) {
		Test4 t = new Test4("Mouse Event Test");
	}	
}