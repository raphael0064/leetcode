package _1_Two_Sum;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class Solution {
	public static void main(String[] args) {
		int[] nums = {2, 7, 11, 15};
		int target = 9;
		int[] result = two_sum(nums, target);
		System.out.println(result[0] +":"+result[1]);
	}

	static int[] two_sum(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums.length; j++) {
				if (i == j) {
					continue;
				}
				if (nums[i] + nums[j] == target) {
					return new int[]{i, j};
				}
			}
		}
		return null;
	}

	/**
	 * given
	 * to use HashMap
	 */
	public int[] twoSum(int[] numbers, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < numbers.length; i++) {
			if (map.containsKey(target - numbers[i])) {
				return new int[]{i + 1, map.get(target - numbers[i])};
			}
			map.put(numbers[i], i + 1);
		}
		return null;
	}


}