package BookInventory.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by student on 2015/04/25.
 */
@Entity
public class Consumtion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)//makes the code unique
    private String code;
    private int quantity;
    private Date dateConsumed;

    private Consumtion(){

    }

    public Consumtion(Builder builder){
        this.id=builder.id;
        this.code=builder.code;
        this.quantity=builder.quantity;
        this.dateConsumed=builder.dateConsumed;
    }

    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public int getQuantity() {
        return quantity;
    }

    public Date getDateConsumed() {
        return dateConsumed;
    }

    public static class Builder{
        private Long id;
        private String code;
        private int quantity;
        private Date dateConsumed;

        public Builder(String code){
            this.code=code;
        }

        public Builder id(Long value){
            this.id=value;
            return this;
        }

        public Builder quantity(int value){
            this.quantity=value;
            return this;
        }

        public Builder dateConsuned(Date value){
            this.dateConsumed=value;
            return this;
        }

        public Builder copy(Consumtion value){
            this.code = value.getCode();
            this.id = value.getId();
            this.quantity = value.getQuantity();
            this.dateConsumed = value.getDateConsumed();
            return this;
        }

        public Consumtion build(){
            return new Consumtion(this);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Builder builder = (Builder) o;

            if (id != null ? !id.equals(builder.id) : builder.id != null) return false;

            return true;
        }

        @Override
        public int hashCode() {
            return id != null ? id.hashCode() : 0;
        }

        @Override
        public String toString() {
            return "Builder{" +
                    "code='" + code + '\'' +
                    ", id=" + id +
                    '}';
        }
    }
}
