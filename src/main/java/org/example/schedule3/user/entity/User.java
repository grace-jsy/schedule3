package org.example.schedule3.user.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.schedule3.BaseEntity;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "users")
// 테이블의 이름은 users
// 이걸 쓰지 않으면 클래스 이름으로 만들어진다.
public class User extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String username;

    @Column(nullable = false, length = 50, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
}
