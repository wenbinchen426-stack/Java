//========================================
// 流程控制 - 完整学习笔记
//========================================

public class Mian {
    public static void main(String[] args) {

        //========================================
        // 1. 概述：三大流程控制结构
        //========================================
        /**
         * 顺序结构    - 程序按代码书写顺序依次执行（默认）
         * 选择结构    - 根据条件决定执行哪些代码（if, if-else, switch）
         * 循环结构    - 重复执行某段代码（for, while, do-while）
         * 跳转语句    - 改变执行流程（break, continue, return）
         */

        //==================== 2. 选择结构 ====================
        System.out.println("========== 2.1 if语句 ==========");

        // 2.1.1 单分支 if
        int score = 85;
        if (score >= 60) {
            System.out.println("成绩及格：" + score);
        }

        // 2.1.2 双分支 if-else
        int age = 17;
        if (age >= 18) {
            System.out.println("成年人，可以上网");
        } else {
            System.out.println("未成年人，禁止上网");
        }

        // 2.1.3 多分支 if-else if-else
        int grade = 78;
        if (grade >= 90) {
            System.out.println("等级：优秀");
        } else if (grade >= 80) {
            System.out.println("等级：良好");
        } else if (grade >= 70) {
            System.out.println("等级：中等");
        } else if (grade >= 60) {
            System.out.println("等级：及格");
        } else {
            System.out.println("等级：不及格");
        }

        // 2.1.4 嵌套 if
        int num = 15;
        if (num > 0) {
            if (num % 2 == 0) {
                System.out.println(num + " 是正偶数");
            } else {
                System.out.println(num + " 是正奇数");
            }
        } else if (num < 0) {
            System.out.println(num + " 是负数");
        } else {
            System.out.println("数字是0");
        }

        // ⚠️ 注意：else 与最近的 if 配对（大括号明确作用域可避免歧义）
        int a = 5, b = 3;
        if (a > b)
            if (a > 10)
                System.out.println("a大于10");
            else
                System.out.println("这个else属于内层if");  // 容易混淆，建议总是使用大括号

        // 推荐写法：明确大括号
        if (a > b) {
            if (a > 10) {
                System.out.println("a大于10");
            }
        } else {
            System.out.println("a <= b");
        }

        System.out.println("\n========== 2.2 switch语句 ==========");

        // switch支持类型：byte, short, int, char, String (Java 7+), 枚举
        int dayOfWeek = 3;
        String dayName;

        switch (dayOfWeek) {
            case 1:
                dayName = "Monday";
                break;
            case 2:
                dayName = "Tuesday";
                break;
            case 3:
                dayName = "Wednesday";
                break;
            case 4:
                dayName = "Thursday";
                break;
            case 5:
                dayName = "Friday";
                break;
            case 6:
                dayName = "Saturday";
                break;
            case 7:
                dayName = "Sunday";
                break;
            default:
                dayName = "Invalid day";
                break;
        }
        System.out.println("星期" + dayOfWeek + " = " + dayName);

        // switch 穿透现象（故意省略break）
        int month = 4;
        String season;
        switch (month) {
            case 12:
            case 1:
            case 2:
                season = "冬季";
                break;
            case 3:
            case 4:
            case 5:
                season = "春季";
                break;
            case 6:
            case 7:
            case 8:
                season = "夏季";
                break;
            case 9:
            case 10:
            case 11:
                season = "秋季";
                break;
            default:
                season = "未知季节";
        }
        System.out.println(month + "月属于：" + season);

        // switch 使用字符串 (Java 7+)
        String fruit = "apple";
        switch (fruit) {
            case "apple":
                System.out.println("苹果是红色的");
                break;
            case "banana":
                System.out.println("香蕉是黄色的");
                break;
            default:
                System.out.println("未知水果");
        }

        // 新语法：switch 表达式 (Java 14+, 可使用 -> 和 yield)
        // 示例（需Java 14+）：
        // int numLetters = switch (dayName) {
        //     case "Monday", "Sunday" -> 6;
        //     case "Tuesday" -> 7;
        //     default -> {
        //         int len = dayName.length();
        //         yield len;
        //     }
        // };

        //==================== 3. 循环结构 ====================
        System.out.println("\n========== 3.1 for循环 ==========");

        // 3.1.1 标准for循环
        System.out.print("1到10累加：");
        int sum = 0;
        for (int i = 1; i <= 10; i++) {
            sum += i;
        }
        System.out.println(sum);

        // 3.1.2 循环的三个表达式缺一不可（可省略，但分号必须）
        int j = 0;
        for ( ; j < 5; j++) {
            System.out.print(j + " ");
        }
        System.out.println();

        // 3.1.3 无限for循环
        // for (;;) { System.out.println("无限循环"); }  // 需谨慎使用

        // 3.1.4 多个变量初始化和多个更新
        for (int i = 0, k = 10; i < k; i++, k--) {
            System.out.println("i=" + i + ", k=" + k);
        }

        System.out.println("\n========== 3.2 增强for循环 (foreach) ==========");

        // 用于数组或Iterable集合
        int[] numbers = {1, 2, 3, 4, 5};
        System.out.print("数组元素：");
        for (int n : numbers) {
            System.out.print(n + " ");
        }
        System.out.println();

        String[] names = {"Alice", "Bob", "Charlie"};
        for (String name : names) {
            System.out.println("Hello, " + name);
        }

        // 注意：增强for循环不能修改数组/集合的结构，也不能直接修改基本类型数组的元素值（修改的是副本）
        for (int n : numbers) {
            n = n * 2;  // 无效，不影响原数组
        }
        // 需要修改元素时使用标准for循环
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] *= 2;
        }
        System.out.print("修改后数组：");
        for (int n : numbers) System.out.print(n + " ");
        System.out.println();

        System.out.println("\n========== 3.3 while循环 ==========");

        // 入口条件循环（先判断后执行）
        int count = 0;
        while (count < 5) {
            System.out.print(count + " ");
            count++;
        }
        System.out.println();

        // 常见用法：读取用户输入直到特定条件
        // Scanner scanner = new Scanner(System.in);
        // String input = "";
        // while (!input.equals("quit")) {
        //     input = scanner.next();
        //     System.out.println("你输入了: " + input);
        // }

        // 无限while循环
        // while (true) { ... } 常用break跳出

        System.out.println("\n========== 3.4 do-while循环 ==========");

        // 出口条件循环（至少执行一次）
        int n = 0;
        do {
            System.out.print(n + " ");
            n++;
        } while (n < 0);  // 条件为false，但循环体已执行一次
        System.out.println("\ndo-while至少执行了一次，尽管条件不满足");

        // 实际案例：菜单选择至少显示一次
        // int choice;
        // do {
        //     System.out.println("1. 开始游戏  2. 设置  3. 退出");
        //     choice = scanner.nextInt();
        // } while (choice != 3);

        //==================== 4. 跳转语句 ====================
        System.out.println("\n========== 4.1 break语句 ==========");

        // 4.1.1 退出当前循环
        for (int i = 1; i <= 10; i++) {
            if (i == 5) {
                System.out.println("遇到5，终止循环");
                break;  // 跳出for循环
            }
            System.out.print(i + " ");
        }
        System.out.println();

        // 4.1.2 带标签的break（跳出多层循环）
        outer:  // 标签
        for (int i = 0; i < 3; i++) {
            for (int k = 0; k < 3; k++) {
                if (i == 1 && k == 1) {
                    System.out.println("break outer, 跳出所有循环");
                    break outer;
                }
                System.out.println("i=" + i + ", k=" + k);
            }
        }
        System.out.println("循环结束");

        System.out.println("\n========== 4.2 continue语句 ==========");

        // 跳过本次循环剩余语句，继续下一次迭代
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                continue;  // 跳过偶数
            }
            System.out.print(i + " ");
        }
        System.out.println(" ← 只打印奇数");

        // 带标签的continue（跳过外层循环的当前迭代）
        outer2:
        for (int i = 0; i < 3; i++) {
            for (int k = 0; k < 3; k++) {
                if (k == 1) {
                    System.out.println("continue outer2, 跳过i=" + i + "的剩余内层循环，进入下一次外层");
                    continue outer2;
                }
                System.out.println("i=" + i + ", k=" + k);
            }
        }

        System.out.println("\n========== 4.3 return语句 ==========");

        // 结束当前方法，返回到调用者
        int result = add(3, 5);
        System.out.println("3 + 5 = " + result);

        // 在void方法中，return; 提前返回
        printIfPositive(10);
        printIfPositive(-5);

        //==================== 5. 流程控制最佳实践与陷阱 ====================
        System.out.println("\n========== 5. 常见陷阱与注意事项 ==========");

        // 陷阱1：浮点数比较（不要直接比较）
        double d1 = 0.1 + 0.2;
        double d2 = 0.3;
        if (Math.abs(d1 - d2) < 1e-6) {
            System.out.println("d1 和 d2 近似相等");
        } else {
            System.out.println("d1=" + d1 + " d2=" + d2);  // 可能输出0.30000000000000004 != 0.3
        }

        // 陷阱2：switch忘记break导致穿透
        int option = 1;
        switch (option) {
            case 1:
                System.out.println("执行case 1");
                // 没有break，会继续执行case 2
            case 2:
                System.out.println("执行case 2");
                break;
            default:
                System.out.println("default");
        }

        // 陷阱3：循环条件永远为真（无限循环）
        // int i = 0;
        // while (i < 10) {
        //     System.out.println(i);
        //     // 忘记 i++ 导致无限循环
        // }

        // 陷阱4：在for循环的循环体内修改循环变量导致意想不到的结果
        for (int i = 0; i < 10; i++) {
            System.out.print(i + " ");
            i++;  // 跳过了一些值
        }
        System.out.println(" ← 注意：循环体内修改了i");

        // 陷阱5：分号误加
        int sum2 = 0;
        for (int i = 0; i < 5; i++); {  // 分号使循环体为空
            //sum2 += i;  // 这里的i未定义（编译错误示例，实际会报错）
        }
        // 正确写法：去掉分号

        // 陷阱6：else悬吊问题（使用大括号解决）
        boolean condition1 = true;
        boolean condition2 = false;
        if (condition1)
            if (condition2)
                System.out.println("内层if");
            else
                System.out.println("这个else属于内层if？");  // 实际属于内层if，容易误解

        //==================== 6. 综合案例 ====================
        System.out.println("\n========== 6. 综合案例：猜数字游戏 ==========");

        // 模拟猜数字（1-100），最多7次机会
        int target = (int)(Math.random() * 100) + 1;
        int guess;
        int attempts = 0;
        int maxAttempts = 7;
        boolean guessed = false;

        System.out.println("猜数字游戏开始！数字范围1-100，你有7次机会。");
        // 这里为了演示不实际读取输入，直接硬编码模拟
        // 实际会用Scanner
        int[] guesses = {50, 75, 62, 68, 65};  // 模拟猜测序列

        for (int g : guesses) {
            attempts++;
            if (g == target) {
                System.out.println("恭喜！第" + attempts + "次猜中，数字就是" + target);
                guessed = true;
                break;
            } else if (g < target) {
                System.out.println("第" + attempts + "次猜" + g + "，太小了");
            } else {
                System.out.println("第" + attempts + "次猜" + g + "，太大了");
            }
            if (attempts == maxAttempts) {
                System.out.println("机会用尽！正确答案是：" + target);
                break;
            }
        }
        if (!guessed && attempts < maxAttempts) {
            System.out.println("最终未猜中，答案是" + target);
        }

        //==================== 7. 总结 ====================
        printSummary();
    }

    // 辅助方法演示return
    private static int add(int x, int y) {
        return x + y;
    }

    private static void printIfPositive(int num) {
        if (num <= 0) {
            System.out.println("数字" + num + "不是正数，不打印");
            return;  // 提前返回
        }
        System.out.println("正数: " + num);
    }

    // 总结
    private static void printSummary() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("📚 流程控制 - 学习总结");
        System.out.println("=".repeat(50));

        System.out.println("\n【选择结构】");
        System.out.println("▪ if / if-else / if-else if-else  - 适合范围判断");
        System.out.println("▪ switch - 适合等值判断，支持byte/short/int/char/String/枚举");

        System.out.println("\n【循环结构】");
        System.out.println("▪ for      - 已知循环次数时使用");
        System.out.println("▪ for-each - 遍历数组或集合，简洁但不可修改结构");
        System.out.println("▪ while    - 先判断后执行，可能一次都不执行");
        System.out.println("▪ do-while - 先执行后判断，至少执行一次");

        System.out.println("\n【跳转语句】");
        System.out.println("▪ break     - 退出当前循环或switch，可带标签退出多层");
        System.out.println("▪ continue  - 跳过本次循环剩余部分，继续下一次");
        System.out.println("▪ return    - 结束当前方法，返回调用处");

        System.out.println("\n【常见陷阱】");
        System.out.println("⚠️  else 与最近的 if 配对，建议使用大括号");
        System.out.println("⚠️  switch 忘记 break 导致穿透");
        System.out.println("⚠️  浮点数不宜直接用 == 比较");
        System.out.println("⚠️  分号误加导致循环体为空");
        System.out.println("⚠️  循环体内修改循环变量导致逻辑错误");
        System.out.println("⚠️  无限循环（条件永远为真）");

        System.out.println("\n【最佳实践】");
        System.out.println("💡 始终使用大括号包裹 if/else/循环体");
        System.out.println("💡 循环尽量避免嵌套过深（不超过3层）");
        System.out.println("💡 优先使用 for-each 遍历集合，代码更清晰");
        System.out.println("💡 复杂条件抽取为布尔变量或方法，提高可读性");
        System.out.println("💡 避免在循环中创建不必要的对象");
        System.out.println("💡 使用有意义的标签（break outer）");
        System.out.println("💡 将循环不变的计算移出循环");
    }
}