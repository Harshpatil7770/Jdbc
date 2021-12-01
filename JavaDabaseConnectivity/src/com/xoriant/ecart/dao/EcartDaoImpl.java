package com.xoriant.ecart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.xoriant.ecart.config.DBconfig;
import com.xoriant.ecart.model.Brand;
import com.xoriant.ecart.model.Category;
import com.xoriant.ecart.model.Product;

public class EcartDaoImpl {

	public void addNewBrand(Brand brand) {
		try {
				
			Connection con=DBconfig.getConnection();
			String query="insert into brands values(?,?)";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1,brand.getBrandId());
			ps.setString(2,brand.getBrandName());
			
			int res=ps.executeUpdate();
			if(res!=0) {
				System.out.println(" New Brand Added Succesfully BrandId::"+brand.getBrandId()+" BrandName::"+brand.getBrandName());
			}else {
				System.out.println(" Record Not Saved.......................");
			}
		}catch(Exception  e) {
			e.printStackTrace();
		} /*
			 * finally { DBconfig.closeConnection(); }
			 */
	}
	
  public void addNewCategoey(Category category) {
	  try {
		  Connection con=DBconfig.getConnection();
		  String query="insert into categories values(?,?)";
		  PreparedStatement ps=con.prepareStatement(query);
		  ps.setInt(1,category.getCategoryId());
		  ps.setString(2,category.getCategoryName());
		  
		  int res=ps.executeUpdate();
		  if(res!=0) {
			  System.out.println("New Category added categoryName ::"+category.getCategoryName());
		  }else {
			  System.out.println("Record not saved ...............");
		  }
	  }catch(Exception e) {
		  e.printStackTrace();
		} /*
			 * finally { DBconfig.closeConnection(); }
			 */
}
  
   public void addNewProduct(Product product) {
	  try {
		  Connection con=DBconfig.getConnection();
		  String query="insert into products(?,?,?,?,?)";
		  PreparedStatement ps=con.prepareStatement(query);
		  ps.setInt(1,product.getProductId());
		  ps.setString(2,product.getProductName());
		  ps.setDouble(3,product.getProductPrice());
		  ps.setInt(4,product.getBrand().getBrandId());
		  ps.setInt(5,product.getCategory().getCategoryId());
		  
		  int res=ps.executeUpdate();
		  if(res!=0) {
			  System.out.println("Product Added Succesfully"+product.getProductId()+" "+product.getProductName()+" "+product.getProductPrice()+
					  " "+product.getBrand().getBrandId()+" "+product.getCategory().getCategoryId());
		  }else {
			  System.out.println("Record not Saved .....................");
		  }
	  }catch(Exception e) {
		  e.printStackTrace();
		} /*
			 * finally { DBconfig.closeConnection(); }
			 */
  }
   
   public List<Product> fetchAllProducts(){
	   List<Product> list=new ArrayList<Product>();
	   try {
		   Connection con=DBconfig.getConnection();
		   Statement st=con.createStatement();
		   String query="select * from products p inner join brands b on p.brand_id=b.brand_id inner join categories c on p.category_id=c.category_id";
		   ResultSet rs=st.executeQuery(query);
		   while(rs.next()) {
			   Product product=new Product();
			   Brand brand=new Brand();
			   Category category=new Category();
			   
			   product.setProductId(rs.getInt(1));
			   product.setProductName(rs.getString(2));
			   product.setProductPrice(rs.getDouble(3));
			   brand.setBrandId(rs.getInt(4));
			   brand.setBrandName(rs.getString(5));
			   category.setCategoryId(rs.getInt(6));
			   category.setCategoryName(rs.getString(7));
			   
			   product.setBrand(brand);
			   product.setCategory(category);
			   list.add(product);
		   }
	   }catch(Exception e) {
		   e.printStackTrace();
		} /*
			 * finally { DBconfig.closeConnection(); }
			 */
	   return list;
   }
   
   
   public List<Brand> fetchAllBrand(){
	   List<Brand> list=new ArrayList<Brand>();
	   try {
		   Connection con=DBconfig.getConnection();
		   Statement st=con.createStatement();
		   String query="select * from brands";
		   ResultSet rs=st.executeQuery(query);
		   while(rs.next()) {
			   Brand brand=new Brand();
			   brand.setBrandId(rs.getInt(1));
			   brand.setBrandName(rs.getString(2));
			 
			   list.add(brand);
		   }
	   }catch(Exception e) {
		   e.printStackTrace();
		} /*
			 * finally { DBconfig.closeConnection(); }
			 */
	   return list;
   }
   
   public List<Category> fetchAllCategory(){
	   List<Category> list=new ArrayList<Category>();
	   try {
		   Connection con=DBconfig.getConnection();
		   Statement st=con.createStatement();
		   String query="select * from categories";
		   ResultSet rs=st.executeQuery(query);
		   while(rs.next()) {
			   Category category=new Category();
			   category.setCategoryId(rs.getInt(1));
			   category.setCategoryName(rs.getString(2));
			 
			   list.add(category);
		   }
	   }catch(Exception e) {
		   e.printStackTrace();
		} /*
			 * finally { DBconfig.closeConnection(); }
			 */
	   return list;
   }
   
   public void deleteBrand(Brand brand) {
	   try {
		   Connection con=DBconfig.getConnection();
		   String query="delete from brands where brand_id=?";
		  PreparedStatement ps=con.prepareStatement(query);
		  ps.setInt(1,brand.getBrandId());
		  int res=ps.executeUpdate();
		  if(res!=0) {
			  System.out.println(" Deleted Brand Succesfullly...........");
		  }else {
			  System.out.println(" BrandId not Present in DB");
		  }
	   }catch(Exception e) {
		   e.printStackTrace();
		} /*
			 * finally { DBconfig.closeConnection(); }
			 */
   }
   
   
   public void deleteProduct(Product product) {
	   try {
		   Connection con=DBconfig.getConnection();
		   String query="delete from products where product_id=?";
		  PreparedStatement ps=con.prepareStatement(query);
		  ps.setInt(1,product.getProductId());
		  int res=ps.executeUpdate();
		  if(res!=0) {
			  System.out.println(" Deleted Product Succesfullly...........");
		  }else {
			  System.out.println(" ProductId not Present in DB");
		  }
	   }catch(Exception e) {
		   e.printStackTrace();
		} /*
			 * finally { DBconfig.closeConnection(); }
			 */
   }
   
   public void deleteCategory(Category category) {
	   try {
		   Connection conn=DBconfig.getConnection();
		   String query="delete from categories where category_id=?";
		   PreparedStatement ps=conn.prepareStatement(query);
		   ps.setInt(1,category.getCategoryId());
		   
		   int res=ps.executeUpdate();
		   if(res!=0) {
			   System.out.println("Deleted Succesfully............");
		   }else {
			   System.out.println(" CategoryId is not found");
		   }
	   }catch(Exception e) {
		   e.printStackTrace();
	   }
   }
   
   public List<Product> fetchAllSamsungProduct(){
	   List<Product> list=new ArrayList<Product>();
	   try {
		   Connection con=DBconfig.getConnection();
		   Statement st=con.createStatement();
		   String query="select * from products p inner join brands b on  p.brand_id=b.brand_id  inner join categories c on  p.category_id=c.category_id where brand_name='Samsung'";
		   ResultSet rs=st.executeQuery(query);
		   while(rs.next()) {
			   Product product=new Product();
			   Brand brand=new Brand();
			   Category category=new Category();
			   
			   product.setProductId(rs.getInt(1));
			   product.setProductName(rs.getString(2));
			   product.setProductPrice(rs.getDouble(3));
			   brand.setBrandId(rs.getInt(4));
			   brand.setBrandName(rs.getString(5));
			   category.setCategoryId(rs.getInt(6));
			   category.setCategoryName(rs.getString(7));
			   
			   product.setBrand(brand);
			   product.setCategory(category);
			   list.add(product); 
		   }
	   }catch(Exception e) {
		   e.printStackTrace();
		} /*
			 * finally { DBconfig.closeConnection(); }
			 */
	   return list;
   }
}
