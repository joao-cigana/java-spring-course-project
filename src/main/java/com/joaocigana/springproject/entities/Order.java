package com.joaocigana.springproject.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity (name = "order_table")
public class Order implements Serializable {
    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long Id;
    private Instant moment;

    @ManyToOne
    @JoinColumn (name = "client_id")
    private User client;

    public Order(){

    }

    public Order(Long id, Instant moment, User client) {
        Id = id;
        this.moment = moment;
        this.client = client;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Id.equals(order.Id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id);
    }
}
