package com.tst.digit2char;

import java.util.*;

public class DigitsMapToChar {


	private static Map<Integer, List<String>> digMap;

	static {
//		digMap.put(0, null);
//		digMap.put(1, null);
		digMap = new HashMap<>();
		digMap.put(2, Arrays.asList("a", "b", "c"));
		digMap.put(3, Arrays.asList("d", "e", "f"));
		digMap.put(4, Arrays.asList("g", "h", "i"));
		digMap.put(5, Arrays.asList("j", "k", "l"));
		digMap.put(6, Arrays.asList("m", "n", "o"));
		digMap.put(7, Arrays.asList("p", "q", "r", "s"));
		digMap.put(8, Arrays.asList("t", "u", "v"));
		digMap.put(9, Arrays.asList("w", "x", "y", "z"));
	}

	/**
	 * number to char
	 * @param digits
	 */
	protected static void digToString(List<Integer> digits) {
		if (digits != null && digits.size() > 0) {
			ArrayList<List<String>> ll = new ArrayList<>();
			for (int i : digits) {
				if (digMap.containsKey(i)) {
					ll.add(digMap.get(i));
				}
			}
			List<String> descartes = ArrayUtils.getPermutations(ll);
			for (String s : descartes) {
				System.out.printf("%s\t", s);
			}

		}
		System.out.println();
	}



	public static void main(String[] args) {
		List<Integer> a = new ArrayList<>();
		a.add(5);
		a.add(6);
		digToString(a);

		List<Integer> b = new ArrayList<>();
		b.add(7);
		b.add(7);
		digToString(b);

		Integer[] c= {1,0, 22, 55, 66};
		List<Integer> l = Arrays.asList(c);
		List<Integer> newList = new ArrayList<>();

		for(Integer i: l) {
			if(i>=10 && i<=99) {
				String j = i+"";
				if(j.contains("0") || j.contains("1")){
					j = j.replace("0", "").replace("1", "");
				}
				if(j.length()==2){
					String[] arr = j.split("");
					for(String s: arr){
						newList.add(Integer.parseInt(s));
					}
				}else if(j.length()>0){
					newList.add(Integer.parseInt(j));
				}
			}else {
				newList.add(i);
			}
		}
		digToString(newList);
	}
}
