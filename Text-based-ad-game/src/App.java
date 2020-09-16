import java.util.*;

public class App {
    public static void main(String[] args) {

        // System variables
        Scanner reader = new Scanner(System.in);
        Random prng = new Random();

        // Game variables and player variables
        String[] enemies = { "skeleton", "Assassin", "warrior", "mage" };
        int playerHealth = 100;
        int playerDamage = 25;

        int maxEnemyHealth = 75;
        int maxEnemyDamage = 15;

        int maxHealthPotionCount = 5;
        int healthPotionDropChance = 50; // percentage
        int healthPotionCount = 3;
        int healthPotionRegen = 30;

        boolean running = true;
        final String gameDivider = "+------------------------------------------------------------+";

        System.out.println("Welcome!");

        GAME:
        while (running) {
            System.out.println(gameDivider);

            int enemyHealth = prng.nextInt(maxEnemyHealth) + 1;
            String enemy = enemies[prng.nextInt(enemies.length)];
            System.out.println("\t# " + enemy + " has appeared #\n");
            
            COMBAT:
            while (enemyHealth > 0) {
                System.out.println("\tYour HP: " + playerHealth);
                System.out.println("\tEnemy HP: " + enemyHealth);
                System.out.println("\n\tWhat would you like to do?");
                System.out.println("\t1. Attack");
                System.out.println("\t2. Drink health potion");
                System.out.println("\t3. Run away");

                System.out.print("--> ");
                String input = reader.nextLine();

                if (input.equals("1")) {
                    int damageDealt = prng.nextInt(playerDamage);
                    int damageTaken = prng.nextInt(maxEnemyDamage);
                    
                    System.out.println(gameDivider);
                    System.out.println("Attacking!");
                    System.out.println(gameDivider);
                    playerHealth -= damageTaken;
                    enemyHealth -= damageDealt;
                    
                    enemyHealth -= damageDealt;
                    System.out.println("You attacked " + enemy + " for " + damageDealt
                                    + "\nYou took " + damageTaken + " in retaliation!");
                    System.out.println(gameDivider);
                    if (enemyHealth <= 0) {
                        System.out.println("Enemy Dead!");
                    }
                } 
                else if (input.equals("2")) {
                    if (playerHealth <= 70) {
                        System.out.println(gameDivider);
                        if (healthPotionCount > 0) {
                            System.out.println("Healing!");
                            playerHealth += healthPotionRegen;
                            healthPotionCount -= 1;
                            System.out.println("You healed for " + healthPotionRegen + " HP!"
                                            + "\nYou have " + healthPotionCount + " health potions left");
                            System.out.println(gameDivider);
                        }
                        else if (healthPotionCount == 0) {
                            System.out.println("You are out of health Potions! Kill an enemy for a chance to get one!");
                        }
                    } 
                    else {
                        System.out.println(gameDivider);
                        System.out.println("Health not low enough to use health potion");
                        System.out.println(gameDivider);
                    }
                }

                else if (input.equals("3")) {
                    System.out.println(gameDivider);
                    System.out.println("Running away");
                    continue GAME;
                }
                else {
                    System.out.println("Invalid command!");
                }
            }

             
        }


    }
}
