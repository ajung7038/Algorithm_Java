package Algorithm_study.week2;

import java.io.*;
import java.util.Vector;

public class P_���ڿ����� {

    // ����
    // 1. �ϳ��� ����
    // 2. �ִ� �ڸ� �� �ִ� ���ڿ� �� ���ϱ� -> ����� ����
    // 3. ���� ª�� ���� return

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st = br.readLine();
        Vector<Integer> div = new Vector<Integer>(); // ���
        int length = st.length();
        int result = st.length();

        // �ڸ� �� �ִ� �ִ� ���� ��� ���ϱ�
        for (int i=1; i<length; i++) {
            if (length/i == 0) {
                div.add(i);
            }
        }

        // ���� ª�� ���� ã��
        // 1->2>3>6
        for (int i=0; i<div.size(); i++) {
            Vector<String> v = new Vector<String>();

            // ���ڿ� ������
            int split = 0; // ���ڿ� ������ (����)
            for (int j=0; j<st.length()/div.get(i)-1; j++) {
                v.add(st.substring(split, split + div.get(i)));
                split += div.get(i);
            }

            // �ߺ� ����
        }
    }
}
