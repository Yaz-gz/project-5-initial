package com.example.sorting;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Comprehensive unit test suite for SortingUtility class.
 * Tests all three sorting algorithms (Gnome Sort, Cocktail Shaker Sort, Shell Sort)
 * with various edge cases, typical cases, and different Comparable types.
 *
 * NOTE: All test variables use names from the pseudocode specifications:
 * - 'a' for arrays
 * - 'pos' for gnome sort position
 * - 'swapped' for cocktail shaker sort flag
 * - 'gaps', 'n', 'i', 'j', 'temp' for shell sort
 */
class SortingUtilityTest {

    // ============================================================================
    // GNOME SORT TESTS
    // ============================================================================

    @Nested
    @DisplayName("Gnome Sort Tests")
    class GnomeSortTests {

        // -------------------- INTEGER TESTS --------------------

        @Test
        @DisplayName("Gnome Sort - Empty array")
        void testGnomeSortEmptyArray() {
            // Edge case: Empty array should not cause errors
            Integer[] a = {};
            SortingUtility.gnomeSort(a);
            assertArrayEquals(new Integer[]{}, a);
        }

        @Test
        @DisplayName("Gnome Sort - Single element")
        void testGnomeSortSingleElement() {
            // Edge case: Single element is already sorted
            // Tests that pos starts at 0 and immediately increments to 1, then exits
            Integer[] a = {5};
            SortingUtility.gnomeSort(a);
            assertArrayEquals(new Integer[]{5}, a);
        }

        @Test
        @DisplayName("Gnome Sort - Two elements (swapped)")
        void testGnomeSortTwoElementsSwapped() {
            // Tests basic swap and backtracking behavior
            // pos=0 -> pos=1 -> backtrack to pos=0 -> forward to pos=1 -> pos=2 (done)
            Integer[] a = {2, 1};
            SortingUtility.gnomeSort(a);
            assertArrayEquals(new Integer[]{1, 2}, a);
        }

        @Test
        @DisplayName("Gnome Sort - Two elements (already sorted)")
        void testGnomeSortTwoElementsSorted() {
            // Tests that no unnecessary swaps occur
            // pos=0 -> pos=1 -> pos=2 (done, no backtracking)
            Integer[] a = {1, 2};
            SortingUtility.gnomeSort(a);
            assertArrayEquals(new Integer[]{1, 2}, a);
        }

        @Test
        @DisplayName("Gnome Sort - Already sorted array")
        void testGnomeSortAlreadySorted() {
            // Tests that algorithm efficiently handles sorted data
            // Should move forward without any backtracking
            Integer[] a = {1, 2, 3, 4, 5};
            SortingUtility.gnomeSort(a);
            assertArrayEquals(new Integer[]{1, 2, 3, 4, 5}, a);
        }

        @Test
        @DisplayName("Gnome Sort - Reverse sorted array")
        void testGnomeSortReverseSorted() {
            // Worst case: requires maximum backtracking
            // Tests extensive backward movement (pos decrements)
            Integer[] a = {5, 4, 3, 2, 1};
            SortingUtility.gnomeSort(a);
            assertArrayEquals(new Integer[]{1, 2, 3, 4, 5}, a);
        }

        @Test
        @DisplayName("Gnome Sort - Array with duplicates")
        void testGnomeSortWithDuplicates() {
            // Tests handling of equal elements (a[pos] >= a[pos-1] condition)
            Integer[] a = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3};
            SortingUtility.gnomeSort(a);
            assertArrayEquals(new Integer[]{1, 1, 2, 3, 3, 4, 5, 5, 6, 9}, a);
        }

        @Test
        @DisplayName("Gnome Sort - All same elements")
        void testGnomeSortAllSame() {
            // Edge case: All duplicates, should move forward without swaps
            Integer[] a = {5, 5, 5, 5, 5};
            SortingUtility.gnomeSort(a);
            assertArrayEquals(new Integer[]{5, 5, 5, 5, 5}, a);
        }

