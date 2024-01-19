package practice.JavaBasic.Lab09;

import java.awt.Color;
import java.util.Random;

import javax.swing.*;

public class RandomLabelFrame extends JFrame{ // JFrame ���
	
	// Random ��ü ����
	Random random = new Random();
	// JPanel ����
	JPanel jp = new JPanel();
	// ũ�� 20 �� JLable �迭 ����
	JLabel[] jLabels = new JLabel[20];
	public int getLabelLocation() {
		//return random �� �� 50 ~ 250
		return random.nextInt(200) + 50;
	}

	// RandomLabelFrame ������
	public RandomLabelFrame () {
		// �θ� ������ ȣ��, parameter : �й� + �̸� + Ŭ���� �̸�;
		super("2313398 �־��� RandomLabelFrame");
		// panel layout null�� ����
		jp.setLayout(null);
		// label list length for loop..
		for (int i=0; i<jLabels.length; i++) {
			// �� ��ҿ� JLabel ����
			jLabels[i] = new JLabel(Integer.toString(i));
			// ���� �����
			jLabels[i].setBackground(Color.YELLOW);
			// setOpaque true �� ����
			jLabels[i].setOpaque(true);
			// size 15*10
			jLabels[i].setSize(15, 10);
			// location ���� -> getLabelLocation ȣ��
			jLabels[i].setLocation(getLabelLocation(), getLabelLocation());
			// panel �� label ���̱�
			jp.add(jLabels[i]);
		}
		// panel ���̱�
		add(jp);
		// visible ����
		setVisible(true);
		// size 300*300
		setSize(300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new RandomLabelFrame();
	}

}
