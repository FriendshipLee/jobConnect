package com.friendship.jobconnect.gonggo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "gonggo")
public class Gonggo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer gno;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false, columnDefinition = "INT DEFAULT 0")
    private Integer career;
    // 0:무관, 1:신입, 2:경력

    @Column(nullable = false, columnDefinition = "INT DEFAULT 0")
    private Integer education;
    // 0:무관, 1:초대졸, 2:대졸, 3:석사, 4:박사

    @Column(nullable = false)
    private String address;

    @Column
    private String deadline;

    @Column(columnDefinition = "TEXT")
    private String link;

    @CreationTimestamp
    @Column(name = "create_date", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp createDate;

    @UpdateTimestamp
    @Column(name = "update_date", columnDefinition = "TIMESTAMP")
    private Timestamp updateDate;

    @Column(name = "delete_date", columnDefinition = "TIMESTAMP")
    private Timestamp deleteDate;

    @Column(name = "gonggo_type", nullable = false, columnDefinition = "INT DEFAULT 1")
    private Integer gonggoType;
    // 1:일반공고, 99:삭제공고

}
