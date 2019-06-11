package com.softserve.demoproject.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id","fullName", "dateOfBirth"})
public class UserAccount {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private String fullName;
    private LocalDate dateOfBirth;
    private String gender;
    @OneToMany(mappedBy = "ownedBy", cascade = CascadeType.PERSIST)
    @JsonManagedReference
    private Set<PhoneNumber> phones;
    @OneToMany(mappedBy = "user")
    private Set<Call> calls;
}
