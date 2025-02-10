package com.example.demo.hanteo1;

public class MainClass {

	public static void main(String[] args) {
		IdolDataStructure idolDataStructure = new IdolDataStructure();

		// 성공 csae
		System.out.println("===성공 케이스===");
		System.out.println(idolDataStructure.searchChildCategoryByName("방탄소년단"));
		System.out.println(idolDataStructure.searchChildCategoryById("21"));

		//실패 case
		System.out.println("\n===실패 케이스===");
		System.out.println(idolDataStructure.searchChildCategoryByName("한터"));
		System.out.println(idolDataStructure.searchChildCategoryById("777"));

		// json string
		System.out.println("\n===json string===");
		idolDataStructure.printJSonString();
	}
}
