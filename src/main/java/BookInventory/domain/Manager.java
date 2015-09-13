package BookInventory.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by student on 2015/04/25.
 */
@Entity
public class Manager implements Serializable,Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)//makes the code unique
    private String code;
    private String firstName;
    private String lastName;


    private Manager(){

    }

    public Manager (Builder builder){
        this.id=builder.id;
        this.code=builder.code;
        this.firstName=builder.firstName;
        this.lastName=builder.lastName;
    }

    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String getFirstnName() {
        return firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    public static class Builder{
        private Long id;
        private String code;
        private String firstName;
        private String lastName;


        public Builder(String code){
            this.code=code;
        }

        public Builder id(Long value){
            this.id=value;
            return this;
        }

        public Builder firstName(String value){
            this.firstName=value;
            return this;
        }

        public Builder lastName(String value){
            this.lastName=value;
            return this;
        }

        public Builder copy(Manager value){
            this.code = value.getCode();
            this.id = value.getId();
            this.firstName = value.getFirstnName();
            this.lastName = value.getLastName();
            return this;
        }

        public Manager build(){
            return new Manager(this);
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
                    "id=" + id +
                    ", code='" + code + '\'' +
                    '}';
        }
    }
}
