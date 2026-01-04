package 工具类;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Java 常用工具类完整学习笔记
 * 核心涵盖：String/StringBuffer/StringBuilder、Collections、Arrays、Date/Calendar/SimpleDateFormat
 *          Math、Objects、正则表达式（Pattern/Matcher）
 * 特性：代码可直接运行、注释详尽、易错点高亮、结构清晰
 */
public class ToolClassDemo {
    public static void main(String[] args) {
        // ============== 一、字符串工具类（String/StringBuffer/StringBuilder） ==============
        System.out.println("============== 一、字符串工具类 ==============");
        // 1.1 String（不可变字符串，适用于少量修改场景）
        System.out.println("--- 1.1 String（不可变字符串） ---");
        String str1 = "Java";
        String str2 = "Java";
        String str3 = new String("Java");
        System.out.println("str1 == str2：" + (str1 == str2)); // true（字符串常量池）
        System.out.println("str1 == str3：" + (str1 == str3)); // false（堆内存对象）
        System.out.println("str1.equals(str3)：" + str1.equals(str3)); // true（内容比较）
        // 常用方法
        System.out.println("字符串长度：" + str1.length());
        System.out.println("是否包含'va'：" + str1.contains("va"));
        System.out.println("截取索引1之后的字符串：" + str1.substring(1));
        System.out.println("替换'a'为'A'：" + str1.replace('a', 'A'));
        System.out.println("按空格分割：" + Arrays.toString("Java Python C++".split(" ")));
        System.out.println();

        // 1.2 StringBuffer（可变字符串、线程安全、效率低，适用于多线程场景）
        System.out.println("--- 1.2 StringBuffer（可变、线程安全） ---");
        StringBuffer sb1 = new StringBuffer("Java");
        sb1.append(" StringBuffer"); // 追加
        sb1.insert(4, "_"); // 插入
        sb1.reverse(); // 反转
        System.out.println("StringBuffer操作结果：" + sb1);
        System.out.println();

        // 1.3 StringBuilder（可变字符串、线程不安全、效率高，适用于单线程场景）
        System.out.println("--- 1.3 StringBuilder（可变、效率高） ---");
        StringBuilder sb2 = new StringBuilder("Java");
        sb2.append(" StringBuilder");
        sb2.delete(4, 5); // 删除索引4的字符
        sb2.setCharAt(0, 'j'); // 修改指定索引字符
        System.out.println("StringBuilder操作结果：" + sb2);
        System.out.println();

        // ============== 二、集合工具类（Collections） ==============
        System.out.println("============== 二、集合工具类（Collections） ==============");
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(1);
        list.add(2);
        System.out.println("原始集合：" + list);

        // 排序（自然升序）
        Collections.sort(list);
        System.out.println("自然排序后：" + list);

        // 反转集合
        Collections.reverse(list);
        System.out.println("反转后：" + list);

        // 随机打乱
        Collections.shuffle(list);
        System.out.println("随机打乱后：" + list);

        // 查找最大值/最小值
        Integer max = Collections.max(list);
        Integer min = Collections.min(list);
        System.out.println("集合最大值：" + max + "，最小值：" + min);

        // 线程安全集合（将非线程安全集合转为线程安全）
        List<Integer> safeList = Collections.synchronizedList(list);
        System.out.println("线程安全集合：" + safeList);
        System.out.println();

        // ============== 三、数组工具类（Arrays） ==============
        System.out.println("============== 三、数组工具类（Arrays） ==============");
        int[] arr = {3, 1, 2, 5, 4};
        System.out.println("原始数组：" + Arrays.toString(arr));

        // 数组排序
        Arrays.sort(arr);
        System.out.println("数组排序后：" + Arrays.toString(arr));

        // 数组查找（二分查找，数组必须先排序）
        int index = Arrays.binarySearch(arr, 3);
        System.out.println("元素3的索引：" + index);

        // 数组填充
        int[] fillArr = new int[5];
        Arrays.fill(fillArr, 10);
        System.out.println("数组填充后：" + Arrays.toString(fillArr));

        // 数组转集合
        List<String> strList = Arrays.asList("Java", "Python", "C++");
        System.out.println("数组转集合：" + strList);

        // 数组比较
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {1, 2, 3};
        boolean isEqual = Arrays.equals(arr1, arr2);
        System.out.println("数组是否相等：" + isEqual);
        System.out.println();

        // ============== 四、日期时间工具类（Date/Calendar/SimpleDateFormat） ==============
        System.out.println("============== 四、日期时间工具类 ==============");
        // 4.1 Date（日期时间对象）
        Date date = new Date();
        System.out.println("当前Date对象：" + date);

        // 4.2 SimpleDateFormat（日期格式化/解析）
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 格式化：Date -> String
        String dateStr = sdf.format(date);
        System.out.println("日期格式化（Date->String）：" + dateStr);

        // 解析：String -> Date
        try {
            Date parseDate = sdf.parse("2026-01-04 12:00:00");
            System.out.println("日期解析（String->Date）：" + parseDate);
        } catch (Exception e) {
            System.out.println("日期解析异常：" + e.getMessage());
        }

        // 4.3 Calendar（日历类，更灵活操作日期）
        Calendar calendar = Calendar.getInstance();
        System.out.println("当前年份：" + calendar.get(Calendar.YEAR));
        System.out.println("当前月份（0-11，需+1）：" + (calendar.get(Calendar.MONTH) + 1));
        System.out.println("当前日期：" + calendar.get(Calendar.DAY_OF_MONTH));
        // 日期偏移（加10天）
        calendar.add(Calendar.DAY_OF_MONTH, 10);
        System.out.println("加10天后的日期：" + sdf.format(calendar.getTime()));
        System.out.println();

        // ============== 五、其他常用工具类（Math/Objects/正则） ==============
        System.out.println("============== 五、其他常用工具类 ==============");
        // 5.1 Math（数学运算）
        System.out.println("--- 5.1 Math工具类 ---");
        System.out.println("绝对值：" + Math.abs(-10));
        System.out.println("最大值：" + Math.max(10, 20));
        System.out.println("最小值：" + Math.min(10, 20));
        System.out.println("四舍五入：" + Math.round(3.6));
        System.out.println("随机数（0-1）：" + Math.random());

        // 5.2 Objects（对象操作，避免空指针）
        System.out.println("--- 5.2 Objects工具类 ---");
        String nullStr = null;
        String nonNullStr = "Java";
        // 空指针安全的equals
        boolean equals = Objects.equals(nullStr, nonNullStr);
        System.out.println("空指针安全的equals：" + equals);
        // 判空
        boolean isNull = Objects.isNull(nullStr);
        System.out.println("是否为null：" + isNull);
        // 非空判断
        boolean nonNull = Objects.nonNull(nonNullStr);
        System.out.println("是否非null：" + nonNull);

        // 5.3 正则表达式（Pattern/Matcher，字符串匹配）
        System.out.println("--- 5.3 正则表达式 ---");
        String phone = "13800138000";
        String phoneRegex = "^1[3-9]\\d{9}$"; // 手机号正则
        Pattern pattern = Pattern.compile(phoneRegex);
        Matcher matcher = pattern.matcher(phone);
        boolean isPhoneValid = matcher.matches();
        System.out.println("手机号" + phone + "是否合法：" + isPhoneValid);
        System.out.println();

        // ============== 六、常用工具类核心易错点总结 ==============
        System.out.println("============== 六、常用工具类核心易错点 ==============");
        System.out.println("1. 字符串选择：少量修改用String，多线程修改用StringBuffer，单线程修改用StringBuilder（效率最高）");
        System.out.println("2. String相等比较：用equals（内容比较），不用==（地址比较，除非比较常量池字符串）");
        System.out.println("3. Arrays.asList()：返回的是固定大小集合，不支持add/remove操作");
        System.out.println("4. SimpleDateFormat：非线程安全，多线程场景需避免共用实例，或使用ThreadLocal");
        System.out.println("5. 二分查找：Arrays.binarySearch() 要求数组必须先排序，否则结果不可靠");
        System.out.println("6. Objects工具类：优先使用Objects.equals()/Objects.isNull()，避免空指针异常");
    }
}