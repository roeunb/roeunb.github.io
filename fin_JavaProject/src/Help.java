import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Help extends Frame {
	Image img;
	
	Help(String title) {
		super(title);
		
		// ������ ������ �̹��� ����
		this.setIconImage(new ImageIcon("images/icon.jpg").getImage());			
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		img = tk.getImage("images/help.jpg"); // help.jpg �̹����� ������ͼ� img�� ����!
		
		// ������ �ݱ� ��ư ������ �̺�Ʈ ó��
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose(); 
			}
		});
		
		// ������ �߾ӿ� ��ġ��Ű��
		Dimension screenSize = tk.getScreenSize(); // ȭ���� �ʺ�� ���̸� ����
		setBounds(screenSize.width/2-350, screenSize.height/2-350, 700, 700);

		setVisible(true); // ������ ȭ�鿡 ���̱�
	}

	// paint() ȣ�� ����
	// 1. ȭ���� ���̸鼭 ȣ��
	// 2. �������ٰ� �ٽ� ���̸� ȣ��
	// 3. �ּ�ȭ �ƴٰ� �ٽ� ���̸� ȣ��
	public void paint(Graphics g) { // �������̵�
		if(img == null) {
			return;
		}
		
		g.drawImage(img, 0, 0, this);
	}

}






