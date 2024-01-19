package practice.dataStructure_List;

import java.util.Scanner;

public class BOJ_2941 {
    public static void main(String[] args) {

//        int count = 0; // 크로아티아 알파벳 개수
//
//        // 크로아티아 알파벳 : c=, c-, dz=, d-, lj, nj, s=, z=
//        // List로 바꾼 후 contains() 메소드 사용
//        practice.String[] c = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
//        List<practice.String> cList = new ArrayList<>(Arrays.asList(c));
//
//        // 문자열 읽어오기
//        Scanner scanner = new Scanner(System.in);
//        practice.String alpha = scanner.next();
//        int initLen = alpha.length();
//
//        for (int i=0; i<initLen; i++) {
//            int index = cList.indexOf(alpha); // 바꿀 크로아티아 알파벳 위치
//            int len = c[index].length(); // 크로아티아 알파벳 길이
//
//            // 바꿀 크로아티아 알파벳이 존재
//            if (index != -1) {
//                // count 증가
//                count += 1;
//                // alpha 삭제 (크기가 2인 경우, 크기가 3인 경우)
//                alpha = alpha.replaceAll(alpha.substring(index, len), "");
//            }
//            // 나머지 경우
//            else {
//                // 문자열 길이만큼 count 증가
//                count += len;
//            }
//        }
//
//        System.out.println(count);

        // ---------------------------------------- //
        Scanner sc = new Scanner(System.in);
        String str[] = {"c=", "c=", "dz=", "d-", "lj", "nj", "s=", "z="};

        String st = sc.nextLine();

        for (int i=0; i<str.length; i++) {
            if (st.contains(str[i]))
                st=st.replace(str[i], "!");
        }
        System.out.println(st.length());
    }
}
