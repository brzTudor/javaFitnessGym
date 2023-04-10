package Gym;

import java.util.Random;

public class ClasaUtilitara {
    private static String[] arrayNume = {"Michael", "Jim", "Pam", "John","Andy", "Kelly", "Angela", "James", "Jan", "Kevin"};

    static int genereazaVarsta() {
        Random random = new Random();

        return random.nextInt(100);
    }

    static int genereazaProgres() {
        Random random = new Random();

        return random.nextInt(10);
    }

    static String genereazaNume() {
        Random random = new Random();

        return arrayNume[random.nextInt(9)];
    }

    static int genereazaNrAbonati() {
        Random random = new Random();

        return random.nextInt(10);
    }

    static int genereazaId() {
        Random random = new Random();

        return random.nextInt(5);
    }
}
