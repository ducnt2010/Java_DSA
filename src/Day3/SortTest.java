package Day3;

import java.util.*;

public class SortTest {
    public static void main(String[] args) {
        int[] arr = {5, 3, 2, 7, 8, 1, 2};
//        System.out.println(Arrays.toString(arr));
//        selectionSort(arr);
//        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        String[] words = {
                "Tai",
                "Anh",
                "Toan",
                "Dung"
        };
        Arrays.sort(words);
        System.out.println(Arrays.toString(words));

        Student[] students = {
                new Student(10, "Anh"),
                new Student(2, "Dao"),
                new Student(4, "Hoa")
        };
        Arrays.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.name.compareTo(o2.name);
            }
        });
        System.out.println(Arrays.toString(students));

        System.out.println("List student");
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(10, "Anh"));
        studentList.add(new Student(15, "Bac"));
        studentList.add(new Student(9, "Nam"));
        studentList.add(new Student(18, "Mai"));
        studentList.add(new Student(12, "Hi"));

        Collections.sort(studentList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.name.compareTo(o2.name);
            }
        });
        System.out.println(studentList.toString());
    }

    private static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean isSwapped = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    //swap i va j
                    swap(arr, j, j + 1);
                    isSwapped = true;
                }
            }
            System.out.print(i + " : ");
            System.out.println(Arrays.toString(arr));
            if (!isSwapped) {
                break;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int keyNumber = arr[i];
            int j = i - 1; // vị trí bắt đầu duyệt của mảng phía bên trái
            while (j >= 0 && arr[j] > keyNumber) {
                arr[j + 1] = arr[j];  // dịch sang phải để chèn
                j--;
            }            // tai j, thi arr[j] <= keyNumber
            arr[j + 1] = keyNumber;

            System.out.print(i + " : ");
            System.out.println(Arrays.toString(arr));
        }
    }

    private static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
            System.out.print(i + " : ");
            System.out.println(Arrays.toString(arr));
        }
    }
}
