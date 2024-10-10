package section3pelagio;

import javax.swing.JOptionPane;

public class Section3Pelagio {

    public static void main(String[] args) {
        
        //start scene
  String[] startOptions = new String[]{"Start", "Exit"}; //array declaration options para sa Welcome dialog box.
int startGame = JOptionPane.showOptionDialog(null, 
        "Welcome to the world of Pipines. Press Start to begin.", 
        "Welcome!", 0, JOptionPane.INFORMATION_MESSAGE, null, startOptions, startOptions[0]); //INFORMATION_MESSAGE para ma declare as information ung dialog box

if (startGame != 0) { 
    JOptionPane.showMessageDialog(null, "Goodbye, Adventurer!", "Exit", JOptionPane.INFORMATION_MESSAGE);
    System.exit(0);  
}
JOptionPane.showMessageDialog(null, "Welcome to the fantasy world of Pipiines! The world of Swords and Magic!");




// Character creation at stats distribution section
// declartion ng name & class
String playerName = JOptionPane.showInputDialog("But first, what is your name?"); 
String[] classes = {"Warrior", "Thief", "Mage"}; 
String playerClass = (String) JOptionPane.showInputDialog(null, 
        "What are you?", 
        "Class Selection", 
        JOptionPane.QUESTION_MESSAGE, //same as before pero acts as a question
        null, 
        classes, 
        classes[0]); //warrior ang default

//initilization and decleration ng attributes and wpndmg 
 int str = 0, intelli = 0, dex = 0;
        int hp = 0; 
        String weapon = "";
        double weaponDamage = 0.0;
        String attributeMessage = "";
    
 // Stat distribution for starting class and base HP
        if (playerClass.equals("Warrior")) {
            str = 3; 
            intelli = 1; 
            dex = 1; 
            hp = 10; 
            weapon = "sword";
            weaponDamage = 0.1;
            attributeMessage = "Starting attributes for Warrior:\nStr = 3\nInt = 1\nDex = 1\nBase HP = 10\nWeapon: " + weapon;
        } else if (playerClass.equals("Thief")) {
            str = 2; 
            intelli = 1; 
            dex = 2; 
            hp = 8; 
            weapon = "dagger";
            weaponDamage = 0.2; 
            attributeMessage = "Starting attributes for Thief:\nStr = 2\nInt = 1\nDex = 2\nBase HP = 8\nWeapon: " + weapon;
        } else if (playerClass.equals("Mage")) {
            str = 1; 
            intelli = 3; 
            dex = 1;
            hp = 6;
            weapon = "staff";
            weaponDamage = 0.2;
            attributeMessage = "Starting attributes for Mage:\nStr = 1\nInt = 3\nDex = 1\nBase HP = 6\nWeapon: " + weapon;
        }

        // display lng this
        JOptionPane.showMessageDialog(null, attributeMessage + "\n\nYou have 3 free points to allocate!");

     //allocationg ng stats
        String strinput = JOptionPane.showInputDialog("Enter how many points to allocate to Strength (0-3):");
        int strpnt = Integer.parseInt(strinput);
        if (strpnt < 0 || strpnt > 3) {
            strpnt = 0; 
        }

        String intinput = JOptionPane.showInputDialog("Enter how many points to allocate to Intelligence (0-" + (3 - strpnt) + "):");
        int intpnt = Integer.parseInt(intinput);
        if (intpnt < 0 || intpnt > (3 - strpnt)) {
            intpnt = 0; 
        }

        String dexinput = JOptionPane.showInputDialog("Enter how many points to allocate to Dexterity(0-" + (3 - strpnt - intpnt) + "):");
        int dexpnt = Integer.parseInt(dexinput);
        if (dexpnt < 0 || dexpnt > (3 - strpnt - intpnt)) {
            dexpnt = 0; 
        }

        // final value after ng stats allocation
        str += strpnt;
        intelli += intpnt;
        dex += dexpnt;

       //hp calculator
        hp += str; //hp increases with str

        // finalization ng char creation and didisplay ng summary
        String finalAttributes = "Your final attributes are:\nStrength: " + str + "\nIntelligence: " + intelli + "\nDexterity: " + dex + "\nHealth Points: " + hp;
        JOptionPane.showMessageDialog(null, finalAttributes);
        
        
        //next sceneraio
      JOptionPane.showMessageDialog(null, "Welcome again to Pipipines, " + playerClass + " " + playerName + 
            "! As you venture through the world of Pipipines, you wake in a forest of Etivac. " + 
            "As you wander through the forest, you encounter a crazy druct addict!");
      
    //battle start
      JOptionPane.showMessageDialog(null, "You picked up your " + weapon + "!\n");
       String[] skills = {};
        if (playerClass.equals("Warrior")) {
            skills = new String[]{"Slash"}; 
        } else if (playerClass.equals("Thief")) {
            skills = new String[]{"Stab"};
        } else if (playerClass.equals("Mage")) {
            skills = new String[]{"Fireball"}; 
        }
        
        
        //Mobinfo
int mobhp = 10;
        JOptionPane.showMessageDialog(null, "The drug addict has " + mobhp + " HP!");
        String skillChoice = (String) JOptionPane.showInputDialog(null, 
                "Choose your skill:", 
                "Combat Skills", 
                JOptionPane.QUESTION_MESSAGE, 
                null, 
                skills, 
                skills[0]);

        //damage calculatiion
      double damageDealt = 0.0;
if (skillChoice.equals("Slash")) {
    damageDealt = weaponDamage * str; 
} else if (skillChoice.equals("Stab")) {
    damageDealt = weaponDamage * str; 
} else if (skillChoice.equals("Fireball")) {
    damageDealt = weaponDamage * intelli; 
}

       JOptionPane.showMessageDialog(null, "You used " + skillChoice + " and dealt " + damageDealt + " damage to the drug addict!");

// mob hp update
mobhp -= damageDealt; 

// mob hp check
if (mobhp > 0) {
    JOptionPane.showMessageDialog(null, "The drug addict has " + mobhp + " HP left.\nThe drug addict fled!");
} else {
    JOptionPane.showMessageDialog(null, "The drug addict has been defeated!");
}
    
  
      JOptionPane.showMessageDialog(null, "As the drug addict fled the scene, you decided to wander around and found the village of Roocab.\nYou decided to rest there.");
                   String rest_input = (String) JOptionPane.showInputDialog(null, 
                    "How long will you rest (0.1 to 100)?", 
                    "Rest Time", 
                    JOptionPane.QUESTION_MESSAGE, 
                    null, 
                    null, 
                    "0.1");
            double resttime = Double.parseDouble(rest_input);

            
            JOptionPane.showMessageDialog(null, "You have woken up from your coma after " + resttime + " years.\n"
                    + "You were never in the world of Pipipines and instead, you wake up in a wasteland in the real world.\n"
                    + "You, " + playerName + ", were never a " + playerClass + " adventurer.\n"
                    + "Now that you know this harsh reality, you decide to venture into the wasteland.");

            
            JOptionPane.showMessageDialog(null, "Fin.");
}
    }
    

