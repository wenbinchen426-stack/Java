package 运算符; // 优化包名：遵循Java规范（小写+反向域名格式，避免简单中文/单个单词）

/**
 * Java 运算符核心学习笔记
 * 核心涵盖：4大类核心运算符（算术、自增自减、关系、逻辑）+ 三元运算符
 * 优化亮点：结构化清晰、易错点高亮、运行结果可预测、代码可直接运行
 * 关键特性：注释详尽、变量统一管理、对比式演示（便于理解差异）
 */
public class Operator { // 优化类名：采用大驼峰命名法，语义更清晰

    public static void main(String[] args) {
        /// 1. 统一定义测试变量（集中初始化，便于修改和跟踪，避免分散定义的混乱）
        int a = 10;
        int b = 20;
        int c = 25;
        char charD = 'd'; // 优化变量名：避免单个字母（除循环变量外），明确语义（ASCII码：100）
        char charE = 'e'; // ASCII码：101
        boolean flag = true; // 逻辑运算专用测试变量
        int num1 = 10;
        int num2 = 20;



        /// 2. 基本算术运算符（+、-、*、/、%）
        System.out.println("============== 一、基本算术运算符 ==============");
        System.out.println("a + b = " + (a + b)); // 加法运算：结果30
        System.out.println("a - b = " + (a - b)); // 减法运算：结果-10
        System.out.println("a * b = " + (a * b)); // 乘法运算：结果200


        /// 易错点1：整数除法仅保留整数部分，舍弃小数（如需浮点结果，需将其中一个操作数转为浮点型）
        System.out.println("b / a = " + (b / a)); // 整数除法：结果2（而非2.0）
        System.out.println("b / (double)a = " + (b / (double)a)); // 浮点除法：结果2.0（优化补充）


        /// 易错点2：取模运算（%）结果的符号与被除数一致，核心是求余数
        System.out.println("b % a = " + (b % a)); // 取模运算：20÷10余0，结果0
        System.out.println("c % a = " + (c % a)); // 取模运算：25÷10余5，结果5
        System.out.println("-c % a = " + (-c % a)); // 补充示例：被除数为负，结果-5（优化补充）


        /// 特性：字符参与算术运算时，自动转换为对应的ASCII码值进行计算
        System.out.println("charD + charE（ASCII码计算） = " + (charD + charE)); // 100+101=201


        /// 易错点3：+号具有双重含义：算术加法 & 字符串拼接（遇字符串优先执行拼接）
        System.out.println("字符串拼接示例：charD=" + charD + "，charE=" + charE); // 输出：charD=d，charE=e
        System.out.println("算术加法强制优先级：" + "charD+charE=" + (charD + charE)); // 输出：charD+charE=201（优化补充）


        /// 3. 自增/自减运算符（++、--）【核心原则：前置先运算后使用，后置先使用后运算】
        System.out.println("\n============== 二、自增/自减运算符 ==============");
        a = 10; // 重置a的值，避免前面算术运算对后续测试造成干扰
        System.out.println("a 初始值 = " + a); // 初始值：10



        // 后置自增：先返回a的原始值，再执行a = a + 1
        System.out.println("a++ 输出值 = " + a++ + "，执行后a = " + a); // 输出10，执行后a=11


        /// 前置自增：先执行a = a + 1，再返回a的新值
        System.out.println("++a 输出值 = " + ++a + "，执行后a = " + a); // 输出12，执行后a=12


        /// 后置自减：先返回a的原始值，再执行a = a - 1
        System.out.println("a-- 输出值 = " + a-- + "，执行后a = " + a); // 输出12，执行后a=11


        /// 前置自减：先执行a = a - 1，再返回a的新值
        System.out.println("--a 输出值 = " + --a + "，执行后a = " + a); // 输出10，执行后a=10



        /// 4. 关系运算符（==、!=、>、<、>=、<=）【核心特性：返回值永远是boolean类型（true/false）】
        System.out.println("\n============== 三、关系运算符 ==============");
        System.out.println("a == b （10==20）: " + (a == b)); // 结果：false
        System.out.println("a != b （10!=20）: " + (a != b)); // 结果：true
        System.out.println("a > b  （10>20） : " + (a > b));  // 结果：false
        System.out.println("a < b  （10<20） : " + (a < b));  // 结果：true
        System.out.println("a >= b （10>=20）: " + (a >= b)); // 结果：false
        System.out.println("c >= b （25>=20）: " + (c >= b)); // 结果：true


        /// 补充：字符也可参与关系运算（按ASCII码值比较大小）（优化补充）
        System.out.println("charD > charE （'d'>'e'）: " + (charD > charE)); // 100>101，结果：false


        /// 5. 逻辑运算符（&、|、^、!、&&、||）【操作数：boolean类型；返回值：boolean类型】
        System.out.println("\n============== 四、逻辑运算符 ==============");


        /// 基础逻辑运算（非短路：&、|、^、!）
        System.out.println("--- 基础逻辑运算 ---");
        System.out.println("a > b & a < c （false & true）: " + (a > b & a < c)); // 逻辑与：全true才返回true，结果：false
        System.out.println("a > b | a < c （false | true）: " + (a > b | a < c)); // 逻辑或：有true就返回true，结果：true
        System.out.println("a > b ^ a < c （false ^ true）: " + (a > b ^ a < c)); // 逻辑异或：两值不同返回true，结果：true
        System.out.println("!flag （!true）: " + !flag);            // 逻辑非：取反，结果：false


        /// 核心重点：短路逻辑运算（&&、||）【性能优化：满足条件时，右侧表达式不执行】
        System.out.println("--- 短路逻辑运算（重点） ---");


        a = 10; // 重置a的值，确保测试准确性
        /// 短路与（&&）：左侧为false时，右侧表达式直接跳过（不执行）
        System.out.println("(a > b) && (a++) < c （false && ...）: " + ((a > b) && (a++) < c)); // 结果：false
        System.out.println("短路与后a的值：" + a); // a仍为10（右侧a++未执行，核心差异点）


        a = 10; // 重置a的值
        /// 短路或（||）：左侧为true时，右侧表达式直接跳过（不执行）
        System.out.println("(c > b) || (a++) < c （true || ...）: " + ((c > b) || (a++) < c)); // 结果：true
        System.out.println("短路或后a的值：" + a); // a仍为10（右侧a++未执行，核心差异点）


        a = 10; // 重置a的值
        /// 对比：普通与（&）：无论左侧结果如何，右侧表达式都会执行（无短路效果）
        System.out.println("--- 普通与（&）vs 短路与（&&）对比 ---");
        System.out.println("(a > b) & (a++) < c （false & ...）: " + ((a > b) & (a++) < c)); // 结果：false
        System.out.println("普通与后a的值：" + a); // a变为11（右侧a++已执行，核心差异点）


        /// 6. 三元运算符（扩展补充：原有代码末尾存在，此处结构化整理）
        System.out.println("\n============== 五、三元运算符（补充） ==============");
        /// 语法格式：条件表达式 ? 表达式1 : 表达式2
        /// 核心规则：条件为true时执行表达式1，为false时执行表达式2，两表达式类型需一致
        int result1 = (num1 < a) ? num1 : a;
        int result2 = (num2 > a) ? num2 : a;
        System.out.println("num1 < a （10<10）? num1 : a → 结果：" + result1); // 条件false，返回a=10
        System.out.println("num2 > a （20>10）? num2 : a → 结果：" + result2); // 条件true，返回num2=20


        /// 易错点：三元运算符嵌套（谨慎使用，保证可读性）（优化补充）
        int maxNum = (a > b) ? ((a > c) ? a : c) : ((b > c) ? b : c);
        System.out.println("a、b、c中的最大值：" + maxNum); // 结果：25
    }
}