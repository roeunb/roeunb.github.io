import java.awt.*; //AWT ������Ʈ ����ϱ� ���� 

public class Test1 {
	public static void main(String[] args) {
		Frame f = new Frame("������ �����Դϴ�.");//������ ��ü f ����(����ǥ���� ����)
		String str ;
		
		f.setSize(700, 500); //������ �ʺ�700 ���� 500
		f.setLocation(300,100); //������ ���� ��ġ
		f.setBackground(Color.yellow);
		f.setLayout(null); //�������� ���̾ƿ��� ������� ����(���� ��ǥ ���� �ʿ���), ������ �⺻ ���̾ƿ��� �������̾ƿ�
		f.setTitle("������ �����Դϴ�2");
		
		str = f.getTitle();
		System.out.println("str = " + str);
		
		Button b1 = new Button("��ư�Դϴ�"); //��ư ��ü b1 ����
		b1.setBounds(100, 100, 200, 100); //(100,100)���� ����
		b1.setBackground(Color.gray); //��ư ���� ����
		b1.setForeground(Color.blue); //��ư ����� ����(���ڻ�)
		b1.setLabel("�ٲ��ư������"); //��ư�� ���ڿ�(����)�� ���� - ���� �ٲ� �Ⱥ��̴� ��		
		
		
		Button b2 = new Button("��ҹ�ư�Դϴ�"); //��ư ��ü b1 ����
		b2.setBounds(100, 200, 200, 100); //(100,100)���� ����
		b2.setBackground(Color.pink); //��ư ���� ����
		b2.setForeground(Color.blue); //��ư ����� ����(���ڻ�)
		
		
		Choice c = new Choice(); //���̽� ��ü c����
		c.add("������"); c.add("ȭ����"); c.add("������");
		c.add("�����"); c.add("�ݿ���"); c.add("�����"); c.add("�Ͽ���"); //���̽��� ������ ���
		c.setBounds(300, 100, 150, 100);
		System.out.println("������ ������ " +c.getItem(3)); // 0���� ����
		
		
		List l = new List(); //����Ʈ ��ü l����
		l.add("������"); l.add("ȭ����"); l.add("������");
		l.add("�����"); l.add("�ݿ���"); l.add("�����"); l.add("�Ͽ���"); //����Ʈ�� ������ ���
		l.setBounds(500, 100, 150, 80);
		l.setMultipleMode(true); //���߼���
		System.out.println("����Ʈ���� ������ ������ " +l.getItemCount()+ "���Դϴ�."); // 0���� ����
		
		
		
		System.out.println("str = " + b1.getLabel());
		
		
		
		//�����ӿ� ������Ʈ(������Ʈ, �����̳� )�� ���̱�
		f.add(b1); //�����ӿ� ��ư ���̱�
		f.add(b2);
		f.add(c);
		f.add(l);
		
		
		
		f.setVisible(true); //������ ȭ�鿡 ���̰� �ϱ�
	}

}
