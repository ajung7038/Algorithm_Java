package Algorithm_study.week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2468 {

    static int N;
    static int[][] graph;
    static boolean[] visited;
    static int result = 0;

    // 위부터 시계 방향으로 이동
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        graph = new int[N][N];
        visited = new boolean[N*N];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if (max < graph[i][j]) max = graph[i][j];
            }
        }

        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (!visited[N*i+j] && graph[i][j] > N) {
                    DFS(i, j);
                    result++;
                }
            }
        }

        System.out.println(result);
    }

    static void DFS(int x, int y) {
        visited[N*x+y] = true;
        for (int i=0; i<4; i++) {
            int mx = x + dx[i];
            int my = y + dy[i];

            // 범위 안에 있고, 아직 방문하지 않았으며, 잠기지 않은 영역인 경우에만 DFS 호출
            if (mx >= 0 && mx < N && my >= 0 && my < N) {
                if (!visited[N*mx+my] && graph[mx][my] > N) DFS(mx, my);
            }
        }
    }
}
