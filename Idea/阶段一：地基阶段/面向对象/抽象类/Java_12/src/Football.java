public class Football extends Game {
    @Override
    protected void init() {
        System.out.println("初始化足球比赛");
    }

    @Override
    protected void start() {
        System.out.println("足球比赛开始");
    }

    @Override
    protected void end() {
        System.out.println("足球比赛结束");
    }
}
