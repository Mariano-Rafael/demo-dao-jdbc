package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.ArrayList;
import java.util.List;

public class Program2 {
    public static void main(String[] args) {

        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("--- TEST 1: department findById ---");
        Department department = departmentDao.findById(3);
        System.out.println(department);


        System.out.println("\n--- TEST 2: department findAll ---");
        List<Department> list = new ArrayList<>();
        list = departmentDao.findAll();
        for (Department obj : list) {
            System.out.println(obj);
        }

        System.out.println("\n--- TEST 3: seller insert ---");
        Department newDepartment = new Department(95,
                "Comics");

        departmentDao.insert(newDepartment);
        System.out.println("Inserted new id = " + newDepartment.getId());

        System.out.println("\n--- TEST 4: department update ---");
        department = departmentDao.findById(4);
        department.setName("Outros");
        departmentDao.update(department);
        System.out.println("Update completed");

        System.out.println("\n--- TEST 5: department delete ---");
        departmentDao.deleteById(99);
        System.out.println("Delete completed");
    }
}