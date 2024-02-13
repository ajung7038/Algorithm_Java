package Algorithm_study.week6;

import java.util.Arrays;

class programmers_1844 {
    static int answer = 0;
    static int count = 0;

    // �Ʒ�, ������, ��, ����
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};


    static boolean[][] visited;

    public static void main(String[] args) {
        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
        boolean[][] visited = new boolean[101][101];

        for (boolean[] booleans : visited) {
            Arrays.fill(booleans, false);
        }

        dfs(maps, visited, 1, 1);
        System.out.println(answer);
    }

    public static void dfs(int[][] maps, boolean[][] visited, int x, int y) {
        // �湮 ó��, count++, (5, 5)�� ��� result = count
        System.out.println(visited[x][y]);
        visited[x][y] = true;
        count++;
        if (x == 5 & y == 5) answer = count;

        // �����¿� ���鼭 ����Լ� ȣ�� (1 && !visited && ������ ����� �ʴ� ���)
        for (int i = 0; i < 4; i++) {
            if (maps[dx[i] + x][dy[i] + y] != -1 && visited[dx[i] + x][dy[i]+y] && maps[x][y]==1)
                dfs(maps, visited, dx[i] + x, dy[i] + y);
        }
    }
}

