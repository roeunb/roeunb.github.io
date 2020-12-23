import java.awt.*; // ������Ʈ, �����̳�, �޴� ����ϱ� ����
import java.awt.event.*; // �̺�Ʈ ó���� ����

public class Login extends Frame {
	// 5���� ��� ����(�ν��Ͻ� ����)
	Label lid, lpwd;
	TextField tfId, tfPwd;
	Button ok; // 1. �̺�Ʈ �ҽ�(���)
	Frame f = this;
	
	Login(String title) { // �Ű����� �ִ� ������
		super(title); // Frame(String);
		
		lid = new Label("ID : ", Label.RIGHT); // ������ ����
		lpwd = new Label("Password : ", Label.RIGHT);
		tfId = new TextField(10);
		tfPwd = new TextField(10);
		tfPwd.setEchoChar('��'); // ��й�ȣ ��ȣ�ϱ� ���ؼ� 
		ok = new Button("OK");
		
		
		// �̺�Ʈ ó�� �κ�
		// 2. �̺�Ʈ ������(������)
		tfId.addActionListener(new EventLogin());
		tfPwd.addActionListener(new EventLogin());
		ok.addActionListener(new EventLogin());
		
		
		// ������ �ݱ� ��ư ������ �����ϴ� �κ�!
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				dispose();
			} 
		});
		
		
		// ������ �߾ӿ� ��ġ��Ű��
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize(); // ȭ���� �ʺ�� ���̸� ����
		setBounds(screenSize.width/2-350, screenSize.height/2-75, 700, 150);

		setLayout(new FlowLayout()); // �����ӿ� ������Ʈ ���̸� ��� ����
		add(lid); add(tfId); add(lpwd); add(tfPwd); add(ok); // �����ӿ� ������Ʈ ���̱�
		this.setVisible(true); // ������ ���̱�
	}

	// �α��� �̺�Ʈ ó����(Test3 Ŭ���� ���ο� �ۼ��� ����Ŭ������ ���)
	class EventLogin implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String id = tfId.getText(); // �Է��� id ���ڿ��� ������ͼ� id�� ����
			String password = tfPwd.getText(); // �Է��� password ���ڿ��� ������ͼ� id�� ����
			
			
			if(id.equals("admin") && password.equals("admin")) {
				Msg m = new Msg(f, id + "��, ���������� �α��� �Ǿ����ϴ�.");
				f.setVisible(false);
				f.dispose();
			} else {
				Msg m = new Msg(f, "ID/PASSWORD�� Ʋ�Ƚ��ϴ�.");
				tfId.setText(""); // id ���� �����
				tfPwd.setText(""); // password ���� �����
				tfId.requestFocus(); // id �ٽ� �Է��� �� �ֵ��� tfId�� ��Ŀ�� ��!
			}
			

			// String Ŭ�������� equals()�޼ҵ�� �������̵��Ȱ����� ���ڿ��� ���ڿ� ��!
			// id�� "admin"�� ���� ������ ��!
			/*
			if(!(id.equals("admin") || id.equals("admin2"))) {
				System.out.println("�Է��Ͻ� ID�� ��ȿ���� �ʽ��ϴ�. �ٽ� �Է��ϼ���.");
				tfId.requestFocus(); // id �ٽ� �Է��� �� �ֵ��� tfId�� ��Ŀ�� ��!
				tfId.selectAll(); // ��ü �����ϱ�(���̶�����)
				tfId.setText(""); // ���� �����
			} else if(!password.equals("admin")) {
				System.out.println("�Է��Ͻ� password�� ��ȿ���� �ʽ��ϴ�. �ٽ� �Է��ϼ���.");
				tfPwd.requestFocus(); // password �ٽ� �Է��� �� �ֵ��� tfPwd�� ��Ŀ�� ��!
				tfPwd.selectAll(); // ��ü �����ϱ�(���̶�����)
				tfPwd.setText(""); // ���� �����
			} else {
				Msg m = new Msg(f, id + "��, ���������� �α��� �Ǿ����ϴ�.");
				
				//System.out.println(id + "��, ���������� �α��� �Ǿ����ϴ�.");
			}
			*/
		} 
	}

}










