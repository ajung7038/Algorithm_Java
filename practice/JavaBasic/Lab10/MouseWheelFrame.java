package practice.JavaBasic.Lab10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class MouseWheelFrame extends JFrame { //JFrame ���

	public MouseWheelFrame() {
		// title ���� (�й� �̸� - Ŭ���� �̸�)
		super("2313398 �־��� - MouseWheelFrame");
		// default close operation
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// ��ġ������ ���� -FlowLayout
		setLayout(new FlowLayout());
		// "Love Java" �ؽ�Ʈ ��
		JLabel label = new JLabel("Love Java");
		// add label
		add(label);
		// "Arial", plain, 15 �ȼ� ũ��
		label.setFont(new Font("Arial", Font.PLAIN, 15));
		// �󺧿�  mouseWheelListener �߰� �� �͸� Ŭ���� ����
		label.addMouseWheelListener(new MouseWheelListener () {
			// mouseWheelMoved(MouseWheelEvent e)
			public void mouseWheelMoved(MouseWheelEvent e) {
				// e.getWheelRotation() ���� ���� ������ ��������
				int move = e.getWheelRotation();
				// ������ �������� 0���� �۴ٸ� -> ���� �� ������
				if (move < 0) {
					// e.getSource�� �̺�Ʈ �߻��� JLabel ��������
					JLabel label = (JLabel) e.getSource();
					// label�� font �������� - getFont()
					Font font = label.getFont();
					// font �� ���� size �������� - getSize()
					int size = font.getSize();
					// 5�ȼ� ���Ϸ� �۾����� �ʵ��� return
					if (size < 5) return;

					// �������� 5�ȼ� �۾������� ����
					size -= 5;
					label.setFont(new Font("Arial", Font.PLAIN, size));
				}
		
				// ������ �������� 0���� ũ�ٸ� -> �Ʒ� �� ������
				if (move > 0) {
					// e.getSource�� �̺�Ʈ �߻��� JLabel ��������
					JLabel label = (JLabel) e.getSource();
					// label�� font �������� - getFont()
					Font font = label.getFont();
					// font �� ���� size �������� - getSize()
					int size = font.getSize();
					// �������� 5�ȼ� Ŀ������ ����
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
