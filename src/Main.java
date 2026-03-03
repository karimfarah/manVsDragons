
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
        int dragon1HP = 100;
        int dragon1Damage = 20;
        int dragon2HP = 100;
        int dragon2Damage = 20;
        int dragon3HP = 100;
        int dragon3Damage = 20;

        // Start the battle until all dragons are dead or hero is dead
        boolean heroWins = false;
        while(true) {
            System.out.println("Hero has " + heroHP + " HP and deals " + heroDamage + " points of damage");
            System.out.println();

            System.out.println("Dragons Status");
            System.out.println("--------------");
            System.out.println("Dragon 1 " + dragon1HP + " HP and deals " + dragon1Damage + " points of damage");
            System.out.println("Dragon 2 " + dragon2HP + " HP and deals " + dragon2Damage + " points of damage");
            System.out.println("Dragon 3 " + dragon3HP + " HP and deals " + dragon3Damage + " points of damage");
            System.out.println();

            // when hero hit points less than zero HP we have died
            if(heroHP < 1) {
                heroWins = false;
                break;
            }

            // when all dragons have less than zero HP we win
            if(dragon1HP < 1 && dragon2HP < 1 && dragon3HP < 1) {
                heroWins = true;
                break;
            }

            // get user input on which dragon to attack
            int dragonChoice = 0;
            while(dragonChoice < 1 || dragonChoice > 3) {
                System.out.print("Hero's turn to attack. Which Dragon would you like to attack (1, 2, 3)?");
                dragonChoice = scanner.nextInt();
            }

            // Attack the dragons
            System.out.println("Attacking Dragon " + dragonChoice);
            if(dragonChoice == 1) {

                // if dragon is already dead tell user but they lose a turn
                if(dragon1HP < 1) {
                    System.out.println("Dragon 1 is already dead!");
                } else {
                    int heroHitsForDmg = random.nextInt(heroDamage);

                    dragon1HP = dragon1HP - heroHitsForDmg;
                }

            } else if(dragonChoice == 2) {

                // if dragon is already dead tell user but they lose a turn
                if(dragon2HP < 1) {
                    System.out.println("Dragon 2 is already dead!");
                } else {
                    int heroHitsForDmg = random.nextInt(heroDamage);

                    dragon2HP = dragon2HP - heroHitsForDmg;
                }

            } else if(dragonChoice == 3) {

                // if dragon is already dead tell user but they lose a turn
                if (dragon3HP < 1) {
                    System.out.println("Dragon 3 is already dead!");
                } else {
                    int heroHitsForDmg = random.nextInt(heroDamage);

                    dragon3HP = dragon3HP - heroHitsForDmg;
                }

            }

            // Dragons attack Hero
            if(dragon1HP > 0) {
                int dragonHitsForDmg = random.nextInt(dragon1Damage);
                heroHP = heroHP - dragonHitsForDmg;
            }

            if(dragon2HP > 0) {
                int dragonHitsForDmg = random.nextInt(dragon2Damage);
                heroHP = heroHP - dragonHitsForDmg;
            }

            if(dragon3HP > 0) {
                int dragonHitsForDmg = random.nextInt(dragon3Damage);
                heroHP = heroHP - dragonHitsForDmg;
            }
        }

        System.out.println("Battle Outcome");
        System.out.println("--------------");
        System.out.println("Hero has " + heroHP + " HP and deals " + heroDamage + " points of damage");
        System.out.println();
        System.out.println("Dragon 1 " + dragon1HP + " HP and deals " + dragon1Damage + " points of damage");
        System.out.println("Dragon 2 " + dragon2HP + " HP and deals " + dragon2Damage + " points of damage");
        System.out.println("Dragon 3 " + dragon3HP + " HP and deals " + dragon3Damage + " points of damage");
        if(heroWins == false) {
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
}