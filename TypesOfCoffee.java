package machine;

public enum TypesOfCoffee {
    ESPRESSO(250,0,16,4),
    LATTE(350,75,20,7),
    CAPPUCCINO(200,100,12,6);

    private final int waterNeeded;
    private final int milkNeeded;
    private final int coffeeBeansNeeded;
    private final int cost;

    TypesOfCoffee(int waterNeeded, int milkNeeded, int coffeeBeansNeeded, int cost) {
        this.waterNeeded = waterNeeded;
        this.milkNeeded = milkNeeded;
        this.coffeeBeansNeeded = coffeeBeansNeeded;
        this.cost = cost;
    }

    public int getWaterNeeded() {
        return waterNeeded;
    }

    public int getMilkNeeded() {
        return milkNeeded;
    }

    public int getCoffeeBeansNeeded() {
        return coffeeBeansNeeded;
    }

    public int getCost() {
        return cost;
    }
}
