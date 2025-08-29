package org.example.schedule3.comment.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
// 엔티티 클래스임을 나타낸다.
// 이 클래스는 데이터베이스의 테이블과 매핑된다.
// DB에 저장, 조회, 수정, 삭제할 수 있는 대상이 된다.
@Getter
// 클래스의 모든 필드에 대해 Getter 메서드를 자동으로 생성해준다.
@NoArgsConstructor
// 인자가 없는 기본 생성자를 만들어 준다.
public class Comment {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    // @Id : 해당 필드를 엔티티의 기본 키(PK)로 지정한다.
    // @GeneratedValud : 기본 키 값을 자동 생성하는 전략을 설정.
    //                   IDENTITY 전략은 DB의 AUTO_INCREMENT 기능을 사용한다.
    //                   개발자가 id 값을 따로 지정하지 않아도 DB가 자동으로 1씩 증가된 값을 넣어준다.
    private Long id;

    @Column(nullable = false, length = 100)
    private String contents;

    public Comment(String contents) {
        this.contents = contents;
    }
}
