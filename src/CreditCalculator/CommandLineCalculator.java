package CreditCalculator;

import java.util.Map;
public class CommandLineCalculator {
    public static void run(Map<String, String> args) {
        String type = args.get("type");
        if (type == null) {
            System.out.println("Error: Missing 'type' parameter.");
            return;
        }

        int allMoney = Integer.parseInt(args.get("principal"));
        if (allMoney <= 0) {
            System.out.println("Error: Invalid 'principal' parameter.");
            return;
        }

        switch (type) {
            case "annuity" -> {
                int periods = Integer.parseInt(args.get("periods"));
                double interest = Double.parseDouble(args.get("interest"));

                CreditCalculator.calculateAnnuity(allMoney, periods, interest);
            }
            case "diff" -> {
                int payments = Integer.parseInt(args.get("periods"));
                double payment = Double.parseDouble(args.get("payment"));
                double interest = Double.parseDouble(args.get("interest"));

                CreditCalculator.differentiatedPayment(allMoney, payments, payment, (int) interest);
            }
            default -> System.out.println("Error: Unknown operation");
        }
    }
}
