import java.util.LinkedHashSet;
import java.util.Scanner;

public class parking_lot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(", ");
        LinkedHashSet<String> set = new LinkedHashSet<>();
        while(!input[0].equals("END"))
        {
            if(input[0].equals("IN"))
            set.add(input[1]);
            else
            set.remove(input[1]);
            input = scanner.nextLine().split(", ");
        }
        if(set.isEmpty())
        System.out.println("Parking Lot is Empty");
        else
        for (String string : set)
        System.out.println(string);
        scanner.close();
    }
}
