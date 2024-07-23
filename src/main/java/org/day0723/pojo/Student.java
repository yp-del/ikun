package org.day0723.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author yangpeng
 * @date 2024/7/22 下午3:29
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private Integer id;
    private String name;
    private String gender;
    private Date birthday;
    private String addr;
    private Long qqnumber;
}
