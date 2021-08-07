package com.jy.mybatisGenerator;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.mybatis.generator.config.xml.ConfigurationParser;


public class Generator {
	
	public static void main(String[] args) throws Exception{
		
		List<String> warnings = new ArrayList<String>();
		boolean overwrite = true;
		
		File configFile = new File("src/main/resources/generatorConfig.xml");

        System.out.println(configFile.getAbsolutePath());
        ConfigurationParser cp = new ConfigurationParser(warnings);

        Configuration config = cp.parseConfiguration(configFile);

        DefaultShellCallback callback = new DefaultShellCallback(overwrite);

        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config,

                callback, warnings);

        System.out.println("start generate");
        myBatisGenerator.generate(null);
        
        for(String warning : warnings) {
        	 System.out.println(warning);
        }
	}

	
}
