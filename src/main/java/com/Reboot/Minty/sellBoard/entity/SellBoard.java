package com.Reboot.Minty.sellBoard.entity;



import com.Reboot.Minty.categories.entity.SubCategory;
import com.Reboot.Minty.categories.entity.TopCategory;
import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import java.sql.Timestamp;

@Entity
@Table(name = "sellboard")
@Getter
@DynamicInsert
public class SellBoard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int price;
    private String title;
    private String content;

    @Column(name= "created_date", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp created_date;
    private int interesting;
    @Column(name="chat_count",columnDefinition = "INT DEFAULT 0")
    private int chat_count;
    @Column(columnDefinition = "INT DEFAULT 0")
    private int visit_count;

    @ManyToOne
    @JoinColumn(name= "top_category_id")
    private TopCategory topCategory;

    @ManyToOne
    @JoinColumn(name = "sub_category_id")
    private SubCategory subCategory;


}
