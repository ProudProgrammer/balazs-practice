package hu.gaborbalazs.cyberdojo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Write a program to generate all potential 
 * anagrams of an input string.
 *
 * For example, the potential anagrams of "biro" are
 * 
 * biro bior brio broi boir bori
 * ibro ibor irbo irob iobr iorb
 * rbio rboi ribo riob roib robi
 * obir obri oibr oirb orbi orib
 *
 */

public class Anagrams {

    public static void main(String[] args) {

        Anagrams anagrams = new Anagrams();
        List<String> anagramsList = anagrams.getAnagrams("hgbiro");
        System.out.println(anagramsList);
        System.out.println(anagramsList.size());
    }
    
    public List<String> getAnagrams(String input) {
        if (input == null || input.length() == 0) {
            return Collections.emptyList();
        } else if (input.length() == 1) {
            return Arrays.asList(input);
        } else if (input.length() > 9) {
            throw new IllegalArgumentException("Letters element number should be below 10");
        }
        return process(Arrays.asList(input.split("")));
    }

    private List<String> process(List<String> letters) {
        if (letters.size() == 2) {
            return Arrays.asList(letters.get(0) + letters.get(1), letters.get(1) + letters.get(0));
        } else {
            String head;
            List<String> tail;
            List<String> result = new ArrayList<>();
            for (int i = 0; i < letters.size(); i++) {
                head = letters.get(i);
                tail = new ArrayList<>(letters);
                tail.remove(i);
                tail = process(tail);
                for (String s : tail) {
                    result.add(head + s);
                }
            }
            return result;
        }
    }
    
}
