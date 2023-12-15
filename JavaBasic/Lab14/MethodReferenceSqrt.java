package JavaBasic.Lab14;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MethodReferenceSqrt {

	public static void main(String[] args) {
		List<Integer> list= Arrays.asList(new Integer[] {1, 2, 3, 4, 5, 6});
		
		// 메소드 참조 형식

		//Function 인터페이스 구현 - 파라미터 : int, 리턴 : double
		Function<Integer, Double> obj;
		//Math 클래스의 sqrt 메소드 참조
		obj = e -> Math.sqrt(e);
		//리스트 -> 스트림 객체 생성 --> map() 사용하여 매핑 => collect() 이용하여 결과 생성 (List)
		List<Double> result = list.stream()
				.map(obj)
				.collect(Collectors.toList());
		//결과 리스트 출력
		System.out.println(result);
	}

}
