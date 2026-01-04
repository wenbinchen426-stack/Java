package 数据类型;

class Person implements Comparable<Person> {
    // 实现Comparable接口的抽象方法（接口必须实现所有抽象方法）
    @Override
    public int compareTo(Person o) {
        // 简单返回0（仅为满足语法，实际业务可按需求实现）
        return 0;
    }

    // 可选：重写toString，方便打印Person对象时显示有意义的内容
    @Override
    public String toString() {
        return "Person实例";
    }
}
