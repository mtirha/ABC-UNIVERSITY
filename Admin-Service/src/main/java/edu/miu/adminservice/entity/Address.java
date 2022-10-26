package edu.miu.adminservice.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Column(name="street")
    private String street;
    @Column(name="zip")
    private String zip;
    @Column(name="city")
    private String city;
    @Column(name="state")
    private String state;
}
