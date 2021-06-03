package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Anything that will read symptom data from a source. The important part is,
 * the return value from the operation, which is a list (map) of strings with
 * occurences as values.
 * 
 * The implementation does not need to order the list.
 * 
 * @author Emmanuel
 *
 */
public interface ISymptomReader {
	/**
	 * If no data is available, returns an empty List.
	 * 
	 * @return a listing of Symptoms obtained from a data source and the number of
	 *         occurences.
	 * 
	 */
	Map<String, Integer> getSymptoms();
}
