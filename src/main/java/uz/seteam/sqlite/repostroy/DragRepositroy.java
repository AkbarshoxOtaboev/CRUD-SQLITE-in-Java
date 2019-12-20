package uz.seteam.sqlite.repostroy;

import org.hibernate.Session;
import uz.seteam.sqlite.entity.Drag;
import uz.seteam.sqlite.utils.HibernateUtils;

import java.util.ArrayList;
import java.util.List;

public class DragRepositroy {

    public List<Drag> getAllDrags() {
        Session session = null;
        List<Drag> drags = new ArrayList<Drag>();
        try {
            session = HibernateUtils.openSession();
            drags = session.createQuery("SELECT s FROM Drag s").getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return drags;
    }

    public void createDrug(Drag drag) {
        Session session = null;
        try {
            session = HibernateUtils.openSession();
            session.getTransaction().begin();
            session.save(drag);
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void ubdate(Drag drag) {
        Session session = null;
        try {
            session = HibernateUtils.openSession();
            session.getTransaction().begin();
            session.merge(drag);
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void delete(Long id) {
        Session session = null;
        try {
            session = HibernateUtils.openSession();
            Drag deleteToDrug = session.find(Drag.class, id);
            session.getTransaction().begin();
            session.remove(deleteToDrug);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public Drag getDragById(Long id){
        Session session =null;
        Drag idToDrag = null;
        try{
            session = HibernateUtils.openSession();
            try{
                idToDrag = session.find(Drag.class, id);
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
        return idToDrag;
    }

}
