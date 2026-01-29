package leetcode;

import basic.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 文件组合_180 {

    /**
     * 待传输文件被切分成多个部分，按照原排列顺序，每部分文件编号均为一个 [正整数]（至少含有两个文件）。传输要求为：连续文件编号总和
     * 为接收方指定数字 target 的所有文件。请返回所有符合该要求的文件传输组合列表。
     *
     * 题目也没表现的很清楚，按他给的例子和测试用例，这个编号是按照1,2,3,4,5....这样的顺序来的
     *
     * 给定一个target，找出连续和为target的子元素数组。
     * 数组内元素升序排列
     * 不同数组间按第1个元素升序，也就已经暗示从前往后遍历处理
     */


    public static int[][] fileCombination(int target) {
        /**
         * 这个实现理解起来简单，但是浪费了中间的sum。每次要重新计算sum，降低性能
         * 而且其实不用到target，到一半的时候就可以了，省一半的循环，效率立马提升1倍
         */
        List<int[]> all = new ArrayList<>();
        int i = 1; // 文件编号的第一个
        while(i < target) {
            int sum = i;
            int j=i+1;
            while(j < target) {
                if(sum + j > target) {
                    break;
                } else if(sum + j == target) {
                    int size = j-i+1;
                    int[] arr = new int[size];
                    for(int k = 0; k < size; k++) {
                        arr[k] = i+k;
                    }
                    all.add(arr);
                    break;
                } else {
                    sum += j;
                    j++;
                }
            }
            i++;
        }
        int size = all.size();
        int[][] res = new int[size][];
        for(int k = 0; k < size; k++) {
            res[k] = all.get(k);
        }
        return res;
    }

    public static int[][] fileCombination2(int target) {
        List<int[]> all = new ArrayList<>();
        int i=1;
        int j = i+1;
        int sum = i+j;
        while( i < target && j < target) { // 不能是1个文件部分
            if(sum == target) {
                int size = j-i+1;
                int[] arr = new int[size];
                for(int k = 0; k < size; k++) {
                    arr[k] = i+k;
                }
                all.add(arr);
                j++;
                sum = sum -i+j; // 复用前面已经走过的sum
                i++;
            } else if(sum > target) {
                sum = sum -i;
                i++;
            } else { // sum < target
                j++;
                sum += j;
            }
        }
        return all.toArray(new int[0][]);
    }

    public static void main(String[] args) {
//        int[][] res= fileCombination(18);
        int[][] res = fileCombination2(25);
        for(int[] arr : res) {
            System.out.println(Arrays.toString(arr));
        }

//        // 获取 Java 版本属性
//        String version = System.getProperty("java.version");
//
//        // 获取 Java 运行时环境版本
//        String runtimeVersion = Runtime.version().toString();
//
//        System.out.println("java.version 属性: " + version);
//        System.out.println("Runtime 版本详情: " + runtimeVersion);
    }


    Person[] list = new Person[3];
    int[] a;
    Integer[] b;
}
