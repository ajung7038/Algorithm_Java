package practice.JavaBasic.Lab10;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import static java.awt.event.KeyEvent.VK_LEFT;

public class MoveStringFrame extends JFrame { //JFrame ���

	public MoveStringFrame() { //MoveStringFrame ������
		// title ����
		super("2313398 �־��� - MoveStringFrame");
		// Panel ����
		JPanel jp = new JPanel();
		// Label ���� - default "Love Java"
		JLabel label = new JLabel("Love Java");
		// panel �� label ���̱�
		jp.add(label);
		
		// label �� keyListener �߰� (param - KeyAdapter()) => �͸�Ŭ���� ����
		label.addKeyListener(new KeyAdapter() {
			// keyPressed (KeyEvent e)
			public void keyPressed(KeyEvent e) {
				// e.getKeyCode() == ����Ű ���� (VK_LEFT) �� ���,
				if (e.getKeyCode() == VK_LEFT) {
					// label = e.getSource �޾ƿ���
					JLabel label = (JLabel) e.getSource();
					// label text ��������
					String text = label.getText();
					// ù����, ������ ���� ������
					char firstText = text.charAt(0);
					// label setText
					label.setText(text.substring(1) + firstText);
				}
			}
		});
			
		// label setFocusable(true) ����
		label.setFocusable(true); // ��Ŀ���� �޾ƾ߸� Ű �̺�Ʈ�� ���� �� ����
		// requestFocus ���� (������Ʈ�� ��Ŀ�� ����)
		label.requestFocus();
		// Panel �߰�
		add(jp);
		// size 400 * 200
		setSize(400, 200);
		// default close operation
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// visible true
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MoveStringFrame();
	}

}
