package Algorithm_study.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 인접 리스트로 구현
public class BOJ_1260_Ver4 {
    static LinkedList<Integer>[] graph;
    static StringBuilder sb = new StringBuilder();
    static int N, M, V;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        graph = new LinkedList[N+1];

        for (int i=0; i<N+1; i++) {
            graph[i] = new LinkedList<>();
        }

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());

            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());

            graph[X].add(Y);
            graph[Y].add(X);
        }

        // 오름차순
        for (int i=0; i<N; i++) {
            Collections.sort(graph[i]);
        }

        visited = new boolean[N+1];
        DFS(V);
        sb.append("\n");

        visited = new boolean[N+1];
        BFS(V);

        System.out.println(sb);
    }

    static void DFS (int v) {
        visited[v] = true;
        sb.append(v).append(" ");

        for (int i : graph[v]) {
            if (!visited[i]) DFS(i);
        }
    }

    static void BFS (int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visited[v] = true;

        while(!queue.isEmpty()) {
            v = queue.poll();
            sb.append(v).append(" ");

            for (int i : graph[v]) {
                if (!visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}
