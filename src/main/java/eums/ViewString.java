package eums;

public enum ViewString {
    id("序号"),
    userName("代理商名称"),
    money("账户余额")
    ;

    ViewString(String value) {
        this.value=value;
    }
    private String value;


    public String getValue() {
        return value;
    }
}
