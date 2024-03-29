package leetcode.editor.cn;//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1], n = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2], n = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中结点的数目为 sz 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
//
// 
//
// 进阶：你能尝试使用一趟扫描实现吗？ 
//
// Related Topics 链表 双指针 👍 2309 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution19 {

    // todo-ly 2023/5/15 15:49  
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode _head = new ListNode(0);
        _head.next = head;
        ListNode slow = _head, fast = _head;
        for (int i = 0;i < n;++i) {
            fast = fast.next;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast =fast.next;
        }
        slow.next = slow.next.next;
        return _head.next;
    }
    
//    public ListNode removeNthFromEnd(ListNode head, int n) {
//        ListNode dummy = new ListNode(-1);
//        dummy.next = head;
//        ListNode pre = findNthFromEnd(dummy, n + 1);
//        pre.next = pre.next.next;
//        return dummy.next;
//    }
//
//    /**
//     * 查找第k个节点
//      * @param head
//     * @param k
//     * @return
//     */
//    private ListNode findNthFromEnd(ListNode head, int k) {
//        ListNode p1 = head;
//        ListNode p2 = head;
//        for(int i = 0;i < k;++i) {
//            p1 = p1.next;
//        }
//        while(p1 != null) {
//            p1 = p1.next;
//            p2 = p2.next;
//        }
//        return p2;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
