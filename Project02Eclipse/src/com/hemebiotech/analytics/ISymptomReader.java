package com.hemebiotech.analytics;

import java.util.List;

/**
 * Anything that will read symptom data from a source. The important part is,
 * the return value from the operation, which is a list of strings.
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
	 * @return a listing of Symptoms obtained from a data source.
	 * 
	 */
	List<String> getSymptoms();
}
