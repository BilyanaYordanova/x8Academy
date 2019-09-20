package package1;

public class ImageHistogram {

	public int[] histogram(short[][] image) {
		int[] result = new int[256];
		for (int i = 0; i < 256; i++) {
			result[i] = 0;
		}

		for (int row = 0; row < image.length; row++) {
			for (int col = 0; col < image[row].length; col++) {
				result[image[row][col]]++;
			}
		}

		for (int i = 0; i < 256; i++) {
			System.out.println(i + " => " + result[i]);
		}
		return result;
	}
}
