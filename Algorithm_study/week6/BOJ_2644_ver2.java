package Algorithm_study.week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_2644_ver2 {

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean visited[];

    static int N; // 전체 사람 수 == 노드 수
    static int p2; // 찾을 사람
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i <= N ; i++) {
            graph.add(new ArrayList<>());
        }

        st = new StringTokenizer(br.readLine());
        visited = new boolean[N+1];

        int p1 = Integer.parseInt(st.nextToken());
        p2 = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine()); // 간선의 수

        for (int i = 0; i < m ; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        int count = 0;
        dfs(p1,count);

        System.out.println(result != 0 ? result : -1);
    }


    static void dfs(int index,int count){

        visited[index] = true;
        for (int temp : graph.get(index)){
            if(!visited[temp]){
                if(p2 == temp){
                    result = count+1;
                    return;
                }

                dfs(temp,count+1);
            }
        }
    }
}
