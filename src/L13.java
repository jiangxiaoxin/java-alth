import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L13 {
//    罗马数字转整数
//    题目数据保证 s 是一个有效的罗马数字，且表示整数在范围 [1, 3999] 内

    public static void main(String[] args) {
        String s = "MCMXCIV";
        System.out.println(romanToInt(s));
    }

    public static Map<Character, Integer> map = new HashMap<>(){
        {
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }
    };


    public static int romanToInt(String s) {
        int sum = 0;
        char c;
        int val;
        int nextVal = 0;
        for(int i=0;i<s.length();) {
            c = s.charAt(i);
            val = map.get(c);
            if(i+1 < s.length()) {
                nextVal = map.get(s.charAt(i+1));
                if (val < nextVal) {
                    sum += (nextVal - val);
                    i += 2;
                } else {
                    sum += val;
                    i++;
                }
            } else {
                // i 已经是最后一位了
                sum += val;
                i++; // 加1跳出循环
            }
        }

        return sum;
    }
}
