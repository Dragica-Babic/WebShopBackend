package etf.webshop.model.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable=false)
    private int id;
    @Column(name="email", nullable=false)
    private String email;
    @Column(name="city", nullable=false)
    private String city;
    @Column(name="avatar", nullable=true)
    private String avatar;
    @Column(name="is_active", nullable = false, columnDefinition = "default bit 1")
    private boolean isActive;
    @Column(name="is_activated", nullable = false, columnDefinition = "default bit 0")
    private boolean isActivated;
    @OneToOne
    @JoinColumn(name="account_id", referencedColumnName = "id")
    private Account account;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public Account getAccount() {
        return account;
    }
    public void setAccount(Account account) {
        this.account = account;
    }
    public String getAvatar() {
        return avatar;
    }
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
    public boolean isActive() {
        return isActive;
    }
    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }
    public boolean isActivated() {
        return isActivated;
    }
    public void setActivated(boolean isActivated) {
        this.isActivated = isActivated;
    }

}