import java.awt.*; // 컴포넌트, 컨테이너, 메뉴 사용하기 위해
import java.awt.event.*; // 이벤트 처리를 위해

public class Login extends Frame {
	// 5개의 멤버 변수(인스턴스 변수)
	Label lid, lpwd;
	TextField tfId, tfPwd;
	Button ok; // 1. 이벤트 소스(대상)
	Frame f = this;
	
	Login(String title) { // 매개변수 있는 생성자
		super(title); // Frame(String);
		
		lid = new Label("ID : ", Label.RIGHT); // 오른쪽 정렬
		lpwd = new Label("Password : ", Label.RIGHT);
		tfId = new TextField(10);
		tfPwd = new TextField(10);
		tfPwd.setEchoChar('●'); // 비밀번호 보호하기 위해서 
		ok = new Button("OK");
		
		
		// 이벤트 처리 부분
		// 2. 이벤트 리스너(감지기)
		tfId.addActionListener(new EventLogin());
		tfPwd.addActionListener(new EventLogin());
		ok.addActionListener(new EventLogin());
		
		
		// 프레임 닫기 버튼 누르면 종료하는 부분!
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				dispose();
			} 
		});
		
		
		// 프레임 중앙에 위치시키기
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize(); // 화면의 너비와 높이를 구함
		setBounds(screenSize.width/2-350, screenSize.height/2-75, 700, 150);

		setLayout(new FlowLayout()); // 프레임에 컴포넌트 붙이면 가운데 정렬
		add(lid); add(tfId); add(lpwd); add(tfPwd); add(ok); // 프레임에 컴포넌트 붙이기
		this.setVisible(true); // 프레임 보이기
	}

	// 로그인 이벤트 처리기(Test3 클래스 내부에 작성한 내부클래스로 사용)
	class EventLogin implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String id = tfId.getText(); // 입력한 id 문자열을 가지고와서 id에 대입
			String password = tfPwd.getText(); // 입력한 password 문자열을 가지고와서 id에 대입
			
			
			if(id.equals("admin") && password.equals("admin")) {
				Msg m = new Msg(f, id + "님, 성공적으로 로그인 되었습니다.");
				f.setVisible(false);
				f.dispose();
			} else {
				Msg m = new Msg(f, "ID/PASSWORD가 틀렸습니다.");
				tfId.setText(""); // id 내용 지우기
				tfPwd.setText(""); // password 내용 지우기
				tfId.requestFocus(); // id 다시 입력할 수 있도록 tfId로 포커스 줌!
			}
			

			// String 클래스에서 equals()메소드는 오버라이딩된것으로 문자열과 문자열 비교!
			// id가 "admin"와 같지 않으면 참!
			/*
			if(!(id.equals("admin") || id.equals("admin2"))) {
				System.out.println("입력하신 ID가 유효하지 않습니다. 다시 입력하세요.");
				tfId.requestFocus(); // id 다시 입력할 수 있도록 tfId로 포커스 줌!
				tfId.selectAll(); // 전체 선택하기(하이라이터)
				tfId.setText(""); // 내용 지우기
			} else if(!password.equals("admin")) {
				System.out.println("입력하신 password가 유효하지 않습니다. 다시 입력하세요.");
				tfPwd.requestFocus(); // password 다시 입력할 수 있도록 tfPwd로 포커스 줌!
				tfPwd.selectAll(); // 전체 선택하기(하이라이터)
				tfPwd.setText(""); // 내용 지우기
			} else {
				Msg m = new Msg(f, id + "님, 성공적으로 로그인 되었습니다.");
				
				//System.out.println(id + "님, 성공적으로 로그인 되었습니다.");
			}
			*/
		} 
	}

}










