package JavaBasic.Lab10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseDraggingFrame extends JFrame { // JFrame 상속
	
	public MouseDraggingFrame() { //MouseDraggingFrame 생성자
		// title 설정 (학번 이름 - 클래스 이름)
		setTitle("2313398 주아정 - MouseDraggingFrame");
		// Container 생성 = getContentPane();
		Container c = getContentPane();
		// container 의 배경색 설정 - default Green
		c.setBackground(Color.GREEN);
		// MyMouseListener 정의
		MyMouseListener myMouseListener = new MyMouseListener();
		// container 에 mouseListener 추가
		c.addMouseListener(myMouseListener);
		// container 에 mouseMotionListener 추가
		c.addMouseMotionListener(myMouseListener);
		// size 400 * 200
		setSize(400, 200);
		// default close operation
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// visible true
		setVisible(true);
	}
	
	class MyMouseListener extends MouseAdapter { //MouseAdapter 상속
		public void mouseDragged(MouseEvent e) {
			// Container 생성 = e.getSource();
			Container c = (Container) e.getSource();
			// 배경색 설정 - yellow
			c.setBackground(Color.YELLOW);
		}

		public void mouseReleased(MouseEvent e) {
			// Container 생성;
			Container c = getContentPane();
			// 배경색 설정 - green
			c.setBackground(Color.GREEN);
		}
	}
	
	public static void main(String[] args) {
		new MouseDraggingFrame();
	}

}
