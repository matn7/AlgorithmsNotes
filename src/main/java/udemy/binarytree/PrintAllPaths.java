package udemy.binarytree;

import java.util.ArrayList;
import java.util.List;

public class PrintAllPaths {

    public static void main(String[] args) {
        Tree.Node root = new Tree.Node(1);
        root.setLeftChild(new Tree.Node(2));
        root.setRightChild(new Tree.Node(3));
        root.getRightChild().setLeftChild(new Tree.Node(7));
        root.getRightChild().setRightChild(new Tree.Node(6));
        root.getRightChild().getLeftChild().setLeftChild(new Tree.Node(8));
        root.getRightChild().getLeftChild().setRightChild(new Tree.Node(5));
        root.getRightChild().getRightChild().setRightChild(new Tree.Node(4));

        List<Tree.Node<Integer>> paths = new ArrayList<>();
        printPaths(root, paths);
    }

    public static void printPaths(Tree.Node<Integer> root, List<Tree.Node<Integer>> pathList) {
        if (root == null) {
            return;
        }

        pathList.add(root);
        printPaths(root.getLeftChild(), pathList);
        printPaths(root.getRightChild(), pathList);

        if (root.getLeftChild() == null && root.getRightChild() == null) {
            print(pathList);
        }

        pathList.remove(root);
    }

    public static void printAllPathsMy(Tree.Node<Integer> root) {
        if (root == null) {
            return;
        }
        List<Tree.Node<Integer>> paths = new ArrayList<>();
        printAllPathsHelper(root, paths);
    }

    private static void printAllPathsHelper(Tree.Node<Integer> node, List<Tree.Node<Integer>> paths) {
        if (node == null) {
            return;
        }
        if (node.getLeftChild() == null && node.getRightChild() == null) {
            paths.add(node);
            print(paths);
            paths.remove(paths.size() - 1);
            return;
        }
        paths.add(node);
        printAllPathsHelper(node.getLeftChild(), paths);
        printAllPathsHelper(node.getRightChild(), paths);
        paths.remove(paths.size() - 1);
    }

    private static void print(List<Tree.Node<Integer>> paths) {
        for (Tree.Node<Integer> element : paths) {
            System.out.print(element.getData() + ", ");
        }
        System.out.println();
    }

}
