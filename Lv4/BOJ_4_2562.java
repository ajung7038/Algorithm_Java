package Lv4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_4_2562 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int idx = 0;

        int max = Integer.parseInt(br.readLine());

        for (int i=1; i<9; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num > max) {
                max = num;
                idx = i;
            }
        }
        System.out.println(max);
        System.out.println(idx+1);
        br.close();
    }
}
