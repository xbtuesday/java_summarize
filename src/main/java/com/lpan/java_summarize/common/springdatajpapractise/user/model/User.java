package com.lpan.java_summarize.common.springdatajpapractise.user.model;

import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * ClassName: User
 * Description: TODO
 * Author: lpan
 * Date 27/05/19 下午 05:53
 * Version: 1.0
 */
@Data
@Entity
@Table(name="user")
@ToString
public class User {
    @Id
    @GeneratedValue
    private Integer id;
    @Column
    private String name;
    @Column
    private Integer age;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column
    private LocalDateTime birthday;
    @Column
    private String address;

}
