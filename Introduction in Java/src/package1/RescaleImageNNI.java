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
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		int[][] original = {{1,2,6}, 
//							{3,4,5}};
//		
//		int[][] temp = rescale(original,6,6);
//		for(int i = 0; i < temp.length; i++) {
//			for(int j = 0; j < temp[0].length; j++) {
//				System.out.print(temp[i][j]);
//			}
//			System.out.println();
//		}
//	}
}
