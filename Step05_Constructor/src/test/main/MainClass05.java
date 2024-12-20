package test.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MainClass05 {
	public static void main(String[] args) throws FileNotFoundException {
		
		File f=new File("src/test/mypac/memo.txt");
		Scanner scan=new Scanner(f);
		while(true) {
			String line=scan.nextLine();
			System.out.println(line);
		}
	}
}
