package com.friendship.jobconnect.user.entity;

import com.friendship.jobconnect.board.entity.Board;
import com.friendship.jobconnect.reply.entity.Reply;
import com.friendship.jobconnect.resume.entity.Resume;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(name = "user_id", unique = true, nullable = false)
    private String userId;

    @Column(nullable = false)
    private String pw;

    @Column(nullable = false, unique = true)
    private String nick;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String birth;

    @Column(nullable = false)
    private String gender;

    @Column(nullable = false, unique = true)
    private String number;

    @CreationTimestamp
    @Column(name = "create_date", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp createDate;

    @UpdateTimestamp
    @Column(name = "update_date", columnDefinition = "TIMESTAMP")
    private Timestamp updateDate;

    @Column(name = "delete_date", columnDefinition = "TIMESTAMP")
    private Timestamp deleteDate;

    @Column(name = "user_type", columnDefinition = "INT DEFAULT 1")
    private Integer userType;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Board> boards;

    @OneToMany(mappedBy = "uuid", cascade = CascadeType.ALL)
    private List<Resume> resumes;

    @OneToMany(mappedBy = "rauthor", cascade = CascadeType.ALL)
    private List<Reply> replies;
}
