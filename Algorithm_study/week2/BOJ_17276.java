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

            // 각도 확인 (음수인지 양수인지) && rotate
            if (degree > 0) {
                // 반복
                for (int k=0; k<rotate; k++) {
                    // 깊은 복사 -> 바뀐 arr 값이 또 바뀌지 않도록 newArr 생성
                    int newArr[][] = new int[arrSize+1][arrSize+1];

                    // 2차원 배열은 clone()으로 깊은 복사가 안 됨.
                    // 한 행마다 clone() 하거나 이중 포문으로 직접 값을 대입하는 수밖에 없다. 또는 arraycopy() 사용
                    for (int a = 1; a<=arrSize; a++) {
                        for (int b = 1; b<=arrSize; b++) {
                            newArr[a][b] = arr[a][b];
                        }
                    }

                    for (int j = 1; j <= arrSize; j++) {
                        if (k == 0) {
                            st = new StringTokenizer(br.readLine());
                        }
                        // 한 줄씩 넣어주기 -> 확인해서 arr 배열에 넣기 (결괏값)
                        // k : 여러 번 반복하는지 확인
                        clockwise(j, arrSize, st, arr, newArr, middle, k);
                    }
                }
            }
            else {
                for (int k=0; k<rotate; k++) {
                    // 깊은 복사 -> 바뀐 arr 값이 또 바뀌지 않도록 newArr 생성
                    int newArr[][] = new int[arrSize+1][arrSize+1];

                    // 2차원 배열 깊은 복사
                    for (int a = 0; a<arr.length; a++) {
                        newArr[i] = arr[i].clone();
                    }
                    
                    for (int j = 1; j <= arrSize; j++) {
                        if (k == 0) {
                            st = new StringTokenizer(br.readLine());
                        }
                        counterclockwise(j, arrSize, st, arr, newArr, middle, k);
                    }
                }
            }

            // 출력
            for (int j=1; j<=arrSize; j++) {
                for (int k=1; k<=arrSize; k++) {
                    System.out.print(arr[j][k] + " ");
                }
                System.out.println();
            }
        }

        br.close();
    }

    // 시계 방향 배열 순회
    // r : 여러 번 반복 확인
    public static void clockwise(int j, int arrSize, StringTokenizer st, int[][] arr, int[][] newArr, int middle, int r) {

        // 배열 원소 순회
        for (int k = 1; k <= arrSize; k++) {
            int num;
            if (r == 0) {
                num = Integer.parseInt(st.nextToken());
            }
            else {
                num = newArr[j][k]; // 5번 반복
            }

            // 주 대각선 => 열만 변화
            // 주 대각선 확인 : 만약 (x, y)에서 x == y이면
            if (j == k) {
                // X의 주 대각선을 가운데 열로 옮긴다 (1번 조건)
                arr[j][middle] = num;
            }

            // 가운데 열 => 열만 변화
            // ex) (1, 3) -> (1, 5) / (2, 3) -> (2, 4) ... (5, 3) -> (5, 1)
            else if (k == middle) {
                // X의 가운데 열을 부 대각선으로 옮긴다 (2번 조건)
                arr[j][arrSize - j + 1] = num;
            }

            // 부 대각선 => 행만 변화
            // (1, 5), (2, 4), (3, 3), (4, 2), (5, 1)
            else if (j == (arrSize - k + 1)) {
                // X의 부 대각선을 가운데 행으로 옮긴다 (3번 조건)
                arr[middle][k] = num;
            }

            // 가운데 행 => 행만 변화
            else if (j == middle) {
                // X의 가운데 행을 주 대각선으로 옮긴다
                arr[k][k] = num;
            }
            else {
                arr[j][k] = num;
            }
        }
    }


    // 반시계 방향 배열 순회
    public static void counterclockwise(int j, int arrSize, StringTokenizer st, int[][] arr, int[][] newArr, int middle, int r) {
        // 배열 원소 순회
        for (int k = 1; k <= arrSize; k++) {
            int num;

            if (r == 0) {
                num = Integer.parseInt(st.nextToken());
            }
            else {
                num = newArr[j][k];
            }

            // 주 대각선
            // 주 대각선 확인 : 만약 (x, y)에서 x == y이면
            if (j == k) {
                // X의 주 대각선을 가운데 행으로 옮긴다 (3번 조건)
                arr[middle][k] = num;
            }

            // 가운데 열
            // (1, 3) -> (1, 1) / (2, 3) -> (2, 2)
            else if (k == middle) {
                // X의 가운데 열을 주 대각선으로 옮긴다 (1번 조건)
                arr[j][j] = num;
            }

            // 부 대각선
            // (1, 5), (2, 4), (3, 3), (4, 2), (5, 1)
            else if (k == (arrSize - j + 1)) {
                // X의 부 대각선을 가운데 열로 옮긴다 (1번 조건)
                arr[j][middle] = num;
            }

            // 가운데 행
            // (3,1) -> (5,1) / (3, 2) -> (4, 2) ...
            else if (j == middle) {
                // X의 가운데 열을 부 대각선으로 옮긴다
                arr[arrSize - k + 1][k] = num;
            }
            else {
                arr[j][k] = num;
            }
        }
    }
}
