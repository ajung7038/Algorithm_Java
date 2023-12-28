package JavaBasic.Lab14;

//ArrayProcessing 인터페이스
interface ArrayProcessing {
	double apply(double[] array);
}

//람다식 구현하기
public class LambdaTest {
	
	// (1) 합계
//	public static final ArrayProcessing sumer = array -> {
//		double total;
//		//for문 이용하여 array 합계 구하기
////		for ()
//	};
	
	// (2) 최댓값
//	public static final ArrayProcessing maxer = array -> {
//		double max;
//		//for문 이용하여 array 최댓값 구하기
//
//	};
//
//	// (3) 최솟값
//	public static final ArrayProcessing miner = array -> {
//		double min;
//		//for문 이용하여 array 최솟값 구하기
//
//	};
//
//	// (4) 평균값
//	//합계 이용하여 평균값 구하기
//	public static final ArrayProcessing averager = array -> {
//		double avg;
//	};

	public static void main(String[] args) {

		double[] list = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

//		System.out.println("Sum: " + sumer.apply(list));
//		System.out.println("Average: " + averager.apply(list));
//		System.out.println("Minimum: " + miner.apply(list));
//		System.out.println("Maximum: " + maxer.apply(list));
	}
}