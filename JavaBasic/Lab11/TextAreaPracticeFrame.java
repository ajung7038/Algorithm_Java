package JavaBasic.Lab11;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.BadLocationException;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TextAreaPracticeFrame extends JFrame {
	// row 5, column 10 인 JTextArea 생성 - private
	private JTextArea textArea = new JTextArea(5, 10);
	// 0부터 100까지 범위를 가지는 시작값이 0인 JSlider 생성 - private
	private JSlider slider = new JSlider(0, 100, 0);
	public TextAreaPracticeFrame() {
		// 학번 이름 - 클래스 제목으로 타이틀 설정
		super("2313398 주아정 - TextAreaPracticeFrame");
		// slider의 Major 스페이싱 설정 - 20 단위로
		slider.setMajorTickSpacing(20);
		// slider minor 스페이싱 설정 - 5단위
		slider.setMinorTickSpacing(5);
		// slider PaintTicks, PaintLabels true로 설정
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		// slider 에 changeListener 추가
		slider.addChangeListener(new ChangeListener() {
			// stateChanged 함수 재정의
			public void stateChanged(ChangeEvent e) {
				// 1. 텍스트박스의 텍스트 길이 <= 슬라이더의 value
				if (textArea.getText().length() <= slider.getValue())
					// 	슬라이더의 value 설정하기 (텍스트 박스의 텍스트 길이로)
					slider.setValue(textArea.getText().length());
				// 2. 텍스트박스 텍스트 길이 > 슬라이더의 value
				else {
					// --> BadLocationException 에러 try - catch 문으로 처리해주기
					try {
						// 	텍스트박스 텍스트 설정 (텍스트박스의 텍스트 가져오기 (0부터 슬라이더의 길이만큼)) --> 슬라이더보다 텍스트 박스의 글자가 더 많다면 지워주는 것
//						textArea.setText(textArea.getText().substring(0, slider.getValue()));
						textArea.setText(textArea.getText(0, slider.getValue()));
					} catch (BadLocationException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		
		// 텍스트 박스에 KeyListener 추가하기
		textArea.addKeyListener(new KeyAdapter() {
			// keyTyped 함수 재정의
			public void keyTyped(KeyEvent e) {
				// 텍스트 박스의 길이 가져와서 변수에 저장
				int textLength = textArea.getText().length();
				try {
					// 길이가 100 이상이라면
					if (textLength >= 100) {
						// 	텍스트 박스의 텍스트 설정 (텍스트 박스에서 텍스트를 0 ~ 100까지만 가져오기) --> 100글자 이상의 텍스트는 적지 못하게 하는 것
//					textArea.setText(textArea.getText().substring(0, 100));
						textArea.setText(textArea.getText(0, 100));
						// BadLocationException 에러 try - catch 로 처리해주기
					}
				}
				catch (BadLocationException e2) {
					e2.printStackTrace();
				}
				// 슬라이더를 길이로 세팅해주기 (setValue)
				slider.setValue(textLength);
			}
		});
		
		// 판넬 생성 - BorderLayout 초기 레이아웃 설정
		JPanel jp = new JPanel();
		jp.setLayout(new BorderLayout());
		// 텍스트 박스를 JScrollPane로 생성해주고 판넬의 북쪽에 추가
		JScrollPane scrollPane = new JScrollPane(textArea);
		jp.add(scrollPane, "North");
		// 슬라이더를 판넬의 센터에 추가
		jp.add(slider, "Center");
		// 판넬 추가
		add(jp);
		// 창 크기 400, 200
		setSize(400, 200);
		// defaultCloseOperation 설정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// visible 설정
		setVisible(true);
	}

	public static void main(String[] args) {
		new TextAreaPracticeFrame();
	}

}
