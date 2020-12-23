import java.awt.*;
import java.awt.event.*; // �̺�Ʈ ó���� ����

public class MusicBox extends Frame {
	String str1, str2;
	Label p1_name, p1_comment, p1_result;
	Panel p1;
	Button b1, b2;
	Canvas cvs0;
	TextField txt1;
	
	Image img0, img = null;
	
	// ��Ʈ ��ü �߰�
		Font f1 = new Font("Serif", Font.BOLD, 20);
		Font f2 = new Font("Serif", Font.BOLD, 20);
		
	
	MusicBox(String title){
		super(title);
		
		p1 = new Panel();
		
		p1.setBackground(Color.black);
		p1.setLayout(null);	
		 
		 Toolkit tk = Toolkit.getDefaultToolkit();
			img0 = tk.getImage(""); 
			
			p1_comment = new Label("�ݴ�ſ��� ��︮�� ���� ��õ��",Label.CENTER);
			p1_name = new Label("�̸�: ");
		    p1_result = new Label("�̸��� �Է��ϼ���.", Label.CENTER);
		    txt1 = new TextField(5);
			b1 = new Button("���Ȯ��");
			b2 = new Button("�Է�");
			 
			
			 
			 cvs0 = new Canvas() {
				public void paint(Graphics g) {
					g.drawImage(img0, 50, 220, this);
					
				}
			};
			
						 
			 cvs0.setSize(50, 50);
			 cvs0.repaint();
		    
			 p1_comment.setBounds(140, 70, 300, 30);
			 p1_comment.setFont(f1);
			 p1_comment.setForeground(Color.darkGray);
			 p1_comment.setBackground(Color.orange);
			
			 p1_name.setBounds(150, 120, 40, 30);
			 			 
			 txt1.setBounds(200, 120, 130,30);
			 
			 b2.setBounds(330, 120, 50, 30);
			 b1.setBounds(380, 120, 50, 30);
			 p1_result.setBounds(50, 180, 500, 50);
			
		  
		 // ��ư �̺�Ʈ ������(������) �ޱ�
			b1.addActionListener(new EventResult());
			b2.addActionListener(new EventResult2());
			
		// �г� p1�� ������Ʈ ���̱�                     
		p1.add(p1_comment);p1.add(p1_name);
		p1.add(txt1); p1.add(b1); p1.add(b2);
		p1.add(p1_result); p1.add(cvs0);
	    
		
		add(p1);add(p1_comment);add(p1_name);
		add(txt1); add(b1); add(b2);
		add(p1_result); add(cvs0);
		
		
		// ������ �ݱ� ��ư ������ �̺�Ʈ ó��
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose(); }
		});
		
		// ������ �߾ӿ� ��ġ��Ű��
		//Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize(); // ȭ���� �ʺ�� ���̸� ����
		setBounds(screenSize.width/2-450, screenSize.height/2-420, 600, 840);
				setVisible(true);
	}

		// �̹��� ���� ��ư �̺�Ʈ ó����
		class EventResult implements ActionListener {	
			public void actionPerformed(ActionEvent e) {
				String imgArr[] = {"images/img1.jpg", "images/img2.jpg", "images/img3.jpg", "images/img4.jpg", "images/img5.jpg", "images/img6.jpg","images/img7.jpg"};
				int random_str;
			
				random_str = (int)(Math.random()*7); 
			
				img0 = Toolkit.getDefaultToolkit().getImage(imgArr[random_str]); // ��ư ���������� img0 �̹��� ����
			
				cvs0.repaint(); // cvs0 �����ٰ� �ٽ� �׸���!
			}
		}
	
		class EventResult2 implements ActionListener {	
			public void actionPerformed(ActionEvent e) {
						
				str1 = txt1.getText();
			
				p1_result.setText( "��" + str1 + "�Կ��� ��︮�� ������!!��");
				p1_result.setFont(f2);
				p1_result.setBounds(50, 180, 500, 50);
			
				
				txt1.setText("");
				txt1.requestFocus(); // Ű �Է� �κп� ��Ŀ�� �̵�
			
			}
		}
}
	

