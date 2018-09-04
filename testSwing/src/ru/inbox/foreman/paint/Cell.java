package ru.inbox.foreman.paint;

import ru.inbox.foreman.paint.ButtonRollover;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public class Cell extends JLabel {

    Icon normal;
    Icon rollover;
    Icon selected;

    Cell(){

        normal = new ButtonRollover.ColorIcon(Color.GREEN, 10, 10);
        rollover = new ButtonRollover.ColorIcon(Color.RED, 10, 10);
        selected = new ButtonRollover.ColorIcon(Color.BLUE, 10, 10);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setToolTipText("Clicked");
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
                pintB();

            }

            @Override
            public void mouseExited(MouseEvent e) {
                System.out.println("out");
              //  setText("OUT");
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

    private void pintB() {
        repaint(new Rectangle(10,10,20,20));
    }

//    @Override
//    public void paint(Graphics g){
//
//        //super.paint(getGraphics());
//        super.paint(g);
//        g = getGraphics();
//        g.drawRect(getBounds().x, getBounds().y, getBounds().width, getBounds().height);
//        System.out.println("Shit happends" + "\n");
//    }

    public static void main(String[] arg){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.add(new Cell());
        frame.add(new Cell());
        frame.setLocationRelativeTo( null );
        frame.setVisible(true);
    }

}
