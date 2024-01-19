package practice.JavaBasic.Lab03;

import java.util.Scanner;

public class MultiplesOfThree {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] nums = new int[10];

        System.out.print("양의 정수 10개를 입력하시오 >> ");
        for (int i=0; i < 10; i++) {
            nums[i] = scan.nextInt();
        }

        System.out.print("3의 배수는 ");

        for (int i=0; i<nums.length; i++) {
            if (nums[i] % 3 == 0) {
                System.out.print(nums[i] + " ");
            }
        }
    }
}
