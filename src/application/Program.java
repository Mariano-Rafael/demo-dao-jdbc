package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.List;

public class Program {
    public static void main(String[] args) {

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("--- TEST 1: seller findById ---");
        Seller seller = sellerDao.findById(2);
        System.out.println(seller);

        System.out.println("\n--- TEST 2: seller findByDepartment ---");
        List<Seller> list = sellerDao.findByDepartment(new Department(2, null));
        for (Seller obj : list) {
            System.out.println(obj);
        }

        System.out.println("\n--- TEST 3: seller findAll ---");
        list = sellerDao.findAll();
        for (Seller obj : list) {
            System.out.println(obj);
        }

        System.out.println("\n--- TEST 4: seller insert ---");
        Seller newSeller = new Seller(null,
                "Greg",
                "4yG8K@example.com",
                new java.util.Date(),
                4000.0,
                new Department(1, null));

        sellerDao.insert(newSeller);
        System.out.println("Inserted new id = " + newSeller.getId());

        System.out.println("\n--- TEST 5: seller update ---");
        seller = sellerDao.findById(4);
        seller.setName("Martha Waine");
        sellerDao.update(seller);
        System.out.println("Update completed");

        System.out.println("\n--- TEST 6: seller delete ---");
        sellerDao.deleteById(2);
        System.out.println("Delete completed");
    }
}