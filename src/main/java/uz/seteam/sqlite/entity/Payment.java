package uz.seteam.sqlite.entity;

import javax.persistence.*;

@Entity
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer costVolue;
    private String date;
    private Long companyId;

    public Payment() {
    }

    public Payment(Integer costVolue, String date) {
        this.costVolue = costVolue;
        this.date = date;
    }

    public Payment(Integer costVolue, String date, Long companyId) {
        this.costVolue = costVolue;
        this.date = date;
        this.companyId = companyId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCostVolue() {
        return costVolue;
    }

    public void setCostVolue(Integer costVolue) {
        this.costVolue = costVolue;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }
}
