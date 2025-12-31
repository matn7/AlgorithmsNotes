package december_2025;

import java.util.HashMap;
import java.util.Map;

public class Logger {

    Map<String, Integer> messageMap;
    public Logger() {
        messageMap = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!messageMap.containsKey(message)) {
            messageMap.put(message, timestamp);
            return true;
        } else {
            int currentMsgTimestamp = messageMap.get(message);
            if (timestamp >= currentMsgTimestamp + 10) {
                messageMap.remove(message);
                messageMap.put(message, timestamp);
                return true;
            }
        }
        return false;
    }

}
