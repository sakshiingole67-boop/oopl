import java.util.Scanner;

public class ArrayOperations {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        
        System.out.print("Array elements: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

        int sum = 0;
        int max = arr[0];
        int min = arr[0];

        
        for (int i = 0; i < n; i++) {
            sum += arr[i];

            if (arr[i] > max)
                max = arr[i];

            if (arr[i] < min)
                min = arr[i];
        }

        double average = (double) sum / n;

        
        System.out.print("\nEnter element to search: ");
        int key = sc.nextInt();
        boolean found = false;

        for (int i = 0; i < n; i++) {
            if (arr[i] == key) {
                System.out.println("Element found at position: " + (i + 1));
                found = true;
                break;
            }
        }

        if (!found)
            System.out.println("Element not found");

        
        System.out.println("Sum     = " + sum);
        System.out.println("Average = " + average);
        System.out.println("Maximum = " + max);
        System.out.println("Minimum = " + min);

        sc.close();
    }
}


