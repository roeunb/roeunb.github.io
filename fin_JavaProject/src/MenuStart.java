import java.awt.*; // ������Ʈ ����ϱ� ����
import java.awt.event.*; // �̺�Ʈ ó�� ����
import javax.swing.*; // swing ����ϱ� ����

public class MenuStart extends Frame {
	
	MenuStart(String title) {
		super(title);
		
		// ������ ������ �̹��� ����
		this.setIconImage(new ImageIcon("images/icon.jpg").getImage());
		
		// ������ �߾ӿ� ��ġ��Ű��
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize(); // ȭ���� �ʺ�� ���̸� ����
		setBounds(screenSize.width/2-375, screenSize.height/2-250, 750, 500);
			
		MenuBar mb = new MenuBar(); // �޴��� ��ü ����
		
		// �޴� ���� �κ�
		Menu m1 = new Menu("����");
		MenuItem mi1 = new MenuItem("ȸ������", new MenuShortcut('J', true)); // ����Ű ���� ctrl + shift + 'J'
		MenuItem mi2 = new MenuItem("����", new MenuShortcut('E')); // ����Ű ���� ctrl + 'E'
		
		mi2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0); // ���α׷� ���� ����
			}
		});

		m1.add(mi1);
		m1.addSeparator(); // ���м� �߰�
		m1.add(mi2);
	
		// �޴� �̺�Ʈ �κ�
		Menu m2 = new Menu("�̺�Ʈ ó�� 1");
		
		MenuItem mi3 = new MenuItem("Ŀ�� ���Ǳ�");
		mi3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Ŀ�����Ǳ� �޴��� ������ Ŀ�����Ǳ� �������� ����!
				new Coffee("Ŀ�� ���Ǳ�");
			}
		});

		MenuItem mi4 = new MenuItem("üũ�ڽ� �̺�Ʈ");
		mi4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new CheckEvent("üũ�ڽ� �̺�Ʈ");
			}
		});
		
		MenuItem mi5 = new MenuItem("�÷� �̺�Ʈ");
		mi5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new ColorEvent("�÷� �̺�Ʈ");
			}
		});
		
		MenuItem mi9 = new MenuItem("ũ��������");
		mi9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Christmas("ũ��������");
			}
		});
		
		m2.add(mi3);
		m2.add(mi4);
		m2.add(mi5);
		m2.add(mi9);
		
		// �޴� �̺�Ʈ ó��2 �κ�
		Menu m3 = new Menu("�̺�Ʈ ó�� 2");
		MenuItem mi6 = new MenuItem("CheckBMI");
		mi6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new CheckBMI("CheckBMI");
			}
		});
		
		MenuItem mi7 = new MenuItem("Receipt");
		mi7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Receipt("Receipt");
			}
		});
		
		MenuItem mi10 = new MenuItem("MusicBox");
		mi10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new MusicBox("MusicBox");
			}
		});
		
		m3.add(mi6);
		m3.add(mi7);
		m3.add(mi10);
			
		
		// �޴� ���� �κ�
		Menu m4 = new Menu("����");
		MenuItem mi8 = new MenuItem("������Ʈ ����");
		mi8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Help("������Ʈ ����");
			}
		});
		
		m4.add(mi8);
		
		
		// �޴��ٿ� �޴� ���̱�
		mb.add(m1); mb.add(m2); mb.add(m3); mb.add(m4);
		
		// ������ �ݱ� ��ư ������ �̺�Ʈ ó��
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0); // ���α׷� ����
			}
		});

		
		// ������ ����
		this.setMenuBar(mb); // �����ӿ� �޴��� ���̱�
		this.setVisible(true); // ������ ȭ�鿡 ���̱�
	}
	
	
	public static void main(String[] args) {
		new MenuStart("Java Project");
		// new Login("Login");
		// ������Ʈ test���� ��� Login �κ� �����α�
	}
}






