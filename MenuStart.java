import java.awt.*;//컴포넌트 사용하기 위해 
import java.awt.event.*; //이벤트 처리 위해
import javax.swing.*; //swing 사용하기 위해

public class MenuStart extends Frame {
	
	MenuStart(String title){
		super(title);
	
		this.setIconImage(new ImageIcon("icon.jpg").getImage());
		
		//프레임 중앙에 위치시키기
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();//화면의 너비와 높이를 구함
		setBounds(screenSize.width/2-300,screenSize.height/2-250, 700, 700);
		
		//메뉴 부분
		MenuBar mb = new MenuBar();
		
		Menu m1 = new Menu("파일");
		MenuItem mi1 = new MenuItem("회원가입", new MenuShortcut('J', true)); //단축키 설정 Ctrl + shift + J
		MenuItem mi2 = new MenuItem("종료", new MenuShortcut('E'));//단축기 설정 Ctrl + E (true가 있으면 shift)s
		
		mi2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);//프로그램 강제 종료
			}
			
		});
		
		m1.add(mi1);
		m1.addSeparator();//구분선 추가
		m1.add(mi2);
		
		//메뉴 이벤트 부분
		Menu m2 = new Menu("이벤트처리");
		MenuItem mi3 = new MenuItem("커피자판기");
		
		mi3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//커피 자판기 메뉴를 누르면 커피 자판기 프레임이 보임!
				new Coffee("커피 자판기");
				
			}
			
		});
		
		
		
		m2.add(mi3);
		
		
		//메뉴바에 메뉴 붙이기
		mb.add(m1);
		mb.add(m2);
		
		
		// 프레임 닫기 버튼 누르면 이벤트 처리
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0); // 프로그램 종료
			}
		});

		// 프레임 설정
		this.setMenuBar(mb);//프레임에 메뉴바 붙이기. 
		this.setVisible(true);//프레임 화면에 보이기
	}
	
		
	public static void main(String[] args) {
		MenuStart m = new MenuStart("Java Project");
	}

}
