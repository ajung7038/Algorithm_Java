package JavaBasic.Lab02;

import java.util.Scanner;

public class Lab02_2 {
    public static void main(String[] args) {
        // Scanner 객체 생성
        Scanner scan = new Scanner (System.in);

        System.out.print("2자리수 정수 입력(10~99)>>");
        // 2자리 정수 입력 받기
        int num = scan.nextInt();

        // 십의 자리와 일의 자리가 같은지 확인
        if (num/10 == num%10) {
            System.out.println("Yes! 10의 자리와 1의 자리가 같습니다");
        }
        else {
            System.out.println("No! 10의 자리와 1의 자리가 다릅니다");
        }
    }
}
