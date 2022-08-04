package com.cb.binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
 * Queue
 * Time: O(n*n)
 * Space: O(n*) for Stack
 * */
public class BT15_ConstructBinaryTreeFromStringWithBracket {

    // construct tree
    private static Node constructTree(String str, int start, int end) {

        if (start == end)
            return new Node(Integer.parseInt(String.valueOf(str.charAt(start))));

        Stack<Character> stack = new Stack<>();
        stack.add(str.charAt(start + 1));
        int i = start + 2;
        for (; i <= end; i++) {
            if (str.charAt(i) == '(')
                stack.add(str.charAt(i));
            else if (str.charAt(i) == ')') {
                if (stack.peek() == '(') {
                    stack.pop();

                    if (stack.isEmpty())
                        break;
                }
            }
        }

        Node node = new Node(Integer.parseInt(String.valueOf(str.charAt(start))));
        node.left = constructTree(str, start + 2, i - 1);

        if ((i + 1 <= end) && str.charAt(i + 1) == '(')
            node.right = constructTree(str, i + 2, end - 1);

        return node;
    }

    public static void main(String[] args) {
        String str = "4(2(3)(1))(6(5))";
        Node root = constructTree(str, 0, str.length() - 1);
        traverseLevelOrder(root);
    }

    // User by traverseLevelOrder()
    private static Queue<Node> queue = new LinkedList<>();

    // just to print the binary tree
    private static void traverseLevelOrder(Node<Integer> tree) {
        queue.add(tree);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.print(node.data + ",");
            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);
        }
    }

    // tree-node
    static class Node<T> {
        Node left;
        Node right;
        T data;

        public Node(T data) {
            this.data = data;
        }
    }
}
