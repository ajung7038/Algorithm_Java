package JavaBasic.Lab02;

import java.util.Scanner;

public class Lab02_2_5 {
    public static void main(String[] args) {
        // Scanner 객체 생성
        Scanner scan = new Scanner(System.in);

        // 정수 3개 입력
        System.out.print("정수 3개를 입력하시오 >> ");
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();

        // 세 변 중 가장 큰 수
        int max = Math.max(a, Math.max(b, c));

        if (a+b+c-max >= max) {
            System.out.println("삼각형이 됩니다");
        }
        else{
            System.out.println("삼각형을 만들 수 없습니다.");
        }
    }
}
