package com.sqxww.generator.strutil;

import org.junit.Test;

import com.sqxww.generator.utils.NameUtil;

public class NameUtilTest {
	
	@Test
	public void firstUp(){
		System.out.println(NameUtil.firstToUp("Adbdd"));
	}
	
	@Test
	public void firstLow(){
		System.out.println(NameUtil.firstToLow("1AAA"));
	}
	
	@Test
	public void delUnLine(){
		System.out.println(NameUtil.delUnderLine("me_lexj_appoint"));
	}
	
	@Test
	public void packToPath(){
		System.out.println(NameUtil.packToPath("com.sqxww.generator"));
	}
}
