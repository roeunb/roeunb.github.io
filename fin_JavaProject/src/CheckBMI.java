import java.awt.*;
import java.awt.event.*; // �̺�Ʈ ó���� ����

public class CheckBMI extends Frame {
	String str1, str2; // �Է��� Ű, ������ ������ ����
	
	Panel p0, p1, p2, p3;
	
	// �г� 0���� ����� ��� ���� ����
	Canvas cvs0;
	Label p0_str1, p0_str2, p0_str3;
	Button p0_b1;
	
	// �г� 1���� ����� ��� ���� ����
	Label p1_cm1, p1_kg1, p1_cm2, p1_kg2;
	TextField p1_tf1, p1_tf2;
	Button result, reset;
	
	// �г� 2���� ����� ��� ���� ����
	Label p2_l1, p2_l2;
	
	// �г� 3���� ����� ��� ���� ����
	Image img0, img = null;

	// ��Ʈ ��ü �߰�
	Font f1 = new Font("Serif", Font.BOLD, 27);
	Font f2 = new Font("Serif", Font.BOLD + Font.ITALIC, 22);
	Font f3 = new Font("Serif", Font.BOLD, 20);
	
	CheckBMI(String title) {
		super(title);
		
		p0 = new Panel();
		p1 = new Panel();
		p2 = new Panel();
		p3 = new Panel();
		
		p0.setBackground(Color.white);
		p1.setBackground(new Color(210,200,175));
		p2.setBackground(new Color(220,230,210));
		p3.setBackground(Color.white);
		
		
		/*************** �г� p0 �κ� ****************/
		p0.setLayout(null);
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		img0 = tk.getImage("images/img_bmi0.jpg"); 

		p0_b1 = new Button("�̹��� ����");
		p0_b1.setBounds(600, 50, 210, 100);
		p0_b1.setFont(f3);
		p0_b1.setBackground(new Color(220, 200, 180));
		
	    cvs0 = new Canvas() {
			public void paint(Graphics g) {
				g.drawImage(img0, 50, 0, this);
			}
		};
		
	    cvs0.setSize(550,200);
	    cvs0.repaint();
		
	    // �̹��� ���� ��ư �̺�Ʈ ������(������) �ޱ�
	    p0_b1.addActionListener(new EventImageChange());

	    
	    p0.add(cvs0);
	    p0.add(p0_b1);
		
		
		
		/*************** �г� p1 �κ� ****************/
		p1.setLayout(null); // �г� p1�� ���̾ƿ� ��� ����
		
		p1_cm1 = new Label("����", Label.RIGHT);
		p1_cm2 = new Label("cm");
		p1_kg1 = new Label("������", Label.RIGHT);
		p1_kg2 = new Label("kg");
		
		p1_tf1 = new TextField(5);
		p1_tf2 = new TextField(5);
		
		result = new Button("���");
		reset = new Button("�ʱ�ȭ");
		
		p1_cm1.setBounds(70, 35, 100, 35);
		p1_cm1.setFont(f1);
		p1_cm1.setForeground(new Color(50,30,50));
		
		p1_tf1.setBounds(200, 35, 150, 35);
		p1_tf1.setFont(f1);
		p1_tf1.setForeground(new Color(50,30,50));
		
		p1_kg1.setBounds(70, 110, 100, 35);
		p1_kg1.setFont(f1);
		p1_kg1.setForeground(new Color(50,30,50));
		
		p1_tf2.setBounds(200, 110, 150, 35);
		p1_tf2.setFont(f1);
		p1_tf2.setForeground(new Color(50,30,50));
		
		p1_cm2.setBounds(370, 35, 100, 35);
		p1_cm2.setFont(f1);
		p1_cm2.setForeground(new Color(50,30,50));
		
		p1_kg2.setBounds(370, 110, 100, 35);
		p1_kg2.setFont(f1);
		p1_kg2.setForeground(new Color(50,30,50));
		
		result.setBounds(500, 35, 150, 110);
		result.setFont(f1);
		result.setForeground(new Color(50,30,50));
				
		reset.setBounds(680, 35, 150, 110);
		reset.setFont(f1);
		reset.setForeground(new Color(50,30,50));		
		
		
		// ���, �ʱ�ȭ ��ư �̺�Ʈ ������(������) �ޱ�
		result.addActionListener(new EventResult());
		reset.addActionListener(new EventReset());
	
		
		// �г� p1�� ������Ʈ ���̱�
		p1.add(p1_cm1); p1.add(p1_tf1); p1.add(p1_cm2);
		p1.add(p1_kg1); p1.add(p1_tf2); p1.add(p1_kg2);
		p1.add(result); p1.add(reset);
		
		
		/*************** �г� p2 �κ� ****************/
		
		p2.setLayout(new GridLayout(2,1)); // �г� p2�� 2��1���� ���

		p2_l1 = new Label("��� ��ư�� �����ּ���.", Label.CENTER);
		p2_l2 = new Label("ü���������� �ڽ��� ������(kg)�� Ű�� ����(m)���� ���� ���Դϴ�.", Label.CENTER); 
		
		p2_l1.setFont(f1);	
		p2_l2.setFont(f2);
		p2_l2.setForeground(Color.blue);
		
		// �г� p2�� ������Ʈ ���̱�
		p2.add(p2_l1); p2.add(p2_l2);
		
		
		
		
		/*************** �г� p3 �κ� ****************/	
		// Toolkit tk = Toolkit.getDefaultToolkit();
		img = tk.getImage("images/img_bmi.jpg"); 
		
		
	    Canvas cvs = new Canvas() {
			public void paint(Graphics g) {
				g.drawImage(img, 0, 0, this);
			}
		};
		
	    cvs.setSize(800,200);
	    cvs.repaint();
		
	    p3.add(cvs);
		
	    
	    
		// �����ӿ� �г� ���̱�
	    add(p0); add(p1); add(p2); add(p3);
		
		
		// ������ �ݱ� ��ư ������ �̺�Ʈ ó��
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose(); // Ŀ�����Ǳ� �����Ӹ� �޸𸮿��� ����(�ݱ�)
			}
		});
		
		
		// ������ ���� �κ�
		setLayout(new GridLayout(4,1)); // 4�� 1���� ������ ���̾ƿ�!
		
		// ������ �߾ӿ� ��ġ��Ű��
		//Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize(); // ȭ���� �ʺ�� ���̸� ����
		setBounds(screenSize.width/2-450, screenSize.height/2-420, 900, 840);

		setVisible(true); // ������ ȭ�鿡 ���̱�
	}
	

	// �̺�Ʈ ó���� ���� ����Ŭ���� �ۼ�
	
	
	// �̹��� ���� ��ư �̺�Ʈ ó����
	class EventImageChange implements ActionListener {	
		public void actionPerformed(ActionEvent e) {
			String imgArr[] = {"images/img_bmi0.jpg", "images/img_b1.jpg", "images/img_b2.jpg", "images/img_b3.jpg", "images/img_b4.jpg", "images/img_b5.jpg", "images/img_b6.jpg", "images/img_b7.jpg"};
			Color colorArr[] = {Color.pink, Color.cyan, Color.yellow, Color.orange, Color.gray, Color.blue, Color.magenta};
			int random_str, color_cnt;
			
			random_str = (int)(Math.random()*8); // 0~7 ������ ������ �߻�
			color_cnt = (int)(Math.random()*7); // 0~6 ������ ������ �߻�
			
			img0 = Toolkit.getDefaultToolkit().getImage(imgArr[random_str]); // ��ư ���������� img0 �̹��� ����
			p0_b1.setBackground(colorArr[color_cnt]); // ��ư�� ���� ����
			
		    cvs0.repaint(); // cvs0 �����ٰ� �ٽ� �׸���!
		}
	}
	
	
	// ��� ��ư �̺�Ʈ ó����
	class EventResult implements ActionListener {	
		public void actionPerformed(ActionEvent e) {
			String str; // �񸸵� ��� ������ ����
			double bmi, h, w; 
			// h: Ű, w: ������ (TextField ���� �Է¹��� ���� String(���ڿ�)�̱� ������ �Ǽ��� ����� �� ������ ����)
			
			p2_l2.setFont(f1);
			
			str1 = p1_tf1.getText(); // Ű
			str2 = p1_tf2.getText(); // ������
			
			try {
				h = Double.parseDouble(str1); // Ű�� ���ڿ��� �Է¹޾� double������ �����Ͽ� h�� ����(�Է½� �Ǽ��� �ƴϸ� ���� �߻��� �� ����)
				w = Double.parseDouble(str2);
				
				// BMI ���� ����ϱ�
				// ������ / (Ű(����) * Ű(����))
				bmi = w / ((h/100) * (h/100));
				
				if(bmi < 18.5) {
					str = "��ü��";
				} else if(bmi < 23) {
					str = "����";
				} else if(bmi < 25) {
					str = "������";
				} else {
					str = "��";
				}
				
				p2_l1.setForeground(Color.black);
				p2_l1.setText("�񸸵� ����� " + str + " �Դϴ�.");
				p2_l2.setText("BMI ������ " + String.format("%.2f", bmi));
			} catch(NumberFormatException nfe) {
				p2_l1.setForeground(Color.red);
				p2_l1.setText("Ű�� �����Դ� ����(����,�Ǽ�) �Է¸� �����մϴ�.");
				p2_l2.setFont(f2);
				p2_l2.setText("�� �ٽ� �Է����ּ���. ��");
				
				p1_tf1.setText("");
				p1_tf2.setText("");
				p1_tf1.requestFocus(); // Ű �Է� �κп� ��Ŀ�� �̵�
			}
		}
	}
	
	// �ʱ�ȭ ��ư �̺�Ʈ ó����
	class EventReset implements ActionListener {	
		public void actionPerformed(ActionEvent e) {
			p2_l1.setText("��� ��ư�� �����ּ���.");
			p2_l2.setFont(f2);
			p2_l2.setText("ü���������� �ڽ��� ������(kg)�� Ű�� ����(m)���� ���� ���Դϴ�.");
			
			
			p1_tf1.setText("");
			p1_tf2.setText("");
			p1_tf1.requestFocus(); // Ű �Է� �κп� ��Ŀ�� �̵�
		}
	}

}
