import java.awt.*;
import java.awt.event.*;

public class Test11 extends Frame {
	Image img;
	
	Test11(String title){
		super(title);
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		img = tk.getImage("java.png");
		
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
		
		//ȭ�鿡 ������ �������鼭 �ڵ����� paint()ȣ��
		public void paint(Graphics g) { //�������̵�
			int imgWidth = img.getWidth(this); // img �ʺ� ���ؼ� imgwidth�� ����
			int imgHegiht = img.getHeight(this);
			
			if(img == null) {
				return;
			}
			
			g.drawImage(img, 100, 100, this); //this(������)�� img�� (100,100)�� ���̱�
		}
		
	
	
	public static void main(String[] args) {
		Test11 t = new Test11("�����ӿ� �׸����̱�");

	}

}
