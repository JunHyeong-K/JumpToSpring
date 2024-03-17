package com.example.jumpToSpring.question.domain;

import com.example.jumpToSpring.answer.domain.Answer;
import com.example.jumpToSpring.user.domain.SiteUser;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Getter @Setter
public class Question {
    @ManyToOne(fetch = FetchType.LAZY)
    private SiteUser author;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 200)
    private String subject;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime createDate;

    @OneToMany(mappedBy = "question",cascade = CascadeType.REMOVE)
    private List<Answer> answerList;

    private LocalDateTime modifyDate;

    @ManyToMany
    Set<SiteUser> voter;
}
