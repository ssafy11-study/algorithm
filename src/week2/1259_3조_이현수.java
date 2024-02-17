package submit;

import java.util.Scanner;
public class B1259 {
    public static void main(String[] args) {
        String s = "";
        String mystr = "";
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
            s = scan.next();
            mystr = "";
            if(s.charAt(0) != '0') {
                for(int i = s.length()-1; i >= 0; i--){
                    mystr = mystr + s.charAt(i);
                }
                if(s.equals(mystr)) {
                    System.out.println("yes");
                }
                else {
                    System.out.println("no");
                }
            }
        }
    }
}