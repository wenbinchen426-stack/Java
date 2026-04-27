//========================================
// Java / Android 运算符 - 完整学习笔记
//========================================
// 适用场景：Android 开发中的数据处理、条件判断、位掩码、逻辑控制等
// 运算符是对常量或变量进行操作的符号，根据操作数个数分为：一元、二元、三元运算符

public class Main {
    public static void main(String[] args) {

        //========================================
        // 1. 运算符分类总览
        //========================================
        /**
         * 算术运算符      +  -  *  /  %  ++  --
         * 关系运算符      ==  !=  >  <  >=  <=
         * 逻辑运算符      &&  ||  !
         * 位运算符        &  |  ^  ~  <<  >>  >>>
         * 赋值运算符      =  +=  -=  *=  /=  %=  &=  |=  ^=  <<=  >>=  >>>=
         * 条件运算符（三元） ? :
         * instanceof 运算符
         * 其他           new  (type)  []  .  ()
         */

        //==================== 2. 算术运算符 ====================
        System.out.println("========== 2.1 算术运算符 ==========");

        int a = 10, b = 3;
        System.out.println("a + b = " + (a + b));   // 13
        System.out.println("a - b = " + (a - b));   // 7
        System.out.println("a * b = " + (a * b));   // 30
        System.out.println("a / b = " + (a / b));   // 3 (整数除法，截断)
        System.out.println("a % b = " + (a % b));   // 1 (取余/取模)

        // 注意：整数除法向零舍入，负数取余结果符号与被除数相同
        System.out.println("-10 % 3 = " + (-10 % 3));   // -1
        System.out.println("10 % -3 = " + (10 % -3));   // 1

        // 自增自减（建议单独成行，避免混淆）
        int x = 5;
        System.out.println("x++ = " + (x++));   // 先取值后自增，输出5，x变为6
        System.out.println("++x = " + (++x));   // 先自增后取值，输出7
        int y = 5;
        System.out.println("y-- = " + (y--));   // 输出5, y变4
        System.out.println("--y = " + (--y));   // 输出3

        // Android 注意：在 UI 线程避免密集的浮点运算，可使用整数或定点数优化
        double price = 19.99;
        int quantity = 3;
        double total = price * quantity;  // 浮点运算结果精确度问题见后面陷阱

        System.out.println("\n========== 2.2 字符串连接（+的特殊性） ==========");
        // + 可用于字符串连接
        String prefix = "Total: ";
        System.out.println(prefix + total);         // 字符串连接
        System.out.println(1 + 2 + "abc");          // 3abc（从左到右）
        System.out.println("abc" + 1 + 2);          // abc12

        //==================== 3. 关系运算符 ====================
        System.out.println("\n========== 3. 关系运算符 ==========");
        int m = 8, n = 12;
        System.out.println("m == n : " + (m == n));   // false
        System.out.println("m != n : " + (m != n));   // true
        System.out.println("m > n  : " + (m > n));    // false
        System.out.println("m < n  : " + (m < n));    // true
        System.out.println("m >= 8 : " + (m >= 8));   // true
        System.out.println("n <= 12: " + (n <= 12));  // true

        // 关系运算符常与条件判断结合（如 if、while）
        boolean isAdult = (m >= 18);  // 实际用于Android中的年龄验证

        //==================== 4. 逻辑运算符 ====================
        /**
         * &&并且
                a	    b	    a && b
                true	true	true
                true	false	false
                false	true	false
                false	false	false
         *||或者
         *      a	    b	    a || b
         *      true	true	true
         *      true	false	true
         *      false	true	true
         *      false	false	false
         * ! (取反)
         *      a	    !a
         *      true	false
         *      false	true
         *
                & 与 && 的区别：
                &：无论第一个条件是否为真，第二个条件都会执行
                &&：第一个条件为假时，第二个条件不会执行

                | 与 || 的区别：
                |：无论第一个条件是否为真，第二个条件都会执行（不短路）
                ||：第一个条件为真时，第二个条件不会执行（短路）

                & 与 | 的逻辑结果区别（针对布尔值）：
                &：两个条件都为真时，结果才为真
                |：两个条件中有一个为真时，结果就为真

                || 与 ^ 的区别：
                ||：至少一个为真就真（包含两个都真）
                ^  ：恰好一个为真时才真（两个都真为假）
         */
        System.out.println("\n========== 4. 逻辑运算符 ==========");
        boolean hasPermission = true;
        boolean isLoggedIn = false;

        System.out.println("hasPermission && isLoggedIn = " + (hasPermission && isLoggedIn)); // false
        System.out.println("hasPermission || isLoggedIn = " + (hasPermission || isLoggedIn)); // true
        System.out.println("!hasPermission = " + (!hasPermission)); // false

        // 短路特性：&& 前为false则不再计算后一个表达式
        int val = 10;
        if (false && (val++ > 5)) {  // val++ 不会执行
            // 永远不会进入
        }
        System.out.println("短路后 val = " + val);  // 仍是10

        // Android 常见：检查权限组合
        if (hasPermission && isLoggedIn) {
            System.out.println("允许访问敏感数据");
        } else {
            System.out.println("拒绝访问");
        }

        // 逻辑异或 ^ 可用于布尔值（同假异真）
        System.out.println("true ^ false = " + (true ^ false)); // true
        System.out.println("true ^ true = " + (true ^ true));   // false

        //==================== 5. 位运算符 ====================
        System.out.println("\n========== 5. 位运算符（Android 中常用） ==========");
        /**
         * 位运算直接操作二进制，效率高
         * Android 典型应用：权限掩码（如 View 的 Visibility 组合）、颜色通道处理、标志位
         */
        int flags = 0b0011;  // 二进制 0011 = 3
        int mask  = 0b0100;  // 二进制 0100 = 4

        System.out.println("flags & mask = " + (flags & mask));   // 0 (按位与)
        System.out.println("flags | mask = " + (flags | mask));   // 7 (0111)
        System.out.println("flags ^ mask = " + (flags ^ mask));   // 7 (0111)
        System.out.println("~flags = " + (~flags));               // -4 (补码，所有位取反)

        // 左移 << : 低位补0，相当于乘2
        int shiftLeft = 3 << 2;   // 3*4=12
        System.out.println("3 << 2 = " + shiftLeft);

        // 右移 >> : 正数高位补0，负数高位补1（保留符号）
        int shiftRight = 16 >> 2;  // 16/4=4
        System.out.println("16 >> 2 = " + shiftRight);

        // 无符号右移 >>> : 高位总是补0（无论正负）
        int negative = -8;
        System.out.println("-8 >>> 2 = " + (negative >>> 2));  // 得到一个很大的正数

        // Android 实战：使用位掩码表示多个选项
        // 例如 View 的测量模式（MeasureSpec）使用了位运算
        final int MODE_SHIFT = 30;
        final int MODE_MASK  = 0x3 << MODE_SHIFT;  // 0x40000000
        int measureSpec = 0;
        // 实际源码中通过位运算提取模式和尺寸

        // 演示：用位运算枚举权限
        int PERMISSION_READ = 1 << 0;   // 1 (001)
        int PERMISSION_WRITE= 1 << 1;   // 2 (010)
        int PERMISSION_DELETE=1 << 2;   // 4 (100)

        int userPerm = PERMISSION_READ | PERMISSION_WRITE;  // 3 (011)
        // 检查是否有读取权限
        boolean canRead = (userPerm & PERMISSION_READ) != 0;
        System.out.println("用户有读取权限？ " + canRead);

        //==================== 6. 赋值运算符 ====================
        System.out.println("\n========== 6. 赋值运算符 ==========");
        int c = 10;
        c += 5;   // c = c + 5
        System.out.println("c += 5  => " + c);
        c -= 3;   // 12
        c *= 2;   // 24
        c /= 4;   // 6
        c %= 4;   // 2
        System.out.println("最终 c = " + c);

        // 位运算复合赋值
        int bitVal = 0b1010; // 10
        bitVal &= 0b1100;    // 1000 = 8
        System.out.println("bitVal &= 0b1100 => " + bitVal);
        bitVal |= 0b0011;    // 1011 = 11
        System.out.println("bitVal |= 0b0011 => " + bitVal);

        // 注意：复合赋值会自动进行强制类型转换（隐含类型转换）
        byte by = 10;
        // by = by + 5;  // 编译错误：需要强转
        by += 5;          // 正确，等价于 by = (byte)(by + 5)
        System.out.println("byte 使用 += 后：" + by); // 15

        //==================== 7. 条件运算符（三元） ====================
        System.out.println("\n========== 7. 条件运算符 ? : ==========");
        int age = 17;
        String msg = (age >= 18) ? "成年人" : "未成年人";
        System.out.println("年龄 " + age + " -> " + msg);

        // 三元运算符嵌套（尽量不嵌套过深，影响可读性）
        int score = 85;
        String grade = (score >= 90) ? "A" : (score >= 80) ? "B" : "C";
        System.out.println("分数 " + score + " 等级 " + grade);

        // Android 中简化 TextView 文本设置
        // textView.setText(isSuccess ? "成功" : "失败");

        //==================== 8. instanceof 运算符 ====================
        System.out.println("\n========== 8. instanceof 运算符 ==========");
        Object obj = "Hello Android";
        if (obj instanceof String) {
            String str = (String) obj;   // 向下转型
            System.out.println("obj是String类型，长度为" + str.length());
        }

        // Android 中常用于判断 Activity 或 Fragment 类型
        // if (fragment instanceof MyFragment) { ... }

        // Java 14+ 支持模式匹配（预览特性），这里不再展开

        //==================== 9. 其他运算符简介 ====================
        System.out.println("\n========== 9. 其他运算符 ==========");
        // new：创建对象
        // (type)：强制类型转换
        // []：数组访问
        // .：成员访问
        // ()：方法调用，改变运算优先级

        double pi = 3.14159;
        int intPi = (int) pi;   // 强制转换（截断小数）
        System.out.println("(int)3.14159 = " + intPi);

        // 优先级示例：乘除高于加减，括号改变顺序
        int result = 2 + 3 * 4;      // 14
        int resultWithParent = (2 + 3) * 4; // 20
        System.out.println("2+3*4=" + result + ", (2+3)*4=" + resultWithParent);

        //==================== 10. 常见陷阱与注意事项 ====================
        System.out.println("\n========== 10. 运算符陷阱与最佳实践 ==========");

        // 陷阱1：除法与取整
        int divide = 5 / 2;      // 2，不是2.5
        double correct = 5.0 / 2; // 2.5
        System.out.println("整数除法 5/2 = " + divide + "，正确写法 5.0/2 = " + correct);

        // 陷阱2：自增/自减在复杂表达式中的副作用（不推荐写太复杂的表达式）
        int i = 2;
        int j = i++ + ++i;  // i++ => 2，i变为3；++i => 4；结果 2+4=6，i最终4
        System.out.println("i=2, j=i++ + ++i => j=" + j + ", i=" + i);

        // 陷阱3：短路逻辑导致某些表达式不被执行（如上文示例）

        // 陷阱4：== 与 equals 混淆（对于对象比较，==比较引用，equals比较内容）
        String s1 = new String("Android");
        String s2 = new String("Android");
        System.out.println("s1 == s2 : " + (s1 == s2));           // false
        System.out.println("s1.equals(s2) : " + s1.equals(s2));   // true

        // 陷阱5：位运算优先级低于比较运算符，需要加括号
        // if (a & b == 0)  // 错误：因为 == 优先级高于 &
        if ((a & b) == 0) {
            System.out.println("正确写法：加括号");
        }

        // 陷阱6：浮点数精度丢失
        double d1 = 0.1 + 0.2;
        double d2 = 0.3;
        System.out.println("0.1+0.2 == 0.3 ? " + (d1 == d2));   // false
        // 推荐使用差值比较
        final double EPS = 1e-6;
        if (Math.abs(d1 - d2) < EPS) {
            System.out.println("差值法认为相等");
        }

        // Android 特别提醒：在循环中避免频繁创建对象，例如字符串拼接使用 StringBuilder
        // 错误示例: String result = ""; for (int i=0;i<1000;i++) result += i;
        // 正确示例: StringBuilder sb = new StringBuilder(); for (...) sb.append(i);

        // Android 布局中常见位运算判断：View的getVisibility() == View.VISIBLE等

        //==================== 11. 综合案例 ====================
        System.out.println("\n========== 11. 综合案例：Android权限掩码管理 ==========");
        // 模拟一个文件操作权限控制（读、写、执行）
        final int READ   = 1 << 0;  // 001
        final int WRITE  = 1 << 1;  // 010
        final int EXEC   = 1 << 2;  // 100

        int currentPerm = READ | EXEC;   // 101 (5)  拥有读和执行权限

        // 添加写权限
        currentPerm |= WRITE;            // 111 (7)
        // 移除读权限
        currentPerm &= ~READ;            // 110 (6) 只有写和执行
        // 切换执行权限（有则无，无则有）
        currentPerm ^= EXEC;             // 010 (2) 只有写权限

        System.out.println("当前权限（二进制）：" + Integer.toBinaryString(currentPerm));
        System.out.println("是否有写权限？ " + ((currentPerm & WRITE) != 0));

        // 模拟颜色通道提取（Android 中 Color 类使用位运算）
        int color = 0xFFAABBCC;  // ARGB
        int alpha = (color >> 24) & 0xFF;
        int red   = (color >> 16) & 0xFF;
        int green = (color >> 8) & 0xFF;
        int blue  = color & 0xFF;
        System.out.printf("颜色 ARGB(%d,%d,%d,%d)\n", alpha, red, green, blue);

        //==================== 12. 总结（最佳实践与建议） ====================
        printOperatorSummary();
    }

