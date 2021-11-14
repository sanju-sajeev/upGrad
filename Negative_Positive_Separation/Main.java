import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        partitionNegativeAndPositive(n, arr);
    }

    //if signs are opposite the this below function will return true, else true
    static boolean areSignsOpposite(int x, int y) {
        return ((x ^ y) < 0);
    }

    static void print(ArrayList<Integer> arr) {
        int size = arr.size();
        for(int i = 0; i < size; i++) {
            System.out.print(arr.get(i) + " ");
        }
        System.out.println("");
    }

    static void partitionNegativeAndPositive(int n, int[] arr) {
        ArrayList<Integer> sameSign = new ArrayList<>();
        ArrayList<Integer> oppSign = new ArrayList<>();

        sameSign.add(new Integer(arr[0]));

        for(int i = 1; i < n; i++) {
            if(areSignsOpposite(arr[0], arr[i])) {
                oppSign.add(new Integer(arr[i]));
            } else {
                sameSign.add(new Integer(arr[i]));
            }
        }
      
        print(sameSign);
      
        if(oppSign.size() == 0) {
            System.out.println("Array doesn't have " + ((sameSign.get(0) >> 31 == 0) ? "negative" : "positive") + " numbers");
        } else {
            print(oppSign);   
      }
    }
}