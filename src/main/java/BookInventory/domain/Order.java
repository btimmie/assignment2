package BookInventory.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by student on 2015/04/25.
 */
@Entity
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)//makes the code unique
    private String code;
    private int quantity;
    private Date datePlaced;
    private String description;
    @Embedded
    private InventoryItem inventoryItem;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="order_id")
    private List<InventoryItem> inventoryItemList;

    private Order(){
    }

    public Order(Builder builder){
        this.inventoryItem=builder.inventoryItem;
        this.id=builder.id;
        this.code=builder.code;
        this.quantity=builder.quantity;
        this.datePlaced=builder.datePlaced;
        this.description=builder.description;
        this.inventoryItemList=builder.inventoryItemList;
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

    public Date getDatePlaced() {
        return datePlaced;
    }

    public String getDescription() {
        return description;
    }

    public List<InventoryItem> getInventoryItemList() {
        return inventoryItemList;
    }

    public static class Builder{
        private Long id;
        private String code;
        private int quantity;
        private Date datePlaced;
        private String description;
        private InventoryItem inventoryItem;
        private List<InventoryItem> inventoryItemList;


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

        public Builder inventoryItem(InventoryItem value){
            this.inventoryItem=value;
            return this;
        }

        public Builder datePlaced(Date value) {
            this.datePlaced=value;
            return this;
        }

        public Builder description(String value){
            this.description=value;
            return this;
        }

        public Builder inventoryItem(List<InventoryItem> value){
            this.inventoryItemList=value;
            return this;
        }

        public Builder copy(Order value) {
            this.inventoryItem=value.inventoryItem;
            this.code = value.getCode();
            this.quantity = value.getQuantity();
            this.datePlaced = value.getDatePlaced();
            this.description = value.getDescription();
            this.inventoryItemList = value.getInventoryItemList();
            return this;
        }

        public Order build(){
            return new Order(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (code != null ? !code.equals(order.code) : order.code != null) return false;
        if (id != null ? !id.equals(order.id) : order.id != null) return false;

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
        return "Order{" +
                "id=" + id +
                ", code='" + code + '\'' +
                '}';
    }
}
