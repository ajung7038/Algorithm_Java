package JavaBasic.Lab10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class ClickPracticeFrame extends JFrame { //JFrame 상속
	
	public int getRandomLocation(int max) {
		return (new Random()).nextInt(max-10);
	}
	
	public ClickPracticeFrame() {
		// title 설정 (학번 이름 - 클래스 이름)
		super("2313398 주아정 - ClickPracticeFrame");
		// Container 생성 = getContentPane();
		Container c = getContentPane();
		// container layout null 설정 --> C를 어디든 붙이기 위해서
		c.setLayout(null);
		// Label - "C" 설정
		JLabel label = new JLabel("C");
		// label 기본 위치 100*100 설정
		label.setLocation(100, 100);
		// label size 10*10
		label.setSize(10, 10);
		// label 에 mouseListener 추가 (param - MouseAdapter()) => 익명클래스
		label.addMouseListener(new MouseAdapter() {
		// mouseClicked (MouseEvent e)
			public void mouseClicked (MouseEvent e) {
				// e.getComponet()로 label 가져오기
				JLabel label = (JLabel) e.getComponent();
				// label 의 location 설정하기 ((container 가로 길이 - label 가로 길이 )범위의 랜덤 변수, (container 세로 길이 - label 세로 길이 )범위의 랜덤 변수)
				label.setLocation(getRandomLocation(c.getWidth() - label.getWidth()), getRandomLocation(c.getHeight()));
			}
		});
		// container 에 label 추가
		c.add(label);
		
		// size 400 * 300
		setSize(400, 300);
		// default close operation
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// visible true
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new ClickPracticeFrame(); 
	}

}
