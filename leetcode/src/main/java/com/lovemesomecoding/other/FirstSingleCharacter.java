package com.lovemesomecoding.other;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstSingleCharacter {

	public static void main(String[] args) {
		String str = "character";
		char firstSingleChar = findFirstSingleCharacter(str);
		System.out.println("str: " + str + ", firstSingleChar: " + firstSingleChar);
	}

	static char findFirstSingleCharacter(String str) {
		Map<Character, Integer> map = new LinkedHashMap<>();
		
		int length = str.length();

		for (int i = 0; i < length; i++) {
			char character = str.charAt(i);

			if (map.containsKey(character)) {
				map.put(character, map.get(character) + 1);
			} else {
				map.put(character, 1);
			}
			System.out.println(map);
		}
		
		return map.entrySet().stream().filter(entry -> entry.getValue() == 1).findFirst().get().getKey();
	}
}
