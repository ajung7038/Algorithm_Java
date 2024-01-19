package practice.JavaBasic.Lab09;

import javax.swing.*;
import java.awt.*;

import static java.awt.Color.*;

public class ColorButtonFrame extends JFrame { // JFrame ���

	// JPanel �ϳ� ����
	JPanel jp = new JPanel();
	// ũ�� 10�� JButton �迭 ����
	JButton[] jb = new JButton[10];
	// COLOR �迭 ���� (10���� �ٸ� ����)
	Color[] COLOR = {RED, ORANGE, YELLOW, GREEN, CYAN, BLUE, MAGENTA, GRAY, PINK, LIGHT_GRAY};
	// ColorButtonFrame ������
	public ColorButtonFrame() {
		//	�θ� ������ ȣ��, parameter : �й� + �̸� + Ŭ���� �̸�;
		super("2313398 �־��� - ColorButtonFrame");
		//	Panel GridLayout���� ����
		jp.setLayout(new GridLayout());
		//	jbutton �迭 ũ�⸸ŭ for loop ���鼭 ...
		for (int i = 0; i < jb.length; i++) {
			//	�� ��� �� JButton ���� with "i"
			jb[i] = new JButton(Integer.toString(i));
			//	��� �� Color list ������ ����
			jb[i].setBackground(COLOR[i]);
			//	jpanel �� ���̱�
			jp.add(jb[i]);
		}

		// panel ���̱�
		add(jp);
		// ������ 500*200
		setSize(500, 200);
		// visible ����
		setVisible(true);
		// defaultCloseOperation ���� - JFrame.Exit_ON_CLOSE;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new ColorButtonFrame();
	}

}
