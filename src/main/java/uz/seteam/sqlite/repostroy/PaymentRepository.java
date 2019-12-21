package uz.seteam.sqlite.repostroy;

import org.hibernate.Session;
import uz.seteam.sqlite.entity.Payment;
import uz.seteam.sqlite.utils.HibernateUtils;

import java.util.List;

public class PaymentRepository {

    public List<Payment> getAllPayments(){
        Session session = null;
        List<Payment> payments = null;
        try{
            session = HibernateUtils.openSession();
            payments = session.createQuery("SELECT p FROM Payment p").getResultList();

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(session != null &&  session.isOpen()){
                session.close();
            }
        }
        return payments;
    }

    public void createPayment(Payment payment){
        Session session = null;
        try{
            session = HibernateUtils.openSession();
            session.getTransaction().begin();
            session.save(payment);
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(session != null && session.isOpen()){
                session.close();
            }
        }
    }

    public void updatePaymet(Payment payment){
        Session session = null;
        try{
            session = HibernateUtils.openSession();
            session.getTransaction().begin();
            session.merge(payment);
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(session != null && session.isOpen()){
                session.close();
            }
        }

    }

    public void removePayment(Long id){
        Session session = null;
        try{
            session = HibernateUtils.openSession();
            Payment payment = session.find(Payment.class, id);
            session.getTransaction().begin();
            session.remove(payment);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(session != null && session.isOpen()){
                session.close();
            }
        }
    }

    public Payment getPaymentById(Long id){
        Session session = null;
        Payment payment = null;
        try{
            session = HibernateUtils.openSession();
            try{
                payment = session.find(Payment.class , id);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(session != null && session.isOpen()){
                session.close();
            }
        }
        return payment;
    }
}
