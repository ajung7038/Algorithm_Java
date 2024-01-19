package practice.JavaBasic.Lab09;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MultiPanelFrame extends JFrame { // JFrame ���

	public JPanel getNorthPanel() {
		//JPanel ����
		JPanel jp = new JPanel();
		//north panel �� �����ϴ� ��ư 3�� ����(����, �ݱ�, ������)
		JButton jb1 = new JButton("����");
		JButton jb2 = new JButton("�ݱ�");
		JButton jb3 = new JButton("������");
		//panel �� ���̱�
		jp.add(jb1);
		jp.add(jb2);
		jp.add(jb3);
		//panel return
		return jp;
	}
	
	public JPanel getSouthPanel() {
		//JPanel ����
		JPanel jp = new JPanel();
		//button ���� - "Word Input"
		JButton jb = new JButton("Word Input");
		//size 15�� textField ����
		JTextField textField = new JTextField(15);
		//panel �� button, textfield ���̱� 
		jp.add(jb);
		jp.add(textField);
		//panel return
		return jp;
	}
	
	public int getRandomLocation() {
		// return random �� �� 20~220
		return (int)(Math.random()*200 + 20);
	}
	
	public JPanel getCenterPanel() {
		//JPanel ����
		JPanel jp = new JPanel();
		//layout null �� ����
		jp.setLayout(null);
		//���� ������� ����
		jp.setBackground(Color.WHITE);
		// size 5 �� JLabel list ����
		JLabel[] label = new JLabel[5];
		//jlabel length for loop....
		for (int i=0; i<label.length; i++) {
			//�� ��� �� JLabel ���� "*"
			label[i] = new JLabel("*");
			//fontcolor - setForegroud �Լ� ���
			label[i].setForeground(Color.RED);
			//size 10*10
			label[i].setSize(10, 10);
			//location ���� - getRandomLocation ȣ��
			label[i].setLocation(getRandomLocation(), getRandomLocation());
			//panel �� label ���̱�
			jp.add(label[i]);
		}
		//return panel 
		 return jp;
	}
	
	public MultiPanelFrame() {
		//�θ� ������ ȣ��, parameter : �й� + �̸� + Ŭ���� �̸�;
		super("2313398 �־��� - MultiPanelFrame");
		//DefaultCloseOperation- JFrame.EXIT_ON_CLOSE
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//panel �ϳ� ����
		JPanel jp = new JPanel();
		//BorderLayout ���� ����
		jp.setLayout(new BorderLayout());
		//�� ��ġ �� panel ���̱�(�Լ� ȣ�� getNorth...)
		jp.add(getNorthPanel(), "North");
		jp.add(getSouthPanel(), "South");
		jp.add(getCenterPanel(), "Center");
		//panel ���̱�
		add(jp);
		//visible ����
		setVisible(true);
		//size 350*350  
		setSize(350, 350);
	}

	public static void main(String[] args) {
		new MultiPanelFrame();
	}

}
