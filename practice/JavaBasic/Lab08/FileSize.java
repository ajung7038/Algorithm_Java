package practice.JavaBasic.Lab08;

import java.io.File;

public class FileSize {

	public static void main(String[] args) {
		// 출력 "가장 큰 파일은 "
		System.out.print("가장 큰 파일은");
		// File 사용하여 C:/ 경로 설정
		File file = new File("C:/");
		// File 배열에 - File 로 부터 파일들의 목록 가져오기 listFiles();
		File[] files = file.listFiles();
		// size 측정 변수(long) = 0
		long size = 0;
		// 가장 큰 파일 저장할 File 변수 = null
		File bigFile = null;
		// for .. 파일들의 목록 길이만큼 {
		for (int i=0; i< files.length; i++) {
			// 파일 리스트에서 파일 하나 가져옴 File f = list에서 하나 가져오기
			File f = files[i];
			// if f 가  파일이 아니라면 --> 지나가기
			if (f.isFile() == false) continue;
			// 파일인 경우
			else {
				// 현재 size 와 파일의 size 비교 (length() 함수)
				// 지금 가진 파일의 크기가 더 크면 size 업데이트 + 가장 큰 파일 정보에도 현재 파일의 정보 넣기
				if (size < f.length()) {
					size = f.length();
					bigFile = f;
				}
				// }
			}
		}
		// 가장 큰 파일 저장할 파일 변수가 null 인 경우
		if (bigFile == null)
			// 출력 "파일은 없습니다."
			System.out.println("파일은 없습니다.");
		// 아닌 경우	
		else
			// 파일의 전체 위치 정보 (getPath 함수 사용) + 가장 큰 사이즈 + "바이트"
			System.out.print(bigFile.getPath() + " " + size + "바이트");
	}

}