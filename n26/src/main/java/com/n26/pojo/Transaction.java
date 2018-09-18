package com.n26.pojo;

import static com.n26.service.TransactionService.TIME_LIMIT;

import java.math.BigDecimal;
import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.n26.validation.Past;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Transaction {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private BigDecimal amount;

    @NotNull
    @DateTimeFormat(pattern="yyyy-MM-dd'T'hh:mm:ss.SSSZ")
    @Past
    private Instant timestamp;

    @JsonIgnore
    public boolean isNewerThanTimeLimit() {
        return Instant.now().toEpochMilli() - timestamp.toEpochMilli() <= TIME_LIMIT;
    }
	
}