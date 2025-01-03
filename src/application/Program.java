package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== Test 1: seller findById ===");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller.toString());
		
		System.out.println("\n=== Test 2: seller findByDepartment ===");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		list.forEach(System.out::println);
		
		System.out.println("\n=== Test 3: seller findAll ===");
		list = sellerDao.findAll();
		for (Seller obj : list) {
			System.out.println(obj.toString());
		}
		
		System.out.println("\n=== Test 4: seller insert ===");
		Seller newSeller = new Seller(null, "Gref", "Gref@gmail.com", new Date(), 1873.87, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New Id: "+newSeller.getId());
		
		System.out.println("\n=== Test 5: seller update ===");
		seller = sellerDao.findById(1);
		seller.setName("William");
		seller.setEmail("william@gmail.com");
		sellerDao.update(seller);
		System.out.println("Update completed!");
		
		Scanner sc = new Scanner(System.in);
		System.out.println("\n=== Test 6: seller delete ===");
		System.out.println("Entre com um id para teste de delete: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Deleted!");
		sc.close();
	}

}
