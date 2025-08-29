package org.example.schedule3;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass
/*
이 클래스는 테이블로 만들지 않고, 자식 엔티티가 상속받을 때 필드만 컬럼으로 매핑
즉, BaseEntity는 직접 DB 테이블을 만들지 않는다.
대신 자식 엔티티(title, contents등)가 상속받으면 그 필드들이 그 엔티티 테이블에 포함됨
 */
@EntityListeners(AuditingEntityListener.class)
/*
Auditing = entity의 생성일, 수정일을 자동으로 기록해주는 기능
이 기능을 쓰려면 @EnableJpaAuditing 어노테이션을 Application에 써줘야 함
 */
public abstract class BaseEntity {

    @CreatedDate // 데이터가 처음 저장될 때 자동으로 값을 넣어준다.
    @Column(updatable = false) // DB에서 업데이트가 불가능하게 설정한다. (생성일은 수정 불가하기 때문에)
    @Temporal(TemporalType.TIMESTAMP) // JPA에서 data타입을 DB의 어떤 시간 타입으로 매핑할지 지정하는 어노테이션
    private LocalDateTime createdAt;

    @LastModifiedDate // 데이터가 수정될 때 자동으로 값을 갱신해준다.
    @Temporal(TemporalType.TIMESTAMP) // JPA에서 data타입을 DB의 어떤 시간 타입으로 매핑할지 지정하는 어노테이션
    private LocalDateTime modifiedAt;
}
