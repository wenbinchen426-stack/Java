package 常用集合框架; // 遵循Java包命名规范（小写分层）

/**
 * Java 集合框架常用实现类完整学习笔记
 * 核心涵盖：2大集合体系（单列Collection/双列Map）的所有常用实现类
 * 重点模块：List(ArrayList/LinkedList/Vector)、Set(HashSet/LinkedHashSet/TreeSet)
 *          Map(HashMap/LinkedHashMap/TreeMap/Hashtable)
 * 特性：代码可直接运行、易错点高亮、注释详尽、结构清晰
 */
public class CommonGather {
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
        System.out.println("1. 单列集合（Collection）：存储单个元素，细分两大分支");
        System.out.println("   - List：有序可重复有索引（ArrayList/LinkedList/Vector）");
        System.out.println("   - Set：无序/有序不可重复无索引（HashSet/LinkedHashSet/TreeSet）");
        System.out.println("2. 双列集合（Map）：存储键值对（key-value），键唯一值可重复");
        System.out.println("   - 常用实现：HashMap/LinkedHashMap/TreeMap/Hashtable");
        System.out.println("集合核心优势：长度动态变化、操作方法丰富\n");

        // ============== 二、单列集合（Collection）- List接口常用实现类 ==============
        System.out.println("============== 二、List接口常用实现类 ==============");

        // 2.1 ArrayList（数组实现、查询快、增删慢（尾部增删除外）、线程不安全）
        System.out.println("--- 2.1 ArrayList：数组实现 | 查询快 | 增删慢 | 线程不安全 ---");
        java.util.List<String> arrayList = new java.util.ArrayList<>();
        // 增
        arrayList.add("Java");
        arrayList.add(0, "Go"); // 指定索引插入
        arrayList.addAll(java.util.Arrays.asList("Python", "C++"));
        System.out.println("ArrayList 添加后：" + arrayList);
        // 删
        String delIndexEle = arrayList.remove(2);
        boolean delEle = arrayList.remove("C++");
        System.out.println("ArrayList 删除索引2元素：" + delIndexEle + "，是否删除C++：" + delEle);
        System.out.println("ArrayList 删除后：" + arrayList);
        // 查
        String getEle = arrayList.get(1);
        boolean hasJava = arrayList.contains("Java");
        int size = arrayList.size();
        System.out.println("ArrayList 索引1元素：" + getEle + "，是否包含Java：" + hasJava + "，大小：" + size);
        // 改
        arrayList.set(1, "Java高级");
        System.out.println("ArrayList 修改后：" + arrayList);
        // 遍历（3种方式）
        System.out.println("ArrayList 增强for遍历：");
        for (String s : arrayList) System.out.print(s + " ");
        System.out.println("\nArrayList 普通for遍历：");
        for (int i = 0; i < arrayList.size(); i++) System.out.print(arrayList.get(i) + " ");
        System.out.println("\nArrayList 迭代器遍历：");
        java.util.Iterator<String> arrayIt = arrayList.iterator();
        while (arrayIt.hasNext()) System.out.print(arrayIt.next() + " ");
        System.out.println("\n");

        // 2.2 LinkedList（链表实现、查询慢、增删快、线程不安全）
        System.out.println("--- 2.2 LinkedList：链表实现 | 查询慢 | 增删快 | 线程不安全 ---");
        java.util.LinkedList<String> linkedList = new java.util.LinkedList<>();
        // 增（特有头尾添加方法）
        linkedList.add("苹果");
        linkedList.addFirst("香蕉"); // 头部添加
        linkedList.addLast("橙子"); // 尾部添加
        System.out.println("LinkedList 添加后：" + linkedList);
        // 删（特有头尾删除方法）
        String firstDel = linkedList.removeFirst();
        String lastDel = linkedList.removeLast();
        System.out.println("LinkedList 删除头部：" + firstDel + "，删除尾部：" + lastDel);
        System.out.println("LinkedList 删除后：" + linkedList);
        // 查（特有头尾获取方法）
        String firstEle = linkedList.getFirst();
        System.out.println("LinkedList 头部元素：" + firstEle + "，大小：" + linkedList.size());
        // 改
        linkedList.set(0, "红苹果");
        System.out.println("LinkedList 修改后：" + linkedList + "\n");

