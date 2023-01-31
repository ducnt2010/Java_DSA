package Day1;

import java.util.ArrayList;
import java.util.List;

public class MainTest {
    public static void main(String[] args) {
        int[] arr = new int[4];
        arr[0] = 5;
        arr[1] = 2;
        arr[2] = 6;
        for (int i = arr.length - 1; i > 1; i--) {
            arr[i] = arr[i - 1]; //
        }
        // set arr[1]=3
        arr[1] = 3;
        // print
        for (int i : arr) {
            System.out.println(i);
        }

        List<Integer> list = new ArrayList<>();
        list.add(1, 10);

    }
}
