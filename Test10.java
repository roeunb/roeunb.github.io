import java.awt.*;
import java.awt.event.*;

public class Test10 extends Frame implements MouseMotionListener {
	int x, y; // ��������� �ʱ�ȭ ���� ������ �⺻�� ����
	
	Test10(String title) {
		super(title);
		
		// ���콺 ������ �����̸� �����⿡�� �̺�Ʈ ó����� ����!
		addMouseMotionListener(this);	
		
		// ������ �ݱ� ��ư ������ �̺�Ʈ ó��
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0); // ���α׷� ����
			}
		});

		// ������ ����
		setBounds(500, 500, 700, 700);
		setVisible(true);
	}

	// paint()�޼ҵ� �ڵ� ȣ�� �ñ�
	// 1. ó�� ȭ���� ������ ��
	// 2. �ٸ� ȭ�鿡 �������ٰ� �ٽ� ������ ��
	// 3. �ּ�ȭ�ƴٰ� �ٽ� ������ ��
	public void paint(Graphics g) { // paint() �������̵�
		g.drawString("���콺�� ������������.", 50, 100);
		g.drawString("*", x, y);
	}
	
	public void update(Graphics g) {
		paint(g); // ���� update�� ��� ȭ���� ����� paint()ȣ���ϴµ� �������̵� �Ͽ� ȭ�������� �ʰ� paint()ȣ���ϰ� ��!
	}

	public void mouseDragged(MouseEvent e) {}
	public void mouseMoved(MouseEvent e) {
		x = e.getX(); 
		y = e.getY();
		repaint(); // repaint() -> update() -> paint()
	}

	public static void main(String[] args) {
		Test10 t = new Test10("Graphics Test");
	}
}

