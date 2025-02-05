package reflection.Api;
class A{
	
}
interface I1{
	
}
interface I2{
	
}
class Hello extends A implements I1,I2{
	int a=99;
	int b;
	static {
		System.out.println("Sb in Hello");
	}
	{
		System.out.println("IB in Hello");
	}
	Hello(){
		System.out.println("Deflt constr in Hello");
	}
	Hello(int b){
		System.out.println("1 para constr in Hello");
		this.b=b;
	}
	void show() {
		System.out.println("Show in Hello");
		System.out.println(a);
		System.out.println(b);
	}
}
public class Jtc1 {
	public static void main(String[] args)throws Exception{
		Hello h1=new Hello();
		h1.show();
		System.out.println("**************\n");
		Class cls=Class.forName("reflection.Api.Hello");
		Hello h2=(Hello)cls.newInstance();
		h2.show();
		System.out.println("*********About the class**********\n");
		ClassLoader cl=cls.getClassLoader();
		System.out.println(cl);
		//System.out.println(cl.getName());
		System.out.println("**********************\n");
		System.out.println(cls);//java.lang.Class toString
		System.out.println(cls.getName());
		//System.out.println(cls.getPackageName());
		System.out.println(cls.getSuperclass());
		Class cls1[]=cls.getInterfaces();	
		for(int i=0;i<cls1.length;i++) {
			System.out.println(cls1[i].getName());
		}
	}
}
