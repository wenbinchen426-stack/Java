package 面向对象; // 遵循Java包命名规范

/**
 * Java 面向对象（OOP）核心学习笔记
 * 核心涵盖：类与对象、封装、继承、多态、抽象类、接口、关键字（this/super）
 * 特性：代码可直接运行、核心概念标注、易错点高亮、实战示例
 */
public class Object_Oriented {
    public static void main(String[] args) {
        // ============== 一、类与对象（OOP基础） ==============
        System.out.println("============== 一、类与对象 ==============");
        /**
         * 核心概念：
         * 1. 类：是对现实事物的抽象（属性+行为），如“学生类”包含姓名、年龄（属性），学习、吃饭（行为）
         * 2. 对象：是类的具体实例，如“张三这个学生”是“学生类”的一个对象
         * 3. 类是模板，对象是模板创建的具体实例
         */
        // 1. 创建对象（实例化）：类名 对象名 = new 类名();
        Student student1 = new Student();
        // 2. 给对象的属性赋值（通过setter方法，封装特性）
        student1.setName("张三");
        student1.setAge(18);
        // 3. 调用对象的方法
        student1.study(); // 执行行为
        student1.eat("米饭");
        // 4. 获取对象属性（通过getter方法）
        System.out.println("学生信息：" + student1.getName() + "，年龄：" + student1.getAge());

        // 创建第二个对象（类的不同实例，属性独立）
        Student student2 = new Student();
        student2.setName("李四");
        student2.setAge(20);
        System.out.println("第二个学生：" + student2.getName() + "，年龄：" + student2.getAge());

        // ============== 二、封装（OOP三大特性之一） ==============
        System.out.println("\n============== 二、封装 ==============");
        /**
         * 核心概念：
         * 1. 封装：将类的属性私有化（private），对外提供公共（public）的getter/setter方法访问
         * 2. 目的：保护属性不被随意修改，控制属性的访问规则（如年龄不能为负数）
         * 3. 访问修饰符：private（仅本类）、default（同包）、protected（同包+子类）、public（所有）
         */
        // 测试封装的安全性：年龄赋值负数会被拦截
        student1.setAge(-18); // 执行setter方法时，会验证年龄合法性
        System.out.println("赋值负数年龄后的结果：" + student1.getAge()); // 仍为18

        // ============== 三、继承（OOP三大特性之二） ==============
        System.out.println("\n============== 三、继承 ==============");
        /**
         * 核心概念：
         * 1. 继承：子类（派生类）继承父类（基类）的属性和方法，实现代码复用
         * 2. 语法：class 子类 extends 父类 {}
         * 3. Java特性：单继承（一个子类只能继承一个父类），但可多层继承
         * 4. super关键字：访问父类的属性、方法、构造方法
         * 5. 构造方法：子类构造方法默认先调用父类的无参构造（super()）
         */
        // 创建子类对象（大学生类继承学生类）
        CollegeStudent collegeStudent = new CollegeStudent();
        collegeStudent.setName("王五");
        collegeStudent.setAge(22);
        collegeStudent.setMajor("计算机科学");
        // 继承父类的方法
        collegeStudent.study();
        // 子类自己的方法
        collegeStudent.doExperiment();
        // 调用父类的方法（通过super）
        collegeStudent.showParentMethod();

        // ============== 四、多态（OOP三大特性之三） ==============
        System.out.println("\n============== 四、多态 ==============");
        /**
         * 核心概念：
         * 1. 多态：同一行为，不同子类有不同实现（父类引用指向子类对象）
         * 2. 前提：继承 + 方法重写（@Override）
         * 3. 语法：父类类型 变量名 = new 子类类型();
         * 4. 特点：编译看父类，运行看子类（执行子类重写后的方法）
         */
        // 父类引用指向子类对象（多态核心语法）
        Student polyStudent1 = new CollegeStudent();
        Student polyStudent2 = new MiddleSchoolStudent();
        // 调用study方法：编译时看Student类，运行时执行子类重写的方法
        polyStudent1.study(); // 执行CollegeStudent的study方法
        polyStudent2.study(); // 执行MiddleSchoolStudent的study方法

        // ============== 五、抽象类与接口 ==============
        System.out.println("\n============== 五、抽象类与接口 ==============");
        /**
         * 抽象类：
         * 1. 语法：abstract class 类名 {}，包含抽象方法（abstract 方法名();）和普通方法
         * 2. 特点：不能实例化，子类必须重写所有抽象方法（除非子类也是抽象类）
         * 3. 用途：定义通用模板，约束子类必须实现某些方法
         *
         * 接口：
         * 1. 语法：interface 接口名 {}，所有方法默认public abstract，属性默认public static final
         * 2. 特点：不能实例化，类通过implements实现接口，必须重写所有方法
         * 3. 用途：定义行为规范，实现多实现（一个类可实现多个接口）
         */
        // 抽象类使用：子类实现抽象方法
        Animal dog = new Dog();
        dog.eat(); // 执行Dog重写的eat方法
        dog.sleep(); // 执行抽象类的普通方法

        // 接口使用：类实现接口
        Flyable bird = new Bird();
        bird.fly();
        Swimmable fish = new Fish();
        fish.swim();

        // ============== 六、this关键字 ==============
        System.out.println("\n============== 六、this关键字 ==============");
        /**
         * 核心概念：
         * 1. this：代表当前对象的引用
         * 2. 用途：
         *    - 区分成员变量和局部变量（this.属性名）
         *    - 调用当前对象的方法（this.方法名()）
         *    - 调用当前类的构造方法（this()，必须在构造方法第一行）
         */
        student1.showThisUsage(); // 演示this的使用
    }
}

