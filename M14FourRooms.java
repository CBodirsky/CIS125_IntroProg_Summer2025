import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

//Class
class M14FourRooms {
    //array
    String[] lootItems = {"Rusty Sword", "Healing Herb", "Ancient Tome", "Silver Coin", "Dragon Scale"};
    Random randomVal = new Random();

    private int classChoice;
    private String name;
    private int totalHealth;
    private int health;
    private int attack;
    private int strength;
    private int dexterity;
    private int intelligence;
    private int gold = 0;
    private int roomsCleared = 0;
    private final ArrayList<String> playerInventory = new ArrayList<>();

    //Method and decisions
    public void assignStats(int classChoice) {

        if (classChoice == 1) {
            health = 15;
            strength = 7;
            dexterity = 3;
            intelligence = 2;
        }
        else if (classChoice == 2) {
            health = 11;
            strength = 2;
            dexterity = 3;
            intelligence = 8;
        }
        else if (classChoice == 3) {
            health = 13;
            strength = 2;
            dexterity = 9;
            intelligence = 3;
        }
        else {
            System.out.println("Please pick an appropriate class (1-3)");
            return;
        }

        this.classChoice = classChoice;
        totalHealth = health;
        attack = calculateAttack();

    }

    //Method
    public int calculateAttack() {

        if (classChoice == 2) { //mage attack value calc
            float arcaneConstant = Float.intBitsToFloat(0x5f3759df); //forbidden floating-point arcana
            float magicMultiplier = (float)Math.sqrt(arcaneConstant * arcaneConstant); //careful arcane manipulation
            return (int)(intelligence * magicMultiplier/arcaneConstant); //Final IEEE-754 arcane derivative
        } else {
            return Math.max(strength, dexterity); //warrior uses strength, archer uses dexterity
        }
    }

    //Method switch
    public void generateRoom() {
        int genRoom = randomVal.nextInt(3) + 1;
        switch (genRoom) {
            case 1:
                System.out.println("A dark, damp cavern rising well above the range of the torch’s light in your hand. You can hear the echoes of dripping water and was that… a muffled scream for help? You suppress a chill. ");
                break;
            case 2:
                System.out.println("This tunnel is lined with crumbling stone bricks, the light dully reflecting down its passage. There appears to be a trail stained into the floor, but you can’t identify what it is from. You note the faint scent of smoke, but cannot locate anything burning near you. ");
                break;
            case 3:
                System.out.println("A door leads into a finely decorated room that has seen better days. The blue painted walls are faded and flake away. Gilded trim has rotted away and fallen to the ground in many places. And a musty odor permeates from the large section of wall that collapsed on your left, leading further on. ");
        }
    }

    //Method if, else if decisions
    public void roomEvent() {
        int roomEvent = randomVal.nextInt(4) + 1;
        if (roomEvent == 1) {
            System.out.println("You found treasure and gold! +10 gold!");
            gold += 10;
            int lootIndex = randomVal.nextInt(lootItems.length);
            String foundLoot = lootItems[lootIndex];
            System.out.println("You acquired " + foundLoot + "!");
            playerInventory.add(foundLoot);
            displayStats();
        }
        else if (roomEvent == 2) {
            System.out.println("You stumble into a trap!");
            int trapDamage = randomVal.nextInt(10) + 1;
            if (trapDamage > dexterity) {
                int totalTrapDamage = trapDamage - dexterity;
                System.out.println("You took " + totalTrapDamage + " damage from the trap!");
                health -= totalTrapDamage;
                if (health <= 0) {
                    System.out.println("You died in the trap. You’re found later by teenagers who poke your body with a stick over the next months before the room caves in and gives you a proper burial");
                    adventureSummary();
                    return;
                }
            }
            else {
                System.out.println("But you evaded the trap!");
            }
            displayStats();
        }
        else if (roomEvent == 3) {
            System.out.println("You encounter a goblin!");
            int goblinHealth = randomVal.nextInt(3,12) + 1;
            int goblinAttack = randomVal.nextInt(1,5) + 1;
            while (goblinHealth > 0 && health > 0) {
                //Add randomness to attack value. Math doesn't go negative, so no clamp.
                int totalAttack = attack + (randomVal.nextInt(11) - 5); //can't use negatives in random, so subtracting to possibly have subtraction on player attack value.
                System.out.println("You attack the goblin for " + totalAttack);
                goblinHealth -= totalAttack;
                if (goblinHealth <= 0) {
                    System.out.println("The goblin is defeated! You found 10 gold!");
                    gold += 10;
                    int lootIndex = randomVal.nextInt(lootItems.length);
                    String foundLoot = lootItems[lootIndex];
                    System.out.println("You acquired " + foundLoot + "!");
                    playerInventory.add(foundLoot);
                    displayStats();
                    break;
                }
                //goblin attack CAN be negative, so clamp to zero.
                int totalGoblinAttack = clampToZero(goblinAttack + randomVal.nextInt(6) - 3); //Again, no negative in random, so subtract after to give variance
                System.out.println("The goblin attacks you for " + totalGoblinAttack);
                health -= totalGoblinAttack;
                if (health <= 0) {
                    System.out.println("You have died by a meager goblin. Your friends are embarrassed about how pitiful that is and only bring you up in conversation to laugh about it.");
                    adventureSummary();
                    return;
                }
            }
        }
        else if (roomEvent == 4) {
            System.out.println("You find nothing noteworthy in this room. Was it worth coming here?");
            displayStats();
        }

    }

