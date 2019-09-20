package tasks1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SortNumbersInTwoFiles {

	public void sortTwoFiles(String pathToFirstFile, String pathToSecondFile) {

		// data structure to hold the sorted elements from the two files
		ArrayList<Integer> arrayList = new ArrayList<Integer>();

		// create first file
		File objFirstFile = new File(pathToFirstFile);
		try {
			if (!objFirstFile.exists()) {
				objFirstFile.createNewFile();
				// System.out.println("First file doesn't exist");
			}
			System.out.println("First file has been created");
		} catch (IOException e) {
			e.printStackTrace();
		}

		// create second file
		File objSecondFile = new File(pathToSecondFile);
		try {
			if (!objSecondFile.exists()) {
				objSecondFile.createNewFile();
				// System.out.println("Second file doesn't exist");
			}
			System.out.println("Second file has been created");
		} catch (IOException e) {
			e.printStackTrace();
		}

//		// write in first file
//		try {
//			FileWriter firstWriter = new FileWriter(pathToFirstFile);
//			firstWriter.write(21 + " ");
//			firstWriter.write(6 + " ");
//			firstWriter.write(17 + " ");
//			firstWriter.write(3 + " ");
//			firstWriter.close();
//			System.out.println("Successfully wrote to first file.");
//		} catch (IOException e) {
//			System.out.println("An error occurred writing.");
//			e.printStackTrace();
//		}

//		// write in second file
//		try {
//			FileWriter secondWriter = new FileWriter(pathToSecondFile);
//			secondWriter.write(14 + " ");
//			secondWriter.write(11 + " ");
//			secondWriter.write(5 + " ");
//			secondWriter.write(2 + " ");
//			secondWriter.close();
//			System.out.println("Successfully wrote to second file.");
//		} catch (IOException e) {
//			System.out.println("An error occurred writing.");
//			e.printStackTrace();
//		}

		// read from first file
		try {
			Scanner firstReader = new Scanner(objFirstFile);
//			while (firstReader.hasNextLine()) {
//				String firstData = firstReader.nextLine();
//				System.out.println(firstData);
//			}
			while (firstReader.hasNext()) {
				int element = firstReader.nextInt();
				arrayList.add(element);
				// System.out.print(element + " ");
			}
			firstReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred reading from first file");
			e.printStackTrace();
		}

		// read from second file
		try {
			Scanner secondReader = new Scanner(objSecondFile);
//			while (secondReader.hasNextLine()) {
//				String data = secondReader.nextLine();
//				System.out.println(data);
//			}
			while (secondReader.hasNext()) {
				int element = secondReader.nextInt();
				arrayList.add(element);
				// System.out.print(element + " ");
			}
			secondReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred reading from second file");
			e.printStackTrace();
		}

		Collections.sort(arrayList);

		// create file to keep sorted elements
		File objSortedElementFile = new File("sortedFirstAndSecond.txt");
		try {
			if (!objSortedElementFile.exists()) {
				objSortedElementFile.createNewFile();
			}
			System.out.println("The sorted file has been created");
		} catch (IOException e) {
			System.out.println("An error occurred while creating the file to keep the sorted elements");
			e.printStackTrace();
		}

		// write the elements from the data structure in the newly created file which
		// will keep the sorted elements
		try {
			FileWriter sortedFileWriter = new FileWriter("sortedFirstAndSecond.txt");
			for (int i = 0; i < arrayList.size(); i++) {
				sortedFileWriter.write(arrayList.get(i) + " ");
			}
			sortedFileWriter.close();
			System.out.println("Successfully wrote to sorted file.");
		} catch (IOException e) {
			System.out.println("An error occurred writing in the new file ");
			e.printStackTrace();
		}

		// read from the sorted file
		try {
			Scanner sortedReader = new Scanner(objSortedElementFile);
			System.out.println("Sorted elements from two files: ");
			while (sortedReader.hasNext()) {
				System.out.print(sortedReader.next() + " ");
			}
			sortedReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred reading from sorted file ");
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SortNumbersInTwoFiles obj = new SortNumbersInTwoFiles();

		File first = new File("first.txt");
		File second = new File("second.txt");

		ArrayList<Integer> firstArrayList = new ArrayList<Integer>();
		for (int i = 1; i <= 20; i++) {
			firstArrayList.add(i);
		}
		Collections.shuffle(firstArrayList);

		// write in first file
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
		for (int i = 1; i <= 20; i++) {
			secondArrayList.add(i);
		}
		Collections.shuffle(secondArrayList);

		// write in second file
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
