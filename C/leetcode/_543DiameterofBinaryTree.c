#include <stdio.h>  

struct TreeNode {
	int val;
	struct TreeNode  *left;
	struct TreeNode  *right;
};

int diameterOfBT(struct TreeNode*  root, int *overall) {
	if (root == NULL) {
		return 0;
	}

	int left = diameterOfBT(root->left, overall);
	int right = diameterOfBT(root->right, overall);
	if (*overall < left + right) {
		*overall = left + right;
	}

	if (left > right) {
		return left + 1;
	}
	return right + 1;
}

int diameterOfBinaryTree(struct TreeNode*  root) {
	int ans = 0;
	diameterOfBT(root, &ans);
	return ans;
}