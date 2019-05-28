package com.lpan.java_summarize.common.springdatajpapractise.user.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * ClassName: Role
 * Description: TODO
 * Author: lpan
 * Date 28/05/19 下午 02:44
 * Version: 1.0
 */
@Entity
@Data
@Table(name = "role")
public class Role {

    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    private String id;
    @Column(name = "role_name" , unique = true , nullable = false , length = 24)
    private String roleName;
    @Column(name="status" , unique = true , nullable = false , length = 2)
    private Integer status;
    @Column(name = "create_time")
    private LocalDate createTime;
    @Column(name = "type" , unique = true,nullable = false , length = 2)
    private String type;
}