    /**
     * 总结运算符要点及 Android 开发建议
     */
    private static void printOperatorSummary() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("📚 Java/Android 运算符 - 学习总结");
        System.out.println("=".repeat(50));

        System.out.println("\n【优先级速记口诀】");
        System.out.println("单目 > 乘除 > 加减 > 移位 > 关系 > 逻辑(除!) > 赋值");
        System.out.println("不确定就加括号，可读性第一");

        System.out.println("\n【各运算符使用场景】");
        System.out.println("▪ 算术: 数值计算、自增循环计数器");
        System.out.println("▪ 关系: 条件判断 (if/while)");
        System.out.println("▪ 逻辑: 组合布尔条件，注意短路特性");
        System.out.println("▪ 位运算: 权限掩码、颜色处理、标志位、高效乘除2的幂");
        System.out.println("▪ 赋值: 推荐使用复合赋值简化代码，注意类型转换");
        System.out.println("▪ 三元: 简单二分支，避免嵌套过深");
        System.out.println("▪ instanceof: 安全类型判断和转型");

        System.out.println("\n【常见陷阱】");
        System.out.println("⚠️  整数除法向零舍入，需要浮点结果请用 double 或 float");
        System.out.println("⚠️  ++/-- 在复杂表达式中行为难以预测，单独一行使用");
        System.out.println("⚠️  逻辑短路可能使后面的表达式不被执行");
        System.out.println("⚠️  == 比较基本类型值，比较对象时比较引用，应用 equals");
        System.out.println("⚠️  浮点数直接比较相等不可靠，使用精度范围");
        System.out.println("⚠️  位运算优先级低于关系运算符，务必加括号");
        System.out.println("⚠️  移位运算超过 int(32) 或 long(64) 位数会取模（如 1<<32==1）");

        System.out.println("\n【Android 开发最佳实践】");
        System.out.println("💡 使用位掩码管理选项（如 Gravity, Permission）");
        System.out.println("💡 颜色处理用 Color 类的静态方法，底层依赖位运算");
        System.out.println("💡 在循环和频繁调用的方法中避免使用 + 拼接字符串，用 StringBuilder");
        System.out.println("💡 充分利用短路逻辑简化嵌套 if 语句");
        System.out.println("💡 用三元运算符在布局文件中简化条件文本 (DataBinding)");
        System.out.println("💡 复杂条件判断抽取为具名 boolean 变量，提高可读性");
        System.out.println("💡 对敏感数据比较使用 Objects.equals() 避免空指针");

        System.out.println("\n【扩展学习】");
        System.out.println("📖 深入研究：Android MeasureSpec 中的位操作");
        System.out.println("📖 Java 运算符优先级表官方文档");
        System.out.println("📖 高效位运算技巧（乘以2的幂、快速取模等）");
    }
}