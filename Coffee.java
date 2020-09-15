import java.awt.*;
import java.awt.event.*; // �̺�Ʈ ó���� ����

public class Coffee extends Frame {
	Panel p1, p2, p3;
	Label coffee, size, result;
	CheckboxGroup group, group2;
	Checkbox coffee1, coffee2, coffee3;
	Checkbox size1, size2, size3;
	Button ok;
	
	static int coffee_total, size_total;
	
	Font f1 = new Font("Serif", Font.BOLD, 32);
	Font f2 = new Font("Serif", Font.BOLD, 20);
	
	Coffee(String title) {
		super(title);
		
		p1 = new Panel(); // �г� �⺻ ���̾ƿ��� �÷ο� ���̾ƿ� ���
		p1.setBackground(new Color(128,68,0));
		p1.setForeground(Color.white);
		p1.setFont(f1);
		
		p2 = new Panel(); // �г� �⺻ ���̾ƿ��� �÷ο� ���̾ƿ� ���
		p2.setBackground(new Color(180,100,100));
		p2.setForeground(Color.white);
		p2.setFont(f1);
		
		p3 = new Panel();
		p3.setLayout(null); // �г� ���̾ƿ� ��� ����(��ǥ ���)
		p3.setBackground(new Color(128,0,0));
		p3.setForeground(Color.white);
		p3.setFont(f1);
		
		
		coffee = new Label("Ŀ�� ����", Label.CENTER);
		coffee.setBackground(new Color(128,68,0));
		coffee.setForeground(Color.yellow);
		coffee.setFont(f1);
		
		group = new CheckboxGroup();
		coffee1 = new Checkbox("�Ƹ޸�ī��(1000��)", group, false);
		coffee2 = new Checkbox("ī���(1500��)", group, false);
		coffee3 = new Checkbox("īǪġ��(2000��)", group, false);
		
		coffee1.setBackground(new Color(128,68,0));
		coffee1.setForeground(Color.white);
		coffee1.setFont(f2);
		coffee2.setBackground(new Color(128,68,0));
		coffee2.setForeground(Color.white);
		coffee2.setFont(f2);
		coffee3.setBackground(new Color(128,68,0));
		coffee3.setForeground(Color.white);
		coffee3.setFont(f2);
		
	
		size = new Label("������ ����", Label.CENTER);
		size.setBackground(new Color(180,100,100));
		size.setForeground(Color.white);
		size.setFont(f1);
		
		group2 = new CheckboxGroup();
		size1 = new Checkbox("����������(+0��)", group2, false);
		size2 = new Checkbox("�߰�������(+500��)", group2, false);
		size3 = new Checkbox("ū������(+1000��)", group2, false);
		
		size1.setBackground(new Color(180,100,100));
		size1.setForeground(Color.white);
		size1.setFont(f2);
		size2.setBackground(new Color(180,100,100));
		size2.setForeground(Color.white);
		size2.setFont(f2);
		size3.setBackground(new Color(180,100,100));
		size3.setForeground(Color.white);
		size3.setFont(f2);
		
		
		ok = new Button("���");
		ok.setBounds(50, 30, 200, 50);
		ok.setBackground(new Color(250,230,210));
		ok.setForeground(new Color(64,0,0));
		
		
		result = new Label("0", Label.CENTER);
		result.setBounds(290, 30, 340, 50);
		result.setBackground(Color.black);
		result.setForeground(Color.yellow);

		
		// üũ �ڽ� �̺�Ʈ ������ �κ�
		coffee1.addItemListener(new EventCheckCoffee());
		coffee2.addItemListener(new EventCheckCoffee());
		coffee3.addItemListener(new EventCheckCoffee());
		
		size1.addItemListener(new EventCheckCoffee());
		size2.addItemListener(new EventCheckCoffee());
		size3.addItemListener(new EventCheckCoffee());
		
		
		// ��ư ������ �̺�Ʈ ������ �κ�
		ok.addActionListener(new EventCoffee());
		
		
		// ������ �ݱ� ��ư ������ �̺�Ʈ ó��
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.out.println("�����մϴ�.");
				System.exit(0); // ���α׷� ����
			}
		});
		
		// �г� p1, p2�� üũ�ڽ� ���̱�
		p1.add(coffee1); p1.add(coffee2); p1.add(coffee3);
		p2.add(size1); p2.add(size2); p2.add(size3);
		p3.add(ok); p3.add(result);
		
		// �����ӿ� ������Ʈ ���̱�
		add(coffee); add(p1); add(size); add(p2); add(p3); 

		// ������ ���� �κ�
		this.setBackground(new Color(200, 170, 150));
		setLayout(new GridLayout(5,1)); // 5�� 1���� ������ ���̾ƿ�!
		setBounds(500, 500, 700, 600);
		setVisible(true); // ������ ȭ�鿡 ���̱�
	}
	
	
	class EventCheckCoffee implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			Checkbox cb = (Checkbox)e.getSource(); 
			
			if(cb == coffee1) {
				coffee_total = 1000;
			} else if(cb == coffee2) {
				coffee_total = 1500;
			} else if(cb == coffee3) {
				coffee_total = 2000;
			}
			
			if(cb == size1) {
				size_total = 0;
			} else if(cb == size2) {
				size_total = 500;
			} else if(cb == size3) {
				size_total = 1000;
			}
		}
	}

	
	// �̺�Ʈ ó���� ���� ����Ŭ���� �ۼ�
	class EventCoffee implements ActionListener {	
		public void actionPerformed(ActionEvent e) {
			result.setText((coffee_total + size_total) + "��");
		}
	}
	
}
