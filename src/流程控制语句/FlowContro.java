package 流程控制语句; // 遵循Java包命名规范（小写分层）

/**
 * Java 流程控制核心学习笔记
 * 核心涵盖：3大流程结构（顺序/分支/循环）
 * 重点模块：if-else分支、switch分支、for/while/do-while循环、循环控制（break/continue）
 * 特性：代码可直接运行、易错点高亮、注释详尽、结构清晰
 */
public class FlowContro {
    public static void main(String[] args) {
        // ============== 一、顺序结构（默认执行流程） ==============
        /**
         * 核心特性：
         * 1. 程序默认的执行流程，从上到下、逐行执行，无跳转
         * 2. 所有分支/循环结构的基础，嵌套在各类流程控制中
         */
        System.out.println("============== 一、顺序结构 ==============");
        int num1 = 10;
        int num2 = 20;
        int sum = num1 + num2;
        System.out.println("num1 = " + num1);
        System.out.println("num2 = " + num2);
        System.out.println("sum = num1 + num2 = " + sum);
        System.out.println("顺序结构：从上到下逐行执行完成\n");

        // ============== 二、分支结构（根据条件执行不同代码） ==============
        // 2.1 if 单分支结构
        System.out.println("============== 二、分支结构 ==============");
        System.out.println("--- 2.1 if 单分支 ---");
        /**
         * 语法格式：
         * if (条件表达式) {
         *     条件为true时执行的代码块;
         * }
         * 注意：条件表达式必须返回boolean类型（true/false）
         */
        int score = 85;
        System.out.println("当前分数：" + score);
        if (score >= 60) {
            System.out.println("单分支结果：成绩合格，无需补考");
        }

        // 2.2 if-else 双分支结构
        System.out.println("\n--- 2.2 if-else 双分支 ---");
        /**
         * 语法格式：
         * if (条件表达式) {
         *     条件为true时执行的代码块;
         * } else {
         *     条件为false时执行的代码块;
         * }
         * 特性：二选一执行，必有一个代码块会被执行
         */
        if (score >= 60) {
            System.out.println("双分支结果：成绩合格");
        } else {
            System.out.println("双分支结果：成绩不合格，需要补考");
        }

        // 2.3 if-else if-else 多分支结构
        System.out.println("\n--- 2.3 if-else if-else 多分支 ---");
        /**
         * 语法格式：
         * if (条件1) {
         *     条件1为true时执行;
         * } else if (条件2) {
         *     条件1为false、条件2为true时执行;
         * } else if (条件3) {
         *     条件1/2为false、条件3为true时执行;
         * } ...
         * else {
         *     所有条件都为false时执行;
         * }
         * 易错点1：条件判断有顺序性，优先满足前面的条件，后面的条件不再判断
         * 易错点2：else 模块可选，可根据需求省略
         */
        String grade;
        if (score >= 90) {
            grade = "优秀";
        } else if (score >= 80) {
            grade = "良好";
        } else if (score >= 70) {
            grade = "中等";
        } else if (score >= 60) {
            grade = "及格";
        } else {
            grade = "不及格";
        }
        System.out.println("多分支结果：成绩等级为 → " + grade);

        // 2.4 switch 多分支结构（支持等值判断）
        System.out.println("\n--- 2.4 switch 多分支 ---");
        /**
         * 语法格式：
         * switch (表达式) {
         *     case 常量1:
         *         表达式等于常量1时执行的代码;
         *         break; // 可选，用于跳出switch结构，避免case穿透
         *     case 常量2:
         *         表达式等于常量2时执行的代码;
         *         break;
         *     ...
         *     default: // 可选，所有case不匹配时执行，类似else
         *         默认执行的代码;
         *         break;
         * }
         * 支持的表达式类型：byte、short、int、char、String（Java 7+）、枚举
         * 核心易错点：case穿透（忘记写break时，会继续执行后续case的代码，无论常量是否匹配）
         */
        int week = 3;
        String weekName;
        switch (week) {
            case 1:
                weekName = "星期一";
                break; // 跳出switch，避免穿透
            case 2:
                weekName = "星期二";
                break;
            case 3:
                weekName = "星期三";
                break;
            case 4:
                weekName = "星期四";
                break;
            case 5:
                weekName = "星期五";
                break;
            case 6:
                weekName = "星期六";
                break;
            case 7:
                weekName = "星期日";
                break;
            default:
                weekName = "无效星期数";
                break;
        }
        System.out.println("switch结果：今天是 → " + weekName);

        // 演示case穿透（故意省略break）
        System.out.println("\n--- 演示case穿透（易错点） ---");
        int num = 2;
        switch (num) {
            case 1:
                System.out.println("执行case 1");
                break;
            case 2:
                System.out.println("执行case 2（未写break）");
            case 3:
                System.out.println("穿透到case 3，无需匹配直接执行");
            default:
                System.out.println("穿透到default，无需匹配直接执行");
        }

        // ============== 三、循环结构（重复执行指定代码） ==============
        /**
         * 核心特性：满足循环条件时，重复执行代码块（循环体）
         * 三大循环：for、while、do-while
         * 循环四要素：初始化表达式、条件判断表达式、循环体、更新表达式
         */
        System.out.println("\n============== 三、循环结构 ==============");

        // 3.1 for 循环（适合明确循环次数的场景）
        System.out.println("--- 3.1 for 循环 ---");
        /**
         * 语法格式：
         * for (初始化表达式; 条件判断表达式; 更新表达式) {
         *     循环体（满足条件时重复执行的代码）;
         * }
         * 执行流程：
         * 1. 执行初始化表达式（仅执行1次）
         * 2. 判断条件表达式：true → 执行循环体；false → 跳出循环
         * 3. 执行更新表达式
         * 4. 重复步骤2-3，直到条件为false
         */
        // 示例：打印1-5的整数
        for (int i = 1; i <= 5; i++) {
            System.out.print(i + " ");
        }
        System.out.println("\nfor循环执行完成");

        // 3.2 while 循环（适合循环次数不明确的场景）
        System.out.println("\n--- 3.2 while 循环 ---");
        /**
         * 语法格式：
         * 初始化表达式;
         * while (条件判断表达式) {
         *     循环体;
         *     更新表达式;
         * }
         * 执行流程：先判断，后执行（条件不满足时，循环体一次都不执行）
         * 易错点：忘记写更新表达式，会导致死循环
         */
        // 示例：计算1-10的累加和
        int i = 1;
        int sumWhile = 0;
        while (i <= 10) {
            sumWhile += i; // 累加
            i++; // 更新表达式，避免死循环
        }
        System.out.println("1-10的累加和（while循环）：" + sumWhile);

        // 3.3 do-while 循环（至少执行一次循环体的场景）
        System.out.println("\n--- 3.3 do-while 循环 ---");
        /**
         * 语法格式：
         * 初始化表达式;
         * do {
         *     循环体;
         *     更新表达式;
         * } while (条件判断表达式);
         * 执行流程：先执行，后判断（无论条件是否满足，循环体至少执行1次）
         * 区别于while：while先判断后执行，do-while先执行后判断
         */
        // 示例：即使条件不满足，仍执行一次循环体
        int j = 11;
        int sumDoWhile = 0;
        do {
            sumDoWhile += j;
            j++;
            System.out.println("do-while循环体执行（此时j=" + j + "，条件不满足仍执行）");
        } while (j <= 10);
        System.out.println("11的累加和（do-while循环）：" + sumDoWhile);

        // 3.4 循环控制：break & continue
        System.out.println("\n--- 3.4 循环控制（break/continue） ---");
        /**
         * break：跳出当前整个循环（for/while/do-while）或switch结构，不再执行后续循环
         * continue：跳过当前次循环的剩余代码，直接进入下一次循环的判断/更新
         */
        // 示例1：break跳出循环（打印1-5，遇到3时终止循环）
        System.out.println("示例1：break跳出循环");
        for (int k = 1; k <= 5; k++) {
            if (k == 3) {
                break; // 跳出整个for循环
            }
            System.out.print(k + " ");
        }
        System.out.println("\nbreak循环终止");

        // 示例2：continue跳过当前次循环（打印1-5，跳过3）
        System.out.println("\n示例2：continue跳过当前次循环");
        for (int k = 1; k <= 5; k++) {
            if (k == 3) {
                continue; // 跳过本次循环剩余代码，直接执行k++
            }
            System.out.print(k + " ");
        }
        System.out.println("\ncontinue循环执行完成");

        // 3.5 嵌套循环（循环中嵌套另一个循环）
        System.out.println("\n--- 3.5 嵌套循环（打印九九乘法表简化版） ---");
        /**
         * 特性：外层循环执行1次，内层循环执行完整一轮
         * 示例：打印3*3乘法表
         */
        for (int row = 1; row <= 3; row++) { // 外层循环：控制行数
            for (int col = 1; col <= row; col++) { // 内层循环：控制列数
                System.out.print(row + "*" + col + "=" + (row * col) + "\t");
            }
            System.out.println(); // 换行
        }
    }
}