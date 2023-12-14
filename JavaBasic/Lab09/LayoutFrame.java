package JavaBasic.Lab09;

import javax.swing.*;
import java.awt.*;

public class LayoutFrame extends JFrame { //JFrame 상속
	
	// JPanel 생성
	JPanel jp = new JPanel();
	// "East, West, South, North, Center" 이름 가진 JButton 생성
	JButton bt1 = new JButton("East");
	JButton bt2 = new JButton("West");
	JButton bt3 = new JButton("South");
	JButton bt4 = new JButton("North");
	JButton bt5 = new JButton("Center");
	// LayoutFrame 클래스 생성자
	public LayoutFrame() {
		// 부모 생성자 호출 - jframe, parameter : 학번 + 이름 + 클래스 이름;
		super("2313398 주아정 LayoutFrame");
		// defaultCloseOperation 설정 - JFrame.Exit_ON_CLOSE;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// panel layout 설정 - BorderLayout (row, col);
		jp.setLayout(new BorderLayout(5, 7));
		// 각 버튼 동, 서, 남, 북, 센터에 추가
		jp.add(bt1, BorderLayout.EAST);
		jp.add(bt2, BorderLayout.WEST);
		jp.add(bt3, BorderLayout.SOUTH);
		jp.add(bt4, BorderLayout.NORTH);
		jp.add(bt5, BorderLayout.CENTER);
		// add panel
		add(jp);
		// size 400*200
		setSize(400, 200);
		// visible 설정
		setVisible(true);
	}

	public static void main(String[] args) {
		new LayoutFrame();
	}

}
