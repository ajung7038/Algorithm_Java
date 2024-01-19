package practice.arr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10818 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine()); // ���� ����
        int[] nums = new int[N]; // ���� ���� �迭

        StringTokenizer st = new StringTokenizer(bf.readLine());

        
        // ���� ����
        for (int i=0; i<N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int max = nums[0]; // �ִ�
        int min = nums[0]; // �ּڰ�

        // �ִ�, �ּڰ� Ȯ��
        for (Integer i : nums) {
            if (max < i)
                max = i;
            if (min > i)
                min = i;
        }

        // �ִ�, �ּڰ� ���
        System.out.print(min + " " + max);
    }
}
