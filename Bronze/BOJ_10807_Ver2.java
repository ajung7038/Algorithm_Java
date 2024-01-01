package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_10807_Ver2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int b = Integer.parseInt(br.readLine());

        for (int i=0; i<N; i++) {
            if (b == arr[i]) {
                count++;
            }
        }

        System.out.println(count);

        br.close();
    }
}
