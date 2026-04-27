//========================================
// 接口与抽象类 & 回调机制 - 核心笔记
//========================================

import abstracts.AbstractTask;
import abstracts.Animal;
import abstracts.FileParser;
import interfaces.*;
import view.View;

public class Main {
    public static void main(String[] args) {

        //========================================
        // 1. 接口 (Interface)
        //========================================
        /**
         * 接口是100%抽象的契约，定义了一组方法签名（无实现）。
         * 特点：
         *  - 所有方法默认 public abstract (Java 8 前)
         *  - Java 8 允许默认方法 (default) 和静态方法
         *  - Java 9 允许私有方法
         *  - 多继承：一个类可以实现多个接口
         *  - 不能有实例字段（只能有 static final 常量）
         */

        System.out.println("========== 1. 接口基础 ==========");

        // 接口实现类多态
        Drawable circle = new Circle();
        Drawable rectangle = new Rectangle();
        circle.draw();      // 输出: 画一个圆形
        rectangle.draw();   // 输出: 画一个矩形

        // 接口常量
        System.out.println("接口常量 PI = " + Drawable.PI);

        // Java 8 默认方法
        circle.printType();  // 接口中的默认方法，实现类可继承或重写


        //========================================
        // 2. 抽象类 (Abstract Class)
        //========================================
        /**
         * 抽象类是不能实例化的类，可以包含抽象方法（无实现）和具体方法。
         * 特点：
         *  - 可以有构造器、实例字段、具体方法
         *  - 单继承：一个类只能继承一个抽象类
         *  - 访问权限灵活（private, protected, public）
         *  - 适合定义公共基础行为和状态
         */

        System.out.println("\n========== 2. 抽象类基础 ==========");

        // 抽象类不能 new，但可以通过子类实例化
        Animal dog = new Dog("旺财");
        Animal cat = new Cat("咪咪");

        dog.makeSound();       // 子类具体实现
        cat.makeSound();

        dog.sleep();           // 抽象类中的具体方法（公共行为）

        System.out.println("狗的名字: " + ((Dog) dog).getName());


        //========================================
        // 3. 接口 vs 抽象类 对比
        //========================================
        /**
         * 特性              接口                        抽象类
         * ----------------------------------------------------------------
         * 关键字            interface                   abstract class
         * 实例化            不能                        不能
         * 多继承支持        一个类可实现多个接口        单继承
         * 构造器            无                          有
         * 字段              只能是 public static final  可以有实例字段, 非final
         * 方法              默认 public abstract        可以有抽象/具体方法
         * 访问修饰符        默认 public (方法)          任意修饰符
         * 新增方法影响      所有实现类需实现（除非默认方法） 子类可选实现
         * 使用场景          定义契约、能力、回调        代码复用、模板模式
         */

        printComparison();


        //========================================
        // 4. 回调机制 (Callback)
        //========================================
        /**
         * 回调是指：将一段可执行的代码作为参数传递给另一段代码，在适当时候被调用。
         * 在 Java 中通常通过接口实现。
         *
         * 核心要素：
         *  - 定义回调接口
         *  - 实现回调接口（匿名类、Lambda、实现类）
         *  - 将回调对象传递给执行者
         *  - 执行者在特定事件/时机调用回调方法
         */

        System.out.println("\n========== 4.1 经典接口回调 ==========");

        // 场景：下载任务，完成后回调通知
        DownloadTask task = new DownloadTask();
        // 传入回调接口的实现（匿名内部类）
        task.startDownload(new DownloadCallback() {
            @Override
            public void onSuccess(String filePath) {
                System.out.println("下载成功，文件保存到: " + filePath);
            }
            @Override
            public void onError(String errorMsg) {
                System.out.println("下载失败: " + errorMsg);
            }
        });

        // 场景：按钮点击回调（模拟）
        Button btn = new Button("提交");
        btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("按钮 \"" + v.getText() + "\" 被点击");
            }
        });
        btn.click();  // 模拟点击


        //========================================
        // 4.2 Lambda 表达式简化回调 (Java 8+)
        //========================================
        System.out.println("\n========== 4.2 Lambda 回调 ==========");

        // 对于只有一个抽象方法的接口（函数式接口），可用 Lambda
        Calculator calc = new Calculator();
        // 传统匿名类
        calc.compute(10, 5, new Operation() {
            @Override
            public int apply(int a, int b) {
                return a + b;
            }
        });

        // Lambda 表达式
        calc.compute(10, 5, (a, b) -> a - b);   // 减法
        calc.compute(10, 5, (a, b) -> a * b);   // 乘法

        // 更简明的例子：异步回调
        asyncFetchData(data -> {
            System.out.println("接收到数据: " + data);
            return data.length();
        });


        //========================================
        // 4.3 使用抽象类实现回调
        //========================================
        System.out.println("\n========== 4.3 抽象类回调 ==========");

        // 场景：文件解析器，提供模板方法，子类实现具体解析逻辑
        FileParser parser = new JsonParser();
        parser.parse("{\"name\":\"张三\"}");   // 模板方法内部调用 parseContent()

        // 回调还可以通过抽象类传递状态
        TimerTaskExample timer = new TimerTaskExample();
        timer.schedule(new AbstractTask() {
            @Override
            public void run() {
                System.out.println("定时任务执行 (抽象类回调)");
            }
        }, 1000);


        //========================================
        // 4.4 回调的应用场景
        //========================================
        System.out.println("\n========== 4.4 实际应用场景 ==========");

        // 场景1：事件监听（GUI、Android）
        // 场景2：异步任务（网络请求、文件IO）
        // 场景3：排序比较器 (Comparator)
        // 场景4：过滤、映射 (Stream API)
        // 场景5：策略模式、命令模式

        // 示例：使用 Comparator 接口回调进行排序
        String[] fruits = {"Apple", "Banana", "Orange", "Mango"};
        // 传入比较逻辑（Lambda是回调的一种形式）
        java.util.Arrays.sort(fruits, (s1, s2) -> s1.length() - s2.length());
        System.out.print("按长度排序后: ");
        for (String f : fruits) System.out.print(f + " ");
        System.out.println();


        //========================================
        // 5. 最佳实践与总结
        //========================================
        printSummary();
    }

    //==================== 辅助方法 ====================
    private static void printComparison() {
        System.out.println("\n========== 接口 vs 抽象类 对比表 ==========");
        System.out.println("+------------------------+----------------------------+----------------------------+");
        System.out.println("| 特性                    | 接口                        | 抽象类                      |");
        System.out.println("+------------------------+----------------------------+----------------------------+");
        System.out.println("| 关键字                  | interface                  | abstract class              |");
        System.out.println("| 多继承                  | 支持(实现多个接口)            | 不支持(单继承)               |");
        System.out.println("| 构造器                  | 无                         | 有                          |");
        System.out.println("| 实例字段                 | 只能 public static final   | 可以有任意字段                |");
        System.out.println("| 非抽象方法               | default/static (Java 8+)   | 可以有具体方法                |");
        System.out.println("| 访问修饰符               | 默认 public                 | 任意                        |");
        System.out.println("| 新增方法影响              | 实现类必须实现(except default)| 子类可选实现                |");
        System.out.println("| 设计意图                 | “能做什么”(Can-Do)          | “是什么”(Is-A)               |");
        System.out.println("+------------------------+----------------------------+----------------------------+");
    }

    // 异步数据获取模拟
    private static void asyncFetchData(DataCallback callback) {
        // 模拟异步操作
        String result = "模拟数据内容";
        int len = callback.onDataReceived(result);
        System.out.println("数据处理后长度: " + len);
    }

    private static void printSummary() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("📚 接口与抽象类 & 回调机制 - 核心总结");
        System.out.println("=".repeat(50));

        System.out.println("\n【接口核心】");
        System.out.println("▪ 定义能力契约，实现“多继承”效果");
        System.out.println("▪ Java 8 后可以写 default/static 方法");
        System.out.println("▪ 函数式接口(@FunctionalInterface)可配合Lambda");

        System.out.println("\n【抽象类核心】");
        System.out.println("▪ 代码复用，模板方法模式");
        System.out.println("▪ 可以持有状态（字段）");
        System.out.println("▪ 适合构建继承体系中的公共部分");

        System.out.println("\n【回调机制核心】");
        System.out.println("▪ 定义接口 -> 传递实现 -> 条件触发调用");
        System.out.println("▪ 常用方式：匿名内部类、Lambda、方法引用");
        System.out.println("▪ 同步回调：立即执行（如 Comparator）");
        System.out.println("▪ 异步回调：延迟执行（如网络请求）");

        System.out.println("\n【选择指南】");
        System.out.println("✅ 需要多实现、定义能力 → 接口");
        System.out.println("✅ 需要代码复用、共享状态 → 抽象类");
        System.out.println("✅ 需要解耦、事件驱动 → 回调（通常用接口）");
        System.out.println("✅ 函数式接口 + Lambda → 简洁回调");

        System.out.println("\n【常见陷阱】");
        System.out.println("⚠️ 接口 default 方法冲突：需重写");
        System.out.println("⚠️ 抽象类构造器调用被重写的方法（空指针风险）");
        System.out.println("⚠️ 回调中持有外部引用导致内存泄漏（如 Android Handler）");
        System.out.println("⚠️ Lambda 表达式只能用于函数式接口");
    }
}

