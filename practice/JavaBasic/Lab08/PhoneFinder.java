package practice.JavaBasic.Lab08;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class PhoneFinder {

	public static void main(String[] args) {
		// Scanner ��ü ����
		Scanner scanner = new Scanner(System.in);
		// HashMap ��ü ���� 
		HashMap<String, String> hashMap = new HashMap<String, String>();
		// File - "C:/classJava/2000000_JAVA/Lab08/phone.txt" ����
		File f = new File("C:/Users/ajung/Documents/GitHub/Algorithm/practice.JavaBasic/Lab08/phone.txt");
		// FileReader ���� - �ʱ�ȭ:null
		FileReader fr = null;
		try {
			// fileReader �� file �о����
			fr = new FileReader(f);
			// Scanner �̿��ؼ� File �ٷ� �о����
			// hint --> System.in to fileReader
			Scanner fs = new Scanner(fr);
			// while ... scanner ��.hasNext() {
			while (fs.hasNext()) {
				// name = scanner.next() �� �ޱ�
				String name = fs.next();
				// tel = scanner.next() �� �ޱ�
				String tel = fs.next();
				// hashMap �� �ֱ� (name, tel)
				hashMap.put(name, tel);
				// }
			}
			// scanner �ݱ�
			fs.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// ��� "�� " + hashMap.size() + "���� ��ȭ��ȣ�� �о����ϴ�."
			System.out.println("�� " + hashMap.size() + "���� ��ȭ��ȣ�� �о����ϴ�.");
		}

		// while(true){
		while (true) {
			// ��� "�̸� >> "
			System.out.print("�̸� >> ");
			// �̸� �Է�
			String name = scanner.next();

			// �̸� == "�׸�" ? break;
			if (name.equals("�׸�")) break;
			// hashMap���� �޾ƿ� �̸����� �˻� != null
			if (hashMap.get(name) != null)
				// hashMap���� ���� �޾ƿͼ� ��� "��ȭ��ȣ : " + hashMap.get(name)
				System.out.println("��ȭ��ȣ : " + hashMap.get(name));
			// else (==null)
			else
				// ��� "ã�� �̸��� �����ϴ�."
				System.out.println("ã�� �̸��� �����ϴ�.");
			//}
		}
		// scanner �ݱ�
		scanner.close();
	}
}