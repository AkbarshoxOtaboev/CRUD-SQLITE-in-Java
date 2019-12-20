package uz.seteam.sqlite.controller;

import uz.seteam.sqlite.entity.Company;
import uz.seteam.sqlite.repostroy.CompanyRepository;

import java.util.Scanner;

public class CompanyController extends CompanyRepository {
    private Scanner scanner = new Scanner(System.in);

    public void isWorkingCompany() {
        boolean stop = true;
        while (stop){
            System.out.println("<<   Comapany blog   >>");
            System.out.println("=======================");
            System.out.println("=======================");
            System.out.println("1- All companies");
            System.out.println("2- Create company");
            System.out.println("3- Update");
            System.out.println("4- Delete");
            System.out.println("5- Get company by id");
            System.out.println("6- Back to home");
            switch (scanner.nextInt()) {
                case 1:
                    System.out.println(getAllCompany());
                    break;
                case 2:
                    madeCompany();
                    break;
                case 3:
                    update();
                    break;
                case 4:
                    remove();
                    break;
                case 5:
                    readOneCompany();
                    break;
                case 6:
                    stop=false;
                    break;
            }
        }

    }

    private void readOneCompany() {
        System.out.println("   Read one company  ");
        System.out.println("=====================");
        System.out.println(getAllCompany());
        System.out.println("Input id which you see");
        Long id = scanner.nextLong();
        System.out.println(getCompanyById(id));
    }

    private void remove() {
        System.out.println("Delete company");
        System.out.println("==============");
        System.out.println(getAllCompany());
        System.out.println("Input id which you delete");
        Long idToRemove = scanner.nextLong();
        deleteCompany(idToRemove);
    }

    private void update() {
        System.out.println("Update company");
        System.out.println("==============");
        System.out.println(getAllCompany());
        System.out.println("Type id company");
        Long idForCompany = scanner.nextLong();
        System.out.println(getCompanyById(idForCompany));
        System.out.println("Input update name");
        String updateName = scanner.next();
        System.out.println("Input update balans");
        Integer updateBalans = scanner.nextInt();
        Company updateToCompany = new Company(updateName, updateBalans);
        updateToCompany.setId(idForCompany);
        updateCompany(updateToCompany);


    }

    private void madeCompany() {
        System.out.println("Input name");
        String name = scanner.next();
        System.out.println("Input balans");
        Integer balans = scanner.nextInt();
        Company newCompany = new Company(name, balans);
        createCompany(newCompany);
    }
}
