package com.myframework.views;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletContext;

import com.framework.di.Component;
@Component(name="vr")
public class ViewResolverImp implements ViewResolver{

	
	private Properties props;

	@Override
	public View propretiesView(ServletContext servletContext) {
		InputStream input;
		View view=null;
		try {
			input = new FileInputStream(servletContext.getRealPath("/WEB-INF/ViewConfig.propreties"));
			Properties prop = System.getProperties();
			prop.load(input);
			String suffix=prop.getProperty("suffix",".jsp");
			String prefix=prop.getProperty("prefix","");
			view=new View(prefix, suffix);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        
		return view;
	}

}
