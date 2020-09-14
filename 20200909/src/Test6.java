import java.awt.*; // 컴포넌트, 컨테이너, 메뉴 사용하기 위해
import java.awt.event.*; // 이벤트 처리를 위해

public class Test6 extends Frame {
	CheckboxGroup group;
	Checkbox cb1, cb2, cb3;

	Test6(String title){
		super(title);
		
		group = new CheckboxGroup();
		cb1 = new Checkbox("red", group, true);
		cb2 = new Checkbox("green", group, false);
		cb3 = new Checkbox("blue", group, false);
		
		//프레임에 컴포넌트 붙이기
		add(cb1); add(cb2); add(cb3);
		
		//체크박스 이벤트 처리 부분
		cb1.addItemListener(new CheckEvent());
		cb2.addItemListener(new CheckEvent());
		cb3.addItemListener(new CheckEvent());
		
		// 프레임 닫기 버튼 누르면 종료하는 부분!
		addWindowListener(new WindowAdapter() {
		public void windowClosing(WindowEvent we) {
				System.out.println("종료합니다.");
				System.exit(0); // 프로그램 종료
			} 
		});
		
		//프레임 설정 부분
		this.setBackground(Color.red);
		this.setLayout(new FlowLayout()); //왼->오른, 위->아래, 가운데 정렬이 기본		
		this.setBounds(800,500,300,200);//프레임 시작 위치, 크기
		this.setVisible(true);
	}	
	
	class CheckEvent implements ItemListener {
		public void itemStateChanged(ItemEvent e){
			Checkbox cb = (Checkbox)e.getSource();
			String color = cb.getLabel(); 
	
			if(color.equals("red")){
				setBackground(Color.red);
				cb1.setBackground(Color.red);
				cb2.setBackground(Color.red);
				cb3.setBackground(Color.red);
			}else if(color.equals("green")){
				setBackground(Color.green);
				cb1.setBackground(Color.green);
				cb2.setBackground(Color.green);
				cb3.setBackground(Color.green);
			}else {
				setBackground(Color.blue);
				cb1.setBackground(Color.blue);
				cb2.setBackground(Color.blue);
				cb3.setBackground(Color.blue);
			}
		}
	}
	
	public static void main(String[] args) {
		Test6 t = new Test6("Checkbox Event Test");
	}

}
