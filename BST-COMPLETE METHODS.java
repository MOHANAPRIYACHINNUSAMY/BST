import java.util.Scanner;
import java.util.*;
class TreeNode{
    int data;
    TreeNode left;
    TreeNode right;
    public TreeNode(int d)
    {
        data=d;
        left=null;
        right=null;
    }
}

class BinarySearchTree
{
    TreeNode root=null;
    void insert(int d)
    {
        root=insert(root,d);
    }
    
    TreeNode insert(TreeNode curr,int d)
    {
        if(curr == null)
        {
            TreeNode node=new TreeNode(d);
            return node;
        }
        if(curr.data > d)
        {
            curr.left=insert(curr.left,d);
        }
        else
        {
            curr.right=insert(curr.right, d);
        }
        return curr;
    }
    void in_order()
    {
        in_order(root);
    }
    void in_order(TreeNode curr)
    {
        if(curr == null)
        {
            return;
        }
        in_order(curr.left);
        System.out.print(curr.data +" ");
        in_order(curr.right);
        
        
    }
    
     void pre_order()
    {
        pre_order(root);
    }
    void pre_order(TreeNode curr)
    {
        if(curr == null)
        {
            return;
        }
        System.out.print(curr.data +" ");
        pre_order(curr.left);
        pre_order(curr.right);
    }
    
     void post_order()
    {
        post_order(root);
    }
    void post_order(TreeNode curr)
    {
        if(curr == null)
        {
            return;
        }
        post_order(curr.left);
        post_order(curr.right);
        System.out.print(curr.data +" ");
    }
    
    boolean search(int key)
    {
        return search(key,root);
    }
    boolean search(int key,TreeNode curr)
    {
        if(curr==null)
        {
            return false;
        }
        else if(key == curr.data)
        {
            return true;
        }
        else if(key < curr.data)
        {
            return search(key,curr.left);
        }
        else
        {
            return search(key,curr.right);
        }
    }
   
    
    void level_order()
    {
        Queue<TreeNode> que=new LinkedList<>();
        que.offer(root);
        while(!que.isEmpty())
        {
            TreeNode curr =que.remove();
            System.out.print(curr.data +" ");
            if(curr.left != null)
            {
                que.offer(curr.left);
            }
            if(curr.right != null)
            {
                que.offer(curr.right);
            }
        }
    }
}

public class Main
{
    public static void main (String[] args)
    {
        BinarySearchTree bst=new BinarySearchTree();
        bst.insert(70);
        bst.insert(30);
        bst.insert(80);
        bst.insert(20);
        bst.insert(10);
        bst.insert(90);
        bst.insert(70);
        bst.insert(10);
        bst.insert(5);
        bst.in_order();
        System.out.println();
        bst.pre_order();
        System.out.println();
        bst.post_order();
        System.out.println();
        System.out.println(bst.search(70));
        bst.level_order();
}
}

