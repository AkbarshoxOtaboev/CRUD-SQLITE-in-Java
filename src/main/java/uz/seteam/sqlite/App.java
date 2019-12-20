package uz.seteam.sqlite;

import org.hibernate.Session;
import uz.seteam.sqlite.controller.CompanyController;
import uz.seteam.sqlite.controller.DragController;
import uz.seteam.sqlite.repostroy.CompanyRepository;
import uz.seteam.sqlite.utils.HibernateUtils;

import java.util.Scanner;

public class App {
    private Scanner scanner = new Scanner(System.in);
    private CompanyController companyController = new CompanyController();
    private DragController dragController = new DragController();
    public static void main(String[] args) throws Exception {
        new App().run();

    }

    private void run() throws Exception {
        Session session = HibernateUtils.openSession();
        while (true) {
            System.out.println("1-Companies blog");
            System.out.println("2-Drags blog");
            System.out.println("3-Payments blog");
            switch (scanner.nextInt()){
                case 1:
                    companyController.isWorkingCompany();
                    break;
                case 2:
                    dragController.isWorkingDrag();
                    break;

            }
        }

    }
}
