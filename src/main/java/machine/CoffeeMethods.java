package machine;

import java.util.Scanner;

public class CoffeeMethods {
    static Scanner scanner = new Scanner(System.in);
    CoffeeMachine coffeeMachine = new CoffeeMachine(550, 400, 540, 120, 9);
    public static boolean exit = true;
    boolean enough;


    public void remaining() {
        System.out.println("The coffee machine has:");
        System.out.println(coffeeMachine.getWater() + " ml of water");
        System.out.println(coffeeMachine.getMilk() + " ml of milk");
        System.out.println(coffeeMachine.getBeans() + " g of coffee beans");
        System.out.println(coffeeMachine.getCups() + " disposable cups");
        System.out.println("$" + coffeeMachine.getMoney() + " of money");
    }

    public void fill() {
        System.out.println("Write how many ml of water you want to add:");
        coffeeMachine.setWater(coffeeMachine.getWater() + scanner.nextInt());
        System.out.println("Write how many ml of milk you want to add:");
        coffeeMachine.setMilk(coffeeMachine.getMilk() + scanner.nextInt());
        System.out.println("Write how many grams of coffee beans you want to add:");
        coffeeMachine.setBeans(coffeeMachine.getBeans() + scanner.nextInt());
        System.out.println("Write how many disposable cups of coffee you want to add:");
        coffeeMachine.setCups(coffeeMachine.getCups() + scanner.nextInt());
    }

    public void take() {
        System.out.println("I gave you $" + coffeeMachine.getMoney());
        coffeeMachine.setMoney(0);
    }

    public void buy() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        int value = scanner.nextInt();
        isEnough();
        for (CoffeeVariant cof : CoffeeVariant.values()) {
            if (cof.value == value && enough) {
                coffeeMachine.setWater(coffeeMachine.getWater() - cof.water);
                coffeeMachine.setMilk(coffeeMachine.getMilk() - cof.milk);
                coffeeMachine.setBeans(coffeeMachine.getBeans() - cof.beans);
                coffeeMachine.setCups(coffeeMachine.getCups() - cof.cups);
                coffeeMachine.setMoney(coffeeMachine.getMoney() + cof.money);
            }
        }
    }

    public void isEnough() {
        if (coffeeMachine.getWater() < CoffeeVariant.ESPRESSO.water ||
                coffeeMachine.getWater() < CoffeeVariant.LATTE.water ||
                coffeeMachine.getWater() < CoffeeVariant.CAPPUCCINO.water) {
            enough = false;
            System.out.println("Sorry, not enough water!");
        } else if (coffeeMachine.getMilk() < CoffeeVariant.ESPRESSO.milk ||
                coffeeMachine.getMilk() < CoffeeVariant.LATTE.milk ||
                coffeeMachine.getMilk() < CoffeeVariant.CAPPUCCINO.milk) {
            enough = false;
            System.out.println("Sorry, not enough milk!");
        } else if (coffeeMachine.getBeans() < CoffeeVariant.ESPRESSO.beans ||
                coffeeMachine.getBeans() < CoffeeVariant.LATTE.beans ||
                coffeeMachine.getBeans() < CoffeeVariant.CAPPUCCINO.beans) {
            enough = false;
            System.out.println("Sorry, not enough coffee beans!");
        } else if (coffeeMachine.getCups() < CoffeeVariant.ESPRESSO.cups ||
                coffeeMachine.getCups() < CoffeeVariant.LATTE.cups ||
                coffeeMachine.getCups() < CoffeeVariant.CAPPUCCINO.cups) {
            enough = false;
            System.out.println("Sorry, not enough disposable cups!");
        } else {
            enough = true;
            System.out.println("I have enough resources, making you a coffee!");
        }

    }

    public void exit() {
        exit = false;
    }

    public void options(String action) {
        switch (action) {
            case "buy" -> buy();
            case "fill" -> fill();
            case "take" -> take();
            case "remaining" -> remaining();
            case "exit" -> exit();
        }
    }
}
