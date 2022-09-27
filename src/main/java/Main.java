import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        // instantiating new Scanner object to obtain user input
        Scanner input = new Scanner(System.in);
        // prompting user to provide input
        System.out.println("Wondering how many words in your sentence are a palindrome? Try it out!");
        // userInput is initialised with the values entered by the user
        String userInput = input.nextLine();
        // informing user of multiple method choices, as well as which means of input are accepted, and what happens in
        // the event of incorrect, or no input.
        System.out.println("There are a few ways we can do this. Select 1, 2 or 3.\n Alternate or no input defaults to 3");
        // capturing user choice
        String userMethod = input.nextLine();
        // screening user input and providing specified methods as appropriate to user selection
        if(userMethod.equalsIgnoreCase("1")) {
            // instantiating new StringBuilder method, in order to obtain isPalindrome(), which takes in a string and
            // provides an ArrayList of palindromes once methods have been seen through
            PalindromeInterface strBuildPal = new StringBuilderPalindrome();
            // presenting the ArrayList to the user
            System.out.println(strBuildPal.palindromeCypher(userInput));
            // screening for user input option 2
        } else if (userMethod.equalsIgnoreCase("2")) {
            // instantiating WhileLoop object, in order to obtain isPalindrome() method, taking in a string and returning
            // an ArrayList for display.
            WhileLoopPalindrome whilePal = new WhileLoopPalindrome();
            System.out.println(whilePal.isPalindrome(userInput));
        } else {
            // this is effectively our 'fall through', when user selects 3 they get their appropriate selection
            // due to not screening for '3', however if user doesn't provide any input will fall-through to here
            // instantiating ForLoopPalindrome object and utilising isPalindrome()
            ForLoopPalindrome forPal = new ForLoopPalindrome();
            System.out.println(forPal.isPalindrome(userInput));;
        }

    }
}
