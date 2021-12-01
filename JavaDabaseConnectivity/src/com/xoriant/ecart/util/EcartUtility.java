package com.xoriant.ecart.util;

import java.util.Scanner;

import com.xoriant.ecart.dao.EcartDaoImpl;
import com.xoriant.ecart.model.Brand;
import com.xoriant.ecart.model.Category;
import com.xoriant.ecart.model.Product;

public class EcartUtility {

	public void addNewBrand() {
		Scanner sc=new Scanner(System.in);
		System.out.println(" Enter Brand Name ::");
		String brandName=sc.next();
		
		Brand brand=new Brand();
		brand.setBrandName(brandName);
		
		EcartDaoImpl e1=new EcartDaoImpl();
		e1.addNewBrand(brand);
	}
	
	public void addNewCategory() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter category Name");
		String categoryName=sc.next();
		
		Category category=new Category();
		category.setCategoryName(categoryName);
		
		EcartDaoImpl e1=new EcartDaoImpl();
		e1.addNewCategoey(category);
	}
	
	
	public void addNewProduct() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter New Product Name ::");
		String productName=sc.next();
		System.out.println("Enter New Product Price ::");
		double price=sc.nextDouble();
		System.out.println("Enter Brand Id ::");
		int brandId=sc.nextInt();
		System.out.println("Enter Category Id ::");
		int categoryId=sc.nextInt();
		
		Product product=new Product();
		Brand brand=new Brand();
		Category category=new Category();
		product.setProductName(productName);
		product.setProductPrice(price);
		brand.setBrandId(brandId);
		category.setCategoryId(categoryId);
		
		product.setBrand(brand);
		product.setCategory(category);
		
		EcartDaoImpl e1=new EcartDaoImpl();
		e1.addNewProduct(product);
		
	} 
	
	
	public void deleteBrand() {
		Scanner sc=new Scanner(System.in);
		System.out.println("ENter Brand ID::");
		int brandId=sc.nextInt();
		
		Brand brand=new Brand();
		brand.setBrandId(brandId);
		
		EcartDaoImpl e1=new EcartDaoImpl();
		e1.deleteBrand(brand);
		
	}

	
	public void deleteProduct() {
		Scanner sc=new Scanner(System.in);
		System.out.println("ENter Product ID::");
		int productId=sc.nextInt();
		
		Product product=new Product();
		product.setProductId(productId);
		
		EcartDaoImpl e1=new EcartDaoImpl();
		e1.deleteProduct(product);
		
	}
	
	
	public void deleteCategory() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter CategoryID::");
		int categoryId=sc.nextInt();
		
		Category category=new Category();
		category.setCategoryId(categoryId);
		
		EcartDaoImpl e1=new EcartDaoImpl();
		e1.deleteCategory(category);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}


