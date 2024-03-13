import java.util.Comparator;
import java.util.Arrays;

/**
 * A simple way to sort arrays using merge sort.
 *
 * @author YourName Here
 * @author Your NameHere
 * @author Samuel A. Rebelsky
 */
public class MergeSorter {

  // +------------------+--------------------------------------------
  // | Exported methods |
  // +------------------+

  /**
   * Sort an array using the merge sort algorithm.
   */
  public static <T> void sort(T[] vals, Comparator<? super T> comparator) {
    // STUB
  } // sort

  // +-----------------+---------------------------------------------
  // | Local utilities |
  // +-----------------+

  /**
   * Merge the values from positions [lo..mid) and [mid..hi) back into
   * the same part of the array.
   *
   * Preconditions: Each subarray is sorted accorting to comparator.
   */
  static <T> void merge(T[] vals, int lo, int mid, int hi, Comparator<? super T> comparator) {
    int left = lo;
    int right = mid;
    int sort = 0;
    T[] scratch = Arrays.copyOf(vals, hi + 1);
    while(left != mid && right != hi) {
      int comp = comparator.compare(vals[left], vals[right]);
      if (comp < 0) {
        scratch[sort++] = vals[right++];
      } else {
        scratch[sort++] = vals[left++];
      }
    }
    if (left == mid) {
      while (right != hi) {
        scratch[sort++] = vals[right++];
      }
    } else {
      while (left != mid) {
        scratch[sort++] = vals[left++];
      }
    }

    for(int i = lo; i < hi; i++) {
      vals[i] = scratch[i - lo];
    }
  } // merge

} // class MergeSorter
