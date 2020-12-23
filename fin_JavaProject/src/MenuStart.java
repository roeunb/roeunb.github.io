import java.awt.*; // 컴포넌트 사용하기 위해
import java.awt.event.*; // 이벤트 처리 위해
import javax.swing.*; // swing 사용하기 위해

public class MenuStart extends Frame {
	
	MenuStart(String title) {
		super(title);
		
		// 프레임 아이콘 이미지 설정
		this.setIconImage(new ImageIcon("images/icon.jpg").getImage());
		
		// 프레임 중앙에 위치시키기
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize(); // 화면의 너비와 높이를 구함
		setBounds(screenSize.width/2-375, screenSize.height/2-250, 750, 500);
			
		MenuBar mb = new MenuBar(); // 메뉴바 객체 생성
		
		// 메뉴 파일 부분
		Menu m1 = new Menu("파일");
		MenuItem mi1 = new MenuItem("회원가입", new MenuShortcut('J', true)); // 단축키 설정 ctrl + shift + 'J'
		MenuItem mi2 = new MenuItem("종료", new MenuShortcut('E')); // 단축키 설정 ctrl + 'E'
		
		mi2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0); // 프로그램 강제 종료
			}
		});

		m1.add(mi1);
		m1.addSeparator(); // 구분선 추가
		m1.add(mi2);
	
		// 메뉴 이벤트 부분
		Menu m2 = new Menu("이벤트 처리 1");
		
		MenuItem mi3 = new MenuItem("커피 자판기");
		mi3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// 커피자판기 메뉴를 누르면 커피자판기 프레임이 보임!
				new Coffee("커피 자판기");
			}
		});

		MenuItem mi4 = new MenuItem("체크박스 이벤트");
		mi4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new CheckEvent("체크박스 이벤트");
			}
		});
		
		MenuItem mi5 = new MenuItem("컬러 이벤트");
		mi5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new ColorEvent("컬러 이벤트");
			}
		});
		
		MenuItem mi9 = new MenuItem("크리스마스");
		mi9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Christmas("크리스마스");
			}
		});
		
		m2.add(mi3);
		m2.add(mi4);
		m2.add(mi5);
		m2.add(mi9);
		
		// 메뉴 이벤트 처리2 부분
		Menu m3 = new Menu("이벤트 처리 2");
		MenuItem mi6 = new MenuItem("CheckBMI");
		mi6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new CheckBMI("CheckBMI");
			}
		});
		
		MenuItem mi7 = new MenuItem("Receipt");
		mi7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Receipt("Receipt");
			}
		});
		
		MenuItem mi10 = new MenuItem("MusicBox");
		mi10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new MusicBox("MusicBox");
			}
		});
		
		m3.add(mi6);
		m3.add(mi7);
		m3.add(mi10);
			
		
		// 메뉴 도움말 부분
		Menu m4 = new Menu("도움말");
		MenuItem mi8 = new MenuItem("프로젝트 설명");
		mi8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Help("프로젝트 설명");
			}
		});
		
		m4.add(mi8);
		
		
		// 메뉴바에 메뉴 붙이기
		mb.add(m1); mb.add(m2); mb.add(m3); mb.add(m4);
		
		// 프레임 닫기 버튼 누르면 이벤트 처리
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0); // 프로그램 종료
			}
		});

		
		// 프레임 설정
		this.setMenuBar(mb); // 프레임에 메뉴바 붙이기
		this.setVisible(true); // 프레임 화면에 보이기
	}
	
	
	public static void main(String[] args) {
		new MenuStart("Java Project");
		// new Login("Login");
		// 프로젝트 test에는 잠시 Login 부분 가려두기
	}
}






