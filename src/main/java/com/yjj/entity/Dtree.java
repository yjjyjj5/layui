package com.yjj.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author
 * @date: 2021/2/27 15:55
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Dtree {
    //id
    private Integer id;
    //标题
    private String title;
    //复选框
    private String checkArr;
    //父级id
    private Integer parentId;
}
