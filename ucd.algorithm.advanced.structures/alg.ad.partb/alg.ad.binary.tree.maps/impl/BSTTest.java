package impl;

public class BSTTest {
//	Part1 question b

	public static void main(String[] args) {
		BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
		//Printing state of tree after each operation
		tree.insert(24);
		System.out.println(tree);
		
		tree.insert(12);
		System.out.println(tree);
		
		tree.insert(36);
		System.out.println(tree);
		
		tree.insert(5);
		System.out.println(tree);
		
		tree.insert(7);
		System.out.println(tree);
		
		tree.insert(2);
		System.out.println(tree);
		
		tree.insert(76);
		System.out.println(tree);
		
		tree.remove(24);
		System.out.println(tree);
		
		tree.insert(18);
		System.out.println(tree);
		
		System.out.println("State of tree after last operation matching partB");
		
		tree.insert(24);
		System.out.println(tree);
	
		
	}

}
