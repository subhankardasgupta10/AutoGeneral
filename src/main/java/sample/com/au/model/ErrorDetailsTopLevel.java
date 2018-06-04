
package sample.com.au.model;

public class ErrorDetailsTopLevel {
    String name;
    String location;
    String param;
    String msg;
    String value;

    public ErrorDetailsTopLevel(String name, String location, String param, String msg, String value) {
        super();
        this.name = name;
        this.location = location;
        this.param = param;
        this.msg = msg;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(final String location) {
        this.location = location;
    }

    public String getParam() {
        return param;
    }

    public void setParam(final String param) {
        this.param = param;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(final String msg) {
        this.msg = msg;
    }

    public String getValue() {
        return value;
    }

    public void setValue(final String value) {
        this.value = value;
    }
}
