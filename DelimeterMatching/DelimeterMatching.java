package delimetermatching;

import java.util.Scanner;

public class DelimeterMatching {

    public static void main(String[] args) {

        //Prompt user to enter the how many delimeters they plan to enter.
        Scanner scan = new Scanner(System.in);
        System.out.println("How many total delimeters are you entering?");
        int n = scan.nextInt();

        //Prompt the user to populate the stack
        System.out.println("Please enter your delimeters: "
        + "\nNote- Please enter all your delimeters without any spaces" );
        String s = scan.next();

        long start = System.currentTimeMillis();
        
        //method call
        DelimeterMatch(n, s);
        
        long end = System.currentTimeMillis();
        float totalTime = (end - start);
        System.out.println("This operation took " + totalTime + " milliseconds");

    } //end main

    public static void DelimeterMatch(int n, String s) {

        Array stack = new Array(n); //create stack object

        //check string length
        if (s.length() > n) {

            System.out.println("Potential stack overflow");
            return;

        } else if (s.length() < n) {

            System.out.println("Stack is not fully populated");
            return;

        } //end for

        //create array for string
        char[] array = new char[s.length()];

        //iterate through string to convert it to an array
        for (int i = 0; i < s.length(); i++) {

            array[i] = s.charAt(i);

            //makes sure only (){}[] are entered 
            if (array[i] == '(' || array[i] == '[' || array[i] == '{' || array[i] == ')'
                    || array[i] == ']' || array[i] == '}') {
            } else {

                System.out.println("Invalid character. Computer will self destruct in 10 seconds.");
                return;
            } //end else

        } // end for

        // the following is a "foreach" loop
        // the syntax is as follows: for (type variableName : Object to iterate through)
        // this allows us to iterate through the user inputted string, which is then converted to an array
        // the array is then put into the stack 
        for (char x : array) {

            if (x == '(' || x == '{' || x == '[') {

                stack.push(x);

            } else if (x == ')' || x == '}' || x == ']') {

                if (stack.isEmpty()) {
                    System.out.println("Does not match -- STACK UNDERFLOW AHHHHHH");
                    return;
                }

                char r = stack.pop();

                switch (r) { //switch to compare closed bracked with popped open bracket
                    case '(': {

                        if (x != ')') {
                            System.out.println("Does not match");
                            return;
                        } //end if
                        break;
                    } //end case 1

                    case '{': {

                        if (x != '}') {
                            System.out.println("Does not match");
                            return;
                        } //end if
                        break;
                    } //end case 2

                    case '[': {

                        if (x != ']') {
                            System.out.println("Does not match");
                            return;
                        } // end if
                        break;
                    } //end case 3

                } //end switch

            } //end else if

        } //end foreach

        if (!stack.isEmpty()) { //if there are still items in the stack, it does not match

            System.out.println("Does not match");

        } else { //brackets all match

            System.out.println("Matches");

        } // end if

    } // end DelimeterMatch method

} //end class

