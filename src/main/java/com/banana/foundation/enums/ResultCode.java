package com.banana.foundation.enums;

public enum ResultCode {
    SUCCESS("200", "1", "操作成功", "操作成功"),
    ERROR("400", "2", "系统异常,请稍后!", "默认错误"),
    INFO_MISSING("604","6","信息不存在","信息不存在");

    ResultCode(String code, String codeGroup, String title, String msg) {
        this.code = code;
        this.codeGroup = codeGroup;
        this.title = title;
        this.msg = msg;
    }

    private String code;
    private String codeGroup;
    private String title;
    private String msg;

    public String getCode() {
        return code;
    }

    public String getCodeGroup() {
        return codeGroup;
    }

    public String getTitle() {
        return title;
    }

    public String getMsg() {
        return msg;
    }
}
