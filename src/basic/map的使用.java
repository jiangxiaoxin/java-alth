package basic;

import java.util.HashMap;
import java.util.Map;

public class map的使用 {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("name", "张三");
        map.put("age", "18");
        map.put("sex", "男");
        map.put("name", "李四");
        System.out.println(map.get("name"));
        System.out.println(map.get("age"));
        System.out.println(map.get("sex"));
        System.out.println(map.get("address"));
        System.out.println(map.getOrDefault("address", "北京"));
    }
}
