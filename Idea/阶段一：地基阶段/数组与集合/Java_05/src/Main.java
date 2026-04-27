//========================================
// Java / Android 数组与集合 - 完整学习笔记
//========================================
// 适用场景：数据存储、批量操作、数据传递、缓存管理等

public class Main {
    public static void main(String[] args) {

        //==================== 1. 数组（Array） ====================
        System.out.println("========== 1. 数组基础 ==========");
        /**
         * 数组特点：
         * - 长度固定，一旦创建不可改变
         * - 存储相同类型的数据
         * - 内存连续，索引访问速度快
         * - 可以存储基本类型和引用类型
         */

        // 1.1 数组的声明与初始化
        // 方式一：声明并分配空间
        int[] arr1 = new int[5];           // 默认值为0
        // 方式二：声明并赋值
        int[] arr2 = new int[]{1, 2, 3, 4, 5};
        // 方式三：简化写法（仅声明时）
        int[] arr3 = {10, 20, 30, 40, 50};

        // 1.2 数组的遍历
        System.out.print("arr3遍历: ");
        for (int i = 0; i < arr3.length; i++) {
            System.out.print(arr3[i] + " ");
        }
        System.out.println();

        // 增强for循环（foreach）
        System.out.print("增强for: ");
        for (int num : arr3) {
            System.out.print(num + " ");
        }
        System.out.println();

        // 1.3 多维数组
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println("matrix[1][2] = " + matrix[1][2]); // 6

        // 1.4 数组工具类 Arrays（重要）
        int[] unsorted = {5, 2, 8, 1, 9};
        java.util.Arrays.sort(unsorted);                     // 排序
        System.out.println("排序后: " + java.util.Arrays.toString(unsorted));

        int[] copy = java.util.Arrays.copyOf(unsorted, 3);    // 拷贝前3个元素
        System.out.println("copyOf: " + java.util.Arrays.toString(copy));

        boolean isEqual = java.util.Arrays.equals(unsorted, copy);
        System.out.println("两数组相等? " + isEqual);

        // 1.5 数组的陷阱：引用传递
        int[] original = {1, 2, 3};
        int[] wrongCopy = original;       // 只是引用，未复制数据
        wrongCopy[0] = 100;
        System.out.println("original[0] 被意外修改: " + original[0]); // 100

        // 正确复制方式
        int[] rightCopy = original.clone(); // 或 Arrays.copyOf()
        rightCopy[1] = 200;
        System.out.println("original[1] 不变: " + original[1]); // 2

        //==================== 2. 集合框架（Collection Framework） ====================
        System.out.println("\n========== 2. 集合框架概述 ==========");
        /**
         * 集合框架主要接口：
         * - Collection: 存储单值
         *     - List: 有序、可重复（ArrayList, LinkedList, Vector）
         *     - Set: 无序、不可重复（HashSet, LinkedHashSet, TreeSet）
         *     - Queue: 队列（PriorityQueue, ArrayDeque）
         * - Map: 存储键值对（HashMap, LinkedHashMap, TreeMap, Hashtable）
         */

        //==================== 2.1 List 接口 ====================
        System.out.println("\n========== 2.1 List - ArrayList ==========");
        // ArrayList: 底层数组，随机访问快，增删慢（尾部除外）
        java.util.ArrayList<String> list = new java.util.ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");
        list.add(1, "Blueberry"); // 指定位置插入
        System.out.println("ArrayList: " + list);
        System.out.println("get(2): " + list.get(2));
        list.remove("Banana");
        System.out.println("remove后: " + list);

        // 遍历方式
        System.out.print("for-each遍历: ");
        for (String fruit : list) {
            System.out.print(fruit + " ");
        }
        System.out.println();

        // LinkedList: 底层双向链表，增删快，随机访问慢
        java.util.LinkedList<Integer> linkedList = new java.util.LinkedList<>();
        linkedList.addFirst(10);
        linkedList.addLast(20);
        linkedList.add(15);
        System.out.println("LinkedList: " + linkedList);

        // ArrayList vs LinkedList 选择：频繁随机访问用ArrayList；频繁插入删除用LinkedList

        //==================== 2.2 Set 接口 ====================
        System.out.println("\n========== 2.2 Set - HashSet ==========");
        // HashSet: 无序，基于HashMap，去重依靠 hashCode() 和 equals()
        java.util.HashSet<Integer> set = new java.util.HashSet<>();
        set.add(5);
        set.add(2);
        set.add(8);
        set.add(5);  // 重复，不会添加
        System.out.println("HashSet: " + set);  // 无序，如 [2,5,8]

        // LinkedHashSet: 保持插入顺序
        java.util.LinkedHashSet<String> linkedHashSet = new java.util.LinkedHashSet<>();
        linkedHashSet.add("One");
        linkedHashSet.add("Two");
        linkedHashSet.add("Three");
        System.out.println("LinkedHashSet: " + linkedHashSet);

        // TreeSet: 自动排序（红黑树）
        java.util.TreeSet<Integer> treeSet = new java.util.TreeSet<>();
        treeSet.add(9);
        treeSet.add(1);
        treeSet.add(5);
        System.out.println("TreeSet (排序后): " + treeSet);

        // Set 去重示例
        java.util.ArrayList<Integer> withDuplicates = new java.util.ArrayList<>();
        withDuplicates.add(1); withDuplicates.add(2); withDuplicates.add(1);
        java.util.HashSet<Integer> uniqueSet = new java.util.HashSet<>(withDuplicates);
        System.out.println("去重后: " + uniqueSet);

        //==================== 2.3 Map 接口 ====================
        System.out.println("\n========== 2.3 Map - HashMap ==========");
        // HashMap: 键值对，无序，允许一个null键和多个null值
        java.util.HashMap<String, Integer> map = new java.util.HashMap<>();
        map.put("Alice", 25);
        map.put("Bob", 30);
        map.put("Charlie", 35);
        map.put("Alice", 26); // 覆盖
        System.out.println("HashMap: " + map);
        System.out.println("Alice的年龄: " + map.get("Alice"));
        System.out.println("是否包含Bob: " + map.containsKey("Bob"));

        // 遍历Map
        for (java.util.Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // LinkedHashMap: 保持插入顺序或访问顺序（构造参数）
        java.util.LinkedHashMap<String, String> linkedMap = new java.util.LinkedHashMap<>();
        linkedMap.put("key1", "value1");
        linkedMap.put("key2", "value2");
        System.out.println("LinkedHashMap: " + linkedMap);

        // TreeMap: 按键排序
        java.util.TreeMap<String, Integer> treeMap = new java.util.TreeMap<>();
        treeMap.put("Banana", 3);
        treeMap.put("Apple", 5);
        treeMap.put("Cherry", 2);
        System.out.println("TreeMap (按key排序): " + treeMap);

        //==================== 2.4 集合工具类 Collections ====================
        System.out.println("\n========== 2.4 Collections 工具类 ==========");
        java.util.ArrayList<Integer> nums = new java.util.ArrayList<>();
        nums.add(3); nums.add(1); nums.add(4); nums.add(1); nums.add(5);
        java.util.Collections.sort(nums);                     // 排序
        System.out.println("排序后: " + nums);
        java.util.Collections.reverse(nums);                  // 反转
        System.out.println("反转后: " + nums);
        java.util.Collections.shuffle(nums);                  // 乱序
        System.out.println("乱序后: " + nums);
        int max = java.util.Collections.max(nums);
        int min = java.util.Collections.min(nums);
        System.out.println("最大值: " + max + ", 最小值: " + min);
        int freq = java.util.Collections.frequency(nums, 1);
        System.out.println("1出现的次数: " + freq);

        // 同步包装（线程安全）
        java.util.List<Integer> syncList = java.util.Collections.synchronizedList(nums);

        //==================== 3. Android 特有集合（优化内存） ====================
        System.out.println("\n========== 3. Android 专用集合（性能优化） ==========");
        /**
         * Android 推荐使用 SparseArray, ArrayMap 代替 HashMap（当键为整数且数量不大时）
         * 原因：避免自动装箱，内存效率更高
         */

        // SparseArray: 键为 int，值为 Object
        // 注意：需要添加 android.jar 依赖，这里仅语法示例
        // android.util.SparseArray<String> sparseArray = new android.util.SparseArray<>();
        // sparseArray.put(1, "One");
        // sparseArray.put(2, "Two");
        // System.out.println("SparseArray get(1): " + sparseArray.get(1));

        // ArrayMap: 通用键值对，内存比 HashMap 紧凑
        // android.util.ArrayMap<String, String> arrayMap = new android.util.ArrayMap<>();
        // arrayMap.put("key", "value");

        // 使用普通 HashMap 模拟说明
        java.util.HashMap<Integer, String> normalMap = new java.util.HashMap<>();
        normalMap.put(1, "One");
        normalMap.put(2, "Two");
        System.out.println("普通HashMap（存在自动装箱）: " + normalMap);

        System.out.println("\n提示：Android项目中建议使用 SparseArray, LongSparseArray, ArrayMap 优化性能。");

        //==================== 4. 数组与集合的转换 ====================
        System.out.println("\n========== 4. 数组 <-> 集合转换 ==========");
        // 数组 -> List
        String[] arr = {"A", "B", "C"};
        java.util.List<String> listFromArray = java.util.Arrays.asList(arr);
        // 注意：asList 返回的 List 是固定长度的，不能 add/remove，但可以 set
        System.out.println("数组转List: " + listFromArray);
        // 要得到可变的 List
        java.util.ArrayList<String> mutableList = new java.util.ArrayList<>(java.util.Arrays.asList(arr));

        // List -> 数组
        java.util.ArrayList<Integer> intList = new java.util.ArrayList<>();
        intList.add(10); intList.add(20);
        Integer[] arrayFromList = intList.toArray(new Integer[0]);
        System.out.println("List转数组: " + java.util.Arrays.toString(arrayFromList));

        // 基本类型数组与集合转换（需要循环遍历，或使用Stream）
        int[] primitiveArr = {1,2,3};
        java.util.ArrayList<Integer> boxedList = new java.util.ArrayList<>();
        for (int num : primitiveArr) {
            boxedList.add(num);
        }
        System.out.println("基本类型数组转集合: " + boxedList);

        //==================== 5. 常见陷阱与注意事项 ====================
        System.out.println("\n========== 5. 常见陷阱 ==========");
        // 陷阱1：数组越界
        int[] smallArr = new int[3];
        // smallArr[3] = 10; // ArrayIndexOutOfBoundsException

        // 陷阱2：遍历时删除集合元素（使用迭代器）
        java.util.ArrayList<Integer> removeList = new java.util.ArrayList<>();
        removeList.add(1); removeList.add(2); removeList.add(3);
        // 错误方式（会引发 ConcurrentModificationException）
        // for (Integer num : removeList) {
        //     if (num == 2) removeList.remove(num);
        // }
        // 正确方式：使用 Iterator
        java.util.Iterator<Integer> it = removeList.iterator();
        while (it.hasNext()) {
            if (it.next() == 2) {
                it.remove();
            }
        }
        System.out.println("安全删除后: " + removeList);

        // 陷阱3：HashSet/HashMap 需要正确重写 hashCode 和 equals
        // 自定义类作为 key 时必须同时重写这两个方法，否则导致查找失败或内存泄漏

        // 陷阱4：Arrays.asList 返回的 List 是视图，不支持增删
        java.util.List<String> fixedList = java.util.Arrays.asList("a", "b");
        // fixedList.add("c"); // 抛出 UnsupportedOperationException

        // 陷阱5：基本类型数组不能直接作为泛型参数
        // List<int> wrong = new ArrayList<>(); // 编译错误，必须使用包装类

        // 陷阱6：集合容量与扩容（ArrayList 默认初始容量10，扩容1.5倍）
        // 如果预知元素数量，使用 ArrayList(int initialCapacity) 避免频繁扩容

        //==================== 6. 综合案例 ====================
        System.out.println("\n========== 6. 综合案例：学生成绩管理 ==========");
        // 使用 HashMap 存储学生姓名->成绩列表
        java.util.HashMap<String, java.util.ArrayList<Integer>> studentScores = new java.util.HashMap<>();

        // 添加成绩
        addScore(studentScores, "张三", 85);
        addScore(studentScores, "张三", 90);
        addScore(studentScores, "李四", 78);
        addScore(studentScores, "王五", 92);

        // 输出每个学生的总分和平均分
        for (java.util.Map.Entry<String, java.util.ArrayList<Integer>> entry : studentScores.entrySet()) {
            String name = entry.getKey();
            java.util.ArrayList<Integer> scores = entry.getValue();
            int sum = 0;
            for (int s : scores) sum += s;
            double avg = (double) sum / scores.size();
            System.out.printf("%s 总分=%d, 平均分=%.2f, 科目数=%d%n", name, sum, avg, scores.size());
        }

        // 找出最高分学生
        String topStudent = "";
        int maxTotal = -1;
        for (java.util.Map.Entry<String, java.util.ArrayList<Integer>> entry : studentScores.entrySet()) {
            int total = 0;
            for (int s : entry.getValue()) total += s;
            if (total > maxTotal) {
                maxTotal = total;
                topStudent = entry.getKey();
            }
        }
        System.out.println("总分最高的是: " + topStudent + "，总分=" + maxTotal);

        // 使用 TreeMap 对学生按姓名排序
        java.util.TreeMap<String, java.util.ArrayList<Integer>> sortedMap = new java.util.TreeMap<>(studentScores);
        System.out.println("按姓名排序的学生: " + sortedMap.keySet());

        //==================== 7. 总结 ====================
        printSummary();
    }

    // 辅助方法：添加成绩
    private static void addScore(java.util.HashMap<String, java.util.ArrayList<Integer>> map, String name, int score) {
        java.util.ArrayList<Integer> scores = map.get(name);
        if (scores == null) {
            scores = new java.util.ArrayList<>();
            map.put(name, scores);
        }
        scores.add(score);
    }

    private static void printSummary() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("📚 数组与集合 - 学习总结（Java / Android）");
        System.out.println("=".repeat(50));

        System.out.println("\n【数组 vs 集合】");
        System.out.println("▪ 数组：长度固定，内存连续，存取快，适合大小固定的数据");
        System.out.println("▪ 集合：动态扩容，功能丰富，适合业务数据管理");

        System.out.println("\n【常用集合选型】");
        System.out.println("▪ List   → ArrayList（随机读多）/ LinkedList（增删多）");
        System.out.println("▪ Set    → HashSet（一般去重）/ LinkedHashSet（保序）/ TreeSet（排序）");
        System.out.println("▪ Map    → HashMap（通用）/ LinkedHashMap（保序）/ TreeMap（排序）");
        System.out.println("▪ Android→ SparseArray（int键）/ ArrayMap（内存优化）");

        System.out.println("\n【遍历方式】");
        System.out.println("▪ 普通for: 需要索引时");
        System.out.println("▪ 增强for: 简洁只读");
        System.out.println("▪ Iterator: 边遍历边删除");
        System.out.println("▪ forEach + Lambda (Java 8+): list.forEach(System.out::println)");

        System.out.println("\n【常见陷阱】");
        System.out.println("⚠️  Arrays.asList 返回的是固定长度List");
        System.out.println("⚠️  遍历时直接删除集合元素会抛ConcurrentModificationException");
        System.out.println("⚠️  自定义类作为Map键或Set元素需重写hashCode和equals");
        System.out.println("⚠️  基本类型数组不能直接转List，需循环或Stream");
        System.out.println("⚠️  多线程环境下使用 Collections.synchronizedXXX 或 ConcurrentHashMap");

        System.out.println("\n【最佳实践】");
        System.out.println("💡 尽量使用接口类型声明：List<String> list = new ArrayList<>();");
        System.out.println("💡 合理初始化集合容量，减少扩容开销");
        System.out.println("💡 优先使用增强for，需要删除时用迭代器");
        System.out.println("💡 Android 中键为 int 时用 SparseArray 代替 HashMap<Integer, Object>");
        System.out.println("💡 使用 Collections.emptyList() 返回空不可变集合，避免 null");
        System.out.println("💡 数组拷贝用 Arrays.copyOf 或 System.arraycopy（底层高效）");
        System.out.println("💡 集合转数组时传递类型数组：list.toArray(new String[0])");
    }
}