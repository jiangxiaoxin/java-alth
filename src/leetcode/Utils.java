package leetcode;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

public class Utils {

    public static List<Integer> stringToIntegerList(String input) {
        JSONArray jsonArray = JSON.parseArray(input);
        List<Integer> arr = new ArrayList<>(jsonArray.size());
        for (int i = 0; i < jsonArray.size(); i++) {
            arr.add(jsonArray.getInteger(i));
        }
        return arr;
    }

    public static ListNode stringToListNode(String input) {
        JSONArray array = JSON.parseArray(input);
        ListNode flag = new ListNode();
        ListNode current = flag;
        for(int i=0;i<array.size();i++) {
            int val = array.getIntValue(i);
            ListNode node = new ListNode(val);
            current.next = node;
            current = node;
        }
        return flag.next;
    }

    public static String printListNodes(ListNode head) {
        StringBuilder builder = new StringBuilder();
        ListNode current = head;
        while(current != null) {
            builder.append(current.val);
            builder.append(",");
            current = current.next;
        }
        System.out.println(builder.toString());
        return builder.toString();
    }


    /**
     *将类似 [[2],[3,4],[6,5,7],[4,1,8,3]] 的字符串转成2维list
     * @param input
     * @return
     */
    public static List<List<Integer>> stringToInt2dList(String input) {
        JSONArray jsonArray = JSON.parseArray(input);
        if(jsonArray.size() == 0) {
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> list = new ArrayList<>(jsonArray.size());
        for(int i=0;i<jsonArray.size();i++) {
           JSONArray cols = jsonArray.getJSONArray(i);
           list.add(stringToIntegerList(cols.toString()));
        }
        return list;
    }

    /**
     * [[100,-42,-46,-41],[31,97,10,-10],[-58,-51,82,89],[51,81,69,-51]]
     * 字符串转2维m*n数组
     * @param input
     * @return
     */
    public static int[][] stringToInt2dArray(String input) {
        JSONArray jsonArray = JSON.parseArray(input);
        if(jsonArray.size() == 0) {
            return new int[0][0];
        }
        int m = jsonArray.size();
        int[][] matrix = new int[m][];
        for(int i=0;i<m;i++) {
            JSONArray cols = jsonArray.getJSONArray(i);
            int n = cols.size();
            int[] array = new int[n];
            for(int j=0;j<n;j++) {
                array[j] = cols.getIntValue(j);
            }
            matrix[i] = array;
        }
        return matrix;
    }

    /**
     * 转成char类型的2维数组
     * input格式有要求
     * input = "['1','2']" 这样的格式才能通过。全部用 "" 不行.或者中间的""要加\ 转义符号
     */
    public static char[][] stringToChar2dArray(String input) {
        JSONArray jsonArray = JSON.parseArray(input);
        if(jsonArray.size() == 0) {
            return new char[0][0];
        }
        int m = jsonArray.size();
        char[][] matrix = new char[m][];
        for(int i=0;i<m;i++) {
            JSONArray cols = jsonArray.getJSONArray(i);
            int n = cols.size();
            char[] array = new char[n];
            for(int j=0;j<n;j++) {
                array[j] = cols.getObject(j, char.class);
            }
            matrix[i] = array;
        }
        return matrix;
    }

    /**
     * 将字符串转成tree 格式。[3,9,20,null,null,15,7]
     * @param input
     * @return
     */
    public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }

    public static String treeNodeToString(TreeNode root) {
        if (root == null) {
            return "[]";
        }

        String output = "";
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (node == null) {
                output += "null, ";
                continue;
            }

            output += String.valueOf(node.val) + ", ";
            nodeQueue.add(node.left);
            nodeQueue.add(node.right);
        }
        return "[" + output.substring(0, output.length() - 2) + "]";
    }
}
