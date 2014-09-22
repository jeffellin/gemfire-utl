package com.ellin.gemfire.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created with IntelliJ IDEA.
 * User: jellin
 * Date: 7/5/14
 * Time: 11:08 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name="Customer")
public class Customer {

    private String id;
    private String firstName;
    private String lastName;

    @Id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
