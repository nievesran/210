package addone;

import java.util.Arrays;
import java.util.Scanner;

public class AddOne {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);//scanner
        int q; //int for users choice on what to do
        int[] digits; //digits array to output
        System.out.println("What would you like to do? ");
        System.out.println("[0] for time test or [1] to add your own values:");
        q = scan.nextInt();

        switch (q) { //switch to do what the users needs.
            case 0: {
                System.out.println("What size array would you like?");
                int n = scan.nextInt();
                int[] a = new int[n];
                for (int i = 0; i < n; ++i) {
                    a[i] = 9;
                } //end for

                long start = System.currentTimeMillis();
                //method call
                digits = TwoSum(a, n);
                //output users array +1
                System.out.println("Your array + 1 = " + Arrays.toString(digits));
                // finding the time after the operation is executed
                long end = System.currentTimeMillis();
                float totalTime = (end - start);
                System.out.println("This operation took " + totalTime + " milliseconds");
                break;
            }
            case 1: {
                // User input arrays
                System.out.println("What would you like your array size to be?");
                int n = scan.nextInt();
                int[] initialize = new int[n]; //initial array
                for (int j = 0; j < n; j++) { //iterate through array to populate it with users input

                    System.out.println("Enter the " + j + " index value");
                    int l = scan.nextInt(); // take user value
                    initialize[j] = l; //assign it to array index

                } // end for
                long start = System.currentTimeMillis();
                //method call
                digits = TwoSum(initialize, n);
                //output users array +1
                System.out.println("Your array + 1 = " + Arrays.toString(digits));
                // finding the time after the operation is executed
                long end = System.currentTimeMillis();
                float totalTime = (end - start);
                System.out.println("This operation took " + totalTime + " milliseconds");
                break;
            }
            default:
                System.out.println("Please select a valid value");
                break;
        } //end switch

    } //end main

    //method to add one to users array
    public static int[] TwoSum(int[] arr, int key) {

        int[] value = new int[key + 1];//return value 
        System.out.println("Your array is " + Arrays.toString(arr)); //print test

        int i; //index

        if (arr[arr.length - 1] == 9) { //Check if last value is 9.

            if (arr.length == 1) { //check if array is one digit, if so create new array  
                //I was having an issue with only a value of 9 becoming 0,0 for some reason, this is what i came up with

                int[] arr2 = new int[2]; // Create a new array with two digits
                arr2[0] = 1;
                arr2[1] = 0;
                value = arr2;

            } else { //If array is more than one digit and last index is 9, iterate through

                for (i = arr.length - 1; i > 0; i--) {

                    if (arr[i] > 8) { //checks if other digits are 9, makes them zero then adds one to previous index

                        arr[i] = 0;
                        int p = arr[i - 1];
                        p = p + 1;
                        arr[i - 1] = p;

                        if (arr[0] > 9) { //if first index is 9, creates new array with +1 to users inputted length

                            int[] arr2 = new int[key + 1];
                            arr2[0] = 1;
                            arr2[1] = 0;
                            value = arr2;

                        } else {

                            value = arr;

                        } //end else

                    } //end if

                } //end for

            } //end else

        } else { // doesnt end in 9- add 1 to last index 

            i = arr[arr.length - 1];
            i = i + 1;
            arr[arr.length - 1] = i;
            value = arr;

        } //end else

        return value;

    } //end TwoSum method

} //end class
