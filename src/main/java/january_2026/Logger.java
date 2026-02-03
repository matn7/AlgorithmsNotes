package january_2026;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Logger {

    public static void main(String[] args) {
        Logger logger = new Logger();
        System.out.println(logger.shouldPrintMessage(1, "foo"));
        System.out.println(logger.shouldPrintMessage(2, "bar"));
        System.out.println(logger.shouldPrintMessage(3, "foo"));
        System.out.println(logger.shouldPrintMessage(8, "bar"));
        System.out.println(logger.shouldPrintMessage(10, "foo"));
        System.out.println(logger.shouldPrintMessage(11, "foo"));
    }

    // O(1) time | O(1) space
    private Map<String, Integer> logerrMap;

    public Logger() {
        logerrMap = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        // logerrMap = {foo : 1, bar : 2, }
        if (!logerrMap.containsKey(message)) {
            logerrMap.put(message, timestamp);
            return true;
        }

        if (logerrMap.containsKey(message) && timestamp - 10 >= logerrMap.get(message)) { // 3 - 10 >= 1
            logerrMap.put(message, timestamp);
            return true;
        }
        return false;
    }

}
