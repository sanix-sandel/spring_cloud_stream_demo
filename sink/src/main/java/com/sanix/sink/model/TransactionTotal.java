package com.sanix.sink.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionTotal {
    private int count;
    private int productCount;
    private long amount;
}
