package ru.inbox.foreman.paint;

import ru.inbox.foreman.paint.ButtonRollover;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public class Cell extends JLabel {
    boolean mouseEnter = false;
    boolean isHide = false;
    Icon normal;
    Icon rollover;
    Icon selected;

    Cell() {

        normal = new ButtonRollover.ColorIcon(Color.GREEN, 10, 10);
        rollover = new ButtonRollover.ColorIcon(Color.RED, 10, 10);
        selected = new ButtonRollover.ColorIcon(Color.BLUE, 10, 10);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int clickNumber = e.getClickCount();
                //  e.
                isHide = true;
                repaint();
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
    }

//    private void pintB() {
//        repaint(new Rectangle(10,10,20,20));
//    }

    @Override
    public void paint(Graphics g) {

        super.paint(g);
        g.fillRect(getBounds().x + 20, getBounds().y + 20, getBounds().width - 40, getBounds().height - 40);
        if (!isHide) {
            if (!mouseEnter) {
                g.drawRect(getBounds().x + 10, getBounds().y + 10, getBounds().width - 20, getBounds().height - 20);
            } else {
                g.drawRect(getBounds().x + 4, getBounds().y + 4, getBounds().width - 8, getBounds().height - 8);
                g.drawRect(getBounds().x + 5, getBounds().y + 5, getBounds().width - 10, getBounds().height - 10);
            }
        } else {
            g.setColor(Color.GRAY);
            g.fillRect(getBounds().x + 5, getBounds().y + 5, getBounds().width - 10, getBounds().height - 10);
            g.setColor(Color.BLUE);
            g.drawString("1", getBounds().width / 2, getBounds().height / 2);
        }
    }

    public static void main(String[] arg) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 3));
//        frame.getContentPane().add(new Cell());
//        frame.getContentPane().add(new Cell());
        panel.add(new Cell());
        panel.add(new Cell());
        panel.add(new Cell());
        panel.add(new Cell());
        panel.add(new Cell());
        panel.add(new Cell());
        panel.add(new Cell());
        panel.add(new Cell());
        panel.add(new Cell());
        panel.updateUI();
        frame.getContentPane().add(panel, CENTER);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        //  frame.pack();
    }

}
