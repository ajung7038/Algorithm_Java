package practice.Bronze;

import java.util.Scanner;

public class BOJ_10811 {
//    public static void main(practice.String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        // N과 M 받기
//        int N = scanner.nextInt(); // 바구니 수
//        int M = scanner.nextInt(); // 반복 횟수
//
//        int num; // 교환 숫자
//
//        int [] basket = new int[N];
//        int [][] basketIdx = new int[M+1][2];
//
//
//        // 수 입력 받기
//        for (int i=0; i<M; i++) {
//            for (int j=0; j<2; j++) {
//                basketIdx[i][j] = scanner.nextInt();
//            }
//        }
//
//        // basket 배열 생성
//        for (int i=0; i<N; i++) {
//            basket[i] = i+1;
//        }
//
//        // 순서 바꾸기
//        for (int i=1; i<=M; i++) {
//        }
//    }
    // ---------------------------------------

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] arr = new int[N];
        for ( int i=0; i<N; i++) {
            arr[i] = i+1;
        }

        for (int i=0; i<M; i++) {
            int left = sc.nextInt() -1;
            int right = sc.nextInt() -1;

            while (left < right) {
                int temp = arr[left];
                arr[left++] = arr[right];
                arr[right--] = temp;
            }
        }
        sc.close();
        for (int basket:arr)
            System.out.print(basket + " ");
    }
}
