package practice.JavaBasic.Lab11;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.BadLocationException;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TextAreaPracticeFrame extends JFrame {
	// row 5, column 10 �� JTextArea ���� - private
	private JTextArea textArea = new JTextArea(5, 10);
	// 0���� 100���� ������ ������ ���۰��� 0�� JSlider ���� - private
	private JSlider slider = new JSlider(0, 100, 0);
	public TextAreaPracticeFrame() {
		// �й� �̸� - Ŭ���� �������� Ÿ��Ʋ ����
		super("2313398 �־��� - TextAreaPracticeFrame");
		// slider�� Major �����̽� ���� - 20 ������
		slider.setMajorTickSpacing(20);
		// slider minor �����̽� ���� - 5����
		slider.setMinorTickSpacing(5);
		// slider PaintTicks, PaintLabels true�� ����
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		// slider �� changeListener �߰�
		slider.addChangeListener(new ChangeListener() {
			// stateChanged �Լ� ������
			public void stateChanged(ChangeEvent e) {
				// 1. �ؽ�Ʈ�ڽ��� �ؽ�Ʈ ���� <= �����̴��� value
				if (textArea.getText().length() <= slider.getValue())
					// 	�����̴��� value �����ϱ� (�ؽ�Ʈ �ڽ��� �ؽ�Ʈ ���̷�)
					slider.setValue(textArea.getText().length());
				// 2. �ؽ�Ʈ�ڽ� �ؽ�Ʈ ���� > �����̴��� value
				else {
					// --> BadLocationException ���� try - catch ������ ó�����ֱ�
					try {
						// 	�ؽ�Ʈ�ڽ� �ؽ�Ʈ ���� (�ؽ�Ʈ�ڽ��� �ؽ�Ʈ �������� (0���� �����̴��� ���̸�ŭ)) --> �����̴����� �ؽ�Ʈ �ڽ��� ���ڰ� �� ���ٸ� �����ִ� ��
//						textArea.setText(textArea.getText().substring(0, slider.getValue()));
						textArea.setText(textArea.getText(0, slider.getValue()));
					} catch (BadLocationException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		
		// �ؽ�Ʈ �ڽ��� KeyListener �߰��ϱ�
		textArea.addKeyListener(new KeyAdapter() {
			// keyTyped �Լ� ������
			public void keyTyped(KeyEvent e) {
				// �ؽ�Ʈ �ڽ��� ���� �����ͼ� ������ ����
				int textLength = textArea.getText().length();
				try {
					// ���̰� 100 �̻��̶��
					if (textLength >= 100) {
						// 	�ؽ�Ʈ �ڽ��� �ؽ�Ʈ ���� (�ؽ�Ʈ �ڽ����� �ؽ�Ʈ�� 0 ~ 100������ ��������) --> 100���� �̻��� �ؽ�Ʈ�� ���� ���ϰ� �ϴ� ��
//					textArea.setText(textArea.getText().substring(0, 100));
						textArea.setText(textArea.getText(0, 100));
						// BadLocationException ���� try - catch �� ó�����ֱ�
					}
				}
				catch (BadLocationException e2) {
					e2.printStackTrace();
				}
				// �����̴��� ���̷� �������ֱ� (setValue)
				slider.setValue(textLength);
			}
		});
		
		// �ǳ� ���� - BorderLayout �ʱ� ���̾ƿ� ����
		JPanel jp = new JPanel();
		jp.setLayout(new BorderLayout());
		// �ؽ�Ʈ �ڽ��� JScrollPane�� �������ְ� �ǳ��� ���ʿ� �߰�
		JScrollPane scrollPane = new JScrollPane(textArea);
		jp.add(scrollPane, "North");
		// �����̴��� �ǳ��� ���Ϳ� �߰�
		jp.add(slider, "Center");
		// �ǳ� �߰�
		add(jp);
		// â ũ�� 400, 200
		setSize(400, 200);
		// defaultCloseOperation ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// visible ����
		setVisible(true);
	}

	public static void main(String[] args) {
		new TextAreaPracticeFrame();
	}

}
