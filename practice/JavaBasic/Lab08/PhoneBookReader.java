package practice.JavaBasic.Lab08;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class PhoneBookReader {

	public static void main(String[] args) {
		// File ���� - ���� ���� (���� ��ũ�����̽��� �°�): "C:/classJava/2000000_JAVA/Lab08/phone.txt"
		File f = new File("C:/Users/ajung/Documents/GitHub/Algorithm/practice.JavaBasic/Lab08/phone.txt");
		// FileReader ���� - �ʱ�ȭ:null
		FileReader fr = null;
		// ���ڸ� �о�� ���� -> �ʱ�ȭ:0
		int c = 0;
		try {
			// FileReader ����ؼ� file �о����
			fr = new FileReader(f);
			// while ... fileReader ���� �о�� �� (read) �� != -1
			while ((c=fr.read()) != -1) {
				// ȭ�鿡 ��� (int to char)
				System.out.print((char)c);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// fileReader != null --> fileReader.close() with try&catch
			try {
				if (fr != null)
					fr.close();
			}
			catch (IOException e){

			}
			
		}
	}

}