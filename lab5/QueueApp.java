// import java.util.Queue;

public class QueueApp {
	/**
	 * Checks if a given string represents an integer.
	 *
	 * @param s The string to be checked.
	 * @return True if the string is an integer, false otherwise.
	 */
	public static boolean isInteger(String s) {
		try {
			Integer.parseInt(s);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	/**
	 * Checks if the given strings form a prefix expression (operator followed by
	 * two integers).
	 *
	 * @param x The first string.
	 * @param y The second string.
	 * @param z The third string.
	 * @return True if the strings form a prefix expression, false otherwise.
	 */
	static boolean isPrefix(String x, String y, String z) {
		if (!isInteger(x) && isInteger(y) && isInteger(z))
			return true;
		else
			return false;
	}

	/**
	 * Evaluates a binary operation represented by two integers and an operator.
	 *
	 * @param opt The operator ('+', '-', '*', '/', or '%') to perform the
	 *            operation.
	 * @param x   The first operand as a string.
	 * @param y   The second operand as a string.
	 * @return The result of the binary operation as a string, or "can't be
	 *         evaluated" if the operator is invalid or the operands are not valid
	 *         integers.
	 */
	static String evalPrefixString(String opt, String x, String y) {
		if (opt.equals("+"))
			return "" + (Integer.parseInt(x) + Integer.parseInt(y));
		else if (opt.equals("-"))
			return "" + (Integer.parseInt(x) - Integer.parseInt(y));
		else if (opt.equals("*"))
			return "" + Integer.parseInt(x) * Integer.parseInt(y);
		else if (opt.equals("/"))
			return "" + Integer.parseInt(x) / Integer.parseInt(y);
		else if (opt.equals("%"))
			return "" + Integer.parseInt(x) % Integer.parseInt(y);
		else
			return "can't be evaluated";
	}

	/**
	 * Evaluates a prefix expression represented by an array of strings.
	 *
	 * @param input The array of strings representing the prefix expression.
	 * @return The result of the evaluated prefix expression.
	 */
	static String prefixEval(String[] input) {
		Queue<String> Q = new Queue<String>();
		for (int i = 0; i < input.length; i++) {
			Q.enqueue(input[i]);
		}
		// Exercise 4
		int size = Q.getSize();
		
		while (size > 1) {
			String x = Q.dequeue();
			String y = Q.dequeue();
			String z = Q.dequeue();
			
			if (isPrefix(x, y, z)) {
				Q.enqueue(evalPrefixString(x, y, z));
				size = size - 3;
			} else {
				Q.enqueue(x);
				x = y;
				y = z;
				z = Q.dequeue();
			}
		}

		return Q.list.first.element;
	}
	
	/**
     * Simulates the "Hot Potato" game using a queue.
     *
     * @param children Array of children's names participating in the game.
     * @param passes   Number of passes after which the child holding the potato is removed.
     * @return The name of the winner.
     */

    public static String playHotPotato(String[] children, int passes) {
        Queue<String> queue = new Queue<>();

        
        for (String child : children) {
			// Exercise 5
            //Complete the code, Add children to the queue
			
        }

        while (queue.getSize() > 1) {
            // Pass the potato the specified number of times
            for (/*Complete the code */) {
                /* Remove child from front and add to rear (simulate passing)*/;
            }
            /* Remove child holding the potato after specified passes */;
        }
        /*Return the winner*/;
    }

}