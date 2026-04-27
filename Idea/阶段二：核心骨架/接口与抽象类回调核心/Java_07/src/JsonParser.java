import abstracts.FileParser;

class JsonParser extends FileParser {
    @Override
    protected String parseContent(String content) {
        // 模拟 JSON 解析
        return "JSON解析: " + content;
    }
}
