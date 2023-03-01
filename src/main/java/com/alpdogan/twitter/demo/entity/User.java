package com.alpdogan.twitter.demo.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(	name = "users" /* ,
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "user_name"),
                @UniqueConstraint(columnNames = "email")
                }*/
        )
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "id")
    private int id;

    //@NotNull
    @Column(name = "first_name")
    private String firstName;

    //@NotNull
    @Column(name = "last_name")
    private String lastName;

    //@NotNull
    @Column(name = "email", unique = true)
    private String email;

    //@NotNull
    @Column(name = "user_name", unique = true, length = 30)
    private String username;

    //@NotNull
    @Column(name = "password", length = 120)
    private String password;

    @Column(name = "bio")
    private String bio;

    @OneToMany(fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.DETACH,
            CascadeType.REFRESH
    })
    private List<Tweet> tweets = new ArrayList<>();

}
