package com.company;

import java.util.Scanner;

public class Main {

    public static void body_fat_table() // print after body fat %
    {
        final Object[][] table = new String[6][];
        table[0] = new String[] {"Description", "Women", "Men"};
        table[1] = new String[] {"Essential Fat", "10-13%", "02-05%"};
        table[2] = new String[] {"Athletes", "14-20%", "06-13%"};
        table[3] = new String[] {"Fitness", "21-24%", "14-17%"};
        table[4] = new String[] {"Average", "25-31%", "18-25%"};
        table[5] = new String[] {"Obese", "32+%", "25+%"};

        System.out.println();
        for(final Object[] row : table)
        {
            System.out.format("%25s%15s%15s%n", row);
        }
    }

    public static void bmi_table() // print BMI table
    {
        final Object[][] table = new String[9][];
        table[0] = new String[] {"Category", "BMI Range - kg/m^2"};
        table[1] = new String[] {"Severe Thinness", "<16"};
        table[2] = new String[] {"Moderate Thinness", "16-17"};
        table[3] = new String[] {"Mild Thinness", "17-18.5"};
        table[4] = new String[] {"Normal", "18.5-25"};
        table[5] = new String[] {"Overweight", "25-30"};
        table[6] = new String[] {"Obese Class 1", "30-35"};
        table[7] = new String[] {"Obese Class 2", "35-40"};
        table[8] = new String[] {"Obese Class 3", ">40"};

        System.out.println();
        for(final Object[] row : table)
        {
            System.out.format("%25s%25s%n", row);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Body_Fat s = new Body_Fat();
        System.out.println("\n\tEnter your details"); //Getting Person Details
        s.setPerson();

        char choice1,choice2;
        byte choice = 1;
        while(choice == 1) // Making it Menu-Driven
        {
            System.out.println("\n\tEnter T to calculate Total Daily Energy Expenditure(Calories Burnt)");
            System.out.println("\tEnter B to calculate Body Mass Index(BMI)");
            System.out.println("\tEnter A to calculate Calories Burnt during a specific activity");
            System.out.println("\tEnter C to calculate Calorie Intake Per Day");
            System.out.println("\tEnter F to calculate Body Fat Percentage");
            System.out.println("\tEnter E to exit");
            System.out.print("\tEnter choice : ");
            choice1 = sc.next().charAt(0);
            switch(choice1) //Switch Case
            {
                case 't':
                case 'T': s.setTotal_daily_energy_expenditure();
                    break;

                case 'b':
                case 'B': System.out.print("\n\tBody Mass Index(BMI) : ");
                    s.BMI_analytics();
                    bmi_table();
                    break;

                case 'a':
                case 'A': do // Using do while so that we can move back to main menu
                {
                    System.out.println("\n\tEnter W to calculate Calories Burnt during walking");
                    System.out.println("\tEnter J to calculate Calories Burnt during jogging");
                    System.out.println("\tEnter C to calculate Calories Burnt during cycling");
                    System.out.println("\tEnter S to calculate Calories Burnt during swimming");
                    System.out.println("\tEnter E to move back to main menu ");
                    System.out.print("\tEnter choice : ");
                    choice2 = sc.next().charAt(0);
                    switch(choice2) // Nested Switch Case
                    {
                        case 'w':
                        case 'W': s.setCb_walking();
                            break;

                        case 'j':
                        case 'J': s.setCb_jogging();
                            break;

                        case 'c':
                        case 'C': s.setCb_cycling();
                            break;

                        case 's':
                        case 'S': s.setCb_swimming();
                            break;

                        case 'e':
                        case 'E': break;

                        default : System.out.println("\n\tInvalid Input, Please Re-Enter");
                    }
                } while(choice2 != 'E' && choice2 != 'e');
                    break;

                case 'c':
                case 'C': s.setCalorie_intake();
                    s.getCalorie_intake();
                    break;

                case 'f':
                case 'F': s.setBody_fat();
                    body_fat_table();
                    break;

                case 'e':
                case 'E':System.exit(0);
                    break;

                default : System.out.println("\n\tInvalid Input, Please Re-Enter");
            }
            System.out.print("\n\tEnter 1 to Main menu\n\tEnter 0 to Exit : ");
            choice = sc.nextByte();
        }
    }
}
