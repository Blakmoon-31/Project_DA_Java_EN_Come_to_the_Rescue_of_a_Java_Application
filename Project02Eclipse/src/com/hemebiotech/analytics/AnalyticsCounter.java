package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.Map;

public class AnalyticsCounter {

	public static void main(String[] args) {

		createResultFile();

	}

	/**
	 * Calls methods to read the symptoms.txt file and generate the file result.out
	 * with the list of symptoms in alphabetical order with number of occurences.
	 * 
	 * @see ReadSymptomDataFromFile#getSymptoms()
	 * @see WriteResultFileFromSymptomList#writeResult(Map)
	 * 
	 */
	public static void createResultFile() {

		Map<String, Integer> symptomsList = new HashMap<String, Integer>();

		ReadSymptomDataFromFile list = new ReadSymptomDataFromFile();

		symptomsList = list.getSymptoms();

		/**
		 * Result file created only if the list given has at least one line.
		 */
		if (symptomsList.size() > 0) {
			WriteResultFileFromSymptomList listWriter = new WriteResultFileFromSymptomList();
			listWriter.writeResult(symptomsList);

		}

	}
}
