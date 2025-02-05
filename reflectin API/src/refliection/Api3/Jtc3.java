package refliection.Api3;

import java.lang.reflect.Method;

class Hello{
	void m1(String s1,String s2) {
		System.out.println("M1 in Hello");
		System.out.println(s1);
		System.out.println(s2);
	}
	void m2(int a,int b) {
		System.out.println("M2(int a,int b) in Hello");
		System.out.println(a);
		System.out.println(b);
	}
	void showAll() {
		System.out.println("ShowAll in Hello");
	}
	private void mPrivate() {
		System.out.println("MPrivate in Hello***** ");
	}
}
public class Jtc3 {
	public static void main(String[] args) {
		try{
			Class cls=Class.forName("refliection.Api3.Hello");
		    Hello h=(Hello)cls.newInstance();
		    Method m[]=cls.getDeclaredMethods();
		    for(int i=0;i<m.length;i++) {
		    	System.out.println(m[i].getName());
		    	if(m[i].getName().equals("m1")) {
		    		String s[]= {"Hello","JTC"};
		    		m[i].invoke(h, s);
		    	}
		    	if(m[i].getName().equals("showAll")) {
		    		String s[]= {"Hello","JTC"};
		    		m[i].invoke(h, null);
		    	}
		    	if(m[i].getName().equals("mPrivate")) {
		    		String s[]= {"Hello","JTC"};
		    		m[i].invoke(h, null);
		    	}
		    }
		    
		}catch(Exception e) {
			
		}
	}
}
