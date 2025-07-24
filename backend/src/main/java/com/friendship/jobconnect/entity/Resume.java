package com.friendship.jobconnect.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "resume")
public class Resume {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rno;

    @Column
    private String school;

    @Column
    private String major;

    @Column(name = "graduation_date")
    private String graduationDate;

    @Column(name = "enter_date")
    private String enterDate;

    @ManyToOne
    @JoinColumn(name = "users_id", referencedColumnName = "id")
    private Users usersId;

    @OneToMany(mappedBy = "rno", cascade = CascadeType.ALL)
    private List<Career> careers;
}
