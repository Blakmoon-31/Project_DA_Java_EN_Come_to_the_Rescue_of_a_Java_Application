package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Reads a file with a list of symptoms to creat a list (map) with the number of
 * occurences of each symptom.
 * 
 * @author Emmanuel
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	/**
	 * Default name of the file to read.
	 * 
	 * The file name may later be used as an argument for the getSymptoms method.
	 */
	private String symptomFilePath = "symptoms.txt";

	/**
	 * Constructor with file name.
	 * 
	 * @param filepath A full or partial path to file with symptom strings in it,
	 *                 one per line.
	 */
	public ReadSymptomDataFromFile(String filepath) {
		this.symptomFilePath = filepath;
	}

	public ReadSymptomDataFromFile() {
	}

	/**
	 * Lists the symptoms from the file and counts its iterations in the file.
	 * 
	 * @return The list of symptoms with the number of occurences.
	 * 
	 */
	@Override
	public Map<String, Integer> getSymptoms() {

		Map<String, Integer> result = new HashMap<String, Integer>();

		/**
		 * Controls if there is a correct file name to read.
		 */
		if (symptomFilePath != null && symptomFilePath != "") {
			try (BufferedReader reader = new BufferedReader(new FileReader(symptomFilePath))) {
				String line = reader.readLine();

				/**
				 * If file is not empty, reads it, if empty shows warning.
				 */
				if (line != null) {

					while (line != null) {

						/**
						 * If symptom is already present, adds 1 to its value. If not, creates it with
						 * value = 1 (first time it is read). Forced to lower case to prevent
						 * duplicates.
						 */
						if (result.get(line.toLowerCase()) != null) {
							result.put(line.toLowerCase(), result.get(line.toLowerCase()) + 1);
						} else {
							result.put(line.toLowerCase(), 1);
						}
						line = reader.readLine();
					}

					System.out.println("Listing completed.");

				} else
					System.out.println("File " + symptomFilePath + " is empty.");

			} catch (FileNotFoundException e) {
				System.out.println("File " + symptomFilePath + " doesn't exist.");

			} catch (IOException e) {
				e.printStackTrace();
			}

		} else
			System.out.println("Please indicate the symptom file to be processed.");

		return result;
	}

}
