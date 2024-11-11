package october_2024;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class JumpGameVIITest {

    JumpGameVII jumpGameVII;

    @BeforeEach
    public void setup() {
        jumpGameVII = new JumpGameVII();
    }

    @Test
    public void canReachTest() {
        String s = "011010";
        int minJump = 2;
        int maxJump = 3;
        assertTrue(jumpGameVII.canReach(s, minJump, maxJump));
    }

    @Test
    public void canNotReachTest() {
        String s = "01101110";
        int minJump = 2;
        int maxJump = 3;
        assertFalse(jumpGameVII.canReach(s, minJump, maxJump));
    }

}
