package com.mathewzvk.mongodbstarter.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;


@Document("expense")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Data
public class Expense {

    @Id
    private String id;

    @Field(name = "name")
    @Indexed(unique = true)
    private String expenseName;

    @Field(name = "category")
    private ExpenseCategory expenseCategory;

    @Field(name = "amount")
    private BigDecimal expenseAmount;
}
