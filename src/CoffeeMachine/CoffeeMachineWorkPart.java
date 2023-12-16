package CoffeeMachine;

public class CoffeeMachineWorkPart {
    private final CoffeeMaterials coffeeMaterials;

    public CoffeeMachineWorkPart(CoffeeMaterials coffeeMaterials) {
        this.coffeeMaterials = coffeeMaterials;
    }

    public void performAction(String action) {
        switch (action) {
            case "buy" -> buyCoffee();
            case "fill" -> fillIngredients();
            case "take" -> takeMoney();
            case "remaining" -> displayRemaining();
            case "exit" -> System.exit(0);
            default -> System.out.println("Unknown action. Please try again.");
        }
    }

    private void buyCoffee() {
        String coffeeType = CoffeeMachineVisual.getCoffeeType();
        switch (coffeeType) {
            case "1" -> makeCoffee(250, 0, 16, 4);
            case "2" -> makeCoffee(350, 75, 20, 7);
            case "3" -> makeCoffee(200, 100, 12, 6);
            case "back" -> {
            }
            default -> System.out.println("Unknown coffee type. Please try again.");
        }
    }

    private void makeCoffee(int waterNeeded, int milkNeeded, int coffeeBeansNeeded, int cost) {
        if (hasEnoughIngredients(waterNeeded, milkNeeded, coffeeBeansNeeded)) {
            System.out.println("I have enough resources, making you a coffee!");
            coffeeMaterials.fillIngredients(-waterNeeded, -milkNeeded, -coffeeBeansNeeded, -1);
            coffeeMaterials.money += cost;
        } else {
            System.out.println("Sorry, not enough resources to make coffee.");
        }
    }

    private void fillIngredients() {
        int addedWater = CoffeeMachineVisual.getIngredientAmount("ml of water");
        int addedMilk = CoffeeMachineVisual.getIngredientAmount("ml of milk");
        int addedCoffeeBeans = CoffeeMachineVisual.getIngredientAmount("grams of coffee beans");
        int addedDisposableCups = CoffeeMachineVisual.getIngredientAmount("disposable cups of coffee");

        coffeeMaterials.fillIngredients(addedWater, addedMilk, addedCoffeeBeans, addedDisposableCups);
    }

    private void takeMoney() {
        int takenMoney = coffeeMaterials.takeMoney();
        System.out.println("I gave you " + takenMoney);
    }

    private void displayRemaining() {
        System.out.println(coffeeMaterials.getRemaining());
    }

    private boolean hasEnoughIngredients(int waterNeeded, int milkNeeded, int coffeeBeansNeeded) {
        return coffeeMaterials.water >= waterNeeded &&
                coffeeMaterials.milk >= milkNeeded &&
                coffeeMaterials.coffeeBeans >= coffeeBeansNeeded &&
                coffeeMaterials.disposableCups >= 1;
    }
}
