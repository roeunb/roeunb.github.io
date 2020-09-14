import java.awt.*; // ������Ʈ, �����̳�, �޴� ����ϱ� ����
import java.awt.event.*; // �̺�Ʈ ó���� ����

// ������(������)�� x(�ݱ�)��ư�� ������ �̺�Ʈ ó���� ���� EventA Ŭ���� ����
// windowClosing()�� �����ϱ� ���ؼ� �������̽��� WindowListener�� ����(implements)�ؾ� ��!
// �������̽� ���� �ִ� ��� �߻�޼ҵ带 �����ؾ� ��!
/*
class EventA implements WindowListener { // 3. �̺�Ʈ ó����
	public void windowActivated(WindowEvent arg0) {}
	public void windowClosed(WindowEvent arg0) {}
	public void windowClosing(WindowEvent arg0) {
		System.out.println("�����մϴ�.");
		arg0.getWindow().setVisible(false); // ȭ�鿡�� ������
		arg0.getWindow().dispose(); // �޸𸮿��� ����
		System.exit(0); // ���α׷� ����
	}
	public void windowDeactivated(WindowEvent arg0) {}
	public void windowDeiconified(WindowEvent arg0) {}
	public void windowIconified(WindowEvent arg0) {}
	public void windowOpened(WindowEvent arg0) {} 
}*/


// WindowAdapter Ŭ������ �������̽� WindowListener�� �߻�޼ҵ带 ��� �����س��� Ŭ������!
class EventA extends WindowAdapter {
	public void windowClosing(WindowEvent arg0) { // �������̵�
		System.out.println("WindowAdapter Ŭ���� ��ӹ��� EventA���� �����մϴ�.");
		System.exit(0); // ���α׷� ����
	} 
}


// Ȯ�� ��ư�� ������ �̺�Ʈ ó���� �ִ� �κ�~ 
// 3. �̺�Ʈ ó����
class EventB implements ActionListener {
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("Ȯ�� ��ư�� �������ϴ�.");
	}
}

public class Test1 {
	public static void main(String[] args) {
		Frame f = new Frame("�̺�Ʈ ó�� ����"); // 1. �̺�Ʈ �ҽ�(�������� �ݱ� ��ư ���� ��)
		f.setBounds(500, 500, 700, 700);
		f.setBackground(new Color(177,188,199));
		f.setLayout(null); // ������ ���̾ƿ� ��� ����(���� ��ǥ ���)
		f.addWindowListener(new EventA()); // 2. �̺�Ʈ ������(������) �ޱ�
		
		Button ok = new Button("Ȯ��"); // 1. �̺�Ʈ �ҽ�
		ok.setBounds(100, 100, 200, 200);
		ok.setBackground(new Color(123,200,100));
		ok.addActionListener(new EventB()); // 2. �̺�Ʈ ������(������)

		Button ok2 = new Button("Ȯ��2"); // 1. �̺�Ʈ �ҽ�
		ok2.setBounds(350, 100, 200, 200);
		ok2.setBackground(new Color(223,100,200));
		ok2.addActionListener(new ActionListener() { // �͸�Ŭ���� ����� �̺�Ʈ ó��(Ŭ���� �������� �ʰ� �ٷ� ����ϰ� ��)
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ȯ��2 ��ư�� �������ϴ�.");
			}
		}); // 2. �̺�Ʈ ������(������)

		
		// �����ӿ� ������Ʈ ���̱�
		f.add(ok); 
		f.add(ok2);
			
		f.setVisible(true);
	}
}




