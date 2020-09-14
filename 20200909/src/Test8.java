import java.awt.*;
import java.awt.event.*;

public class Test8 extends Frame {
	// ������� ����
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
		// �г� p1�� �⺻ ���̾ƿ��� FlowLayout���

		p2 = new Panel();
		p2.setLayout(null);
		// �г� p2�� ���̾ƿ� �����ϰ� ��ǥ�� ����
		
		blood = new Label("������ ����", Label.CENTER);
		blood.setFont(f1);
		
		group = new CheckboxGroup(); // �׷����� �����Ͽ� üũ�ڽ��� ������ư���� ����!(4������)
		cb1 = new Checkbox("A��", group, false);
		cb2 = new Checkbox("B��", group, false);
		cb3 = new Checkbox("AB��", group, false);
		cb4 = new Checkbox("O��", group, false);
		
		cb1.setFont(f1);
		cb2.setFont(f1);
		cb3.setFont(f1);
		cb4.setFont(f1);
		
		ok = new Button("Ȯ��");
		ok.setFont(f1);
		ok.setBounds(50, 20, 150, 60);
		
		result = new Label("", Label.CENTER); // ó������ ���ڿ� ���� ���·� ����!
		result.setBackground(Color.black);
		result.setForeground(Color.yellow);
		result.setFont(f1);
		result.setBounds(250, 20, 350, 60);
		
		// �гο� ������Ʈ ���̱�
		p1.add(cb1); p1.add(cb2); p1.add(cb3); p1.add(cb4);  
		p2.add(ok); p2.add(result);
		
		// �����ӿ� ������Ʈ ���̱�
		add(blood); add(p1); add(p2);
		
		
		// �̺�Ʈ ������(������) �κ�
		cb1.addItemListener(new Checkbox_Event());
		cb2.addItemListener(new Checkbox_Event());
		cb3.addItemListener(new Checkbox_Event());
		cb4.addItemListener(new Checkbox_Event());
		
		ok.addActionListener(new Button_Event());
		
		
		// ������ �ݱ� ��ư ������ �̺�Ʈ ó��
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.out.println("�����մϴ�.");
				System.exit(0); // ���α׷� ����
			}
		});

		// ������ ���� �κ�
		setLayout(new GridLayout(3,1)); // 3�� 1���� ������ ���̾ƿ�!
		setBounds(500, 500, 700, 400);
		setVisible(true); // ������ ȭ�鿡 ���̱�
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
				result.setText("�������� ����!");
			} else {			
				result.setText(str + "�̱���~!!");
			}
		}
	}
	
	public static void main(String[] args) {
		Test8 t = new Test8("������ ���� ���α׷�");
	}

}
