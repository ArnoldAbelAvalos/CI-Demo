import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathTest {

    @Test
    void sum() {
        assertEquals(2,Math.sum(1,1));
    }

    @Test
    void div() {
        assertEquals(5,Math.div(10,2));
    }
}