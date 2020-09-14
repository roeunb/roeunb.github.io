import java.awt.*; // 컴포넌트, 컨테이너, 메뉴 사용하기 위해
import java.awt.event.*; // 이벤트 처리를 위해

public class Test7 extends Frame {
	//멤버면수 초기화는 생성자에서 함!
	Label q1, q2, score;
	Checkbox q1cb1, q1cb2, q1cb3, q1cb4;
	Checkbox q2cb1, q2cb2, q2cb3, q2cb4;
	CheckboxGroup group;
	Button ok;
	
	Test7(String title){
		super(title);
		
		q1 = new Label("1. 다음 중 ActionEvent의 actionPerformed 메소드가 호출되는 경우는?(모두고르시오)");
		q1cb1 = new Checkbox("Button을 눌렀을 때");
		q1cb2 = new Checkbox("TextField에서 Enter키를 눌렀을 때");
		q1cb3 = new Checkbox("MEnuItem을 눌렀을 때");
		q1cb4 = new Checkbox("List에서 더블클릭으로 item을 선택했을 때");
		
		q2 = new Label("2. Frame의 기본 LayoutManager는? (하나만 고르시오)");
		group = new CheckboxGroup();
		q2cb1 = new Checkbox("FlowLayout");
		q2cb2 = new Checkbox("GridLayout");
		q2cb3 = new Checkbox("BorderLayout");
		q2cb4 = new Checkbox("CardLaylout");
		
		score = new Label("* 결과: ");
		ok = new Button("이 버튼을 누르시면 결과를 알 수 있습니다.");
		
		
		// 프레임 닫기 버튼 누르면 종료하는 부분!
		addWindowListener(new WindowAdapter() {
		public void windowClosing(WindowEvent we) {
				System.exit(0); // 프로그램 종료
			} 
		});
		
		//프레임에 컴포넌트 붙이기
		add(q1); add(q1cb1); add(q1cb2); add(q1cb3); add(q1cb4);
		add(new Label(""));
		add(q2); add(q2cb1); add(q2cb2); add(q2cb3); add(q2cb4);
		add(score); add(ok);
		
		//버튼을 클릭했을 때 이벤트 처리 부분
		ok.addActionListener(new EventCheck2());
		
		
		//프레임 설정 부분
		this.setLayout(new GridLayout(13,1));//13행 1열
		this.setBounds(500,500,700,500);//프레임 시작 위치, 크기
		this.setVisible(true);
	}	
	
	
		class EventCheck2 implements ActionListener {
			public void actionPerformed(ActionEvent e){
				double total = 0.0;
				
				if(q1cb1.getState()) {
					total +=12.5;
				}
				if(q1cb2.getState()) {
					total +=12.5;
				}
				if(q1cb3.getState()) {
					total +=12.5;
				}
				if(q1cb4.getState()) {
					total +=12.5;
				}
				//2번문제 정답 3번에 체크할 경우
				if(q2cb3.getState()) {
					total +=12.5;
				}
				
				score.setText("* 결과: 당신의 점수는 " + total + "점입니다.");
				
			}
		}
	
		public static void main(String[] args) {
		Test7 t = new Test7("Checkbox Event Test");
	}

}

