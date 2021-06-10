package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Reads a file to create a list with all symptoms from the file.
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
	private String symptomFilePath = "./Project02Eclipse/symptoms.txt";

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
	 * Create a list of symptoms by reading the file.
	 * 
	 * @return The list of all symptoms.
	 * 
	 */
	@Override
	public List<String> getSymptoms() {

		List<String> result = new ArrayList<String>();

		/**
		 * Controls if there is a correct file name to read.
		 */
		if (symptomFilePath != null && symptomFilePath != "") {
			try (BufferedReader reader = new BufferedReader(new FileReader(symptomFilePath))) {
				String line = reader.readLine();

				/**
				 * If file is not empty, reads it and inserts strings in the list, if empty
				 * shows warning.
				 */
				if (line != null) {

					while (line != null) {
						result.add(line);
						line = reader.readLine();
					}

					System.out.println("Listing completed.");

				} else
					System.out.println("The file " + symptomFilePath + " is empty.");

			} catch (FileNotFoundException e) {
				System.out.println("The file " + symptomFilePath + " doesn't exist.");

			} catch (IOException e) {
				e.printStackTrace();
			}

		} else
			System.out.println("Please indicate the symptom file to be processed.");

		return result;
	}

}
