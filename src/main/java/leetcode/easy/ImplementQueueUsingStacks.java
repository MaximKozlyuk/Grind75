package leetcode.easy;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class ImplementQueueUsingStacks {

    public final static class MyQueue {

        // todo this is dummy impl :)
        private final Queue<Integer> queue = new LinkedList<>();

        public MyQueue() {
        }

        /**
         * Pushes element x to the back of the queue.
         */
        public void push(int x) {
            queue.add(x);
        }

        /**
         * Removes the element from the front of the queue and returns it.
         */
        public int pop() {
            return queue.remove();
        }

        /**
         * Returns the element at the front of the queue.
         */
        public int peek() {
            return queue.peek();
        }

        /**
         * Returns true if the queue is empty, false otherwise.
         */
        public boolean empty() {
            try {
                queue.element();
            } catch (NoSuchElementException exp) {
                return true;
            }
            return false;
        }
    }

}
