package hu.gaborbalazs.lambda;

import java.util.ArrayList;
import java.util.List;

public class LambdaException {

    public static void main(String[] args) {

        System.out.println(">> start");

        List<String> strings = new ArrayList<>();
        strings.add("one");
        strings.add("two");
        strings.add("three");
        strings.add("four");
        strings.add("five");
        
        try {
            strings.forEach(string -> {
                try {
                    System.out.println("Element is " + lengthChecker(string));
                } catch (Exception exception) {
                    throw new RuntimeException(exception.getMessage());
                }
            });
        } catch (Exception e) {
            System.out.println("Error occured: " + e.getMessage());
        }
        
        System.out.println(">> end");
    }
    
    public static String lengthChecker(String s) throws Exception {
        if (s.length() < 4) {
            return s;
        } else {
            throw new Exception("Given paramater is too long: " + s);
        }
    }

}
