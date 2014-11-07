/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.NumberFormat;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;

/**
 *
 * @author Aaron
 */
public class Calculator extends JFrame implements ActionListener {

    public JButton BUTTON_1;
    public JButton BUTTON_2;
    public JButton BUTTON_3;
    public JButton BUTTON_4;
    public JButton BUTTON_5;
    public JButton BUTTON_6;
    public JButton BUTTON_7;
    public JButton BUTTON_8;
    public JButton BUTTON_9;
    public JButton BUTTON_0;
    public JButton BUTTON_MINUS;
    public JButton BUTTON_PLUS;
    public JButton BUTTON_DIVIDE;
    public JButton BUTTON_MULTIPLY;
    public JButton BUTTON_ENTER;
    public JButton BUTTON_CLEAR;
    public JFormattedTextField TEXT_FIELD;
    public KL KEY_LISTENER;

    public class KL extends KeyAdapter {

        public String numbers = "1234567890";
        public String operators = "/+-*";
        public Calculator calc;

        public KL(Calculator calc) {
            this.calc = calc;
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (isValid(e.getKeyChar(), numbers)) {
                TEXT_FIELD.setText(TEXT_FIELD.getText() + e.getKeyChar());
            } else if (isValid(e.getKeyChar(), operators)) {
                if (!checkOperator()) {
                    TEXT_FIELD.setText(TEXT_FIELD.getText() + " " + e.getKeyChar() + " ");
                }
            }else if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE){
                TEXT_FIELD.setText(": ");
            }else if(e.getKeyCode() == KeyEvent.VK_ENTER){
                calculate();
            }
        }

