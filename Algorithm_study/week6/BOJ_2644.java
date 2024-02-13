package Algorithm_study.week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_2644 {

    static LinkedList<Integer>[] graph;
    static boolean[] visited;
    static int p1;
    static int p2;
    static int count = -1;
    static int result = 0;
    static boolean found = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 전체 사람 수 == 노드 수
        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        p1 = Integer.parseInt(st.nextToken());
        p2 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        // 부모-자식 간 관계 수 == 간선의 수
        int m = Integer.parseInt(st.nextToken());

        graph = new LinkedList[n+1];

        for (int i=0; i<n+1; i++) {
            graph[i] = new LinkedList<>();
        }

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x].add(y);
            graph[y].add(x);
        }

        visited = new boolean[n+1];
        dfs(p1);
        System.out.println(found? result+1 : -1);
    }

    static void dfs(int v) {
        visited[v] = true;
        count++;
        for (int i : graph[v]) {
            if(i==p2) {
                found = true;
                result = count;
                return;
            }

            if (!visited[i]) dfs(i);
        }
    }
}
