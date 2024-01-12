package Algorithm_study.week2;

import java.io.*;

public class BOJ_1193 {
    public static void main(String[] args) throws IOException {
        // 2차원 배열
        // (i, j)에서 i == 1이면 오른쪽으로 이동
        // (i, j)에서 j == 1이면 아래로 이동
        // else : i--, j++ (1이 나올 때까지)

        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        Long[][] board = new Long[10000000][10000000];

        for (int i=1; i<=X; i++) {
            for (int j=1; j<=X; j++) {
                if (i == 1) {
                    j += 1;
                }
                else if (j == 1) {
                    i += 1;
                }
                else {
                    i--;
                    j++;
                }
            }
        }
    }
}
