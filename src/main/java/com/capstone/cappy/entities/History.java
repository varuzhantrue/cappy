package com.capstone.cappy.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "history")
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "user_id")
    private long user;

    @Column(name = "product_id")
    private long product;

    @Column(name = "download_date")
//    private Date downloadDate;
//    private SimpleDateFormat downloadDate;
    private LocalDate downloadDate;
//    private Calendar downloadDate;

    @Column
    private String productName;

    public History(long user_id,
                   long product_id,
//                   Date downloadDate,
//                   SimpleDateFormat downloadDate,
                   LocalDate downloadDate,
                   String productName) {

        this.user = user_id;
        this.product = product_id;
        this.downloadDate = downloadDate;
        this.productName = productName;
    }

}
