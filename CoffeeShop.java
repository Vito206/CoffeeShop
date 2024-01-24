import java.io.IOException;
import java.io.*; 
import java.util.*;
import java.util.Scanner;
import java.util.Arrays; 
import java.util.List;
/**
 * Write a description of class CoffeeShop here.
 *
 * @author (Vito Mkrtychyan)
 * @version (11/27/22)
 */
public class CoffeeShop
{
    private static Scanner scanner = new Scanner(System.in);

    private static Order order;
    private static Time time;
    
    public static void main(String[] args) {
        
        ReadFile();
        //Welcome user
        System.out.print("\nHello, welcome to the Java shop! Please enter your name: ");
        final String name = scanner.nextLine();
        order = new Order(name);
        
        //repeat from beginning if user wants to order again 
        String orderAgain;
        do {
            promptTime();
            printMenu();
            promptTeaOrCoffee();
            System.out.println("Would you like to order again? Enter 'Yes' or 'No':");
            orderAgain = scanner.nextLine();
        } while (orderAgain.equalsIgnoreCase("yes"));

        printReceipt();
    }
    
    /**
     * @throws FileNotFoundException if ReadMe file does not exist
     */
    public static void ReadFile() { 
        //Give details to user about my program and how to order from my shop
        try { 
            Scanner sc = new Scanner(new FileInputStream("ReadMe.txt"));
            while(sc.hasNextLine()) { 
                System.out.println(sc.nextLine()); 
            }
            sc.close();
        }
        catch(IOException e) { 
            System.out.println("File not found");
            e.printStackTrace();
        }
        
    }

    //ask user if they want to order tea or coffee
    private static void promptTeaOrCoffee() {
        System.out.printf("%s, please enter tea(0) or coffee(1):\n", order.getName());
        final String teaOrCoffee = scanner.nextLine();
        switch (teaOrCoffee) {
            case "0": 
                promptTea();
                break; 
            case "1": 
                promptCoffee(); 
                break;
            default: 
                System.out.println("Invalid Choice");
        }  
    }

    //Ask user to input time of their order in hours and then minutes
    private static void promptTime() {
        System.out.println("Based on military time, when should the order be prepared?");

        System.out.println();
        final int hour = ConsoleUtils.promptNumberBetween("For hours, enter a value between 0 and 23:\t", 0, 23);

        System.out.println();
        final int minute = ConsoleUtils.promptNumberBetween("For minutes, enter a value between 0 and 59:\t", 0, 59);

        order.setOrderTime(new Time(hour, minute));
    }

    //print coffee and tea menu to the screen
    public static void printMenu() {
        printTeaMenu();
        System.out.println();
        printCoffeeMenu();
    }

    //tea menu
    private static void printTeaMenu() {
        System.out.println("                                                                 ~~ Tea Menu ~~");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-20s", "Tea type:");
        System.out.printf("%-20s", "Green tea");
        System.out.printf("%-20s", "Black tea");
        System.out.printf("%-20s", "Herbal tea");

        System.out.println("\n--------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-20s", "Tea size:");
        System.out.printf("%-20s", "Short");
        System.out.printf("%-20s", "Tall");
        System.out.printf("%-20s", "Grande");
        System.out.printf("%-20s", "Venti");

        System.out.println("\n--------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-20s", "Milk type:");
        System.out.printf("%-20s", "Nonfat");
        System.out.printf("%-20s", "Almond");
        System.out.printf("%-20s", "Coconut");
        System.out.printf("%-20s", "Oatmilk");
        System.out.printf("%-20s", "Soy");
        System.out.printf("%-20s", "Half and half");

        System.out.println("\n--------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-20s", "Sweetener type:");
        System.out.printf("%-20s", "Sugar");
        System.out.printf("%-20s", "Honey");
        System.out.printf("%-20s", "Splenda");
        System.out.printf("%-20s", "Lemon");

        System.out.println("\n--------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-20s", "Syrup type:");
        System.out.printf("%-20s", "Caramel");
        System.out.printf("%-20s", "Raspberry");
        System.out.printf("%-20s", "Vanilla");
        System.out.printf("%-20s", "Peppermint");

        System.out.println("\n--------------------------------------------------------------------------------------------------------------------------------------------");
    }

