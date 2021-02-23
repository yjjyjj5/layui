package com.yjj.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author
 * @date: 2021/1/27 16:05
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Userrole implements Serializable {
    private Integer id;
    private Integer userid;
    private Integer roleid;
}