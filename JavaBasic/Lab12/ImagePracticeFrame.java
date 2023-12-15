package JavaBasic.Lab12;

import java.awt.*;

import javax.swing.*;

public class ImagePracticeFrame extends JFrame {
	public ImagePracticeFrame() {
		// title 설정
		super("2313398 주아정 - ImagePracticeFrame");
		// contentPane 설정 - MyPanel()
		MyPanel myPanel = new MyPanel();
		setContentPane(myPanel);
		// default Close operation 설정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 창크기 400, 400
		setSize(400, 400);
		// Visible 설정
		setVisible(true);
	}

	class MyPanel extends JPanel {
		// ImageIcon 받아와서 뒷 배경 설정
		ImageIcon icon = new ImageIcon("C:/Users/ajung/Documents/GitHub/Algorithm/JavaBasic/Lab12/images/image");
		// ImageIcon 을 image 로 받아오기
		Image img = icon.getImage();
		// 이미지 가로, 세로 길이
		private int imgWidth = icon.getIconWidth();
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			// 판넬 가로, 세로 길이
			JPanel jp = new JPanel();
			// 이미지 네등분해서 판넬에 설정
			// drawImage(이미지, 이미지 그릴 위치(왼쪽 위부터 ~ 가로, 세로 크기), 그릴 이미지 가져오기(왼쪽 위 ~ 가로, 세로 크기), this);
			// --> 총 4번 그리기
			
		}
	}

	public static void main(String[] args) {
		new ImagePracticeFrame();
	}
}









