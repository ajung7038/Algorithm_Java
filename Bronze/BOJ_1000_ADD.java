package Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1000_ADD {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        // StringTokenizer("문자열", 구분자);
        StringTokenizer st = new StringTokenizer(str, " ");

        // nextToken() : 구분된 변수를 꺼낸다. => 문자열 반환 후 객체에서 소멸
        // int형으로 변환

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        System.out.println(A+B);
    }
}
