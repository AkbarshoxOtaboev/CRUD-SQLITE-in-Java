package uz.seteam.sqlite.entity;

import javax.persistence.*;

@Entity
@Table(name = "drags")
public class Drag {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Integer cost;
    private Integer count;
    private String date;
    private Integer generalCost;

    public Drag() {
    }

    public Drag(String name, Integer cost, Integer count, String date, Integer generalCost) {
        this.name = name;
        this.cost = cost;
        this.count = count;
        this.date = date;
        this.generalCost = generalCost;
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

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getGeneralCost() {
        return generalCost;
    }

    public void setGeneralCost(Integer generalCost) {
        this.generalCost = generalCost;
    }

    @Override
    public String toString() {
        return "Drag{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", count=" + count +
                ", date='" + date + '\'' +
                ", generalCost=" + generalCost +
                '}';
    }
}
