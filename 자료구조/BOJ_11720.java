package 자료구조;

import java.util.Scanner;

public class BOJ_11720 {
    // 숫자의 합 구하기
    // -- 입력 --
    // 숫자의 개수
    // 공백 없이 주어진 N개의 숫자

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int count = scan.nextInt(); // 숫자의 개수
        String num = scan.next(); // 공백 없이 주어진 숫자
        
        int sum = 0; // 숫자 합
        
        char numArr[] = num.toCharArray(); // 문자 배열 생성

        for (int i=0; i<numArr.length; i++) {
            sum += numArr[i] - '0';
        }

        System.out.println(sum);
    }
}
