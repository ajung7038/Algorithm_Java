package Algorithm_study.week2;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 배열 돌리기.java
 */
public class BOJ_17276 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 수 (몇 번 반복할 건지)

        // 테스트 케이스 반복
        for (int i=0; i<T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 테스트 케이스마다 값이 다르므로 지역변수로 설정
            int arrSize = Integer.parseInt(st.nextToken()); // 배열 크기
            int degree = Integer.parseInt(st.nextToken()); // 각도
            int[][] arr = new int[arrSize+1][arrSize+1]; // 2차원 배열
            int rotate = Math.abs(degree) / 45; // 회전 수

            // n * n 배열이므로 중간 좌표의 x값 == y값 (하나만 설정)
            int middle = (arrSize+1)/2; // 중간 좌표 값
            int[][] newArr = new int[arrSize+1][arrSize+1]; // 값 변경 후의 2차원 배열 (결과)

            // 초기 배열 세팅 (1부터 5까지, 0은 사용 X)
            for (int j=1; j<=arrSize; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k=1; k<=arrSize; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                    newArr[j][k] = (j-1) * arrSize + k;
                }
            }

            // 각도 확인 (음수인지 양수인지) && rotate
            if (degree > 0) {
                clockwise(arrSize, arr, newArr, middle, rotate);
            }
            else {
                counterclockwise(arrSize, arr, newArr, middle, rotate);
            }

            // 출력
            for (int j=1; j<=arrSize; j++) {
                for (int k=1; k<=arrSize; k++) {
                    System.out.print(newArr[j][k] + " ");
                }
                System.out.println();
            }
        }

        br.close();
    }

    // 시계 방향 배열 순회
    public static int[][] clockwise(int arrSize, int[][] arr, int[][] newArr, int middle, int rotate) {

        // 반복
        for (int i=0; i<rotate; i++) {
            // 배열 원소 순회
            for (int j = 1; j <= arrSize; j++) {
                for (int k = 1; k <= arrSize; k++) {

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
                        newArr[j][arrSize - j + 1] = arr[j][k];
                    }

                    // 부 대각선 => 행만 변화
                    // (1, 5), (2, 4), (3, 3), (4, 2), (5, 1)
                    if (j == (arrSize - k + 1)) {
                        // X의 부 대각선을 가운데 행으로 옮긴다 (3번 조건)
                        newArr[middle][k] = arr[j][k];
                    }

                    // 가운데 행 => 행만 변화
                    if (j == middle) {
                        // X의 가운데 행을 주 대각선으로 옮긴다
                        newArr[k][k] = arr[j][k];
                    }
                }
            }
        }
        return newArr;
    }


    // 반시계 방향 배열 순회
    public static int[][] counterclockwise(int arrSize, int[][] arr, int[][] newArr, int middle, int rotate) {
        // 반복
        for (int i=0; i<rotate; i++) {
            // 배열 원소 순회
            for (int j = 1; j <= arrSize; j++) {
                for (int k = 1; k <= arrSize; k++) {

                    // 주 대각선
                    // 주 대각선 확인 : 만약 (x, y)에서 x == y이면
                    if (j == k) {
                        // X의 주 대각선을 가운데 행으로 옮긴다 (3번 조건)
                        newArr[middle][k] = arr[j][k];
                    }

                    // 가운데 열
                    // (1, 3) -> (1, 1) / (2, 3) -> (2, 2)
                    if (k == middle) {
                        // X의 가운데 열을 주 대각선으로 옮긴다 (1번 조건)
                        newArr[j][j] = arr[j][k];
                    }

                    // 부 대각선
                    // (1, 5), (2, 4), (3, 3), (4, 2), (5, 1)
                    if (k == (arrSize - j + 1)) {
                        // X의 부 대각선을 가운데 열로 옮긴다 (1번 조건)
                        newArr[j][middle] = arr[j][k];
                    }

                    // 가운데 행
                    // (3,1) -> (5,1) / (3, 2) -> (4, 2) ...
                    if (j == middle) {
                        // X의 가운데 열을 부 대각선으로 옮긴다
                        newArr[arrSize - k + 1][k] = arr[j][k];
                    }
                }
            }
        }
        return newArr;
    }

}
