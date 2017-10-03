package hu.gaborbalazs.classloader;

public class App {

    public static void main(String[] args)
            throws ClassNotFoundException, InstantiationException, IllegalAccessException {

        System.out.println(">> main()");

        @SuppressWarnings("unchecked")
        Class<StringBuilder> clazz = (Class<StringBuilder>) Class.forName("java.lang.StringBuilder");
        StringBuilder sb1 = clazz.newInstance();
        sb1.append("hello");
        System.out.println(sb1.toString());

        StringBuilder sb2 = StringBuilder.class.cast(Class.forName("java.lang.StringBuilder").newInstance());
        sb2.append("hello");
        System.out.println(sb2.toString());

        StringBuffer sb3 = new StringBuffer("hello");
        StringBuffer sb4 = App.clone(sb3, StringBuffer.class);
        sb4.append(" world");
        System.out.println(sb3 == sb4);
        System.out.println(sb4.toString());

        System.out.println("<< main()");
    }

    public static <T> T clone(T t, Class<T> clazz)
            throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        T cloned = clazz.cast(Class.forName(t.getClass().getName()).newInstance());
        // TODO clone
        return cloned;
    }
}
