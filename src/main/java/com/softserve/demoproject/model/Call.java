package com.softserve.demoproject.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@Table(name = "CallLogs")
@EqualsAndHashCode(of = {"id", "callTime", "callerPhoneNumber"})
public class Call {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name="client_id", nullable = false)
    private UserAccount user;
    private String callerPhoneNumber;
    private String recipientPhoneNumber;
    private LocalDateTime callTime;
    private int duration;
    private String city;
}
