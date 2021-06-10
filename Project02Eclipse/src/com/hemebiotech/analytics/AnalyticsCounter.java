package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {

	/**
	 * Calls methods to create a list of symptoms from the symptoms.txt file, count
	 * symptoms occurrences, order the list alphabetically and write it in the
	 * result.out file.
	 * 
	 * @see ReadSymptomDataFromFile#getSymptoms()
	 * @see WriteResultFileFromSymptomList#writeResult(Map)
	 * 
	 */
	public void start() {

		/**
		 * Obtaining list of symptoms.
		 */
		List<String> symptomsList = new ArrayList<String>();
		ISymptomReader listFromFile = new ReadSymptomDataFromFile();
		symptomsList = listFromFile.getSymptoms();

		/**
		 * Next instructions done only if the list given has at least one line.
		 */
		if (symptomsList.size() > 0) {

			/**
			 * Counting occurrences from the list.
			 */
			Map<String, Integer> symptomsListCounted = new HashMap<String, Integer>();
			symptomsListCounted = countSymptoms(symptomsList);

			/**
			 * Ordering alphabetically the list with occurrences.
			 */
			TreeMap<String, Integer> symptomsListOrdered = new TreeMap<String, Integer>();
			symptomsListOrdered = orderSymptom(symptomsListCounted);

			/**
			 * Writing the result.out file from the ordered list.
			 */
			IResultWriter listWriter = new WriteResultFileFromSymptomList();
			listWriter.writeResult(symptomsListOrdered);

		}

	}

	/**
	 * Creates a map list with each symptom and count its occurrences. The lists are
	 * processed in lower case to avoid potential case differences for the same
	 * symptom.
	 * 
	 * @param listToCount The list obtained by reading a file.
	 * @return The list with symptoms and occurences.
	 * 
	 */
	public static Map<String, Integer> countSymptoms(List<String> listToCount) {

		Map<String, Integer> countedList = new HashMap<String, Integer>();

		for (String n : listToCount)
			if (countedList.get(n.toLowerCase()) == null) {
				countedList.put(n.toLowerCase(), 1);
			} else {
				countedList.put(n.toLowerCase(), countedList.get(n.toLowerCase()) + 1);
			}
		;

		return countedList;
	}

	/**
	 * Creates an ordered list from the list of symptoms with their occurrences.
	 * 
	 * @param listToOrder The list obtained after counting occurrences.
	 * @return The list ordered, ready to be write in result file.
	 * 
	 */
	public static TreeMap<String, Integer> orderSymptom(Map<String, Integer> listToOrder) {

		TreeMap<String, Integer> orderedList = new TreeMap<String, Integer>(listToOrder);

		return orderedList;

	}

}
