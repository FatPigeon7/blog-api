package com.fatpigeon.blog.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@Entity
@Table(name = "user")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;

    /**
     * Username.
     */
    @NotEmpty(message = "用户名不能为空")
    private String username;

    /**
     * Password.
     */
    private String password;

    /**
     * Salt for encoding.
     */
    private String salt;

    /**
     * Real name.
     */
    private String name;

    /**
     * Phone number.
     */
    private String phone;

    /**
     * Email address.
     *
     * A Email address can be null,but should be correct if exists.
     */
    @Email(message = "请输入正确的邮箱")
    private String email;

    /**
     * User status.
     */
    private boolean enabled;

    /**
     * Transient property for storing role owned by current user.
     */
    @Transient
    private List<AdminRole> roles;

}
