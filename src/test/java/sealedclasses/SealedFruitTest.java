package sealedclasses;

import org.junit.jupiter.api.Test;

class SealedFruitTest {

    @Test
    public void testSealedRestrictions() {
        SealedFruit sealedFruit;

        //Apple permitted
        Apple apple = new Apple();
        sealedFruit = apple;

        class Avocado extends Apple {
            //Allowed, Apple is non sealed
        }
        sealedFruit = new Avocado();

        Banana banana = new Banana();
        sealedFruit = banana;
        // class Cucumber extends Banana {
        //  Not allowed, Banana is not non-sealed
        // }

        Tomato tomato = new Tomato();
        // sealedFruit = tomato; Not allowed
    }

}