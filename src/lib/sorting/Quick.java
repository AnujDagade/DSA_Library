package lib.sorting;

public record Quick<T extends Comparable<T>>(T[] array) implements Sortable {
    private int partition(int low, int high) {
        T pivot = array[high];
        int i = low -1;

        for(int j=low; j<high; j++) {
            if(array[j].compareTo(pivot) < 0) {
                i++;
                T temp = array[j];
                array[j] = array[i];
                array[i] = temp;
            }
        }
        i++;
        T temp = array[high];
        array[high] = array[i];
        array[i] = temp;

        return i;
    }

    private void quickSort(int low, int high) {
        if(low < high) {
            int pivot = partition(low, high);
            quickSort(low, pivot - 1);
            quickSort(pivot + 1, high);
        }
    }

    public void sort() {
        quickSort(0, array.length - 1);
    }
}
