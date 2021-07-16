package Practice.tree.binary;

import java.util.HashMap;
import java.util.Map;

import Practice.algorithm.AbstractBaseTree;

/**
 * 先序遍历和中序遍历恢复二叉树
 * @author weidong
 *
 */
public class PostorderAndInorderBuildTree extends AbstractBaseTree {

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder == null || inorder == null) {
			return null;
		}
		Map<Integer, Integer> rootIndexMap = new HashMap<>();
		for (int i = 0; i < inorder.length; i++) {
			rootIndexMap.put(inorder[i], i);
		}
		return buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1, rootIndexMap);

	}

	private TreeNode buildTree(int[] preorder, int[] inorder, int preorderStartIndex, int preorderEndIndex,
			int inorderStartIndex, int inorderEndIndex, Map<Integer, Integer> rootIndexMap) {
		if (preorderStartIndex > preorderEndIndex) {
			return null;
		}
		int rootValue = preorder[preorderStartIndex];
		TreeNode root = new TreeNode(rootValue, null, null);
		int rootIndex = rootIndexMap.get(rootValue);
		int leftTreeSize = rootIndex - inorderStartIndex;
		root.left = buildTree(preorder, inorder, preorderStartIndex + 1, preorderStartIndex + leftTreeSize,
				inorderStartIndex, rootIndex - 1, rootIndexMap);
		root.right = buildTree(preorder, inorder, preorderStartIndex + leftTreeSize + 1, preorderEndIndex,
				rootIndex + 1, inorderEndIndex, rootIndexMap);
		return root;

	}

}
