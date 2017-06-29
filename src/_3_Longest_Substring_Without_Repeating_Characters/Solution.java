package _3_Longest_Substring_Without_Repeating_Characters;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * <p>
 * Examples:
 * <p>
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * <p>
 * Given "bbbbb", the answer is "b", with the length of 1.
 * <p>
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class Solution {

	public int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int sum = 1;
		for (int i = 0; i < s.length(); i++) {
			Set set = new HashSet<>();
			set.add(s.charAt(i));
			int temp = 1;
			for (int j = i + 1; j < s.length(); j++) {
				char c = s.charAt(j);
				if (!set.contains(c)) {
					set.add(c);
					temp++;
				} else {
					if (set.size() > sum) {
						temp = set.size();
					}
					break;
				}
			}
			if (temp > sum) {
				sum = temp;
			}
		}

		return sum;
	}

	public static void main(String[] args) {
		String s = "pwwkew";
		Solution solution = new Solution();
		System.out.println(solution.lengthOfLongestSubstring_given(s));
	}

	/**
	 * given
	 * the basic idea is, keep a hashmap which stores the characters in string as keys and their positions as values,
	 * and keep two pointers which define the max substring. move the right pointer to scan through the string,
	 * and meanwhile update the hashmap.
	 * If the character is already in the hashmap, then move the left pointer to the right of the same character last found.
	 * Note that the two pointers can only move forward.
	 */
	public int lengthOfLongestSubstring_given(String s) {
		if (s.length()==0) return 0;
		HashMap<Character, Integer> map = new HashMap<>();
		int max=0;
		for (int i=0, j=0; i<s.length(); ++i){
			if (map.containsKey(s.charAt(i))){
				j = Math.max(j,map.get(s.charAt(i))+1);
			}
			map.put(s.charAt(i),i);
			max = Math.max(max,i-j+1);
		}
		return max;
	}
}
