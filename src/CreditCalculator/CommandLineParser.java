package CreditCalculator;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class CommandLineParser {
    private final String[] args;

    public CommandLineParser(String[] args) {
        this.args = args;
    }

    public Map<String, String> parse() {
        Map<String, String> parsedArgs = new HashMap<>();

        for (String arg : args) {
            Pattern pattern = Pattern.compile("-D(\\w+)=(\\S+)");
            Matcher matcher = pattern.matcher(arg);

            if (matcher.matches()) {
                String key = matcher.group(1);
                String value = matcher.group(2);
                parsedArgs.put(key, value);
            }
        }

        return parsedArgs;
    }
}
