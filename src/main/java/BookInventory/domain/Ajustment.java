package BookInventory.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by student on 2015/04/25.
 */
@Entity
public class Ajustment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)//makes the code unique
    private String code;
    private String itemName;
    private Date ajustmentDate;
    private int amount;
    @OneToMany
    @JoinColumn(name = "ajustment_id")
    private List<Employee> employeeList;


    private Ajustment(){
    }

    public Ajustment(Builder builder){
        this.id=builder.id;
        this.code=builder.code;
        this.itemName=builder.itemName;
        this.ajustmentDate=builder.ajustmentDate;
        this.amount=builder.amount;
        this.employeeList=builder.employeeList;
    }

    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getItemName() {
        return itemName;
    }

    public Date getAjustmentDate() {
        return ajustmentDate;
    }

    public int getAmount() {
        return amount;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public static class Builder{
        private Long id;
        private String code;
        private String itemName;
        private Date ajustmentDate;
        private int amount;
        private List<Employee> employeeList;

        public Builder(String code){
            this.code=code;
        }

        public Builder itemName(String value){
            this.itemName = value;
            return this;
        }

        public Builder ajustmentDate(Date value){
            this.ajustmentDate = value;
            return this;
        }

        public Builder amount(int value){
            this.amount = value;
            return this;
        }

        public Builder employeeList(List<Employee> value){
            this.employeeList=value;
            return this;
        }

        public Builder copy(Ajustment value){
            this.code = value.getCode();
            this.itemName = value.getItemName();
            this.ajustmentDate = value.getAjustmentDate();
            this.amount = value.getAmount();
            this.employeeList=value.getEmployeeList();
            return this;
        }

        public Ajustment build(){
            return new Ajustment(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ajustment ajustment = (Ajustment) o;

        if (id != null ? !id.equals(ajustment.id) : ajustment.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Ajustment{" +
                "Id=" + id +
                ", code='" + code + '\'' +
                '}';
    }
}