        @Test
        @DisplayName("Gnome Sort - Random order")
        void testGnomeSortRandomOrder() {
            // Typical case: random unsorted data
            Integer[] a = {64, 34, 25, 12, 22, 11, 90};
            SortingUtility.gnomeSort(a);
            assertArrayEquals(new Integer[]{11, 12, 22, 25, 34, 64, 90}, a);
        }

        @Test
        @DisplayName("Gnome Sort - Element at beginning needs to move to end")
        void testGnomeSortLargestAtStart() {
            // Tests extensive forward movement after initial backtracking
            Integer[] a = {90, 1, 2, 3, 4};
            SortingUtility.gnomeSort(a);
            assertArrayEquals(new Integer[]{1, 2, 3, 4, 90}, a);
        }

        @Test
        @DisplayName("Gnome Sort - Element at end needs to move to beginning")
        void testGnomeSortSmallestAtEnd() {
            // Tests maximum backtracking scenario
            // pos will backtrack all the way to 0, then move forward again
            Integer[] a = {5, 4, 3, 2, 1};
            SortingUtility.gnomeSort(a);
            assertArrayEquals(new Integer[]{1, 2, 3, 4, 5}, a);
        }

        @Test
        @DisplayName("Gnome Sort - Backtracking to position 0")
        void testGnomeSortBacktrackToZero() {
            // Specifically tests the (pos == 0) condition in the algorithm
            // When pos backtracks to 0, it should increment forward
            Integer[] a = {3, 2, 1, 4, 5};
            SortingUtility.gnomeSort(a);
            assertArrayEquals(new Integer[]{1, 2, 3, 4, 5}, a);
        }

        // -------------------- STRING TESTS --------------------

        @Test
        @DisplayName("Gnome Sort - String array")
        void testGnomeSortStrings() {
            // Tests generic Comparable type (String)
            String[] a = {"zebra", "apple", "mango", "banana"};
            SortingUtility.gnomeSort(a);
            assertArrayEquals(new String[]{"apple", "banana", "mango", "zebra"}, a);
        }

        @Test
        @DisplayName("Gnome Sort - String array with duplicates")
        void testGnomeSortStringsWithDuplicates() {
            // Tests string comparison with equal elements
            String[] a = {"dog", "cat", "dog", "ant", "cat"};
            SortingUtility.gnomeSort(a);
            assertArrayEquals(new String[]{"ant", "cat", "cat", "dog", "dog"}, a);
        }

        @Test
        @DisplayName("Gnome Sort - Empty strings")
        void testGnomeSortEmptyStrings() {
            // Edge case: empty strings in the array
            String[] a = {"", "b", "", "a"};
            SortingUtility.gnomeSort(a);
            assertArrayEquals(new String[]{"", "", "a", "b"}, a);
        }

        // -------------------- OTHER COMPARABLE TYPES --------------------

        @Test
        @DisplayName("Gnome Sort - Double array")
        void testGnomeSortDoubles() {
            // Tests another generic Comparable type
            Double[] a = {3.14, 1.41, 2.71, 0.5};
            SortingUtility.gnomeSort(a);
            assertArrayEquals(new Double[]{0.5, 1.41, 2.71, 3.14}, a);
        }

        @Test
        @DisplayName("Gnome Sort - Character array")
        void testGnomeSortCharacters() {
            // Tests Character Comparable type
            Character[] a = {'z', 'a', 'm', 'b', 'y'};
            SortingUtility.gnomeSort(a);
            assertArrayEquals(new Character[]{'a', 'b', 'm', 'y', 'z'}, a);
        }

        // -------------------- NEGATIVE NUMBER TESTS --------------------

        @Test
        @DisplayName("Gnome Sort - Negative integers")
        void testGnomeSortNegativeIntegers() {
            // Tests handling of negative numbers
            Integer[] a = {-5, 3, -1, 0, -10, 7, -3};
            SortingUtility.gnomeSort(a);
            assertArrayEquals(new Integer[]{-10, -5, -3, -1, 0, 3, 7}, a);
        }

        @Test
        @DisplayName("Gnome Sort - All negative integers")
        void testGnomeSortAllNegative() {
            // Tests array with only negative numbers
            Integer[] a = {-2, -8, -1, -5, -3};
            SortingUtility.gnomeSort(a);
            assertArrayEquals(new Integer[]{-8, -5, -3, -2, -1}, a);
        }

