package Practice.tree.binary;

import java.util.HashMap;
import java.util.Map;

import Practice.algorithm.AbstractBaseTree;

/**
 * 先序遍历和中序遍历恢复二叉树
 * 
 * @author weidong
 *
 */
public class BuildTree extends AbstractBaseTree {

	public static TreeNode buildTree(int[] inorder, int[] postorder) {
		if (postorder == null || inorder == null) {
			return null;
		}
		Map<Integer, Integer> rootIndexMap = new HashMap<>();
		for (int i = 0; i < inorder.length; i++) {
			rootIndexMap.put(inorder[i], i);
		}
		return buildTree(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1, rootIndexMap);
	}

	private static  TreeNode buildTree(int[] inorder, int[] postorder, int inorderStartIndex, int inorderEndIndex,
			int postorderStartIndex, int postorderEndIndex, Map<Integer, Integer> rootIndexMap) {
		if (inorderStartIndex > inorderEndIndex || postorderStartIndex > postorderEndIndex) {
			return null;
		}
		int rootIndex = rootIndexMap.get(postorder[postorderEndIndex]);
		TreeNode root = new TreeNode(postorder[postorderEndIndex], null, null);
		int rigntTreeSize = inorderEndIndex - rootIndex;
		root.left = buildTree(inorder, postorder, inorderStartIndex, rootIndex - 1, postorderStartIndex,
				postorderEndIndex - rigntTreeSize - 1, rootIndexMap);
		root.right = buildTree(inorder, postorder, rootIndex + 1, inorderEndIndex, postorderEndIndex - rigntTreeSize,
				postorderEndIndex - 1, rootIndexMap);
		return root;

	}
	
	public static void main(String[] args) {
		int[] inorder = {9,3,15,20,7};
		int[] postorder = {9,15,7,20,3};
		buildTree(inorder, postorder);
	}

}
