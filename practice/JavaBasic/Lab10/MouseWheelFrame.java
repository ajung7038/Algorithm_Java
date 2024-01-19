package practice.JavaBasic.Lab10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class MouseWheelFrame extends JFrame { //JFrame 상속

	public MouseWheelFrame() {
		// title 설정 (학번 이름 - 클래스 이름)
		super("2313398 주아정 - MouseWheelFrame");
		// default close operation
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 배치관리자 설정 -FlowLayout
		setLayout(new FlowLayout());
		// "Love Java" 텍스트 라벨
		JLabel label = new JLabel("Love Java");
		// add label
		add(label);
		// "Arial", plain, 15 픽셀 크기
		label.setFont(new Font("Arial", Font.PLAIN, 15));
		// 라벨에  mouseWheelListener 추가 및 익명 클래스 정의
		label.addMouseWheelListener(new MouseWheelListener () {
			// mouseWheelMoved(MouseWheelEvent e)
			public void mouseWheelMoved(MouseWheelEvent e) {
				// e.getWheelRotation() 으로 휠의 움직임 가져오기
				int move = e.getWheelRotation();
				// 가져온 움직임이 0보다 작다면 -> 위로 휠 움직임
				if (move < 0) {
					// e.getSource로 이벤트 발생한 JLabel 가져오기
					JLabel label = (JLabel) e.getSource();
					// label의 font 가져오기 - getFont()
					Font font = label.getFont();
					// font 에 대해 size 가져오기 - getSize()
					int size = font.getSize();
					// 5픽셀 이하로 작아지지 않도록 return
					if (size < 5) return;

					// 원래보다 5픽셀 작아지도록 설정
					size -= 5;
					label.setFont(new Font("Arial", Font.PLAIN, size));
				}
		
				// 가져온 움직임이 0보다 크다면 -> 아래 휠 움직임
				if (move > 0) {
					// e.getSource로 이벤트 발생한 JLabel 가져오기
					JLabel label = (JLabel) e.getSource();
					// label의 font 가져오기 - getFont()
					Font font = label.getFont();
					// font 에 대해 size 가져오기 - getSize()
					int size = font.getSize();
					// 원래보다 5픽셀 커지도록 설정
					size += 5;
					label.setFont(new Font("Arial", Font.PLAIN, size));
				}
			}
		});
				
			
		
		// size 300*150
		setSize(300, 150);
		// visible true
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MouseWheelFrame();
	}

}
