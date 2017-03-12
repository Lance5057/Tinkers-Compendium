package lance5057.tDefense.util;

public class Color16Util {
	public static String[] colors = { "black", "red", "green", "brown", "blue",
			"purple", "cyan", "lightgray", "gray", "pink", "lime", "yellow",
			"lightblue", "magenta", "orange", "white" };

	public static int[] colorsHex = { 0xDDDDDD, 0xDB7D3E, 0xB350BC,
			0x6B8AC9, 0xB1A627, 0x41AE38, 0xD08499, 0x404040, 0x9AA1A1,
			0x2E6E89, 0x7E3DB5, 0x2E388D, 0x4F321F, 0x35461B, 0x963430,
			0x191616 };
	
	public static int[] hexToRGB(String hex) {
		final int color[] = new int[3];

		color[0] = Integer.parseInt(hex.substring(0, 2), 16);
		color[1] = Integer.parseInt(hex.substring(2, 4), 16);
		color[2] = Integer.parseInt(hex.substring(4, 6), 16);

		return color;
	}
}
