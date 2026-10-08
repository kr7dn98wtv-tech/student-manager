package com.student.common;

import lombok.Data;

@Data
public class Result {
    private Integer code;    // 状态码：1=成功，0=失败
    private String message;  // 提示信息
    private Object data;     // 真正的数据

    // 有参构造（给下面的静态方法用）
    public Result(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    // 成功（带数据）
    public static Result success(Object data) {
        return new Result(1, "success", data);
    }

    // 成功（不带数据，比如"删除成功"这种）
    public static Result success() {
        return new Result(1, "success", null);
    }

    // 失败
    public static Result error(String message) {
        return new Result(0, message, null);
    }
}
