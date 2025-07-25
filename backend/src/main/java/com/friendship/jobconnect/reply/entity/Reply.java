package com.friendship.jobconnect.reply.entity;

import com.friendship.jobconnect.board.entity.Board;
import com.friendship.jobconnect.user.entity.Users;
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
@Table(name = "reply")
public class Reply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rno;

    @Column
    private String content;

    @CreationTimestamp
    @Column(name = "create_date", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CRRENT_TIMESTAMP")
    private Timestamp createDate;

    @UpdateTimestamp
    @Column(name = "update_date", columnDefinition = "TIMESTAMP")
    private Timestamp updateDate;

    @Column(name = "delete_date", columnDefinition = "TIMESTAMP")
    private Timestamp deleteDate;

    @Column(name = "reply_date", columnDefinition = "INT DEFAULT 0")
    private Integer reply;
    // 0:일반 댓글, 99:삭제 댓글

    @ManyToOne
    @JoinColumn(name = "bno")
    private Board board;

    @ManyToOne
    @JoinColumn(name = "rauthor", referencedColumnName = "id")
    private Users rauthor;

}
