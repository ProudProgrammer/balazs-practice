package hu.gaborbalazs.classloader;

public class App {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {

        System.out.println(">> main()");
        
        @SuppressWarnings("unchecked")
        Class<StringBuilder> clazz = (Class<StringBuilder>) Class.forName("java.lang.StringBuilder");
        StringBuilder sb = clazz.newInstance();
        sb.append("hello");
        System.out.println(sb.toString());

        System.out.println("<< main()");
    }
}
