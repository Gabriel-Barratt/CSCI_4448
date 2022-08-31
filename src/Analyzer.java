import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;

public class Analyzer
{
    static String read()
    {
        double[] lst = new double[0];
        Scanner reader = new Scanner(System.in);

        System.out.println("Enter a number: ");
        String input = reader.nextLine();
        lst = Arrays.copyOf(lst, lst.length +1);
        lst [lst.length - 1] = Double.parseDouble(input);
        System.out.println(Arrays.toString(lst));

        while(!(input.equals("")))
        {
            System.out.println("Enter a number: ");
            input = reader.nextLine();
            if(!(input.equals("")))
            {
                // makes array bigger https://stackoverflow.com/questions/13197702/resize-an-array-while-keeping-current-elements-in-java
                lst = Arrays.copyOf(lst, lst.length +1);
                lst [lst.length -1] = Double.parseDouble(input);
                System.out.println(Arrays.toString(lst));
            }
        }
        System.out.println("Median: "+ median(lst));
        System.out.println("Mean: "+ mean(lst));
        System.out.println("Mode: "+ mode(lst));
        System.out.println("Variance: "+ variance(lst));
        System.out.println("Standard Deviation: "+ standard_deviation(lst));
        System.out.println("Minimum Value: "+ min(lst));
        System.out.println("Maximum Value: "+ max(lst));
        System.out.println(max_occurrences(lst));
        reader.close();
        return input;
    }
    //source: https://www.geeksforgeeks.org/median/
    static double median(double[] lst)
    {
        Arrays.sort(lst);
        double median;

        if(lst.length % 2 == 0)
        {
            median = (lst[((lst.length)/2)] + lst[((lst.length) / 2) - 1]) / 2;
            return median;
        }
        else
        {
            median = (lst.length / 2) + 1;
            return median;
        }
    }
    static double mean(double[] lst)
    {
        Arrays.sort(lst);
        double mean;
        double total = 0;
        for(int i = 0; i < lst.length; i++)
        {
            total += lst[i];
        }
        mean = total / lst.length;
        return mean;
    }
    // https://stackoverflow.com/questions/8858327/finding-multiple-modes-in-an-array
    static ArrayList<Double> mode(double[] temp)
    {
        ArrayList<Double> mode = new ArrayList<Double>();
        double counter = 0;
        double counter_2 = 0;
        for (int i = 0; i < temp.length; i++)
        {
            counter_2 = 0;
            for (int j = 0; j < temp.length; j++)
            {
                if (temp[i] == temp[j])
                {
                    counter_2++;
                }
            }
            if (counter < counter_2 && !mode.contains(temp[i]))
            {
                counter = counter_2;
                mode.clear();
                mode.add(temp[i]);
            }
            else if(counter == counter_2 && !mode.contains(temp[i]))
            {
                mode.add(temp[i]);
            }
        }
        return mode;
    }

    //https://www.includehelp.com/java-programs/calculate-the-mean-variance-and-standard-deviation-of-real-numbers.aspx
    static double variance(double[] lst)
    {
        double variance = 0;
        double total = 0;
        double mean = 0;

        for (int i = 0; i < lst.length; i++)
        {
            total += lst[i];
        }
        mean = total / lst.length;                      // Compute sum squared differences with the mean
        for (int i = 0; i < lst.length; i++)
            variance += Math.pow((lst[i] - mean), 2);    //variance math
        return variance / lst.length;
    }

    static double standard_deviation(double[] lst)
    {
        double standard_dev = 0;
        double total = 0;
        double mean = 0;
        double square_diff = 0;
        double var = 0;

        for (int i = 0; i < lst.length; i++)
        {
            total += lst[i];
        }
        mean = total / lst.length;

        for (int i = 0; i < lst.length; i++)
        {
            square_diff += Math.pow((lst[i] - mean), 2);    //takes the power
        }
        var = square_diff / lst.length;
        standard_dev = Math.sqrt(var);           //takes the square root of the std
        return standard_dev;
    }

    static double min(double[] lst)
    {
        Arrays.sort(lst);
        return lst[0];
    }

    static double max(double[] lst)
    {
        Arrays.sort(lst);
        return lst[lst.length -1];
    }

    static double max_occurrences(double[] temp)
    {
        ArrayList<Double> mode = new ArrayList<Double>();
        double counter = 0;
        double counter_2 = 0;
        for (int i = 0; i < temp.length; i++)
        {
            counter_2 = 0;
            for (int j = 0; j < temp.length; j++)
            {
                if (temp[i] == temp[j])
                {
                    counter_2++;
                }
            }
            if (counter < counter_2 && !mode.contains(temp[i]))
            {
                counter = counter_2;
                mode.clear();
                mode.add(temp[i]);
            }
            else if(counter == counter_2 && !mode.contains(temp[i]))
            {
                mode.add(temp[i]);
            }
        }
        System.out.println("Maximum Occurrences:");
        System.out.println("Value: " + mode);
        System.out.print("Count: ");
        return counter_2;
    }
}