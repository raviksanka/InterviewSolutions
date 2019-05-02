package com.self;

import java.util.*;
import java.util.stream.Collectors;

public class OrderedJunctionBoxes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

	public List<String> orderedJunctionBoxes(int numberOfBoxes, List<String> boxList) {
		// WRITE YOUR CODE HERE
		if (null == boxList || numberOfBoxes != boxList.size()) {
			// log error
			return boxList;
		}
		List<String> newVersions = new LinkedList<String>();
		String regex = "\\d+";
		for (String box : boxList) {
			if (box.substring(box.indexOf(' ') + 1).replaceAll("\\s", "").matches(regex)) {
				newVersions.add(box);
			}
		}
		if (newVersions.size() > 0)
			boxList.removeAll(newVersions);
		Map<String, String> nameVersionMap = boxList.stream().collect(Collectors
				.toMap(item -> item.substring(0, item.indexOf(' ')), item -> item.substring(item.indexOf(' ') + 1)));
		List<Map.Entry<String, String>> list = new ArrayList<>(nameVersionMap.entrySet());
		Collections.sort(list, new ValueThenKeyComparator<String, String>());
		List<String> returnList = new LinkedList<String>();
		returnList = list.stream().map(item -> item.getKey() + " " + item.getValue()).collect(Collectors.toList());
		returnList.addAll(newVersions);
		return returnList;
	}
	// METHOD SIGNATURE ENDS
}

class ValueThenKeyComparator<K extends Comparable<? super K>, V extends Comparable<? super V>>
		implements Comparator<Map.Entry<K, V>> {

	public int compare(Map.Entry<K, V> a, Map.Entry<K, V> b) {
		int cmp1 = a.getValue().compareTo(b.getValue());
		if (cmp1 != 0)
			return cmp1;
		else
			return a.getKey().compareTo(b.getKey());
	}
}
