package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("=== Test 1: department findById ===");
		Department department = departmentDao.findById(3);
		System.out.println(department.toString());
		
		System.out.println("\n=== Test 2: department findAll ===");
		List<Department> list = departmentDao.findAll();
		for (Department obj : list) {
			System.out.println(obj.toString());
		}
		
		System.out.println("\n=== Test 3: department insert ===");
		Department newDepartment = new Department(null, "Food");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! New Id: "+newDepartment.getId());
		
		System.out.println("\n=== Test 4: department update ===");
		department = departmentDao.findById(10);
		department.setName("Computer");
		departmentDao.update(department);
		System.out.println("Update completed!");
		
		Scanner sc = new Scanner(System.in);
		System.out.println("\n=== Test 5: department delete ===");
		System.out.println("Entre com um id para teste de delete: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Deleted!");
		sc.close();
	}

}
