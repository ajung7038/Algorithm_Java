package practice.JavaBasic.Lab08;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileAppender {
	static void writeToFile(FileReader from, FileWriter to) {
		int i = 0;
		try {
			// while.. ���Ϸ� ���� �ϳ��� �о�� != -1
			while ( (i=from.read()) != -1)
				// ���Ͽ� ���� (�о�� �� int --> �� �� char)
				to.write((char) i);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// Scanner ��ü ����
		Scanner scan = new Scanner(System.in);
		// File ������ �̿��Ͽ� appended.txt ����
		File f = new File("C:/Users/ajung/Documents/GitHub/Algorithm/practice.JavaBasic/Lab08/appended.txt");
		// FileReader, FileWriter ���� - �ʱ�ȭ:null
		FileReader fr = null;
		FileWriter fw = null;
		
		// ��� "��ü ��θ��� �ƴ� ���� �̸��� �Է��ϴ� ���, ������ ������Ʈ ������ �־�� �մϴ�."
		System.out.println("��ü ��θ��� �ƴ� ���� �̸��� �Է��ϴ� ���, ������ ������Ʈ ������ �־�� �մϴ�.");

		// ��� "ù��° ���� �̸��� �Է��ϼ��� >> "
		System.out.print("ù��° ���� �̸��� �Է��ϼ��� >> ");
		// ���ϸ�1 �Է�
		String file1 = scan.nextLine();
		// ��� "�ι�° ���� �̸��� �Է��ϼ��� >> "
		System.out.print("�ι�° ���� �̸��� �Է��ϼ��� >> ");
		// ���ϸ�2 �Է�
		String file2 = scan.nextLine();
		try {
			// FileWriter ����
			fw = new FileWriter(f);
			// FileReader ���� for file1
			fr = new FileReader("C:/Users/ajung/Documents/GitHub/Algorithm/practice.JavaBasic/Lab08/" + file1);
			// writeToFile(fileReader, fileWriter) �Լ� ȣ��
			writeToFile(fr, fw);
			// FileReader ������ for file2
			fr = new FileReader("C:/Users/ajung/Documents/GitHub/Algorithm/practice.JavaBasic/Lab08/" + file2);
			// writeToFile(fileReader, fileWriter) �Լ� ȣ��.
			writeToFile(fr, fw);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// ��� "������Ʈ ���� �ؿ� appended.txt ���Ͽ� �����Ͽ����ϴ�"
			System.out.println("������Ʈ ���� �ؿ� appended.txt ���Ͽ� �����Ͽ����ϴ�");
			// fileReader != null --> fileReader.close(); with try&catch
			if (fr != null) {
				try {
					fr.close();
				} catch (IOException e) {

				}
			}
			
			// fileWriter != null --> fileWriter. close(); with try&catch
			if (fw != null) {
				try {
					fw.close();
				}
				catch(IOException e){

				}
			}
			
		}
	}

}
