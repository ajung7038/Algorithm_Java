package practice.JavaBasic.Lab08;

import java.io.File;

public class FileSize {

	public static void main(String[] args) {
		// ��� "���� ū ������ "
		System.out.print("���� ū ������");
		// File ����Ͽ� C:/ ��� ����
		File file = new File("C:/");
		// File �迭�� - File �� ���� ���ϵ��� ��� �������� listFiles();
		File[] files = file.listFiles();
		// size ���� ����(long) = 0
		long size = 0;
		// ���� ū ���� ������ File ���� = null
		File bigFile = null;
		// for .. ���ϵ��� ��� ���̸�ŭ {
		for (int i=0; i< files.length; i++) {
			// ���� ����Ʈ���� ���� �ϳ� ������ File f = list���� �ϳ� ��������
			File f = files[i];
			// if f ��  ������ �ƴ϶�� --> ��������
			if (f.isFile() == false) continue;
			// ������ ���
			else {
				// ���� size �� ������ size �� (length() �Լ�)
				// ���� ���� ������ ũ�Ⱑ �� ũ�� size ������Ʈ + ���� ū ���� �������� ���� ������ ���� �ֱ�
				if (size < f.length()) {
					size = f.length();
					bigFile = f;
				}
				// }
			}
		}
		// ���� ū ���� ������ ���� ������ null �� ���
		if (bigFile == null)
			// ��� "������ �����ϴ�."
			System.out.println("������ �����ϴ�.");
		// �ƴ� ���	
		else
			// ������ ��ü ��ġ ���� (getPath �Լ� ���) + ���� ū ������ + "����Ʈ"
			System.out.print(bigFile.getPath() + " " + size + "����Ʈ");
	}

}