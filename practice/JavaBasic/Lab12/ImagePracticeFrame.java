package practice.JavaBasic.Lab12;

import java.awt.*;

import javax.swing.*;

public class ImagePracticeFrame extends JFrame {
	public ImagePracticeFrame() {
		// title ����
		super("2313398 �־��� - ImagePracticeFrame");
		// contentPane ���� - MyPanel()
		MyPanel myPanel = new MyPanel();
		setContentPane(myPanel);
		// default Close operation ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// âũ�� 400, 400
		setSize(400, 400);
		// Visible ����
		setVisible(true);
	}

	class MyPanel extends JPanel {
		// ImageIcon �޾ƿͼ� �� ��� ����
		ImageIcon icon = new ImageIcon("C:/Users/ajung/Documents/GitHub/Algorithm/practice.JavaBasic/Lab12/images/image");
		// ImageIcon �� image �� �޾ƿ���
		Image img = icon.getImage();
		// �̹��� ����, ���� ����
		private int imgWidth = icon.getIconWidth();
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			// �ǳ� ����, ���� ����
			JPanel jp = new JPanel();
			// �̹��� �׵���ؼ� �ǳڿ� ����
			// drawImage(�̹���, �̹��� �׸� ��ġ(���� ������ ~ ����, ���� ũ��), �׸� �̹��� ��������(���� �� ~ ����, ���� ũ��), this);
			// --> �� 4�� �׸���
			
		}
	}

	public static void main(String[] args) {
		new ImagePracticeFrame();
	}
}









