package CreditCalculator;

public class CreditCalculator {
    public static int monthToPay(int startMoneySum, int monthlyPayment) {
        int months = startMoneySum / monthlyPayment;
        if (startMoneySum % monthlyPayment > 0) {
            months += 1;
        }
        return months;
    }

    public static int[] paymentForMonth(int startMoneySum, int months) {
        int payment = startMoneySum / months;
        int lastPayment = startMoneySum - (months - 1) * payment;
        if (lastPayment == payment) {
            return new int[]{payment};
        } else {
            return new int[]{payment, lastPayment};
        }
    }

    public static double annualPayment(int startMoneySum, double yearPercent, int years) {
        double someVar = yearPercent / 100;
        double firstCoefficient = someVar * Math.pow(1 + someVar, years);
        double secondCoefficient = Math.pow(1 + someVar, years) - 1;
        return startMoneySum * (firstCoefficient / secondCoefficient);
    }

    public static String periodToRepay(int startMoneySum, double payment, double modification) {
        double someVar = modification / 1200;
        double periods = Math.ceil(-Math.log(payment / (payment - someVar * startMoneySum)) / Math.log(1 + someVar));
        int years = (int) (periods / 12);
        int remainingMonths = (int) (periods % 12);

        if (years == 0) {
            return "It will take " + remainingMonths + " months to repay this loan!";
        } else if (remainingMonths == 0) {
            return "It will take " + years + " years to repay this loan!";
        } else {
            return "It will take " + years + " years and " + remainingMonths + " months to repay this loan!";
        }
    }

    public static int loanPrincipal(double annuityPayment, int periods, double loanPercents) {
        double i = loanPercents / 1200;
        double firstCoefficient = i * Math.pow(1 + i, periods);
        double secondCoefficient = Math.pow(1 + i, periods) - 1;
        double loanPrincipal = annuityPayment / (firstCoefficient / secondCoefficient);
        return (int) Math.round(loanPrincipal);
    }

    public static double differentiatedPayment(double moneySum, double payments, double mod, int month) {
        double money = moneySum / payments;
        double percent = mod / 1200;
        return money + percent * (moneySum - (money * (month - 1)));
    }

    public static void calculateAnnuity(int allMoney, int periods, double interest) {
        double i = interest / 1200;
        double firstCoefficient = i * Math.pow(1 + i, periods);
        double secondCoefficient = Math.pow(1 + i, periods) - 1;
        double annuityPayment = allMoney * (firstCoefficient / secondCoefficient);

        System.out.println("Your annuity payment = " + Math.round(annuityPayment) + "!");
    }
}
