import java.awt.*; //AWT 컴포넌트 사용하기 위해 

public class Test1 {
	public static void main(String[] args) {
		Frame f = new Frame("프레임 연습입니다.");//프레임 객체 f 생성(제목표시줄 설정)
		String str ;
		
		f.setSize(700, 500); //프레임 너비700 높이 500
		f.setLocation(300,100); //프레임 시작 위치
		f.setBackground(Color.yellow);
		f.setLayout(null); //프레임의 레이아웃을 사용하지 않음(직접 좌표 설정 필요함), 프레임 기본 레이아웃은 보더레이아웃
		f.setTitle("프레임 연습입니다2");
		
		str = f.getTitle();
		System.out.println("str = " + str);
		
		Button b1 = new Button("버튼입니다"); //버튼 객체 b1 생성
		b1.setBounds(100, 100, 200, 100); //(100,100)에서 시작
		b1.setBackground(Color.gray); //버튼 배경색 설정
		b1.setForeground(Color.blue); //버튼 전경색 설정(글자색)
		b1.setLabel("바뀐버튼이지롱"); //버튼의 문자열(글자)를 변경 - 빨리 바뀌어서 안보이는 것		
		
		
		Button b2 = new Button("취소버튼입니다"); //버튼 객체 b1 생성
		b2.setBounds(100, 200, 200, 100); //(100,100)에서 시작
		b2.setBackground(Color.pink); //버튼 배경색 설정
		b2.setForeground(Color.blue); //버튼 전경색 설정(글자색)
		
		
		Choice c = new Choice(); //초이스 객체 c생성
		c.add("월요일"); c.add("화요일"); c.add("수요일");
		c.add("목요일"); c.add("금요일"); c.add("토요일"); c.add("일요일"); //초이스에 아이템 등록
		c.setBounds(300, 100, 150, 100);
		System.out.println("선택한 요일은 " +c.getItem(3)); // 0부터 시작
		
		
		List l = new List(); //리스트 객체 l생성
		l.add("월요일"); l.add("화요일"); l.add("수요일");
		l.add("목요일"); l.add("금요일"); l.add("토요일"); l.add("일요일"); //리스트에 아이템 등록
		l.setBounds(500, 100, 150, 80);
		l.setMultipleMode(true); //다중선택
		System.out.println("리스트에서 선택한 요일은 " +l.getItemCount()+ "개입니다."); // 0부터 시작
		
		
		
		System.out.println("str = " + b1.getLabel());
		
		
		
		//프레임에 컴포넌트(컴포넌트, 컨테이너 )를 붙이기
		f.add(b1); //프레임에 버튼 붙이기
		f.add(b2);
		f.add(c);
		f.add(l);
		
		
		
		f.setVisible(true); //프레임 화면에 보이게 하기
	}

}
