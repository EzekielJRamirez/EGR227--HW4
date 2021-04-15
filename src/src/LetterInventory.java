/**
 * Write your comments here
 */
public class LetterInventory {
    //Implement this class
    public static final int ALPHABET = 26;
    // basic array syntax
    int[] inventory;

    /* constructors */

    /**
     * constructs an empty inventory--all counts are zero
     */
    public LetterInventory() {
        inventory = new int[ALPHABET];
    }

    /**
     * constructs an inventory of alphabetic leters in data. uppercase and lowercase
     * letters should be treated as same. all non-alphabetic characters should be
     * ignored
     */
    public LetterInventory(String data) {
        inventory = new int[ALPHABET];
        data = data.toUpperCase();
        // for every alphabetic letter in data...
        for (int i = 0; i < data.length(); i++) {
            // A: 65 C: 67
            // A - A = 0;
            // C - A = 2;
            if (data.charAt(i) - 'A' < 26 && data.charAt(i) - 'A' >= 0) {
                inventory[data.charAt(i) - 'A']++;
            }
        }
    }

    /* public methods */

    /**
     * @param letter
     * @return
     */
    public int get(char letter) {
        letter = Character.toLowerCase(letter);
        if(!Character.isLetter(letter)) {
            throw new IllegalArgumentException("This is not a letter");
        }

        return inventory[letter - 'a']; // works when letter passed in is capital
    }

    /**
     * @param letter
     * @param value
     */
    public void set(char letter, int value) {
        // should throw an illegal argument exception
        letter = Character.toLowerCase(letter);
        if(!Character.isLetter(letter)) {
            throw new IllegalArgumentException("This is not a letter");
        }

        inventory[letter - 'a'] = value;
    }

    /**
     * @return
     */
    public int size() {
        return toString().length() - 2;
    }

    /**
     * @return
     */
    public boolean isEmpty() {
        // size updates because it takes info about the extended string form of inventory
        return size() < 1;
    }

    /**
     * @return
     */
    //TODO try to get rid of the nested loop--Tutor says it looks good
    public String toString() {
        String ret = "[";
        // for each letter print its character the amount of times the inventory
        for (int i = 0; i < inventory.length; i++) {
            for (int j = inventory[i]; j > 0; j--) {
                ret += (char) (97 + i);
                // 97 in char corresponds to 'a'
                // as i increments from the outer loop
                // it adds into 97 and gets the next letter
            }
        }
        // pizza
        // [aipzz]
        ret += "]";
        return ret;
    }

    public LetterInventory add(LetterInventory other) {
        // for every letter index in new inventory add this and other inventory
        LetterInventory Combo = new LetterInventory(); // am I calling the first constructor
        for (int i = 0; i < Combo.inventory.length; i++) {
            Combo.inventory[i] = this.inventory[i] + other.inventory[i];
        }
//        int[] Combo.inventory[] = new int[ALPHABET];
        return Combo;
    }

    public LetterInventory subtract(LetterInventory other) {
        // for every letter index in new inventory add this and other inventory
        LetterInventory Combo = new LetterInventory(); // am I calling the first constructor
        for (int i = 0; i < Combo.inventory.length; i++) {
            Combo.inventory[i] = this.inventory[i] - other.inventory[i];
            if (Combo.inventory[i] < 0) {
                return null;
            }
        }
//        int[] Combo.inventory[] = new int[ALPHABET];
        return Combo;
    }

    public double getLetterPercentage(char letter) {
        Character.toLowerCase(letter);
        if(!Character.isLetter(letter)) {
            throw new IllegalArgumentException("This is not a letter");
        }

        // if there are no letters in inventory you should return 0
        // I could try to return use last line in this method to just return 0
        if (size() == 0) {
            return 0;
        }

        return get(letter) / (double) size();
    }
}
