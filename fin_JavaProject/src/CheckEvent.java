import java.awt.*;
import java.awt.event.*; // �̺�Ʈ ó���� ����

public class CheckEvent extends Frame {
	// ������� �ʱ�ȭ�� �����ڿ��� ��!
	Label q1, q2, score;
	Checkbox q1cb1, q1cb2, q1cb3, q1cb4;
	Checkbox q2cb1, q2cb2, q2cb3, q2cb4;
	CheckboxGroup group;
	Button ok;
	
	CheckEvent(String title) {
		super(title);	
		
		q1 = new Label("1. ���� �� ActionEvent�� actionPerformed �޼ҵ尡 ȣ��Ǵ� ����?(��� ������)");
		q1cb1 = new Checkbox("Button�� ������ ��");
		q1cb2 = new Checkbox("TextField���� EnterŰ�� ������ ��");
		q1cb3 = new Checkbox("MenuItem�� ������ ��");
		q1cb4 = new Checkbox("List���� ����Ŭ������ item�� �������� ��");
		
		q2 = new Label("2. Frame�� �⺻ LayoutManager��?(�ϳ��� ������)");
		group = new CheckboxGroup();
		q2cb1 = new Checkbox("FlowLayout", group, false);
		q2cb2 = new Checkbox("GridLayout", group, false);
		q2cb3 = new Checkbox("BorderLayout", group, false);
		q2cb4 = new Checkbox("CardLayout", group, false);
		
		score = new Label("�� ��� : ");
		ok = new Button("�� ��ư�� �����ø� ����� �� �� �ֽ��ϴ�.");
		
		
		// ������ �ݱ� ��ư ������ �����ϴ� �κ�!
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				dispose();
			} 
		});	
	
		// �����ӿ� ������Ʈ ���̱�
		add(q1); add(q1cb1); add(q1cb2); add(q1cb3); add(q1cb4);
		add(new Label(""));
		add(q2); add(q2cb1); add(q2cb2); add(q2cb3); add(q2cb4);
		add(score); add(ok);
		
		
		// ��ư�� Ŭ������ �� �̺�Ʈ ó�� �κ�
		ok.addActionListener(new EventCheck2());
		
		
		// ������ ���� �κ�
		this.setLayout(new GridLayout(13,1)); // 13�� 1��
		
		
		// ������ �߾ӿ� ��ġ��Ű��
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize(); // ȭ���� �ʺ�� ���̸� ����
		setBounds(screenSize.width/2-350, screenSize.height/2-250, 700, 500);

		setVisible(true);
	}
	
	class EventCheck2 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			double total = 0.0;
			
			if(q1cb1.getState()) {
				total += 12.5;
			}
			if(q1cb2.getState()) {
				total += 12.5;
			}
			if(q1cb3.getState()) {
				total += 12.5;
			}
			if(q1cb4.getState()) {
				total += 12.5;
			}
			
			if(q2cb3.getState()) {
				total += 50.0;
			}
			score.setText("�� ��� : ����� ������ " + total + "�� �Դϴ�.");
		}
	}
	
}




