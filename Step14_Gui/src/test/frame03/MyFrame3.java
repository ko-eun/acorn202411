package test.frame03;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame3 extends JFrame implements ActionListener{
	// 필드
	int count;
	JButton countBtn;
	
	// 생성자 
	public MyFrame3() {
		// 프레임 제목 설정
		this.setTitle("나의 프레임");
		// 프레임의 위치와 크기 설정 setBounds(x, y, width, height);
		this.setBounds(100, 100, 500, 500);
		// 종료 버튼을 눌렀을 때 프로세스 전체가 종료되도록 한다.
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//레이아웃 매니저 객체 생성
		FlowLayout layout = new FlowLayout(FlowLayout.CENTER);
		// 프레임의 레이아웃 매니저 설정
		setLayout(layout);
		// JButton 객체 생성
		countBtn = new JButton("0");
		// 프레임의 add() 메소드 호출하면서 JButton 객체의 참조값을 전달하면 프레임에 버튼이 배치된다.
		add(countBtn);
		
		// MyFrame3 클래스는 implements ActionListener 인터페이스를 구현했기 때문에 this 전달 가능
		countBtn.addActionListener(this);
		
		// 화면상에 실제 보이도록 한다.
		setVisible(true);
	}
	// main 메소드
	public static void main(String[] args) {
		new MyFrame3();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("버튼을 눌렀네?");
		count++;
		countBtn.setText(Integer.toString(count));
	}
}
