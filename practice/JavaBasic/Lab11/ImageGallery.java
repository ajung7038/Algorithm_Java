package practice.JavaBasic.Lab11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.Vector;

public class ImageGallery extends JFrame {
	// ImageIcon Ÿ���� Vector ����� - private
	private Vector<ImageIcon> imgVector = new Vector<>();
	// �ʱⰪ 0�� index ���� �����ϱ� - private
	private int index = 0;

	// �̹��� ���ϵ��� �����ͼ� Vector �� �־��ִ� �Լ�
	public void loadImages(String path) {
		// path ��ġ ���� ���� ����
		File f = new File(path);
		// ������ ���� ������ �̿��Ͽ� �ش� ������ ������ �����ϴ� ���ϵ��� ��� �������� --> listFiles()
		File[] files = f.listFiles();
		// ���� ���ϵ��� ��� ������ŭ for ���� �ݺ��Ͽ� imgVector�� �־��ֱ� (ImageIcon ���·� �����Ͽ�)
		for (int i=0; i<files.length; i++) {
			imgVector.add(new ImageIcon(files[i].getPath()));
		}
	}
	
	public ImageGallery() {
		// �й� �̸� - Ŭ���� �������� Ÿ��Ʋ ����
		super("2313398 �־��� - ImageGallery");
		// panel �ϳ� ���� (��ü �ǳ�, BorderLayout)
		JPanel jp = new JPanel(new BorderLayout());
		// ���� ��ư ���� �ǳ� �ϳ� ����
		JPanel radioPanel = new JPanel();
		// JRadioButton �ΰ� ���� - left(true), right
		JRadioButton leftButton = new JRadioButton("left", true);
		JRadioButton rightButton = new JRadioButton("right", false);
		// ���� ��ư �ΰ��� ��ư �׷����� �����ֱ� - ButtonGroup .add
		ButtonGroup btGroup = new ButtonGroup();
		btGroup.add(leftButton);
		btGroup.add(rightButton);
		// loadImages �Լ��� ȣ���Ͽ� ���� ������Ʈ ������ images ������ �ִ� ���� ��� ��������
		loadImages("C:/Users/ajung/Documents/GitHub/Algorithm/practice.JavaBasic/Lab11/images");
		// JLabel �� ����Ͽ� �̹��� �������� - ������ ȣ�� �� vector �� 0��° ������ ù �̹��� �����ϱ�
		JLabel img = new JLabel(imgVector.get(0));
		// img(label) �� Ŭ���ϸ� ����/���� �̹����� ȣ���ϹǷ� MouseListener �߰��ϱ�
		img.addMouseListener(new MouseAdapter() {
			// mouseClicked �Լ��� ���������ְ�
			public void mouseClicked(MouseEvent e) {
				// right ���� ��ư�� ���������� Ȯ��
				if (rightButton.isSelected()) {
					// index �����ϱ�
					index += 1;
					// ������ index �� ������ ������� Ȯ��
					if (index > imgVector.size()) {
						index -= 1;
					}
				}
				// left ���� ��ư�� ���������� Ȯ��
				else if (leftButton.isSelected()) {
					// index �����ϱ�
					index -= 1;
					// ������ index �� ������ ������� Ȯ��
					if (index < 0) {
						index += 1;
					}
				}
				//index �� ����Ͽ� img(label)�� �̹��� ���� - setIcon �Լ��� �̿�
				img.setIcon(imgVector.get(index));
			}
		});
		// ���� �ǳڿ� ������ư �ΰ� �߰�
		radioPanel.add(leftButton);
		radioPanel.add(rightButton);
		// �ǳ��� ���ʿ� ���� �ǳ� �߰�
		jp.add(radioPanel, "North");
		// img(label)�� �ǳ��� ���Ϳ� �߰�
		jp.add(img, "Center");
		// �ǳ� �߰�
		add(jp);
		// â ũ�� 400, 300
		setSize(400, 300);
		// defaultCloseOperation ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// visible ����
		setVisible(true);
	}

	public static void main(String[] args) {
		new ImageGallery();
	}

}
