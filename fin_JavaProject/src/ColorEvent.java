import java.awt.*;
import java.awt.event.*; // �̺�Ʈ ó���� ����

public class ColorEvent extends Frame {
	Button b1, b2, b3, b4, r;
	Font f1 = new Font("Serif", Font.BOLD, 32);
	
	ColorEvent(String title) {
		super(title);
		
		b1 = new Button("�Ķ�");
		b2 = new Button("���");
		b3 = new Button("��Ȳ");
		b4 = new Button("�ʷ�");
		r = new Button("����");
		
		
		b1.setBounds(150, 150, 150, 150);
		b2.setBounds(400, 150, 150, 150);
		b3.setBounds(150, 350, 150, 150);
		b4.setBounds(400, 350, 150, 150);
		r.setBounds(150, 550, 400, 150);
		
		
		b1.setFont(f1);
		b2.setFont(f1);
		b3.setFont(f1);
		b4.setFont(f1);
		r.setFont(f1);
		
		b1.setBackground(new Color(64,128,128));
		b2.setBackground(new Color(64,128,128));
		b3.setBackground(new Color(64,128,128));
		b4.setBackground(new Color(64,128,128));
		r.setBackground(new Color(164,228,228));
		
		b1.setForeground(Color.white);
		b2.setForeground(Color.white);
		b3.setForeground(Color.white);
		b4.setForeground(Color.white);
		r.setForeground(Color.BLUE);
		
		// ��ư�� Ŭ������ �� �̺�Ʈ ó�� �κ�
		b1.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				setBackground(Color.blue);
			}
		});

		b2.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				setBackground(Color.yellow);
			}
		});
		
		b3.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				setBackground(Color.orange);
			}
		});
		
		b4.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				setBackground(Color.green);
			}
		});
		
		r.addActionListener(new EventColor());
		
		// ������ �ݱ� ��ư ������ �̺�Ʈ ó��
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose(); 
			}
		});
		
		
		// �����ӿ� ��ư ���̱�
		add(b1); add(b2); add(b3); add(b4); add(r);
		this.setLayout(null); // ������ ���̾ƿ� ��� ����(��ǥ ���)
		
		// ������ �߾ӿ� ��ġ��Ű��
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize(); // ȭ���� �ʺ�� ���̸� ����
		setBounds(screenSize.width/2-350, screenSize.height/2-400, 700, 800);

		setVisible(true); // ������ ȭ�鿡 ���̱�
	}

	// �̺�Ʈ ó���� ���� ����Ŭ���� �ۼ�
	class EventColor implements ActionListener {	
		public void actionPerformed(ActionEvent e) {
			Color color[] = {Color.blue, Color.yellow, Color.orange, Color.green};
			int random = (int)(Math.random()*4); // 0,1,2,3
			
			setBackground(color[random]);
		}
	}

}














