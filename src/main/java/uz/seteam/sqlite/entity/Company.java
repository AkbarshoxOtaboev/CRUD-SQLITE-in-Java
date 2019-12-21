package uz.seteam.sqlite.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "companies")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Integer balans;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "companyId")
    private List<Drag> dragList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "companyId")
    private List<Payment> paymentList;

    public Company() {
    }

    public Company(String name, Integer balans) {
        this.name = name;
        this.balans = balans;
    }

    public List<Payment> getPaymentList() {
        return paymentList;
    }

    public void setPaymentList(List<Payment> paymentList) {
        this.paymentList = paymentList;
    }

    public List<Drag> getDragList() {
        return dragList;
    }

    public void setDragList(List<Drag> dragList) {
        this.dragList = dragList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBalans() {
        return balans;
    }

    public void setBalans(Integer balans) {
        this.balans = balans;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", balans=" + balans +
                '}';
    }
}
