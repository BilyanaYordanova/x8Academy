package package1;

public class RescaleImageNNI {

	int[][] rescale(int[][] original, int newWidth, int newHeight) {

		int[][] temp = new int[newWidth][newHeight];
		int width = original.length;
		int height = original[0].length;

		double x_ratio = width / (double) newWidth;
		double y_ratio = height / (double) newHeight;
		double px, py;

		for (int i = 0; i < newWidth; i++) {
			for (int j = 0; j < newHeight; j++) {
				px = Math.floor(i * x_ratio);
				py = Math.floor(j * y_ratio);
				temp[i][j] = original[(int) px][(int) py];
			}
		}
		return temp;
	}
