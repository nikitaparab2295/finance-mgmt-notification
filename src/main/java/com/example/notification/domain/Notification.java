package com.example.notification.domain;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "notifications")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ownerId;
    private String category;
    private String level; // WARNING / ALERT
    private BigDecimal budgetAmount;
    private BigDecimal expenseAmount;
    private String expenseDescription;
    private BigDecimal totalSpent;
    private BigDecimal remaining;
    private boolean readFlag;
    private Instant createdAt;
}
