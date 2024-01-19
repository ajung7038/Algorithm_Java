package practice.arr;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_10810 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken()); // 바구니 개수
        int M = Integer.parseInt(st.nextToken()); // 공 넣는 횟수

        int[] basket = new int[N];

//         바구니 공 번호 초기화 (0)
        for (int i=0; i<N; i++) {
            basket[i] = 0;
        }

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(bf.readLine());
            // i번 인덱스부터 j번 인덱스까지 k 삽입
            int startIndex = Integer.parseInt(st.nextToken());
            int lastIndex = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            for (int j=startIndex-1; j<lastIndex; j++) {
                basket[j] = value;
            }
        }

        // 출력
        for (int i = 0; i<basket.length; i++) {
            bw.write(basket[i] + " ");
        }

        bf.close();
        bw.flush();
        bw.close();
    }
}
