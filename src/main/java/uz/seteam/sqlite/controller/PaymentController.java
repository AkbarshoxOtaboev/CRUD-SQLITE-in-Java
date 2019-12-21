package uz.seteam.sqlite.controller;

import uz.seteam.sqlite.entity.Drag;
import uz.seteam.sqlite.entity.Payment;
import uz.seteam.sqlite.repostroy.PaymentRepository;

import java.util.Scanner;

public class PaymentController extends PaymentRepository {

    private Scanner scanner = new Scanner(System.in);
    public  void isWorkingDrag(){
        boolean stop = true;
        while (stop){
            System.out.println("<<   Payment blog    >>");
            System.out.println("==================== ");
            System.out.println("==================== " );
            System.out.println("1- All payment list");
            System.out.println("2- Create payment");
            System.out.println("3- Update");
            System.out.println("4- Delete");
            System.out.println("5- Get payment by id");
            System.out.println("6- Back to home ");
            switch (scanner.nextInt()){
                case 1:
                    System.out.println(getAllPayments());
                    break;
                case 2:
                    madePayment();
                    break;
                case 3:
                    update();
                    break;
                case 4:
                    remove();
                    break;
                case 5:
                    readOnePayment();
                    break;
                case 6:
                    stop = false;
                    break;
            }
        }

    }

    private void readOnePayment() {
        System.out.println("   Read one payment  ");
        System.out.println("=====================");
        System.out.println(getAllPayments());
        System.out.println("Input id which you see");
        Long id = scanner.nextLong();
        System.out.println(getPaymentById(id));
    }

    private void remove() {
        System.out.println("<<   Remove payment by id   >>");
        System.out.println("===========================");
        System.out.println("===========================");
        System.out.println(" Input id which you remove ");
        Long idForRemoveDrug = scanner.nextLong();
        removePayment(idForRemoveDrug);

    }

    private void update() {
        System.out.println("  Update payment ");
        System.out.println("===============");
        System.out.println("===============");
        System.out.println(getAllPayments());
        System.out.println("Type id payment");
        Long paymentId = scanner.nextLong();
        System.out.println(getPaymentById(paymentId));
        System.out.println("Input payment cost");
        Integer cost = scanner.nextInt();
        System.out.println("Input payment date");
        String date = scanner.next();
        Payment payment = new Payment(cost,date);
        payment.setId(paymentId);
        updatePaymet(payment);
    }

    private void madePayment() {
        System.out.println("<<   Create payment  >>");
        System.out.println("=====================");
        System.out.println("=====================");
        System.out.println("Input payment cost");
        Integer cost = scanner.nextInt();
        System.out.println("Input payment date");
        String date = scanner.next();
        Payment newPayment = new Payment(cost,date);
        createPayment(newPayment);

    }
}

