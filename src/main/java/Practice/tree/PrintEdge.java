package Practice.tree;

import Practice.algorithm.AbstractBaseTree;

public class PrintEdge extends AbstractBaseTree {

	public static void findEdgeMap(TreeNode root, int depthIndex, TreeNode[][] treeNodeMap) {
		if (root == null) {
			return;
		}
		treeNodeMap[depthIndex][0] = treeNodeMap[depthIndex][0] == null ? root : treeNodeMap[depthIndex][0];
		treeNodeMap[depthIndex][1] = root;
		findEdgeMap(root.left, depthIndex + 1, treeNodeMap);
		findEdgeMap(root.right, depthIndex + 1, treeNodeMap);
	}

	public static int getDepth(TreeNode root) {
		if (root == null) {
			return 1;
		}
		return Math.max(getDepth(root.left), getDepth(root.right));

	}

	public static void printEdge(TreeNode root) {
		if (root == null) {
			return;
		}
		int depth = getDepth(root);
		TreeNode[][] treeNodeMap = new TreeNode[depth][2];
		findEdgeMap(root, 0, treeNodeMap);
		// 打印最左几点
		for(int i=0;i< treeNodeMap.length;i++) {
			System.out.println(treeNodeMap[i][0]);
		}

		// 打印非最左 最右叶子节点

		// 打印 最右节点

	}
	
}