    //coffee menu
    private static void printCoffeeMenu() {
        System.out.println("                                                                ~~ Coffee Menu ~~");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-20s", "Coffee type:");
        System.out.printf("%-20s", "Espresso short");
        System.out.printf("%-20s", "Espresso long");
        System.out.printf("%-20s", "Latte");
        System.out.printf("%-20s", "Cappuccino");
        System.out.printf("%-20s", "Americano");
        System.out.printf("%-20s", "Machiatto");

        System.out.println("\n--------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-20s", "Coffee size:");
        System.out.printf("%-20s", "Short");
        System.out.printf("%-20s", "Tall");
        System.out.printf("%-20s", "Grande");
        System.out.printf("%-20s", "Venti");

        System.out.println("\n--------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-20s", "Milk type:");
        System.out.printf("%-20s", "Nonfat");
        System.out.printf("%-20s", "Almond");
        System.out.printf("%-20s", "Coconut");
        System.out.printf("%-20s", "Oatmilk");
        System.out.printf("%-20s", "Soy");
        System.out.printf("%-20s", "Half and half");

        System.out.println("\n--------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-20s", "Coffee sweeteners:");
        System.out.printf("%-20s", "Sugar");
        System.out.printf("%-20s", "Honey");
        System.out.printf("%-20s", "Nutmeg");
        System.out.printf("%-20s", "Maple syrup");
        System.out.printf("%-20s", "Splenda");

        System.out.println("\n--------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-20s", "Coffee temperature:");
        System.out.printf("%-20s", "Iced");
        System.out.printf("%-20s", "Warm");
        System.out.printf("%-20s", "Regular");
        System.out.printf("%-20s", "Hot");
        System.out.printf("%-20s", "Extra hot");

        System.out.println("\n--------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-20s", "Coffee foam:");
        System.out.printf("%-20s", "Light");
        System.out.printf("%-20s", "Regular");
        System.out.printf("%-20s", "Extra");

        System.out.println("\n--------------------------------------------------------------------------------------------------------------------------------------------");
    }

    //ask user specifics about their tea and how they want it made
    public static void promptTea() {
        order.addItem("Order of tea:");

        final String teaType = ConsoleUtils.promptString(
                "Please enter valid tea type:",
                "green tea", "black tea", "herbal tea"
            );
        order.addItem("Tea type: " + teaType);

        final String teaSize = ConsoleUtils.promptString(
                "Please enter valid tea size:",
                "Short", "Tall", "Grande", "Venti"
            );
        order.addItem("Tea size: " + teaSize);

        final String teaMilkType = ConsoleUtils.promptString(
                "Please enter valid tea milk type(enter 'none' if don't want any):",
                "none", "nonfat", "almond", "coconut", "oatmilk", "soy", "half and half"
            );
        if (!teaMilkType.equalsIgnoreCase("none")) {
            order.addItem("Tea milk type: " + teaMilkType);
        }

        final String teaSweetener = ConsoleUtils.promptString(
                "Please enter valid tea sweetener type(enter 'none' if don't want any):",
                "none", "sugar", "honey", "splenda", "lemon"
            );
        if (!teaSweetener.equalsIgnoreCase("none")) {
            order.addItem("Tea sweetener type: " + teaSweetener);
        }

        final String teaSyrup = ConsoleUtils.promptString(
                "Please enter valid tea syrup(enter 'none' if don't want any):",
                "none", "caramel", "raspberry", "vanilla", "peppermint"
            );
        if (!teaSyrup.equalsIgnoreCase("none")) {
            order.addItem("Tea syrup: " + teaSyrup);
        }

        String teaAmountPrompt = String.format("Please enter valid number of %s:", teaType);
        final int teaAmount = ConsoleUtils.promptNumberBetween(teaAmountPrompt, 0, 100);
        order.addItem("number of teas: " + teaAmount);
    }

