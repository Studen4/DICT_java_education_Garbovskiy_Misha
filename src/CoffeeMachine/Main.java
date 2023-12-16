package CoffeeMachine;

public class Main {
    public static void main(String[] args) {
        CoffeeMaterials coffeeMaterials = new CoffeeMaterials(400, 540, 120, 9, 550);
        CoffeeMachineWorkPart coffeeMachineWorkPart = new CoffeeMachineWorkPart(coffeeMaterials);

        while (true) {
            String action = CoffeeMachineVisual.getUserAction();
            coffeeMachineWorkPart.performAction(action);
        }
    }
}