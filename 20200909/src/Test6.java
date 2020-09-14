import java.awt.*; // ������Ʈ, �����̳�, �޴� ����ϱ� ����
import java.awt.event.*; // �̺�Ʈ ó���� ����

public class Test6 extends Frame {
	CheckboxGroup group;
	Checkbox cb1, cb2, cb3;

	Test6(String title){
		super(title);
		
		group = new CheckboxGroup();
		cb1 = new Checkbox("red", group, true);
		cb2 = new Checkbox("green", group, false);
		cb3 = new Checkbox("blue", group, false);
		
		//�����ӿ� ������Ʈ ���̱�
		add(cb1); add(cb2); add(cb3);
		
		//üũ�ڽ� �̺�Ʈ ó�� �κ�
		cb1.addItemListener(new CheckEvent());
		cb2.addItemListener(new CheckEvent());
		cb3.addItemListener(new CheckEvent());
		
		// ������ �ݱ� ��ư ������ �����ϴ� �κ�!
		addWindowListener(new WindowAdapter() {
		public void windowClosing(WindowEvent we) {
				System.out.println("�����մϴ�.");
				System.exit(0); // ���α׷� ����
			} 
		});
		
		//������ ���� �κ�
		this.setBackground(Color.red);
		this.setLayout(new FlowLayout()); //��->����, ��->�Ʒ�, ��� ������ �⺻		
		this.setBounds(800,500,300,200);//������ ���� ��ġ, ũ��
		this.setVisible(true);
	}	
	
	class CheckEvent implements ItemListener {
		public void itemStateChanged(ItemEvent e){
			Checkbox cb = (Checkbox)e.getSource();
			String color = cb.getLabel(); 
	
			if(color.equals("red")){
				setBackground(Color.red);
				cb1.setBackground(Color.red);
				cb2.setBackground(Color.red);
				cb3.setBackground(Color.red);
			}else if(color.equals("green")){
				setBackground(Color.green);
				cb1.setBackground(Color.green);
				cb2.setBackground(Color.green);
				cb3.setBackground(Color.green);
			}else {
				setBackground(Color.blue);
				cb1.setBackground(Color.blue);
				cb2.setBackground(Color.blue);
				cb3.setBackground(Color.blue);
			}
		}
	}
	
	public static void main(String[] args) {
		Test6 t = new Test6("Checkbox Event Test");
	}

}
