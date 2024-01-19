package practice.JavaBasic.Lab09;

import javax.swing.*;
import java.awt.*;

public class LayoutFrame extends JFrame { //JFrame ���
	
	// JPanel ����
	JPanel jp = new JPanel();
	// "East, West, South, North, Center" �̸� ���� JButton ����
	JButton bt1 = new JButton("East");
	JButton bt2 = new JButton("West");
	JButton bt3 = new JButton("South");
	JButton bt4 = new JButton("North");
	JButton bt5 = new JButton("Center");
	// LayoutFrame Ŭ���� ������
	public LayoutFrame() {
		// �θ� ������ ȣ�� - jframe, parameter : �й� + �̸� + Ŭ���� �̸�;
		super("2313398 �־��� LayoutFrame");
		// defaultCloseOperation ���� - JFrame.Exit_ON_CLOSE;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// panel layout ���� - BorderLayout (row, col);
		jp.setLayout(new BorderLayout(5, 7));
		// �� ��ư ��, ��, ��, ��, ���Ϳ� �߰�
		jp.add(bt1, BorderLayout.EAST);
		jp.add(bt2, BorderLayout.WEST);
		jp.add(bt3, BorderLayout.SOUTH);
		jp.add(bt4, BorderLayout.NORTH);
		jp.add(bt5, BorderLayout.CENTER);
		// add panel
		add(jp);
		// size 400*200
		setSize(400, 200);
		// visible ����
		setVisible(true);
	}

	public static void main(String[] args) {
		new LayoutFrame();
	}

}
