package ru.inbox.foreman.graf;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;
import java.util.function.Consumer;

public class Graph {
    private int[][] nodes;

    public Graph(int[][] nodes) {
        this.nodes = nodes;
    }

    public void visitDepthFirst(Consumer<int[]> consumer) {
        boolean[] visitedNodes = new boolean[nodes.length];
        Stack<int[]> stack = new Stack<>();

        for (int k = 0; k < nodes.length; k++) {
            if (!visitedNodes[k]) {
                stack.add(nodes[k]);
                visitedNodes[k] = true;

                while (!stack.empty()) {
                    int[] currentNodeLinks = stack.pop();
                    consumer.accept(currentNodeLinks);

                    for (int j = currentNodeLinks.length - 1; j >= 0; j--) {
                        if (currentNodeLinks[j] == 1 && !visitedNodes[j]) {
                            stack.add(nodes[j]);
                            visitedNodes[j] = true;
                        }
                    }
                }
            }
        }
    }

    public void visitBreadthFirst(Consumer<int[]> consumer) {
        boolean[] visitedNodes = new boolean[nodes.length];
        Queue<int[]> stack = new ArrayDeque<>();

        for (int k = 0; k < nodes.length; k++) {
            if (!visitedNodes[k]) {
                stack.add(nodes[k]);
                visitedNodes[k] = true;

                while (stack.size() != 0) {
                    int[] currentNodeLinks = stack.remove();
                    consumer.accept(currentNodeLinks);

                    for (int j = 0; j < currentNodeLinks.length; j++) {
                        if (currentNodeLinks[j] == 1 && !visitedNodes[j]) {
                            stack.add(nodes[j]);
                            visitedNodes[j] = true;
                        }
                    }
                }
            }
        }
    }
}



