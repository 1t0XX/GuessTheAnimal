import java.lang.reflect.Method;

class MethodFinder {


    public static String findMethod(String methodName, String[] classNames) throws ClassNotFoundException {
        String str = "";

        for (String s : classNames) {
            Class clazz = Class.forName(s);
            Method[] method = clazz.getMethods();


            for (Method m : method) {

                String name = m.getName();

                if (methodName.equals(name)) {
                    str = s;

                }
            }
        }
        return str;

    }
}