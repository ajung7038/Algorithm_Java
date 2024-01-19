package practice.JavaBasic.Lab11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MoneyChangerCheckBoxFrame extends JFrame {

	public MoneyChangerCheckBoxFrame() {
		// �й� �̸� - Ŭ���� �������� Ÿ��Ʋ ����
		super("2313398 �־��� - MoneyChangerCheckBoxFrame");
		//MyPanel �����ڸ� ����Ͽ� ContentPane ����
		MyPanel myPanel = new MyPanel();
		setContentPane(myPanel);
		// â ũ�� 400, 300
		setSize(400, 300);
		// defaultCloseOperation ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// visible ����
		setVisible(true);
	}

	class MyPanel extends JPanel {
		// 50000 ~ 1 ������ ������ int �迭 �ϳ� ����
		int[] moneyInt = {50000, 10000, 1000, 500, 100, 50, 10, 1};
		// "������" ~ "1��" ���� ������ practice.String �迭 �ϳ� ����
		String[] moneyString = {"������", "����", "õ��", "500��", "100��", "50��", "10��", "1��"};
		// JCheckBox �迭 ���� (ũ��� �� �迭�� ���̸�ŭ)
		JCheckBox[] checkBoxes = new JCheckBox[moneyInt.length];
		// JTextField �迭 ���� (ũ��� ���� ����)
		JTextField[] textFields = new JTextField[moneyInt.length];
		public MyPanel() {
			// ������ PINK �� ���� (����Ʈ ���� ���� �ٸ� ������ ���� ����)
			setBackground(Color.PINK);
			// �ǳ� �ϳ� ����
			JPanel jp = new JPanel();
			// �ǳ� ������ �� ������ ����� �����ϰ� ����
			jp.setBackground(Color.PINK);
			// "�ݾ�" ���� ������ �� �ϳ� ����
			JLabel label = new JLabel("�ݾ�");
			// 15ũ���� �ؽ�Ʈ�ʵ� �ϳ� ���� (�ݾ�)
			JTextField tf = new JTextField(15);
			// "���" ���� ������ ��ư �ϳ� ����
			JButton bt = new JButton("���");
			// �ǳڿ� ��, �ؽ�Ʈ�ʵ�, ��ư ������� ���̱�
			jp.add(label);
			jp.add(tf);
			jp.add(bt);
			// �ǳ� ���̱�
			add(jp);
			// ���� �ǳ� �ϳ� ����
			JPanel centerPanel = new JPanel();
			// ���� �ǳ��� ���̾ƿ� ���� - GridLayout (row, col) : hint) �� �迭�� ���̰� ���� �����̰�, �÷��� ��� ��, �ؽ�Ʈ�ʵ�, �޺��ڽ��� ����.
			centerPanel.setLayout(new GridLayout(moneyInt.length, 3));
			// ���� �ǳ��� ���� ���� (�� ������ ����� �����ϰ� ����)
			centerPanel.setBackground(Color.PINK);
			// �迭(Ŭ������ ó���� ��������) �� ���̸�ŭ ���鼭
			for (int i=0; i<moneyString.length; i++) {
				// ���� practice.String �迭�� ���� �ϳ��� �޾ƿ��鼭 ����
				JLabel lb = new JLabel(moneyString[i]);
				// �� �ؽ�Ʈ�ʵ� �迭���� ������ �ε����� ũ�� 10�� �ؽ�Ʈ �ʵ带 ����
				textFields[i] = new JTextField(10);
				// �� �޺��ڽ� �迭���� ������ �ε����� üũ �ڽ� ���� ("", false)
				checkBoxes[i] = new JCheckBox("", false);
				// �޺� �ڽ��� opaque �� false�� ����
				checkBoxes[i].setOpaque(false);
				// ���� �ǳڿ� ��, �ؽ�Ʈ �ʵ�, �޺��ڽ��� ������� �߰�
				centerPanel.add(lb);
				centerPanel.add(textFields[i]);
				centerPanel.add(checkBoxes[i]);
			}
			// ���� �ǳ� �߰�
			add(centerPanel);

			// "���" ��ư�� ActionListener �߰�
			bt.addActionListener(new ActionListener() {
				// actionPerformed �Լ� ������
				public void actionPerformed(ActionEvent e) {
					// ù �ؽ�Ʈ �ʵ忡�� ���� ������
					String tfMoney = tf.getText();
					// ���� �ؽ�Ʈ �ʵ忡 �ƹ��͵� �ԷµǾ� ���� �ʴٸ� --> return ;
					if (tf.getText().isEmpty()) return;
					// �ؽ�Ʈ �ʵ� ���� Integer ������ ���� (parseInt)
					int money = Integer.parseInt(tfMoney);
					// ���� �ϳ� ���� (�� �� or �� �� ����� ����)
					int count;
					// �迭�� ���̸�ŭ �ݺ��ϸ鼭
					for (int i=0; i<moneyString.length; i++) {
						// �� ���ϱ�(�� �� or �� ��) = (���� �� / ���� ����)
						count = money/moneyInt[i];
						// 1. i�� 1���� ���, 1���� �ش��ϴ� textfield �� ���� ������ �ִ� ���� ��� �� (integer toString)
						if (moneyInt[i] == 1) {
							// --> break;
							textFields[i].setText(Integer.toString(money));
							break;
						}
						// 2. �޺��ڽ��� ���õ��� ���� ���
						else if (!checkBoxes[i].isSelected()) {
							// --> 0���� �����ϱ�, continue;
							textFields[i].setText("0");
							continue;
						}
						// 3. ������ ����
						else {
							// ���� ������°�� �ش��ϴ� �ؽ�Ʈ �ʵ忡 ���� ��(�� �� or �� ��) �����ϱ�
							textFields[i].setText(Integer.toString(count));
							// ���� ���� (���� �� % ���� ����)�� �ٲپ� �ֱ� --> �̹� ����� ������ ���ؼ��� ���ִ� ��
							money %= moneyInt[i];
						}
					}
				}
			});
		}
	}

	public static void main(String[] args) {
		new MoneyChangerCheckBoxFrame();
	}

}
