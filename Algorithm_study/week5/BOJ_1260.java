package Algorithm_study.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1260 {

    static StringBuilder sb = new StringBuilder();
    public static boolean[] visited;
    public static int[][] graph;

    public static int N, M, V;
    public static Queue<Integer> queue = new LinkedList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 정점 개수
        M = Integer.parseInt(st.nextToken()); // 간선 개수
        V = Integer.parseInt(st.nextToken()); // 탐색을 시작할 정점 번호

        graph = new int[N+1][N+1];
        visited = new boolean[N+1];

        // 그래프 초기 세팅
        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x][y] = graph[y][x] = 1;
        }

        dfs(V);
        sb.append("\n");

        // visited 초기화
        visited = new boolean[N+1];
        bfs(V);

        System.out.println(sb);

    }

    public static void dfs(int v) {
        visited[v] = true;
        sb.append(v).append(" ");

        for (int i=1; i<N+1; i++) {
            if (graph[v][i] == 1 && !visited[i]) dfs(i);
        }
    }

    public static void bfs(int v) {
        queue.add(v);
        visited[v] = true;

        while (!queue.isEmpty()) {
            v = queue.poll();
            sb.append(v).append(" ");

            for (int i=1; i<N+1; i++) {
                if (graph[v][i] == 1 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}
