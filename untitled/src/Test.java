public class Test extends Thread{
    final StringBuffer a = new StringBuffer();
    final StringBuffer b = new StringBuffer();

    public static void main(String[] args) {
        final Test ob = new Test();
        new Thread(){
            public void run(){
                synchronized (this){
                    ob.a.append("1");
                    ob.b.append("A");
                    System.out.println(ob.a);
                    System.out.println(ob.b);
                }
            }
        }.start();
        new Thread(){
            public void run(){
                synchronized (this){
                    ob.a.append("2");
                    ob.b.append("B");
                    System.out.println(ob.a);
                    System.out.println(ob.b);
                }
            }
        }.start();
    }
}
