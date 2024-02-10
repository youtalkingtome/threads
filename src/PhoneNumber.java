import java.util.HashMap;
import java.util.Map;

public final class PhoneNumber {
    private  short areaCode;
    private  short prefix;
    private short lineNum;

    public PhoneNumber(int areaCode, int prefix, int lineNum) {
        this.areaCode = rangeCheck(areaCode, 999, "area code");
        this.prefix = rangeCheck(prefix, 999, "prefix");
        this.lineNum = rangeCheck(lineNum, 9999, "line num");

    }

    private static short rangeCheck(int val, int max, String arg) {
        if (val < 0 || val > max)
            throw new IllegalArgumentException(arg + val);
            return (short) val;
        }


    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof PhoneNumber))
            return false;
        PhoneNumber pn = (PhoneNumber) o;
        return pn.lineNum == lineNum && pn.prefix == prefix && pn.areaCode == areaCode;
    }

    public static void main(String[] args) {
        Map<PhoneNumber, String > m=new HashMap<>();
        PhoneNumber phNo1=new PhoneNumber(707, 856, 4134);
        PhoneNumber phNo2=new PhoneNumber(707, 856, 4134);
        String vikas = m.put(phNo1, "Vikas");
        System.out.println(m.get(phNo2));

    }
}

