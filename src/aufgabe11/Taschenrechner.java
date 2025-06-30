package aufgabe11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Taschenrechner extends JFrame {

    JTextField opx;
    JTextField opy;
    JTextField result;
    JRadioButton radiant;
    JRadioButton degree;
    JCheckBox display;
    JButton plus;
    JButton mal;
    JButton minus;
    JButton geteilt;
    JButton sinus;
    JButton cosinus;
    JButton quadrat;
    JButton logarithmus;
    JButton einstelligeFunktion;
    JButton zweistelligeFunktion;
    JButton clear;

    public Taschenrechner() {
        this.setTitle("Taschenrechner");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel opxLabel = new JLabel("Operand x");
        JLabel opyLabel = new JLabel("Operand y");
        JLabel resultLabel = new JLabel("Resultat");
        opx = new JTextField("0", 10);
        opy = new JTextField("0", 10);
        result = new JTextField("0", 10);
        result.setEditable(false);

        degree = new JRadioButton("Deg");
        degree.setSelected(true);
        radiant = new JRadioButton("Rad");
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(degree);
        buttonGroup.add(radiant);
        display = new JCheckBox("Helles Display");
        display.setSelected(true);
        display.addItemListener(
                new ItemListener() {
                    @Override
                    public void itemStateChanged(ItemEvent e) {
                        if (!display.isSelected()) {
                            opx.setBackground(Color.BLACK);
                            opx.setForeground(Color.YELLOW);
                            opy.setBackground(Color.BLACK);
                            opy.setForeground(Color.YELLOW);
                            result.setBackground(Color.BLACK);
                            result.setForeground(Color.YELLOW);
                        } else {
                            opx.setBackground(Color.white);
                            opx.setForeground(Color.BLACK);
                            opy.setBackground(Color.white);
                            opy.setForeground(Color.BLACK);
                            result.setBackground(Color.white);
                            result.setForeground(Color.BLACK);
                        }
                    }
                }
        );
        clear = new JButton("Clear");
        clear.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        opx.setText("0");
                        opy.setText("0");
                        result.setText("0");
                    }
                }
        );
        plus = new JButton("+");
        plus.addActionListener(new Zweistellig());
        minus = new JButton("-");
        minus.addActionListener(new Zweistellig());
        mal = new JButton("*");
        mal.addActionListener(new Zweistellig());
        geteilt = new JButton("/");
        geteilt.addActionListener(new Zweistellig());
        quadrat = new JButton("x^y");
        quadrat.addActionListener(new Zweistellig());
        logarithmus = new JButton("log^2");
        logarithmus.addActionListener(new Einstellig());
        sinus = new JButton("sin");
        sinus.addActionListener(new Einstellig());
        cosinus = new JButton("cos");
        cosinus.addActionListener(new Einstellig());
//Änderungen Aufgabe 11-------------------------------------------------------
        BinaryOperator<Double> max = (x, y) -> Math.max(x,y);
        UnaryOperator<Double> squared = (x) -> Math.pow(x,x);
        einstelligeFunktion = new JButton("f(x)");
        einstelligeFunktion.addActionListener(e -> {
            opy.setText("0");
            result.setText("" + squared.apply(Double.parseDouble(opx.getText())));
        });
        zweistelligeFunktion = new JButton("g(x,y)");
        zweistelligeFunktion .addActionListener(e -> result.setText("" + max.apply(Double.parseDouble(opx.getText()), Double.parseDouble(opy.getText()))));
//------------------------------------------------------------------------------
        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(3, 2));
        panel1.add(opxLabel);
        panel1.add(opx);
        panel1.add(opyLabel);
        panel1.add(opy);
        panel1.add(resultLabel);
        panel1.add(result);

        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(2, 4));
        panel2.add(plus);
        panel2.add(mal);
        panel2.add(minus);
        panel2.add(geteilt);
        panel2.add(sinus);
        panel2.add(cosinus);
        panel2.add(quadrat);
        panel2.add(logarithmus);
        panel2.add(einstelligeFunktion);
        panel2.add(zweistelligeFunktion);

        JPanel panel3 = new JPanel();
        panel3.setLayout(new GridLayout(1, 3));
        panel3.add(degree);
        panel3.add(radiant);
        panel3.add(display);

        JPanel panel4 = new JPanel();
        panel4.add(clear);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(panel1);
        panel.add(panel3);
        panel.add(panel2);
        panel.add(panel4);
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        setContentPane(panel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        JFrame taschenrechner = new Taschenrechner();
    }

    private class Zweistellig implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Object source = e.getSource();
                double x = Double.parseDouble(opx.getText());
                double y = Double.parseDouble(opy.getText());
                if (source == plus) {
                    result.setText("" + (x + y));
                }
                if (source == minus) {
                    result.setText("" + (x - y));
                }
                if (source == mal) {
                    result.setText("" + (x * y));
                }
                if (source == geteilt) {
                    result.setText("" + (x / y));
                }
                if (source == quadrat) {
                    result.setText("" + Math.pow(x, y));
                }
            } catch (NullPointerException | NumberFormatException e1) {
                System.out.println("Keine gültige Zahl");
            }
        }
    }

    private class Einstellig implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Object source = e.getSource();
                double x = Double.parseDouble(opx.getText());
                opy.setText("0");
                if (source == sinus) {
                    if (degree.isSelected()) {
                        result.setText("" + Math.sin(Math.toRadians(x)));
                    } else {
                        result.setText("" + Math.sin((x)));
                    }
                }
                if (source == cosinus) {
                    if (degree.isSelected()) {
                        result.setText("" + Math.cos(Math.toRadians(x)));
                    } else {
                        result.setText("" + Math.cos((x)));
                    }
                }
                if (source == logarithmus) {
                    result.setText("" + Math.log(x));
                }
            } catch (NullPointerException | NumberFormatException e1) {
                System.out.println("Keine gültige Zahl");
            }
        }
    }
}