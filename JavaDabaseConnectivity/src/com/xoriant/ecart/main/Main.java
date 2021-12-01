package com.xoriant.ecart.main;

import java.util.Scanner;

import com.xoriant.ecart.dao.EcartDaoImpl;
import com.xoriant.ecart.util.EcartUtility;

public class Main {

	public void showMain() {
		String str="yes";
		do {
	    System.out.println("=============================================");	
		System.out.println("=============== Welcome TO Ecart ============");
		System.out.println("=============================================");
		
		System.out.println(" 1) Add New Brand");
		System.out.println(" 2) Add New Category");
		System.out.println(" 3) Add New Product");
		System.out.println(" 4) List Of ALL Products");
		System.out.println(" 5) List Of ALL Brand");
		System.out.println(" 6) List Of ALL Category");
		System.out.println(" 7) Delete Brand");
		System.out.println(" 8) Delete Category");
		System.out.println(" 9) Delete Product");
		System.out.println(" 10) List of Samsung Product");
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your choice please::");
		int num=sc.nextInt();
		
		EcartDaoImpl e1=new EcartDaoImpl();
		EcartUtility eu=new EcartUtility();
		
		switch(num) {
		case 1:
			System.out.println("========== Add New BRAND =========");
			eu.addNewBrand();
			break;
			
		case 2:
			System.out.println(" =========== Add New Category =========");
			eu.addNewCategory();
			break;
		case 3:
			System.out.println("============ Add New Product ===========");
			eu.addNewProduct();
		case 4:
			System.out.println("============= List Of All Product==========");
			e1.fetchAllProducts().forEach(System.out::println);
			break;
		case 5:
			System.out.println("============= List Of All Brand==========");
			e1.fetchAllBrand().forEach(System.out::println);
			break;
		case 6:
			System.out.println("============= List Of All Category==========");
			e1.fetchAllCategory().forEach(System.out::println);
			break;
			
		case 7:
			System.out.println("=============Delete Brand ==========");
			eu.deleteBrand();
			break;
			
		case 8:
			System.out.println("=============Delete Category ==========");
			eu.deleteCategory();
			break;
			
		case 9:
			System.out.println("=============Delete Product ==========");
			eu.deleteProduct();
			break;
			
		case 10:
			System.out.println("=============List Of ALL Product Samsung==========");
			e1.fetchAllSamsungProduct().forEach(System.out::println);
			break;
			
		}
		System.out.println("Do you want to Continue again? 1)yes 2)no");
		str=sc.next();
		}while(str.equals("yes"));
	}
}
