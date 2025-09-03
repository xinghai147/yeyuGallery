package com.xingji.tuku.common;

import lombok.Data;

import java.io.Serializable;

/**
 * 通用删除请求类
 */
@Data
public class DeleteRequest implements Serializable {

    /**
     * id
     */
    private Long id;

    private static final long seridVersionUID = 1L;
}
