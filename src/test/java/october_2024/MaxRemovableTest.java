package october_2024;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaxRemovableTest {

    MaxRemovable maxRemovable;

    @BeforeEach
    public void setup() {
        this.maxRemovable = new MaxRemovable();
    }

    @Test
    public void example1Test() {
        String s = "abcacb";
        String p = "ab";
        int[] removable = {3, 1, 0};
        assertEquals(2, maxRemovable.maximumRemovals(s, p, removable));
    }

    @Test
    public void example2Test() {
        String s = "abcbddddd";
        String p = "abcd";
        int[] removable = {3,2,1,4,5,6};
        assertEquals(1, maxRemovable.maximumRemovals(s, p, removable));
    }

    @Test
    public void example3Test() {
        String s = "abcab";
        String p = "abc";
        int[] removable = {0,1,2,3,4};
        assertEquals(0, maxRemovable.maximumRemovals(s, p, removable));
    }


}
