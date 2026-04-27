// 模板方法模式示例
public abstract class Game {
    // 模板方法
    public final void play() {
        init();
        start();
        end();
    }

    protected abstract void init();

    protected abstract void start();

    protected abstract void end();
}
