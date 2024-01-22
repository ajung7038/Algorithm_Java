package Lv4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_6_10813 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int [N];

        int a, b, comp;

        // 배열에 원소 삽입
        for (int i=0; i<N; i++) arr[i] = i+1;

        // 공 교환
        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            comp = arr[a-1];
            arr[a-1] = arr[b-1];
            arr[b-1] = comp;
        }

        for (int i : arr) System.out.print(i + " ");
    }
}
