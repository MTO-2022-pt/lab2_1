package edu.iis.mto.bsearch;

import arrays.Array;

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
    public static SearchResult search(int key, int[] seq) throws IllegalAccessException
    {
        if (seq.length == 0) {
            throw new IllegalArgumentException("Tablica wejściowa musi zawierać przynajmniej jeden element!");
        } else if (!Array.isSorted(seq)) {
            throw new IllegalArgumentException("Tablica nie jest posortowana!");
        } else if (Array.isRepeating(seq)) {
            throw new IllegalArgumentException("Tablica zawiera powtarzającą się wartość!");
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

}
