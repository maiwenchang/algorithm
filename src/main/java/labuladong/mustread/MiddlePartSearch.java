package labuladong.mustread;

public class MiddlePartSearch {

    public static void main(String[] args) {

    }

    public int[] searchRange(int[] nums, int target) {
        int left = bound_left(nums, target);
        int right = bound_right(nums, target);
        return new int[]{left, right};
    }

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int index = left + (right - left) / 2;
            if (nums[index] == target) {
                return index;
            }
            if (nums[index] > target) {
                right = index - 1;
            }
            if (nums[index] < target) {
                left = index + 1;
            }
        }
        return -1;
    }

    public int bound_left(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int index = -1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] == target) {
                right = middle - 1;
                index = middle;
            } else if (nums[middle] > target) {
                right = middle - 1;
            } else if (nums[middle] < target) {
                left = middle + 1;
            }
        }
        return index;
    }

    public int bound_right(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int index = -1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] == target) {
                left = middle + 1;
                index = middle;
            } else if (nums[middle] > target) {
                right = middle - 1;
            } else if (nums[middle] < target) {
                left = middle + 1;
            }
        }
        return index;
    }
}
