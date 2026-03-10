
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();

        // Title
        System.out.println("**************************");
        System.out.println("Welcome to Man vs. Dragons");
        System.out.println("**************************");

        // Splash page
        System.out.println();
        String splashScreen = "                                                       ____________\n" +
                "                                 (`-..________....---''  ____..._.-`\n" +
                "                                  \\\\`._______.._,.---'''     ,'\n" +
                "                                  ; )`.      __..-'`-.      /\n" +
                "                                 / /     _.-' _,.;;._ `-._,'\n" +
                "                                / /   ,-' _.-'  //   ``--._``._\n" +
                "                              ,','_.-' ,-' _.- (( =-    -. `-._`-._____\n" +
                "                            ,;.''__..-'   _..--.\\\\.--'````--.._``-.`-._`.\n" +
                "             _          |\\,' .-''        ```-'`---'`-...__,._  ``-.`-.`-.`.\n" +
                "  _     _.-,'(__)\\__)\\-'' `     ___  .          `     \\      `--._\n" +
                ",',)---' /|)          `     `      ``-.   `     /     /     `     `-.\n" +
                "\\_____--.  '`  `               __..-.  \\     . (   < _...-----..._   `.\n" +
                " \\_,--..__. \\\\ .-`.\\----'';``,..-.__ \\  \\      ,`_. `.,-'`--'`---''`.  )\n" +
                "           `.\\`.\\  `_.-..' ,'   _,-..'  /..,-''(, ,' ; ( _______`___..'__\n" +
                "                   ((,(,__(    ((,(,__,'  ``'-- `'`.(\\  `.,..______   SSt\n" +
                "                                                      ``--------..._``--.__\n";
        System.out.println(splashScreen);
        System.out.println();

        // Grab user configuration data points
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Hero hit points: ");
        int heroHP = scanner.nextInt();
        System.out.print("Enter Hero damage points: ");
        int heroDamage        = scanner.nextInt();

        // Setup our Dragons
        int[] dragonHPs    = { 1000, 1000, 3000 };
        int[] dragonDamage = { 200,  200,  300   };

        // Start the battle until all dragons are dead or hero is dead
        boolean heroWins = false;
        while(true) {
            System.out.println("Hero has " + heroHP + " HP and deals " + heroDamage + " points of damage");
            System.out.println();

            printDragonStatus(dragonHPs, dragonDamage);

            // when hero hit points less than zero HP we have died
            if(heroHP < 1) {
                heroWins = false;
                break;
            }

            // when all dragons have less than zero HP we win
            if(dragonHPs[0] < 1 && dragonHPs[1] < 1 && dragonHPs[2] < 1) {
                heroWins = true;
                break;
            }

            // get user input on which dragon to attack
            int dragonChoice = 0;
            while(dragonChoice < 1 || dragonChoice > 3) {
                System.out.print("Hero's turn to attack. Which Dragon would you like to attack (1, 2, 3)?");
                dragonChoice = scanner.nextInt();
            }

            // subtract one from user input to access actual dragon
            dragonChoice--;

            // Attack the dragons
            System.out.println("Attacking Dragon " + dragonChoice);
            if(dragonHPs[dragonChoice] < 1) {
                System.out.println("Dragon " + dragonChoice + " is already dead!");
            } else {
                int heroHitsForDmg = random.nextInt(heroDamage);

                dragonHPs[dragonChoice] = dragonHPs[dragonChoice] - heroHitsForDmg;
            }


            // Dragons attack Hero
            for(int i = 0; i < dragonHPs.length; i++) {
                if(dragonHPs[i] > 0) {
                    int dragonHitsForDmg = random.nextInt(dragonDamage[i]);
                    heroHP = heroHP - dragonHitsForDmg;
                }
            }
        }

        System.out.println("Battle Outcome");
        System.out.println("--------------");
        System.out.println("Hero has " + heroHP + " HP and deals " + heroDamage + " points of damage");
        System.out.println();

        printDragonStatus(dragonHPs, dragonDamage);

        System.out.println();        if(heroWins == false) {
            String tombstone = "                  _  /)\n" +
                    "                 mo / )\n" +
                    "                 |/)\\)\n" +
                    "                  /\\_\n" +
                    "                  \\__|=\n" +
                    "                 (    )\n" +
                    "                 __)(__\n" +
                    "           _____/      \\\\_____\n" +
                    "          |  _     ___   _   ||\n" +
                    "          | | \\     |   | \\  ||\n" +
                    "          | |  |    |   |  | ||\n" +
                    "          | |_/     |   |_/  ||\n" +
                    "          | | \\     |   |    ||\n" +
                    "          | |  \\    |   |    ||\n" +
                    "          | |   \\. _|_. | .  ||\n" +
                    "          |                  ||\n" +
                    "          |     Hero         ||\n" +
                    "          |                  ||\n" +
                    "  *       | *   **    * **   |**      **\n" +
                    "   \\))ejm97/.,(//,,..,,\\||(,,.,\\\\,.((//";
            System.out.println(tombstone);
            System.out.println("You were DEFEATED!");
        } else {
            System.out.println("You are a true hero you WIN!");
        }
    }

    private static void printDragonStatus(int[] dragonHPs, int[] dragonDamage) {
        System.out.println("Dragons Status");
        System.out.println("--------------");

        for(int i = 0; i < dragonHPs.length && i < dragonDamage.length; i++) {
            System.out.println("Dragon " + (i+1) + " " + dragonHPs[i] + " HP and deals " + dragonDamage[i] + " points of damage");
        }
    }
}