package ru.inbox.foreman.paint;

import ru.inbox.foreman.paint.ButtonRollover;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public class Cell extends JLabel {
    static int count = 0;
    static int xx = 0;
    static int yy = 0;
    private boolean mouseEnter = false;
    private boolean isHide = false;

    static Color[] colors = {Color.BLACK, Color.GREEN, Color.YELLOW, Color.RED, Color.GREEN, Color.YELLOW, Color.RED, Color.GREEN, Color.YELLOW, Color.BLACK, Color.GREEN, Color.YELLOW};

    Cell() {

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int clickNumber = e.getClickCount();
                //  e.
                isHide = true;

            }

            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                System.out.println("in");
                mouseEnter = true;
                repaint();

            }

            @Override
            public void mouseExited(MouseEvent e) {
                System.out.println("out");
                mouseEnter = false;
                repaint();
            }

            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                super.mouseWheelMoved(e);
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                super.mouseMoved(e);
            }
        });
        count++;
        xx = getBounds().width / 3 + xx;
    }

    @Override
    public void paintComponent(Graphics g) {

     //   super.paintComponent(g);
        g.setColor(colors[count]);
        g.fillRect(getLocation().x + 20+ xx, getLocation().y + 20, getBounds().width - 40, getBounds().height - 40);
        if (!isHide) {
            if (!mouseEnter) {
                g.drawRect(getLocation().x + 10, getLocation().y + 10, getBounds().width - 20, getBounds().height - 20);
            } else {
                g.drawRect(getBounds().x + 4, getBounds().y + 4, getBounds().width - 8, getBounds().height - 8);
                g.drawRect(getBounds().x + 5, getBounds().y + 5, getBounds().width - 10, getBounds().height - 10);
            }
        } else {
            g.setColor(Color.GRAY);
            g.fillRect(getBounds().x + 5, getBounds().y + 5, getBounds().width - 10, getBounds().height - 10);
            g.setColor(colors[count]);
            g.drawString("1", getBounds().width / 2, getBounds().height / 2);
        }
    }

    public static void main(String[] arg) {


        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 3));

//        frame.getContentPane().add(new Cell());
        panel.add(new Cell());
        panel.add(new Cell());
        panel.add(new Cell());

      //  panel.updateUI();
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.getContentPane().add(panel, CENTER);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        //  frame.pack();
    }

}
