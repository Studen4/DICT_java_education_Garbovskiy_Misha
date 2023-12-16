package CoffeeMachine;

public class CoffeeMaterials {
    public int water;
    public int milk;
    public int coffeeBeans;
    public int disposableCups;
    public int money;

    public CoffeeMaterials(int water, int milk, int coffeeBeans, int disposableCups, int money) {
        this.water = water;
        this.milk = milk;
        this.coffeeBeans = coffeeBeans;
        this.disposableCups = disposableCups;
        this.money = money;
    }

    public String getRemaining() {
        return String.format("The coffee machine has:\n%d of water\n%d of milk\n%d of coffee beans\n%d of disposable cups\n%d of money",
                water, milk, coffeeBeans, disposableCups, money);
    }

    public void fillIngredients(int addedWater, int addedMilk, int addedCoffeeBeans, int addedDisposableCups) {
        water += addedWater;
        milk += addedMilk;
        coffeeBeans += addedCoffeeBeans;
        disposableCups += addedDisposableCups;
    }

    public int takeMoney() {
        int takenMoney = money;
        money = 0;
        return takenMoney;
    }

}
