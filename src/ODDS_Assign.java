
import java.util.Scanner;

public class ODDS_Assign {

    static String[] functionA(int number) {
        //เปลี่ยนเลขเป็น ODD EVEN 
        int tens = number / 10;
        int digit = number % 10;
        String str_ten = "";
        String str_digit = "";
        String str_number = "";

        if (tens != 0 && tens % 2 == 1) {
            str_ten = str_ten + ("Odd" + tens);
        }
        if (tens != 0 && tens % 2 == 0) {
            str_ten = str_ten + ("Even" + tens);
        }
        if (digit % 2 == 1) {
            str_digit = str_digit + ("Odd" + digit);
        } else {
            str_digit = str_digit + ("Even" + digit);
        }
        str_number = str_ten + str_digit;
        System.out.printf("FunctionA = %s\n", str_number);
        return new String[]{str_ten, str_digit};
    }

    static String[] functionB(String str_tens, String str_digit) {
        //reverse ODD EVEN 
        String text = "";
        String text_ten = "";
        String text_digit = "";
        if (str_tens.isEmpty()) {
            text_ten= "";
        } else if (str_tens.charAt(0) == 'O') {
            text_ten = "DDO" + str_tens.charAt(3);
        } else if (str_tens.charAt(0) == 'E') {
            text_ten = "NEVE" + str_tens.charAt(4);
        }
        if (str_digit.charAt(0) == 'O') {
            text_digit = "DDO" + str_digit.charAt(3);
        } else if (str_digit.charAt(0) == 'E') {
            text_digit = "NEVE" + str_digit.charAt(4);
        }
        text = text_ten + text_digit;
        System.out.println("FunctionB = " + text);
        return new String[]{text_ten, text_digit};
    }

    static String[] functionC(String text_ten, String text_digit) {
        //แปลงเป็น ASCII
        String ascii = "";
        String ascii_ten = "";
        String ascii_digit = "";
        if (text_ten.isEmpty()) {
            ascii_ten = "";
        } else {
            for (int i = 0; i < text_ten.length() - 1; i++) {
                ascii_ten = ascii_ten + (int) text_ten.charAt(i);
            }
            ascii_ten = ascii_ten + text_ten.charAt(text_ten.length() - 1);//เลขASCII +ด้วยเลขท้ายสุด
        }
        for (int i = 0; i < text_digit.length() - 1; i++) {
            ascii_digit = ascii_digit + (int) text_digit.charAt(i);
        }
        ascii_digit = ascii_digit + text_digit.charAt(text_digit.length() - 1);//เลขASCII +ด้วยเลขท้ายสุด
        ascii = ascii_ten + ascii_digit;
        System.out.println("FunctionC = " + ascii);
        return new String[]{ascii_ten, ascii_digit};
    }

    static String[] functionD(String ascii_ten, String ascii_digit) {
        //แปลง ASCII กลับเป็น Reverse ODD Even
        String text = "";
        String text_ten = "";
        String text_digit = "";
        if (ascii_ten.isEmpty()) {
            text_ten = "";
        } else {
            for (int i = 0; i < ascii_ten.length() - 1; i += 2) {
                String split_ten = ascii_ten.substring(i, i + 2);//แบ่ง2ตัว
                int integer_spilt = Integer.valueOf(split_ten);//แปลงเป็น int
                char casting_char = (char) integer_spilt;//cast เป็น char 
                text_ten = text_ten + casting_char;
            }
            text_ten = text_ten + ascii_ten.charAt(ascii_ten.length() - 1);
        }
        for (int i = 0; i < ascii_digit.length() - 1; i += 2) {
            String split_digit = ascii_digit.substring(i, i + 2);
            int integer_spilt = Integer.parseInt(split_digit);
            char casting_char = (char) integer_spilt;
            text_digit = text_digit + casting_char;
        }
        text_digit = text_digit + ascii_digit.charAt(ascii_digit.length() - 1);
        text = text_ten + text_digit;
        System.out.println("FunctionD = " + text);
        return new String[]{text_ten, text_digit};
    }

    static String[] functionE(String text_ten, String text_digit) {
        String str_ten = "";
        String str_digit = "";
        String str_number = "";
        if(text_ten.isEmpty()){
            str_ten = "" ;
        }else if (text_ten.charAt(0) == 'D') {
            str_ten = "Odd" + text_ten.charAt(3);
        } else if (text_ten.charAt(0) == 'N') {
            str_ten = "Even" + text_ten.charAt(4);
        }
        if (text_digit.charAt(0) == 'D') {
            str_digit = "Odd" + text_digit.charAt(3);
        } else if (text_digit.charAt(0) == 'N') {
            str_digit = "Even" + text_digit.charAt(4);
        }
        str_number = str_ten + str_digit ;
        System.out.println("FunctionE = " + str_number);
        return new String[]{str_ten,str_digit};
        
    }
    static int functionF(String str_ten, String str_digit){
        String str = str_ten + str_digit ;        
        String non_alphabet = str.replaceAll("\\D+","");
        int number = Integer.parseInt(non_alphabet);
        System.out.println("FunctionF = " + number);
        return number ;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Please insert number between 1 to 20");
        int number = in.nextInt();
        while (number <= 0 || number > 20) {
            System.out.println("Number is out of range");
            System.out.println("Please enter new number");
            number = in.nextInt();
        }
        String[] ans_A = functionA(number);
        String[] ans_B = functionB(ans_A[0], ans_A[1]);
        String[] ans_C = functionC(ans_B[0], ans_B[1]);
        String[] ans_D = functionD(ans_C[0], ans_C[1]);
        String[] ans_E = functionE(ans_D[0], ans_D[1]);
        int ans_F = functionF(ans_E[0], ans_E[1]);
    }
}
