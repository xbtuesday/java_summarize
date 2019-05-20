package com.lpan.java_summarize.common.user.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *   实体类 -- generator 逆向工程生成
 * </p>
 *  继承Model<T>   ActiveRecord  简称 AR  活动记录
 *     ActiveRecord模式特点是一个模型类对应关系型数据库中一个表，而模型类的一个实例对应表中一个记录。
 *     现在仅仅需要让实现类继承Model<T> 类 且实现主键指定方法即可
 *     注意：实体类对应的接口mapper 中 需要UserDao extends BaseMapper<User>
 *          虽然AR模式用不到该接口，但是一定要定义，否则使用AR会报NullPointException
 *
 *    使用：
 *         User user = new User();
 *         user.setName("林青霞");
 *         user.setAge(22);
 *         user.setGender(1);
 *         //下句就是AR的使用
 *         ---------------------------------
 *         boolean result = user.insert();
 *         ---------------------------------
 *
 * @author lpan
 * @since 2019-05-20
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class User extends Model<User> implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String name;

    private String age;

    private LocalDateTime birthday;

    private String address;

    /** 继承Model<*> 重写pkVal() 返回当前类主键 */
    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
