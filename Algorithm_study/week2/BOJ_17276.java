package Algorithm_study.week2;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 배열 돌리기.java
 */
public class BOJ_17276 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine()); // 테스트 케이스의 수 (몇 번 반복할 건지)

        StringTokenizer st = new StringTokenizer(bf.readLine());
        int arrSize = Integer.parseInt(st.nextToken()); // 배열 크기
        int degree = Integer.parseInt(st.nextToken()); // 각도
        int[][] arr = new int[arrSize+1][arrSize+1]; // 2차원 배열


        // 테스트 케이스 반복
        for (int i=0; i<T; i++) {
            // 테이스 케이스마다 중간값이 다르므로 지역변수로 설정
            // n * n 배열이므로 중간 좌표의 x값 == y값 (하나만 설정)
            int middle = (arrSize+1)/2; // 중간 좌표 값
            int[][] newArr = new int[arrSize+1][arrSize+1]; //arr.clone(); // 값 변경 후의 2차원 배열 (결과)

            // 초기 배열 세팅 (1부터 5까지, 0은 사용 X)
            for (int j=1; j<=arrSize; j++) {
                for (int k=1; k<=arrSize; k++) {
                    // ex) (1, 1) -> 1 / (5, 5) -> 25
                    arr[j][k] = (j-1) * arrSize + k;
                    newArr[j][k] = (j-1) * arrSize + k;
                }
            }

            // 배열 원소 순회
            for (int j=1; j<=arrSize; j++) {
                for (int k=1; k<=arrSize; k++) {

                    // 주 대각선 => 열만 변화
                    // 주 대각선 확인 : 만약 (x, y)에서 x == y이면
                    if (j == k) {
                        // X의 주 대각선을 가운데 열로 옮긴다 (1번 조건)
                        newArr[j][middle] = arr[j][k];
                    }

                    // 가운데 열 => 열만 변화
                    // ex) (1, 3) -> (1, 5) / (2, 3) -> (2, 4) ... (5, 3) -> (5, 1)
                    if (k == middle) {
                        // X의 가운데 열을 부 대각선으로 옮긴다 (2번 조건)
                        newArr[j][arrSize-j+1] = arr[j][k];
                    }

                    // 부 대각선 => 행만 변화
                    // (1, 5), (2, 4), (3, 3), (4, 2), (5, 1)
                    if (j == (arrSize - k + 1)) {
                        // X의 부 대각선을 가운데 행으로 옮긴다 (3번 조건)
                        newArr[middle][k] = arr[j][k];
                    }

                    // 가운데 행 => 행만 변화
                    if (j == middle) {
                        newArr[k][k] = arr[j][k];
                    }
                }
            }

            // 출력
            for (int j=1; j<=arrSize; j++) {
                for (int k=1; k<=arrSize; k++) {
                    System.out.print(newArr[j][k] + " ");
                }
                System.out.println();
            }
        }
    }
}
