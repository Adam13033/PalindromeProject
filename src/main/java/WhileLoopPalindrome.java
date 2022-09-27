import java.util.ArrayList;

public class WhileLoopPalindrome implements PalindromeInterface {
    public boolean palindromeCypher(String userInput) {
        // Representing index positions, where start counts forwards from the start
        // end counts backwards from the end
        int start = 0;
        int end = userInput.length() - 1;

        // Continue iterating until even
        while (end > start) {
            // iterates through current word up until it finds values which don't match
            // at which point, it isn't possible to be a palindrome
            // more efficient than screening exclusively for equality, considering we can figure it out faster
            if (userInput.charAt(start++) != userInput.charAt(end--)) {
                System.out.println(userInput.charAt(start++) + userInput.charAt(end--));
                return false;
            }
        }
        // when true, this is fed back to isPalindrome() method, which utilises the true valuation
        // as a trigger for conditional statement of 'if palindrome, add to ArrayList'
        return true;
    }

    // Function to return all Palindrome string
    public ArrayList<String> isPalindrome(String userInput) {
        // instantiating a new ArrayList (referred to as ArrayList to avoid confusion here onwards)
        ArrayList<String> palindromes = new ArrayList<String>();
        // invoke strSplitter() which is simply a method to .split(" ") our string at whitespace
        // forming a String[] array of individual words to screen
        String[] strArr = splitMethod(userInput);
        // i indicates index, serving as our point of iteration. See below;
        int i = 0;
        // while i is less than our entries to strArr (index positions), continue looping.
        while (i < strArr.length) {
            // palindromeCypher() returns a boolean, conditional statement is specifying if
            // palindromeCypher() returns true, then the word is a palindrome
            // in which case, .add() to our ArrayList
            if (palindromeCypher(strArr[i])) {
                palindromes.add(strArr[i]);
            }
            // increment our index as a means of breaking out of while loop when i is equal to strArray.length.
            i++;
        }
        // returns out palindromes, which is received in our main method contained within system.out.println()
        // in order to present the recorded palindromes.
        return palindromes;
    }

    public  String[] splitMethod(String userInput) {
        // splits our userInput at whitespace, isolating individual words and providing us the required array
        // this is returned to isPalindrome() method and array is used for isolating words and screening
        // for palindromes
        return userInput.split(" ");
    }
}
