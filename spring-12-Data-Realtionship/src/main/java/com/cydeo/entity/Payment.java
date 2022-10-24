package com.cydeo.entity;

import com.cydeo.enums.Status;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Data
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // help us to create ID
    private Long id;
    @Column(columnDefinition = "DATE")
    private LocalDate createdDate;

    private BigDecimal amount;
    @Enumerated(EnumType.STRING)
    private Status paymentStatus;

    // spring boot is going to create two table b/w this classes but what kind of relationship?
    // in this table one foreign key is already created
   // @OneToOne(cascade = CascadeType.ALL) //
    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE}) //
    @JoinColumn(name = "payment_details_id")
    private PaymentDetail paymentDetail;

    public Payment(LocalDate createdDate, BigDecimal amount, Status paymentStatus) {
        this.createdDate = createdDate;
        this.amount = amount;
        this.paymentStatus = paymentStatus;
    }
}
