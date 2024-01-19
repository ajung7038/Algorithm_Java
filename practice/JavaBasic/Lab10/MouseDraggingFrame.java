package practice.JavaBasic.Lab10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseDraggingFrame extends JFrame { // JFrame ���
	
	public MouseDraggingFrame() { //MouseDraggingFrame ������
		// title ���� (�й� �̸� - Ŭ���� �̸�)
		setTitle("2313398 �־��� - MouseDraggingFrame");
		// Container ���� = getContentPane();
		Container c = getContentPane();
		// container �� ���� ���� - default Green
		c.setBackground(Color.GREEN);
		// MyMouseListener ����
		MyMouseListener myMouseListener = new MyMouseListener();
		// container �� mouseListener �߰�
		c.addMouseListener(myMouseListener);
		// container �� mouseMotionListener �߰�
		c.addMouseMotionListener(myMouseListener);
		// size 400 * 200
		setSize(400, 200);
		// default close operation
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// visible true
		setVisible(true);
	}
	
	class MyMouseListener extends MouseAdapter { //MouseAdapter ���
		public void mouseDragged(MouseEvent e) {
			// Container ���� = e.getSource();
			Container c = (Container) e.getSource();
			// ���� ���� - yellow
			c.setBackground(Color.YELLOW);
		}

		public void mouseReleased(MouseEvent e) {
			// Container ����;
			Container c = getContentPane();
			// ���� ���� - green
			c.setBackground(Color.GREEN);
		}
	}
	
	public static void main(String[] args) {
		new MouseDraggingFrame();
	}

}
