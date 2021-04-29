import java.util.*;

/**
 * Write your comments here
 */
public class Anagrams {
    //Implement this class
    List<String> dict; // double check spec

    private List<String> orderedDictionary;
    private Map<String, LetterInventory> inventoryMap;

//    public Anagrams(List<String> dictionary) {
////        Anagrams anny = new Anagrams(dictionary);
//        dict = dictionary;
//    }

    public Anagrams(List<String> dictionary) {
        orderedDictionary = new LinkedList<>(dictionary);
        inventoryMap = new HashMap<>();
        for (String s : dictionary) {
            inventoryMap.put(s, new LetterInventory(s));
            // should only happen once in the constructor
            //Thus using map is required
        }
    }

    public void print(String text, int max) {
        // throw IllegalArgumentException

        // recursion :
        // explore into possibility and
        // take letter from dict
        // check

        // have method that calls itself
        // use global variable if method is overloaded
        // go over lecturs that cover recursive unit
    }

    public void diceFake() {
        // this method checks the probability of comb for 3 outcome
    }
}
