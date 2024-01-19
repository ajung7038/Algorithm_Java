package practice.JavaBasic.Lab12;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrawOvalWithMouse extends JFrame {
	public DrawOvalWithMouse() {
		// title ����
		super("2313398 �־��� - DrawOvalWithMouse");
		//  MyPanel add
		MyPanel myPanel = new MyPanel();
		setContentPane(myPanel);
		// default Close operation ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// âũ�� 400, 300
		setSize(400, 300);
		// Visible ����
		setVisible(true);
	}

	class Circle {
		// x, y, radius ���� - private
		private int x, y, radius;
		// ������ - �޾ƿ� x, y, radius �� �ʱ�ȭ
		public Circle(int x, int y, int radius) {
			this.x = x;
			this.y = y;
			this.radius = radius;
		}

		public Point getPoint() {
			// ���� ��ġ return --> ���콺 Ŭ�����κ��� �޾ƿ� ��ġ - radius (�޾ƿ� ��ġ�� ���� �߽�)
			return new Point(x-radius, y-radius);
		}

		public int getSize() {
			// ������ * 2 --> ���� ���� ���̷� �׷��� �ϹǷ� ������ * 2
			return radius * 2;
		}
	}

	class MyPanel extends JPanel {
		// circle Ÿ���� Vector ����
		Vector<Circle> circleVector = new Vector<>();
		// ���� ����Ʈ�� ��Ÿ���� ���� ����
		private Point startPoint = null;
		// �巡�� ���� ����� �׷��� ���� ������ ��� Circle ���� ����
		private Circle dragged = null;

		public void paintComponent(Graphics g) {
			//super()
			super.paintComponent(g);
			//���� ���� - >green
			setForeground(Color.GREEN);
			//�巡�װ� �Ǿ��� ��� dragged ��ü�� �׷��ֱ�
			if (dragged != null) {
				Point p = dragged.getPoint();
				g.drawOval(p.x, p.y, dragged.getSize(), dragged.getSize());
			}
			
			//vector �ȿ� �ִ� circle ��ü���� �׷��ֱ� - for�� ���
			for (int i=0; i<circleVector.size(); i++) {
				Circle p = circleVector.get(i);
				Point loc = p.getPoint();
				g.drawOval(loc.x, loc.y, p.getSize(), p.getSize());
			}
			
		}

		public MyPanel() {
			this.addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					// �̺�Ʈ �Ͼ ��ġ�� ���� ���� ����Ʈ �޾ƿ���
					startPoint = e.getPoint();
				}
				
				public void mouseReleased(MouseEvent e) {
					//�̺�Ʈ �Ͼ x��ǥ, y��ǥ �޾ƿ���
					Point endPoint = e.getPoint();
					double x1 = startPoint.getX();
					double y1 = startPoint.getY();
					double x2 = endPoint.getX();
					double y2 = endPoint.getY();
					// root((x2-x1)^2 + (y2-y1)^2)
					double len = Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2);
					int radius = (int) Math.sqrt(len);
					// ���Ϳ� ���ο� circle ��ü ���� �߰�
					circleVector.add(new Circle(startPoint.x, startPoint.y, radius));
					// repaint()
					repaint();
				}
			});
			
			this.addMouseMotionListener(new MouseAdapter() {
				public void mouseDragged(MouseEvent e) {
					//�̺�Ʈ �Ͼ x��ǥ, y��ǥ �޾ƿ���
					Point endPoint = e.getPoint();
					double x1 = startPoint.getX();
					double y1 = startPoint.getY();
					double x2 = endPoint.getX();
					double y2 = endPoint.getY();
					// x2-x1 ^2 + y2-y1 ^2 --> root
					double len = Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2);
					int radius = (int) Math.sqrt(len);
					//  ���ο� circle ��ü ���� dragged�� ����
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