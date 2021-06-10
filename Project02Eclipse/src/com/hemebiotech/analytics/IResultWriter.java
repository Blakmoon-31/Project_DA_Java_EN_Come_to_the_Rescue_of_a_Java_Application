package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Will write result of reading symptoms into a file. Result is a list of
 * strings and values ordered alphabetically.
 * 
 * @author Emmanuel
 *
 */
public interface IResultWriter {

	/**
	 * @param ListToWrite The list used to write in the file.
	 */
	void writeResult(Map<String, Integer> ListToWrite);
}