    //Void Method
    public void displayStats() {
        System.out.println("Name: " + name + " Health: " + health + "/" + totalHealth + " Strength: " + strength + " Dexterity: " + dexterity + " Intelligence: " + intelligence + " Gold: " + gold);
    }

    //Void Method with decisions and for loop
    public void adventureSummary() {
        if (health <= 0) {
            System.out.println("You had a heroic-ish death...");
        } else {
            System.out.println("You decide to call it a day instead. Gunsmoke is on soon and you don't want to miss it!\n");
            System.out.println(" YOU SURVIVED THE DUNGEON! ");
            System.out.println("════════════════════════════");
        }

        System.out.println("You cleared " + roomsCleared + " rooms!");
        System.out.println("Your stats are: ");
        displayStats();
        System.out.print("Inventory: ");
        //Loop
        for (int i = 0; i < playerInventory.size(); i++) {
            System.out.print(" - " + playerInventory.get(i));
        }
    }

    //Method with parameters and return
    public int clampToZero(int clampVal) {
        //Java not having its own clamp system, I'll just have to do it myself!
        return Math.max(clampVal, 0);
    }

    //Main Method with both while and for loop and decisions
    public static void main(String[] args) {
        M14FourRooms player = new M14FourRooms();
        Scanner playerScan = new Scanner(System.in);

        System.out.println("╔════════════════════╗");
        System.out.println("║  DUNGEON QUEST RPG ║");
        System.out.println("╚════════════════════╝");

        System.out.println("What is your name?");
        player.name = playerScan.nextLine();

        //While loop
        int classChoice = 0;
        while (classChoice < 1 || classChoice > 3) {
            System.out.print("1 = Warrior \n2 = Mage \n3 = Archer \nWhat class are you (1-3)?");
            try {
                classChoice = Integer.parseInt(playerScan.nextLine());
                if (classChoice < 1 || classChoice > 3) {
                    System.out.println("Please enter a valid choice between 1 and 3.");
                }
            } catch (NumberFormatException e) {
                System.out.println("That's not a number! Please enter 1, 2, of 3.");
            }
        }
        player.assignStats(classChoice);

        //For loop
        for (int roomCount = 0; roomCount <=3; roomCount++ ) {
            if (player.health <= 0) {
                break;
            }
            System.out.println("\n ~ ~ ~ A New Room ~ ~ ~ \n");
            player.generateRoom();
            player.roomEvent();
            player.roomsCleared++;
            if (player.health > 0) {
                System.out.println("\n[Press enter to continue to the next room...]");
                playerScan.nextLine();
            }
        }
        if (player.health > 0 ) {
            player.adventureSummary();
        }
        playerScan.close();
    }
}