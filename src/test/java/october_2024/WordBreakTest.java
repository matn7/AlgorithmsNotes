package october_2024;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WordBreakTest {

    WordBreak wordBreak;

    @BeforeEach
    public void setup() {
        wordBreak = new WordBreak();
    }

    @Test
    public void testCanBreak() {
        boolean result = wordBreak.wordBreak("leetcode", Arrays.asList("leet", "code"));
        assertTrue(result);
    }

    @Test
    public void testCanBreakV2() {
        boolean result = wordBreak.wordBreak("aaaaaaa", Arrays.asList("aaaa", "aaa"));
        assertTrue(result);
    }

    @Test
    public void testCanNotBreak() {
        boolean result = wordBreak.wordBreak("aaaaaaa", Arrays.asList("aaaa", "aa"));
        assertFalse(result);
    }



}
