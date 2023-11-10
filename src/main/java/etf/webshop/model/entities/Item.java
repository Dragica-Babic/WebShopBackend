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
    @Column(name="is_new", nullable=false, columnDefinition = "default bit 1")
    private boolean isUsed;
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
    private User user;
    @Column(name="customer_id", nullable=true)
    private Integer customerId;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public boolean isUsed() {
        return isUsed;
    }
    public void setUsed(boolean isNew) {
        this.isUsed = isNew;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public boolean isDeleted() {
        return isDeleted;
    }
    public void setDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }
    public boolean isActive() {
        return isActive;
    }
    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public Integer getCustomerId() {
        return customerId;
    }
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
}
