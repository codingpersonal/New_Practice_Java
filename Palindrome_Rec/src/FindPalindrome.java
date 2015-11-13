
public class FindPalindrome {

	public static void main(String[] args) {
		String input = "sdss";
		System.out.println("Input string is " + 
				(checkPalindrome(input) ? " " : "not") +
				" a palindrome");
	}

	static boolean checkPalindrome(String ip) {
		return (ip.length() == 1 || ip.length() == 0)
				? true
				: (ip.charAt(0) == ip.charAt(ip.length() - 1)) && checkPalindrome(ip.substring(1, ip.length() - 1));
	}
}
