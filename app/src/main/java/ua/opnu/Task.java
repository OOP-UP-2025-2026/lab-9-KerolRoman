package ua.opnu;

import java.util.*;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Task {
    public static void main(String[] args) {

    }

    public void removeShorterStrings(List<String> list) {

        for (int i = 0; i < list.size() - 1; i++) {
            String a = list.get(i);
            String b = list.get(i + 1);

            if (a.length() <= b.length()) {
                list.remove(i);
            } else {
                list.remove(i + 1);
            }
        }

    }

    public void stutter(List<String> list) {

        for (int i = 0; i < list.size(); i += 2) {
            list.add(i, list.get(i));
        }
    }

    public void switchPairs(List<String> list) {

        for (int i = 0; i < list.size() - 1; i += 2) {
            String tmp = list.get(i);
            list.set(i, list.get(i + 1));
            list.set(i + 1, tmp);
        }
    }

    public void removeDuplicates(List<String> list) {

        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).equals(list.get(i + 1))) {
                list.remove(i + 1);
                i--;
            }
        }
    }

    public void markLength4(List<String> list) {

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() == 4) {
                list.add(i, "****");
                i++;
            }
        }
    }

    public boolean isPalindrome(Queue<Integer> queue) {

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int size = queue.size();

        for (int i = 0; i < size; i++) {
            int x = queue.remove();
            queue.add(x);
            stack.push(x);
        }

        boolean ok = true;

        for (int i = 0; i < size; i++) {
            int x = queue.remove();
            int y = stack.pop();
            queue.add(x);

            if (x != y) ok = false;
        }
        return ok;
    }

    public void reorder(Queue<Integer> queue) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int size = queue.size();

        for (int i = 0; i < size; i++) {
            int x = queue.remove();
            if (x < 0) stack.push(x);
            else queue.add(x);
        }

        while (!stack.isEmpty()) queue.add(stack.pop());
    }

    public void rearrange(Queue<Integer> queue) {

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int size = queue.size();

        for (int i = 0; i < size; i++) {
            int x = queue.remove();
            if (x % 2 == 0) stack.push(x);
            else queue.add(x);
        }

        while (!stack.isEmpty()) {
            queue.add(stack.removeLast());
        }

        while (!stack.isEmpty()) queue.add(stack.removeLast());
    }

    public int maxLength(Set<String> set) {

        int max = 0;
        for (String s : set) max = Math.max(max, s.length());
        return max;
    }

    public void removeEvenLength(Set<String> set) {

        set.removeIf(s -> s.length() % 2 == 0);
    }

    public int numInCommon(List<Integer> list1, List<Integer> list2) {

        Set<Integer> set = new HashSet<>(list1);
        int count = 0;
        Set<Integer> used = new HashSet<>();

        for (int x : list2) {
            if (set.contains(x) && !used.contains(x)) {
                used.add(x);
                count++;
            }
        }

        return count;
    }

    public boolean isUnique(Map<String, String> map) {

        Set<String> used = new HashSet<>();
        for (String v : map.values()) {
            if (!used.add(v)) return false;
        }
        return true;
    }

    public Map<String, Integer> intersect(Map<String, Integer> map1, Map<String, Integer> map2) {

        Map<String, Integer> res = new HashMap<>();
        for (String key : map1.keySet()) {
            if (map2.containsKey(key) && map1.get(key).equals(map2.get(key))) {
                res.put(key, map1.get(key));
            }
        }
        return res;
    }

    public Map<String, Integer> reverse(Map<Integer, String> map) {

        Map<String, Integer> res = new HashMap<>();
        for (Map.Entry<Integer, String> e : map.entrySet()) {
            res.put(e.getValue(), e.getKey());
        }
        return res;
    }

    public int rarest(Map<String, Integer> map) {

        Map<Integer, Integer> freq = new HashMap<>();

        for (int v : map.values()) freq.put(v, freq.getOrDefault(v, 0) + 1);

        int bestValue = Integer.MAX_VALUE;
        int bestCount = Integer.MAX_VALUE;

        for (var e : freq.entrySet()) {
            int v = e.getKey();
            int c = e.getValue();

            if (c < bestCount || (c == bestCount && v < bestValue)) {
                bestCount = c;
                bestValue = v;
            }
        }

        return bestValue;
    }

    public int maxOccurrences(List<Integer> list) {

        if (list.isEmpty()) return 0;

        Map<Integer, Integer> freq = new HashMap<>();
        int best = 0;

        for (int x : list) {
            int c = freq.getOrDefault(x, 0) + 1;
            freq.put(x, c);
            best = Math.max(best, c);
        }

        return best;
    }

}
