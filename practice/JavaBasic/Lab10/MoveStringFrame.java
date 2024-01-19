package practice.JavaBasic.Lab10;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import static java.awt.event.KeyEvent.VK_LEFT;

public class MoveStringFrame extends JFrame { //JFrame 상속

	public MoveStringFrame() { //MoveStringFrame 생성자
		// title 설정
		super("2313398 주아정 - MoveStringFrame");
		// Panel 생성
		JPanel jp = new JPanel();
		// Label 생성 - default "Love Java"
		JLabel label = new JLabel("Love Java");
		// panel 에 label 붙이기
		jp.add(label);
		
		// label 에 keyListener 추가 (param - KeyAdapter()) => 익명클래스 구현
		label.addKeyListener(new KeyAdapter() {
			// keyPressed (KeyEvent e)
			public void keyPressed(KeyEvent e) {
				// e.getKeyCode() == 방향키 왼쪽 (VK_LEFT) 일 경우,
				if (e.getKeyCode() == VK_LEFT) {
					// label = e.getSource 받아오기
					JLabel label = (JLabel) e.getSource();
					// label text 가져오기
					String text = label.getText();
					// 첫글자, 나머지 글자 나누기
					char firstText = text.charAt(0);
					// label setText
					label.setText(text.substring(1) + firstText);
				}
			}
		});
			
		// label setFocusable(true) 설정
		label.setFocusable(true); // 포커스를 받아야만 키 이벤트를 받을 수 있음
		// requestFocus 설정 (컴포넌트에 포커스 설정)
		label.requestFocus();
		// Panel 추가
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
