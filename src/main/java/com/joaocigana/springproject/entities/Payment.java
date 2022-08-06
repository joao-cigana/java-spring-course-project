package com.joaocigana.springproject.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Table (name = "payment_table")
public class Payment implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Instant moment;

    @OneToOne
    @MapsId
    @JsonIgnore
    private Order order;

    public Payment(){}

    public Payment(Long id, Instant moment, Order order) {
        this.id = id;
        this.moment = moment;
        this.order = order;
    }

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public Instant getMoment() {return moment;}

    public void setMoment(Instant moment) {this.moment = moment;}

    public Order getOrder() {return order;}

    public void setOrder(Order order) {this.order = order;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Payment payment = (Payment) o;

        if (id != null ? !id.equals(payment.id) : payment.id != null) return false;
        if (moment != null ? !moment.equals(payment.moment) : payment.moment != null) return false;
        return order != null ? order.equals(payment.order) : payment.order == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (moment != null ? moment.hashCode() : 0);
        result = 31 * result + (order != null ? order.hashCode() : 0);
        return result;
    }
}
