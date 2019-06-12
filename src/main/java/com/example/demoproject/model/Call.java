package com.example.demoproject.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "CallLogs")
@EqualsAndHashCode(of = {"id", "callTime", "callerPhoneNumber"})
public class Call {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name="client_id", nullable = false)
    @JsonBackReference
    private UserAccount user;
    @NotNull
    private String callerPhoneNumber;
    @NotNull
    private String recipientPhoneNumber;
    private LocalDateTime callTime;
    private int duration;
    private String city;
}
