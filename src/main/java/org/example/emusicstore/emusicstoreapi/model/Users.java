package org.example.emusicstore.emusicstoreapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * User Model
 * User ID - long, auto-generated
 * Username, Password - Strings, fields
 * Enabled - Boolean, to mark the user either as active or disabled
 * Customer ID - one-to-one relationship, links a user to a customer entry
 */

@Entity
public class Users {

    @Id
    @GeneratedValue
    private long userId;
    private String username;
    private String password;
    private boolean enabled;
    private long customerId;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }
}
