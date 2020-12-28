package labuladong.mustread;

import javax.xml.crypto.Data;
import java.util.*;

public class OpenLock {


    public static void main(String[] args) {

        String[] deadends = {"8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"};
        String target = "8888";
        System.out.println("start at " + new Date().toString());
        int time = new Solution().openLock(deadends, target);
        System.out.println("unlock at " + new Date().toString());
        System.out.println("unlock time : " + time);
    }

    static class Solution {


        public int openLock(String[] deadends, String target) {
            Set<String> visiteds = new HashSet<>();
            Set<String> deads = new HashSet<>();
            Collections.addAll(deads, deadends);
            Queue<String> queue = new LinkedList<>();
            queue.add("0000");
            int times = 0;
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    String current = queue.remove();
                    /* 判断是否到达终点 */
                    if (deads.contains(current))
                        continue;
                    if (target.equals(current))
                        return times;

                    for (int j = 0; j < 4; j++) {
                        //向上拨
                        String keyUp = plusOne(current, j);
                        if (!visiteds.contains(keyUp)) {
                            queue.offer(keyUp);
                            visiteds.add(keyUp);
                        }

                        //向下拨
                        String keyDown = minusOne(current, j);
                        if (!visiteds.contains(keyDown)) {
                            queue.offer(keyDown);
                            visiteds.add(keyDown);
                        }

                    }
                }
                times++;
            }

            return -1;
        }


        // 将 s[j] 向上拨动一次
        String plusOne(String s, int j) {
            char[] ch = s.toCharArray();
            if (ch[j] == '9')
                ch[j] = '0';
            else
                ch[j] += 1;
            return new String(ch);
        }

        // 将 s[i] 向下拨动一次
        String minusOne(String s, int j) {
            char[] ch = s.toCharArray();
            if (ch[j] == '0')
                ch[j] = '9';
            else
                ch[j] -= 1;
            return new String(ch);
        }


    }


}
