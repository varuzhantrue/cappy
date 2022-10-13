package com.capstone.cappy.models;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

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

    @Column(name = "user_id", unique = false)
    private long user;

    @Column(name = "product_id")
    private long product;

    @Column(name = "download_date")
    private Date downloadDate;

    public History(long user_id,
                   long product_id,
                   Date downloadDate) {
        this.user = user_id;
        this.product = product_id;
        this.downloadDate = downloadDate;
    }
}
