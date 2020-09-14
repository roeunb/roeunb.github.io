import java.awt.*;
import java.awt.event.*;

public class Test9 extends Frame  {
	Panel slide, buttons;
	Panel p1, p2, p3, p4, p5;
	Button first, prev, next, last;

	CardLayout card = new CardLayout();
	
	Test9(String title) {
		super(title);

		slide = new Panel();
		buttons = new Panel();
		slide.setLayout(card);
		
		p1 = new Panel();
		p2 = new Panel();
		p3 = new Panel();
		p4 = new Panel();
		p5 = new Panel();
		
		p1.setBackground(Color.gray);
		p2.setBackground(Color.orange);
		p3.setBackground(Color.blue);
		p4.setBackground(Color.cyan);
		p5.setBackground(Color.pink);
		
		p1.add(new Label("1page", Label.CENTER));
		p2.add(new Label("2page", Label.CENTER));
		p3.add(new Label("3page", Label.CENTER));
		p4.add(new Label("4page", Label.CENTER));
		p5.add(new Label("5page", Label.CENTER));
		
		slide.add(p1, "1"); // slide에 p1 붙이는데 "1"이라는 이름을 부여함!
		slide.add(p2, "2");
		slide.add(p3, "3");
		slide.add(p4, "4");
		slide.add(p5, "5");
		
		
		first = new Button("<<");
		prev = new Button("<");
		next = new Button(">");
		last = new Button(">>");
		
		// 패널 buttons(FlowLayout, 가운데정렬) 에 버튼 붙이기
		buttons.add(first);
		buttons.add(prev);
		buttons.add(next);
		buttons.add(last);

		first.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				card.first(slide); // slide의 처음 패널을 보이기!
			}
		});
		
		prev.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				card.previous(slide); // slide의 이전 패널을 보이기!
			}
		});
		
		next.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				card.next(slide); // slide의 다음 패널을 보이기!
			}
		});
		
		last.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				card.last(slide); // slide의 마지막 패널을 보이기!
			}
		});
		
		// 프레임(보더레이아웃)에 컴포넌트 붙이기
		add("Center", slide); // Center에 패널 slide 붙이기
		add("South", buttons); // South에 패널 buttons 붙이기
		
		setBounds(500, 500, 700, 700);
		setVisible(true);
		
		card.show(slide, "1"); // "1"이라는 이름을 갖는 카드를 보여주면서 시작!
		
	}


	public static void main(String[] args) {
		Test9 t = new Test9("CardLayout Test");
	}
}
