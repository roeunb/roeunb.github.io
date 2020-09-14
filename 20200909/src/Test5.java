import java.awt.*; // 컴포넌트, 컨테이너, 메뉴 사용하기 위해
import java.awt.event.*; // 이벤트 처리를 위해

public class Test5 extends Frame{
	TextArea ta;
	TextField tf;
	
	Test5(String title){
		super(title);
	
		ta = new TextArea();
		tf = new TextField();
		
		ta.setBackground(Color.orange);
		tf.setBackground(Color.pink);
		
		add("Center", ta); //add(BorderLayout.CENTER, ta); 이렇게 써도 된다
		add(tf, BorderLayout.SOUTH);
		
		//TextField tf에 문자열 입력 후 엔터시 이벤트 발생 지점
		tf.addActionListener(new ChatEvent());
		
		// 프레임 닫기 버튼 누르면 종료하는 부분!
		addWindowListener(new WindowAdapter() {
		public void windowClosing(WindowEvent we) {
			System.out.println("종료합니다.");
			System.exit(0); // 프로그램 종료
			} 
		});
	
		//프레임 설정 부분
		this.setBounds(800,500,300,200);//프레임 시작 위치, 크기
		this.setVisible(true); //프레임 화면에 보이기
	}

	//내부 클래스로 이벤트 처리
	class ChatEvent implements ActionListener{
		public void actionPerformed(ActionEvent e){
			ta.append(tf.getText()+"\n");
			tf.setText("");
			tf.requestFocus();
		}
	}

	public static void main(String[] args) {
		Test5 t = new Test5("TextComponent Event Test");
	}
}


