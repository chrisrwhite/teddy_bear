
package teddy_bear_game;

import java.util.Scanner;

public class Teddy_bear_game {
    public static boolean teddyBearGame(int bears){
        if (bears < 42) return false;
        if (bears == 42) return true;

        
        // If n is divisible by 5, then you may give back exactly 42 bears. 
        if ((bears%5 == 0) && teddyBearGame(bears - 42)) return true;   
        
        //If n is even, then you may give back exactly n /2 bears
        if ((bears%2 == 0)  && teddyBearGame(bears / 2)) return true;
        
        //If n is divisible by 3 or 4, then you may multiply the last 
        //two digits of n and give back this many bears. By the way, 
        //the last digit of n is n%10, and the next-to-last digit is (n%100)=10. 
        if (bears%4 == 0 || bears%3 == 0) {
        // lsb
        int b = bears%10;
        
        //select second lsb and shift digits down
        int a = (bears%100)/10;   
 
        int result = a*b;
        
        return result != 0 && teddyBearGame(bears - result);

        }
        return false;
        
    }
    
    
    public static void main(String[] args) {
        
        Scanner kybd = new Scanner(System.in);
        System.out.print("Enter an integer (eg: 234): ");   
        int test_case = kybd.nextInt();


        System.out.println("Start with : " + test_case );
        boolean response = teddyBearGame(test_case);
           
        System.out.println(response);
    }
    
}
