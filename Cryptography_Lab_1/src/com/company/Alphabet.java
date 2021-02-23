package com.company;

public enum Alphabet {
    Latina("abcdefghijklmnopqrstuvwxyz"),LatinaCapital("ABCDEFGHIJKLMNOPQRSTUVWXYZ"),
    Cyrillic("абвгдеєжзиіїйклмнопрстуфхцчшщьюя"),CyrillicCapital("АБВГДЕЄЖЗИІЇЙКЛМНОПРСТУФХЦЧШЩЬЮЯ"),
    Znak(".,!?><@#$%^&*()_-=+'/[]{};:№₴~`|1234567890\n ");

    String s;

    Alphabet(String s) {
        this.s = s;
    }

    public String getS() {
        return s;
    }
}











//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                new Main();
//            }
//        });