        // 2.3 Vector（数组实现、线程安全、效率低、古老实现类）
        System.out.println("--- 2.3 Vector：数组实现 | 查询快 | 线程安全 | 效率低 ---");
        java.util.Vector<String> vector = new java.util.Vector<>();
        // 增
        vector.add("北京");
        vector.addElement("上海"); // 特有添加方法
        System.out.println("Vector 添加后：" + vector);
        // 删
        vector.remove(1);
        vector.removeElement("北京"); // 特有删除方法
        System.out.println("Vector 删除后：" + vector);
        // 查
        if (vector.size() > 0) {
            String vecEle = vector.get(0);
            System.out.println("Vector 元素：" + vecEle);
        } else {
            vector.add("广州");
            System.out.println("Vector 新增元素后：" + vector);
        }
        // 改
        vector.set(0, "深圳");
        System.out.println("Vector 修改后：" + vector + "\n");

        // ============== 三、单列集合（Collection）- Set接口常用实现类 ==============
        System.out.println("============== 三、Set接口常用实现类 ==============");

        // 3.1 HashSet（哈希表实现、无序、不可重复、无索引、查询快、线程不安全）
        System.out.println("--- 3.1 HashSet：哈希表 | 无序 | 不可重复 | 无索引 ---");
        java.util.Set<Integer> hashSet = new java.util.HashSet<>();
        // 增（重复元素自动去重）
        hashSet.add(10);
        hashSet.add(20);
        hashSet.add(10); // 重复元素，添加失败
        System.out.println("HashSet 添加后（自动去重）：" + hashSet);
        // 删
        boolean del10 = hashSet.remove(10);
        System.out.println("HashSet 是否删除10：" + del10 + "，删除后：" + hashSet);
        // 查
        boolean has20 = hashSet.contains(20);
        System.out.println("HashSet 是否包含20：" + has20 + "，大小：" + hashSet.size());
        // 改（无索引，先删后加）
        hashSet.remove(20);
        hashSet.add(25);
        System.out.println("HashSet 修改后（先删后加）：" + hashSet);
        // 遍历（仅支持增强for和迭代器）
        System.out.println("HashSet 增强for遍历：");
        for (Integer num : hashSet) System.out.print(num + " ");
        System.out.println("\n");

        // 3.2 LinkedHashSet（链表+哈希表实现、有序（插入顺序）、不可重复、无索引）
        System.out.println("--- 3.2 LinkedHashSet：链表+哈希表 | 插入有序 | 不可重复 | 无索引 ---");
        java.util.Set<String> linkedHashSet = new java.util.LinkedHashSet<>();
        // 增（按插入顺序保存）
        linkedHashSet.add("红色");
        linkedHashSet.add("绿色");
        linkedHashSet.add("蓝色");
        linkedHashSet.add("红色"); // 重复元素，添加失败
        System.out.println("LinkedHashSet 添加后（插入有序）：" + linkedHashSet);
        // 删
        boolean delRed = linkedHashSet.remove("红色");
        System.out.println("LinkedHashSet 是否删除红色：" + delRed + "，删除后：" + linkedHashSet);
        // 查
        boolean hasGreen = linkedHashSet.contains("绿色");
        System.out.println("LinkedHashSet 是否包含绿色：" + hasGreen + "，大小：" + linkedHashSet.size());
        // 改（先删后加）
        linkedHashSet.remove("绿色");
        linkedHashSet.add("草绿色");
        System.out.println("LinkedHashSet 修改后：" + linkedHashSet + "\n");

        // 3.3 TreeSet（红黑树实现、自然排序/定制排序、不可重复、无索引）
        System.out.println("--- 3.3 TreeSet：红黑树 | 排序（自然/定制） | 不可重复 | 无索引 ---");
        // 自然排序（默认升序）
        java.util.Set<Integer> treeSet1 = new java.util.TreeSet<>();
        treeSet1.add(30);
        treeSet1.add(10);
        treeSet1.add(20);
        System.out.println("TreeSet 自然排序（升序）：" + treeSet1);

