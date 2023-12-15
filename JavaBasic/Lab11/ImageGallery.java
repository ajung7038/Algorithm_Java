package JavaBasic.Lab11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.Vector;

public class ImageGallery extends JFrame {
	// ImageIcon 타입의 Vector 만들기 - private
	private Vector<ImageIcon> imgVector = new Vector<>();
	// 초기값 0인 index 변수 생성하기 - private
	private int index = 0;

	// 이미지 파일들을 가져와서 Vector 에 넣어주는 함수
	public void loadImages(String path) {
		// path 위치 파일 변수 생성
		File f = new File(path);
		// 생성한 파일 변수를 이용하여 해당 폴더의 하위에 존재하는 파일들의 목록 가져오기 --> listFiles()
		File[] files = f.listFiles();
		// 하위 파일들의 목록 갯수만큼 for 문을 반복하여 imgVector에 넣어주기 (ImageIcon 형태로 변형하여)
		for (int i=0; i<files.length; i++) {
			imgVector.add(new ImageIcon(files[i].getPath()));
		}
	}
	
	public ImageGallery() {
		// 학번 이름 - 클래스 제목으로 타이틀 설정
		super("2313398 주아정 - ImageGallery");
		// panel 하나 생성 (전체 판넬, BorderLayout)
		JPanel jp = new JPanel(new BorderLayout());
		// 라디오 버튼 가질 판넬 하나 생성
		JPanel radioPanel = new JPanel();
		// JRadioButton 두개 생성 - left(true), right
		JRadioButton leftButton = new JRadioButton("left", true);
		JRadioButton rightButton = new JRadioButton("right", false);
		// 라디오 버튼 두개를 버튼 그룹으로 묶어주기 - ButtonGroup .add
		ButtonGroup btGroup = new ButtonGroup();
		btGroup.add(leftButton);
		btGroup.add(rightButton);
		// loadImages 함수를 호출하여 현재 프로젝트 하위의 images 폴더에 있는 사진 목록 가져오기
		loadImages("C:/Users/ajung/Documents/GitHub/Algorithm/JavaBasic/Lab11/images");
		// JLabel 를 사용하여 이미지 가져오기 - 생성자 호출 시 vector 의 0번째 값으로 첫 이미지 설정하기
		JLabel img = new JLabel(imgVector.get(0));
		// img(label) 를 클릭하면 다음/이전 이미지를 호출하므로 MouseListener 추가하기
		img.addMouseListener(new MouseAdapter() {
			// mouseClicked 함수를 재정의해주고
			public void mouseClicked(MouseEvent e) {
				// right 라디오 버튼이 눌러졌는지 확인
				if (rightButton.isSelected()) {
					// index 증가하기
					index += 1;
					// 증가한 index 가 범위를 벗어났는지 확인
					if (index > imgVector.size()) {
						index -= 1;
					}
				}
				// left 라디오 버튼이 눌러졌는지 확인
				else if (leftButton.isSelected()) {
					// index 감소하기
					index -= 1;
					// 감소한 index 가 범위를 벗어났는지 확인
					if (index < 0) {
						index += 1;
					}
				}
				//index 를 사용하여 img(label)의 이미지 설정 - setIcon 함수를 이용
				img.setIcon(imgVector.get(index));
			}
		});
		// 라디오 판넬에 라디오버튼 두개 추가
		radioPanel.add(leftButton);
		radioPanel.add(rightButton);
		// 판넬의 북쪽에 라디오 판넬 추가
		jp.add(radioPanel, "North");
		// img(label)을 판넬의 센터에 추가
		jp.add(img, "Center");
		// 판넬 추가
		add(jp);
		// 창 크기 400, 300
		setSize(400, 300);
		// defaultCloseOperation 설정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// visible 설정
		setVisible(true);
	}

	public static void main(String[] args) {
		new ImageGallery();
	}

}
