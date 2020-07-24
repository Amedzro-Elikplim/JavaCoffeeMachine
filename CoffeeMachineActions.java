package machine;

import java.util.Scanner;

public class CoffeeMachineActions {
    //ingredients available in the coffee machine at the start of work
    static int waterAvailable = 400;
    static int milkAvailable = 540;
    static int coffeeBeansAvailable = 120;
    static int disposableCupAvailable = 9;
    static int moneyAvailable = 550;

    static Scanner scanner = new Scanner(System.in);
    String input;

     public CoffeeMachineActions(){
         processAction();
     }


    //gate to the internal parts of the program
    public void processAction(){
        System.out.println("Write action (buy, fill, take, remaining, exit)");
        input = scanner.nextLine();
        switch (input){
            case "buy":
                buyAction();
                processAction();
                break;

            case "fill":
                fillAction();
                processAction();
                break;

            case "take":
                takeAction();
                processAction();
                break;

            case "remaining":
                displayRemaining();
                processAction();
                break;

            case ("exit"):
                break;

            default:
                processAction();
                break;
        }
    }

    private void displayRemaining() {
        System.out.println("The coffee machine has: \n" +
                waterAvailable + " of water \n" +
                milkAvailable + " of milk \n" +
                coffeeBeansAvailable + " of coffee beans \n" +
                disposableCupAvailable + " of disposable cups \n" +
                "$" + moneyAvailable + " of money");
    }

    private void takeAction() {
        System.out.println("i gave you $" + moneyAvailable);
        moneyAvailable = 0;
    }

    private void fillAction() {
        System.out.println("Write how many ml of water do you want to add: ");
        String waterAdded = scanner.nextLine();
        System.out.println("Write how many ml of milk do you want to add: ");
        String milkAdded = scanner.nextLine();
        System.out.println("Write how many grams of coffee beans do you want to add: ");
        String coffeeBeansAdded = scanner.nextLine();
        System.out.println("Write how many disposable cups of coffee do you want to add: ");
        String cupsAdded = scanner.nextLine();

        waterAvailable = waterAvailable + Integer.parseInt(waterAdded);
        milkAvailable = milkAvailable + Integer.parseInt(milkAdded);
        coffeeBeansAvailable = coffeeBeansAvailable + Integer.parseInt(coffeeBeansAdded);
        disposableCupAvailable = disposableCupAvailable + Integer.parseInt(cupsAdded);

    }

    private void buyAction() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu");
        String order = scanner.nextLine();
        switch (order){
            case "1":
                processEspressoOrder();
                break;

            case "2":
                processLatteOrder();
                break;

            case "3":
                processCappuccinoOrder();
                break;

            case "back":
            default:
                break;
        }


    }

    private void processCappuccinoOrder() {
        TypesOfCoffee cappuccino = TypesOfCoffee.CAPPUCCINO;
        boolean waterEnoughForCappuccino = waterAvailable >= cappuccino.getWaterNeeded();
        boolean milkEnoughForCappuccino = milkAvailable >= cappuccino.getMilkNeeded();
        boolean coffeeBeansEnoughForCappuccino = coffeeBeansAvailable >= cappuccino.getCoffeeBeansNeeded();

        if (!waterEnoughForCappuccino || !coffeeBeansEnoughForCappuccino || !milkEnoughForCappuccino){
            if(!waterEnoughForCappuccino){
                System.out.println("Sorry, not enough coffee beans");
            } else if (!coffeeBeansEnoughForCappuccino){
                System.out.println("Sorry, not enough coffee beans");
            } else {
                System.out.println("Sorry, not enough milk");
            }
        } else {
            System.out.println("I have enough resources, making you a coffee!");
            waterAvailable = waterAvailable - cappuccino.getWaterNeeded();
            milkAvailable = milkAvailable - cappuccino.getMilkNeeded();
            coffeeBeansAvailable = coffeeBeansAvailable - cappuccino.getCoffeeBeansNeeded();
            moneyAvailable = moneyAvailable + cappuccino.getCost();
            disposableCupAvailable = disposableCupAvailable - 1;
        }
    }

    private void processLatteOrder() {
        TypesOfCoffee latte = TypesOfCoffee.LATTE;
        boolean waterEnoughForLatte = waterAvailable >= latte.getWaterNeeded();
        boolean milkEnoughForLatte = milkAvailable >= latte.getMilkNeeded();
        boolean coffeeBeansEnoughForLatte = coffeeBeansAvailable >= latte.getCoffeeBeansNeeded();

        if (!waterEnoughForLatte || !milkEnoughForLatte || !coffeeBeansEnoughForLatte){
            if (!waterEnoughForLatte){
                System.out.println("Sorry, not enough water");
            }else if (!coffeeBeansEnoughForLatte){
                System.out.println("Sorry, not enough coffee beans");
            }else {
                System.out.println("Sorry, not enough milk");
            }
        } else {
            System.out.println("I have enough resources, making you a coffee!");
            waterAvailable = waterAvailable - latte.getWaterNeeded();
            milkAvailable = milkAvailable - latte.getMilkNeeded();
            coffeeBeansAvailable = coffeeBeansAvailable - latte.getCoffeeBeansNeeded();
            moneyAvailable = moneyAvailable + latte.getCost();
            disposableCupAvailable = disposableCupAvailable - 1;
        }
    }

    private void processEspressoOrder() {
        TypesOfCoffee espresso = TypesOfCoffee.ESPRESSO;
        boolean waterEnoughForEspresso = waterAvailable >= espresso.getWaterNeeded();
        boolean coffeeBeansEnoughForEspresso = coffeeBeansAvailable >= espresso.getCoffeeBeansNeeded();

        if (!waterEnoughForEspresso || !coffeeBeansEnoughForEspresso){
            if (!waterEnoughForEspresso){
                System.out.println("Sorry, not enough water");
            }else {
                System.out.println("Sorry, not enough coffee beans");
            }
        }else {
            System.out.println("I have enough resources, making you a coffee!");
        }

             waterAvailable = waterAvailable - espresso.getWaterNeeded();
             coffeeBeansAvailable = coffeeBeansAvailable - espresso.getCoffeeBeansNeeded();
             moneyAvailable = moneyAvailable + espresso.getCost();
             disposableCupAvailable = disposableCupAvailable - 1;
    }


}
