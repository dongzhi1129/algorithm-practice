package Practice.algorithm;

public class StackMin {

	public static class Stack<T extends Comparable<T>> {

		private java.util.Stack<T> dataStack;

		private java.util.Stack<T> minStack;

		public Stack() {
			super();
			dataStack = new java.util.Stack<>();
			minStack = new java.util.Stack<>();
		}

		public Stack(java.util.Stack<T> dataStack, java.util.Stack<T> minStack) {
			super();
			this.dataStack = dataStack;
			this.minStack = minStack;
		}

		public T push(T elem) {
			if (dataStack.isEmpty()) {
				dataStack.push(elem);
				minStack.push(elem);
				return elem;
			}
			if (elem.compareTo(minStack.peek()) > 0) {
				dataStack.push(elem);
			} else {
				dataStack.push(elem);
				minStack.push(elem);
			}
			return elem;
		}

		public T pop() {
			if (dataStack.isEmpty()) {
				return null;
			}
			if (dataStack.peek().compareTo(minStack.peek()) > 0) {
				return dataStack.pop();
			} else {
				minStack.pop();
				return dataStack.pop();
			}

		}

		public T getMin() {
			if (minStack.isEmpty()) {
				return null;
			}
			return minStack.peek();

		}

	}

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(5);
		System.out.println(stack.getMin());
		stack.push(4);
		System.out.println(stack.getMin());
		stack.push(6);
		System.out.println(stack.getMin());
		stack.push(4);
		System.out.println(stack.getMin());
		stack.pop();
		System.out.println(stack.getMin());
		stack.pop();
		System.out.println(stack.getMin());
		stack.pop();
		System.out.println(stack.getMin());
	}

}
