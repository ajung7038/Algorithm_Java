package practice.dataStructure_List;

import java.util.Scanner;

public class BOJ_2751 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 숫자를 받을 개수
        int[] nums = new int[n];
        int comp; // 정수 교환

        // 정수 저장
        for (int i=0; i<n; i++) {
            nums[i] = scanner.nextInt();
        }
        
        // 크기 비교
        for (int i = 0; i<n-1; i++) {
            for (int j = 0; j < n-1; j++) {
                if (nums[i] > nums[i + 1]) {
                    comp = nums[i];
                    nums[i] = nums[i+1];
                    nums[i+1] = comp;
                }
            }
        }

        for (int i=0; i<n; i++) {
            System.out.println(nums[i]);
        }
    }
    
}
