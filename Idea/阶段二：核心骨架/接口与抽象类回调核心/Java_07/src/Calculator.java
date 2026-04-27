import interfaces.Operation;

class Calculator {
    public void compute(int a, int b, Operation op) {
        int result = op.apply(a, b);
        System.out.println("计算结果: " + result);
    }
}
