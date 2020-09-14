import java.awt.*; // ������Ʈ, �����̳�, �޴� ����ϱ� ����
import java.awt.event.*; // �̺�Ʈ ó���� ����

public class Test5 extends Frame{
	TextArea ta;
	TextField tf;
	
	Test5(String title){
		super(title);
	
		ta = new TextArea();
		tf = new TextField();
		
		ta.setBackground(Color.orange);
		tf.setBackground(Color.pink);
		
		add("Center", ta); //add(BorderLayout.CENTER, ta); �̷��� �ᵵ �ȴ�
		add(tf, BorderLayout.SOUTH);
		
		//TextField tf�� ���ڿ� �Է� �� ���ͽ� �̺�Ʈ �߻� ����
		tf.addActionListener(new ChatEvent());
		
		// ������ �ݱ� ��ư ������ �����ϴ� �κ�!
		addWindowListener(new WindowAdapter() {
		public void windowClosing(WindowEvent we) {
			System.out.println("�����մϴ�.");
			System.exit(0); // ���α׷� ����
			} 
		});
	
		//������ ���� �κ�
		this.setBounds(800,500,300,200);//������ ���� ��ġ, ũ��
		this.setVisible(true); //������ ȭ�鿡 ���̱�
	}

	//���� Ŭ������ �̺�Ʈ ó��
	class ChatEvent implements ActionListener{
		public void actionPerformed(ActionEvent e){
			ta.append(tf.getText()+"\n");
			tf.setText("");
			tf.requestFocus();
		}
	}

	public static void main(String[] args) {
		Test5 t = new Test5("TextComponent Event Test");
	}
}


