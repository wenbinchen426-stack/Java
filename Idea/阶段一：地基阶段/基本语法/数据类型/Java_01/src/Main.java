///========================================1.基本数据类型====================================================================
public class Main {
    public static void main(String[] args) {
        /**
         * ======================================== 整型 ========================================
         * 类型     内存占用    取值范围                    默认值    使用场景
         * byte     1字节      -128 ~ 127                 0       处理二进制文件流，节省内存
         * short    2字节      -32,768 ~ 32,767           0       较少使用，兼容特殊场景
         * int      4字节      -2^31 ~ 2^31-1             0       最常用，循环计数、数组索引
         * long     8字节      -2^63 ~ 2^63-1             0L      时间戳、超大数值
         *
         * ======================================== 浮点型 ========================================
         * 类型     内存占用    取值范围                   精度           默认值    使用场景
         * float    4字节      ±3.4E-38 ~ ±3.4E+38       6-7位有效小数   0.0f    内存紧张、图形变换
         * double   8字节      ±4.9E-324 ~ ±1.8E+308     15-16位有效小数 0.0d    默认小数类型，科学计算
         *
         * ======================================== 布尔型 ========================================
         * 类型     内存占用        取值范围       默认值   使用场景
         * boolean  1字节(JVM实现)  true/false    false   逻辑判断、开关状态
         *
         * ======================================== 字符型 ========================================
         * 类型     内存占用    取值范围                    默认值      使用场景
         * char     2字节       0 ~ 65535 (Unicode)       '\u0000'   单个字符
         */

        // ========== 1. 基本类型声明与初始化 ==========
        // 整型
        byte b = 100;
        short s = 1000;
        int i = 100000;
        long l = 100000L;           // 注意：必须加 L 后缀

        // 浮点型
        float f = 3.14f;            // 注意：必须加 f 后缀
        double d = 3.14159;         // double 是默认浮点类型，可省略 d 后缀

        // 字符型
        char c = 'A';               // 单引号
        char unicodeChar = '\u0041'; // Unicode 表示法，也是 'A'

        // 布尔型
        boolean bool = true;

        // 打印输出
        System.out.println("========== 基本类型示例 ==========");
        System.out.println("byte: " + b);
        System.out.println("short: " + s);
        System.out.println("int: " + i);
        System.out.println("long: " + l);
        System.out.println("float: " + f);
        System.out.println("double: " + d);
        System.out.println("char: " + c);
        System.out.println("boolean: " + bool);

        // ========== 2. 类型转换演示 ==========
        System.out.println("\n========== 类型转换 ==========");

        // 自动类型转换（小→大）
        int intNum = 100;
        long longNum = intNum;      // int → long，自动转换
        double doubleNum = intNum;  // int → double，自动转换
        System.out.println("自动转换: int(100) → long(" + longNum + ")");
        System.out.println("自动转换: int(100) → double(" + doubleNum + ")");

        // 强制类型转换（大→小），可能丢失数据
        double pi = 3.14159;
        int intPi = (int) pi;       // 强制转换，小数部分丢失
        System.out.println("强制转换: double(3.14159) → int(" + intPi + ")");

        // 表达式类型提升
        byte b1 = 10, b2 = 20;
        int sum = b1 + b2;          // byte + byte → int（自动提升）
        System.out.println("类型提升: byte(" + b1 + ") + byte(" + b2 + ") = int(" + sum + ")");

        // ========== 3. 常见陷阱与注意事项 ==========
        System.out.println("\n========== 注意事项 ==========");

        // 陷阱1：浮点数精度问题
        System.out.println("【陷阱1】浮点数精度问题:");
        double result = 0.1 + 0.2;
        System.out.println("  0.1 + 0.2 = " + result);
        System.out.println("  期望值 0.3，实际得到 " + result);
        System.out.println("  解决方案：使用 BigDecimal 进行精确计算");

        // 陷阱2：整数溢出
        System.out.println("\n【陷阱2】整数溢出:");
        int maxInt = Integer.MAX_VALUE;  // 2,147,483,647
        System.out.println("  int最大值: " + maxInt);
        System.out.println("  最大值+1: " + (maxInt + 1));  // 溢出变成负数
        System.out.println("  解决方案：使用 long 或检查边界");

        // 陷阱3：byte 和 short 的算术运算
        System.out.println("\n【陷阱3】byte/short 运算陷阱:");
        byte byteVal = 50;
        // byte result2 = byteVal * 2;  //编译错误！结果自动提升为 int
        int correctResult = byteVal * 2;  //正确接收
        System.out.println("  byte(50) * 2 = int(" + correctResult + ")");

        // 陷阱4：char 的特殊性
        System.out.println("\n【陷阱4】char 的特殊性:");
        char ch = 'A';
        int charToInt = ch;  // char 可以自动转换为 int
        System.out.println("  char('A') 的 Unicode 码点: " + charToInt);
        System.out.println("  char 参与算术运算: " + (ch + 1));  // 输出 66

        // ========== 4. 实用技巧 ==========
        System.out.println("\n========== 实用技巧 ==========");

        // 技巧1：获取各类型的最大/最小值
        System.out.println("【技巧1】查看类型取值范围:");
        System.out.println("  byte: " + Byte.MIN_VALUE + " ~ " + Byte.MAX_VALUE);
        System.out.println("  short: " + Short.MIN_VALUE + " ~ " + Short.MAX_VALUE);
        System.out.println("  int: " + Integer.MIN_VALUE + " ~ " + Integer.MAX_VALUE);
        System.out.println("  long: " + Long.MIN_VALUE + " ~ " + Long.MAX_VALUE);
        System.out.println("  float: " + Float.MIN_VALUE + " ~ " + Float.MAX_VALUE);
        System.out.println("  double: " + Double.MIN_VALUE + " ~ " + Double.MAX_VALUE);

        // 技巧2：进制表示
        System.out.println("\n【技巧2】不同进制表示:");
        int decimal = 100;      // 十进制
        int binary = 0b1100100; // 二进制 (0b前缀)
        int octal = 0144;       // 八进制 (0前缀)
        int hex = 0x64;         // 十六进制 (0x前缀)
        System.out.println("  十进制: " + decimal);
        System.out.println("  二进制 0b1100100: " + binary);
        System.out.println("  八进制 0144: " + octal);
        System.out.println("  十六进制 0x64: " + hex);

        // 技巧3：数字分隔符（Java 7+）
        System.out.println("\n【技巧3】数字分隔符（提高可读性）:");
        int million = 1_000_000;
        long creditCard = 1234_5678_9012_3456L;
        float piFloat = 3.1415_9265f;
        System.out.println("  1_000_000 = " + million);
        System.out.println("  信用卡号: " + creditCard);


/**---------------------------------------------------------------------------------------------------------------------
基本类型的总结表：
         数据类型	        关键字	    占用字节	            默认值	        示例
         字节型	        byte	    1	                0	            byte b = 100;
         短整型	        short	    2	                0	            short s = 1000;
         整型	        int	        4	                0	            int i = 100000;
         长整型	        long	    8	                0L	            long l = 100000L;
         单精度浮点型	    float	    4	                0.0f	        float f = 3.14f;
         双精度浮点型	    double	    8	                0.0d	        double d = 3.14159;
         字符型	        char	    2	                '\u0000'	    char c = 'A';
         布尔型	        boolean	    1位（实际JVM决定）	    false	        boolean bool = true;
-----------------------------------------------------------------------------------------------------------------------*/
    }
}