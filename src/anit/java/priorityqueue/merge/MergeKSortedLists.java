/**
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 *
 * Merge all the linked-lists into one sorted linked-list and return it.
 */

import java.util.*;
class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {

        if(lists == null || lists.length == 0)
            return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(
                (a, b) -> a.val - b.val
        );
        for(ListNode node : lists)
            if(node != null)
                queue.offer(node);
        ListNode result = null, curr = null;
        while(!queue.isEmpty()) {
            ListNode node = queue.poll();
            if(result == null)
                result = node;
            else
                curr.next = node;
            curr = node;
            if(node.next != null)
                queue.offer(node.next);
        }
        return result;
    }
}