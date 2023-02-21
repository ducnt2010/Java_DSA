package Day8;


import java.util.ArrayList;
import java.util.List;

public class SpaceComplexity {
    public static void main(String[] args) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int[] array = new int[1024 * 1024 * 25];  //100MB
            // 1 int -> 4b
            // 1024 -> 4Kb
            // 1024kb 4M
            // *25 ->100MB
            list.add(array);
        }
    }
}
