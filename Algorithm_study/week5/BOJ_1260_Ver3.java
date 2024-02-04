package Algorithm_study.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1260_Ver3 {

    static StringBuilder sb = new StringBuilder();
//    public static Queue<Integer> queue = new LinkedList<>();
    static int[][] graph;
    static boolean[] visited;
    static int N, M, V;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        graph = new int[N+1][N+1];

        // 그래프 설정
        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());

            graph[X][Y] = graph[Y][X] = 1;
        }

        visited = new boolean[N+1];
        DFS(V);
        sb.append("\n");

        visited = new boolean[N+1];
        BFS(V);
        System.out.println(sb);
    }

    static void DFS(int v) {
        visited[v] = true;
        sb.append(v).append(" ");

        for (int i=1; i<N+1; i++) {
            if (graph[v][i] == 1 && !visited[i]) DFS(i);
        }
    }

    static void BFS(int v) {
        Queue<Integer> queue = new LinkedList<>();
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
