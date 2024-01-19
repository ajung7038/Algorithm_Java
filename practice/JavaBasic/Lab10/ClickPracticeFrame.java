package practice.JavaBasic.Lab10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class ClickPracticeFrame extends JFrame { //JFrame ���
	
	public int getRandomLocation(int max) {
		return (new Random()).nextInt(max-10);
	}
	
	public ClickPracticeFrame() {
		// title ���� (�й� �̸� - Ŭ���� �̸�)
		super("2313398 �־��� - ClickPracticeFrame");
		// Container ���� = getContentPane();
		Container c = getContentPane();
		// container layout null ���� --> C�� ���� ���̱� ���ؼ�
		c.setLayout(null);
		// Label - "C" ����
		JLabel label = new JLabel("C");
		// label �⺻ ��ġ 100*100 ����
		label.setLocation(100, 100);
		// label size 10*10
		label.setSize(10, 10);
		// label �� mouseListener �߰� (param - MouseAdapter()) => �͸�Ŭ����
		label.addMouseListener(new MouseAdapter() {
		// mouseClicked (MouseEvent e)
			public void mouseClicked (MouseEvent e) {
				// e.getComponet()�� label ��������
				JLabel label = (JLabel) e.getComponent();
				// label �� location �����ϱ� ((container ���� ���� - label ���� ���� )������ ���� ����, (container ���� ���� - label ���� ���� )������ ���� ����)
				label.setLocation(getRandomLocation(c.getWidth() - label.getWidth()), getRandomLocation(c.getHeight()));
			}
		});
		// container �� label �߰�
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
