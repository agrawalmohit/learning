package practice;

import java.lang.reflect.Method;
import java.util.Set;
import java.util.TreeSet;

public class JavaReflection {
	
	public static void main(String[] args) {
		try{
            Set<String> set = new TreeSet<>();
            Class claz = Class.forName("Student");
            while(claz != null){
            for(Method method:claz.getDeclaredMethods()){
                set.add(method.getName());
            }
                claz = claz.getSuperclass();
            }
            for(String name:set){
                System.out.println(name);
            }
        }catch(Exception ex){}
	}
	
	

}

class Student{
	
	public void test() {}
	
}
