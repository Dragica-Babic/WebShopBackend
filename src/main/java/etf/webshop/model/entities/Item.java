package etf.webshop.model.entities;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable=false)
    private int id;
    @Column(name="title", nullable=false)
    private String title;
    @Column(name="description", nullable=false)
    private String description;
    @Column(name="price", nullable=false)
    private double price;
    @Column(name="is_used", nullable=false, columnDefinition = "default bit 1")
    private boolean used;
    @Column(name="is_deleted", nullable=false, columnDefinition = "default bit 0")
    private boolean isDeleted;
    @Column(name="is_active", nullable=false, columnDefinition = "default bit 1")
    private boolean isActive;
    @Column(name="location", nullable=false)
    private String location;
    @Column(name="image")
    private String image;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="category_id", referencedColumnName = "id")
    private Category category;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id", referencedColumnName = "id")
    private UserEntity user;
    @Column(name="customer_id", nullable=true)
    private Integer customerId;
}
