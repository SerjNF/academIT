package ru.inbox.foreman.test;

import org.junit.Before;
import org.junit.Test;
import ru.inbox.foreman.graf.Graph;

import java.util.Arrays;

public class GraphTest {
    private Graph testGraph;

    @Before
    public void createField() {
        testGraph = new Graph(new int[][]{{0, 0, 0, 0, 0, 0, 0},
                                          {0, 0, 1, 1, 1, 1, 0},
                                          {0, 1, 0, 0, 0, 0, 1},
                                          {0, 1, 0, 0, 0, 0, 0},
                                          {0, 1, 0, 0, 0, 1, 0},
                                          {0, 1, 0, 0, 1, 0, 1},
                                          {0, 0, 1, 0, 0, 1, 0}});

    }

    @Test
    public void testVisitDepthFirst() {
       testGraph.visitDepthFirst(this::printNodes);
        System.out.println();
    }
    @Test
    public void testVisitBreadthFirst() {
       testGraph.visitBreadthFirst(this::printNodes);
        System.out.println();
    }

    private void printNodes(int[] node) {
        System.out.println(Arrays.toString(node));
    }
}
