package com.swayam.practice.algos.tree.bfs;

class TreeNode {

    private final String text;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("TreeNode [text=");
        builder.append(text);
        builder.append("]");
        return builder.toString();
    }

}