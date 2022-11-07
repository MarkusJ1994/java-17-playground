package stream;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestStreamEnhancements {

    @Test
    public void testStreamToList() {
        //No more collecting
        Stream stream = Stream.of(1, 2, 3);
        List l = stream.toList();
        assertEquals(List.of(1, 2, 3), l);
    }

}
