package abstracts;

//========================================
// 抽象类回调示例
//========================================
public abstract class FileParser {
    // 模板方法
    public final void parse(String content) {
        System.out.println("开始解析文件...");
        String result = parseContent(content);
        System.out.println("解析结果: " + result);
        afterParse();
    }

    // 抽象方法：具体解析逻辑由子类实现（相当于回调）
    protected abstract String parseContent(String content);

    // 钩子方法（可选扩展）
    protected void afterParse() {
        System.out.println("解析完成");
    }
}
