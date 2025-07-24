package com.friendship.jobconnect.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.catalina.User;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "board")
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bno;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @CreationTimestamp
    @Column(name = "create_date", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp createDate;

    @UpdateTimestamp
    @Column(name = "update_date", columnDefinition = "TIMESTAMP")
    private Timestamp updateDate;

    @Column(name = "delete_date", columnDefinition = "TIMESTAMP")
    private Timestamp deleteDate;

    @Column(name = "board_type", columnDefinition = "INT DEFAULT 0")
    private Integer boardType;
    // 0:일반글, 99:삭제글

    @ManyToOne
    @JoinColumn(name = "author", referencedColumnName = "id")
    private Users author;

    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL)
    private List<Reply> replies;
}
