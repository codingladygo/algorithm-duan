package class03;

/**
 * @author duanyixuan
 * @date 2022/12/19 10:15 PM
 */
public class Code02_DeleteGivenValue {
    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node removeValue(Node head, int num) {
        //先判断删除的数据是不是头节点，遍历循环到删除的不是第一个元素的位置
        while (head != null) {
            if (head.value != num) {
                break;
            }

            head = head.next;
        }

        Node pre = head;
        Node cur = head;

        while (cur != null) {
            if (cur.value == num) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
        }
        return head;
    }
}
