package ru.inbox.foreman.paint;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ButtonRollover extends JFrame
{
    Icon normal;
    Icon rollover;
    Icon selected;

    public ButtonRollover()
    {
        MouseListener ml = new RolloverButtonListener();

        normal = new ColorIcon(Color.GREEN, 10, 10);
        rollover = new ColorIcon(Color.RED, 10, 10);
        selected = new ColorIcon(Color.BLUE, 10, 10);

        setLayout( new FlowLayout() );

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar( menuBar );

        JMenu menu = (JMenu)createButton(new JMenu(), "Menu");
        menu.addMouseListener( ml );
        menuBar.add( menu );

        JMenuItem menuItem = (JMenuItem)createButton(new JMenuItem(), "MenuItem");
        menuItem.addMouseListener( ml );
        menu.add( menuItem );

        JButton button = (JButton)createButton(new JButton(), "Button");
        add( button );

        JCheckBox checkBox = (JCheckBox)createButton(new JCheckBox(), "CheckBox");
        add( checkBox );

        JRadioButton radioButton = (JRadioButton)createButton(new JRadioButton(), "RadioButton");
        add( radioButton );
    }


    public AbstractButton createButton(AbstractButton button, String text)
    {
        button.setText( text );
        button.setIcon( normal );
        button.setSelectedIcon( selected );
        button.setRolloverIcon( rollover );
        button.setRolloverSelectedIcon( rollover );

        System.out.println( text );
        MouseListener[] mls = button.getMouseListeners();

        for (MouseListener ml: mls)
        {
            System.out.println( "\t" + ml);
        }

        return button;
    }

    class RolloverButtonListener extends MouseAdapter
    {
        private Icon normal;

        public void mouseEntered(MouseEvent e)
        {
            AbstractButton b = (AbstractButton) e.getSource();
            ButtonModel model = b.getModel();

            if (b.isRolloverEnabled() && !SwingUtilities.isLeftMouseButton(e))
            {
                normal = b.getIcon();
                b.setIcon(b.getRolloverIcon());
                model.setRollover(true);
            }
        }

        public void mouseExited(MouseEvent e)
        {
            AbstractButton b = (AbstractButton) e.getSource();
            ButtonModel model = b.getModel();

            if(b.isRolloverEnabled())
            {
                b.setIcon( normal );
                model.setRollover(false);
            }
        };

    }

    public static class ColorIcon implements Icon
    {
        private Color color;
        private int width;
        private int height;

        public ColorIcon(Color color, int width, int height)
        {
            this.color = color;
            this.width = width;
            this.height = height;
        }

        public int getIconWidth()
        {
            return width;
        }

        public int getIconHeight()
        {
            return height;
        }

        public void paintIcon(Component c, Graphics g, int x, int y)
        {
            g.setColor(color);
            g.fillRect(x, y, width, height);
        }
    }

    public static void main(String[] args)
    {
        try
        {
//          UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception e) { }

        ButtonRollover frame = new ButtonRollover();
        frame.setDefaultCloseOperation( EXIT_ON_CLOSE );
        frame.setSize(400, 200);
        frame.setLocationRelativeTo( null );
        frame.setVisible(true);
    }
}