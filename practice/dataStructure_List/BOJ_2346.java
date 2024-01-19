package practice.dataStructure_List;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

// 풍선의 인덱스와 숫자 값을 저장하는 클래스 Balloon
class Balloon {
    int index;
    int numValue;

    public Balloon(int index, int numValue) {
        this.index = index;
        this.numValue = numValue;
    }
}

public class BOJ_2346 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Deque<Balloon> queue = new ArrayDeque<>();

        int N = Integer.parseInt(br.readLine()); // 풍선의 개수
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] balloonLocation = new int[N];
        for (int i=0; i< N; i++) {
            balloonLocation[i] = Integer.parseInt(st.nextToken());
        }

        br.close();
        sb.append("1 "); // 첫 번째 풍선 터뜨리기
        int moveValue = balloonLocation[0]; // 이동 값

        // 인덱스 값과 인덱스가 가지고 있는 이동 값을 함께 넣기
        for (int i =1; i<N; i++) {
            queue.add(new Balloon(i + 1, balloonLocation[i]));
        }

        while(!queue.isEmpty()) {
            // 양수인 경우
            if (moveValue > 0) {
                // 앞에 있는 요소를 모두 뒤로 보내기
                for (int i =1; i<moveValue; i++) {
                    queue.add(queue.poll());
                }
                // 모두 뒤로 보냈다면
                Balloon next = queue.poll();
                moveValue = next.numValue; // 이동값 갱신
                sb.append(next.index+" "); // 터뜨린 풍선의 위치값 출력 목록에 저장
            }

            // 음수일 경우
            else{
                // 뒤에 있는 요소를 모두 앞으로 보내기
                for (int i = 1; i< -moveValue; i++) {
                    queue.addFirst(queue.pollLast());
                }

                // 모두 뒤로 보냈다면
                Balloon next = queue.pollLast();
                moveValue = next.numValue;
                sb.append(next.index+" ");
            }
        }
        System.out.println(sb);
    }
}

