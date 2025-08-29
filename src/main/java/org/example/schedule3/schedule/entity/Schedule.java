package org.example.schedule3.schedule.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.schedule3.BaseEntity;
import org.example.schedule3.user.entity.User;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "schedules")
public class Schedule extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // FK 매핑 (N:1) 여러개의 스케줄을 한명의 유저가 쓸 수 있다.
    // username 또한 User 엔티티에서 가져오기 때문에 쓰지 않는다.
    // 연관된 객체를 사용할 때까지 로딩을 미룬다.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false, length = 500)
    private String contents;

    public Schedule(User user, String title, String contents) {
        this.user = user;
        this.title = title;
        this.contents = contents;
    }
}