        public boolean isValid(char c, String validList) {
            boolean toReturn = false;
            for (int currentChar = 0; currentChar < validList.length(); currentChar++) {
                if (validList.charAt(currentChar) == c) {
                    toReturn = true;
                }
            }
            return toReturn;
        }
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        calc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        calc.pack();
        calc.setResizable(false);
        calc.setVisible(true);
    }

    public Calculator() {
        KEY_LISTENER = new KL(this);
        setLayout(new GridBagLayout());
        TEXT_FIELD = new JFormattedTextField();
        TEXT_FIELD.setEditable(false);
        TEXT_FIELD.setText(": ");
        TEXT_FIELD.addKeyListener(KEY_LISTENER);
        GridBagConstraints cT = new GridBagConstraints();
        cT.gridx = 0;
        cT.gridy = 0;
        cT.gridwidth = 5;
        cT.fill = GridBagConstraints.HORIZONTAL;
        add(TEXT_FIELD, cT);
        BUTTON_1 = new JButton("1");
        BUTTON_1.addActionListener(this);
        GridBagConstraints c1 = new GridBagConstraints();
        c1.gridx = 0;
        c1.gridy = 1;
        add(BUTTON_1, c1);
        BUTTON_2 = new JButton("2");
        BUTTON_2.addActionListener(this);
        GridBagConstraints c2 = new GridBagConstraints();
        c2.gridx = 1;
        c2.gridy = 1;
        add(BUTTON_2, c2);
        BUTTON_3 = new JButton("3");
        BUTTON_3.addActionListener(this);
        GridBagConstraints c3 = new GridBagConstraints();
        c3.gridx = 2;
        c3.gridy = 1;
        add(BUTTON_3, c3);
        BUTTON_4 = new JButton("4");
        BUTTON_4.addActionListener(this);
        GridBagConstraints c4 = new GridBagConstraints();
        c4.gridx = 0;
        c4.gridy = 2;
        add(BUTTON_4, c4);
        BUTTON_5 = new JButton("5");
        BUTTON_5.addActionListener(this);
        GridBagConstraints c5 = new GridBagConstraints();
        c5.gridx = 1;
        c5.gridy = 2;
        add(BUTTON_5, c5);
        BUTTON_6 = new JButton("6");
        BUTTON_6.addActionListener(this);
        GridBagConstraints c6 = new GridBagConstraints();
        c6.gridx = 2;
        c6.gridy = 2;
        add(BUTTON_6, c6);
        BUTTON_7 = new JButton("7");
        BUTTON_7.addActionListener(this);
        GridBagConstraints c7 = new GridBagConstraints();
        c7.gridx = 0;
        c7.gridy = 3;
        add(BUTTON_7, c7);
        BUTTON_8 = new JButton("8");
        BUTTON_8.addActionListener(this);
        GridBagConstraints c8 = new GridBagConstraints();
        c8.gridx = 1;
        c8.gridy = 3;
        add(BUTTON_8, c8);
        BUTTON_9 = new JButton("9");
        BUTTON_9.addActionListener(this);
        GridBagConstraints c9 = new GridBagConstraints();
        c9.gridx = 2;
        c9.gridy = 3;
        add(BUTTON_9, c9);
        BUTTON_0 = new JButton("0");
        BUTTON_0.addActionListener(this);
        GridBagConstraints c0 = new GridBagConstraints();
        c0.gridx = 3;
        c0.gridy = 3;
        add(BUTTON_0, c0);
        BUTTON_MINUS = new JButton("-");
        BUTTON_MINUS.addActionListener(this);
        GridBagConstraints cMinus = new GridBagConstraints();
        cMinus.gridx = 4;
        cMinus.gridy = 1;
        add(BUTTON_MINUS, cMinus);
        BUTTON_PLUS = new JButton("+");
        BUTTON_PLUS.addActionListener(this);
        GridBagConstraints cPlus = new GridBagConstraints();
        cPlus.gridx = 3;
        cPlus.gridy = 1;
        add(BUTTON_PLUS, cPlus);
        BUTTON_DIVIDE = new JButton("/");
        BUTTON_DIVIDE.addActionListener(this);
        GridBagConstraints cDivide = new GridBagConstraints();
        cDivide.gridx = 3;
        cDivide.gridy = 2;
        cDivide.fill = GridBagConstraints.HORIZONTAL;
        add(BUTTON_DIVIDE, cDivide);
        BUTTON_MULTIPLY = new JButton("*");
        BUTTON_MULTIPLY.addActionListener(this);
        GridBagConstraints cMultiply = new GridBagConstraints();
        cMultiply.gridx = 4;
        cMultiply.gridy = 2;
        add(BUTTON_MULTIPLY, cMultiply);
        BUTTON_ENTER = new JButton("=");
        BUTTON_ENTER.addActionListener(this);
        GridBagConstraints cEnter = new GridBagConstraints();
        cEnter.gridx = 4;
        cEnter.gridy = 3;
        add(BUTTON_ENTER, cEnter);
        BUTTON_CLEAR = new JButton("C");
        BUTTON_CLEAR.addActionListener(this);
        GridBagConstraints cClear = new GridBagConstraints();
        cClear.gridx = 1;
        cClear.gridy = 4;
        add(BUTTON_CLEAR, cClear);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        if (action.equals(BUTTON_1.getActionCommand())) {
            TEXT_FIELD.setText(TEXT_FIELD.getText() + "1");
        } else if (action.equals(BUTTON_2.getActionCommand())) {
            TEXT_FIELD.setText(TEXT_FIELD.getText() + "2");
        } else if (action.equals(BUTTON_3.getActionCommand())) {
            TEXT_FIELD.setText(TEXT_FIELD.getText() + "3");
        } else if (action.equals(BUTTON_4.getActionCommand())) {
            TEXT_FIELD.setText(TEXT_FIELD.getText() + "4");
        } else if (action.equals(BUTTON_5.getActionCommand())) {
            TEXT_FIELD.setText(TEXT_FIELD.getText() + "5");
        } else if (action.equals(BUTTON_6.getActionCommand())) {
            TEXT_FIELD.setText(TEXT_FIELD.getText() + "6");
        } else if (action.equals(BUTTON_7.getActionCommand())) {
            TEXT_FIELD.setText(TEXT_FIELD.getText() + "7");
        } else if (action.equals(BUTTON_8.getActionCommand())) {
            TEXT_FIELD.setText(TEXT_FIELD.getText() + "8");
        } else if (action.equals(BUTTON_9.getActionCommand())) {
            TEXT_FIELD.setText(TEXT_FIELD.getText() + "9");
        } else if (action.equals(BUTTON_0.getActionCommand())) {
            TEXT_FIELD.setText(TEXT_FIELD.getText() + "0");
        } else if (action.equals(BUTTON_PLUS.getActionCommand())) {
            if (!checkOperator()) {
                TEXT_FIELD.setText(TEXT_FIELD.getText() + " + ");
            }
        } else if (action.equals(BUTTON_MINUS.getActionCommand())) {
            if (!checkOperator()) {
                TEXT_FIELD.setText(TEXT_FIELD.getText() + " - ");
            }
        } else if (action.equals(BUTTON_DIVIDE.getActionCommand())) {
            if (!checkOperator()) {
                TEXT_FIELD.setText(TEXT_FIELD.getText() + " / ");
            }
        } else if (action.equals(BUTTON_MULTIPLY.getActionCommand())) {
            if (!checkOperator()) {
                TEXT_FIELD.setText(TEXT_FIELD.getText() + " * ");
            }
        } else if (action.equals(BUTTON_ENTER.getActionCommand())) {
            calculate();
        } else if (action.equals(BUTTON_CLEAR.getActionCommand())) {
            TEXT_FIELD.setText(": ");
        }
    }

    public void calculate() {
        String toCalc = TEXT_FIELD.getText();
        int length = 0;
        String answer = toCalc;
        Scanner lengthFinder = new Scanner(toCalc);
        while (lengthFinder.hasNext()) {
            lengthFinder.next();
            length++;
        }
        if (length > 2) {
            Scanner calcScanner = new Scanner(toCalc);
            calcScanner.next();
            int toWork = calcScanner.nextInt();
            while (calcScanner.hasNext()) {
                char op = calcScanner.next().charAt(0);
                int secondNum = calcScanner.nextInt();
                if (op == '-') {
                    toWork = (int) Math.round((double) toWork - (double) secondNum);
                } else if (op == '+') {
                    toWork = (int) Math.round((double) toWork + (double) secondNum);
                } else if (op == '/') {
                    toWork = (int) Math.round((double) toWork / (double) secondNum);
                } else if (op == '*') {
                    toWork = (int) Math.round((double) toWork * (double) secondNum);
                }
            }
            answer = "" + toWork;
        }
        TEXT_FIELD.setText(": " + answer);
    }

    public boolean checkOperator() {
        char last = TEXT_FIELD.getText().charAt(TEXT_FIELD.getText().length() - 1);
        boolean toReturn = false;
        if (last == '-') {
            toReturn = true;
        } else if (last == '+') {
            toReturn = true;
        } else if (last == '/') {
            toReturn = true;
        } else if (last == ' ') {
            toReturn = true;
        } else if (last == ':') {
            toReturn = true;
        }
        return toReturn;
    }
}