    //ask user specifics about their coffee and how they want it made
    private static void promptCoffee() {
        order.addItem("Order of coffee:");

        final String coffeeType = ConsoleUtils.promptString(
                "Please enter valid coffee type:",
                "espresso short", "espresso long", "latte", "cappuccino", "americano", "machiato"
            );
        order.addItem("Coffee type: " + coffeeType);

        final String coffeeSize = ConsoleUtils.promptString(
                "Please enter valid coffee size:",
                "Short", "Tall", "Grande", "Venti"
            );
        order.addItem("Coffee size: " + coffeeSize);

        final String coffeeMilkType = ConsoleUtils.promptString(
                "Please enter valid coffee milk type(enter 'none' if don't want any):",
                "none", "nonfat", "almond", "coconut", "oatmilk", "soy", "half and half"
            );
        if (!coffeeMilkType.equalsIgnoreCase("none")) {
            order.addItem("Coffee milk: " + coffeeMilkType);
        }

        final String coffeeSweetener = ConsoleUtils.promptString(
                "Please enter valid coffee sweetener(enter 'none' if don't want any):",
                "none", "sugar", "honey", "nutmeg", "maple syrup", "soy", "half and half"
            );
        if (!coffeeSweetener.equalsIgnoreCase("none")) {
            order.addItem("Coffee sweetener: " + coffeeSweetener);
        }

        final String coffeeTemperature = ConsoleUtils.promptString(
                "Please enter valid coffee temperature:",
                "iced", "warm", "regular", "hot", "extra hot"
            );
        order.addItem("Coffee temperature: " + coffeeTemperature);

        final String coffeeFoam = ConsoleUtils.promptString(
                "Please enter valid coffee foam(enter 'none' if don't want any):",
                "light", "regular", "extra"
            );
        if (!coffeeFoam.equalsIgnoreCase("none")) {
            order.addItem("Coffee foam: " + coffeeFoam);
        }
    }

    //print receipt to screen for user at end of program and tell them to have a nice day
    private static void printReceipt() {
        System.out.println("Here is a copy of your order:\n");
        System.out.printf("~~~~~~~~~~~ Order Receipt for %s ~~~~~~~~~~~\n", order.getName());
        System.out.printf("Order time given: %s\n", order.getOrderTime());
        System.out.println();
        System.out.println(order);
        System.out.println();
        System.out.printf("Transaction complete, have a nice day %s!!!", order.getName());
    }
}

class ConsoleUtils {
    private static Scanner scanner = new Scanner(System.in);

    /**
     * Prompts the user to enter a number, only accepting between a minimum and maximum.
     * User is re-prompted if answer is invalid.
     * 
     * Returns a number the user has answered that is within this min and max range.
     * 
     * When prompting the user for input, code like this is written:
     * 
     * int answer = scanner.nextInt();
     * scanner.nextLine();
     * while(answer < 0 || answer > 100) {
     *     System.out.println("That's not valid. Try again:");
     *     answer = scanner.nextInt();
     *     scanner.nextLine();
     * }
     */
    public static int promptNumberBetween(String prompt, int min, int max) {
        System.out.println(prompt);
        int number = scanner.nextInt();
        scanner.nextLine();
        while (number < min || number > max) {
            System.out.println(prompt);
            number = scanner.nextInt();
            scanner.nextLine();
        }
        
        return number;
    }

     /**
     * Prompts the user to enter a string, only accepting those specified after the first argument.
     * User is re-prompted if answer is invalid.
     * 
     * Returns one of the valid choices that the user has answered.
     * 
     * When prompting the user for input, code like this is written:
     * 
     * System.out.println("Which do you like the most, pie or cake?");
     * String answer = scanner.nextLine();
     * while(!answer.equals("pie") || !answer.equals("cake")) {
     *     System.out.println("That's not valid. Try again:");
     *     answer = scanner.nextLine();
     * }
     */
    public static String promptString(String prompt, String... validOptions) {
        List<String> validOptionsList = Arrays.asList(validOptions);
        System.out.println(prompt);
        String answer = scanner.nextLine();
        while (!isValidOption(answer, validOptions)) {
            printValidOptions(validOptions);
            System.out.println(prompt);
            answer = scanner.nextLine();
        }

        return answer;
    }

    /**
     * Returns true if the answer given exists in the list of valid options
     */
    private static boolean isValidOption(String answer, String... validOptions) {
        for (String option : validOptions) {
            if (answer.equalsIgnoreCase(option)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Helper method to print all the valid options to the console
     */
    private static void printValidOptions(String... validOptions) {
        System.out.println("Valid options: ");
        System.out.print("[ ");

        System.out.print(validOptions[0]);
        for (int i = 1; i < validOptions.length; i++) {
            System.out.print(" | ");
            System.out.print(validOptions[i]);
        }
        System.out.println(" ]");
    }
}

