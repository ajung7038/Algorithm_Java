package Lv4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_8_3052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n;
        int[] remain = new int[42];

        for (int i=0; i<10; i++) {
            n = Integer.parseInt(br.readLine());
            remain[n%42] = 0;
        }
    }
}
