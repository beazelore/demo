package com.example.demoproject.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id", "phone"})
public class PhoneNumber {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    @NotNull
    private String phone;
    @ManyToOne(cascade= {CascadeType.MERGE})
    @JoinColumn(name="user_account")
    @JsonBackReference
    private UserAccount ownedBy;
}
