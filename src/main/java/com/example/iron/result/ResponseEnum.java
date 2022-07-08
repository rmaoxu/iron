package com.example.iron.result;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public enum ResponseEnum {

    SUCCESS(0, "成功"),
    ERROR(-1, "服务器内部错误"),

    BAD_SQL_GRAMMAR_ERROR(-101, "sql语法错误"),
    UPLOAD_ERROR(-103, "文件上传错误"),
    CSVFILE_EMPTY(-104, "文件上传为空"),

    PARAM_EMPTY(-105, "参数为空");
    //响应状态码
    private final Integer code;
    //响应信息
    private final String message;
}
