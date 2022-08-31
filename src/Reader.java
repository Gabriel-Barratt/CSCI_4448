import java.util.Scanner;
import java.util.Arrays;

public class Reader
{
    static String read()
    {
        Scanner read = new Scanner(System.in);
        print("Enter a string to read: ");
        String user_input = read.nextLine();
        read.close();

        print(user_input);

        user_input = clean(user_input);
        print(user_input);

        user_input = sort(user_input);
        print(user_input);

        user_input = palindrome(user_input);
        print(user_input);

        return user_input;
    }

    //https://www.geeksforgeeks.org/how-to-remove-all-white-spaces-from-a-string-in-java/
    static String clean(String args)
    {
        args = args.toUpperCase();
        args = args.replaceAll("\\s", "");
        return args;
    }

    //https://www.geeksforgeeks.org/sort-a-string-in-java-2-different-ways/
    static String sort(String args)
    {
        char tempArray[] = args.toCharArray();
        Arrays.sort(tempArray);
        return new String (tempArray);
    }

    //https://stackoverflow.com/questions/13827654/how-can-i-get-a-char-array-in-reverse-order
    //https://www.geeksforgeeks.org/java-util-arrays-copyofrange-java/
    static String palindrome(String args)
    {
        char[] breakup = args.toCharArray();
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
    }
}