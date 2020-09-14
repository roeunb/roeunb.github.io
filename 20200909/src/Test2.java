// ������ ���� ���Ǳ� ���α׷�
// ��ư�� ������ ������ ��ǰ�� �˷��ִ� ���α׷�

import java.awt.*; // ������Ʈ, �����̳�, �޴� ����ϱ� ����
import java.awt.event.*; // �̺�Ʈ ó���� ����

class EventCoffee1 implements ActionListener {
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("�Ƹ޸�ī�븦 �����ϼ̽��ϴ�.");
	}
}

class EventCoffee2 implements ActionListener {
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("ī��󶼸� �����ϼ̽��ϴ�.");
	}
}

public class Test2 {
	public static void main(String[] args) {
		Frame f = new Frame("�� ������ Ŀ�� ���Ǳ� ��");
		f.setBounds(500, 500, 750, 500);
		f.setBackground(new Color(224,224,192));
		f.setLayout(null); // ������ ���̾ƿ� ��� ����
		
		// ������ �ݱ� ��ư ������ �����ϴ� �κ�!
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.out.println("�����մϴ�.");
				System.exit(0); // ���α׷� ����
			} 
		});
		
		Font f1 = new Font("Serif", Font.BOLD, 22);
		Font f2 = new Font("Serif", Font.BOLD + Font.ITALIC, 25);
			
		Button coffee1 = new Button("�Ƹ޸�ī��");
		Button coffee2 = new Button("ī����");
		Button coffee3 = new Button("īǪġ��");
		
		coffee1.addActionListener(new EventCoffee1());
		coffee2.addActionListener(new EventCoffee2());
		coffee3.addActionListener(new ActionListener() { // �͸�Ŭ���� ���
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("īǪġ�븦 �����ϼ̽��ϴ�.");
				coffee3.setBackground(Color.red);
			}
		});
		
		coffee1.setBounds(100, 120, 150, 120);
		coffee1.setBackground(new Color(112,146,190));
		coffee1.setForeground(Color.white);
		coffee1.setFont(f1);
		
		coffee2.setBounds(300, 120, 150, 120);
		coffee2.setBackground(new Color(112,146,190));
		coffee2.setForeground(Color.white);
		coffee2.setFont(f1);
		
		coffee3.setBounds(500, 120, 150, 120);
		coffee3.setBackground(new Color(112,146,190));
		coffee3.setForeground(Color.white);
		coffee3.setFont(f1);

		
		Label result = new Label("�� ��ư�� �������� ��", Label.CENTER);
		result.setBounds(100, 290, 550, 130);
		result.setBackground(new Color(124,124,92));
		result.setForeground(Color.white);
		result.setFont(f2);
		
		
		// �����ӿ� ������Ʈ ���̱�
		f.add(coffee1); f.add(coffee2); f.add(coffee3); f.add(result);
		
		f.setVisible(true); // ������ ȭ�鿡 ���̱�
	}
}
