package uz.seteam.sqlite;

import org.hibernate.Session;
import uz.seteam.sqlite.entity.Company;
import uz.seteam.sqlite.repostroy.CompanyRepository;
import uz.seteam.sqlite.utils.HibernateUtils;

import java.util.Scanner;

public class App extends CompanyRepository {
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        new App().run();

    }

    private void run() throws Exception {
        Session session = HibernateUtils.openSession();
        while (true){
            System.out.println("1-create company");
            System.out.println("2-get all company");
            System.out.println("3-Get company by id");
            System.out.println("4-Update company");
            System.out.println("5-Delete company");
            switch (scanner.nextInt()){
                case 1:
                    createCompany();
                    break;
                case 2:
                    System.out.println(getAllCompany());
                    break;
                case 3:
                    getCompanyId();
                    break;
                case 4:
                    update();
                    break;
                case 5:
                    delete();
                    break;
            }
        }
    }

    private void delete() {
        System.out.println("Delete company by id");
        System.out.println("====================");
        System.out.println(getAllCompany());
        System.out.println("Input id: ");
        Long id = scanner.nextLong();
        System.out.println(getCompanyById(id));
        System.out.println(" 1-YES  or  2-NO");
        switch (scanner.nextInt()){
            case 1:
                deleteCompany(id);
                break;
            case 2:
                delete();
                break;
        }
    }

    private void update() {
        System.out.println( " update company");
        System.out.println(" ============== ");
        System.out.println(getAllCompany());
        System.out.print("Type company id :  ");
        Long idToUpdate = scanner.nextLong();
        System.out.println(getCompanyById(idToUpdate));
        System.out.println("Company name : ");
        String name = scanner.next();
        System.out.println("Balanse:  ");
        Integer balanse = scanner.nextInt();
        Company updateToCompany = new Company(name,balanse);
        updateToCompany.setId(idToUpdate);
        updateCompany(updateToCompany);


    }

    private void getCompanyId() {
        System.out.println("Input Id");
        Long id = scanner.nextLong();
        System.out.println(getCompanyById(id));
    }

    private void createCompany() {
        System.out.println("Input company name");
        String name = scanner.next();
        System.out.println("Input company balans");
        Integer balans = scanner.nextInt();
        Company company = new Company(name,balans);
        createCompany(company);

    }
}
