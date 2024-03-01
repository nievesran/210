package ispalindrome;

//import java.util.Scanner;

public class Ispalindrome {

    public static void main(String[] args) {

        //finding the time before the operation is executed
        long start = System.nanoTime();
        int N = 500001;
        String word = "aba".repeat(N);

        if (Palin(word)) {
            System.out.println("The word is a palindrome");
        } else {
            System.out.println("the word is not a palindrome");

        }
        // finding the time after the operation is executed
        long end = System.nanoTime();
        float totalTime = (end - start);
        System.out.println(totalTime);

    }
    //Checking if the word is even or odd
    public static boolean isEven(String word) {
        if (word.length() % 2 == 1) {
            return true;
        }
        return false;
    }
    //Checking if the word is a palindrome by comparing the beginning and ending indexes 
    //then decrementing and incrementing each index until the middle is reached
    public static boolean Palin(String word) {
        char[] charArray = word.toCharArray();
        int R = charArray.length - 1;

        int L = 0;
        if (isEven(word)) {
            while (R > L) {
                if (charArray[R] != charArray[L]) {

                    return false;
                }
                L++;
                R--;

            }
            return true;
        }
        return false;
    }

}
