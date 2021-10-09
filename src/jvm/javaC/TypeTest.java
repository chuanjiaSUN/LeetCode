package jvm.javaC;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-09-27 21:08
 */
public class TypeTest {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("hello", "你好");
        map.put("how are you?", "吃了没");
        System.out.println(map.get("hello"));
        System.out.println(map.get("how are you?"));
    }
}
