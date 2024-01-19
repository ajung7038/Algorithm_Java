package practice.JavaBasic.Lab02;

import java.util.Scanner;

public class Lab02_10 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("원의 중심 x1, y1, 반지름 radius1 >> ");
         int x1 = scan.nextInt();
         int y1 = scan.nextInt();
         int r1 = scan.nextInt();
        System.out.print("원의 중심 x2, y2, 반지름 radius2 >> ");
         int x2 = scan.nextInt();
         int y2 = scan.nextInt();
         int r2 = scan.nextInt();

         double distance = Math.sqrt(Math.pow((x2-x1), 2) + Math.pow( (y2-y1), 2));

         if (distance <= r1 + r2) {
             System.out.println("두 원은 서로 겹친다.");
         }
         else System.out.println("두 원은 서로 겹치지 않는다.");
    }
}
