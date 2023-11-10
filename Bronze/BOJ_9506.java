package Bronze;

import java.util.Scanner;

public class BOJ_9506 {

    // n이 완전수인지 아닌지 판다내주는 프로그램
    /*
    nums : 입력 받은 숫자 저장 배열
    int i = 0;
    while (nums != -1) {
        nums[i] = scan.nextInt();
    }

    sum : 약수들의 합
    pn : 완전수 배열
    for (int j=1; j<n; j++) {
        if (n%j == 0) {
            sum += j;
        }
    }

    -- for문으로 돌리기 --
    if (sum == n) {
        배열에서 꺼내기 -> 6 = 1 + 2 + 3
    }
    else {
        System.out.println("nums[i] is NOT perfect.");
    }
     */
    public static void main(String[] args) {
        int[] nums = new int[100];
        int i = 0;
        Scanner scan = new Scanner(System.in);
        while ((nums[i] = scan.nextInt()) != -1) {
            i++;
        }

        int sum = 0; // 약수들의 합
        int[] pn = new int[100]; // 완전수일 경우 숫자 저장 배열

        // nums 배열 길이만큼 돌기
        for (int j=0; j<nums.length; j++) {
            int p = 0; // pn 배열 저장
            // 약수 구하기
            for (int k=1; k<nums[j]; k++) {
                if (nums[j]%k == 0) {
                    sum += j;
                    pn[p++] = k;
                }
            }

            // 약수인지 확인
            if (sum == nums[j]) {
                System.out.print(nums[j] + " = ");
                for (int k=0; k<pn.length; k++) {
                    System.out.print(pn[k]);
                    if (k < pn.length-1) {
                        System.out.print(" + ");
                    }
                }
            } else {
                System.out.println(nums[j] + " is NOT perfect.");
            }
        }
    }
}
