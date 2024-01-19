package practice.JavaBasic.Lab12;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrawOvalWithMouse extends JFrame {
	public DrawOvalWithMouse() {
		// title 설정
		super("2313398 주아정 - DrawOvalWithMouse");
		//  MyPanel add
		MyPanel myPanel = new MyPanel();
		setContentPane(myPanel);
		// default Close operation 설정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 창크기 400, 300
		setSize(400, 300);
		// Visible 설정
		setVisible(true);
	}

	class Circle {
		// x, y, radius 변수 - private
		private int x, y, radius;
		// 생성자 - 받아온 x, y, radius 를 초기화
		public Circle(int x, int y, int radius) {
			this.x = x;
			this.y = y;
			this.radius = radius;
		}

		public Point getPoint() {
			// 시작 위치 return --> 마우스 클릭으로부터 받아온 위치 - radius (받아온 위치는 원의 중심)
			return new Point(x-radius, y-radius);
		}

		public int getSize() {
			// 반지름 * 2 --> 원의 지름 길이로 그려야 하므로 반지름 * 2
			return radius * 2;
		}
	}

	class MyPanel extends JPanel {
		// circle 타입의 Vector 선언
		Vector<Circle> circleVector = new Vector<>();
		// 시작 포인트를 나타내는 변수 선언
		private Point startPoint = null;
		// 드래그 됐을 경우의 그려질 원의 정보를 담는 Circle 변수 선언
		private Circle dragged = null;

		public void paintComponent(Graphics g) {
			//super()
			super.paintComponent(g);
			//색깔 지정 - >green
			setForeground(Color.GREEN);
			//드래그가 되었을 경우 dragged 객체를 그려주기
			if (dragged != null) {
				Point p = dragged.getPoint();
				g.drawOval(p.x, p.y, dragged.getSize(), dragged.getSize());
			}
			
			//vector 안에 있는 circle 객체들을 그려주기 - for문 사용
			for (int i=0; i<circleVector.size(); i++) {
				Circle p = circleVector.get(i);
				Point loc = p.getPoint();
				g.drawOval(loc.x, loc.y, p.getSize(), p.getSize());
			}
			
		}

		public MyPanel() {
			this.addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					// 이벤트 일어난 위치를 통해 시작 포인트 받아오기
					startPoint = e.getPoint();
				}
				
				public void mouseReleased(MouseEvent e) {
					//이벤트 일어난 x좌표, y좌표 받아오기
					Point endPoint = e.getPoint();
					double x1 = startPoint.getX();
					double y1 = startPoint.getY();
					double x2 = endPoint.getX();
					double y2 = endPoint.getY();
					// root((x2-x1)^2 + (y2-y1)^2)
					double len = Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2);
					int radius = (int) Math.sqrt(len);
					// 벡터에 새로운 circle 객체 만들어서 추가
					circleVector.add(new Circle(startPoint.x, startPoint.y, radius));
					// repaint()
					repaint();
				}
			});
			
			this.addMouseMotionListener(new MouseAdapter() {
				public void mouseDragged(MouseEvent e) {
					//이벤트 일어난 x좌표, y좌표 받아오기
					Point endPoint = e.getPoint();
					double x1 = startPoint.getX();
					double y1 = startPoint.getY();
					double x2 = endPoint.getX();
					double y2 = endPoint.getY();
					// x2-x1 ^2 + y2-y1 ^2 --> root
					double len = Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2);
					int radius = (int) Math.sqrt(len);
					//  새로운 circle 객체 만들어서 dragged로 관리
					dragged = new Circle(startPoint.x, startPoint.y, radius);
					// repaint()
					repaint();
				
				}
			});
		}
	}

	public static void main(String[] args) {
		new DrawOvalWithMouse();
	}
}