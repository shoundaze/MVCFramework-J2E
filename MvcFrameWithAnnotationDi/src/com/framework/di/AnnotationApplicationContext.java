package com.framework.di;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Set;

import org.reflections.Reflections;


public class AnnotationApplicationContext {

	String strings[];
	public AnnotationApplicationContext(String...strings) {
		this.strings=strings;
		
		
	}
	
	public Object getBean(String bean) {
		
		// TODO Auto-generated method stub
		Object o=null;
		for(String s:strings) {
		Reflections reflections = new Reflections(s);
		
		Set<Class<?>> annotated = reflections.getTypesAnnotatedWith(Component.class); 
		Iterator<Class<?>> listClass=annotated.iterator();
		while(listClass.hasNext()){
			try {
				Class obj=Class.forName(listClass.next().getName());
				Annotation ann=obj.getAnnotation(Component.class);
				Component cp=(Component) ann;
				
				if(cp.name().equals(bean)) {
					//instantiation
					
					try {
						o=obj.newInstance();
						
						for(Field f:obj.getFields()) {
							System.out.println("prop "+f.getName());
							
							if(f.isAnnotationPresent(Autowired.class)) {
								
								Annotation ann2=f.getAnnotation(Autowired.class);
								Autowired cp2=(Autowired) ann2;
								Object inject=getBean(cp2.name());
								
								System.out.println(cp2.name()+" "+inject);
								
								
								try {
									String prop=f.getName();
									prop = prop.substring(0, 1).toUpperCase() + prop.substring(1);
									Method setMethod = obj.getMethod("set" + prop, f.getType());
									setMethod.invoke(o, inject);
									
								} catch (IllegalArgumentException | InvocationTargetException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} catch (NoSuchMethodException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} catch (SecurityException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								
							}
						}
						
					} catch (InstantiationException | IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		}
		return o;
	}
	
	
	private Class getFieldType(Object o, String name) {
		Class cl = null;
		try {
			System.out.println(o.getClass().getDeclaredField(name).getType());
			cl = o.getClass().getDeclaredField(name).getType();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cl;

	}
	
}
