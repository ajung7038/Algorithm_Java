package Lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_6_2525 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int time = Integer.parseInt(br.readLine());

        time += h*60 + m;

        h = time/60;
        m = time%60;

        if (h >= 24) sb.append(h-24).append(" ").append(m);
        else sb.append(h).append(" ").append(m);

        System.out.println(sb);
    }
}
