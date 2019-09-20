package tasks1;

public class ExpandString {

	public StringBuilder copyNTimes(StringBuilder str, int timesToCopy) {
		StringBuilder result = new StringBuilder("");
		for (int i = 0; i < timesToCopy; i++) {
			result.append(str);
		}
		return result;
	}

	public String expandString(String str) {
		StringBuilder expanded = new StringBuilder("");
		StringBuilder result = new StringBuilder("");
		int timesToCopy;

		for (int i = 0; i < str.length(); i++) {
			if (Character.isLetter(str.charAt(i))) {
				result.append(str.charAt(i));
			}
			if (Character.isDigit(str.charAt(i))) {
				timesToCopy = Character.getNumericValue(str.charAt(i));
				i++;
				while (str.charAt(i) != ')') {
					if (str.charAt(i) == '(') {
						i++;
						continue;
					} else {
						expanded.append(str.charAt(i));
						i++;
					}
				}
				expanded = copyNTimes(expanded, timesToCopy);
				result.append(expanded);
				expanded = new StringBuilder("");
				if (str.charAt(i) == ')') {
					continue;
				}
			}
		}

		return result.toString();
	}
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		ExpandString obj = new ExpandString();
//		String str = "AB3(DC)2(F)";
//		System.out.println(obj.expandString(str));
//	}

}
