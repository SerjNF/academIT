package ru.inbox.foreman.paint;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Cell extends JPanel {
    private boolean mouseEnter = false;
    private boolean isHide = false;
    private int button = 0;

    Cell() {

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
    public void paintComponent(Graphics g) {

        super.paintComponent(g);

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

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 3));
        frame.getContentPane().add(panel);
        JPanel panel1 = new JPanel();
        panel1.add(new Cell());
        panel1.setLayout(new GridLayout(1, 1));
        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(1, 1));
        panel2.add(new Cell());
        JPanel panel3 = new JPanel();
        panel3.setLayout(new GridLayout(1, 1));
        panel3.add(new Cell());
        panel.add(panel1);
        panel.add(panel2);
        panel.add(panel3);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
