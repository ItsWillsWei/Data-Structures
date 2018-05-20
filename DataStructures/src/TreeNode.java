
public class TreeNode<E extends Comparable<E>> {
	private TreeNode<E> left;
	private TreeNode<E> right;
	private E data;
	
	TreeNode(E data){
		this.data = data;
	}
	
	void setLeft(TreeNode<E> left){
		this.left = left;
	}
	TreeNode<E> getLeft(){
		return left;
	}
	
	void setRight(TreeNode<E> right){
		this.right = right;
	}
	TreeNode<E> getRight(){
		return right;
	}
	
	void setData(E data){
		this.data = data;
	}
	E getData(){
		return data;
	}
	
	boolean isLeaf(){
		return left == null && right == null;
	}

}
