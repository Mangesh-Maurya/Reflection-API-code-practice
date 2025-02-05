package reflection.Api2;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

class A{
	int a=101;
	void m1() {
		System.out.println("mA in A");
	}
}
class B extends A{
	public final static int b1=909;
    final static int c1=808;
	B(){
		System.out.println("B() in B");
	}
	void mB() {
		System.out.println("mB in B");
		System.out.println(b1);
	}
	void mb1(int a,int b) {
		System.out.println("Mb1 in B");
	}
	
}
public class Jtc2 {
	public static void main(String[] args) {
		try{
			Class cls=Class.forName("reflection.Api2.B");
					B b1=(B)cls.newInstance();
			System.out.println(Modifier.PUBLIC);
			System.out.println(Modifier.PRIVATE);
			System.out.println(Modifier.FINAL);
			System.out.println("Fields********\n");
			Field f[]=cls.getFields();
			for(int i=0;i<f.length;i++) {
				System.out.println(f[i].getModifiers()+" Type "+f[i].getType()+" Name "+f[i].getName());
			}
			System.out.println("Declared Fields*******");
			Field f1[]=cls.getDeclaredFields();
			for(int i=0;i<f1.length;i++) {
				System.out.println(f1[i].getModifiers()+" Type "+f1[i].getType()+" Name "+f1[i].getName());
			}
		}catch(Exception e) {
		}
	}
}
		
