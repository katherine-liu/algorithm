package com.leetcode;

import jdk.nashorn.api.tree.Tree;

import java.util.List;
import java.util.ArrayList;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode (int x) { val = x; }
}

public class BinaryTreeRightSideView {

    public static void main(String[] args) {
        TreeNode tr = new TreeNode(0);
        TreeNode tr1 = new TreeNode(1);
        TreeNode tr2 = new TreeNode(2);
        TreeNode tr3 = new TreeNode(3);
        TreeNode tr4 = new TreeNode(4);
        TreeNode tr5 = new TreeNode(5);
        TreeNode tr6 = new TreeNode(6);
        TreeNode tr7 = new TreeNode(7);

        tr.left = tr1;
        tr1.right = tr2;
        tr2.left = tr3;
        tr.right = tr4;
        tr4.left = tr5;
        tr5.left = tr6;
        tr6.right = tr7;

        BinaryTreeRightSideView btrsv = new BinaryTreeRightSideView();
        btrsv.rightSideView(tr);
    }

    public List<Integer> rightSideView(TreeNode root) {

        List<TreeNode> childNode = new ArrayList<>();
        List<Integer> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        childNode.add(root);

        TreeNode curNode;

        while(!childNode.isEmpty()) {

            int size = childNode.size();

            for (int i = 0 ; i < size; i++) {
                curNode = childNode.get(0);
                childNode.remove(0);

//                System.out.print(curNode.val);

                if (curNode.left != null) {
                    childNode.add(curNode.left);
                }
                if (curNode.right != null) {
                    childNode.add(curNode.right);
                }
                if (i == size - 1) res.add(curNode.val);
            }
            System.out.println();
        }

        print(res);

        return res;
    };

    public void print(List<Integer> arr) {
        int i = 0;
        while(i < arr.size()) {
            System.out.println(arr.get(i));
            i++;
        }
    }

}
