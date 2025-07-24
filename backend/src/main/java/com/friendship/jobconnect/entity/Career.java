package com.friendship.jobconnect.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "career")
public class Career {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cno;

    @Column
    private String company;

    @Column(name = "career_start_date")
    private String careerStartDate;

    @Column
    private String work;

    @Column(name = "career_end_date")
    private String careerEndDate;

    @ManyToOne
    @JoinColumn(name = "rno")
    private Resume rno;

}
