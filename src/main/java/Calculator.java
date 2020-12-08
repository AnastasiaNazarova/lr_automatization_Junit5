public class Calculator {
    public String Add(String  x, String  y) {
        int i1 = Integer.parseInt(x,2);
        int i2 = Integer.parseInt(y,2);
        return Integer.toBinaryString(i1 + i2);
    }

    public  String Sub(String  x, String  y)
    {
        int i1 = Integer.parseInt(x,2);
        int i2 = Integer.parseInt(y,2);
        return Integer.toBinaryString(i1 - i2);
    }

    public String Divide(String  x, String  y) {
        int i1 = Integer.parseInt(x,2);
        int i2 = Integer.parseInt(y,2);
        if (i2 == 0) {
            throw new IllegalArgumentException("Divider must not be 0");
        }
        return Integer.toBinaryString(i1 / i2);
    }

    public String Multiple(String  x, String  y) {
        int i1 = Integer.parseInt(x,2);
        int i2 = Integer.parseInt(y,2);
        return Integer.toBinaryString(i1 * i2);
    }

    public String Xor(String  x, String  y) {
        int i1 = Integer.parseInt(x,2);
        int i2 = Integer.parseInt(y,2);
        return Integer.toBinaryString(i1 ^ i2);
    }

}