        @Test
        @DisplayName("Gnome Sort - Mixed positive, negative, and zero")
        void testGnomeSortMixedWithZero() {
            // Tests complete range including zero
            Integer[] a = {5, -3, 0, -7, 2, 0, -1};
            SortingUtility.gnomeSort(a);
            assertArrayEquals(new Integer[]{-7, -3, -1, 0, 0, 2, 5}, a);
        }

        // -------------------- NULL HANDLING TESTS --------------------

        @Test
        @DisplayName("Gnome Sort - Null array throws NullPointerException")
        void testGnomeSortNullArray() {
            // Edge case: Null array should throw NullPointerException
            Integer[] a = null;
            assertThrows(NullPointerException.class, () -> {
                SortingUtility.gnomeSort(a);
            });
        }
    }

    // ============================================================================
    // COCKTAIL SHAKER SORT TESTS
    // ============================================================================

    @Nested
    @DisplayName("Cocktail Shaker Sort Tests")
    class CocktailShakerSortTests {

        // -------------------- INTEGER TESTS --------------------

        @Test
        @DisplayName("Cocktail Shaker - Empty array")
        void testCocktailShakerEmptyArray() {
            // Edge case: Empty array, do-while should exit immediately
            Integer[] a = {};
            SortingUtility.cocktailShakerSort(a);
            assertArrayEquals(new Integer[]{}, a);
        }

        @Test
        @DisplayName("Cocktail Shaker - Single element")
        void testCocktailShakerSingleElement() {
            // Edge case: Single element, no swaps should occur
            Integer[] a = {5};
            SortingUtility.cocktailShakerSort(a);
            assertArrayEquals(new Integer[]{5}, a);
        }

        @Test
        @DisplayName("Cocktail Shaker - Two elements (swapped)")
        void testCocktailShakerTwoElementsSwapped() {
            // Tests basic bidirectional behavior
            // Forward pass: swap, Backward pass: check (already sorted)
            Integer[] a = {2, 1};
            SortingUtility.cocktailShakerSort(a);
            assertArrayEquals(new Integer[]{1, 2}, a);
        }

        @Test
        @DisplayName("Cocktail Shaker - Two elements (already sorted)")
        void testCocktailShakerTwoElementsSorted() {
            // Tests early termination when no swaps occur
            Integer[] a = {1, 2};
            SortingUtility.cocktailShakerSort(a);
            assertArrayEquals(new Integer[]{1, 2}, a);
        }

        @Test
        @DisplayName("Cocktail Shaker - Already sorted array")
        void testCocktailShakerAlreadySorted() {
            // Tests early termination: forward pass makes no swaps, breaks immediately
            Integer[] a = {1, 2, 3, 4, 5};
            SortingUtility.cocktailShakerSort(a);
            assertArrayEquals(new Integer[]{1, 2, 3, 4, 5}, a);
        }

        @Test
        @DisplayName("Cocktail Shaker - Reverse sorted array")
        void testCocktailShakerReverseSorted() {
            // Tests bidirectional sweeping on worst case
            // Requires multiple forward and backward passes
            Integer[] a = {5, 4, 3, 2, 1};
            SortingUtility.cocktailShakerSort(a);
            assertArrayEquals(new Integer[]{1, 2, 3, 4, 5}, a);
        }

        @Test
        @DisplayName("Cocktail Shaker - Array with duplicates")
        void testCocktailShakerWithDuplicates() {
            // Tests handling of equal elements during bidirectional passes
            // swapped variable tracks if any swaps occurred
            Integer[] a = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3};
            SortingUtility.cocktailShakerSort(a);
            assertArrayEquals(new Integer[]{1, 1, 2, 3, 3, 4, 5, 5, 6, 9}, a);
        }

        @Test
        @DisplayName("Cocktail Shaker - All same elements")
        void testCocktailShakerAllSame() {
            // Edge case: No swaps should occur, exits after first forward pass
            // swapped should remain false
            Integer[] a = {5, 5, 5, 5, 5};
            SortingUtility.cocktailShakerSort(a);
            assertArrayEquals(new Integer[]{5, 5, 5, 5, 5}, a);
        }

        @Test
        @DisplayName("Cocktail Shaker - Random order")
        void testCocktailShakerRandomOrder() {
            // Typical case: random unsorted data
            Integer[] a = {64, 34, 25, 12, 22, 11, 90};
            SortingUtility.cocktailShakerSort(a);
            assertArrayEquals(new Integer[]{11, 12, 22, 25, 34, 64, 90}, a);
        }

        @Test
        @DisplayName("Cocktail Shaker - Largest at beginning, smallest at end")
        void testCocktailShakerBidirectionalBenefit() {
            // Tests the advantage of bidirectional sorting
            // Forward pass: i increments, moves 90 to the right, swapped = true
            // Backward pass: i decrements, moves 1 to the left, swapped = true
            // This demonstrates why cocktail shaker is better than bubble sort
            Integer[] a = {90, 5, 3, 2, 1};
            SortingUtility.cocktailShakerSort(a);
            assertArrayEquals(new Integer[]{1, 2, 3, 5, 90}, a);
        }

        @Test
        @DisplayName("Cocktail Shaker - Verify forward pass moves large elements right")
        void testCocktailShakerForwardPass() {
            // Array designed to test forward pass effectiveness
            // 99 should bubble to the end in first forward pass
            // Tests the forward loop: for each i in 0 to length(a) − 1
            Integer[] a = {99, 1, 2, 3, 4};
            SortingUtility.cocktailShakerSort(a);
            assertArrayEquals(new Integer[]{1, 2, 3, 4, 99}, a);
        }

        @Test
        @DisplayName("Cocktail Shaker - Verify backward pass moves small elements left")
        void testCocktailShakerBackwardPass() {
            // Array designed to test backward pass effectiveness
            // 0 should move to the beginning during backward passes
            // Tests the backward loop: for each i in length(a) − 1 to 0
            Integer[] a = {5, 4, 3, 2, 0};
            SortingUtility.cocktailShakerSort(a);
            assertArrayEquals(new Integer[]{0, 2, 3, 4, 5}, a);
        }

        @Test
        @DisplayName("Cocktail Shaker - Alternating high-low pattern")
        void testCocktailShakerAlternatingPattern() {
            // Tests that both directions work together efficiently
            // Pattern: high, low, high, low, high
            Integer[] a = {9, 1, 8, 2, 7, 3, 6, 4, 5};
            SortingUtility.cocktailShakerSort(a);
            assertArrayEquals(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, a);
        }

        @Test
        @DisplayName("Cocktail Shaker - Three elements requiring both passes")
        void testCocktailShakerThreeElements() {
            // Minimal case to test both forward and backward passes
            Integer[] a = {3, 1, 2};
            SortingUtility.cocktailShakerSort(a);
            assertArrayEquals(new Integer[]{1, 2, 3}, a);
        }

        // -------------------- STRING TESTS --------------------

        @Test
        @DisplayName("Cocktail Shaker - String array")
        void testCocktailShakerStrings() {
            // Tests generic Comparable type (String)
            String[] a = {"zebra", "apple", "mango", "banana"};
            SortingUtility.cocktailShakerSort(a);
            assertArrayEquals(new String[]{"apple", "banana", "mango", "zebra"}, a);
        }

        @Test
        @DisplayName("Cocktail Shaker - String array with duplicates")
        void testCocktailShakerStringsWithDuplicates() {
            // Tests string comparison with equal elements in both directions
            String[] a = {"dog", "cat", "dog", "ant", "cat"};
            SortingUtility.cocktailShakerSort(a);
            assertArrayEquals(new String[]{"ant", "cat", "cat", "dog", "dog"}, a);
        }

        @Test
        @DisplayName("Cocktail Shaker - Strings in reverse order")
        void testCocktailShakerStringsReverse() {
            // Tests bidirectional passes with string comparisons
            String[] a = {"echo", "delta", "charlie", "bravo", "alpha"};
            SortingUtility.cocktailShakerSort(a);
            assertArrayEquals(new String[]{"alpha", "bravo", "charlie", "delta", "echo"}, a);
        }

        // -------------------- OTHER COMPARABLE TYPES --------------------

        @Test
        @DisplayName("Cocktail Shaker - Double array")
        void testCocktailShakerDoubles() {
            // Tests another generic Comparable type
            Double[] a = {3.14, 1.41, 2.71, 0.5};
            SortingUtility.cocktailShakerSort(a);
            assertArrayEquals(new Double[]{0.5, 1.41, 2.71, 3.14}, a);
        }

        @Test
        @DisplayName("Cocktail Shaker - Character array")
        void testCocktailShakerCharacters() {
            // Tests Character Comparable type
            Character[] a = {'z', 'a', 'm', 'b', 'y'};
            SortingUtility.cocktailShakerSort(a);
            assertArrayEquals(new Character[]{'a', 'b', 'm', 'y', 'z'}, a);
        }

        // -------------------- NEGATIVE NUMBER TESTS --------------------

        @Test
        @DisplayName("Cocktail Shaker - Negative integers")
        void testCocktailShakerNegativeIntegers() {
            // Tests handling of negative numbers
            Integer[] a = {-5, 3, -1, 0, -10, 7, -3};
            SortingUtility.cocktailShakerSort(a);
            assertArrayEquals(new Integer[]{-10, -5, -3, -1, 0, 3, 7}, a);
        }

        @Test
        @DisplayName("Cocktail Shaker - All negative integers")
        void testCocktailShakerAllNegative() {
            // Tests array with only negative numbers
            Integer[] a = {-2, -8, -1, -5, -3};
            SortingUtility.cocktailShakerSort(a);
            assertArrayEquals(new Integer[]{-8, -5, -3, -2, -1}, a);
        }

        @Test
        @DisplayName("Cocktail Shaker - Mixed positive, negative, and zero")
        void testCocktailShakerMixedWithZero() {
            // Tests complete range including zero
            Integer[] a = {5, -3, 0, -7, 2, 0, -1};
            SortingUtility.cocktailShakerSort(a);
            assertArrayEquals(new Integer[]{-7, -3, -1, 0, 0, 2, 5}, a);
        }

        // -------------------- NULL HANDLING TESTS --------------------

        @Test
        @DisplayName("Cocktail Shaker - Null array throws NullPointerException")
        void testCocktailShakerNullArray() {
            // Edge case: Null array should throw NullPointerException
            Integer[] a = null;
            assertThrows(NullPointerException.class, () -> {
                SortingUtility.cocktailShakerSort(a);
            });
        }
    }

    // ============================================================================
    // SHELL SORT TESTS
    // ============================================================================

    @Nested
    @DisplayName("Shell Sort Tests")
    class ShellSortTests {

        // -------------------- INTEGER TESTS --------------------

        @Test
        @DisplayName("Shell Sort - Empty array")
        void testShellSortEmptyArray() {
            // Edge case: Empty array
            Integer[] a = {};
            SortingUtility.shellSort(a);
            assertArrayEquals(new Integer[]{}, a);
        }

        @Test
        @DisplayName("Shell Sort - Single element")
        void testShellSortSingleElement() {
            // Edge case: Single element
            Integer[] a = {5};
            SortingUtility.shellSort(a);
            assertArrayEquals(new Integer[]{5}, a);
        }

        @Test
        @DisplayName("Shell Sort - Two elements (swapped)")
        void testShellSortTwoElementsSwapped() {
            // Tests basic sorting with minimal elements
            Integer[] a = {2, 1};
            SortingUtility.shellSort(a);
            assertArrayEquals(new Integer[]{1, 2}, a);
        }

        @Test
        @DisplayName("Shell Sort - Two elements (already sorted)")
        void testShellSortTwoElementsSorted() {
            // Tests that no unnecessary operations occur
            Integer[] a = {1, 2};
            SortingUtility.shellSort(a);
            assertArrayEquals(new Integer[]{1, 2}, a);
        }

        @Test
        @DisplayName("Shell Sort - Already sorted array")
        void testShellSortAlreadySorted() {
            // Tests efficiency on already sorted data
            Integer[] a = {1, 2, 3, 4, 5};
            SortingUtility.shellSort(a);
            assertArrayEquals(new Integer[]{1, 2, 3, 4, 5}, a);
        }

        @Test
        @DisplayName("Shell Sort - Reverse sorted array")
        void testShellSortReverseSorted() {
            // Tests gap sequence effectiveness on worst case
            Integer[] a = {5, 4, 3, 2, 1};
            SortingUtility.shellSort(a);
            assertArrayEquals(new Integer[]{1, 2, 3, 4, 5}, a);
        }

        @Test
        @DisplayName("Shell Sort - Array with duplicates")
        void testShellSortWithDuplicates() {
            // Tests handling of equal elements across gap sequences
            // Uses variables: gaps, n, i, j, temp
            Integer[] a = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3};
            SortingUtility.shellSort(a);
            assertArrayEquals(new Integer[]{1, 1, 2, 3, 3, 4, 5, 5, 6, 9}, a);
        }

        @Test
        @DisplayName("Shell Sort - All same elements")
        void testShellSortAllSame() {
            // Edge case: All duplicates
            Integer[] a = {5, 5, 5, 5, 5};
            SortingUtility.shellSort(a);
            assertArrayEquals(new Integer[]{5, 5, 5, 5, 5}, a);
        }

        @Test
        @DisplayName("Shell Sort - Random order")
        void testShellSortRandomOrder() {
            // Typical case: random unsorted data
            Integer[] a = {64, 34, 25, 12, 22, 11, 90};
            SortingUtility.shellSort(a);
            assertArrayEquals(new Integer[]{11, 12, 22, 25, 34, 64, 90}, a);
        }

        @Test
        @DisplayName("Shell Sort - Large array with various gaps")
        void testShellSortLargeArray() {
            // Tests that multiple gap sizes are utilized effectively
            // Ciura gap sequence: gaps = [701, 301, 132, 57, 23, 10, 4, 1]
            // Uses variables: gap, i, j, temp, n
            Integer[] a = {23, 45, 12, 67, 89, 34, 56, 78, 90, 1, 3, 5, 7, 9, 2, 4, 6, 8};
            SortingUtility.shellSort(a);
            assertArrayEquals(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 12, 23, 34, 45, 56, 67, 78, 89, 90}, a);
        }

        // -------------------- STRING TESTS --------------------

        @Test
        @DisplayName("Shell Sort - String array")
        void testShellSortStrings() {
            // Tests generic Comparable type (String)
            String[] a = {"zebra", "apple", "mango", "banana"};
            SortingUtility.shellSort(a);
            assertArrayEquals(new String[]{"apple", "banana", "mango", "zebra"}, a);
        }

        @Test
        @DisplayName("Shell Sort - String array with duplicates")
        void testShellSortStringsWithDuplicates() {
            // Tests string comparison with equal elements
            String[] a = {"dog", "cat", "dog", "ant", "cat"};
            SortingUtility.shellSort(a);
            assertArrayEquals(new String[]{"ant", "cat", "cat", "dog", "dog"}, a);
        }

        @Test
        @DisplayName("Shell Sort - Large string array")
        void testShellSortLargeStringArray() {
            // Tests gap sequence with strings
            String[] a = {"kiwi", "grape", "fig", "date", "cherry", "banana", "apple",
                    "orange", "mango", "lemon"};
            SortingUtility.shellSort(a);
            assertArrayEquals(new String[]{"apple", "banana", "cherry", "date", "fig",
                    "grape", "kiwi", "lemon", "mango", "orange"}, a);
        }

        // -------------------- OTHER COMPARABLE TYPES --------------------

        @Test
        @DisplayName("Shell Sort - Double array")
        void testShellSortDoubles() {
            // Tests another generic Comparable type
            Double[] a = {3.14, 1.41, 2.71, 0.5};
            SortingUtility.shellSort(a);
            assertArrayEquals(new Double[]{0.5, 1.41, 2.71, 3.14}, a);
        }

        @Test
        @DisplayName("Shell Sort - Character array")
        void testShellSortCharacters() {
            // Tests Character Comparable type
            Character[] a = {'z', 'a', 'm', 'b', 'y'};
            SortingUtility.shellSort(a);
            assertArrayEquals(new Character[]{'a', 'b', 'm', 'y', 'z'}, a);
        }

        // -------------------- NEGATIVE NUMBER TESTS --------------------

        @Test
        @DisplayName("Shell Sort - Negative integers")
        void testShellSortNegativeIntegers() {
            // Tests handling of negative numbers
            Integer[] a = {-5, 3, -1, 0, -10, 7, -3};
            SortingUtility.shellSort(a);
            assertArrayEquals(new Integer[]{-10, -5, -3, -1, 0, 3, 7}, a);
        }

        @Test
        @DisplayName("Shell Sort - All negative integers")
        void testShellSortAllNegative() {
            // Tests array with only negative numbers
            Integer[] a = {-2, -8, -1, -5, -3};
            SortingUtility.shellSort(a);
            assertArrayEquals(new Integer[]{-8, -5, -3, -2, -1}, a);
        }

        @Test
        @DisplayName("Shell Sort - Mixed positive, negative, and zero")
        void testShellSortMixedWithZero() {
            // Tests complete range including zero
            Integer[] a = {5, -3, 0, -7, 2, 0, -1};
            SortingUtility.shellSort(a);
            assertArrayEquals(new Integer[]{-7, -3, -1, 0, 0, 2, 5}, a);
        }

        // -------------------- NULL HANDLING TESTS --------------------

        @Test
        @DisplayName("Shell Sort - Null array throws NullPointerException")
        void testShellSortNullArray() {
            // Edge case: Null array should throw NullPointerException
            Integer[] a = null;
            assertThrows(NullPointerException.class, () -> {
                SortingUtility.shellSort(a);
            });
        }
    }

    // ============================================================================
    // COMPARATIVE TESTS - All algorithms should produce same results
    // ============================================================================

    @Nested
    @DisplayName("Comparative Tests - All Algorithms")
    class ComparativeTests {

        @Test
        @DisplayName("All algorithms produce same result - Random integers")
        void testAllAlgorithmsSameResultIntegers() {
            // Verify all three algorithms sort identically
            Integer[] a1 = {64, 34, 25, 12, 22, 11, 90};
            Integer[] a2 = {64, 34, 25, 12, 22, 11, 90};
            Integer[] a3 = {64, 34, 25, 12, 22, 11, 90};
            Integer[] expected = {11, 12, 22, 25, 34, 64, 90};

            SortingUtility.gnomeSort(a1);
            SortingUtility.cocktailShakerSort(a2);
            SortingUtility.shellSort(a3);

            assertArrayEquals(expected, a1);
            assertArrayEquals(expected, a2);
            assertArrayEquals(expected, a3);
        }

        @Test
        @DisplayName("All algorithms produce same result - Strings")
        void testAllAlgorithmsSameResultStrings() {
            // Verify all three algorithms sort identically with strings
            String[] a1 = {"zebra", "apple", "mango", "banana"};
            String[] a2 = {"zebra", "apple", "mango", "banana"};
            String[] a3 = {"zebra", "apple", "mango", "banana"};
            String[] expected = {"apple", "banana", "mango", "zebra"};

            SortingUtility.gnomeSort(a1);
            SortingUtility.cocktailShakerSort(a2);
            SortingUtility.shellSort(a3);

            assertArrayEquals(expected, a1);
            assertArrayEquals(expected, a2);
            assertArrayEquals(expected, a3);
        }

        @Test
        @DisplayName("All algorithms handle duplicates identically")
        void testAllAlgorithmsDuplicates() {
            // Verify stability and correctness with duplicates
            Integer[] a1 = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3};
            Integer[] a2 = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3};
            Integer[] a3 = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3};
            Integer[] expected = {1, 1, 2, 3, 3, 4, 5, 5, 6, 9};

            SortingUtility.gnomeSort(a1);
            SortingUtility.cocktailShakerSort(a2);
            SortingUtility.shellSort(a3);

            assertArrayEquals(expected, a1);
            assertArrayEquals(expected, a2);
            assertArrayEquals(expected, a3);
        }
    }
}