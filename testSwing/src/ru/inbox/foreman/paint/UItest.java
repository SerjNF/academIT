package ru.inbox.foreman.paint;



import javax.swing.*;
import java.awt.*;

public class UItest {
    JFrame frame;
    int x = 15, y = 12;
    CellGr[][] cells;
    private UItest(){
        cells = new CellGr[x][y];
        frame = new JFrame();
        frame.getContentPane().add(createFieldCells());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setSize(500,500);
    }

    private JPanel createFieldCells() {
        JPanel panel = new JPanel(new GridLayout(x, y));
        for(int i = 0; i < x; i++){
            for (int j = 0; j < y; j++){
                JPanel p = new JPanel(new BorderLayout());
                CellGr c = new CellGr();
                p.add(c);
                cells[i][j] = c;
                panel.add(p);
            }
        }

        return panel;
    }

    public static void main (String[] arg){
        new UItest();
    }
}
