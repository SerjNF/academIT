package ru.inbox.foreman.UI;

import ru.inbox.foreman.model.ConvertTemperature;
import ru.inbox.foreman.support.DigitFilter;

import javax.swing.*;
import javax.swing.text.AbstractDocument;
import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Класс окна перевода температур.
 *
 * @author SergeyNF
 * @version 1.0
 * @since 30.08.18
 */
public class MainFrame {
    private JFrame frame;
    private JTextField inputTemp;
    private JComboBox<String> selectInputScale;
    private JComboBox<String> selectResultTempScale;
    private JLabel resultTemp;
    private ConvertTemperature converter;

    private MainFrame() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        converter = new ConvertTemperature();
        createUI();
    }

    public static void main(String[] arg) {
        SwingUtilities.invokeLater(MainFrame::new);
    }

    private void createUI() {
        // меню
        JMenuBar menuBar = createMenu();
        // панель ввода
        JPanel inputPanel = createInputPanel();
        // лэйбел
        JPanel mediumPanel = new JPanel();
        JLabel label = new JLabel(new ImageIcon("icon/konvert.png"), JLabel.CENTER);
        mediumPanel.add(label);
        // панель результата
        JPanel resultPanel = createResultPanel();

        frame = new JFrame("Конвертер темрературы");
        frame.setLayout(new GridLayout(3, 1));
        frame.setJMenuBar(menuBar);
        frame.getContentPane().add(inputPanel);
        frame.getContentPane().add(mediumPanel);
        frame.getContentPane().add(resultPanel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setSize(500, 270);
        frame.setResizable(false);
        //   frame.pack();
    }

    private JMenuBar createMenu() {
        JMenuBar mBar = new JMenuBar();

        JMenu menuScale = new JMenu("Menu");
        menuScale.setMnemonic('m');
        JMenuItem close = new JMenuItem("Exit", new ImageIcon("icon/Exit.png"));
        close.setAccelerator(KeyStroke.getKeyStroke('X', KeyEvent.ALT_MASK));
        close.addActionListener(e -> closeWindow());

        menuScale.add(close);
        mBar.add(menuScale);

        return mBar;
    }


    private void closeWindow() {
        this.frame.dispose();
    }

    private void setResultTemp() {
        String result = converter.convertTemp(selectInputScale.getSelectedIndex(),
                selectResultTempScale.getSelectedIndex(),
                inputTemp.getText());

        resultTemp.setText(result);
    }

    private JPanel createInputPanel() {
        Font font = new Font("Serif", Font.ITALIC, 20);
        selectInputScale = new JComboBox<>(converter.getScaleName());
        selectInputScale.setFont(font);

        inputTemp = new JTextField(15);
        inputTemp.setFont(font);
        inputTemp.setHorizontalAlignment(SwingConstants.RIGHT);
        inputTemp.setText("0");
        //фильтр
        ((AbstractDocument) inputTemp.getDocument()).setDocumentFilter(new DigitFilter());

        JPanel iPanel = new JPanel(new GridLayout(1, 2));
        iPanel.add(selectInputScale);
        iPanel.add(inputTemp);
        return iPanel;
    }

    private JPanel createResultPanel() {
        Font font = new Font("Serif", Font.ITALIC, 20);

        selectResultTempScale = new JComboBox<>(converter.getScaleName());
        selectResultTempScale.setFont(font);
        resultTemp = new JLabel();
        resultTemp.setHorizontalAlignment(SwingConstants.RIGHT);
        resultTemp.setFont(font);

        JPanel rPanel = new JPanel(new GridLayout(1, 2));
        rPanel.add(selectResultTempScale);
        rPanel.add(resultTemp);

        selectResultTempScale.addActionListener(e -> setResultTemp());
        inputTemp.addActionListener(e -> setResultTemp());

        return rPanel;
    }
}
