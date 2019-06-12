package com.example.demoproject.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
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
    @NotNull
    private String fullName;
    private LocalDate dateOfBirth;
    @Pattern(regexp = "[0129]", message = "0 = not known, 1 = male, 2 = female, 9 = not applicable")
    @Column(columnDefinition = "CHAR(1)")
    private String gender;
    @OneToMany(mappedBy = "ownedBy", cascade = CascadeType.PERSIST)
    @JsonManagedReference
    private Set<PhoneNumber> phones;
    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private Set<Call> calls;
}