        // 定制排序（降序，通过Comparator）
        java.util.Set<Integer> treeSet2 = new java.util.TreeSet<>(new java.util.Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1; // 降序排列
            }
        });
        treeSet2.add(30);
        treeSet2.add(10);
        treeSet2.add(20);
        System.out.println("TreeSet 定制排序（降序）：" + treeSet2);

        // 增删改查
        treeSet1.remove(20);
        boolean has10 = treeSet1.contains(10);
        System.out.println("TreeSet1 删除20后：" + treeSet1 + "，是否包含10：" + has10);
        // 改（先删后加）
        treeSet1.remove(10);
        treeSet1.add(15);
        System.out.println("TreeSet1 修改后：" + treeSet1 + "\n");

        // ============== 四、双列集合（Map）常用实现类 ==============
        System.out.println("============== 四、Map接口常用实现类 ==============");

        // 4.1 HashMap（哈希表实现、无序、键唯一、线程不安全、效率高、允许键值为null）
        System.out.println("--- 4.1 HashMap：哈希表 | 无序 | 键唯一 | 线程不安全 | 允许键值为null ---");
        java.util.Map<String, String> hashMap = new java.util.HashMap<>();
        // 增
        hashMap.put("CN", "中国");
        hashMap.put("US", "美国");
        hashMap.put("UK", "英国");
        hashMap.put("CN", "中华人民共和国"); // 键重复，覆盖值
        hashMap.put(null, "无国家代码"); // 键为null
        hashMap.put("JP", null); // 值为null
        System.out.println("HashMap 添加后：" + hashMap);
        // 删
        String delCn = hashMap.remove("CN");
        boolean delNullKey = hashMap.remove(null, "无国家代码");
        System.out.println("HashMap 删除CN对应值：" + delCn + "，是否删除null键：" + delNullKey);
        System.out.println("HashMap 删除后：" + hashMap);
        // 查
        String usValue = hashMap.get("US");
        boolean hasUK = hashMap.containsKey("UK");
        boolean hasNullValue = hashMap.containsValue(null);
        System.out.println("HashMap US对应值：" + usValue + "，是否包含UK键：" + hasUK + "，是否包含null值：" + hasNullValue);
        // 改（put覆盖）
        hashMap.put("US", "美利坚合众国");
        System.out.println("HashMap 修改后：" + hashMap);
        // 遍历（2种常用方式）
        System.out.println("HashMap keySet遍历：");
        for (String key : hashMap.keySet()) System.out.println(key + "：" + hashMap.get(key));
        System.out.println("HashMap entrySet遍历（推荐）：");
        for (java.util.Map.Entry<String, String> entry : hashMap.entrySet()) {
            System.out.println(entry.getKey() + "：" + entry.getValue());
        }
        System.out.println();

        // 4.2 LinkedHashMap（链表+哈希表实现、插入有序/访问有序、键唯一、线程不安全）
        System.out.println("--- 4.2 LinkedHashMap：链表+哈希表 | 插入有序 | 键唯一 | 线程不安全 ---");
        java.util.Map<String, Integer> linkedHashMap = new java.util.LinkedHashMap<>();
        // 增（按插入顺序保存）
        linkedHashMap.put("张三", 88);
        linkedHashMap.put("李四", 95);
        linkedHashMap.put("王五", 90);
        System.out.println("LinkedHashMap 添加后（插入有序）：" + linkedHashMap);
        // 删改查
        linkedHashMap.remove("李四");
        linkedHashMap.put("张三", 92); // 修改
        boolean hasZhang = linkedHashMap.containsKey("张三");
        System.out.println("LinkedHashMap 修改删除后：" + linkedHashMap + "，是否包含张三：" + hasZhang + "\n");

        // 4.3 TreeMap（红黑树实现、键排序（自然/定制）、键唯一、线程不安全）
        System.out.println("--- 4.3 TreeMap：红黑树 | 键排序（自然/定制） | 键唯一 | 线程不安全 ---");
        // 自然排序（键按字符串自然排序）
        java.util.Map<String, Integer> treeMap1 = new java.util.TreeMap<>();
        treeMap1.put("B", 20);
        treeMap1.put("A", 10);
        treeMap1.put("C", 30);
        System.out.println("TreeMap 键自然排序：" + treeMap1);

        // 定制排序（键降序）
        java.util.Map<String, Integer> treeMap2 = new java.util.TreeMap<>(new java.util.Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1); // 键降序排列
            }
        });
        treeMap2.put("B", 20);
        treeMap2.put("A", 10);
        treeMap2.put("C", 30);
        System.out.println("TreeMap 键定制排序（降序）：" + treeMap2 + "\n");

        // 4.4 Hashtable（哈希表实现、无序、键唯一、线程安全、效率低、不允许键值为null）
        System.out.println("--- 4.4 Hashtable：哈希表 | 无序 | 键唯一 | 线程安全 | 不允许键值为null ---");
        java.util.Hashtable<String, String> hashtable = new java.util.Hashtable<>();
        // 增
        hashtable.put("姓名", "张三");
        hashtable.put("年龄", "25");
        // hashtable.put(null, "性别"); // 报错：NullPointerException
        // hashtable.put("性别", null); // 报错：NullPointerException
        System.out.println("Hashtable 添加后：" + hashtable);
        // 删改查
        hashtable.remove("年龄");
        hashtable.put("姓名", "李四"); // 修改
        String name = hashtable.get("姓名");
        System.out.println("Hashtable 修改删除后：" + hashtable + "，姓名对应值：" + name + "\n");

        // ============== 五、常用集合核心特性总结 ==============
        System.out.println("============== 五、常用集合核心特性总结 ==============");
        System.out.println("===== List 接口 =====");
        System.out.println("1. ArrayList：数组实现 | 查询快 | 增删慢（尾部除外） | 线程不安全 | 有序可重复有索引");
        System.out.println("2. LinkedList：链表实现 | 查询慢 | 增删快 | 线程不安全 | 有序可重复有索引 | 特有头尾操作");
        System.out.println("3. Vector：数组实现 | 查询快 | 增删慢 | 线程安全（同步） | 效率低 | 有序可重复有索引");
        System.out.println("\n===== Set 接口 =====");
        System.out.println("1. HashSet：哈希表 | 无序 | 不可重复 | 无索引 | 查询快 | 线程不安全 | 需重写hashCode+equals去重");
        System.out.println("2. LinkedHashSet：链表+哈希表 | 插入有序 | 不可重复 | 无索引 | 线程不安全 | 兼顾有序和查询效率");
        System.out.println("3. TreeSet：红黑树 | 排序（自然/定制） | 不可重复 | 无索引 | 线程不安全 | 自动排序");
        System.out.println("\n===== Map 接口 =====");
        System.out.println("1. HashMap：哈希表 | 无序 | 键唯一 | 线程不安全 | 效率高 | 允许键值为null | 键去重依赖hashCode+equals");
        System.out.println("2. LinkedHashMap：链表+哈希表 | 插入/访问有序 | 键唯一 | 线程不安全 | 兼顾有序和查询效率");
        System.out.println("3. TreeMap：红黑树 | 键排序（自然/定制） | 键唯一 | 线程不安全 | 按键自动排序");
        System.out.println("4. Hashtable：哈希表 | 无序 | 键唯一 | 线程安全（同步） | 效率低 | 不允许键值为null");
        System.out.println("\n===== 核心易错点 =====");
        System.out.println("1. 索引相关：List有索引（支持get/set），Set/Map无索引（不支持索引操作）");
        System.out.println("2. 去重相关：HashSet/HashMap键去重需重写自定义对象的hashCode()和equals()");
        System.out.println("3. 排序相关：TreeSet/TreeMap支持排序，可通过Comparator实现定制排序");
        System.out.println("4. 线程安全：Vector/Hashtable是线程安全的（古老实现），ArrayList/HashSet/HashMap线程不安全");
        System.out.println("5. null值支持：HashMap允许键值为null（键仅一个null），Hashtable不允许键值为null");
        System.out.println("6. 修改相关：Set无索引，修改元素需先删后加；Map修改值通过put（键存在即覆盖）");
    }
}