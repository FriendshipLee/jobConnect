package com.friendship.jobconnect.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "company")
public class Company {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "company_id", columnDefinition = "BINARY(16)")
    private UUID companyId;

    @Column(name = "company_number", nullable = false, unique = true)
    private String companyNumber;

    @Column(nullable = false)
    private String pw;

    @Column(name = "company_number", nullable = false)
    private String companyName;

    @Column(name = "ceo_name", nullable = false)
    private String ceoName;

    @Column(nullable = false, unique = true)
    private String number;

    @CreationTimestamp
    @Column(name = "create_date", updatable = false, nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp createDate;

    @UpdateTimestamp
    @Column(name = "update_date", columnDefinition = "TIMESTAMP")
    private Timestamp updateDate;

    @Column(name = "delete_date", columnDefinition = "TIMESTAMP")
    private Timestamp deleteDate;

    @Column(name = "company_type", nullable = false, columnDefinition = "INT DEFAULT 0")
    private Integer companyType;
    // 0:일반회사 , 99:탈퇴회사
}
