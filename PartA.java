import java.util.*;

public class Main 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();
        System.out.println("Enter integers (type 'done' to finish):");
        while (true) {
            String input = sc.next();
            if (input.equalsIgnoreCase("done")) break;
            Integer num = Integer.parseInt(input);
            numbers.add(num);
        }
        int sum = 0;
        for (Integer n : numbers) sum += n;
        System.out.println("Sum of integers: " + sum);
    }
}
