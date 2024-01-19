package practice.JavaBasic.Lab02;

import java.util.Scanner;

public class Lab02_6 {

    public static void main (String[] args){
        // Scanner 객체 생성
        Scanner scan = new Scanner(System.in);

        System.out.print("1~99 사이의 정수를 입력하시오>>");
        int num = scan.nextInt();

        int num10 = num/10;
        int num1 = num%10;

        if ( (num10 == 3 | num10 == 6 | num10 == 9) & (num1 == 3 | num1 == 6 | num1 == 9) ) {
            System.out.println("박수짝짝");
        }
        else if ( (num10 == 3 | num10 == 6 | num10 == 9) | (num1 == 3 | num1 == 6 | num1 == 9) ) {
            System.out.println("박수짝");
        }
        else {
            System.out.println("박수없음");
        }
    }
}
