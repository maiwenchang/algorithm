package labuladong.mustread;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 全排列(回溯问题)
 */
public class AllSort {


    public static void main(String[] args) {
        AllSort allSort = new AllSort();
        List<List<Integer>> lists = allSort.permute(new int[]{1, 2, 3, 4, 5, 6, 7, 8});
        for (List<Integer> list : lists) {
            System.out.print("[ ");
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i));
                if (i != list.size() - 1) {
                    System.out.print(",");
                }
            }
            System.out.print(" ]\n");
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        trackItem(results, nums, new ArrayList<>());
        return results;
    }


    public void trackItem(List<List<Integer>> results, int[] nums, ArrayList<Integer> trackList) {
        if (!trackList.isEmpty() && trackList.size() == nums.length) {
            results.add(new ArrayList<>(trackList));
            return;
        }
        for (int num : nums) {
            //决策
            if (trackList.contains(num)) {
                continue;
            }
            trackList.add(num);
            //进入下一层决策
            trackItem(results, nums, trackList);
            //撤回决策
            int lastIndex = trackList.size() - 1;
            trackList.remove(lastIndex);
        }
    }

}
