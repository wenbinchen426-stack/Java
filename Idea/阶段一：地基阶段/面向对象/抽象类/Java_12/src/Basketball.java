public class Basketball extends Game {
    @Override
    protected void init() {
        System.out.println("初始化篮球比赛");
    }

    @Override
    protected void start() {
        System.out.println("篮球比赛开始");
    }

    @Override
    protected void end() {
        System.out.println("篮球比赛结束");
    }
}
