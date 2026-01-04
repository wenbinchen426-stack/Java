package 集合; // 遵循Java包命名规范（小写分层）

/**
 * Java 集合框架核心学习笔记
 * 核心涵盖：2大集合体系（单列Collection/双列Map）
 * 重点模块：List（ArrayList）、Set（HashSet）、Map（HashMap）、集合增删改查、遍历方式
 * 特性：代码可直接运行、易错点高亮、注释详尽、结构清晰
 */
public class Gather {
    public static void main(String[] args) {
        // ============== 一、集合概述（核心认知） ==============
        /**
         * 核心特性：
         * 1. 集合是Java提供的容器，用于存储多个对象（区别于数组，长度可动态变化）
         * 2. 分为两大体系：单列集合（Collection）、双列集合（Map）
         * 3. 集合存储的是对象的引用，而非对象本身（基本数据类型会自动装箱为包装类）
         * 4. 核心优势：提供丰富的操作方法（增删改查、遍历、排序等），比数组更灵活
         */
        System.out.println("============== 一、集合概述 ==============");
        System.out.println("集合两大体系：");
        System.out.println("1. 单列集合（Collection）：存储单个元素，如List（有序可重复）、Set（无序不可重复）");
        System.out.println("2. 双列集合（Map）：存储键值对（key-value），键唯一，值可重复，如HashMap");
        System.out.println("集合核心优势：长度动态变化、操作方法丰富\n");

        // ============== 二、单列集合（Collection）核心操作 ==============
        /**
         * 核心特性：
         * 1. 根接口：Collection<E>，所有单列集合的父接口
         * 2. 常用实现类：ArrayList（List接口）、HashSet（Set接口）
         * 3. 核心操作：增、删、查、改（Set无索引，修改需先删后加）
         */
        System.out.println("============== 二、单列集合（Collection） ==============");

        // 2.1 List接口 - ArrayList实现类（有序、可重复、有索引）
        System.out.println("--- 2.1 List<ArrayList>：有序可重复有索引 ---");
        /**
         * 语法格式：
         * List<元素类型> 集合名 = new ArrayList<>();
         * 核心特性：
         * 1. 有序：元素存入顺序与取出顺序一致
         * 2. 可重复：允许存储相同内容的元素
         * 3. 有索引：支持通过索引操作元素（0开始，类似数组）
         */
        // 导入提示：import java.util.ArrayList; import java.util.List;
        java.util.List<String> arrayList = new java.util.ArrayList<>();

        // 2.1.1 增：添加元素（add(单个元素)、add(索引, 元素)、addAll(批量元素)）
        System.out.println("--- ArrayList 增操作 ---");
        // 单个添加（尾部追加）
        arrayList.add("Java");
        arrayList.add("Python");
        arrayList.add("C++");
        System.out.println("尾部添加后：" + arrayList); // 输出：[Java, Python, C++]

        // 指定索引添加（插入元素，后续元素后移）
        arrayList.add(1, "Go");
        System.out.println("索引1插入Go后：" + arrayList); // 输出：[Java, Go, Python, C++]

        // 批量添加
        java.util.List<String> otherList = new java.util.ArrayList<>();
        otherList.add("JavaScript");
        otherList.add("PHP");
        arrayList.addAll(otherList);
        System.out.println("批量添加后：" + arrayList); // 输出：[Java, Go, Python, C++, JavaScript, PHP]

        // 2.1.2 删：删除元素（remove(索引)、remove(元素)、clear(清空)）
        System.out.println("\n--- ArrayList 删操作 ---");
        // 根据索引删除（返回被删除的元素）
        String deletedByIndex = arrayList.remove(3);
        System.out.println("索引3被删除元素：" + deletedByIndex); // 输出：C++
        System.out.println("索引删除后：" + arrayList); // 输出：[Java, Go, Python, JavaScript, PHP]

        // 根据元素删除（返回是否删除成功，仅删除第一个匹配元素）
        boolean isRemoved = arrayList.remove("PHP");
        System.out.println("是否删除PHP：" + isRemoved); // 输出：true
        System.out.println("元素删除后：" + arrayList); // 输出：[Java, Go, Python, JavaScript]

        // 清空集合
        // arrayList.clear();
        // System.out.println("清空后：" + arrayList); // 输出：[]

        // 2.1.3 查：查询/判断元素（get(索引)、contains(元素)、size()、遍历）
        System.out.println("\n--- ArrayList 查操作 ---");
        // 根据索引获取元素
        String element = arrayList.get(2);
        System.out.println("索引2的元素：" + element); // 输出：Python

        // 判断是否包含指定元素
        boolean hasJava = arrayList.contains("Java");
        System.out.println("是否包含Java：" + hasJava); // 输出：true

        // 获取集合大小（元素个数）
        int size = arrayList.size();
        System.out.println("集合元素个数：" + size); // 输出：4

        // 遍历方式1：增强for循环（推荐，简洁）
        System.out.println("增强for循环遍历：");
        for (String lang : arrayList) {
            System.out.print(lang + " ");
        }
        System.out.println();

        // 遍历方式2：普通for循环（支持索引操作）
        System.out.println("普通for循环遍历：");
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.print(arrayList.get(i) + " ");
        }
        System.out.println();

