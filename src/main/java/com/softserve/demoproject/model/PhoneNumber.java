package com.softserve.demoproject.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id", "phoneNumber"})
public class PhoneNumber {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private String phoneNumber;
    @ManyToOne(cascade= {CascadeType.MERGE})
    @JoinColumn(name="user_account")
    @JsonBackReference
    private UserAccount ownedBy;
}