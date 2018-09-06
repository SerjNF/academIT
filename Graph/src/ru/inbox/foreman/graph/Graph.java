package ru.inbox.foreman.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;
import java.util.function.IntConsumer;

public class Graph {
    private int[][] nodes;

    public Graph(int[][] nodes) {
        this.nodes = nodes;
    }

    public void visitDepthFirst(IntConsumer consumer) {
        boolean[] visitedNodes = new boolean[nodes.length];
        ArrayList<Integer> stack = new ArrayList<>();

        for (int k = 0; k < nodes.length; k++) {
            if (!visitedNodes[k]) {
                stack.add(k);

                while (!stack.isEmpty()) {
                    int currentNode = stack.remove(stack.size() - 1);
                    if (!visitedNodes[currentNode]) {
                        consumer.accept(currentNode);
                        visitedNodes[currentNode] = true;

                        int[] currentNodeLinks = nodes[currentNode];
                        for (int j = currentNodeLinks.length - 1; j >= 0; j--) {
                            if (currentNodeLinks[j] == 1 && !visitedNodes[j]) {
                                stack.add(j);
                            }
                        }
                    }
                }
            }
        }
    }

    public void visitBreadthFirst(IntConsumer consumer) {
        boolean[] visitedNodes = new boolean[nodes.length];
        Queue<Integer> queue = new ArrayDeque<>();

        for (int k = 0; k < nodes.length; k++) {
            if (!visitedNodes[k]) {
                queue.add(k);

                while (queue.size() != 0) {
                    int currentNode = queue.remove();
                    if (!visitedNodes[currentNode]) {
                        consumer.accept(currentNode);
                        visitedNodes[currentNode] = true;

                        int[] currentNodeLinks = nodes[currentNode];
                        for (int j = 0; j < currentNodeLinks.length; j++) {
                            if (currentNodeLinks[j] == 1 && !visitedNodes[j]) {
                                queue.add(j);
                            }
                        }
                    }
                }
            }
        }
    }

    public void visitDepthFirstRecurs(IntConsumer consumer) {
        boolean[] visitedNodes = new boolean[nodes.length];

        for (int k = 0; k < nodes.length; k++) {
            if (!visitedNodes[k]) {
                visitRecurs(consumer, k, visitedNodes);
            }
        }
    }

    private void visitRecurs(IntConsumer consumer, int node, boolean[] visitedNodes) {
        consumer.accept(node);
        visitedNodes[node] = true;
        int[] array = nodes[node];

        for (int i = 0; i < array.length; i++) {
            if (nodes[node][i] == 1 && !visitedNodes[i]) {
                visitRecurs(consumer, i, visitedNodes);
            }
        }
    }
}



