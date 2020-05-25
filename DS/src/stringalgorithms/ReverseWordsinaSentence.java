

package stringalgorithms;

public class ReverseWordsinaSentence {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0)
			return "";
		int curr = 0, start = 0;
		s = reverse(s);
		StringBuilder sb = new StringBuilder();
		while (curr < s.length()) {
			// start = curr;
			if (s.charAt(curr) != ' ') {
				// word
				curr++;
			} else {
				if (start != curr) {
					sb.append(reverse(s.substring(start, curr)) + " ");
					start = curr;
				} else {
					// space;
					curr++;
					start++;
				}
			}
		}
		if (start != curr) {
			sb.append(reverse(s.substring(start, curr)) + " ");
		}
		return sb.length() != 0 ? sb.toString().substring(0, sb.length() - 1) : "";
    }
    public String reverse(String s) {
        if (s == null || s.length() == 0)
			return "";
		int length = s.length(), last = length - 1;
		char[] chars = s.toCharArray();
		for (int i = 0; i < length / 2; i++) {
			char c = chars[i];
			chars[i] = chars[last - i];
			chars[last - i] = c;
		}
		return new String(chars);
    }
}