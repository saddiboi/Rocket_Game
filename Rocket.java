import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
//JPanel is declared as a super class.
public class Rocket extends JPanel {

    private Frame frame;
    // the coordinates for the shapes are declared.
    private int ovalX = 750, ovalY = 750;
    private int circleX = 725, circleY = 725;
    private int[] triangleX = {700,775,850}, triangleY = {900,800,900};
    private int lineX1 = 770, lineY1 = 930, lineX2 = 770, lineY2 = 965;
    // initial color for the shapes are declared.
    private Color ovalColor = new Color(128,128,128);
    private Color circleColor = new Color(255,255,255);
    private Color triangleColor = new Color(44, 117, 255);
    private Color lineColor = new Color(255,0,0);
    // a new random object is created.
    private Random random = new Random();
    // the coordinates and color for the rock
    private int[] rockX = {
        random.nextInt(1400), 
        random.nextInt(1400), 
        random.nextInt(1400),
        random.nextInt(1400),
        random.nextInt(1400),
        random.nextInt(1400),
        random.nextInt(1400),
        random.nextInt(1400),
        random.nextInt(1400),
        random.nextInt(1400),
        random.nextInt(1400),
        random.nextInt(1400),
        random.nextInt(1400)};
    private int[] rockY = {
        random.nextInt(600), 
        random.nextInt(600), 
        random.nextInt(600),
        random.nextInt(600),
        random.nextInt(600),
        random.nextInt(600),
        random.nextInt(600),
        random.nextInt(600),
        random.nextInt(600),
        random.nextInt(600),
        random.nextInt(600),
        random.nextInt(600),
        random.nextInt(600)};
    private Color[] rockColor = {
        new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)), 
        new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)),
        new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)),
        new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)),
        new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)),
        new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)),
        new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)),
        new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)),
        new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)),
        new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)),
        new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)),
        new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)),
        new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255))};
    // The cordinates for the reset
    private final int START_OVAL_X = 750, START_OVAL_Y = 750;
    private final int START_CIRCLE_X = 725, START_CIRCLE_Y = 725;
    private final int[] START_TRIANGLE_X = {700,775,850}, START_TRIANGLE_Y = {900,800,900};
    private final int START_LINE_X1 = 770, START_LINE_Y1 = 930, START_LINE_X2 = 770, START_LINE_Y2 = 965;
    // the cordinates for the win box
    private int winX = 1200, winY = 100, winW = 250, winH = 150;
    private boolean hasWon = false;

    public Rocket() {
        // a new JFrame objected is created and modified.
        frame = new JFrame("Rocket");
        this.setBackground(Color.BLACK);
        this.setPreferredSize(new Dimension(1500, 1000));
        frame.add(this);
        frame.pack();
        this.setLayout(null);
        frame.setVisible(true);
        ((JFrame) frame).setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //a new object named KeyTracker is created which implements the KeyListener.
        KeyTracker kt = new KeyTracker();
        frame.addKeyListener(kt);
        frame.setFocusable(true);
        frame.requestFocusInWindow();
        //a new Jbutton object is created
        JButton button = new JButton();
        button.setText("Difficult!!!");
        button.setBounds(10, 10, 130, 30);
        this.add(button);
        // a buttonlistener object is created and ActionListener is added
        ButtonListener bl = new ButtonListener();
        button.addActionListener(bl);
        
        // reset button implementation
        JButton resetButton = new JButton("Reset");
        resetButton.setBounds(10, 50, 130, 30);
        this.add(resetButton);

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();                               
                SwingUtilities.invokeLater(() -> new Rocket());
    }
});

    }
    // a private class Buttonlistener that implements ActionListener. this performs the Action for changing the color when button is pressed
    private class ButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            ovalColor = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
            circleColor = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
            triangleColor = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
            lineColor = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
            for (int i = 0; i < rockColor.length; i++) {
                rockColor[i] = Color.BLACK;
            }
            repaint();
            frame.requestFocusInWindow();
        }  
    }
    //a public class KeyTracker that implements ActionListner. This moves the 2D objects with "WASD" keys.
    public class KeyTracker implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {}

        @Override
        public void keyPressed(KeyEvent e) {
            char key = e.getKeyChar();
            switch (key) {
                case 'a':
                    ovalX -= 10;
                    circleX -= 10;
                    lineX1 -= 10;
                    lineX2 -= 10;
                    for(int i=0; i<triangleX.length; i++)
                        triangleX[i] -= 10;
                    break;
                case 'd':
                    ovalX += 10;
                    circleX += 10;
                    lineX1 += 10;
                    lineX2 += 10;
                    for(int i=0; i<triangleX.length; i++)
                        triangleX[i] += 10;
                    break;
                case 'w':
                    ovalY -= 10;
                    circleY -= 10;
                    lineY1 -= 10;
                    lineY2 -= 10;
                    for(int i=0; i<triangleY.length; i++)
                        triangleY[i] -= 10;
                    break;
                case 's':
                    ovalY += 10;
                    circleY += 10;
                    lineY1 += 10;
                    lineY2 += 10;
                    for(int i=0; i<triangleY.length; i++)
                        triangleY[i] += 10;
                    break;
            }
            Rectangle rocketCircle = new Rectangle(circleX, circleY,100, 200);
            for (int i = 0; i < rockX.length; i++) {
                Rectangle rock = new Rectangle(rockX[i], rockY[i], 100, 100);

                if (rocketCircle.intersects(rock)) {
                    // Reset all rocket parts back to original positions
                    ovalX = START_OVAL_X;
                    ovalY = START_OVAL_Y;
                    circleX = START_CIRCLE_X;
                    circleY = START_CIRCLE_Y;
                    for (int j = 0; j < triangleX.length; j++) {
                    triangleX[j] = START_TRIANGLE_X[j];
                    triangleY[j] = START_TRIANGLE_Y[j];
                }
                lineX1 = START_LINE_X1;
                lineY1 = START_LINE_Y1;
                lineX2 = START_LINE_X2;
                lineY2 = START_LINE_Y2;
                }
            }
            hasWon = rocketCircle.intersects(new Rectangle(winX, winY, winW, winH));
            repaint();
        }

        @Override
        public void keyReleased(KeyEvent e) {}
    }
    //PaintComponent is added which paints the 2D shapes.
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;

        g2D.setPaint(triangleColor);
        g2D.fillPolygon(triangleX,triangleY,3);

        g2D.setPaint(circleColor);
        g2D.fillOval(circleX, circleY, 100, 200);

        g2D.setPaint(ovalColor);
        g2D.fillOval(ovalX, ovalY, 50, 50);

        g2D.setPaint(lineColor);
        g2D.setStroke(new BasicStroke(10));
        g2D.drawLine(lineX1, lineY1, lineX2, lineY2);

        g2D.setStroke(new BasicStroke(10));
        g2D.drawLine(lineX1+5, lineY1, lineX2+5, lineY2+10);

        g2D.setStroke(new BasicStroke(10));
        g2D.drawLine(lineX1+10, lineY1, lineX2+10, lineY2);
        // drawing rocks
        for (int i=0; i<rockX.length; i++){
            g2D.setPaint(rockColor[i]);
            g2D.fillOval(rockX[i], rockY[i], 100, 100);
        }
        // drawing the win box
        g2D.setPaint(Color.GREEN);
        g2D.setStroke(new BasicStroke(6));
        g2D.drawRect(winX, winY, winW, winH);
        if (hasWon) {
        g2D.setPaint(Color.WHITE);
        g2D.setFont(new Font("SansSerif", Font.BOLD, 36));
        g2D.drawString("   YOU WIN", winX + 20, winY + winH / 2);
        }
    }
}