package model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50)
    private String name;
    private Date date;
    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private Set<Trip> tripes;

    public Company(String name, Date date) {
        this.name = name;
        this.date = date;
    }

    public Company() {

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", date=" + date +
                '}';
    }
}