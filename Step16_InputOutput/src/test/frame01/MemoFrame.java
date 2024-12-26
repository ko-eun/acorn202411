package test.frame01;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MemoFrame extends JFrame{
	//생성자
	public MemoFrame(String title) {
		super(title);
		
		var topPanel=new JPanel();
		var inputMsg=new JTextField(30);
		var saveBtn=new JButton("Save");
		
		//페널에 UI 두개 추가
		topPanel.add(inputMsg);
		topPanel.add(saveBtn);
		//프레임의 레이아웃 설정
		setLayout(new BorderLayout());
		//프레임의 북쪽에 페널 배치
		add(topPanel, BorderLayout.NORTH);
		//저장 버튼에 리스너 함수 등록 
		saveBtn.addActionListener((event)->{
			//입력한 문자열 읽어오기
			String msg=inputMsg.getText();
			File f = new File("C:/Users/acorn/Desktop/playground/myFolder/memo.txt");
			
			try {
				//만일 해당 파일이 존재하지 않으면
				if(!f.exists()) {
					//새로 만들어라 
					f.createNewFile();
					System.out.println("memo.txt 파일을 만들었습니다.");
				}
				// new FileWriter(File 객체, append mode 여부 ) 
				var fw=new FileWriter(f, true);
				fw.append(msg);
				fw.append("\r\n"); //개행기호
				fw.flush(); //실제 출력
				fw.close(); //마무리
				System.out.println("memo.txt 파일에 문자열을 기록 했습니다");		
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}
	
	public static void main(String[] args) {
		var f=new MemoFrame("메모 프레임");
		f.setBounds(100, 100, 500, 500);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}


