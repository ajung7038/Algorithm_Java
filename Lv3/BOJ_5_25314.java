package Lv3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_5_25314 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        N/=4;

        for (int i=0; i<N; i++) {
            System.out.print("long ");
        }
        System.out.println("int");
        br.close();
    }
}
