import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Help extends Frame {
	Image img;
	
	Help(String title) {
		super(title);
		
		// 프레임 아이콘 이미지 설정
		this.setIconImage(new ImageIcon("images/icon.jpg").getImage());			
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		img = tk.getImage("images/help.jpg"); // help.jpg 이미지를 가지고와서 img에 대입!
		
		// 프레임 닫기 버튼 누르면 이벤트 처리
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose(); 
			}
		});
		
		// 프레임 중앙에 위치시키기
		Dimension screenSize = tk.getScreenSize(); // 화면의 너비와 높이를 구함
		setBounds(screenSize.width/2-350, screenSize.height/2-350, 700, 700);

		setVisible(true); // 프레임 화면에 보이기
	}

	// paint() 호출 시점
	// 1. 화면이 보이면서 호출
	// 2. 가려졌다가 다시 보이면 호출
	// 3. 최소화 됐다가 다시 보이면 호출
	public void paint(Graphics g) { // 오버라이딩
		if(img == null) {
			return;
		}
		
		g.drawImage(img, 0, 0, this);
	}

}






