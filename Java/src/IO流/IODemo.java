package IO流;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * Java IO 流完整学习笔记
 * 核心涵盖：IO流体系（字节流/字符流）、节点流/处理流、文件读写、缓冲流优化、转换流
 *          字符流（文本文件）、字节流（非文本文件：图片/视频/音频）
 * 特性：代码可直接运行、注释详尽、易错点高亮、结构清晰
 */
public class IODemo {
    public static void main(String[] args) {
        // ============== 一、IO 流概述（核心认知） ==============
        System.out.println("============== 一、IO 流概述 ==============");
        System.out.println("IO 流：用于实现设备之间的数据传输（文件读写、网络通信等）");
        System.out.println("IO 流两大分类：");
        System.out.println("1. 按数据单位：字节流（8位字节，适用于所有文件）、字符流（16位字符，仅适用于文本文件）");
        System.out.println("   - 字节流根接口：InputStream（读）、OutputStream（写）");
        System.out.println("   - 字符流根接口：Reader（读）、Writer（写）");
        System.out.println("2. 按流的方向：输入流（读数据：从文件到程序）、输出流（写数据：从程序到文件）");
        System.out.println("3. 按流的角色：节点流（直接操作数据源）、处理流（包装节点流，增强功能，如缓冲流）");
        System.out.println();

        // ============== 二、字节流（核心：文件读写，支持所有文件） ==============
        System.out.println("============== 二、字节流（FileInputStream/FileOutputStream） ==============");
        String filePath = "test_byte.txt";
        // 2.1 字节流写文件（FileOutputStream）
        System.out.println("--- 2.1 字节流写文件 ---");
        try (FileOutputStream fos = new FileOutputStream(filePath, true)) {
            // 第二个参数true：追加写入；false：覆盖写入（默认）
            String content = "Java IO 字节流写文件测试\n";
            fos.write(content.getBytes(StandardCharsets.UTF_8)); // 字符串转字节数组
            System.out.println("字节流写文件成功：" + filePath);
        } catch (IOException e) {
            System.out.println("字节流写文件异常：" + e.getMessage());
            e.printStackTrace();
        }
        System.out.println();

        // 2.2 字节流读文件（FileInputStream）
        System.out.println("--- 2.2 字节流读文件 ---");
        try (FileInputStream fis = new FileInputStream(filePath)) {
            byte[] buffer = new byte[1024]; // 缓冲区，每次读取1024字节
            int len; // 实际读取的字节数
            StringBuilder sb = new StringBuilder();
            while ((len = fis.read(buffer)) != -1) {
                // 读取字节数组转换为字符串
                sb.append(new String(buffer, 0, len, StandardCharsets.UTF_8));
            }
            System.out.println("字节流读文件内容：\n" + sb.toString());
        } catch (IOException e) {
            System.out.println("字节流读文件异常：" + e.getMessage());
            e.printStackTrace();
        }
        System.out.println();

        // 2.3 字节缓冲流（BufferedInputStream/BufferedOutputStream，提升读写效率）
        System.out.println("============== 三、字节缓冲流（高效读写） ==============");
        String bufferFilePath = "test_buffered_byte.txt";
        // 3.1 缓冲流写文件
        System.out.println("--- 3.1 字节缓冲流写文件 ---");
        try (BufferedOutputStream bos = new BufferedOutputStream(
                new FileOutputStream(bufferFilePath, true)
        )) {
            String content = "Java IO 字节缓冲流写文件（高效）\n";
            bos.write(content.getBytes(StandardCharsets.UTF_8));
            System.out.println("字节缓冲流写文件成功：" + bufferFilePath);
        } catch (IOException e) {
            System.out.println("字节缓冲流写文件异常：" + e.getMessage());
        }
        System.out.println();

        // 3.2 缓冲流读文件
        System.out.println("--- 3.2 字节缓冲流读文件 ---");
        try (BufferedInputStream bis = new BufferedInputStream(
                new FileInputStream(bufferFilePath)
        )) {
            byte[] buffer = new byte[1024];
            int len;
            StringBuilder sb = new StringBuilder();
            while ((len = bis.read(buffer)) != -1) {
                sb.append(new String(buffer, 0, len, StandardCharsets.UTF_8));
            }
            System.out.println("字节缓冲流读文件内容：\n" + sb.toString());
        } catch (IOException e) {
            System.out.println("字节缓冲流读文件异常：" + e.getMessage());
        }
        System.out.println();

        // ============== 四、字符流（核心：文本文件读写，更简洁高效） ==============
        System.out.println("============== 四、字符流（FileReader/FileWriter） ==============");
        String charFilePath = "test_char.txt";
        // 4.1 字符流写文件（FileWriter）
        System.out.println("--- 4.1 字符流写文件 ---");
        try (FileWriter fw = new FileWriter(charFilePath, true)) {
            String content = "Java IO 字符流写文件测试\n";
            fw.write(content); // 直接写字符串，无需转字节数组
            fw.flush(); // 刷新缓冲区，确保数据写入文件
            System.out.println("字符流写文件成功：" + charFilePath);
        } catch (IOException e) {
            System.out.println("字符流写文件异常：" + e.getMessage());
        }
        System.out.println();

        // 4.2 字符流读文件（FileReader）
        System.out.println("--- 4.2 字符流读文件 ---");
        try (FileReader fr = new FileReader(charFilePath)) {
            char[] buffer = new char[1024]; // 字符缓冲区
            int len;
            StringBuilder sb = new StringBuilder();
            while ((len = fr.read(buffer)) != -1) {
                sb.append(new String(buffer, 0, len));
            }
            System.out.println("字符流读文件内容：\n" + sb.toString());
        } catch (IOException e) {
            System.out.println("字符流读文件异常：" + e.getMessage());
        }
        System.out.println();

        // 4.3 字符缓冲流（BufferedReader/BufferedWriter，特有行读写方法）
        System.out.println("============== 五、字符缓冲流（高效文本读写） ==============");
        String charBufferFilePath = "test_buffered_char.txt";
        // 5.1 字符缓冲流写文件（特有newLine()方法，跨平台换行）
        System.out.println("--- 5.1 字符缓冲流写文件 ---");
        try (BufferedWriter bw = new BufferedWriter(
                new FileWriter(charBufferFilePath, true)
        )) {
            bw.write("Java IO 字符缓冲流写文件1");
            bw.newLine(); // 跨平台换行（Windows：\r\n，Linux：\n）
            bw.write("Java IO 字符缓冲流写文件2");
            bw.flush();
            System.out.println("字符缓冲流写文件成功：" + charBufferFilePath);
        } catch (IOException e) {
            System.out.println("字符缓冲流写文件异常：" + e.getMessage());
        }
        System.out.println();

        // 5.2 字符缓冲流读文件（特有readLine()方法，按行读取）
        System.out.println("--- 5.2 字符缓冲流读文件（按行读取） ---");
        try (BufferedReader br = new BufferedReader(
                new FileReader(charBufferFilePath)
        )) {
            String line; // 每行内容
            System.out.println("字符缓冲流按行读取内容：");
            while ((line = br.readLine()) != null) {
                // readLine()返回null表示读取到文件末尾
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("字符缓冲流读文件异常：" + e.getMessage());
        }
        System.out.println();

        // ============== 六、IO 流核心易错点总结 ==============
        System.out.println("============== 六、IO 流核心易错点 ==============");
        System.out.println("1. 流的关闭：必须关闭资源，推荐使用try-with-resources自动关闭（实现AutoCloseable接口）");
        System.out.println("2. 字节流 vs 字符流：非文本文件（图片/视频）用字节流，文本文件用字符流更简洁");
        System.out.println("3. 追加写入：FileOutputStream/FileWriter 第二个参数设为true，默认是覆盖写入");
        System.out.println("4. 缓冲流优势：包装节点流，通过缓冲区减少IO次数，大幅提升读写效率，优先使用");
        System.out.println("5. 字符缓冲流特有功能：BufferedReader.readLine()（按行读）、BufferedWriter.newLine()（跨平台换行）");
        System.out.println("6. 编码问题：读写文件时指定统一编码（如UTF-8），避免中文乱码");
    }
}