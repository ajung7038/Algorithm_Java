package practice.dataStructure_List;

import java.util.Scanner;

public class BOJ_1546 {
    
    // 평균 구하기

    /*
    -- 입력 --
     시험을 본 과목의 개수
     각 과목의 시험 성적
    */
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int count = scan.nextInt(); // count : 시험을 본 과목의 개수
        int numArr[] = new int[count]; // scanner (배열) : 각 과목의 시험 성적
        int maxSc = 0; // maxSc : max 값 저장 변수 선언
        double sum = 0; // sum : 평균을 구하기 위한 합
        
        // max 값 구하기
        for (int i = 0; i<count; i++) {
            numArr[i] = scan.nextInt();
            if (numArr[i]>maxSc) {
                maxSc = numArr[i];
            }
        }

        for (int i=0; i<count; i++) {
            // sum = (double)시험 성적/maxSc*100 * 캐스팅 필수 *
            sum += (double)numArr[i]/maxSc * 100;
        }
         System.out.println(sum/count);
    }
}
