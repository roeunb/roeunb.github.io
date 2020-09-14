import java.awt.*; // 컴포넌트, 컨테이너, 메뉴 사용하기 위해
import java.awt.event.*; // 이벤트 처리를 위해

public class Test3 extends Frame {
	// 5개의 멤버 변수(인스턴스 변수)
	Label lid, lpwd;
	TextField tfId, tfPwd;
	Button ok;
	
	Test3(String title) { // 매개변수 있는 생성자
		super(title); // Frame(String);
		
		lid = new Label("ID : ", Label.RIGHT); // 오른쪽 정렬
		lpwd = new Label("Password : ", Label.RIGHT);
		tfId = new TextField(10);
		tfPwd = new TextField(10);
		tfPwd.setEchoChar('●'); // 비밀번호 보호하기 위해서 
		ok = new Button("OK");
		
 		// 이벤트 처리 부분
		//2. 이벤트 리스너(감지기)
		tfId.addActionListener(new EventLogin());
		tfPwd.addActionListener(new EventLogin());
		ok.addActionListener(new EventLogin());
		
		// 프레임 닫기 버튼 누르면 종료하는 부분!
		addWindowListener(new WindowAdapter() {
		public void windowClosing(WindowEvent we) {
			System.out.println("종료합니다.");
			System.exit(0); // 프로그램 종료
		} 
	});
		
		this.setBounds(500, 500, 700, 150);
		setLayout(new FlowLayout()); // 프레임에 컴포넌트 붙이면 가운데 정렬
		add(lid); add(tfId); add(lpwd); add(tfPwd); add(ok); // 프레임에 컴포넌트 붙이기
		this.setVisible(true); // 프레임 보이기

	}
	

	// 로그인 이벤트 처리기(Test3 클래스 내부에 작성한 내부클래스로 사용)
	class EventLogin implements ActionListener { 
		public void actionPerformed(ActionEvent e){
			String id = tfId.getText();//입력한 id 문자열을 가지고 와서 id에 대입
			String password =tfPwd.getText();//입력한password 문자열을 가지고 와서 id에 대입
				
		//String 클래스에서 equal()메소드는 오버라이딩된 것으로 문자열과 문자열 비교!
		//id가 "admin"과 같지 않으면 참!
		if(!(id.equals("admin") || id.equals("admin2"))){
			System.out.println("입력하신 ID가 유효하지 않습니다. 다시 입력하세요.");
			tfId.requestFocus();//id 다시입력할 수있도록tfID로 포커스 줌
			tfId.selectAll();//전체 선택하기 (하이라이트)
			tfId.setText("");//내용지우기
		}
		else if(!password.equals("admin")){
			System.out.println("입력하신 password가 유효하지 않습니다. 다시 입력하세요.");
			tfId.requestFocus();//id 다시입력할 수있도록tfID로 포커스 줌
			tfId.selectAll();//전체 선택하기 (하이라이트)
			tfId.setText("");//내용지우기
		} else {
			System.out.println(id + "님 , 성공적으로 로그인되었습니다.");
			}
	}
}
	
	public static void main(String[] args) {
		Test3 t = new Test3("Login"); // 객체 t 생성
	}
}
