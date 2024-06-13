

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//配列で5つのボールを動かしてみよう

public class BallMovingAWT {
	public static void main(String[] args) {
		FFrame f = new FFrame();
		f.setSize(700, 400);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		f.show();
	}


	static class FFrame extends Frame implements Runnable {

		Thread th;
		Ball myBall1;
		Ball myBall2;
        Ball myBall3;
        Ball myBall4;
        Ball myBall5;

		private boolean enable = true;
		private int counter = 0;

		FFrame() {
			th = new Thread(this);
			th.start();
		}

		public void run() {


			myBall1 = new Ball();
			myBall1.setPosition(200, 150);
			myBall1.setR(20);
			myBall1.setColor(Color.RED);

			myBall2 = new Ball();
			myBall2.setPosition(50, 250);
			myBall2.setR(40);
			myBall2.setColor(Color.GREEN);

            myBall3 = new Ball();
			myBall3.setPosition(150, 50);
			myBall3.setR(30);
			myBall3.setColor(Color.blue);

            myBall4 = new Ball();
			myBall4.setPosition(200, 120);
			myBall4.setR(35);
			myBall4.setColor(Color.pink);

            myBall5 = new Ball();
			myBall5.setPosition(0, 130);
			myBall5.setR(20);
			myBall5.setColor(Color.YELLOW);

			while (enable) {

				try {
					th.sleep(100);
					counter++;
					if (counter >= 200) enable = false;
				} catch (InterruptedException e) {
				}


				myBall1.move();
				myBall2.move();
                myBall3.move();
                myBall4.move();
                myBall5.move();

				repaint();  // paint()メソッドが呼び出される
			}
		}


		public void paint(Graphics g) {
			myBall1.draw(g);
			myBall2.draw(g);
            myBall3.draw(g);
            myBall4.draw(g);
            myBall5.draw(g);
		}

		// Ball というインナークラスを作る
		class Ball {
			int x;
			int y;
			int r; // 半径
			Color c = Color.RED;

			int xDir = 1;  // 1:+方向  -1: -方向
			int yDir = 1;

			void setColor(Color c) {
				this.c = c;
			}


			void move() {

				if ((xDir == 1) && (x >= 600)) {
					xDir = -1;
				}
				if ((xDir == -1) && (x <= 00)) {
					xDir = 1;
				}

				if (xDir == 1) {
					x = x + 20;
				} else {
					x = x - 20;
				}


				if ((yDir == 1) && (y >= 300)) {
					yDir = -1;
				}
				if ((yDir == -1) && (y <= 100)) {
					yDir = 1;
				}

				if (yDir == 1) {
					y = y + 20;
				} else {
					y = y - 20;
				}


			}


			void setPosition(int x, int y) {
				this.x = x;
				this.y = y;
			}

			void setR(int r) {
				this.r = r;
			}

			void draw(Graphics g) {
				g.setColor(c);
				g.fillOval(x, y, 2 * r, 2 * r);  // rは半径なので2倍にする
			}

		}//innner class Ball end

	}
}

