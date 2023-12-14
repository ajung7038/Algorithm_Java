package JavaBasic.Lab08;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileAppender {
	static void writeToFile(FileReader from, FileWriter to) {
		int i = 0;
		try {
			// while.. 파일로 부터 하나씩 읽어옴 != -1
			while ( (i=from.read()) != -1)
				// 파일에 쓰기 (읽어온 값 int --> 쓸 값 char)
				to.write((char) i);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// Scanner 객체 생성
		Scanner scan = new Scanner(System.in);
		// File 생성자 이용하여 appended.txt 생성
		File f = new File("C:/Users/ajung/Documents/GitHub/Algorithm/JavaBasic/Lab08/appended.txt");
		// FileReader, FileWriter 선언 - 초기화:null
		FileReader fr = null;
		FileWriter fw = null;
		
		// 출력 "전체 경로명이 아닌 파일 이름만 입력하는 경우, 파일은 프로젝트 폴더에 있어야 합니다."
		System.out.println("전체 경로명이 아닌 파일 이름만 입력하는 경우, 파일은 프로젝트 폴더에 있어야 합니다.");

		// 출력 "첫번째 파일 이름을 입력하세요 >> "
		System.out.print("첫번째 파일 이름을 입력하세요 >> ");
		// 파일명1 입력
		String file1 = scan.nextLine();
		// 출력 "두번째 파일 이름을 입력하세요 >> "
		System.out.print("두번째 파일 이름을 입력하세요 >> ");
		// 파일명2 입력
		String file2 = scan.nextLine();
		try {
			// FileWriter 생성
			fw = new FileWriter(f);
			// FileReader 생성 for file1
			fr = new FileReader("C:/Users/ajung/Documents/GitHub/Algorithm/JavaBasic/Lab08/" + file1);
			// writeToFile(fileReader, fileWriter) 함수 호출
			writeToFile(fr, fw);
			// FileReader 재정의 for file2
			fr = new FileReader("C:/Users/ajung/Documents/GitHub/Algorithm/JavaBasic/Lab08/" + file2);
			// writeToFile(fileReader, fileWriter) 함수 호출.
			writeToFile(fr, fw);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 출력 "프로젝트 폴더 밑에 appended.txt 파일에 저장하였습니다"
			System.out.println("프로젝트 폴더 밑에 appended.txt 파일에 저장하였습니다");
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
