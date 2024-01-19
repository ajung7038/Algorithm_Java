package practice.JavaBasic.Lab14;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MethodReferenceSqrt {

	public static void main(String[] args) {
		List<Integer> list= Arrays.asList(new Integer[] {1, 2, 3, 4, 5, 6});
		
		// �޼ҵ� ���� ����

		//Function �������̽� ���� - �Ķ���� : int, ���� : double
		Function<Integer, Double> obj;
		//Math Ŭ������ sqrt �޼ҵ� ����
		obj = e -> Math.sqrt(e);
		//����Ʈ -> ��Ʈ�� ��ü ���� --> map() ����Ͽ� ���� => collect() �̿��Ͽ� ��� ���� (List)
		List<Double> result = list.stream()
				.map(obj)
				.collect(Collectors.toList());
		//��� ����Ʈ ���
		System.out.println(result);
	}

}
