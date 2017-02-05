package stack;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class StackAndClosures {

	static Map<Character, Character> correspondents = new HashMap<>();
	static List<Character> opens = Arrays.asList('(', '{', '[');
	static List<Character> closers = Arrays.asList(')', '}', ']');
	static {
		correspondents.put('(', ')');
		correspondents.put('{', '}');
		correspondents.put('[', ']');
	}

	public static boolean isBalanced(String expression) {
		return isBalanced(expression, new ArrayList<Character>());
	}

	public static boolean isBalanced(String expression, List<Character> stack) {
		if (expression.isEmpty()) {
			if (stack.isEmpty()) {
				return true;
			}
			return false;
		}
		char c = expression.charAt(0);
		if (opens.contains(c)) {

			stack.add(c);
			return isBalanced(expression.substring(1), stack);
		}
		if (closers.contains(c)) {

			int top = stack.size() - 1;
			if (top < 0) {
				return false;
			}
			Character character = stack.get(top);
			if (correspondents.get(character).charValue() == c) {
				stack.remove(top);
				return isBalanced(expression.substring(1), stack);
			} else {
				return false;
			}

		}
		return false;

	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			String expression = in.next();
			System.out.println((isBalanced(expression)) ? "YES" : "NO");
		}
	}
}
