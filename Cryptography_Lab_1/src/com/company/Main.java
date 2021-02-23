package com.company;

import javax.swing.*;



public class Main extends JFrame  {
    //Розмір вікна
    private static final int WIDTH = 625;
    private static final int HEIGHT = 400;
    //Елементи вікна
    private final JTextField input = new JTextField(60);
    private final JTextField key = new JTextField("3",5);
    private final JButton code = new JButton("CODE");
    private final JButton decode = new JButton("DECODE");
    private final JTextArea output = new JTextArea(60,60);


    private Main(){

        // Створюємо вікно
        JFrame frame = new JFrame("Шифр Цезаря");
        frame.setSize(WIDTH, HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Створюємо панель з менеджером вертикального розташування компонентів
        JPanel contents = new JPanel(new VerticalLayout());


        // Розміщення елементів
        contents.add(input);
        contents.add(key);
        contents.add(code);
        contents.add(decode);
        output.setEditable(false);
        output.setLineWrap(true);
        contents.add(output);
        frame.setContentPane(contents);
        frame.setVisible(true);

        //Обробка натискання кнопки шифрування
        code.addActionListener(e -> {
            String text = input.getText();
            String Key = key.getText();


            if (checkString(Key)) {
                int k = Integer.parseInt(Key);
                output.append(Ceasar.Encrypt_Decrypt(text, k) + "\n"); //Якщо ключ типу int, тоді шифр Цезаря
            }
            else
                output.append(Vigenere.Encrypt(text.toLowerCase(), Key.toLowerCase()) + "\n"); //Якщо ключ типу String, тоді шифр Віженера

            output.setCaretPosition(output.getDocument().getLength());
        });

        //Обробка натискання кнопки дешифрування
        decode.addActionListener(e -> {
            String text = input.getText();
            String Key = key.getText();

            if (checkString(Key)) {
                int k = Integer.parseInt(Key);
                output.append(Ceasar.Encrypt_Decrypt(text, -k) + "\n"); //Якщо ключ типу int, тоді шифр Цезаря
            }
            else
                output.append(Vigenere.Decrypt(text.toLowerCase(), Key.toLowerCase()) + "\n"); //Якщо ключ типу String, тоді шифр Віженера

            output.setCaretPosition(output.getDocument().getLength());
            input.setText("");
        });
    }


    //Функція перевірки символа в ключі на тип
    private boolean checkString(String string) {
        if (string == null || string.length() == 0) return false;

        int i = 0;
        if (string.charAt(0) == '-') {
            if (string.length() == 1) {
                return false;
            }
            i = 1;
        }

        char c;
        for (; i < string.length(); i++) {
            c = string.charAt(i);
            if (!(c >= '0' && c <= '9')) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
    }
}

