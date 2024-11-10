package lib.sorting;

public record Bubble<T extends Comparable<T>>(T[] array) implements Sortable {


    public void sort() {

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    T temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }


}
