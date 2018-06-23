package com.sqxww.generator.fileutil;

import org.junit.Test;

import com.sqxww.generator.utils.FileUtil;

public class FileUtilTest {
	
	@Test
	public void newPack(){
		try {
			FileUtil.newPackage("com.xxx.hello");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void  getSrcPath() {
		System.out.println(FileUtil.getSrcPath("maven"));
	}
}
