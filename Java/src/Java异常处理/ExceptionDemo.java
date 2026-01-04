package Java异常处理;

/**
 * Java 异常处理完整学习笔记
 * 核心涵盖：异常体系（Error/Exception）、编译时异常/运行时异常、异常处理方式（捕获/抛出）
 *          自定义异常、finally关键字、try-with-resources自动关闭资源
 * 特性：代码可直接运行、注释详尽、易错点高亮、结构清晰
 */
public class ExceptionDemo {
    public static void main(String[] args) {
        // ============== 一、异常概述（核心认知） ==============
        System.out.println("============== 一、异常概述 ==============");
        System.out.println("异常：程序运行过程中出现的非正常情况（如数组越界、空指针、文件不存在等）");
        System.out.println("异常两大体系：");
        System.out.println("1. Error（错误）：虚拟机级别的严重问题，无法通过代码处理（如OOM、栈溢出）");
        System.out.println("2. Exception（异常）：程序级别的问题，可通过代码捕获和处理");
        System.out.println("   - 编译时异常：编译阶段必须处理（如IO异常、SQLException），否则代码报错");
        System.out.println("   - 运行时异常：运行阶段才会触发（如NullPointerException、ArrayIndexOutOfBoundsException），编译不报错");
        System.out.println();

        // ============== 二、异常处理方式1：捕获异常（try-catch-finally） ==============
        System.out.println("============== 二、捕获异常（try-catch-finally） ==============");
        // 2.1 基本try-catch（处理单个异常）
        System.out.println("--- 2.1 基本try-catch（单个异常） ---");
        int a = 10;
        int b = 0;
        try {
            // 可能出现异常的代码块
            int result = a / b;
            System.out.println("除法运算结果：" + result);
        } catch (ArithmeticException e) {
            // 捕获指定异常并处理
            System.out.println("捕获算术异常：" + e.getMessage()); // 获取异常信息
            e.printStackTrace(); // 打印异常堆栈（便于调试）
        }
        System.out.println();

        // 2.2 多catch块（处理多个异常，从上到下异常范围从小到大）
        System.out.println("--- 2.2 多catch块（多个异常） ---");
        int[] arr = {1, 2, 3};
        try {
            b = 1;
            int result = a / b;
            System.out.println("除法运算结果：" + result);
            System.out.println("数组索引3的元素：" + arr[3]); // 数组越界异常
        } catch (ArithmeticException e) {
            System.out.println("捕获算术异常：" + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("捕获数组越界异常：" + e.getMessage());
        } catch (Exception e) {
            // 父异常兜底，放在最后
            System.out.println("捕获通用异常：" + e.getMessage());
        }
        System.out.println();

        // 2.3 finally关键字（无论是否出现异常，都会执行，用于释放资源）
        System.out.println("--- 2.3 finally关键字（释放资源） ---");
        try {
            int result = a / 2;
            System.out.println("正常运算结果：" + result);
        } catch (ArithmeticException e) {
            System.out.println("捕获算术异常：" + e.getMessage());
        } finally {
            System.out.println("finally代码块：无论是否异常，我都会执行");
            // 示例：关闭流、释放数据库连接等资源操作
        }
        System.out.println();

        // ============== 三、异常处理方式2：抛出异常（throws/throw） ==============
        System.out.println("============== 三、抛出异常（throws/throw） ==============");
        // 3.1 throws：方法声明上抛出异常，由调用者处理
        System.out.println("--- 3.1 throws（方法声明抛出异常） ---");
        try {
            readFile("test.txt"); // 调用抛出异常的方法，必须捕获或继续抛出
        } catch (Exception e) {
            System.out.println("捕获到文件读取异常：" + e.getMessage());
        }
        System.out.println();

        // 3.2 throw：方法内部手动抛出异常对象
        System.out.println("--- 3.2 throw（手动抛出异常） ---");
        try {
            checkAge(15);
        } catch (IllegalArgumentException e) {
            System.out.println("捕获年龄校验异常：" + e.getMessage());
        }
        System.out.println();

        // ============== 四、try-with-resources（自动关闭资源，JDK7+） ==============
        System.out.println("============== 四、try-with-resources（自动关闭资源） ==============");
        // 实现AutoCloseable接口的资源，可自动关闭（无需手动在finally中关闭）
        try (MyResource resource = new MyResource(); // 多个资源用分号分隔
             MyResource2 resource2 = new MyResource2()) {
            resource.doSomething();
            resource2.doSomething();
        } catch (Exception e) {
            System.out.println("捕获资源操作异常：" + e.getMessage());
        }
        // 资源已自动关闭，无需手动处理
        System.out.println();

        // ============== 五、自定义异常（继承Exception或RuntimeException） ==============
        System.out.println("============== 五、自定义异常 ==============");
        try {
            // 调用抛出自定义异常的方法
            userLogin("zhangsan", "1234567"); // 密码错误
        } catch (UserLoginException e) {
            System.out.println("捕获自定义登录异常：" + e.getMessage());
        }
        System.out.println();

        // ============== 六、异常处理核心易错点总结 ==============
        System.out.println("============== 六、异常处理核心易错点 ==============");
        System.out.println("1. 多catch块顺序：子类异常在前，父类异常在后，否则编译报错");
        System.out.println("2. finally执行时机：除非JVM退出（System.exit(0)），否则无论try/catch是否执行，finally都会执行");
        System.out.println("3. 运行时异常：可不用显式处理（捕获/抛出），编译时异常必须显式处理");
        System.out.println("4. throw vs throws：throw是手动抛异常对象（方法内），throws是声明异常（方法上）");
        System.out.println("5. try-with-resources：资源必须实现AutoCloseable接口，自动关闭资源，代码更简洁");
        System.out.println("6. 自定义异常：按需继承Exception（编译时异常）或RuntimeException（运行时异常）");
    }

    /**
     * 示例方法：throws声明编译时异常，由调用者处理
     * @param fileName 文件名
     * @throws Exception 抛出文件读取异常
     */
    public static void readFile(String fileName) throws Exception {
        // 模拟文件读取，抛出编译时异常
        if (!"test.txt".equals(fileName)) {
            throw new Exception("文件不存在：" + fileName);
        }
        System.out.println("文件读取成功");
    }

    /**
     * 示例方法：throw手动抛出运行时异常
     * @param age 年龄
     */
    public static void checkAge(int age) {
        if (age < 18) {
            // 手动抛出非法参数异常
            throw new IllegalArgumentException("年龄必须大于等于18岁，当前年龄：" + age);
        }
        System.out.println("年龄校验通过");
    }

    /**
     * 自定义异常：用户登录异常（编译时异常，继承Exception）
     */
    static class UserLoginException extends Exception {
        public UserLoginException(String message) {
            super(message); // 调用父类构造方法，传入异常信息
        }
    }

    /**
     * 示例：用户登录方法，抛出自定义异常
     * @param username 用户名
     * @param password 密码
     * @throws UserLoginException 登录异常
     */
    public static void userLogin(String username, String password) throws UserLoginException {
        // 模拟用户名密码校验
        String correctPwd = "123456";
        if (!correctPwd.equals(password)) {
            throw new UserLoginException("用户名：" + username + "，密码错误！");
        }
        System.out.println("登录成功！");
    }

    /**
     * 自定义资源类：实现AutoCloseable接口，支持try-with-resources自动关闭
     */
    static class MyResource implements AutoCloseable {
        public void doSomething() {
            System.out.println("MyResource 执行业务操作");
        }

        @Override
        public void close() throws Exception {
            System.out.println("MyResource 自动关闭资源");
        }
    }

    /**
     * 自定义资源类2：实现AutoCloseable接口
     */
    static class MyResource2 implements AutoCloseable {
        public void doSomething() {
            System.out.println("MyResource2 执行业务操作");
        }

        @Override
        public void close() throws Exception {
            System.out.println("MyResource2 自动关闭资源");
        }
    }
}