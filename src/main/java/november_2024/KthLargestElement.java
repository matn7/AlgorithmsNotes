package november_2024;

import java.util.PriorityQueue;

public class KthLargestElement {

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;

        KthLargestElement kthLargestElement = new KthLargestElement();
        int result = kthLargestElement.findKthLargest(nums, k);
        System.out.println(result);
    }

    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int num : nums) {
            if (queue.size() < k) {
                queue.add(num);
            } else {
                Integer peek = queue.peek();
                if (peek < num) {
                    queue.poll();
                    queue.add(num);
                }
            }
        }
        return queue.peek();

    }


    public int findKthLargest2(int[] nums, int k) {
        int kth = nums.length - k;

        quickSort(nums, 0, nums.length - 1, kth);

        return nums[kth];
    }

    private void quickSort(int[] nums, int s, int e, int kth) {
        if (s >= e) {
            return;
        }
        int pivot = s;
        int start = s + 1;
        int end = e;

        while (start <= end) {
            if (nums[start] >= nums[pivot] && nums[end] <= nums[pivot]) {
                swap(nums, start, end);
            }
            if (nums[start] <= nums[pivot]) {
                start++;
            }
            if (nums[end] >= nums[pivot]) {
                end--;
            }
        }
        swap(nums, end, pivot);
        if (end == kth) {
            return;
        }

        if (e - (end + 1) < end - 1 - s) {
            quickSort(nums, s, end - 1, kth);
            quickSort(nums, end + 1, e, kth);
        } else {
            quickSort(nums, end + 1, e, kth);
            quickSort(nums, s, end - 1, kth);
        }

        // s==============end======e
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
