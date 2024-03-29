package leetcode.editor.cn;//给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位
//。 
//
// 返回 滑动窗口中的最大值 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
//输出：[3,3,5,5,6,7]
//解释：
//滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], k = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 1 <= k <= nums.length 
// 
//
// Related Topics 队列 数组 滑动窗口 单调队列 堆（优先队列） 👍 2228 👎 0


import com.lc.structure.MaxPQ;

import java.util.Deque;
import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution239 {

    // todo-ly 2023/5/5 21:48
//    public int[] maxSlidingWindow(int[] nums, int k) {
//
//    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        MonotonicQueue window = new MonotonicQueue();
        for (int i = 0;i < n;++i) {
            //k - 1个元素
            if (i < k - 1) {
                window.push(nums[i]);
            }else {
                window.push(nums[i]);
                res[i - k + 1] = window.max();
                window.pop(nums[i - k + 1]);
            }
        }
        return res;
    }

    // todo-ly 2023/5/5 22:12  
    /**单调队列*/
    class MonotonicQueue {
        Deque<Integer> queue = new LinkedList<>();

        /**移除比当前元素小的*/
        public void push(int n) {
            while (!queue.isEmpty() && queue.peekLast() < n) queue.removeLast();
            queue.addLast(n);
        }

        /**队头元素最大*/
        public int max() {
            return queue.getFirst();
        }

        /**出队元素值等于最大元素值才删除 因为其他情况不影响队列的最大值*/
        public void pop(int n) {
            if (n == queue.getFirst()) {
                queue.removeFirst();
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
