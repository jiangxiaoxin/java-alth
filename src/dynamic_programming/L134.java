package dynamic_programming;

public class L134 {

    public static void main(String[] args) {
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        System.out.println(canCompleteCircuit(gas, cost));
    }

    /**
     * 暴力法超时，因为中间会有很多重复计算。需要对计算减少计算量
     * 假设计算得出从x出发，最远走到了y，而想到y+1时油不够了。那么从x和y之间的任意一点出发，都走不到y+1.
     * 因为假设x和y之间的任意一点z，假设z能走到y+1，那么x能走到z，这样x应该能走到y+1.而这与前提就矛盾，x最远只能走到y。
     * 所以计算过程中，如果从x出发，走到y这个位置后走不到y+1了，那下次计算位置，可以直接从y+1开始。
     */

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
//        从i这个位置开始
        int i=0;
        while(i < n) {
            int sumGas = 0;
            int sumCost = 0;
            int j = 0;
            while(j < n) {
                int nextIndex = (i+j)%n;
                sumGas += gas[nextIndex];
                sumCost += cost[nextIndex];
                if(sumCost > sumGas) {
//                    油不够烧的.此时j肯定<n
                    break;
                } else {
//                    油够了，继续走下个位置
                    j++;
                }
            }
            if(j == n) {
                return i;
            } else {
                // 如果是油不够烧的，然后break走到这，那j肯定<n,
                i = i+j+1;
            }
        }
        return -1;
    }

// !   暴力法超时了
//    public static int canCompleteCircuit(int[] gas, int[] cost) {
//        int n = gas.length;
//        int index = -1;
//        for(int i=0;i<n;i++) {
//            // 从i这个节点出发，计算一圈leftGas，如果中间leftGas空了，那就走不下去
//            int startIndex = i;
//            int leftGas = gas[startIndex];
//            int nextIndex;
//            for(int j=1;j<=n;j++) {
//                nextIndex = (startIndex+j) % n;
//                if(leftGas >= cost[(startIndex+j-1) % n]) {
//                    leftGas = leftGas - cost[(startIndex+j-1) % n] + gas[nextIndex];
//                    // 此时已经到了nextIndex
//                    if(nextIndex == startIndex){
//                        index = startIndex;
//                        break;
//                    }
//                } else {
//                    break;
//                }
//            }
//        }
//        return index;
//    }
}
