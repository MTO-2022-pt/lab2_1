/**
 *
 */
package edu.iis.mto.bsearch;

/**
 * Klasa implementująca wyszukiwanie binarne
 *
 */
public class BinarySearch {

    private BinarySearch() {}

    /**
     * Metoda realizujaca wyszukiwanie binarne
     *
     * @param key
     *            - szukany obiekt
     * @param seq
     *            - rosnaco uporzadkowana niepusta sekwencja
     * @return obiekt rezultatu o polach: - found (true jezeli znaleziony) - position (jezeli znaleziony - pozycja w
     *         sekwencji, jezeli nie znaleziony -1)
     */
    public static SearchResult search(int key, int[] seq) throws IllegalArgumentException{
        if(seq.length <= 0){
            throw new IllegalArgumentException("Array is empty!");
        }else if(!isArraySorted(seq)){
            throw new IllegalArgumentException("Array is not sorted!");
        }else if(hasArrayDuplicates(seq)){
            throw new IllegalArgumentException("Array has duplicates!");
        }

        int start = 0;
        int end = seq.length - 1;
        int center;
        SearchResult result = new SearchResult();

        while (start <= end) {
            center = (start + end) / 2;
            if (seq[center] == key) {
                result.setPosition(center);
                break;
            } else {
                if (seq[center] < key) {
                    start = center + 1;
                } else {
                    end = center - 1;
                }
            }
        }
        return result;
    }

    public static boolean isArraySorted(int[] array){
        for(int i = 0 ; i < array.length - 1; i++){
            if(array[i] > array[i+1]){
                return false;
            }
        }
        return true;
    }

    public static boolean hasArrayDuplicates(int[] array){
        for(int i = 0; i < array.length; i++){
            for(int j = i+1; j < array.length; j++){
                if(array[j] == array[i]){
                    return true;
                }
            }
        }
        return false;
    }



}
