package package1;

public class URLDecode {

	public String decodeUrl(String input) {
		String replaced = input.replace("%20", " ");
		replaced = replaced.replace("%3A", ":");
		replaced = replaced.replace("%3D", "?");
		replaced = replaced.replace("%2F", "/");
		return replaced;
	}
}
