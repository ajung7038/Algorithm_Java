package Algorithm_study.week7;

import java.util.*;
import java.io.*;

public class BOJ_2468 {
    static List<Integer> list = new ArrayList<>();
    static int[] dx = {0, 0, -1, 1}; // 상 하 좌 우
    static int[] dy = {-1, 1, 0, 0}; // 상 하 좌 우
    static boolean[][] visit;
    static int[][] arr;

    static int N, nowX, nowY;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        // 배열 넣기
        arr = new int[N][N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                // 각 안전 영역의 높이를 저장한다
                if( !list.contains(arr[i][j])) {
                    list.add(arr[i][j]);
                }
            }
        }

        // 메모리 줄이기
        int max = Integer.MIN_VALUE / 16;

        // 안전 영역 계산
        for(int num : list) {
            visit = new boolean[N][N];
            int safeArea = 0;

            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {

                    // 방문 X && 안전 영역인 경우
                    if( !visit[i][j] && arr[i][j] >= num) {
                        DFS(i, j, num);
                        safeArea++;
                    }
                }
            }

            max = Math.max(max, safeArea);
        }

        System.out.println(max);
    }

    static void DFS(int x, int y, int num) {
        visit[x][y] = true;

        for(int i=0; i<4; i++) {
            nowX = x + dx[i];
            nowY = y + dy[i];

            // 범위 안 존재 && 방문 X, 안전 영역
            if(range_check() && !visit[nowX][nowY] && arr[nowX][nowY] >= num) {
                DFS(nowX, nowY, num);
            }
        }

    }

    static boolean range_check() {
        return (nowX >= 0 && nowY >= 0 && nowX < N && nowY < N);
    }

}