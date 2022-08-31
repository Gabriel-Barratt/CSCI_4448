import java.util.Scanner;
import java.util.Arrays;

public class Reader
{
    static String read()            //runs the other functions and prints it out
    {                               //to look nice and neat
        Scanner read = new Scanner(System.in);
        print("Enter a string to read: ");
        String user_input = read.nextLine();    //storing user input
        read.close();

        print(user_input);

        user_input = clean(user_input);         //clean function
        print(user_input);

        user_input = sort(user_input);          //sort function
        print(user_input);

        user_input = palindrome(user_input);    //palindrome function
        print(user_input);

        return user_input;
    }

    //https://www.geeksforgeeks.org/how-to-remove-all-white-spaces-from-a-string-in-java/
    static String clean(String args)
    {
        args = args.toUpperCase();      //converts everything to uppercase
        args = args.replaceAll("\\s", "");  //replaces all the spaces with nothing
        return args;
    }

    //https://www.geeksforgeeks.org/sort-a-string-in-java-2-different-ways/
    static String sort(String args)
    {
        char[] tempArray = args.toCharArray();      //creating a temp character array that uses the
        Arrays.sort(tempArray);                     //sort function and returns it as a string
        return new String (tempArray);
    }

    //https://stackoverflow.com/questions/13827654/how-can-i-get-a-char-array-in-reverse-order
    //https://www.geeksforgeeks.org/java-util-arrays-copyofrange-java/
    static String palindrome(String args)
    {                                           //creating a character array, breaking up the word,
        char[] breakup = args.toCharArray();    //reversing half of it, and splicing it together
        char[] erase = Arrays.copyOfRange(breakup, 1, breakup.length);
        char[] flip = (new StringBuilder(new String(args)).reverse().toString()).toCharArray();

        for (int i = 0; i < erase.length; i++)
        {
            flip = Arrays.copyOf(flip, flip.length +1);
            flip [flip.length - 1] = erase[i];
        }
        return new String (flip);
    }

    static void print(String args)
    {
        System.out.println(args);
    }   //used so i don't have to keep
}                                                                  //typing system.out.println