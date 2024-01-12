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

        // ù ��° �õ��� �Ȱ����� �� -> �Ⱥ��ٴ� �� -> ������ �����ؼ� Ǫ�� �� �� ���ٴ� �� �˾Ҵ�...
        // �����̴� ĭ�� Ƚ���� 11 22 33 44.. nn �̹Ƿ�!
        // if�� ��� ������ �ʰ� �׳� �� ����Ŭ ����
        while (true) {
            for (int i=0; i<limit; i++) {
                arr[y--][x] = count++;
            }

            // �������� �ٴٶ��ٸ�
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