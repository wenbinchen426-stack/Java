///========================================2.引用数据类型====================================================================
public class Main {
    public static void main(String[] args) {
/**
 ================================================== 什么是引用数据类型 ======================================================
 引用数据类型 vs 基本数据类型：
 方面          基本类型                        引用类型
 ------------------------------------------------------------------------------------------------------------------------
 存储内容      具体的值（如100, true）          内存地址（指向堆中的对象）
 内存位置      栈内存                         变量在栈，对象在堆
 默认值        0, 0.0, false 等              null
 赋值操作      直接复制值（独立）               复制地址（多个变量指向同一对象）
 大小         固定大小                      引用大小固定(4/8字节)，对象大小可变
 ================================================== 引用类型的分类 =========================================================
 1. 类 (Class)           - String, 自定义类, 系统类(Activity, Button等)
 2. 接口 (Interface)     - Runnable, OnClickListener, List等
 3. 数组 (Array)         - int[], String[], 对象数组
 4. 枚举 (Enum)          - 特殊的类，用于定义常量集合
 5. 注解 (Annotation)    - @Override, @Nullable 等
 */

        // ========== 1. 类 (Class) ==========
        System.out.println("========== 1. 类 (Class) ==========");

        // String 是最常用的引用类型
        String name = "张三";                    // 字符串字面量
        String nickname = new String("三哥");    // 使用构造器
        System.out.println("姓名: " + name);
        System.out.println("昵称: " + nickname);

        // 自定义类的对象
        Person person1 = new Person("李四", 25);
        Person person2 = person1;               // 引用赋值，指向同一对象
        person2.setAge(26);                      // 修改person2会影响person1
        System.out.println("person1年龄: " + person1.getAge());  // 输出26
        System.out.println("person2年龄: " + person2.getAge());  // 输出26

        // null 表示不指向任何对象
        Person person3 = null;
        if (person3 == null) {
            System.out.println("person3 是 null，未指向任何对象");
        }

        // 常见陷阱：调用 null 对象的方法会抛出 NullPointerException
        // person3.getName();  // 运行时崩溃！

        // ========== 2. 接口 (Interface) ==========
        System.out.println("\n========== 2. 接口 (Interface) ==========");

        // 使用匿名内部类实现接口
        Runnable task = new Runnable() {
            @Override
            public void run() {
                System.out.println("任务执行中...");
            }
        };
        task.run();

        // Lambda表达式 (Java 8+)
        Runnable lambdaTask = () -> System.out.println("Lambda任务执行中...");
        lambdaTask.run();

        // 接口作为方法参数（多态）
        MyInterface.testInterface(() -> System.out.println("传入的Runnable被执行"));

        // ========== 3. 数组 (Array) ==========
        System.out.println("\n========== 3. 数组 (Array) ==========");

        // 基本类型数组
        int[] intArray = new int[5];           // 默认值都是0
        int[] intArray2 = {1, 2, 3, 4, 5};    // 静态初始化
        int[] intArray3 = new int[]{10, 20, 30};

        System.out.println("int数组长度: " + intArray2.length);
        System.out.print("int数组元素: ");
        for (int num : intArray2) {
            System.out.print(num + " ");
        }
        System.out.println();

        // 引用类型数组
        String[] strArray = new String[3];      // 默认值都是 null
        strArray[0] = "Hello";
        strArray[1] = "World";
        // strArray[2] 还是 null

        Person[] persons = new Person[2];
        persons[0] = new Person("王五", 30);
        persons[1] = new Person("赵六", 28);

        // 二维数组
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println("二维数组[1][1]: " + matrix[1][1]);  // 输出5

        // ========== 4. 枚举 (Enum) ==========
        System.out.println("\n========== 4. 枚举 (Enum) ==========");

        // 使用枚举
        Day today = Day.MONDAY;
        System.out.println("今天是: " + today);
        System.out.println("今天是周几: " + today.getChineseName());

        // switch 中使用枚举
        switch (today) {
            case SATURDAY:
            case SUNDAY:
                System.out.println("周末，休息！");
                break;
            default:
                System.out.println("工作日，加油！");
                break;
        }

        // 遍历所有枚举值
        System.out.print("一周的所有天: ");
        for (Day d : Day.values()) {
            System.out.print(d + " ");
        }
        System.out.println();

        // ========== 5. 注解 (Annotation) ==========
        System.out.println("\n========== 5. 注解 (Annotation) ==========");

        MyClass obj = new MyClass();
        obj.oldMethod();    // 已被标记为废弃
        obj.newMethod();

        // ========== 引用类型的特殊特性 ==========
        System.out.println("\n========== 引用类型的特殊特性 ==========");

        // 1. 引用赋值 vs 基本类型赋值
        System.out.println("【特性1】引用赋值 vs 基本类型赋值:");

        // 基本类型：独立副本
        int a = 10;
        int b = a;          // 复制值
        b = 20;             // 修改b不影响a
        System.out.println("  基本类型: a=" + a + ", b=" + b);  // a=10, b=20

        // 引用类型：共享对象
        int[] arr1 = {1, 2, 3};
        int[] arr2 = arr1;  // 复制引用（地址）
        arr2[0] = 100;      // 修改arr2会影响arr1
        System.out.println("  引用类型: arr1[0]=" + arr1[0] + ", arr2[0]=" + arr2[0]);  // 都是100

        // 2. 方法参数传递（值传递，但引用传递的是地址值）
        System.out.println("\n【特性2】方法参数传递:");

        int num = 10;
        MyInterface.modifyPrimitive(num);     // 基本类型：不会被修改
        System.out.println("  基本类型参数修改后: " + num);  // 仍然是10

        Person p = new Person("小明", 18);
        MyInterface.modifyReference(p);       // 引用类型：可以修改对象内部属性
        System.out.println("  引用类型参数修改后: " + p.getName() + ", " + p.getAge());  // 小红, 20

        // 3. 比较操作（== 与 equals）
        System.out.println("\n【特性3】比较操作:");

        String s1 = "hello";
        String s2 = "hello";
        String s3 = new String("hello");

        System.out.println("  s1 == s2: " + (s1 == s2));           // true（字符串常量池）
        System.out.println("  s1 == s3: " + (s1 == s3));           // false（不同对象）
        System.out.println("  s1.equals(s3): " + s1.equals(s3));   // true（内容相同）

        // 4. 垃圾回收（GC）
        System.out.println("\n【特性4】垃圾回收:");
        Person temp = new Person("临时对象", 99);
        temp = null;              // 对象不再被引用，等待GC回收
        //System.gap();              // 建议JVM进行垃圾回收（不一定立即执行）
        System.out.println("已建议JVM进行垃圾回收");

        // ========== 总结 ==========
        printSummary();
    }

    // ========== 总结表 ==========
    private static void printSummary() {
        System.out.println("\n========== 引用类型总结 ==========");
        System.out.println("- 类(Class): 对象的蓝图，使用new创建实例");
        System.out.println("- 接口(Interface): 定义契约，实现多态");
        System.out.println("- 数组(Array): 存储同类型元素的容器");
        System.out.println("- 枚举(Enum): 预定义的常量集合");
        System.out.println("- 注解(Annotation): 元数据，提供额外信息");
        System.out.println("\n【核心要点】");
        System.out.println("1. 引用类型变量存储的是内存地址，不是实际数据");
        System.out.println("2. 默认值是null，使用前必须初始化，否则NPE");
        System.out.println("3. 赋值操作复制的是引用（地址），多个变量可指向同一对象");
        System.out.println("4. == 比较引用地址，equals() 比较内容（需重写）");
        System.out.println("5. 方法参数传递是值传递，但引用类型传递的是地址值");
    }
}

