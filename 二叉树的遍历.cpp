//1.先序遍历
//先访问根节点，然后访问左节点，再访问右节点
void preOrder(TNode* root)
{
	if(root != NULL)
	{
		Visit(root);
		preOrder(root->left);
		preOrder(root->left);
	}
}