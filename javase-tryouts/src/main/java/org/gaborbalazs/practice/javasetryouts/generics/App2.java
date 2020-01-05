package org.gaborbalazs.practice.javasetryouts.generics;

public class App2 {

    public enum Type {
        STRING, INTEGER;
    }

    public static void main(String[] args) {

        System.out.println(">> main()");

        String s = method(Type.STRING);
        Integer i = App2.<Integer>method(Type.INTEGER);
        System.out.println("s: " + s);
        System.out.println("i: " + i);

        System.out.println("<< main()");
    }

    @SuppressWarnings("unchecked")
    public static <T> T method(Type type) {
        switch (type) {
        case STRING:
            return (T) new String("hello");
        case INTEGER:
            return (T) new Integer(5);
        default:
            return null;
        }
    }
}