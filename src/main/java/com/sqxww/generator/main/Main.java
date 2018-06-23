package com.sqxww.generator.main;


public class Main {
	public static void main(String[] args) throws Exception {
		Generator.generateMapper();
		Generator.generateController();
		Generator.generateDao();
		Generator.generateDaoImpl();
		Generator.generateTbl();
		Generator.generatePo();
		Generator.generateDomain();
		Generator.generateQueryDao();
		Generator.generateQueryDaoImpl();
		Generator.generateRepository();
		Generator.generateRepositoryImpl();
	}

}
