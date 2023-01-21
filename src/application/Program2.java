package application;

import java.util.ArrayList;
import java.util.List;

//import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {
    public static void main(String[] args) {
        //Scanner sc = new Scanner(System.in);

        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("=== TEST 1: department findById ===");
        Department department = departmentDao.findById(2);
        System.out.println(department);

        System.out.println("=== TEST 2: department findAll ===");
        List<Department> list = new ArrayList<>();
        list = departmentDao.findAll();
        System.out.println(list);

        System.out.println("=== TEST 3: department insert ===");
        Department dep = new Department(null, "Music");
        departmentDao.insert(dep);
        System.out.println("inserted! new id = "+dep.getId());

        System.out.println("=== TEST 4: department update ===");
        Department depUpdate = new Department(6, "Food");
        departmentDao.update(depUpdate);
        System.out.println("update completed!");

        System.out.println("=== TEST 5: department deleteById ===");
        departmentDao.deleteById(7);
        System.out.println("delete completed!");

    }   
}
