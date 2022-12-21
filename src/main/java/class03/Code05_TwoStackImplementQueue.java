package class03;

import java.util.Stack;

/**
 * @author duanyixuan
 * @date 2022/12/20 10:23 PM
 * 使用栈实现队列功能
 */
public class Code05_TwoStackImplementQueue {
    public static class TwoStackQueue {
        private Stack<Integer> stackPush;
        private Stack<Integer> stackPop;

        public TwoStackQueue() {
            stackPop = new Stack<Integer>();
            stackPush = new Stack<Integer>();
        }

        private void pushToPop() {
            if (stackPop.isEmpty()) {
                while (!stackPush.isEmpty()) {
                    stackPop.push(stackPush.pop());
                }
            }
        }

        private void add(int pushNum) {
            stackPush.push(pushNum);
            pushToPop();
        }

        private int poll() {
            if (stackPop.isEmpty() && stackPush.isEmpty()) {
                throw new RuntimeException("Queue is empty!");
            }
            pushToPop();
            return stackPop.pop();
        }

        private int peek() {
            if (stackPop.isEmpty() && stackPush.isEmpty()) {
                throw new RuntimeException("Queue is empty!");
            }

            pushToPop();
            return stackPop.peek();
        }
    }

    public static void main(String[] args) {
        TwoStackQueue test = new TwoStackQueue();
        test.add(1);
        test.add(2);
        test.add(3);
        System.out.println(test.peek());
        System.out.println(test.poll());
        System.out.println(test.peek());
        System.out.println(test.poll());
        System.out.println(test.peek());
        System.out.println(test.poll());
    }
}
