package Lv4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3_10818 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int arrNum1 = Integer.parseInt(st.nextToken());

        int max = arrNum1;
        int min = arrNum1;

        for (int i = 0; i < N - 1; i++) {
            int num = Integer.parseInt(st.nextToken());

            if (max < num) max = num;
            if (min > num) min = num;
        }
        System.out.println(min + " " + max);
    }
}
