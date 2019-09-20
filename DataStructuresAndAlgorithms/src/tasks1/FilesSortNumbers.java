package tasks1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class FilesSortNumbers {

	public void sortTwoFiles(String pathToFirstFile, String pathToSecondFile) {

		// data structures to hold the sorted elements from the two files
		ArrayList<Integer> firstArrayList = new ArrayList<Integer>();
		ArrayList<Integer> secondArrayList = new ArrayList<Integer>();

		// create first file
		File objFirstFile = new File(pathToFirstFile);
		try {
			if (!objFirstFile.exists()) {
				objFirstFile.createNewFile();
			}
			System.out.println("First file exists ");
		} catch (IOException e) {
			e.printStackTrace();
		}

		// create second file
		File objSecondFile = new File(pathToSecondFile);
		try {
			if (!objSecondFile.exists()) {
				objSecondFile.createNewFile();
			}
			System.out.println("Second file exists");
		} catch (IOException e) {
			e.printStackTrace();
		}

		// read from first file
		try {
			Scanner firstReader = new Scanner(objFirstFile);
			while (firstReader.hasNext()) {
				int element = firstReader.nextInt();
				firstArrayList.add(element);
			}
			firstReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred reading from first file");
			e.printStackTrace();
		}

		// read from second file
		try {
			Scanner secondReader = new Scanner(objSecondFile);
			while (secondReader.hasNext()) {
				int element = secondReader.nextInt();
				secondArrayList.add(element);
			}
			secondReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred reading from second file");
			e.printStackTrace();
		}

		Collections.sort(firstArrayList);
		Collections.sort(secondArrayList);

		// create file to keep sorted elements
		File objSortedElementFile = new File("sortedFirstAndSecond.txt");
		try {
			if (!objSortedElementFile.exists()) {
				objSortedElementFile.createNewFile();
			}
			System.out.println("The file to keep the sorted elements exists ");
		} catch (IOException e) {
			System.out.println("An error occurred while creating the file to keep the sorted elements ");
			e.printStackTrace();
		}

		// write the elements from the data structure in the newly created file which
		// will keep the sorted elements
		try {
			FileWriter sortedFileWriter = new FileWriter("sortedFirstAndSecond.txt");
			int i = 0, j = 0;
			while (i < firstArrayList.size() && j < secondArrayList.size()) {
				if (firstArrayList.get(i) < secondArrayList.get(j)) {
					sortedFileWriter.write(firstArrayList.get(i) + " ");
					i++;
				} else {
					sortedFileWriter.write(secondArrayList.get(j) + " ");
					j++;
				}
			}
			while (i < firstArrayList.size()) {
				sortedFileWriter.write(firstArrayList.get(i) + " ");
				i++;
			}
			while (j < secondArrayList.size()) {
				sortedFileWriter.write(secondArrayList.get(j) + " ");
				j++;
			}
			sortedFileWriter.close();
			System.out.println("Successfully wrote in the newly created file ");
		} catch (IOException e) {
			System.out.println("An error occurred writing in the new file ");
			e.printStackTrace();
		}

		// read from the sorted file
		try {
			Scanner sortedReader = new Scanner(objSortedElementFile);
			System.out.println("Sorted elements from two files: ");
			while (sortedReader.hasNext()) {
				System.out.println(sortedReader.next());
			}
			sortedReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred reading from sorted file ");
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FilesSortNumbers obj = new FilesSortNumbers();

		File first = new File("first.txt");
		File second = new File("second.txt");

		ArrayList<Integer> firstArrayList = new ArrayList<Integer>();
		for (int i = 1; i <= 250000; i++) {
			firstArrayList.add(i);
		}
		Collections.shuffle(firstArrayList);

		// write in first file elements from firstArrayList
		try {
			FileWriter firstWriter = new FileWriter(first);
			for (int i = 0; i < firstArrayList.size(); i++) {
				firstWriter.write(firstArrayList.get(i) + " ");
			}
			firstWriter.close();
			System.out.println("Successfully wrote to first file ");
		} catch (IOException e) {
			System.out.println("An error occurred writing to first file ");
			e.printStackTrace();
		}

		ArrayList<Integer> secondArrayList = new ArrayList<Integer>();
		for (int i = 250001; i <= 500000; i++) {
			secondArrayList.add(i);
		}
		Collections.shuffle(secondArrayList);

		// write in second file elements from secondArrayList
		try {
			FileWriter secondWriter = new FileWriter(second);
			for (int i = 0; i < secondArrayList.size(); i++) {
				secondWriter.write(secondArrayList.get(i) + " ");
			}
			secondWriter.close();
			System.out.println("Successfully wrote to second file ");
		} catch (IOException e) {
			System.out.println("An error occurred writing to second file");
			e.printStackTrace();
		}

		obj.sortTwoFiles(first.getAbsolutePath(), second.getAbsolutePath());
	}

}
