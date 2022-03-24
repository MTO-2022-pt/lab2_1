package arrays;

public class Array {

    public static boolean isSorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static boolean isDuplucated(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i = 1; j < array.length; j++) {
                if (array[i] == array [j])
                    return true;
            }
        }
        return false;
    }
}
