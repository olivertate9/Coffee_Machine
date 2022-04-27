package machine;

public enum CoffeeVariant {
    ESPRESSO("1", 250, 0, 16, 1, 4),
    LATTE("2", 350, 75, 20, 1, 7),
    CAPPUCCINO("3", 200, 100, 12, 1, 6),
    BACK("back", 0, 0, 0, 0, 0);


    final String value;
    final int water;
    final int milk;
    final int beans;
    final int cups;
    final int money;

    CoffeeVariant(String value, int water, int milk, int beans, int cups, int money) {
        this.value = value;
        this.water = water;
        this.milk = milk;
        this.beans = beans;
        this.cups = cups;
        this.money = money;
    }
}