package practice.dataStructure_List;

import java.util.Scanner;

public class BOJ_2941 {
    public static void main(String[] args) {

//        int count = 0; // ũ�ξ�Ƽ�� ���ĺ� ����
//
//        // ũ�ξ�Ƽ�� ���ĺ� : c=, c-, dz=, d-, lj, nj, s=, z=
//        // List�� �ٲ� �� contains() �޼ҵ� ���
//        practice.String[] c = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
//        List<practice.String> cList = new ArrayList<>(Arrays.asList(c));
//
//        // ���ڿ� �о����
//        Scanner scanner = new Scanner(System.in);
//        practice.String alpha = scanner.next();
//        int initLen = alpha.length();
//
//        for (int i=0; i<initLen; i++) {
//            int index = cList.indexOf(alpha); // �ٲ� ũ�ξ�Ƽ�� ���ĺ� ��ġ
//            int len = c[index].length(); // ũ�ξ�Ƽ�� ���ĺ� ����
//
//            // �ٲ� ũ�ξ�Ƽ�� ���ĺ��� ����
//            if (index != -1) {
//                // count ����
//                count += 1;
//                // alpha ���� (ũ�Ⱑ 2�� ���, ũ�Ⱑ 3�� ���)
//                alpha = alpha.replaceAll(alpha.substring(index, len), "");
//            }
//            // ������ ���
//            else {
//                // ���ڿ� ���̸�ŭ count ����
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
