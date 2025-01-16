package november_2024;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddresses {

    public int numUniqueEmails(String[] emails) {
        Set<String> unique = new HashSet<>();

        for (String e : emails) {
            int i = 0;
            StringBuilder builder = new StringBuilder();
            while (e.charAt(i) != '@' && e.charAt(i) != '+') {
                if (e.charAt(i) != '.') {
                    builder.append(e.charAt(i));
                }
                i++;
            }
            while (e.charAt(i) != '@') {
                i++;
            }
            String domain = e.substring(i + 1);
            String local = builder.toString();
            unique.add(local + "@" + domain);
        }

        return unique.size();
    }

    public int numUniqueEmails2(String[] emails) {
        Set<String> unique = new HashSet<>();

        for (String e : emails) {
            String[] split = e.split("@");
            String local = split[0];
            String domain = split[1];

            // Remove everything after the '+' symbol in the local part
            local = local.split("\\+")[0];

            // Remove all periods from the local part
            local = local.replace(".", "");

            // Add the normalized email to the set
            unique.add(local + "@" + domain);
        }

        return unique.size();
    }
}
