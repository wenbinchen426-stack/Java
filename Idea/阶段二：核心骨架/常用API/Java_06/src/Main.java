// Java / Android 常用 API 笔记
//========================================
// 涵盖：java.lang、java.util、java.io、android 常用类
// 适用场景：日常编码、面试复习、快速查阅

public class Main {
    public static void main(String[] args) {

        //==================== 1. 字符串处理（String / StringBuilder） ====================
        System.out.println("========== 1. String 常用 API ==========");
        String str = " Hello, Android World! ";

        // 1.1 判断与比较
        System.out.println("length(): " + str.length());               // 22
        System.out.println("isEmpty(): " + str.isEmpty());             // false
        System.out.println("trim(): '" + str.trim() + "'");            // 去除首尾空格
        System.out.println("startsWith(\" Hello\"): " + str.startsWith(" Hello")); // true
        System.out.println("endsWith(\"! \"): " + str.endsWith("! ")); // true
        System.out.println("contains(\"Android\"): " + str.contains("Android")); // true
        System.out.println("equalsIgnoreCase(): " + "hello".equalsIgnoreCase("HELLO")); // true

        // 1.2 查找与截取
        System.out.println("indexOf('A'): " + str.indexOf('A'));       // 10
        System.out.println("lastIndexOf('o'): " + str.lastIndexOf('o')); // 16
        System.out.println("substring(8, 15): " + str.substring(8, 15)); // "Android"
        System.out.println("charAt(3): " + str.charAt(3));             // 'e'

        // 1.3 转换与替换
        System.out.println("toUpperCase(): " + str.toUpperCase());
        System.out.println("toLowerCase(): " + str.toLowerCase());
        System.out.println("replace('o', '0'): " + str.replace('o', '0'));
        System.out.println("replaceAll(\"\\\\s+\", \"\"): " + str.replaceAll("\\s+", "")); // 去掉所有空白
        System.out.println("split(\",\"): " + java.util.Arrays.toString(str.split(",")));

        // 1.4 格式化（类似 C 的 printf）
        String formatted = String.format("Hello %s, score %.2f", "Alice", 95.5);
        System.out.println("String.format(): " + formatted);

        // 1.5 StringBuilder（可变字符串，线程不安全，性能好）
        StringBuilder sb = new StringBuilder("初始");
        sb.append(" 追加");
        sb.insert(0, "【前缀】");
        sb.replace(3, 5, "替换");
        sb.delete(8, 10);
        System.out.println("StringBuilder结果: " + sb.toString());

        //==================== 2. 数学与随机数 ====================
        System.out.println("\n========== 2. Math & Random ==========");
        System.out.println("Math.abs(-5): " + Math.abs(-5));           // 绝对值
        System.out.println("Math.max(3,8): " + Math.max(3, 8));        // 最大值
        System.out.println("Math.min(3,8): " + Math.min(3, 8));        // 最小值
        System.out.println("Math.pow(2,10): " + Math.pow(2, 10));      // 2^10=1024
        System.out.println("Math.sqrt(64): " + Math.sqrt(64));         // 平方根
        System.out.println("Math.cbrt(27): " + Math.cbrt(27));         // 立方根
        System.out.println("Math.ceil(3.14): " + Math.ceil(3.14));     // 向上取整 4.0
        System.out.println("Math.floor(3.99): " + Math.floor(3.99));   // 向下取整 3.0
        System.out.println("Math.round(3.5): " + Math.round(3.5));     // 四舍五入 4
        System.out.println("Math.random(): " + Math.random());         // [0.0,1.0) 随机数

        // 随机整数 [min, max]
        int min = 10, max = 20;
        int randInt = (int)(Math.random() * (max - min + 1)) + min;
        System.out.println("随机整数[10,20]: " + randInt);

        // 使用 java.util.Random
        java.util.Random random = new java.util.Random();
        System.out.println("random.nextInt(100): " + random.nextInt(100)); // 0~99
        System.out.println("random.nextDouble(): " + random.nextDouble());

        //==================== 3. 日期与时间 ====================
        System.out.println("\n========== 3. 日期时间 API ==========");
        // 3.1 旧版 Date + SimpleDateFormat（线程不安全，不推荐新项目）
        java.util.Date date = new java.util.Date();
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("当前时间(旧): " + sdf.format(date));

        // 3.2 Java 8+ 新时间API（推荐，线程安全）
        java.time.LocalDate today = java.time.LocalDate.now();
        System.out.println("LocalDate now: " + today);
        java.time.LocalTime nowTime = java.time.LocalTime.now();
        System.out.println("LocalTime now: " + nowTime);
        java.time.LocalDateTime dateTime = java.time.LocalDateTime.now();
        System.out.println("LocalDateTime: " + dateTime);

        // 格式化
        java.time.format.DateTimeFormatter formatter = java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println("格式化当前时间: " + dateTime.format(formatter));

        // 日期运算
        java.time.LocalDate tomorrow = today.plusDays(1);
        java.time.LocalDate lastMonth = today.minusMonths(1);
        System.out.println("明天: " + tomorrow + ", 上月今天: " + lastMonth);

        // 时间戳（毫秒）
        long timestamp = System.currentTimeMillis();
        System.out.println("System.currentTimeMillis(): " + timestamp);

        //==================== 4. 系统与数组工具 ====================
        System.out.println("\n========== 4. System & Arrays ==========");
        // System.arraycopy 数组拷贝
        int[] src = {1, 2, 3, 4, 5};
        int[] dest = new int[5];
        System.arraycopy(src, 1, dest, 2, 3);
        System.out.println("System.arraycopy结果: " + java.util.Arrays.toString(dest));

        // 垃圾回收建议（不一定立即执行）
        System.gc();

        // 获取环境变量 / 属性
        System.out.println("java.version: " + System.getProperty("java.version"));
        System.out.println("PATH: " + System.getenv("PATH"));

        // Arrays 常用方法
        int[] arr = {5, 2, 8, 1, 9};
        java.util.Arrays.sort(arr);
        System.out.println("Arrays.sort: " + java.util.Arrays.toString(arr));
        int index = java.util.Arrays.binarySearch(arr, 8);
        System.out.println("二分查找 8 的位置: " + index);
        int[] copy = java.util.Arrays.copyOfRange(arr, 1, 4);
        System.out.println("copyOfRange: " + java.util.Arrays.toString(copy));
        boolean equals = java.util.Arrays.equals(arr, copy);
        System.out.println("equals: " + equals);
        java.util.Arrays.fill(arr, 0);
        System.out.println("fill 0: " + java.util.Arrays.toString(arr));

        //==================== 5. 集合工具类 Collections ====================
        System.out.println("\n========== 5. Collections ==========");
        java.util.ArrayList<Integer> list = new java.util.ArrayList<>();
        list.add(3); list.add(1); list.add(4); list.add(1); list.add(5);
        java.util.Collections.sort(list);
        System.out.println("Collections.sort: " + list);
        java.util.Collections.reverse(list);
        System.out.println("reverse: " + list);
        java.util.Collections.shuffle(list);
        System.out.println("shuffle: " + list);
        System.out.println("max: " + java.util.Collections.max(list));
        System.out.println("min: " + java.util.Collections.min(list));
        System.out.println("frequency(1): " + java.util.Collections.frequency(list, 1));
        java.util.Collections.fill(list, 0);
        System.out.println("fill 0: " + list);
        // 线程安全包装
        java.util.List<Integer> syncList = java.util.Collections.synchronizedList(list);

        //==================== 6. 输入输出（IO）常用 API ====================
        System.out.println("\n========== 6. IO 常用 ==========");
        // 文件读写示例（需处理异常，这里仅演示 API）
        String filePath = "test.txt";
        // 写文件
        try (java.io.FileWriter fw = new java.io.FileWriter(filePath)) {
            fw.write("Hello Android");
            System.out.println("写入文件成功");
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        // 读文件
        try (java.io.BufferedReader br = new java.io.BufferedReader(new java.io.FileReader(filePath))) {
            String line = br.readLine();
            System.out.println("读取内容: " + line);
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        // 删除文件
        new java.io.File(filePath).delete();

        // 路径分隔符
        System.out.println("文件分隔符: " + java.io.File.separator);
        System.out.println("路径分隔符: " + java.io.File.pathSeparator);

        //==================== 7. 异常处理常用 API ====================
        System.out.println("\n========== 7. 异常 ==========");
        try {
            int r = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("捕获异常: " + e.getMessage());
            e.printStackTrace(); // 打印堆栈
        } finally {
            System.out.println("finally 块总是执行");
        }

        // 自定义异常（略）

        //==================== 8. Android 特有常用 API（简要） ====================
        System.out.println("\n========== 8. Android 常用 API ==========");
        // 以下代码需在 Android 环境下运行，此处仅为 API 列举
        /**
         * Context: getResources(), getSharedPreferences(), getSystemService()
         * Log: Log.d(), Log.e(), Log.i(), Log.v(), Log.w()
         * Toast: Toast.makeText(context, text, duration).show()
         * View: findViewById(), setOnClickListener(), setVisibility()
         * Intent: new Intent(context, targetClass), startActivity()
         * Bundle: putString(), getString(), putInt(), getInt()
         * SharedPreferences: getSharedPreferences(), edit(), commit() / apply()
         * RecyclerView: setLayoutManager(), setAdapter()
         * Glide/Coil: 图片加载第三方库
         *
         * 注意：Android API 依赖 android.jar，此处仅作列表参考
         */
        System.out.println("提示：Android 特有 API 需在 Activity/Context 环境中使用");

        //==================== 9. 常用正则表达式 ====================
        System.out.println("\n========== 9. 正则表达式 ==========");
        String email = "test@example.com";
        boolean isEmail = email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$");
        System.out.println("邮箱匹配: " + isEmail);

        String phone = "13812345678";
        boolean isPhone = phone.matches("^1[3456789]\\d{9}$");
        System.out.println("手机号匹配: " + isPhone);

        // 使用 Pattern 和 Matcher
        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile("\\d+");
        java.util.regex.Matcher matcher = pattern.matcher("订单号: 12345");
        if (matcher.find()) {
            System.out.println("找到数字: " + matcher.group());
        }

        //==================== 10. 常用 API 总结 ====================
        printApiSummary();
    }

    private static void printApiSummary() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("📚 Java / Android 常用 API 总结");
        System.out.println("=".repeat(50));

        System.out.println("\n【java.lang 包】");
        System.out.println("▪ String        - 字符串操作（不可变）");
        System.out.println("▪ StringBuilder - 可变字符串，线程不安全（优先）");
        System.out.println("▪ Math          - 数学计算、随机数");
        System.out.println("▪ System        - 系统操作（arraycopy, gc, currentTimeMillis）");
        System.out.println("▪ Thread        - 多线程");

        System.out.println("\n【java.util 包】");
        System.out.println("▪ ArrayList / LinkedList / HashSet / HashMap");
        System.out.println("▪ Collections / Arrays - 集合/数组工具");
        System.out.println("▪ Random / Scanner");
        System.out.println("▪ Date / Calendar (旧) 或 java.time.* (新)");

        System.out.println("\n【java.io 包】");
        System.out.println("▪ File, FileInputStream, FileOutputStream");
        System.out.println("▪ BufferedReader, BufferedWriter");
        System.out.println("▪ Serializable 序列化");

        System.out.println("\n【java.nio 包】更高性能的 IO（Buffer, Channel）");

        System.out.println("\n【Android 特有】");
        System.out.println("▪ Log, Toast, Context, Intent, SharedPreferences");
        System.out.println("▪ View, ViewGroup, RecyclerView, Fragment");
        System.out.println("▪ SparseArray, ArrayMap");

        System.out.println("\n【最佳实践】");
        System.out.println("💡 字符串频繁拼接用 StringBuilder");
        System.out.println("💡 日期时间优先用 java.time.*");
        System.out.println("💡 集合遍历删除用 Iterator");
        System.out.println("💡 文件操作用 try-with-resources 自动关闭");
        System.out.println("💡 正则表达式提前编译 Pattern 提升性能");
        System.out.println("💡 Android 中避免主线程 IO 操作");
    }
}