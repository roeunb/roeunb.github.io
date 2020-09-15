import java.awt.*;//������Ʈ ����ϱ� ���� 
import java.awt.event.*; //�̺�Ʈ ó�� ����
import javax.swing.*; //swing ����ϱ� ����

public class MenuStart extends Frame {
	
	MenuStart(String title){
		super(title);
	
		this.setIconImage(new ImageIcon("icon.jpg").getImage());
		
		//������ �߾ӿ� ��ġ��Ű��
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();//ȭ���� �ʺ�� ���̸� ����
		setBounds(screenSize.width/2-300,screenSize.height/2-250, 700, 700);
		
		//�޴� �κ�
		MenuBar mb = new MenuBar();
		
		Menu m1 = new Menu("����");
		MenuItem mi1 = new MenuItem("ȸ������", new MenuShortcut('J', true)); //����Ű ���� Ctrl + shift + J
		MenuItem mi2 = new MenuItem("����", new MenuShortcut('E'));//����� ���� Ctrl + E (true�� ������ shift)s
		
		mi2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);//���α׷� ���� ����
			}
			
		});
		
		m1.add(mi1);
		m1.addSeparator();//���м� �߰�
		m1.add(mi2);
		
		//�޴� �̺�Ʈ �κ�
		Menu m2 = new Menu("�̺�Ʈó��");
		MenuItem mi3 = new MenuItem("Ŀ�����Ǳ�");
		
		mi3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Ŀ�� ���Ǳ� �޴��� ������ Ŀ�� ���Ǳ� �������� ����!
				new Coffee("Ŀ�� ���Ǳ�");
				
			}
			
		});
		
		
		
		m2.add(mi3);
		
		
		//�޴��ٿ� �޴� ���̱�
		mb.add(m1);
		mb.add(m2);
		
		
		// ������ �ݱ� ��ư ������ �̺�Ʈ ó��
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0); // ���α׷� ����
			}
		});

		// ������ ����
		this.setMenuBar(mb);//�����ӿ� �޴��� ���̱�. 
		this.setVisible(true);//������ ȭ�鿡 ���̱�
	}
	
		
	public static void main(String[] args) {
		MenuStart m = new MenuStart("Java Project");
	}

}
