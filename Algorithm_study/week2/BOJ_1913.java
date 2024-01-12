package Algorithm_study.week2;

import java.io.*;

public class BOJ_1913 {

    // 접근
    // 1. N^2 크기의 2차원 배열
    // 2. 위 -> 왼쪽 -> 아래 -> 오른쪽 반복
    // 3. 다시 생각해보니 가장 왼쪽에서 안으로 들어가는 형식으로 구현하는 게 더 편할 것 같다
    //    -> 기존에는 안에서 밖으로 나가는 형태로 구현하려고 했었다
    // 4. 아래 -> 오른쪽 -> 위 -> 왼쪽
    // 5. 범위를 벗어나거나 기존에 값이 있는 경우 방향 바꾸기 -> count가 1이 될 때까지 반복
    // 6. 풀다 보니 일련의 규칙 발견
    // N-1만 3번 움직이고 나머지는 2번 움직인 후 방향을 바꿈
    // N=5인 경우 444 33 22 11, N=3인 경우 222 11, N=7인 경우 666 55 44 33 22 11


    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine()); // 홀수인 자연수 N
        int location = Integer.parseInt(br.readLine()); // 찾고자 하는 N^2 이하 자연수 위치
        int[][] arr = new int[N+1][N+1];
        int count = N*N; // 표에 들어갈 숫자
        int z = N; // 방향 바꿀 때 확인할 변수

        // 방향 (아래, 오른쪽, 위, 왼쪽)
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        int k = 0; // 위치 이동 변수 : 0, 1, 2, 3만 값으로 가진다

        // 현재 위치를 나타내는 변수
        int x = 1;
        int y = 1;

        while (count != 0) {
            // N인 경우 (1번 반복)
            if (z == N) {
                arr[1][1] = count--;
                for (int i=0; i<z-1; i++) {
                    arr[x += dx[k]][y += dy[k]] = count--;
                }
                k++;
                z--;
            }
            // 아니면 (2번 반복)
            else {
                for (int i=0; i<2; i++) {
                    for (int j=0; j<z; j++) {
                        arr[x += dx[k]][y += dy[k]] = count--;
                    }
                    // 방향 바꾸기
                    k = k==3? 0: (k+=1);
                }
                z--;
            }
        }

        // 배열 출력
        for (int i=1; i<N+1; i++) {
            for (int j=1; j<N+1; j++) {
                System.out.print(arr[i][j] + " ");
                if (arr[i][j] == location) {
                    x = i;
                    y = j;
                }
            }
            System.out.println();
        }

        // 입력받은 자연수의 좌표 출력
        System.out.print(x + " " + y);
    }
}