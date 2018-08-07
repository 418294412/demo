public class test {


    public static void main(String[] args) {
        System.out.println(13/12);
        A ab = new B();
        ab = new B();
        A  c = new B();
    }
}

class A {
    static {
        System.out.print("1");
    }

    public A() {
        System.out.print("2");
    }
}

class B extends A{
    static {
        System.out.print("a");
    }
    public B() {
        System.out.print("b");
    }
}