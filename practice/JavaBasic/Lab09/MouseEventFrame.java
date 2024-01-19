package practice.JavaBasic.Lab09;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MouseEventFrame extends JFrame {
	public MouseEventFrame() {
		// title 설정 (학번 이름 - 클래스 이름)
		super("2313398 주아정 - MouseEventFrame");
		// default close operation
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Container 생성 = getContentPane();
		Container c = getContentPane();
		// container flow layout 설정
		setLayout(new FlowLayout());
		// Label - "Love Java" 설정
		JLabel label = new JLabel("Love Java");
		// container 에 label 추가
		c.add(label);
		
		//label 에 mouseListener 추가 (param - MouseAdapter()) => 익명클래스 구현
		label.addMouseListener(new MouseAdapter() {
			//mouseEntered(MouseEvent e)
			@Override
			public void mouseEntered(MouseEvent e) {
				// e.getSource로 이벤트 발생한 JLabel 가져오기
				JLabel label = (JLabel) e.getSource();
				//label setText "Love Java"
				label.setText("Love Java");
			}
				
			//mouseExited(MouseEvent e)
			@Override
			public void mouseExited(MouseEvent e) {
				// e.getSource로 이벤트 발생한 JLabel 가져오기
				JLabel label = (JLabel) e.getSource();
				//label setText "사랑해"
				label.setText("사랑해");
			}
		});
				
				

		// size 250 * 150
		setSize(250, 150);
		// visible true
		setVisible(true);
	}
	static public void main(String [] args) {
		new MouseEventFrame();
	}
}
