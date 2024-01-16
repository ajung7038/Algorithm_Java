package Algorithm_study.week2;

import java.io.*;

public class BOJ_1193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 출력 예시 : 1 -> 1/1
        int X = Integer.parseInt(br.readLine());
        br.close();

        int squareCount = 1;
        int squareSum = 0; // 해당 대각선의 전 대각선 칸 누적 변수

        while (true) {
            if (X <= squareSum + squareCount) {
                if (squareCount % 2 == 1) {
                    System.out.println((squareCount - (X - squareSum - 1) + "/" + (X - squareSum)));
                    break;
                } else {
                    System.out.println((X - squareSum) + "/" + (squareCount - (X - squareSum - 1)));
                    break;
                }
            } else {
                squareSum += squareCount;
                squareCount++;
            }
        }
    }
}
