package practice.JavaBasic.Lab11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MoneyChangerCheckBoxFrame extends JFrame {

	public MoneyChangerCheckBoxFrame() {
		// 학번 이름 - 클래스 제목으로 타이틀 설정
		super("2313398 주아정 - MoneyChangerCheckBoxFrame");
		//MyPanel 생성자를 사용하여 ContentPane 설정
		MyPanel myPanel = new MyPanel();
		setContentPane(myPanel);
		// 창 크기 400, 300
		setSize(400, 300);
		// defaultCloseOperation 설정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// visible 설정
		setVisible(true);
	}

	class MyPanel extends JPanel {
		// 50000 ~ 1 원으로 구성된 int 배열 하나 생성
		int[] moneyInt = {50000, 10000, 1000, 500, 100, 50, 10, 1};
		// "오만원" ~ "1원" 으로 구성된 practice.String 배열 하나 생성
		String[] moneyString = {"오만원", "만원", "천원", "500원", "100원", "50원", "10원", "1원"};
		// JCheckBox 배열 생성 (크기는 위 배열의 길이만큼)
		JCheckBox[] checkBoxes = new JCheckBox[moneyInt.length];
		// JTextField 배열 생성 (크기는 위와 동일)
		JTextField[] textFields = new JTextField[moneyInt.length];
		public MyPanel() {
			// 배경색을 PINK 로 설정 (디폴트 색생 빼고 다른 색으로 정의 가능)
			setBackground(Color.PINK);
			// 판넬 하나 생성
			JPanel jp = new JPanel();
			// 판넬 색상을 위 정의한 색상과 동일하게 설정
			jp.setBackground(Color.PINK);
			// "금액" 라벨을 가지는 라벨 하나 생성
			JLabel label = new JLabel("금액");
			// 15크기의 텍스트필드 하나 생성 (금액)
			JTextField tf = new JTextField(15);
			// "계산" 라벨을 가지는 버튼 하나 생성
			JButton bt = new JButton("계산");
			// 판넬에 라벨, 텍스트필드, 버튼 순서대로 붙이기
			jp.add(label);
			jp.add(tf);
			jp.add(bt);
			// 판넬 붙이기
			add(jp);
			// 센터 판넬 하나 생성
			JPanel centerPanel = new JPanel();
			// 센터 판넬의 레이아웃 설정 - GridLayout (row, col) : hint) 위 배열의 길이가 행의 갯수이고, 컬럼의 경우 라벨, 텍스트필드, 콤보박스가 들어간다.
			centerPanel.setLayout(new GridLayout(moneyInt.length, 3));
			// 센터 판넬의 배경색 설정 (위 정의한 색상과 동일하게 설정)
			centerPanel.setBackground(Color.PINK);
			// 배열(클래스의 처음에 정의해준) 의 길이만큼 돌면서
			for (int i=0; i<moneyString.length; i++) {
				// 라벨을 practice.String 배열의 값을 하나씩 받아오면서 설정
				JLabel lb = new JLabel(moneyString[i]);
				// 위 텍스트필드 배열에서 각각의 인덱스에 크기 10인 텍스트 필드를 생성
				textFields[i] = new JTextField(10);
				// 위 콤보박스 배열에서 각각의 인덱스에 체크 박스 생성 ("", false)
				checkBoxes[i] = new JCheckBox("", false);
				// 콤보 박스의 opaque 를 false로 설정
				checkBoxes[i].setOpaque(false);
				// 센터 판넬에 라벨, 텍스트 필드, 콤보박스를 순서대로 추가
				centerPanel.add(lb);
				centerPanel.add(textFields[i]);
				centerPanel.add(checkBoxes[i]);
			}
			// 센터 판넬 추가
			add(centerPanel);

			// "계산" 버튼에 ActionListener 추가
			bt.addActionListener(new ActionListener() {
				// actionPerformed 함수 재정의
				public void actionPerformed(ActionEvent e) {
					// 첫 텍스트 필드에서 값을 가져옴
					String tfMoney = tf.getText();
					// 만약 텍스트 필드에 아무것도 입력되어 있지 않다면 --> return ;
					if (tf.getText().isEmpty()) return;
					// 텍스트 필드 값을 Integer 값으로 변경 (parseInt)
					int money = Integer.parseInt(tfMoney);
					// 변수 하나 생성 (몇 장 or 몇 개 계산할 변수)
					int count;
					// 배열의 길이만큼 반복하면서
					for (int i=0; i<moneyString.length; i++) {
						// 몫 구하기(몇 장 or 몇 개) = (현재 돈 / 현재 단위)
						count = money/moneyInt[i];
						// 1. i가 1원인 경우, 1원에 해당하는 textfield 에 현재 가지고 있는 돈을 모두 셋 (integer toString)
						if (moneyInt[i] == 1) {
							// --> break;
							textFields[i].setText(Integer.toString(money));
							break;
						}
						// 2. 콤보박스가 선택되지 않은 경우
						else if (!checkBoxes[i].isSelected()) {
							// --> 0으로 세팅하기, continue;
							textFields[i].setText("0");
							continue;
						}
						// 3. 나머지 경우들
						else {
							// 현재 단위번째에 해당하는 텍스트 필드에 현재 몫(몇 장 or 몇 개) 세팅하기
							textFields[i].setText(Integer.toString(count));
							// 남은 돈을 (현재 돈 % 현재 단위)로 바꾸어 주기 --> 이미 사용한 단위에 대해서는 빼주는 것
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
