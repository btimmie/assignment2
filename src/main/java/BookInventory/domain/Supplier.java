package BookInventory.domain;


import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;
import java.util.List;

/**
 * Created by student on 2015/04/25.
 */
@Entity
public class Supplier implements Serializable {


    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)//makes the code unique
    private String code;
    private String name;
    private String address;
    private List<InventoryItem> inventoryItemList;

    private Supplier(){
    }

    public Supplier(Builder builder){
        this.id=builder.id;
        this.code=builder.code;
        this.name=builder.name;
        this.address=builder.address;
        this.inventoryItemList=builder.inventoryItemList;
    }

    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public List<InventoryItem> getInventoryItemList() {
        return inventoryItemList;
    }

    public static class Builder{
        private long id;
        private String code;
        private String name;
        private String address;
        private List<InventoryItem> inventoryItemList;

        public Builder(String code){
            this.code=code;
        }

        public Builder id(Long value){
            this.id=value;
            return this;
        }

        public Builder name(String value){
            this.name=value;
            return this;
        }

        public Builder address(String value){
            this.address=value;
            return this;
        }

        public Builder inventoryItemList(List<InventoryItem> value){
            this.inventoryItemList=value;
            return this;
        }

        public Builder copy(Supplier value){
            this.id=value.id;
            this.code=value.code;
            this.name=value.name;
            this.address=value.address;
            this.inventoryItemList=value.inventoryItemList;
            return this;
        }

        public Supplier build(){
            return new Supplier(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Supplier supplier = (Supplier) o;

        if (code != null ? !code.equals(supplier.code) : supplier.code != null) return false;
        if (id != null ? !id.equals(supplier.id) : supplier.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (code != null ? code.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "id=" + id +
                ", code='" + code + '\'' +
                '}';
    }
}
