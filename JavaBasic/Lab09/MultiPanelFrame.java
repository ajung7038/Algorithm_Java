package JavaBasic.Lab09;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MultiPanelFrame extends JFrame { // JFrame 상속

	public JPanel getNorthPanel() {
		//JPanel 생성
		JPanel jp = new JPanel();
		//north panel 에 존재하는 버튼 3개 생성(열기, 닫기, 나가기)
		JButton jb1 = new JButton("열기");
		JButton jb2 = new JButton("닫기");
		JButton jb3 = new JButton("나가기");
		//panel 에 붙이기
		jp.add(jb1);
		jp.add(jb2);
		jp.add(jb3);
		//panel return
		return jp;
	}
	
	public JPanel getSouthPanel() {
		//JPanel 생성
		JPanel jp = new JPanel();
		//button 생성 - "Word Input"
		JButton jb = new JButton("Word Input");
		//size 15인 textField 생성
		JTextField textField = new JTextField(15);
		//panel 에 button, textfield 붙이기 
		jp.add(jb);
		jp.add(textField);
		//panel return
		return jp;
	}
	
	public int getRandomLocation() {
		// return random 한 값 20~220
		return (int)(Math.random()*200 + 20);
	}
	
	public JPanel getCenterPanel() {
		//JPanel 생성
		JPanel jp = new JPanel();
		//layout null 로 설정
		jp.setLayout(null);
		//배경색 흰색으로 설정
		jp.setBackground(Color.WHITE);
		// size 5 인 JLabel list 생성
		JLabel[] label = new JLabel[5];
		//jlabel length for loop....
		for (int i=0; i<label.length; i++) {
			//각 요소 별 JLabel 생성 "*"
			label[i] = new JLabel("*");
			//fontcolor - setForegroud 함수 사용
			label[i].setForeground(Color.RED);
			//size 10*10
			label[i].setSize(10, 10);
			//location 설정 - getRandomLocation 호출
			label[i].setLocation(getRandomLocation(), getRandomLocation());
			//panel 에 label 붙이기
			jp.add(label[i]);
		}
		//return panel 
		 return jp;
	}
	
	public MultiPanelFrame() {
		//부모 생성자 호출, parameter : 학번 + 이름 + 클래스 이름;
		super("2313398 주아정 - MultiPanelFrame");
		//DefaultCloseOperation- JFrame.EXIT_ON_CLOSE
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//panel 하나 생성
		JPanel jp = new JPanel();
		//BorderLayout 으로 설정
		jp.setLayout(new BorderLayout());
		//각 위치 별 panel 붙이기(함수 호출 getNorth...)
		jp.add(getNorthPanel(), "North");
		jp.add(getSouthPanel(), "South");
		jp.add(getCenterPanel(), "Center");
		//panel 붙이기
		add(jp);
		//visible 설정
		setVisible(true);
		//size 350*350  
		setSize(350, 350);
	}

	public static void main(String[] args) {
		new MultiPanelFrame();
	}

}
