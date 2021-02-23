package com.company;



class Vigenere {

    // Таблиця Віженера
    final static private char[][] mTableL; //Латиниця
    final static private char[][] mTableC; //Кирилиця

    private static String s = "";

    // Ініціалізація таблиць
    static {

        mTableL = new char[Alphabet.Latina.getS().length()][Alphabet.Latina.getS().length()];
        mTableC = new char[Alphabet.Cyrillic.getS().length()][Alphabet.Cyrillic.getS().length()];


        //Латиниця
        for (int i=0; i<Alphabet.Latina.getS().length(); i++){
            for (int j=0; j<Alphabet.Latina.getS().length(); j++){

                mTableL[i][j] = Alphabet.Latina.getS().charAt((26 + j + i) % 26 );
            }
        }
        for (int i=0; i<Alphabet.Latina.getS().length(); i++){
            for (int j=0; j<Alphabet.Latina.getS().length(); j++){

                System.out.print(mTableL[i][j] + " ");
            }
            System.out.println();
        }

        //Кирилиця
        for (int i=0; i<Alphabet.Cyrillic.getS().length(); i++){
            for (int j=0; j<Alphabet.Cyrillic.getS().length(); j++){

                mTableC[i][j] = Alphabet.Cyrillic.getS().charAt((32 + j + i) % 32 );
            }
        }
        for (int i=0; i<Alphabet.Cyrillic.getS().length(); i++){
            for (int j=0; j<Alphabet.Cyrillic.getS().length(); j++){

                System.out.print(mTableC[i][j] + " ");
            }
            System.out.println();
        }
    }



    // індекс латинської літери для шифрування
    private static int CharL(char c) {
        for (int j=0; j<mTableL[0].length; j++) {
            if (mTableL[0][j] == c)
                return j;
        }
        return 0;
    }

    // індекс літери кирилиці для шифрування
    private static int CharC(char c) {
        for (int j=0; j<mTableC[0].length; j++) {
            if (mTableC[0][j] == c)
                return j;
        }
        return 0;
    }

    // індекс латинської літери для розшифрування
    private static int CharL(char c, int i) {
        for (int j=0; j<mTableL[0].length; j++) {
            if (mTableL[j][i] == c)
                return j;
        }
        return 0;
    }

    // індекс літери кирилиці для розшифрування
    private static int CharC(char c, int i) {
        for (int j=0; j<mTableC[0].length; j++) {
            if (mTableC[j][i] == c)
                return j;
        }
        return 0;
    }

    // Шифрувати
    static String Encrypt(String str, String key) {

        char n = ' ';
        s = "";
        for (int i = 0; i < str.length(); i++) {
            char m = str.charAt(i);//Літера вхідного тексту
            char l = key.charAt(i%key.length()); //Літера ключа

            for (int k = 0; k < Alphabet.Znak.getS().length(); k++) {

                //Шифрування латинської літери
                if (m == Alphabet.Latina.getS().charAt(k%Alphabet.Latina.getS().length()))
                    n = mTableL[CharL(m)][CharL(l)];

                //Шифрування літери кирилиці
                if (m == Alphabet.Cyrillic.getS().charAt(k%Alphabet.Cyrillic.getS().length()))
                    n = mTableC[CharC(m)][CharC(l)];

                //Знак пінктуації
                if (m == Alphabet.Znak.getS().charAt(k))
                    n = m;
            }

            s=s+n; //Вихідний рядок
            System.out.print(n);
        }

        return s;
    }

    // Розшифрувати
    static String Decrypt(String str, String key) {

        char n = ' ';
        s = "";

        for (int i = 0; i < str.length(); i++) {
            char m = str.charAt(i);//Літера вхідного тексту
            char l = key.charAt(i%key.length());//Літера ключа


            for (int k = 0; k < Alphabet.Znak.getS().length(); k++) {

                //Дешифрування латинської літери
                if (m == Alphabet.Latina.getS().charAt(k%Alphabet.Latina.getS().length()))
                    n = mTableL[CharL(m,CharL(l))][0];

                //Дешифрування літери кирилиці
                if (m == Alphabet.Cyrillic.getS().charAt(k%Alphabet.Cyrillic.getS().length()))
                    n = mTableC[CharC(m,CharC(l))][0];

                //Знак пінктуації
                if (m == Alphabet.Znak.getS().charAt(k))
                    n = m;

            }

            s=s+n; //Вихідний рядок
            System.out.print(n);

        }
        return s;
    }
}


