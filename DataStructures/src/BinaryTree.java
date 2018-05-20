import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;

public class BinaryTree<E extends Comparable<E>> {
	TreeNode<E> root;

	/**
	 * Recursively determines whether an item is contained within the tree
	 * 
	 * @param item
	 * @return
	 */
	boolean contains(E item) {
		TreeNode<E> current = root;
		return findItem(current, item);
	}

	boolean findItem(TreeNode<E> start, E item) {
		if (start == null)
			return false;
		return start.getData().compareTo(item) == 0
				|| findItem(start.getLeft(), item)
				|| findItem(start.getRight(), item);
	}

	/**
	 * Recursively finds the size of a binary tree
	 * 
	 * @return
	 */
	int size() {
		TreeNode<E> current = root;
		return findSize(current);
	}

	int findSize(TreeNode<E> start) {
		if (start == null)
			return 0;
		return 1 + findSize(start.getLeft()) + findSize(start.getRight());
	}

	/**
	 * Adds a TreeNode to the tree
	 * 
	 * @param item
	 */
	void add(E item) {
		if (item != null) {
			TreeNode<E> current = root;
			if (current == null) {
				root = new TreeNode<E>(item);
			} else {
				boolean found = false;
				while (!found) {
					if (item.compareTo(current.getData()) < 0) {
						if (current.getLeft() != null)
							current = current.getLeft();
						else
							found = true;
					} else {
						if (current.getRight() != null)
							current = current.getRight();
						else
							found = true;
					}
				}
				if (item.compareTo(current.getData()) < 0) {
					current.setLeft(new TreeNode<E>(item));
				} else
					current.setRight(new TreeNode<E>(item));

			}
		}
	}

	private void add(TreeNode<E> node) {
		TreeNode<E> current = root;
		if (current == null) {
			root = node;
		} else {
			boolean found = false;
			while (!found) {
				if (node.getData().compareTo(current.getData()) < 0) {
					if (current.getLeft() != null)
						current = current.getLeft();
					else
						found = true;
				} else {
					if (current.getRight() != null)
						current = current.getRight();
					else
						found = true;
				}
			}
			if (node.getData().compareTo(current.getData()) < 0) {
				current.setLeft(node);
			} else
				current.setRight(node);

		}
	}

	/*
	 * boolean remove(E item) { TreeNode<E> current = root; if (!contains(item))
	 * return false; else { if (root.getData().compareTo(item) == 0) {
	 * TreeNode<E> left = root.getLeft(); if (root.getRight() != null) {
	 * 
	 * root = root.getRight(); add(left); } else { root = left; } } else{
	 * boolean found = false; while (!found) { if
	 * (item.compareTo(current.getData()) < 0) { if (current.getLeft() != null)
	 * current = current.getLeft(); else found = true; } else { if
	 * (current.getRight() != null) current = current.getRight(); else found =
	 * true; } } if (item.compareTo(current.getData()) > 0) { TreeNode<E>
	 * rightLeft = current.getRight().getLeft();
	 * current.setRight(right.getRight());
	 * 
	 * } else current.setRight(node); } } }
	 */
	boolean isEmpty() {
		return root == null;
	}

	public void print() {
		TreeNode<E> current = root;
	//	BTreePrinter.printTreeNode(current);
	}
}


/**
 * Internal method to remove from a subtree.
 * @param x the item to remove.
 * @param t the node that roots the tree.
 * @return the new root.
 *
private TreeNode<E> remove( TreeNode<E> x, TreeNode<E> t )
{
    if( t == null )
        return t;   // Item not found; do nothing
    if( x.compareTo( t.getData() ) < 0 )
        t.getLeft() = remove( x, t.getLeft() );
    else if( x.compareTo( t.getData() ) > 0 )
        t.getRight() = remove( x, t.getRight() );
    else if( t.getLeft() != null && t.getRight() != null ) // Two children
    {
        t.setData(mindMin( t.getRight() ).getData());
        t.setRight(remove( t.getData(), t.getRight() ));
    }
    else
        t = ( t.getLeft() != null ) ? t.getLeft() : t.getRight();
    return t;
}
  */
/*
 * class BTreePrinter {
 * 
 * public static <E extends Comparable<E>> void printTreeNode(TreeNode<E> root)
 * { int maxLevel = BTreePrinter.maxLevel(root);
 * 
 * printTreeNodeInternal( new
 * ArrayList<TreeNode<E>>(Collections.singletonList(root)), 1, maxLevel); }
 * 
 * private static <E extends Comparable<E>> void printTreeNodeInternal(
 * ArrayList<TreeNode<E>> TreeNodes, int level, int maxLevel) { if
 * (TreeNodes.isEmpty() || BTreePrinter.isAllElementsNull(TreeNodes)) return;
 * 
 * int floor = maxLevel - level; int endgeLines = (int) Math.pow(2,
 * (Math.max(floor - 1, 0))); int firstSpaces = (int) Math.pow(2, (floor)) - 1;
 * int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;
 * 
 * BTreePrinter.printWhitespaces(firstSpaces);
 * 
 * ArrayList<TreeNode<E>> newTreeNodes = new ArrayList<TreeNode<E>>(); for
 * (TreeNode<E> TreeNode : TreeNodes) { if (TreeNode != null) {
 * System.out.print(TreeNode.getData()); newTreeNodes.add(TreeNode.getLeft());
 * newTreeNodes.add(TreeNode.getRight()); } else { newTreeNodes.add(null);
 * newTreeNodes.add(null); System.out.print(" "); }
 * 
 * BTreePrinter.printWhitespaces(betweenSpaces); } System.out.println("");
 * 
 * for (int i = 1; i <= endgeLines; i++) { for (int j = 0; j < TreeNodes.size();
 * j++) { BTreePrinter.printWhitespaces(firstSpaces - i); if (TreeNodes.get(j)
 * == null) { BTreePrinter.printWhitespaces(endgeLines + endgeLines + i + 1);
 * continue; }
 * 
 * if (TreeNodes.get(j).getLeft() != null) System.out.print("/"); else
 * BTreePrinter.printWhitespaces(1);
 * 
 * BTreePrinter.printWhitespaces(i + i - 1);
 * 
 * if (TreeNodes.get(j).getRight() != null) System.out.print("\\"); else
 * BTreePrinter.printWhitespaces(1);
 * 
 * BTreePrinter.printWhitespaces(endgeLines + endgeLines - i); }
 * 
 * System.out.println(""); }
 * 
 * printTreeNodeInternal(newTreeNodes, level + 1, maxLevel); }
 * 
 * private static void printWhitespaces(int count) { for (int i = 0; i < count;
 * i++) System.out.print(" "); }
 * 
 * private static <E extends Comparable<E>> int maxLevel(TreeNode<E> TreeNode) {
 * if (TreeNode == null) return 0;
 * 
 * return Math.max(BTreePrinter.maxLevel(TreeNode.getLeft()),
 * BTreePrinter.maxLevel(TreeNode.getRight())) + 1; }
 * 
 * private static <E> boolean isAllElementsNull(ArrayList<E> list) { for (Object
 * object : list) { if (object != null) return false; }
 * 
 * return true; }
 * 
 * }
 */