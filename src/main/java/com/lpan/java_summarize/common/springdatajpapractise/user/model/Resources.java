package com.lpan.java_summarize.common.springdatajpapractise.user.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * ClassName: Resources
 * Description: TODO
 * Author: lpan
 * Date 28/05/19 下午 04:02
 * Version: 1.0
 */
@Entity
@Data
@Table(name = "resources")
public class Resources {
   @Id
   @GeneratedValue
   private Integer id;
    @Column(name="name" , unique = true , nullable = true , length = 64)
   private String name;
   @Column(name="url" , unique = true , nullable = true , length = 64)
   private String url;
   @Column(name="type" , unique = false , nullable = true , length = 2)
   private String type;
   @Column(name="level" , unique = false , nullable = true , length = 2)
   private String level;
   @Column(name="path" , unique = false , nullable = true , length = 64)
   private String path;
   @Column(name="parent_id" , unique = false , nullable = true , length = 11)
   private Integer parentId;
   @Column(name="create_time" , unique = false , nullable = true)
   private LocalDate createTime;
   @Column(name="update_time" , unique = false , nullable = true)
   private LocalDate updateTime;
   @Column(name="status" , unique = false , nullable = true , length = 2)
   private String status;
   @Column(name="permission_code" , unique = false , nullable = true , length = 64)
   private String permissionCode;
   @Column(name="memo" , unique = false , nullable = true , length = 128)
   private String memo;
}
