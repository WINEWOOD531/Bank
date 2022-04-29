package com.solvd.bank.bankWork;

import com.solvd.bank.workers.Economist;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Bank {
    private static final Logger LOGGER = LogManager.getLogger(Bank.class);
    int balance = 5000000;

    public void welcomeInBank() {
        {
            Scanner inAtm = new Scanner(System.in);
            int optionAtm = 0;
            try {
                LOGGER.info("Welcome to our bank!\n\n" +
                        "Choose what you want to do:\n1. Use ATM" +
                        "\n2. Work with economist\n3. Cash operations" +
                        "\n4. Exit Program\nChoice:");

                optionAtm = inAtm.nextInt();
                switch (optionAtm) {
                    case 1:
                        try {
                            getAtm();
                        } catch (InputMismatchException e) {
                            LOGGER.info("Exception in you method!");
                        }
                        break;
                    case 2:
                        economistWork();
                        break;
                    case 3:
                        cashOperations();
                        break;
                    case 4:
                        LOGGER.info("You have selected to exit our program! Thanks for visiting!");
                        System.exit(0);
                    default:
                        LOGGER.info("Incorrect option selected. Please try again.");
                        break;
                }
            } catch (InputMismatchException e) {
                LOGGER.error("Invalid selection! Please try again! Enter any character to continue");
                optionAtm = -1;
                inAtm.next();
            } catch (IndexOutOfBoundsException e) {
                LOGGER.error("IndexOutOfBounds! You have tried to reference an unassigned index!");
            } catch (Exception e) {
                LOGGER.error("General type of exception was thrown!" + e.getClass());
            }
        }
    }

    public void getAtm() {
        Scanner atm = new Scanner(System.in);
        List<Integer> list = new ArrayList<Integer>();
        Collections.addAll(list, 1001, 2020, 3005, 4098, 5060, 7098, 5555, 9875, 1111);
        long cardNumbers[] = {4445333311112222L, 5956111133332222L, 6657333333332222L, 5555777788889900L,
                5111222233334444L, 5467890123456789L, 4567321090123425L, 5580899012341578L, 4512480903950600L};
        int randomCardNumber = (int) Math.floor(Math.random() * cardNumbers.length);
        List<Long> long_array_to_list = new ArrayList<>();
        for (int i = 0; i < cardNumbers.length; i++) {
            long_array_to_list.add(cardNumbers[i]);
        }
        int chooseTakeCheck;
        LOGGER.info("Select an action : ");
        LOGGER.info("LIST MENU");
        LOGGER.info("_______________________");
        LOGGER.info("Press 1 to check the balance");
        LOGGER.info("Press 2 to pull cash");
        LOGGER.info("Press 3 to Go back to Main Menu.");
        LOGGER.info("Press 4 to exit");
        LOGGER.info("Your choice : ");
        int n = atm.nextInt();

        while (n != 0) {
            if (n == 1) {
                LOGGER.info("Please enter Your pin-code : ");
                int pinCode = atm.nextInt();
                while (!list.contains(pinCode)) {
                    LOGGER.info("Invalid PIN-code! Enter CORRECT PIN-code: ");
                    pinCode = atm.nextInt();
                }
                LOGGER.info("BALANCE CHECK");
                LOGGER.info("Do you want to take a check or see on screen?");
                LOGGER.info("Press 1 if YOU want take check");
                LOGGER.info("Press 2 if YOU want see balance on screen");
                int nCash = atm.nextInt();
                if (nCash == 1) {
                    LOGGER.info("Please take you check");
                    printCheckBalance(cardNumbers[n], balance);
                    LOGGER.info("Do you want to continue working with an ATM?");
                    LOGGER.info("Press 1 if YES");
                    LOGGER.info("Press 2 to exit");
                    nCash = atm.nextInt();
                    while (nCash != 0) {
                        if (nCash == 1) {
                            getAtm();
                        } else if (nCash == 2) {
                            System.exit(0);
                        } else {
                            LOGGER.info("Please try again");
                        }
                    }
                } else if (nCash == 2) {
                    LOGGER.info("Your balance = " + balance);
                    LOGGER.info("Do you want to continue working with an ATM?");
                    LOGGER.info("Press 1 if YES");
                    LOGGER.info("Press 2 to exit");
                    nCash = atm.nextInt();
                    while (nCash != 0) {
                        if (nCash == 1) {
                            getAtm();
                        } else if (nCash == 2) {
                            System.exit(0);
                        } else {
                            LOGGER.info("Please try again");
                        }
                    }
                } else {
                    LOGGER.info("Incorrect input! Please try again");
                }
            } else if (n == 2) {
                int removalAmount = 50;
                LOGGER.info("Please enter Your pin-code : ");
                int pinCode = atm.nextInt();
                while (!list.contains(pinCode)) {
                    LOGGER.info("Invalid PIN-code! Enter CORRECT PIN-code: ");
                    pinCode = atm.nextInt();
                }
                LOGGER.info("Pull the cash");
                LOGGER.info("In the ATM available bills: 50,100,200,500,1000");
                LOGGER.info("Enter the amount of money you want to draw (Minimum 50) = ");
                int withdrawal = atm.nextInt();
                int balance2 = balance - withdrawal;
                if (withdrawal <= balance && withdrawal % removalAmount == 0) {
                    LOGGER.info("Do you want to take a check?");
                    LOGGER.info("Press 1 if YES");
                    LOGGER.info("Press 2 if NO");
                    chooseTakeCheck = atm.nextInt();
                    while (chooseTakeCheck != 0) {
                        if (chooseTakeCheck == 1) {
                            printCheck(balance, withdrawal, balance2);
                            LOGGER.info("Please take your money");
                            LOGGER.info("The rest of your balance = " + balance2);
                            LOGGER.info("Do you want to continue working with an ATM?");
                            LOGGER.info("Press 1 if YES");
                            LOGGER.info("Press 2 to exit");
                            int nCash = atm.nextInt();
                            while (nCash != 0) {
                                if (nCash == 1) {
                                    getAtm();
                                } else if (nCash == 2) {
                                    System.exit(0);
                                } else {
                                    LOGGER.info("Please try again");
                                }
                            }
                        } else if (chooseTakeCheck == 2) {
                            LOGGER.info("Please take your money");
                            LOGGER.info("The rest of your balance = " + balance2);
                            LOGGER.info("Do you want to continue working with an ATM?");
                            LOGGER.info("Press 1 if YES");
                            LOGGER.info("Press 2 to exit");
                            int nCash = atm.nextInt();
                            while (nCash != 0) {
                                if (nCash == 1) {
                                    balance = balance2;
                                    getAtm();
                                } else if (nCash == 2) {
                                    System.exit(0);
                                } else {
                                    LOGGER.info("Please try again");
                                }
                            }
                        } else {
                            LOGGER.info("INCORRECT TYPE!!! Please Try again.");
                        }
                    }
                } else {
                    LOGGER.info("Please enter the number according to the provisions");
                }
            } else if (n == 3) {
                welcomeInBank();
                break;
            } else if (n == 4) {
                LOGGER.info("Go out");
                LOGGER.info("Thank You ");
                System.exit(0);
            } else {
                LOGGER.info("Please try again");
            }
        }
    }

    public void economistWork() {
        Map<String, Integer> clientPassportMap = new HashMap<>();
        clientPassportMap.put("4445333311112222", 123456789);
        clientPassportMap.put("5956111133332222", 543210123);
        clientPassportMap.put("6657333333332222", 901058080);
        Economist economist0 = new Economist("Eva", "PrivatBank", "Economist",
                "Individuals", 21, 151);
        Economist economist1 = new Economist("Natasha", "PrivatBank", "Economist",
                "Individuals", 20, 152);
        Economist economist2 = new Economist("Olga", "PrivatBank", "Economist",
                "Individuals", 20, 154);
        Economist economist3 = new Economist("Olena", "PrivatBank", "Economist",
                "Individuals", 20, 155);
        int startEconomist = 1;
        int finishEconomist = 3;
        int economistNumber = startEconomist + (int) (Math.random() * finishEconomist);
        String economistName;
        int creditSum;
        int term;
        int customerSalary;
        int customerPassportNumber;
        int startCardRandomNumber = 1000;
        int finishCardRandomNumber = 9999;
        int[] numbersCopy = new int[4];
        String str = "";
        int start = 0;
        int finish = 10;
        double monthlyCommission = 0.01;
        int interest = start + (int) (Math.random() * finish);
        double totalLoanAmount;
        Scanner inEconomist = new Scanner(System.in);
        if (economistNumber == 1) {
            economistName = economist1.getName();
        } else if (economistNumber == 1) {
            economistName = economist2.getName();
        } else {
            economistName = economist3.getName();
        }

        int optionEconomist = 0;
        try {
            LOGGER.info("Hello! My name is " + economistName + ". Can i help you?\n\n" +
                    "Select necessary variant:\nPress 1 to create new card" +
                    "\nPress 2 to oversee the card\nPress 3 to close the card" +
                    "\nPress 4 for go back to the main menu" + "\nPress 5 for Exit Program\nChoice:");

            optionEconomist = inEconomist.nextInt();
            switch (optionEconomist) {
                case 1:
                    try {
                        LOGGER.info("Choose card type which you want to create:\nPress 1 to create credit card" +
                                "\nPress 2 to create usual card\nPress 3 to create gold card" +
                                "\nPress 4 for continue work with economist" +
                                " \nPress 5 for go back to the main menu" + "\nPress 6 for Exit Program\nChoice:");
                        optionEconomist = inEconomist.nextInt();
                        while (optionEconomist != 0) {
                            if (optionEconomist == 1) {
                                LOGGER.info("Please enter a loan amount that would you like to take: ");
                                creditSum = inEconomist.nextInt();
                                LOGGER.info("Please enter a Number of months " +
                                        "on how much do you want to take credit: ");
                                term = inEconomist.nextInt();
                                LOGGER.info("Please enter a salary in one month: ");
                                customerSalary = inEconomist.nextInt();
                                LOGGER.info("The percentage of the loan will be: " + interest);
                                double сreditInterest = ((creditSum * (24 / 100) * ((term * 2) / term)) +
                                        (creditSum * monthlyCommission * term));
                                totalLoanAmount = (creditSum + сreditInterest);
                                if (totalLoanAmount > (customerSalary * term)) {
                                    while (totalLoanAmount > (customerSalary * term) &
                                            (totalLoanAmount != (customerSalary * term))) {
                                        LOGGER.info("You can't take a given loan amount. " +
                                                "Enter a smaller loan amount: ");
                                        creditSum = inEconomist.nextInt();
                                        totalLoanAmount = creditSum + (((creditSum * interest) / 100) * term);
                                    }
                                } else {
                                    LOGGER.info("The total amount of a loan with percentages " +
                                            "over the entire period is:" +
                                            totalLoanAmount);
                                    LOGGER.info("You want to continue?");
                                    LOGGER.info("------------------------------");
                                    LOGGER.info("\nPress 1 if YES\nPress 2 if NO");
                                    optionEconomist = inEconomist.nextInt();
                                    while (optionEconomist != 0) {
                                        if (optionEconomist == 1) {
                                            LOGGER.info("OK. Here you card with the loan amount indicated by you");
                                            LOGGER.info("\nPress 1 for go back to Main Menu\n" +
                                                    "Press 2 if you want continue" +
                                                    " work with economist" +
                                                    "\nPress 3 for exit program");
                                            optionEconomist = inEconomist.nextInt();
                                            while (optionEconomist != 0) {
                                                if (optionEconomist == 1) {
                                                    welcomeInBank();
                                                } else if (optionEconomist == 2) {
                                                    economistWork();
                                                } else if (optionEconomist == 3) {
                                                    System.exit(0);
                                                } else {
                                                    LOGGER.info("INCORRECT INPUT! Please try Again.");
                                                }
                                            }
                                        } else if (optionEconomist == 2) {
                                            LOGGER.info("\nPress 1 for go back to Main Menu\n" +
                                                    "Press 2 if you want continue" +
                                                    " work with economist" +
                                                    "\nPress 3 for exit program");
                                            optionEconomist = inEconomist.nextInt();
                                            while (optionEconomist != 0) {
                                                if (optionEconomist == 1) {
                                                    welcomeInBank();
                                                } else if (optionEconomist == 2) {
                                                    economistWork();
                                                } else if (optionEconomist == 3) {
                                                    System.exit(0);
                                                } else {
                                                    LOGGER.info("INCORRECT INPUT! Please try Again.");
                                                }
                                            }
                                        } else {
                                            LOGGER.info("INCORRECT INPUT! Please try Again.");
                                        }
                                    }
                                }
                            } else if (optionEconomist == 2) {
                                LOGGER.info("Good choice!");
                                LOGGER.info("This is a bank card by which you can operate with funds" +
                                        " within the country (receive and send). No funds for withdrawal. " +
                                        "Commission for replenishing cards: 1% of the replenishment amount. " +
                                        "You can read the rest of the commissions on our site.");
                                LOGGER.info("-----------------------------------------------------------------");
                                LOGGER.info("Do you want to continue?");
                                LOGGER.info("\nPress 1 if YES\nPress 2 if NO");
                                optionEconomist = inEconomist.nextInt();
                                while (optionEconomist != 0) {
                                    if (optionEconomist == 1) {
                                        LOGGER.info("OK,Input you passport number");
                                        try {
                                            customerPassportNumber = inEconomist.nextInt();
                                            LOGGER.info("OK,Here ypu card");
                                            for (int i = 0; i < 4; i++) {
                                                int randomNumberForCard = start + (int) (Math.random() * finish);
                                                if (randomNumberForCard > 9999) {
                                                    randomNumberForCard = start + (int) (Math.random() * finish);
                                                    numbersCopy[i] = randomNumberForCard;
                                                } else {
                                                    numbersCopy[i] = randomNumberForCard;
                                                }

                                            }
                                            for (int value : numbersCopy) {
                                                str = String.format("%s%s", str, value);
                                            }
                                            clientPassportMap.put(str, customerPassportNumber);
                                            LOGGER.info("What do you want to do now?");
                                            LOGGER.info("--------------------------------------");
                                            LOGGER.info("\nPress 1 for go back to Main Menu\n" +
                                                    "Press 2 if you want continue" +
                                                    " work with economist" +
                                                    "\nPress 3 for exit program");
                                            optionEconomist = inEconomist.nextInt();
                                            while (optionEconomist != 0) {
                                                if (optionEconomist == 1) {
                                                    welcomeInBank();
                                                } else if (optionEconomist == 2) {
                                                    economistWork();
                                                } else if (optionEconomist == 3) {
                                                    System.exit(0);
                                                } else {
                                                    LOGGER.info("INCORRECT INPUT! Please try Again.");
                                                }
                                            }
                                        } catch (InputMismatchException e) {
                                            LOGGER.info("Incorrect input! Please try again.");
                                        }

                                    } else if (optionEconomist == 2) {
                                        economistWork();
                                    } else {
                                        LOGGER.info("INCORRECT INPUT! Please try Again.");
                                    }
                                }
                            } else if (optionEconomist == 3) {
                                LOGGER.info("Best choice !");
                                LOGGER.info("With this card you have many advantages comparable" +
                                        " to conventional cards," +
                                        " here are some of them " +
                                        "(with the rest of you can get acquainted on our site):");
                                LOGGER.info("1)Personal banker to help solve any financial issue");
                                LOGGER.info("2)Special discounts up to 30% in more than 3,000 elite outlets");
                                LOGGER.info("3)Ability to store values in bank's safe boxes");
                                LOGGER.info("And many others...");
                                LOGGER.info("-----------------------------------------------------------------");
                                LOGGER.info("Do you want to continue?");
                                LOGGER.info("\nPress 1 if YES\nPress 2 if NO");
                                optionEconomist = inEconomist.nextInt();
                                while (optionEconomist != 0) {
                                    if (optionEconomist == 1) {
                                        LOGGER.info("OK,Input you passport number");
                                        try {
                                            customerPassportNumber = inEconomist.nextInt();
                                            LOGGER.info("OK,Here ypu card");
                                            for (int i = 0; i < 4; i++) {
                                                int randomNumberForCard = start + (int) (Math.random() * finish);
                                                if (randomNumberForCard > 9999) {
                                                    randomNumberForCard = start + (int) (Math.random() * finish);
                                                    numbersCopy[i] = randomNumberForCard;
                                                } else {
                                                    numbersCopy[i] = randomNumberForCard;
                                                }

                                            }
                                            for (int value : numbersCopy) {
                                                str = String.format("%s%s", str, value);
                                            }
                                            clientPassportMap.put(str, customerPassportNumber);
                                            LOGGER.info("What do you want to do now?");
                                            LOGGER.info("--------------------------------------");
                                            LOGGER.info("\nPress 1 for go back to Main Menu\n" +
                                                    "Press 2 if you want continue" +
                                                    " work with economist" +
                                                    "\nPress 3 for exit program");
                                            optionEconomist = inEconomist.nextInt();
                                            while (optionEconomist != 0) {
                                                if (optionEconomist == 1) {
                                                    welcomeInBank();
                                                } else if (optionEconomist == 2) {
                                                    economistWork();
                                                } else if (optionEconomist == 3) {
                                                    System.exit(0);
                                                } else {
                                                    LOGGER.info("INCORRECT INPUT! Please try Again.");
                                                }
                                            }
                                        } catch (InputMismatchException e) {
                                            LOGGER.info("Incorrect input! Please try again.");
                                        }

                                    } else if (optionEconomist == 2) {
                                        economistWork();
                                    } else {
                                        LOGGER.info("INCORRECT INPUT! Please try Again.");
                                    }
                                }
                            } else if (optionEconomist == 4) {
                                economistWork();
                            } else if (optionEconomist == 5) {
                                welcomeInBank();
                            } else if (optionEconomist == 6) {
                                LOGGER.info("You have selected to exit our program! Thanks for visiting!");
                                System.exit(0);
                            } else {
                                LOGGER.info("Incorrect input! Please try again.");
                            }
                        }
                    } catch (InputMismatchException e) {
                        LOGGER.info("Incorrect input! Please try again.");
                    }
                    break;
                case 2:
                    try {
                        LOGGER.info("Please input you passport number:");
                        int clientPassportNumber = inEconomist.nextInt();
                        if (clientPassportMap.containsValue(clientPassportNumber)) {
                            LOGGER.info("Ok. Here you new card.");
                            LOGGER.info("----------------------------------------------");
                            LOGGER.info("\nPress 1 for go back to Main Menu\nPress 2 if you want continue" +
                                    " work with economist" +
                                    "\nPress 3 for exit program");
                            optionEconomist = inEconomist.nextInt();
                            while (optionEconomist != 0) {
                                if (optionEconomist == 1) {
                                    welcomeInBank();
                                } else if (optionEconomist == 2) {
                                    economistWork();
                                } else if (optionEconomist == 3) {
                                    System.exit(0);
                                } else {
                                    LOGGER.info("INCORRECT INPUT! Please try Again.");
                                }
                            }
                        } else {
                            LOGGER.info("The passport number that you specified not registered in the system." +
                                    " You can create a new card for this Passport by choosing the" +
                                    " \"Create New Card\" item.");
                            LOGGER.info("----------------------------------------------");
                            LOGGER.info("\nPress 1 for go back to Main Menu\nPress 2 if you want continue" +
                                    " work with economist" +
                                    "\nPress 3 for exit program");
                            optionEconomist = inEconomist.nextInt();
                            while (optionEconomist != 0) {
                                if (optionEconomist == 1) {
                                    welcomeInBank();
                                } else if (optionEconomist == 2) {
                                    economistWork();
                                } else if (optionEconomist == 3) {
                                    System.exit(0);
                                } else {
                                    LOGGER.info("INCORRECT INPUT! Please try Again.");
                                }
                            }
                        }

                    } catch (InputMismatchException e) {
                        LOGGER.info("Incorrect input! Please try again.");
                    }
                    break;
                case 3:
                    int passportNumber;
                    Set keys = new HashSet<>();
                    try {
                        LOGGER.info("Please Enter you passport number : ");
                        passportNumber = inEconomist.nextInt();
                        while (!clientPassportMap.containsValue(passportNumber)) {
                            LOGGER.info("Incorrect data. Please input you passport number again ");
                            passportNumber = inEconomist.nextInt();
                        }
                        for (Map.Entry entry : clientPassportMap.entrySet()) {
                            if (entry.getValue().equals(passportNumber)) {
                                keys.add(entry.getKey());
                            }
                        }
                        LOGGER.info("Operation has been successful");
                        LOGGER.info("You card" + keys + "closed");
                        clientPassportMap.remove(keys);
                        LOGGER.info("------------------------------");
                        LOGGER.info("What do you want to do now?\nPress 1 for back to Main Menu" +
                                "\nPress 2 to use another economist function\nPress 3 to exit\nYour choice : ");
                        int nEconomist = inEconomist.nextInt();
                        while (nEconomist != 0) {
                            if (nEconomist == 1) {
                                welcomeInBank();
                            } else if (nEconomist == 2) {
                                economistWork();
                            } else if (nEconomist == 3) {
                                System.exit(0);
                            } else {
                                LOGGER.info("Please try again");
                            }
                        }
                    } catch (InputMismatchException e) {
                        LOGGER.info("Incorrect input! Please try again.");
                    }
                    break;
                case 4:
                    welcomeInBank();
                    break;
                case 5:
                    LOGGER.info("You have selected to exit our program! Thanks for visiting!");
                    System.exit(0);
                default:
                    LOGGER.info("Incorrect option selected. Please try again.");
                    break;
            }
        } catch (InputMismatchException e) {
            LOGGER.error("Invalid selection! Please try again! Enter any character to continue");
            optionEconomist = -1;
            inEconomist.next();
        } catch (IndexOutOfBoundsException e) {
            LOGGER.error("IndexOutOfBounds! You have tried to reference an unassigned index!");
        } catch (Exception e) {
            LOGGER.error("General type of exception was thrown!" + e.getClass());
        }
    }

    public void cashOperations() {
        Map<String, Double> dollarCourses = new HashMap<>();
        Map<String, Double> euroCourses = new HashMap<>();
        List<String> listCash = new ArrayList<String>();
        dollarCourses.put("purchase", 27.50);
        dollarCourses.put("sale", 28.00);
        int dollarSum;
        Double customerMoneySum;
        euroCourses.put("purchase", 29.50);
        euroCourses.put("sale", 30.00);
        int euroSum;
        Collections.addAll(listCash, "dollar", "euro");

        Scanner inCash = new Scanner(System.in);
        int optionCash = 0;
        try {
            LOGGER.info("Hello! Can i help you?\n\n" +
                    "Choose what you want to do:\n1. Pay for accounts" +
                    "\n2. Currency exchange\n3. Back to Main menu" +
                    "\n4. Exit Program\nChoice:");

            optionCash = inCash.nextInt();
            switch (optionCash) {
                case 1:
                    try {
                        int start = 10;
                        int finish = 20;
                        int commission = start + (int) (Math.random() * finish);
                        int customerSum;
                        LOGGER.info("Enter the Account number Where to make payment: ");
                        int accountNumber = inCash.nextInt();
                        LOGGER.info("Enter the amount that you want to pay: ");
                        int cashSum = inCash.nextInt();
                        LOGGER.info("Commission for this transaction: " + commission + "%");
                        int requiredSum = cashSum + ((cashSum * commission) / 100);
                        LOGGER.info("Total amount: " + requiredSum);
                        LOGGER.info("Do you want to continue and make payment?");
                        LOGGER.info("Press 1 if YES");
                        LOGGER.info("Press 2 if NO and Go back to Main Menu.");
                        LOGGER.info("Press 3 to exit");
                        LOGGER.info("Your choice : ");
                        int nCash = inCash.nextInt();
                        while (nCash != 0) {
                            if (nCash == 1) {
                                LOGGER.info("Please enter Your amount of money: ");
                                customerSum = inCash.nextInt();
                                if (requiredSum > customerSum) {
                                    while (requiredSum > customerSum & (requiredSum != customerSum)) {
                                        LOGGER.info("Insufficient funds. Need a larger amount ");
                                        customerSum = inCash.nextInt();
                                    }
                                } else {
                                    LOGGER.info("Operation has been successful");
                                    LOGGER.info("Here is your surrender: " + (customerSum - requiredSum));
                                    LOGGER.info("Please take you check");
                                    printCheckCashierAccountPayment(accountNumber,
                                            requiredSum, commission, customerSum);
                                    LOGGER.info("------------------------------");
                                    LOGGER.info("What do you want to do now?\nPress 1 for back to Main Menu" +
                                            "\nPress 2 to exit\nYour choice : ");
                                    int nCash1 = inCash.nextInt();
                                    while (nCash1 != 0) {
                                        if (nCash1 == 1) {
                                            welcomeInBank();
                                        } else if (nCash1 == 2) {
                                            System.exit(0);
                                        } else {
                                            LOGGER.info("Please try again");
                                        }
                                    }
                                }
                            } else if (nCash == 2) {
                                welcomeInBank();
                                break;
                            } else if (nCash == 3) {
                                LOGGER.info("Go out");
                                LOGGER.info("Thank You ");
                                System.exit(0);
                            } else {
                                LOGGER.info("Please try again");
                            }
                        }
                    } catch (InputMismatchException e) {
                        LOGGER.info("Incorrect input! Please try again.");
                    }
                    break;
                case 2:
                    try {
                        LOGGER.info("Now we have two currency for exchange: " + listCash.get(0) + " and "
                                + listCash.get(1));
                        LOGGER.info("-----------------------------------------------------------");
                        LOGGER.info("Dollar exchange rate: " + "\nPurchase:" + dollarCourses.get("purchase")
                                + "\nSelling:" + dollarCourses.get("sale"));
                        LOGGER.info("***************************************************************");
                        LOGGER.info("Euro exchange rate: " + "\nPurchase:" + euroCourses.get("purchase")
                                + "\nSelling:" + euroCourses.get("sale"));
                        LOGGER.info("-----------------------------------------------------------");
                        LOGGER.info("Press 1 for exchange of dollars");
                        LOGGER.info("Press 2 to exchange Euro");
                        LOGGER.info("Press 3 to Go back to Main Menu.");
                        LOGGER.info("Press 4 to exit");
                        LOGGER.info("Your choice : ");

                        int nCash0 = inCash.nextInt();

                        while (nCash0 != 0) {
                            if (nCash0 == 1) {
                                LOGGER.info("Press 1 for for buying a dollar");
                                LOGGER.info("Press 2 for sale of dollars");
                                LOGGER.info("Press 3 to Go back to Main Menu.");
                                LOGGER.info("Press 4 to exit");
                                LOGGER.info("Your choice : ");
                                int nCash1 = inCash.nextInt();
                                String currencyNameDollar = listCash.get(0);
                                while (nCash1 != 0) {
                                    if (nCash1 == 1) {

                                        LOGGER.info("Enter the amount of dollars that you want to buy : ");
                                        dollarSum = inCash.nextInt();
                                        Double requiredSum = dollarSum * dollarCourses.get("sale");
                                        LOGGER.info("This will cost: " + (dollarSum * dollarCourses.get("sale")));
                                        LOGGER.info("Give the required amount : ");
                                        customerMoneySum = inCash.nextDouble();
                                        while (requiredSum > customerMoneySum) {
                                            LOGGER.info("Insufficient funds. Need a larger amount ");
                                            customerMoneySum = inCash.nextDouble();
                                        }
                                        if (customerMoneySum >= requiredSum) {
                                            LOGGER.info("Operation has been successful");
                                            LOGGER.info("Here is your surrender" + (customerMoneySum - requiredSum));
                                            LOGGER.info("Please take you check");
                                            printCheckCashierExchange(currencyNameDollar, dollarSum,
                                                    dollarCourses.get("sale"), dollarCourses.get("purchase"),
                                                    requiredSum, customerMoneySum);
                                            LOGGER.info("------------------------------");
                                            LOGGER.info("What do you want now?\nPress 1 for back to Main Menu" +
                                                    "\nPress 2 to Exit\nYour choice :");
                                            int nCash10 = inCash.nextInt();
                                            while (nCash10 != 0) {
                                                if (nCash10 == 1) {
                                                    welcomeInBank();
                                                } else if (nCash10 == 2) {
                                                    return;
                                                } else {
                                                    LOGGER.info("Please try again");
                                                }
                                            }
                                        }
                                    } else if (nCash1 == 2) {
                                        LOGGER.info("Enter the amount of dollars that you want to sell : ");
                                        dollarSum = inCash.nextInt();
                                        Double exchangeSum = dollarSum * dollarCourses.get("purchase");
                                        LOGGER.info("You will receive: " + (dollarSum * dollarCourses.get("purchase")));
                                        LOGGER.info("Continue Operation?");
                                        LOGGER.info("Press 1 if YES");
                                        LOGGER.info("Press 2 if NO and go back to Main Menu.");
                                        LOGGER.info("Press 3 to exit");
                                        LOGGER.info("Your choice : ");
                                        int nCash10 = inCash.nextInt();
                                        if (nCash10 == 1) {
                                            LOGGER.info("Operation has been successful");
                                            LOGGER.info("Here is your money: " + (exchangeSum));
                                            LOGGER.info("Please take you check");
                                            printCheckCashierExchange(currencyNameDollar, dollarSum,
                                                    dollarCourses.get("sale"), dollarCourses.get("purchase"),
                                                    0.0, 0.0);
                                            LOGGER.info("------------------------------");
                                            LOGGER.info("What do you want now?\nPress 1 for back to Main Menu" +
                                                    "\nPress 2 to Exit\nYour choice :");
                                            nCash10 = inCash.nextInt();
                                            while (nCash10 != 0) {
                                                if (nCash10 == 1) {
                                                    welcomeInBank();
                                                } else if (nCash10 == 2) {
                                                    return;
                                                } else {
                                                    LOGGER.info("Please try again");
                                                }
                                            }
                                        } else if (nCash10 == 2) {
                                            welcomeInBank();
                                            break;
                                        } else if (nCash10 == 3) {
                                            LOGGER.info("Go out");
                                            LOGGER.info("Thank You ");
                                            System.exit(0);
                                        }
                                    } else if (nCash1 == 3) {
                                        welcomeInBank();
                                        break;
                                    } else if (nCash1 == 4) {
                                        LOGGER.info("Go out");
                                        LOGGER.info("Thank You ");
                                        System.exit(0);
                                    } else {
                                        LOGGER.info("Please try again");
                                    }
                                }

                            } else if (nCash0 == 2) {
                                LOGGER.info("Press 1 for for buying a Euro");
                                LOGGER.info("Press 2 for sale of Euro");
                                LOGGER.info("Press 3 to Go back to Main Menu.");
                                LOGGER.info("Press 4 to exit");
                                LOGGER.info("Your choice : ");
                                String currencyNameEuro = listCash.get(1);
                                int nCash2 = inCash.nextInt();

                                while (nCash2 != 0) {
                                    if (nCash2 == 1) {
                                        LOGGER.info("Enter the amount of Euro that you want to buy : ");
                                        euroSum = inCash.nextInt();
                                        Double requiredSum = euroSum * euroCourses.get("sale");
                                        LOGGER.info("This will cost: " + (euroSum * euroCourses.get("sale")));
                                        LOGGER.info("Give the required amount : ");
                                        customerMoneySum = inCash.nextDouble();
                                        while (requiredSum > customerMoneySum) {
                                            LOGGER.info("Insufficient funds. Need a larger amount ");
                                            customerMoneySum = inCash.nextDouble();
                                        }
                                        if (customerMoneySum >= requiredSum) {
                                            LOGGER.info("Operation has been successful");
                                            LOGGER.info("Here is your surrender" + (customerMoneySum - requiredSum));
                                            LOGGER.info("Please take you check");
                                            printCheckCashierExchange(currencyNameEuro, euroSum,
                                                    euroCourses.get("sale"), euroCourses.get("purchase"),
                                                    requiredSum, customerMoneySum);
                                            LOGGER.info("------------------------------");
                                            LOGGER.info("What do you want now?\nPress 1 for back to Main Menu" +
                                                    "\nPress 2 to Exit\nYour choice :");
                                            int nCash10 = inCash.nextInt();
                                            while (nCash10 != 0) {
                                                if (nCash10 == 1) {
                                                    welcomeInBank();
                                                } else if (nCash10 == 2) {
                                                    return;
                                                } else {
                                                    LOGGER.info("Please try again");
                                                }
                                            }
                                        }
                                    } else if (nCash2 == 2) {
                                        LOGGER.info("Enter the amount of Euro that you want to sell : ");
                                        euroSum = inCash.nextInt();
                                        Double exchangeSum = euroSum * euroCourses.get("purchase");
                                        LOGGER.info("You will receive: " + (euroSum * euroCourses.get("purchase")));
                                        LOGGER.info("Continue Operation?");
                                        LOGGER.info("Press 1 if YES");
                                        LOGGER.info("Press 2 if NO and go back to Main Menu.");
                                        LOGGER.info("Press 3 to exit");
                                        LOGGER.info("Your choice : ");
                                        int nCash10 = inCash.nextInt();
                                        if (nCash10 == 1) {
                                            LOGGER.info("Operation has been successful");
                                            LOGGER.info("Here is your money: " + (exchangeSum));
                                            LOGGER.info("Please take you check");
                                            printCheckCashierExchange(currencyNameEuro, euroSum,
                                                    euroCourses.get("sale"), euroCourses.get("purchase"),
                                                    0.0, 0.0);
                                            LOGGER.info("------------------------------");
                                            LOGGER.info("What do you want now?\nPress 1 for back to Main Menu" +
                                                    "\nPress 2 to Exit\nYour choice :");
                                            nCash10 = inCash.nextInt();
                                            while (nCash10 != 0) {
                                                if (nCash10 == 1) {
                                                    welcomeInBank();
                                                } else if (nCash10 == 2) {
                                                    return;
                                                } else {
                                                    LOGGER.info("Please try again");
                                                }
                                            }
                                        } else if (nCash10 == 2) {
                                            welcomeInBank();
                                            break;
                                        } else if (nCash10 == 3) {
                                            LOGGER.info("Go out");
                                            LOGGER.info("Thank You ");
                                            System.exit(0);
                                        }
                                    } else if (nCash2 == 3) {
                                        welcomeInBank();
                                        break;
                                    } else if (nCash2 == 4) {
                                        LOGGER.info("Go out");
                                        LOGGER.info("Thank You ");
                                        System.exit(0);
                                    } else {
                                        LOGGER.info("Please try again");
                                    }
                                }

                            } else if (nCash0 == 3) {
                                welcomeInBank();
                                break;
                            } else if (nCash0 == 4) {
                                LOGGER.info("Go out");
                                LOGGER.info("Thank You ");
                                System.exit(0);
                            } else {
                                LOGGER.info("Please try again");
                            }
                        }

                    } catch (InputMismatchException e) {
                        LOGGER.info("Incorrect input! Please try again.");
                    }
                    break;
                case 3:
                    welcomeInBank();
                    break;
                case 4:
                    LOGGER.info("You have selected to exit our program! Thanks for visiting!");
                    System.exit(0);
                default:
                    LOGGER.info("Incorrect option selected. Please try again.");
                    break;
            }
        } catch (InputMismatchException e) {
            LOGGER.error("Invalid selection! Please try again! Enter any character to continue");
            optionCash = -1;
            inCash.next();
        } catch (IndexOutOfBoundsException e) {
            LOGGER.error("IndexOutOfBounds! You have tried to reference an unassigned index!");
        } catch (Exception e) {
            LOGGER.error("General type of exception was thrown!" + e.getClass());
        }
    }

    public void printCheck(int oldBalance, int withdrawal, int currentBalance) {
        File file = new File("src/main/resources" +
                "Check № " + ".txt");
        int increase = 1 + (int) (Math.random() * 100000);
        while (file.exists()) {
            increase = 1 + (int) (Math.random() * 100000);
            if (increase >= 2147483647) {
                increase = 1 + (int) (Math.random() * 100000);
            }
            file = new File("src/main/resources" +
                    "Check № " + increase + ".txt");
        }
        if (!file.exists()) {
            try {
                file.createNewFile();
                FileWriter fw = new FileWriter(file.getAbsoluteFile());
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write("Check № " + increase + "\n");
                bw.write("You balance before pull the cash: " + oldBalance + "\n");
                bw.write("Withdrawal sum: " + withdrawal + "\n");
                bw.write("You balance after pull the cash: " + currentBalance + "\n");
                bw.close();
                LOGGER.info("Done");
            } catch (IOException e) {
            }
        }
    }

    public void printCheckBalance(long cardNumber, int currentBalance) {
        File file = new File("src/main/resources" +
                "Check № " + ".txt");
        int increase = 1 + (int) (Math.random() * 100000);
        while (file.exists()) {
            increase = 1 + (int) (Math.random() * 100000);
            if (increase >= 2147483647) {
                increase = 1 + (int) (Math.random() * 100000);
            }
            file = new File("src/main/resources" +
                    "Check № " + increase + ".txt");
        }
        if (!file.exists()) {
            try {
                file.createNewFile();
                FileWriter fw = new FileWriter(file.getAbsoluteFile());
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write("Check № " + increase + "\n");
                bw.write("Card Number: " + cardNumber + "\n");
                bw.write("You balance: " + currentBalance + "\n");
                bw.close();
                LOGGER.info("Done");
            } catch (IOException e) {
            }
        }
    }

    public void printCheckCashierAccountPayment(int accountNumber, int requiredSum, int commission,
                                                int customerSum) {
        File file = new File("src/main/resources" +
                "CashierCheck № " + ".txt");
        int increase = 1 + (int) (Math.random() * 100000);
        while (file.exists()) {
            increase = 1 + (int) (Math.random() * 100000);
            if (increase >= 2147483647) {
                increase = 1 + (int) (Math.random() * 100000);
            }
            file = new File("src/main/resources" +
                    "CashierCheck № " + increase + ".txt");
        }
        if (!file.exists()) {
            try {
                file.createNewFile();
                FileWriter fw = new FileWriter(file.getAbsoluteFile());
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write("Check № " + increase + "\n");
                bw.write("Account number: " + accountNumber + "\n");
                bw.write("Amount to pay: " + requiredSum + "\n");
                bw.write("Сommission: " + commission + "\n");
                bw.write("Customer amount: " + customerSum + "\n");
                bw.write("Surrender: " + (customerSum - requiredSum) + "\n");
                bw.close();
                LOGGER.info("Done");
            } catch (IOException e) {
            }
        }
    }

    public void printCheckCashierExchange(String currencyName, int exchangeSum, Double saleCourse, Double purchaseCourse,
                                          Double requiredSum, Double customerSum) {
        File file = new File("src/main/resources" +
                "CashierCheck № " + ".txt");
        int increase = 1 + (int) (Math.random() * 100000);
        while (file.exists()) {
            increase = 1 + (int) (Math.random() * 100000);
            if (increase >= 2147483647) {
                increase = 1 + (int) (Math.random() * 100000);
            }
            file = new File("src/main/resources" +
                    "CashierCheck № " + increase + ".txt");
        }
        if (!file.exists()) {
            try {
                file.createNewFile();
                FileWriter fw = new FileWriter(file.getAbsoluteFile());
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write("Check № " + increase + "\n");
                bw.write("Currency Name: " + currencyName + "\n");
                bw.write("Exchange Sum: " + exchangeSum + "\n");
                bw.write("Sale Course: " + saleCourse + "\n");
                bw.write("Purchase Course: " + purchaseCourse + "\n");
                bw.write("Required Sum: " + requiredSum + "\n");
                bw.write("Customer amount: " + customerSum + "\n");
                bw.write("Surrender: " + (customerSum - requiredSum) + "\n");
                bw.close();
                LOGGER.info("Done");
            } catch (IOException e) {
            }
        }
    }

    public void getAction() {
        Scanner in = new Scanner(System.in);

        List<Account> accountList = new ArrayList<Account>();
        Account acc;
        int option = 0;

        int accountNumber;
        String customerName, maturityDate, debitCardNumber, pinCode;
        float balance, originalLoanAmount;

        while (option != 4) {
            try {
                LOGGER.info("Welcome to our banking application!\n\n" +
                        "Select from an option below:\n1. Add new Savings Account" +
                        "\n2. Add new Loan Account\n3. Display all Accounts" +
                        "\n4. Exit Program\nChoice:");

                option = in.nextInt();
                switch (option) {
                    case 1:
                        try {
                            Saving saving = new Saving();
                            acc = saving.addAccount();
                            accountList.add(acc);
                        } catch (InputMismatchException e) {
                            LOGGER.info("Exception handled for Savings!");
                        }
                        break;
                    case 2:
                        Loan loan = new Loan();
                        acc = loan.addAccount();
                        accountList.add(acc);
                        break;
                    case 3:
                        LOGGER.info(accountList);
                        break;
                    case 4:
                        LOGGER.info("You have selected to exit our program! Thanks for visiting!");
                        return;
                    default:
                        LOGGER.info("Incorrect option selected. Please try again.");
                        break;
                }
            } catch (InputMismatchException e) {
                LOGGER.error("Invalid selection! Please try again! Enter any character to continue");
                option = -1;
                in.next();
            } catch (IndexOutOfBoundsException e) {
                LOGGER.error("IndexOutOfBounds! You have tried to reference an unassigned index!");
            } catch (Exception e) {
                LOGGER.error("General type of exception was thrown!" + e.getClass());
            }
        }
    }
}

