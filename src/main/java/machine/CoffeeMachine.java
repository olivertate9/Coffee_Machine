package machine;

public class CoffeeMachine {
    private int money;
    private int water;
    private int milk;
    private int beans;
    private int cups;

    CoffeeMachine(int money, int water, int milk, int beans, int cups) {
        this.money = money;
        this.milk = milk;
        this.water = water;
        this.beans = beans;
        this.cups = cups;
    }

    public static void main(String[] args) {
        CoffeeMethods coffeeMethods = new CoffeeMethods();

        while (CoffeeMethods.exit) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            coffeeMethods.options(CoffeeMethods.scanner.next());
            System.out.println();
        }
    }

    public int getWater() {
        return water;
    }

    public void setWater(int water) {
        this.water = water;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getMilk() {
        return milk;
    }

    public void setMilk(int milk) {
        this.milk = milk;
    }

    public int getBeans() {
        return beans;
    }

    public void setBeans(int beans) {
        this.beans = beans;
    }

    public int getCups() {
        return cups;
    }

    public void setCups(int cups) {
        this.cups = cups;
    }
}
