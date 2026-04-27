package interfaces;

//========================================
// Lambda 回调示例（函数式接口）
//========================================
@FunctionalInterface
public interface Operation {
    int apply(int a, int b);
}
