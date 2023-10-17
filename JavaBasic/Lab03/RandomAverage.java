package JavaBasic.Lab03;

public class RandomAverage {
    public static void main(String[] args) {
        int sum = 0;
        int[] numArr = new int[10];
        System.out.print("랜덤한 정수들 : ");

        for (int i=0; i<numArr.length; i++) {
            int rand = (int)(Math.random()*10);
            sum += rand;
            System.out.print(rand + " ");
        }
        System.out.print("\n평균은 "+ (double)(sum/numArr.length) );
    }
}
