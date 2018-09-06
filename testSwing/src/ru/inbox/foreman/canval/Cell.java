package ru.inbox.foreman.canval;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Cell extends Canvas {
    private boolean mouseEnter = false;
    private boolean isHide = false;
    private int button = 0;

    public Cell() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button = e.getButton();
                isHide = true;
                repaint();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                //  System.out.println("in");
                mouseEnter = true;
                repaint();

            }

            @Override
            public void mouseExited(MouseEvent e) {
                //  System.out.println("out");
                mouseEnter = false;
                repaint();
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        //       g.fillRect(getBounds().x + 1, getBounds().y + 1, getBounds().width - 2, getBounds().height - 2);
        if (!isHide) {
            if (!mouseEnter) {
                g.drawRect(getBounds().x + 1, getBounds().y + 1, getBounds().width - 2, getBounds().height - 2);
            } else {
                g.drawRect(getBounds().x + 4, getBounds().y + 4, getBounds().width - 8, getBounds().height - 8);
                g.drawRect(getBounds().x + 5, getBounds().y + 5, getBounds().width - 10, getBounds().height - 10);
            }
        } else {
            g.setColor(Color.GRAY);
            g.fillRect(getBounds().x + 1, getBounds().y + 1, getBounds().width - 2, getBounds().height - 2);
            g.setColor(Color.BLUE);
            g.setFont(new Font("Arial", Font.BOLD, getBounds().height / 2));

            g.drawString(String.valueOf(button), getBounds().width * 2 / 5, getBounds().height * 2 / 3);
        }
    }



    public static void main(String[] arg) {
        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(140, 70);
//
//        JPanel panel = new JPanel();
//        panel.setLayout(new GridLayout(1, 3));
        frame.getContentPane().add(new Cell());
        //    JPanel panel1 = new JPanel();
//        panel.add(new Cell());
//   //     panel1.setLayout(new GridLayout(1, 1));
//    //    JPanel panel2 = new JPanel();
//    //    panel2.setLayout(new GridLayout(1, 1));
//        panel.add(new Cell());
//    //    JPanel panel3 = new JPanel();
//    //    panel3.setLayout(new GridLayout(1, 1));
//        panel.add(new Cell());
////        panel.add(panel1);
////        panel.add(panel2);
//        panel.add(panel3);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}