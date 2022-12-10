public class Sorting {
    /**
     * Sorts the specified array of integers using the selection
     * sort algorithm.
     */
    public static <T extends Comparable<T>> void selectionSort(T[] data) {
        int min;

        for (int index = 0; index < data.length - 1; index++) {
            min = index;
            for (int scan = index + 1; scan < data.length; scan++)
                if (data[scan].compareTo(data[min]) < 0) min = scan;

            swap(data, min, index);
            print(data);
        }
    }

    /**
     * Swaps to elements in an array. Used by various sorting algorithms.
     * <p>
     * data   the array in which the elements are swapped
     * index1 the index of the first element to be swapped.
     * index2 the index of the second element to be swapped
     */
    private static <T extends Comparable<T>> void swap(T[] data, int index1, int index2) {
        T temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;
    }

    /**
     * Sorts the specified array of objects using an insertion
     * sort algorithm.
     */
    public static <T extends Comparable<T>> void insertionSort(T[] data) {
        for (int index = 1; index < data.length; index++) {
            T key = data[index];
            int position = index;

            // shift larger values to the right
            while (position > 0 && data[position - 1].compareTo(key) > 0) {
                data[position] = data[position - 1];
                position--;
            }

            data[position] = key;
            print(data);
        }
    }

    /**
     * Sorts the specified array of objects using a bubble sort
     * algorithm.
     */
    public static <T extends Comparable<T>> void bubbleSort(T[] data) {
        int position, scan;

        for (position = data.length - 1; position >= 0; position--) {
            for (scan = 0; scan <= position - 1; scan++) {
                if (data[scan].compareTo(data[scan + 1]) > 0) swap(data, scan, scan + 1);
            }
            print(data);
        }
    }

    /**
     * Sorts the specified array of objects using the quick sort algorithm.
     */
    public static <T extends Comparable<T>> void quickSort(T[] data) {
        quickSort(data, 0, data.length - 1);
    }

    /**
     * Recursively sorts a range of objects in the specified array using the
     * quick sort algorithm.
     * min  the minimum index in the range to be sorted
     * max  the maximum index in the range to be sorted
     */
    private static <T extends Comparable<T>> void quickSort(T[] data, int min, int max) {
        if (min < max) {
            // create partitions
            int indexPartition = partition(data, min, max);

            // sort the left partition (lower values)
            quickSort(data, min, indexPartition - 1);

            // sort the right partition (higher values)
            quickSort(data, indexPartition + 1, max);

            print(data);
        }
    }

    /**
     * Used by the quick sort algorithm to find the partition.
     * min  the minimum index in the range to be sorted
     * max  the maximum index in the range to be sorted
     */
    private static <T extends Comparable<T>> int partition(T[] data, int min, int max) {
        T partitionElement;
        int left, right;
        int middle = (min + max) / 2;

        // use the middle data value as the partition element
        partitionElement = data[middle];

        // move it out of the way for now
        swap(data, middle, min);

        left = min;
        right = max;

        while (left < right) {
            // search for an element that is > the partition element
            while (left < right && data[left].compareTo(partitionElement) <= 0) left++;

            // search for an element that is < the partition element
            while (data[right].compareTo(partitionElement) > 0) right--;

            // swap the elements
            if (left < right) swap(data, left, right);
        }

        // move the partition element into place
        swap(data, min, right);

        return right;
    }

    /**
     * Sorts the specified array of objects using the merge sort
     * algorithm.
     */
    public static <T extends Comparable<T>> void mergeSort(T[] data) {
        mergeSort(data, 0, data.length - 1);
    }

    /**
     * Recursively sorts a range of objects in the specified array using the
     * merge sort algorithm.
     * min  the index of the first element
     * max  the index of the last element
     */
    private static <T extends Comparable<T>> void mergeSort(T[] data, int min, int max) {
        if (min < max) {
            int mid = (min + max) / 2;
            mergeSort(data, min, mid);
            mergeSort(data, mid + 1, max);
            merge(data, min, mid, max);

            print(data);
        }
    }

    /**
     * Merges two sorted subarrays of the specified array.
     * first the beginning index of the first subarray
     * mid the ending index fo the first subarray
     * last the ending index of the second subarray
     */
    @SuppressWarnings("unchecked")
    private static <T extends Comparable<T>> void merge(T[] data, int first, int mid, int last) {
        T[] temp = (T[]) (new Comparable[data.length]);

        int first1 = first;   // endpoints of first subarray
        int first2 = mid + 1;   // endpoints of second subarray
        int index = first1;  // next index open in temp array

        //  Copy smaller item from each subarray into temp until one
        //  of the subarrays is exhausted
        while (first1 <= mid && first2 <= last) {
            if (data[first1].compareTo(data[first2]) < 0) {
                temp[index] = data[first1];
                first1++;
            } else {
                temp[index] = data[first2];
                first2++;
            }
            index++;
        }

        //  Copy remaining elements from first subarray, if any
        while (first1 <= mid) {
            temp[index] = data[first1];
            first1++;
            index++;
        }

        //  Copy remaining elements from second subarray, if any
        while (first2 <= last) {
            temp[index] = data[first2];
            first2++;
            index++;
        }

        //  Copy merged data into original array
        for (index = first; index <= last; index++)
            data[index] = temp[index];
    }

    public static <T extends Comparable<T>> void print(T[] items) {
        int i = 0;
        while (i < items.length && items[i] != null) {
            System.out.print(items[i].toString() + " ");
            i++;
        }
        System.out.println();

    }
}
