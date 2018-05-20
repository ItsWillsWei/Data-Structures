public class Test {
	public static void testSLinkedList() {
		// SimpleLinkedList
		SLinkedList<String> names = new SLinkedList<String>();
		System.out.println("Testing SimpleLinkedList");
		// Add
		for (char letter = 'A'; letter <= 'Z'; letter++) {
			names.add(letter + "A");
		}

		// Size
		System.out.println(names.size() + " " + names.sizeR() + " " + names);

		// Remove i
		for (int i = 24; i > 12; i--) {
			names.remove(i);
		}
		System.out.println(names.size() + " " + names.sizeR() + " " + names);

		// Remove E
		names.remove("AA");
		names.remove("BA");
		names.remove("MA");
		names.remove("ZA");
		names.remove("XX");
		System.out.println(names.size() + " " + names.sizeR() + " " + names);

		// IndexOf
		System.out.print(names.indexOf("CA") + " ");
		System.out.print(names.indexOf("DA") + " ");
		System.out.print(names.indexOf("EA") + " ");
		System.out.print(names.indexOf("FA") + " ");
		System.out.print(names.indexOf("KA") + " ");
		System.out.print(names.indexOf("LA") + " ");
		System.out.println(names.indexOf("XX"));

		// Get
		System.out.print(names.get(0) + " ");
		System.out.print(names.get(1) + " ");
		System.out.print(names.get(2) + " ");
		System.out.print(names.get(3) + " ");
		System.out.print(names.get(8) + " ");
		System.out.print(names.get(9) + " ");
		System.out.println(names.get(-1));
	}

	public static void testDLinkedList() {
		// SimpleLinkedList
		DLinkedList<String> names = new DLinkedList<String>();
		System.out.println("Testing DoublyLinkedList");
		// Add
		for (char letter = 'A'; letter <= 'Z'; letter++) {
			names.add(letter + "A");
		}

		// Size
		System.out.println(names.size() + " " + names.sizeR() + " " + names);

		// Remove i
		for (int i = 24; i > 12; i--) {
			names.remove(i);
		}
		System.out.println(names.size() + " " + names.sizeR() + " " + names);

		// Remove E
		names.remove("AA");
		names.remove("BA");
		names.remove("MA");
		names.remove("ZA");
		names.remove("XX");
		System.out.println(names.size() + " " + names.sizeR() + " " + names);

		// IndexOf
		System.out.print(names.indexOf("CA") + " ");
		System.out.print(names.indexOf("DA") + " ");
		System.out.print(names.indexOf("EA") + " ");
		System.out.print(names.indexOf("FA") + " ");
		System.out.print(names.indexOf("KA") + " ");
		System.out.print(names.indexOf("LA") + " ");
		System.out.println(names.indexOf("XX"));

		// Get
		System.out.print(names.get(0) + " ");
		System.out.print(names.get(1) + " ");
		System.out.print(names.get(2) + " ");
		System.out.print(names.get(3) + " ");
		System.out.print(names.get(8) + " ");
		System.out.print(names.get(9) + " ");
		System.out.println(names.get(-1));

		// Get first and last
		System.out.println(names.getFirst() + " " + names.getLast());
	}

	public static void testStack() {
		Stack<String> names = new Stack<String>();

		// Push
		for (char letter = 'A'; letter <= 'Z'; letter++) {
			names.push(letter + "A");
		}

		// Print
		System.out.println(names.size() + " " + names);
		System.out.println(names.pop());
		System.out.println(names.size() + " " + names);
		names.push("Hello World!");
		System.out.println(names.size() + " " + names);

		// Popping
		for (int i = 0; i < 28; i++)
			System.out.print(names.pop() + " ");
		System.out.println("\n" + names);
	}

	public static void testQueue() {
		Queue<String> names = new Queue<String>();

		// Enqueuing
		for (char letter = 'A'; letter <= 'Z'; letter++) {
			names.enqueue(letter + "A");
		}

		// Print
		System.out.println(names.size() + " " + names);
		System.out.println(names.dequeue());
		System.out.println(names.size() + " " + names);
		names.enqueue("Hello World!");
		System.out.println(names.size() + " " + names);

		// Dequeuing
		for (int i = 0; i < 28; i++)
			System.out.print(names.dequeue() + " ");
		System.out.println("\n" + names);
	}
	
	public static void testPriorityQueue(){
		PriorityQueue<String> names = new PriorityQueue<String>();
		
		for (char letter = 'A'; letter <= 'G'; letter++) {
			names.enqueue(letter + "A", 3);
		}
		for (char letter = 'H'; letter <= 'P'; letter++) {
			names.enqueue(letter + "A", 6);
		}
		for (char letter = 'Q'; letter <= 'Z'; letter++) {
			names.enqueue(letter + "A", 9);
		}
		
		System.out.println(names.size() + " " + names);
	}
	
	public static void testBinaryTree(){
		BinaryTree<String> names = new BinaryTree<String>();
		names.add("MA");
		
		for (char letter = 'A'; letter <= 'Z'; letter++) {
			names.add(letter + "A");
		}
		
		System.out.println(names.size());
		System.out.println(names.contains("MA"));
		System.out.println(names.contains("BA"));
		System.out.println(names.contains("SA"));
		System.out.println(names.contains("GA"));
		System.out.println(names.contains("XX"));
		System.out.println(names.contains("YY"));
		System.out.println(names.contains("ZZ"));
		
		names.print();
		
	}

	public static void main(String[] args) {
		// testSLinkedList();

		// testDLinkedList();

		// testStack();

		// testQueue();
		
		//testPriorityQueue();
		
		testBinaryTree();
	}

}
