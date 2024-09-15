package com.example.ms.credit.manager.dao.entity;

import com.example.ms.credit.manager.model.enums.CreditStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import static jakarta.persistence.CascadeType.MERGE;
import static jakarta.persistence.CascadeType.PERSIST;
import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Table(name = "credits")
public class CreditEntity {
    @GeneratedValue(strategy = IDENTITY)
    @Id
    private Long id;

    private Integer term;

    private BigDecimal interest;

    private BigDecimal monthlyPayment;

    private BigDecimal amount;

    private Long conveyorId;

    private BigDecimal requestedAmount;

    @UpdateTimestamp
    private LocalDateTime checkDate;

    @Enumerated(STRING)
    private CreditStatus status;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @ManyToOne(fetch = LAZY, cascade = {MERGE, PERSIST})
    private CustomerEntity customer;

    @OneToMany(mappedBy = "credit", cascade = {MERGE, PERSIST})
    private List<OfferEntity> offers;

    @OneToMany(mappedBy = "credit", cascade = {MERGE, PERSIST})
    private List<StatusHistoriesEntity> statusHistories;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreditEntity that = (CreditEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
