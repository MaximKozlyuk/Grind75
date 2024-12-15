package leetcode.medium;

import java.util.*;

public class CloneGraph {

    // can't change
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    /**
     * https://leetcode.com/problems/clone-graph/
     */
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        var clones = new HashMap<Integer, Node>();
        var queue = new LinkedList<Node>();
        queue.add(node);
        clones.put(node.val, new Node(node.val));

        while(!queue.isEmpty()) {
            var current = queue.poll();
            var currentCloneNeighbour = clones.get(current.val).neighbors;
            for (Node neighbour : current.neighbors) {
                if (!clones.containsKey(neighbour.val)) {
                    clones.put(neighbour.val, new Node(neighbour.val));
                    queue.add(neighbour);
                }
                currentCloneNeighbour.add(
                        clones.get(neighbour.val)
                );
            }
        }

        return clones.get(node.val);
    }

}
