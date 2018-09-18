package com.n26.pojo;

import static java.util.stream.Collectors.toList;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.Collection;
import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Statistics {

    private String sum;

    private String avg;

    private String max;

    private String min;

    private Long count;

    public Statistics(Collection<Transaction> transactions) {
        final List<BigDecimal> amountsLastMinute = transactions.stream().map(Transaction::getAmount).collect(toList());
        final Long count = amountsLastMinute.stream().count();
        this.setCount(count);
        if (count > 0) {
        	BigDecimal sum = amountsLastMinute.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
            this.setSum(sum.setScale(2, BigDecimal.ROUND_HALF_UP).toString());
            BigDecimal avg = sum.divide(BigDecimal.valueOf(amountsLastMinute.size()), 2, BigDecimal.ROUND_HALF_UP);
            this.setAvg(avg.setScale(2, BigDecimal.ROUND_HALF_UP).toString());
            this.setMax(amountsLastMinute.stream().max(Comparator.naturalOrder()).orElse(BigDecimal.ZERO).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
            this.setMin(amountsLastMinute.stream().min(Comparator.naturalOrder()).orElse(BigDecimal.ZERO).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
        }else {
        	 this.setSum(BigDecimal.ZERO.setScale(2, BigDecimal.ROUND_HALF_UP).toString());
        	 this.setAvg(BigDecimal.ZERO.setScale(2, BigDecimal.ROUND_HALF_UP).toString());
        	 this.setMax(BigDecimal.ZERO.setScale(2, BigDecimal.ROUND_HALF_UP).toString());
        	 this.setMin(BigDecimal.ZERO.setScale(2, BigDecimal.ROUND_HALF_UP).toString());
        }
    }
}