package com.company;

import static java.lang.StrictMath.abs;

class Ceasar {


    static String Encrypt_Decrypt(String str, int key){

                int j;
                char n = ' ';
                String s = "";

                for (int i = 0; i < str.length(); i++) {
                    char m = str.charAt(i); //Літера вхідного тексту

                    for (int k = 0; k <Alphabet.Znak.getS().length(); k++) {

                        //Шифрування великої латинської літери
                        if (m == Alphabet.LatinaCapital.getS().charAt(k%Alphabet.LatinaCapital.getS().length())) {
                            j = abs((k + key + 26) % 26);
                            n = Alphabet.LatinaCapital.getS().charAt(j);
                        }

                        //Шифрування малої латинської літери
                        if (m == Alphabet.Latina.getS().charAt(k%Alphabet.Latina.getS().length())) {
                            j = abs((k + key +26 ) % 26);
                            n = Alphabet.Latina.getS().charAt(j);
                        }

                        //Шифрування великої літери кирилиці
                        if (m == Alphabet.CyrillicCapital.getS().charAt(k%Alphabet.CyrillicCapital.getS().length())) {
                            j = abs((k + key) % 32);
                            n = Alphabet.CyrillicCapital.getS().charAt(j);
                        }

                        //Шифрування малої літери кирилиці
                        if (m == Alphabet.Cyrillic.getS().charAt(k%Alphabet.Cyrillic.getS().length())) {
                            j = abs((k + key) % 32);
                            n = Alphabet.Cyrillic.getS().charAt(j);
                        }

                        //Знак пінктуації
                        if (m == Alphabet.Znak.getS().charAt(k))
                            n=m;
                    }

                    s += n; //Вихідний рядок
                    System.out.print(n);
                }
        System.out.println();
        return s;
    }
}
