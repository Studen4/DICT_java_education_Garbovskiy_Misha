package CreditCalculator;

import java.util.Map;

class MainCL {
    public static void main(String[] args) {
        CommandLineParser parser = new CommandLineParser(args);
        Map<String, String> parsedArgs = parser.parse();
        CommandLineCalculator.run(parsedArgs);
    }
}
