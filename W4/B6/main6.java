package B6;

class ArrayUtils {
    public static <T> void swap (T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static <T extends Comparable<T>> void sort(T[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (((Comparable<T>) array[j]).compareTo(array[j + 1]) > 0) {
                    swap(array, j, j + 1);
                }
            }
        }
    }
}

public class main6 {
    public static void main(String[] args) {
        Integer[] intArray = {5, 1, 3, 2};
        ArrayUtils.sort(intArray);
        for (Integer num : intArray) {
            System.out.print(num + " ");
        }
        System.out.println();

        String[] strArray = {"Java", "C++", "Python"};
        ArrayUtils.sort(strArray);
        for (String str : strArray) {
            System.out.print(str + " ");
        }
        String[] Student = {};
        ArrayUtils.sort(Student);
        for (String str : Student) {
            System.out.print(str + " ");
        }
    }
}
