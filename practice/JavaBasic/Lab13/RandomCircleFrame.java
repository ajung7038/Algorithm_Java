package practice.JavaBasic.Lab13;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RandomCircleFrame extends JFrame {
	public RandomCircleFrame() {
		// title ����
		super("2313398 �־��� - RandomCircleFrame");
		// MyPanel() �����ڸ� ȣ���Ͽ� ����Ʈ������ ����
		MyPanel myPanel = new MyPanel();
		setContentPane(myPanel);
		// default close operation ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// â size 400, 400
		setSize(400, 400);
		// visible ����
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new RandomCircleFrame();
	}

}

class MyPanel extends JPanel implements Runnable {
	private int x = 100, y = 100;
	
	public MyPanel() {
		// this�� mouseListener �߰� : param (MouseAdpater())
		this.addMouseListener(new MouseAdapter() {
			// mousePressed() �Լ� ������
			public void mousePressed(MouseEvent e) {
			// --> thread ȣ�� : param (MyPanel.this) +  start()
			Thread th = new Thread(MyPanel.this);
			th.start();
		}
		});
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		// blue�� color setting
		setForeground(Color.BLUE);
		// 50x50 ũ���� �� �׸��� with x, y
		g.drawOval(x, y, 50, 50);
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(500);
			}
			catch(InterruptedException e) {
				return ;
			}
			//x, y ��ǥ random�ϰ� �޾ƿ��� -> frame�� ���� ũ�� ���
			x = (int) (Math.random() * (getWidth()-50));
			y = (int) (Math.random() * (getHeight()-50));
			// repaint()�޼ҵ� ȣ��
			repaint();
		}
	}
	
	
}
