package etf.webshop.model.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="item_attributes")
public class ItemAttribute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable=false)
    private int id;
    @Column(name="Item_id", nullable=false)
    private int itemId;
    @ManyToOne
    @JoinColumn(name="Attribute_id")
    private Attribute attribute;
    @Column(name="value", nullable=false)
    private String value;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getItemId() {
        return itemId;
    }
    public void setItemId(int itemId) {
        this.itemId = itemId;
    }
    public Attribute getAttribute() {
        return attribute;
    }
    public void setAttributeId(Attribute attribute) {
        this.attribute = attribute;
    }
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }

}
