package org.example.schedule3.comment.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.schedule3.BaseEntity;
import org.example.schedule3.schedule.entity.Schedule;
import org.example.schedule3.user.entity.User;

@Entity
@Getter
@NoArgsConstructor
public class Comment extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    // @Id : 해당 필드를 엔티티의 기본 키(PK)로 지정한다.
    // @GeneratedValud : 기본 키 값을 자동 생성하는 전략을 설정.
    //                   IDENTITY 전략은 DB의 AUTO_INCREMENT 기능을 사용한다.
    //                   개발자가 id 값을 따로 지정하지 않아도 DB가 자동으로 1씩 증가된 값을 넣어준다.
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)  // FK 매핑 (N:1) 여러개의 댓글을 한명의 유저가 쓸 수 있다
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne // FK 매핑 (N:1) 여러개의 댓글을 하나의 일정에 쓸 수 있다.
    @JoinColumn(name = "schedule_id", nullable = false)
    private Schedule schedule;

    @Column(nullable = false, length = 100)
    private String contents;

    public Comment(User user, Schedule schedule, String contents) {
        this.user = user;
        this.schedule = schedule;
        this.contents = contents;
    }
}
