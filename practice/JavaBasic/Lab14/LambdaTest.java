package practice.JavaBasic.Lab14;

//ArrayProcessing �������̽�
interface ArrayProcessing {
	double apply(double[] array);
}

//���ٽ� �����ϱ�
public class LambdaTest {
	
	// (1) �հ�
//	public static final ArrayProcessing sumer = array -> {
//		double total;
//		//for�� �̿��Ͽ� array �հ� ���ϱ�
////		for ()
//	};
	
	// (2) �ִ�
//	public static final ArrayProcessing maxer = array -> {
//		double max;
//		//for�� �̿��Ͽ� array �ִ� ���ϱ�
//
//	};
//
//	// (3) �ּڰ�
//	public static final ArrayProcessing miner = array -> {
//		double min;
//		//for�� �̿��Ͽ� array �ּڰ� ���ϱ�
//
//	};
//
//	// (4) ��հ�
//	//�հ� �̿��Ͽ� ��հ� ���ϱ�
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