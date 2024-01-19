package practice.JavaBasic.Lab03;

import java.util.Scanner;

public class Lab03_4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("소문자 알파벳 하나를 입력하시오>>");
        String c = scan.next();

        if (c.length() != 1) {
            System.out.println("알파벳 하나만 입력해야 합니다!");
        }
        else if (c.charAt(0) >= 'a' && c.charAt(0) <= 'z') {
            for (int i=c.charAt(0)-'a'+1; i>0; i--) {
                for (int j=0; j<i; j++) {
                    //System.out.print((j+'a').);
                }
                System.out.print("\n");
            }
        }

        else {
            System.out.println("소문자 알파벳이 아닙니다.");
        }
    }
}
