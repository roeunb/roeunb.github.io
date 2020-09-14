import java.awt.*;
import java.awt.event.*;

public class Test8 extends Frame {
	// 멤버변수 선언
	Label blood, result;
	Panel p1, p2;
	CheckboxGroup group;
	Checkbox cb1, cb2, cb3, cb4;
	Button ok;

	Font f1 = new Font("Serif", Font.BOLD, 32);
	String str = null;
	
	Test8(String title) {
		super(title);
		
		p1 = new Panel();
		// 패널 p1은 기본 레이아웃인 FlowLayout사용

		p2 = new Panel();
		p2.setLayout(null);
		// 패널 p2는 레이아웃 사용안하고 좌표로 설정
		
		blood = new Label("혈액형 선택", Label.CENTER);
		blood.setFont(f1);
		
		group = new CheckboxGroup(); // 그룹으로 지정하여 체크박스를 라디오버튼으로 변경!(4지선다)
		cb1 = new Checkbox("A형", group, false);
		cb2 = new Checkbox("B형", group, false);
		cb3 = new Checkbox("AB형", group, false);
		cb4 = new Checkbox("O형", group, false);
		
		cb1.setFont(f1);
		cb2.setFont(f1);
		cb3.setFont(f1);
		cb4.setFont(f1);
		
		ok = new Button("확인");
		ok.setFont(f1);
		ok.setBounds(50, 20, 150, 60);
		
		result = new Label("", Label.CENTER); // 처음에는 문자열 없는 상태로 시작!
		result.setBackground(Color.black);
		result.setForeground(Color.yellow);
		result.setFont(f1);
		result.setBounds(250, 20, 350, 60);
		
		// 패널에 컴포넌트 붙이기
		p1.add(cb1); p1.add(cb2); p1.add(cb3); p1.add(cb4);  
		p2.add(ok); p2.add(result);
		
		// 프레임에 컴포넌트 붙이기
		add(blood); add(p1); add(p2);
		
		
		// 이벤트 감지기(리스너) 부분
		cb1.addItemListener(new Checkbox_Event());
		cb2.addItemListener(new Checkbox_Event());
		cb3.addItemListener(new Checkbox_Event());
		cb4.addItemListener(new Checkbox_Event());
		
		ok.addActionListener(new Button_Event());
		
		
		// 프레임 닫기 버튼 누르면 이벤트 처리
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.out.println("종료합니다.");
				System.exit(0); // 프로그램 종료
			}
		});

		// 프레임 설정 부분
		setLayout(new GridLayout(3,1)); // 3행 1열로 구성된 레이아웃!
		setBounds(500, 500, 700, 400);
		setVisible(true); // 프레임 화면에 보이기
	}
	
	class Checkbox_Event implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			Checkbox cb = (Checkbox)e.getSource(); 
			
			str = cb.getLabel();
		}
	}
	
	class Button_Event implements ActionListener {	
		public void actionPerformed(ActionEvent e) {
			if(str == null) {
				result.setText("혈액형을 선택!");
			} else {			
				result.setText(str + "이군요~!!");
			}
		}
	}
	
	public static void main(String[] args) {
		Test8 t = new Test8("혈액형 선택 프로그램");
	}

}
