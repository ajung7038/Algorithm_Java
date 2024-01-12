package Algorithm_study.week2;

import java.io.*;

public class BOJ_1913_answer {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];
        int count = 1;

        int x = N/2;
        int y = N/2;

        int limit = 1;

        // 첫 번째 시도와 똑같지만 밖 -> 안보다는 안 -> 밖으로 구현해서 푸는 게 더 쉽다는 걸 알았다...
        // 움직이는 칸의 횟수가 11 22 33 44.. nn 이므로!
        // if로 재고 따지지 않고 그냥 한 사이클 구현
        while (true) {
            for (int i=0; i<limit; i++) {
                arr[y--][x] = count++;
            }

            // 마지막에 다다랐다면
            if (count-1 == N*N) break;

            for (int i=0; i<limit; i++) {
                arr[y][x++] = count++;
            }
            limit++;

            for (int i=0; i<limit; i++) {
                arr[y++][x] = count++;
            }

            for (int i=0; i<limit; i++){
                arr[y][x--] = count++;
            }
            limit++;
        }

        int tx=0, ty=0;
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (K == arr[i][j]) {
                    tx = i+1;
                    ty = j+1;
                }
                sb.append(arr[i][j] + " ");
            }
            sb.append("\n");
        }
        sb.append(tx+" " + ty);
        System.out.println(sb.toString());
    }
}