        // 遍历方式3：迭代器遍历（支持遍历中安全删除）
        System.out.println("迭代器遍历：");
        java.util.Iterator<String> iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            String lang = iterator.next();
            System.out.print(lang + " ");
        }
        System.out.println("\n");

        // 2.1.4 改：修改指定索引元素（set(索引, 新元素)）
        System.out.println("--- ArrayList 改操作 ---");
        System.out.println("修改前：" + arrayList); // 输出：[Java, Go, Python, JavaScript]
        // 修改索引3的元素
        arrayList.set(3, "JavaScript高级");
        System.out.println("修改后：" + arrayList); // 输出：[Java, Go, Python, JavaScript高级]

        // 2.2 Set接口 - HashSet实现类（无序、不可重复、无索引）
        System.out.println("\n--- 2.2 Set<HashSet>：无序不可重复无索引 ---");
        /**
         * 语法格式：
         * Set<元素类型> 集合名 = new HashSet<>();
         * 核心特性：
         * 1. 无序：元素存入顺序与取出顺序不一致（底层哈希表实现）
         * 2. 不可重复：不允许存储相同内容的元素（通过hashCode+equals判断）
         * 3. 无索引：不支持通过索引操作元素（不能使用get/set方法）
         * 易错点：存储自定义对象时，需重写hashCode和equals方法，否则无法去重
         */
        // 导入提示：import java.util.HashSet; import java.util.Set;
        java.util.Set<String> hashSet = new java.util.HashSet<>();

        // 2.2.1 增：添加元素（add(单个元素)、addAll(批量元素)）
        System.out.println("--- HashSet 增操作 ---");
        hashSet.add("苹果");
        hashSet.add("香蕉");
        hashSet.add("橙子");
        hashSet.add("苹果"); // 重复元素，添加失败
        System.out.println("添加后（自动去重）：" + hashSet); // 输出：[香蕉, 苹果, 橙子]（顺序不固定）

        // 2.2.2 删：删除元素（remove(元素)、clear(清空)）
        System.out.println("\n--- HashSet 删操作 ---");
        boolean isRemoveBanana = hashSet.remove("香蕉");
        System.out.println("是否删除香蕉：" + isRemoveBanana); // 输出：true
        System.out.println("删除后：" + hashSet); // 输出：[苹果, 橙子]

        // 2.2.3 查：查询/判断元素（contains(元素)、size()、遍历）
        System.out.println("\n--- HashSet 查操作 ---");
        boolean hasOrange = hashSet.contains("橙子");
        System.out.println("是否包含橙子：" + hasOrange); // 输出：true
        System.out.println("集合元素个数：" + hashSet.size()); // 输出：2

        // 遍历：仅支持增强for循环和迭代器（无索引，不支持普通for循环）
        System.out.println("增强for循环遍历：");
        for (String fruit : hashSet) {
            System.out.print(fruit + " ");
        }
        System.out.println("\n");

        // 2.2.4 改：修改元素（无索引，需先删后加）
        System.out.println("--- HashSet 改操作（先删后加） ---");
        System.out.println("修改前：" + hashSet); // 输出：[苹果, 橙子]
        // 将"苹果"修改为"红苹果"
        hashSet.remove("苹果");
        hashSet.add("红苹果");
        System.out.println("修改后：" + hashSet); // 输出：[红苹果, 橙子]
        System.out.println();

        // ============== 三、双列集合（Map）核心操作 ==============
        /**
         * 核心特性：
         * 1. 根接口：Map<K, V>，K为键类型，V为值类型
         * 2. 常用实现类：HashMap（无序、键唯一、查询高效）
         * 3. 核心特性：键（key）唯一不可重复，值（value）可重复，键值一一对应
         * 4. 核心操作：增删改查（围绕键值对展开）
         */
        System.out.println("============== 三、双列集合（Map） ==============");
        System.out.println("--- 3.1 Map<HashMap>：键值对存储，键唯一 ---");
        // 导入提示：import java.util.HashMap; import java.util.Map;
        java.util.Map<String, Integer> scoreMap = new java.util.HashMap<>();

        // 3.1.1 增：添加键值对（put(键, 值)、putAll(批量键值对)）
        System.out.println("--- HashMap 增操作 ---");
        // 单个添加键值对
        scoreMap.put("张三", 95);
        scoreMap.put("李四", 88);
        scoreMap.put("王五", 92);
        System.out.println("添加后：" + scoreMap); // 输出：{张三=95, 李四=88, 王五=92}

        // 键重复时：覆盖原有值（增的特殊情况，本质是修改）
        scoreMap.put("李四", 90);
        System.out.println("覆盖李四分数后：" + scoreMap); // 输出：{张三=95, 李四=90, 王五=92}

        // 批量添加键值对
        java.util.Map<String, Integer> otherScoreMap = new java.util.HashMap<>();
        otherScoreMap.put("赵六", 85);
        otherScoreMap.put("孙七", 98);
        scoreMap.putAll(otherScoreMap);
        System.out.println("批量添加后：" + scoreMap); // 输出：{张三=95, 李四=90, 王五=92, 赵六=85, 孙七=98}

        // 3.1.2 删：删除键值对（remove(键)、remove(键, 值)、clear(清空)）
        System.out.println("\n--- HashMap 删操作 ---");
        // 根据键删除（返回被删除的值）
        Integer deletedScore = scoreMap.remove("王五");
        System.out.println("王五的分数（被删除）：" + deletedScore); // 输出：92
        System.out.println("按键删除后：" + scoreMap); // 输出：{张三=95, 李四=90, 赵六=85, 孙七=98}

        // 键值匹配删除（仅当键对应的值一致时才删除，返回是否成功）
        boolean isRemoveLi = scoreMap.remove("李四", 88); // 李四分数是90，不匹配，删除失败
        System.out.println("是否删除李四（88分）：" + isRemoveLi); // 输出：false

        // 清空集合
        // scoreMap.clear();
        // System.out.println("清空后：" + scoreMap); // 输出：{}

        // 3.1.3 查：查询键/值/键值对（get(键)、containsKey(键)、遍历）
        System.out.println("\n--- HashMap 查操作 ---");
        // 根据键获取值（键不存在返回null）
        Integer zhangSanScore = scoreMap.get("张三");
        System.out.println("张三的分数：" + zhangSanScore); // 输出：95

        // 判断是否包含指定键
        boolean hasZhaoLiu = scoreMap.containsKey("赵六");
        System.out.println("是否包含赵六：" + hasZhaoLiu); // 输出：true

        // 判断是否包含指定值
        boolean has98 = scoreMap.containsValue(98);
        System.out.println("是否包含98分：" + has98); // 输出：true

        // 遍历方式1：keySet()（先获所有键，再按键取值）
        System.out.println("keySet()遍历键值对：");
        for (String name : scoreMap.keySet()) {
            Integer score = scoreMap.get(name);
            System.out.println(name + "：" + score);
        }

        // 遍历方式2：entrySet()（直接获键值对对象，效率更高，推荐）
        System.out.println("entrySet()遍历键值对：");
        for (java.util.Map.Entry<String, Integer> entry : scoreMap.entrySet()) {
            String name = entry.getKey();
            Integer score = entry.getValue();
            System.out.println(name + "：" + score);
        }

        // 3.1.4 改：修改键值对（put(键, 新值)，键存在即修改）
        System.out.println("\n--- HashMap 改操作 ---");
        System.out.println("修改前：" + scoreMap); // 输出：{张三=95, 李四=90, 赵六=85, 孙七=98}
        // 修改张三分数为99，赵六分数为89
        scoreMap.put("张三", 99);
        scoreMap.put("赵六", 89);
        System.out.println("修改后：" + scoreMap); // 输出：{张三=99, 李四=90, 赵六=89, 孙七=98}

        // ============== 四、集合核心易错点总结 ==============
        System.out.println("\n============== 四、集合核心易错点 ==============");
        System.out.println("1. ArrayList：索引越界异常（IndexOutOfBoundsException），需注意索引范围0~size-1");
        System.out.println("2. HashSet：自定义对象去重需重写hashCode()和equals()方法，否则无法去重");
        System.out.println("3. HashMap：键不可重复，值可重复；键为null仅允许一个，值为null可多个");
        System.out.println("4. 遍历中删除：普通for/增强for遍历删除会触发并发修改异常，推荐使用迭代器");
        System.out.println("5. 集合泛型：指定泛型后，只能存储对应类型元素，避免类型转换异常");
    }
}