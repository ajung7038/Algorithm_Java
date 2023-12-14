package JavaBasic.Lab08;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PhoneBookWriter {

	public static void main(String[] args) {
		// Scanner 객체 선언
		Scanner scan = new Scanner(System.in);
		// File 생성 - "C:/classJava/2000000_JAVA/Lab08/phone.txt" --> 본인 워크스페이스에 맞게 설정
		File f = new File("C:/Users/ajung/Documents/GitHub/Algorithm/JavaBasic/Lab08/phone.txt");
		// FileWriter 선언 - 초기화:null
		FileWriter fw = null;
		try {
			// 출력 "전화번호 입력 프로그램입니다."
			System.out.println("전화번호 입력 프로그램입니다.");
			// fileWriter 사용해서 file 읽어오기
			fw = new FileWriter(f);
			// while(true){
			while (true) {
				// 출력 "이름 전화번호 >>"
				System.out.print("이름 전화번호 >>");
				// 입력 받기 nextLine
				String s = scan.nextLine();
				// 입력 값 == "그만" --> break;
				if (s.equals("그만")) break;
				// fileWriter에 받아온 값 + "\n" 쓰기
				fw.write(s + '\n');
				// }
			}
			// 출력 "C:/classJava/2000000_JAVA/Lab08/phone.txt 에 저장하였습니다." --> 본인 워크스페이스에 맞게
			System.out.println("C:/Users/ajung/Documents/GitHub/Algorithm/JavaBasic/Lab08/phone.txt 에 저장하였습니다.");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// fileWriter != null --> fileWriter.close() & Scanner close()  with try&catch
			if (fw != null) {
				try {
					fw.close();
					scan.close();
				}
				catch(IOException e){

				}
			}
		}
	}

}
