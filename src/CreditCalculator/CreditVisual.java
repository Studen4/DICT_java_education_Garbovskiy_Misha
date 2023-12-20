package CreditCalculator;

import java.util.Scanner;

public class CreditVisual {
    public static void run() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the money sum which you want to calculate: ");
        int allMoney = scanner.nextInt();

        System.out.println("""
                What do you want to calculate?
                type "m" - for number of monthly payments,
                type "mp" - for the monthly payment:
                type "a" - for the annual yearly payment:
                type "n" - for number of monthly payments:
                type "p" - for loan principal calculations:
                type "d" - for differentiated payment
                """);
        System.out.print(">");
        String typeOfCalculations = scanner.next();

        switch (typeOfCalculations) {
            case "m" -> {
                System.out.print("Enter the monthly payment: ");
                int monthlyPayment = scanner.nextInt();
                int months = CreditCalculator.monthToPay(allMoney, monthlyPayment);
                System.out.println("It will take " + monthsToYearsAndMonths(months) + " to repay the loan");
            }
            case "mp" -> {
                System.out.print("Enter the number of months: ");
                int numMonths = scanner.nextInt();
                int[] paymentResult = CreditCalculator.paymentForMonth(allMoney, numMonths);
                if (paymentResult.length == 2) {
                    System.out.println("Your monthly payment = " + paymentResult[0] + " and the last payment = " + paymentResult[1] + ".");
                } else {
                    System.out.println("Your monthly payment = " + paymentResult[0] + ".");
                }
            }
            case "a" -> {
                System.out.print("Enter the annual interest modification: ");
                double yearPercent = scanner.nextDouble();
                System.out.print("Enter the number of years: ");
                int years = scanner.nextInt();
                double annualPayment = CreditCalculator.annualPayment(allMoney, yearPercent, years);
                System.out.println("Your annual payment = " + Math.round(annualPayment * 100.0) / 100.0 + ".");
                int months = years * 12;
                System.out.println("It will take " + monthsToYearsAndMonths(months) + " to repay the loan");
            }
            case "n" -> {
                System.out.print("Enter the monthly payment: ");
                double payment = scanner.nextDouble();
                System.out.print("Enter the loan percent: ");
                double modification = scanner.nextDouble();
                String result = CreditCalculator.periodToRepay(allMoney, payment, modification);
                System.out.println(result);
            }
            case "p" -> {
                System.out.print("Enter the annuity payment: ");
                double annuityPayment = scanner.nextDouble();
                System.out.print("Enter the number of periods: ");
                int periods = scanner.nextInt();
                System.out.print("Enter the loan percent: ");
                double loanPercent = scanner.nextDouble();
                int loanPrincipal = CreditCalculator.loanPrincipal(annuityPayment, periods, loanPercent);
                System.out.println("Your loan principal = " + loanPrincipal + "!");
            }
            case "d" -> {
                double totalPaid = 0;
                System.out.print("Enter the number of periods: ");
                int payments = scanner.nextInt();
                System.out.print("Please, enter loan percent: ");
                double mod = scanner.nextDouble();
                for (int paymentMonth = 1; paymentMonth <= payments; paymentMonth++) {
                    double paymentResult = CreditCalculator.differentiatedPayment(allMoney, payments, mod, paymentMonth);
                    totalPaid += paymentResult;
                    System.out.println("Month " + paymentMonth + ": payment is " + Math.round(paymentResult * 100.0) / 100.0);
                }
                double overpayment = totalPaid - (double) allMoney;
                System.out.println("Overpayment = " + Math.round(overpayment * 100.0) / 100.0);
            }
            default -> System.out.println("Unknown operation");
        }
    }

    private static String monthsToYearsAndMonths(int months) {
        int years = months / 12;
        int remainingMonths = months % 12;

        return switch (years) {
            case 0 -> (remainingMonths == 1) ? remainingMonths + " month" : remainingMonths + " months";
            case 1 ->
                    (remainingMonths == 0) ? years + " year" : (remainingMonths == 1) ? years + " year and " + remainingMonths + " month" : years + " year and " + remainingMonths + " months";
            default ->
                    (remainingMonths == 0) ? years + " years" : (remainingMonths == 1) ? years + " years and " + remainingMonths + " month" : years + " years and " + remainingMonths + " months";
        };
    }
}
