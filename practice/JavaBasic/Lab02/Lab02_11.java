package practice.JavaBasic.Lab02;

import java.util.Scanner;

public class Lab02_11 {
    
    public static void main (String[] args) {
        // scanner 객체 생성
        Scanner scan = new Scanner(System.in);

        // 계절 입력
        int season = scan.nextInt();

        switch (season) {
            case 3:
            case 4:
            case 5:
                System.out.println("봄");
                break;
            case 6:
            case 7:
            case 8:
                System.out.println("여름");
                break;
            case 9:
            case 10:
            case 11:
                System.out.println("가을");
                break;
            case 12:
            case 1:
            case 2:
                System.out.println("겨울");
                break;
            default:
                System.out.println("잘못입력");
                break;
        }
    }
}
