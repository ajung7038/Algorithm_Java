package JavaBasic.Lab02;

import java.util.Scanner;

public class Lab02_2_3 {
    public static void main(String[] agrs) {
        // Scanner 객체 생성
        Scanner scan = new Scanner(System.in);
        System.out.print("금액을 입력하시오 >>");
        // 돈의 액수를 입력 받는다
        int money = scan.nextInt();

        // 오만 원권, 만 원권, 천 원권, 500원짜리 동전, 100원짜리 동전, 50원짜리 동전, 10원짜리 동전, 1원짜리 동전으로 변환
        System.out.println("오만원권 " + money/50000 + "매");
        money = money % 50000;

        System.out.println("만원권 " + money/10000 + "매");
        money = money % 10000;

        System.out.println("천원권 " + money/1000 + "매");
        money = money % 1000;

        System.out.println("오백원 " + money/500 + "개");
        money = money % 500;

        System.out.println("백원 " + money/100 + "개");
        money = money % 100;

        System.out.println("오십원 " + money/50 + "개");
        money = money % 50;

        System.out.println("십원 " + money/10 + "개");
//        money = money % 10;

        System.out.println("일원 "+ money%10 + "개");
    }
}
