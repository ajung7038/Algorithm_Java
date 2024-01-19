package practice.Bronze;

import java.util.Scanner;

public class BOJ_10807 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt(); // 정수의 개수
        int[] num = new int[N]; // 정수 값
        int v; // 찾고자 하는 정수의 값
        int count = 0; // v의 개수

        for (int i=0; i<N; i++) {
            num[i] = scan.nextInt();
        }

        v = scan.nextInt(); // v값 받아오기

        for (int i=0; i<N; i++) {
            if (num[i] == v)
                count ++;
        }

        System.out.println(count);
    }
}