// ********************* 以下是示例类定义 *********************

// 1. 基础类：学生类（演示类与对象、封装）
class Student {
    // 1.1 属性私有化（封装核心：private）
    private String name; // 姓名
    private int age;     // 年龄

    // 1.2 无参构造方法（默认存在，手动写出便于理解）
    public Student() {
        System.out.println("Student类的无参构造方法执行");
    }

    // 1.3 有参构造方法（重载）
    public Student(String name, int age) {
        this.name = name; // this区分成员变量和局部变量
        this.age = age;
    }

    // 1.4 getter/setter方法（封装核心：对外提供访问入口）
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        // 封装的优势：控制属性访问规则（年龄不能小于0）
        if (age >= 0) {
            this.age = age;
        } else {
            System.out.println("错误：年龄不能为负数，赋值失败");
        }
    }

    // 1.5 行为方法
    public void study() {
        System.out.println(name + "正在学习");
    }

    public void eat(String food) {
        System.out.println(name + "正在吃" + food);
    }

    // 演示this关键字的使用
    public void showThisUsage() {
        String name = "局部变量张三";
        // this.name：当前对象的成员变量；name：局部变量
        System.out.println("局部变量name：" + name);
        System.out.println("成员变量name（this.name）：" + this.name);
        this.study(); // 调用当前对象的study方法（this可省略，此处为演示）
    }
}

// 2. 子类：大学生类（演示继承）
class CollegeStudent extends Student {
    // 子类新增属性
    private String major; // 专业

    // 构造方法（默认调用父类无参构造super()）
    public CollegeStudent() {
        // super(); // 隐式存在，可省略，必须在构造方法第一行
        System.out.println("CollegeStudent类的无参构造方法执行");
    }

    // getter/setter
    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    // 子类新增方法
    public void doExperiment() {
        System.out.println(getName() + "（专业：" + major + "）正在做实验");
    }

    // 重写父类的study方法（多态前提）
    @Override
    public void study() {
        System.out.println(getName() + "（大学生）正在学习专业课程：" + major);
    }

    // 演示super关键字访问父类方法
    public void showParentMethod() {
        super.study(); // 调用父类的study方法（而非子类重写的）
    }
}

// 3. 另一个子类：中学生类（演示多态）
class MiddleSchoolStudent extends Student {
    // 重写父类的study方法（多态核心：方法重写）
    @Override
    public void study() {
        System.out.println(getName() + "（中学生）正在学习语数外");
    }
}

// 4. 抽象类（演示抽象类与抽象方法）
abstract class Animal {
    // 抽象方法：只有声明，没有实现（子类必须重写）
    public abstract void eat();

    // 普通方法：有实现
    public void sleep() {
        System.out.println("动物正在睡觉");
    }
}

// 抽象类的子类：必须重写抽象方法
class Dog extends Animal {
    @Override
    public void eat() {
        System.out.println("狗正在吃骨头");
    }
}

// 5. 接口1：可飞的（演示接口）
interface Flyable {
    // 接口方法：默认public abstract，可省略
    void fly();
}

// 接口2：可游泳的（演示多实现）
interface Swimmable {
    void swim();
}

// 实现接口的类：必须重写所有接口方法
class Bird implements Flyable {
    @Override
    public void fly() {
        System.out.println("鸟正在飞");
    }
}

class Fish implements Swimmable {
    @Override
    public void swim() {
        System.out.println("鱼正在游泳");
    }
}

// 演示多实现：一个类实现多个接口
class Duck implements Flyable, Swimmable {
    @Override
    public void fly() {
        System.out.println("鸭子正在低空飞");
    }

    @Override
    public void swim() {
        System.out.println("鸭子正在水里游");
    }
}