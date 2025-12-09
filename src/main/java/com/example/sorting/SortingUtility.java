package com.example.sorting;

public class SortingUtility {


    public static <T extends Comparable<T>> void gnomeSort(T[] a) {
        /**
         * Gnome Sort Algorithm
         *
         * Gnome Sort works by comparing adjacent elements and moving backwards
         * when an element is smaller than its predecessor, similar to how a
         * garden gnome sorts flower pots by moving them one at a time.
         *
         * Time Complexity: O(n²) worst case, O(n) best case
         * Space Complexity: O(1)
         *
         * @param a the array to be sorted
         * @param <T> the type of elements, must be Comparable
         */

        // Initialize position to start of array
        int pos = 0;

        // Continue until we've processed the entire array
        while (pos < a.length) {
            // If at the beginning OR current element is in correct order
            if (pos == 0 || a[pos].compareTo(a[pos - 1]) >= 0) {
                // Move forward to check next element
                pos = pos + 1;
            } else {
                // Current element is smaller than previous, swap them
                swap(a, pos, pos - 1);
                // Move backward to recheck the swapped element
                pos = pos - 1;
            }
        }

    }


    public static <T extends Comparable<T>> void cocktailShakerSort(T[] a) {

        /**
         * Cocktail Shaker Sort Algorithm (Bidirectional Bubble Sort)
         *
         * This algorithm improves upon bubble sort by traversing the array in both
         * directions alternately. It moves the largest element to the end in the
         * forward pass and the smallest element to the beginning in the backward pass.
         *
         * Time Complexity: O(n²) worst case, O(n) best case
         * Space Complexity: O(1)
         *
         * @param a the array to be sorted
         * @param <T> the type of elements, must be Comparable
         */
            // Variable to track if any swaps occurred in a pass
            boolean swapped;

            // Repeat until no swaps are made in a complete forward-backward cycle
            do {
                // Reset swapped flag for forward pass
                swapped = false;

                // Forward pass: move from left to right (0 to length-1)
                // Compare each adjacent pair and swap if out of order
                for (int i = 0; i < a.length - 1; i++) {
                    if (a[i].compareTo(a[i + 1]) > 0) {
                        // Elements are out of order, swap them
                        swap(a, i, i + 1);
                        swapped = true;
                    }
                }

                // If no swaps occurred in forward pass, array is sorted
                if (!swapped) {
                    // Break out of the do-while loop
                    break;
                }

                // Reset swapped flag for backward pass
                swapped = false;

                // Backward pass: move from right to left (length-1 down to 0)
                // Still comparing a[i] with a[i+1], but i is decrementing
                for (int i = a.length - 2; i >= 0; i--) {
                    if (a[i].compareTo(a[i + 1]) > 0) {
                        // Elements are out of order, swap them
                        swap(a, i, i + 1);
                        swapped = true;
                    }
                }

            } while (swapped); // Continue if any swaps occurred in backward pass
        }



    public static <T extends Comparable<T>> void shellSort(T[] a) {

        /**
         * Shell Sort Algorithm
         *
         * Shell Sort is an optimization of insertion sort that allows the exchange of
         * items that are far apart. It starts by sorting pairs of elements far apart
         * from each other, then progressively reducing the gap between elements to be
         * compared. The final pass is a standard insertion sort (gap = 1), but by then
         * the array is almost sorted, making it very efficient.
         *
         * This implementation uses the Ciura gap sequence, which is empirically derived
         * and provides good performance in practice.
         *
         * Time Complexity: O(n^(4/3)) for Ciura sequence, O(n²) worst case
         * Space Complexity: O(1)
         *
         * @param a the array to be sorted
         * @param <T> the type of elements, must be Comparable
         */
            // Ciura gap sequence - empirically derived optimal gaps
            int[] gaps = {701, 301, 132, 57, 23, 10, 4, 1};

            // Get the length of the array
            int n = a.length;

            // Start with the largest gap and work down to a gap of 1
            for (int gap : gaps) {
                // Do a gapped insertion sort for every element in gaps
                // Start at gap and move through the array
                for (int i = gap; i < n; i += 1) {
                    // Save a[i] in temp and make a hole at position i
                    T temp = a[i];

                    // Shift earlier gap-sorted elements up until the correct
                    // location for a[i] is found
                    int j;
                    for (j = i; (j >= gap) && (a[j - gap].compareTo(temp) > 0); j -= gap) {
                        // Move the element at j-gap forward to position j
                        a[j] = a[j - gap];
                    }

                    // Put temp (the original a[i]) in its correct location
                    a[j] = temp;
                }
            }
        }


    private static <T extends Comparable<T>> void swap(T[] data, int index1, int index2) {

        T temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;

    }
}





