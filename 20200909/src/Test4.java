import java.awt.*; //������Ʈ, �����̳�, �޴�����ϱ� ����
import java.awt.event.*; //�̺�Ʈ ó��

public class Test4 extends Frame{
	Label location;
	Font f1 = new Font("Serif", Font.BOLD, 25);
	
	
	Test4(String title){
		super(title);
		
		//���̺� �����κ�
		location = new Label("Mouse Pointer Location : ");
		location.setBounds(20, 80, 430, 55);
		location.setBackground(Color.yellow);
		location.setFont(f1);
		
		//�̺�Ʈ ó�� �κ�
		this.addMouseMotionListener(new EventMouse());
		
		//������ ���� �κ�
		this.setBounds(800,500,300,200);//������ ���� ��ġ, ũ��
		this.setLayout(null); //������ ���̾ƿ� ������(��ǥ���)
		this.add(location); //�����ӿ� label ���̱�
		this.setVisible(true);
	}
	
	class EventMouse extends MouseMotionAdapter {
		public void mouseDragged(MouseEvent e) {}
		public void mouseMoved (MouseEvent e) {
			location.setText("Mouse Pointer Location : (" + e.getX() +","+ e.getY()+")");
			location.setBackground(Color.orange);
		}
		
	}
	
	public static void main(String[] args) {
		Test4 t = new Test4("Mouse Event Test");
	}	
}