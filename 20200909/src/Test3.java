import java.awt.*; // ������Ʈ, �����̳�, �޴� ����ϱ� ����
import java.awt.event.*; // �̺�Ʈ ó���� ����

public class Test3 extends Frame {
	// 5���� ��� ����(�ν��Ͻ� ����)
	Label lid, lpwd;
	TextField tfId, tfPwd;
	Button ok;
	
	Test3(String title) { // �Ű����� �ִ� ������
		super(title); // Frame(String);
		
		lid = new Label("ID : ", Label.RIGHT); // ������ ����
		lpwd = new Label("Password : ", Label.RIGHT);
		tfId = new TextField(10);
		tfPwd = new TextField(10);
		tfPwd.setEchoChar('��'); // ��й�ȣ ��ȣ�ϱ� ���ؼ� 
		ok = new Button("OK");
		
 		// �̺�Ʈ ó�� �κ�
		//2. �̺�Ʈ ������(������)
		tfId.addActionListener(new EventLogin());
		tfPwd.addActionListener(new EventLogin());
		ok.addActionListener(new EventLogin());
		
		// ������ �ݱ� ��ư ������ �����ϴ� �κ�!
		addWindowListener(new WindowAdapter() {
		public void windowClosing(WindowEvent we) {
			System.out.println("�����մϴ�.");
			System.exit(0); // ���α׷� ����
		} 
	});
		
		this.setBounds(500, 500, 700, 150);
		setLayout(new FlowLayout()); // �����ӿ� ������Ʈ ���̸� ��� ����
		add(lid); add(tfId); add(lpwd); add(tfPwd); add(ok); // �����ӿ� ������Ʈ ���̱�
		this.setVisible(true); // ������ ���̱�

	}
	

	// �α��� �̺�Ʈ ó����(Test3 Ŭ���� ���ο� �ۼ��� ����Ŭ������ ���)
	class EventLogin implements ActionListener { 
		public void actionPerformed(ActionEvent e){
			String id = tfId.getText();//�Է��� id ���ڿ��� ������ �ͼ� id�� ����
			String password =tfPwd.getText();//�Է���password ���ڿ��� ������ �ͼ� id�� ����
				
		//String Ŭ�������� equal()�޼ҵ�� �������̵��� ������ ���ڿ��� ���ڿ� ��!
		//id�� "admin"�� ���� ������ ��!
		if(!(id.equals("admin") || id.equals("admin2"))){
			System.out.println("�Է��Ͻ� ID�� ��ȿ���� �ʽ��ϴ�. �ٽ� �Է��ϼ���.");
			tfId.requestFocus();//id �ٽ��Է��� ���ֵ���tfID�� ��Ŀ�� ��
			tfId.selectAll();//��ü �����ϱ� (���̶���Ʈ)
			tfId.setText("");//���������
		}
		else if(!password.equals("admin")){
			System.out.println("�Է��Ͻ� password�� ��ȿ���� �ʽ��ϴ�. �ٽ� �Է��ϼ���.");
			tfId.requestFocus();//id �ٽ��Է��� ���ֵ���tfID�� ��Ŀ�� ��
			tfId.selectAll();//��ü �����ϱ� (���̶���Ʈ)
			tfId.setText("");//���������
		} else {
			System.out.println(id + "�� , ���������� �α��εǾ����ϴ�.");
			}
	}
}
	
	public static void main(String[] args) {
		Test3 t = new Test3("Login"); // ��ü t ����
	}
}
