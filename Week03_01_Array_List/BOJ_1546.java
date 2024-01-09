package Week03_01_Array_List;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 성적 수
        double[] score = new double[N];
        double max = 0; // 성적 최고점
        double sum = 0; // 성적 합계

        StringTokenizer st = new StringTokenizer(br.readLine());

        // score 받기 && 최고점 찾기
        for (int i=0; i<N; i++) {
            score[i] = Integer.parseInt(st.nextToken());

            // 최고점 찾기
            if (score[i] > max)
                max = score[i];
        }

        // 평균 구하기
        for (int i=0; i<N; i++) {
            sum += score[i] / max * 100;
        }

        System.out.println(sum/N);
    }
}
