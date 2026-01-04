package 数据类型;

public class DataType  {
    public static void main(String[] args) {
        //数据类型:
    /// ========= 基本数据类型: ======

        //1.整数类型:byte(1字节),short(2字节),int(4字节),long(8字节)
        byte b = 10;    //取值范围 = -128~127
        short s = 20;   //取值范围 = -32768~32767
        int i = 30;     //取值范围 = -2147483648~2147483647
        long l = 40L;   //取值范围 = -9223372036854775808~9223372036854775807
        System.out.println();

        //2.浮点类型:float(4字节),double(8字节)
        float f = 3.14F;    //取值范围 = -3.402823e+38 ~ 3.402823e+38
        double d = 3.1415926;   //取值范围 = -1.7976931348623157e+308 ~ 1.7976931348623157e+308

        //3.字符类型:char(2字节)
        char c = 'a';

        //4.布尔类型:boolean(1字节)
        boolean flag = true;


        System.out.println("=======整数类型=======");
        System.out.println("输出结果:"+"\nb="+b+"\ns="+s+"\ni="+i+"\nl="+l);
        System.out.println("=======浮点类型=======");
        System.out.println("输出结果:"+"\nf="+f+"\nd="+d);
        System.out.println("=======字符类型=======");
        System.out.println("输出结果:"+"\nc="+c);
        System.out.println("=======布尔类型=======");
        System.out.println("输出结果为:="+flag);


    /// ====== 引用数据类型示例 ======

        // 1. 字符串（String是特殊的引用类型）
        String str = "hello";

        // 2. 数组（数组是引用类型，int[]表示int类型的数组）
        int[] arr = {1, 2, 3, 4, 5};

        // 3. 类的实例（Person是自定义类，new Person()创建对象，p指向该对象）
        Person p = new Person();

        // 4. 接口引用（Comparable是接口，指向实现了该接口的Person实例）
        Comparable<Person> c1 = new Person();

        // 5. 枚举类型（Season是枚举，SPRING是枚举常量，直接通过类名访问）
        Season s1 = Season.SPRING;


        System.out.println(s1);
        System.out.println("字符串str: " + str);
        System.out.println("数组arr的长度: " + arr.length);
        System.out.println("Person对象p: " + p);
        System.out.println("接口引用c1: " + c1);
    }
}

