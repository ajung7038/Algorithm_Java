package practice.JavaBasic.Lab02;

import java.util.Scanner;

public class Lab02_8 {

    public static void main(String[] args) {
        // Scanner 객체 생성
        Scanner scan = new Scanner(System.in);

        System.out.print("x1, y1 입력>>");
        int x1 = scan.nextInt();
        int y1 = scan.nextInt();

        System.out.print("x2, y2 입력>>");
        int x2 = scan.nextInt();
        int y2 = scan.nextInt();

        if ( x1 > 200 || x2 < 100 || y1 > 200 || y2 < 100 ) {
            System.out.println("충돌 없음");
        }
        else {
            System.out.println("충돌 발생");
        }
    }
}
