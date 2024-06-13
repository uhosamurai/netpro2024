import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

public class FacesAWTMain {

    public static void main(String[] args){
        new FacesAWTMain();
    }

    FacesAWTMain(){
        FaceFrame f = new FaceFrame();
        f.setSize(800,800);
        f.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
        f.setVisible(true);
    }

    class FaceFrame extends Frame {
        private FaceObj[] fobjs = new FaceObj[9];
        private Random rand = new Random();

        FaceFrame(){
            for(int j=0; j<3; j++) {
                for (int i = 0; i < 3; i++) {
                    fobjs[i + 3 * j] = new FaceObj();
                    fobjs[i + 3 * j].setPosition(200 * i + 50, 200 * j + 50);
                    fobjs[i + 3 * j].setEmotionLevel(rand.nextInt(3));
                    fobjs[i + 3 * j].setFaceColor(new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256))); // ランダムに顔の色を選択
                    fobjs[i + 3 * j].setEyeShape(rand.nextInt(3)); 
                    fobjs[i + 3 * j].setEyeColor(new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256))); // ランダムに目の色を選択
                }
            }
        }

        public void paint(Graphics g) {
            for(FaceObj fobj : fobjs) {
                fobj.drawFace(g);
            }
        }
    }

    private class FaceObj {
        private int x;
        private int y;
        private int emotionLevel;
        private Color faceColor;
        private int eyeShape;
        private Color eyeColor;

        FaceObj() {
        }

        public void setPosition(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void setEmotionLevel(int level) {
            this.emotionLevel = level;
        }

        public void setFaceColor(Color color) {
            this.faceColor = color;
        }

        public void setEyeShape(int shape) {
            this.eyeShape = shape;
        }

        public void setEyeColor(Color color) {
            this.eyeColor = color;
        }

        public void drawFace(Graphics g) {
            g.setColor(faceColor);
            drawRim(g);
            g.setColor(eyeColor);
            drawEyes(g);
            drawNose(g);
            drawMouth(g);
        }

        private void drawRim(Graphics g) {
            int w = 200;
            int h = 200;
            g.drawRect(x, y, w, h);
        }

        private void drawEyes(Graphics g) {
            switch (eyeShape) {
                case 0:
                    g.drawOval(x + 45, y + 65, 35, 35);
                    g.drawOval(x + 115, y + 65, 35, 35);
                    break;
                case 1:
                    g.drawRect(x + 45, y + 65, 35, 35);
                    g.drawRect(x + 115, y + 65, 35, 35);
                    break;
                case 2:
                    g.drawPolygon(new int[]{x + 62, x + 45, x + 80}, new int[]{y + 65, y + 100, y + 100}, 3);
                    g.drawPolygon(new int[]{x + 132, x + 115, x + 150}, new int[]{y + 65, y + 100, y + 100}, 3);
                    break;
            }
        }

        private void drawNose(Graphics g) {
            int noseX = x + 100;
            int noseY = y + 90;
            g.drawLine(noseX, noseY, noseX, noseY + 40);
        }

        private void drawMouth(Graphics g) {
            int mouthX = x + 50;
            int mouthY = y + 150;
            if (emotionLevel % 3 == 0) {
                // Smile
                g.drawArc(mouthX, mouthY, 100, 50, 0, -180);
            } else if (emotionLevel % 3 == 1) {
                // Frown
                g.drawArc(mouthX, mouthY + 20, 100, 50, 0, 180);
            } else {
                // Straight
                g.drawLine(mouthX, mouthY + 25, mouthX + 100, mouthY + 25);
            }
        }
    }
}

