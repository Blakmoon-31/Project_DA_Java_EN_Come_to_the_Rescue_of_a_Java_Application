package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

/**
 * Writes a file with a list of symptoms in alphabetical order.
 * 
 * @see ReadSymptomDataFromFile
 * 
 * @author Emmanuel
 *
 */
public class WriteResultFileFromSymptomList implements IResultWriter {

	/**
	 * Default name of the file to create with the results.
	 * 
	 * The file name may later be used as an argument for the writeResult method.
	 */
	private String resultFilePath = "result.out";

	/**
	 * Constructor with file name.
	 * 
	 * @param resultFilePath A full or partial path to file to create with the
	 *                       symptom list.
	 */
	public WriteResultFileFromSymptomList(String filepath) {
		this.resultFilePath = filepath;
	}

	public WriteResultFileFromSymptomList() {
	}

	/**
	 * Creates the result file with the list of symtpoms in alphabetical order.
	 * 
	 * @param ListToWrite The list of symptoms with the number of occurences.
	 * 
	 * @see ReadSymptomDataFromFile#getSymptoms()
	 * 
	 */
	@Override
	public void writeResult(Map<String, Integer> ListToWrite) {

		/**
		 * Controls if there is a correct file name to create.
		 */
		if (resultFilePath != null && resultFilePath != "") {

			/**
			 * Uses try-with-ressources for auto closing file a the end.
			 */
			try (FileWriter writer = new FileWriter(resultFilePath)) {

				/**
				 * Uses TreeMap to order alphabetically the list of symptoms in the output file.
				 */
				Map<String, Integer> map = new TreeMap<String, Integer>(ListToWrite);
				Set<Entry<String, Integer>> set = map.entrySet();
				Iterator<Entry<String, Integer>> it = set.iterator();

				while (it.hasNext()) {
					Map.Entry<String, Integer> entry = (Map.Entry<String, Integer>) it.next();
					writer.write(entry.getKey() + "=" + entry.getValue() + "\n");
				}

			} catch (IOException e) {

				e.printStackTrace();

			}
			System.out.println("File " + resultFilePath + " created.");

		} else
			System.out.println("Please indicate the result file to create.");

	}

}
