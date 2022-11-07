package patternmatching;

import org.junit.jupiter.api.Test;
import sealedclasses.Apple;
import sealedclasses.Banana;
import sealedclasses.SealedFruit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PatternMatchingTest {

    enum Fruit {
        APPLE, BANANA, MANGO, TOMATO
    }

    static String COMMON_FRUIT = "Common fruit";
    static String EXOTIC_FRUIT = "Exotic fruit";
    static String NO_FRUIT = "No fruit";

    String oldStyle(Fruit fruit) {
        switch (fruit) {
            case APPLE, BANANA:
                return COMMON_FRUIT;
                //break if no return is made
            case MANGO:
                return EXOTIC_FRUIT;
                //break if no return is made
            default:
                return NO_FRUIT;
        }
    }

    String patternMatching(Fruit fruit) {
        return switch (fruit) {
            case APPLE, BANANA -> COMMON_FRUIT;
            case MANGO -> EXOTIC_FRUIT;
            default -> NO_FRUIT;
        };
    }

    @Test
    public void testPatternMatching() {

        assertEquals(oldStyle(Fruit.APPLE), patternMatching(Fruit.APPLE));

        assertEquals(oldStyle(Fruit.MANGO), patternMatching(Fruit.MANGO));

        assertEquals(oldStyle(Fruit.TOMATO), patternMatching(Fruit.TOMATO));
    }

    String instanceOfPatternMatching(SealedFruit fruit) {
        if(fruit instanceof Apple a) {
            return a.seedHouse();
        } else if(fruit instanceof Banana b) {
            return b.peel();
        } else {
            return "No matches";
        }
    }

    @Test
    public void testPatternMatchingInstanceOf() {
        assertEquals(instanceOfPatternMatching(new Apple()), "Apple has seedhouse");
        assertEquals(instanceOfPatternMatching(new Banana()), "Banana has peel");
    }

}
