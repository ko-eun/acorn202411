package test.frame01;

import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class TestFrame extends JFrame{
	JTextArea ta;
	File f;
	
	public TestFrame() {
		setTitle("테스트 프레임");
		setBounds(100, 100, 500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		BorderLayout layout = new BorderLayout();
		setLayout(layout);
		
		ta = new JTextArea();
		
		setVisible(true);
	}
	public static void main(String[] args) {
		new TestFrame();
	}
	
	
}
