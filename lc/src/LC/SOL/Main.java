package LC.SOL;

import java.util.Scanner;
import java.math.BigInteger;
public class Main {
    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //int a = in.nextInt();
        //System.out.println(a);
        System.out.println("Hello World!");
        Main main = new Main();
        System.out.println(main.add2("123", "23"));  // 146
        System.out.println(main.add2("123", "-23")); // 100

        System.out.println(main.add2("", "-23")); // -23

        System.out.println(main.add2("123", "")); // 123

        System.out.println(main.add2(null, "123")); // 123
        System.out.println(main.add2("123", null)); // 123
        System.out.println(main.add2(null, null)); // 0

    }

    // with BigInteger.
    public String add1(String s1, String s2) {
        BigInteger b1 = new BigInteger(s1);
        return b1.add(new BigInteger(s2)).toString();
    }

    // without BigInteger
    public String add2(String s1, String s2) {
        if ( s1 == null && s2 == null) return "0";
        if ( s1 == null ) return s2;
        if ( s2 == null ) return s1;
        if ( s1.length() == 0 && s2.length() == 0) return "0";
        if ( s1.length() == 0 ) return s2;
        if ( s2.length() == 0) return s1;


        int sign1 = s1.charAt(0) == '-' ? -1 : 1;
        if (sign1 == -1) s1 = s1.substring(1);
        int sign2 = s2.charAt(0) == '-' ? -1 : 1;
        if( sign2 == -1) s2 = s2.substring(1);

        if ( sign1 == sign2 ) {
            String num = addUnsigned( s1, s2);
            return ( sign1 == 1 ? "" : "-") + addUnsigned(s1, s2);
        } else {
            int cmp = compareMag(s1 , s2);
            if ( cmp == 0) return "0";
            String ret = ( cmp > 0 ) ? subtract(s1 , s2) : subtract(s2 , s1);
            return ( cmp == sign1 ? "" : "-") + ret;
        }
    }

    private String addUnsigned(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1;
        int carry = 0;
        StringBuilder b = new StringBuilder();
        while ( i >= 0 || j >= 0 ) {
            int d1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int d2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            int num = d1 + d2 + carry;
            b.append(num % 10);
            carry = num / 10;
            i--;j--;
        }
        if ( carry != 0 ) b.append(carry);
        b.reverse();
        return b.toString();
    }

    //
    private String subtract(String num1, String num2) {
        int carry = 0 ;
        int i = num1.length() - 1 , j = num2.length() - 1;
        StringBuilder b = new StringBuilder();
        while ( j >= 0 ) {
            int d1 = num1.charAt(i) - '0', d2 = num2.charAt(j) - '0';
            int num = d1 - d2 - carry;
            if ( num < 0 ) {
                carry = 1; num += 10;
            } else {
                carry = 0;
            }
            b.append(num);
            j--; i--;
        }
        while ( i >= 0 && carry > 0 ) {
            int d1 = num1.charAt(i) - '0';
            int num = d1 - carry;
            if ( num < 0 ) {
                num += 10;
                carry = 1;
            } else {
                carry = 0;
            }
            b.append(num);
            i--;
        }
        while ( i >= 0 ) {
            b.append(num1.charAt(i--));
        }
        b.reverse();
        return b.toString();
    }

    public int compareMag(String num1, String num2) {
        if ( num1.length() > num2.length()) return 1;
        if ( num1.length() < num2.length()) return -1;
        for ( int i = 0 ; i < num1.length() - 1; i++) {
            char c1 = num1.charAt(i);
            char c2 = num2.charAt(i);
            if ( c1 != c2 ) return c1 > c2 ? 1 : -1;
        }
        return 0;
    }
}