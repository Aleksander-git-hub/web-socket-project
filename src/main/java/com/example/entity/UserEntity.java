package com.example.entity;

import com.example.entity.enums.Status;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@Builder
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String login;

    @Column
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column
    private String email;

    @Column
    private Date birthday;

    // ??? have to think about references
    // to do not forget about 10-crate-friends-table.sql
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "friends",
        joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
        inverseJoinColumns = {@JoinColumn(name = "friend_id", referencedColumnName = "id")})
    private Set<UserEntity> friends;

    @Column
    @CreatedDate
    private Date created;

    @Column
    @LastModifiedDate
    private Date update;

    @Column
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "activation_code")
    private String activationCode;
}
