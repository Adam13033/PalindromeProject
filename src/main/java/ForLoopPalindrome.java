import java.util.ArrayList;

public class ForLoopPalindrome implements PalindromeInterface {

    public ArrayList<String> isPalindrome(String userInput) {
        // instantiating our ArrayList
        ArrayList palindromes = new ArrayList<>();
        // calling our strSplitter() method in order to split into individual words and convert to String[].
        String[] strArr = splitMethod(userInput);
        // iterate through each entry in strArr
        for (String currentWord : strArr) {
            // passes current word stored in currentWord to palindromeCypher() which will return
            // true if determining this individual word is a palindrome, or false
            // if it isn't.
            boolean palindrome = palindromeCypher(currentWord);
            // if palindrome is true, adds pal (palindrome) to our ArrayList (palindromes)
            if (palindrome) {
                palindromes.add(currentWord);
            }
        }
        return palindromes;
    }

    @Override
    public boolean palindromeCypher(String userInput) {
        // isPalindrome serves as a switch for iteration, requiring isPalindrome to return 'true' in order to continue
        // iteration. At first instsance characters don't match, iteration ceases and moves forwards to next word.
        boolean isPalindrome = true;
        // i and j serve as index positions, with i counting forwards from the start of the word
        // and j counting backwards, from the back of the word.
        // the process continues until the word is complete, or 1 letter remains. As soon as 2 words are returned
        // which don't match, it isn't possible to be a palindrome and as such doesn't waste further resources
        // moves forwards to next word which holds the potential of being a palindrome.
        for (int i = 0, j = userInput.length() - 1; i < j && isPalindrome; i++, j--) {
            System.out.println(userInput.substring(i, i + 1) + userInput.substring(j, j + 1));
            System.out.println(userInput.substring(j, j + 1) + " testing j substr output");
            // uses i and j and create substrings, comparing between both for equality
            // when equal, returns true and triggers if statement contained within isPalindrome()
            // when false, as mentioned ceases iteration and begins next
            // false is returned at the first instance of characters not matching, otherwise
            // iteration proceeds forwards until no further characters, or one remains - a palindrome!
            return userInput
                    .substring(i, i + 1)
                    .equalsIgnoreCase(userInput.substring(j, j + 1));
        }
        return isPalindrome;
    }

    public static String[] splitMethod(String userInput) {
        // splits our userInput at whitespace, isolating individual words and providing us the required array
        // this is returned to isPalindrome() method and array is used for isolating words and screening
        // for palindromes
        return userInput.split(" ");
    }
}
