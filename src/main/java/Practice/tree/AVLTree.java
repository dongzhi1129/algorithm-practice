package Practice.tree;

public class AVLTree<T extends Comparable<T>> {

	private AVLTreeNode<T> root;

	public AVLTree(AVLTree<T>.AVLTreeNode<T> root) {
		super();
		this.root = root;
	}

	class AVLTreeNode<T extends Comparable<T>> {

		T val;

		AVLTreeNode<T> left;

		AVLTreeNode<T> right;

		int height;

		public AVLTreeNode(T val, AVLTreeNode<T> left, AVLTreeNode<T> right) {
			super();
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public int getHeight() {
		return height(root);
	}

	private int height(AVLTreeNode<T> node) {
		if (node == null) {
			return 0;
		}
		return node.height;
	}

	private AVLTreeNode<T> insert(AVLTreeNode<T> node, T val) {
		AVLTreeNode<T> newNode = null;
		if (node == null) {
			newNode = new AVLTreeNode(val, null, null);
		} else {
			if (node.val.compareTo(val) > 0) {
				//插入左子树
				node.left = insert(node.left,val);
				int leftHeight = height(node.left);
				int rightHeight = height(node.right);
				if(Math.abs(leftHeight -rightHeight) == 2) {
//					if() {
//						
//					}
					
				}
				
			} else if(node.val.compareTo(val) < 0) {
				//插入右边
			} else {
				//不允许插入
			}
			
		}
		return null;

	}

}
