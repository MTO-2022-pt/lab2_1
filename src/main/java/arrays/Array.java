package arrays;

public class Array {
    public static boolean isSorted (int[] array) {
        int len = array.length;
        for (int i = 0; i < len - 1; ++i){
            if (array[i] > array[i + 1]){
                return false;
            }
        }
        return true;
    }

    public static boolean isRepeating (int[] array) {
        int len = array.length;
        for (int i = 0; i < len; ++i) {
            for (int j = 0; j < len; ++j) {
                if (array[i] == array[j]) {
                    return true;
                }
            }
        }
        return false;
    }
}