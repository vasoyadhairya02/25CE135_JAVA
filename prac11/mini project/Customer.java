package Practical_11.Practical_11B;

import java.io.Serializable;

public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private String mobile;

    public Customer(String name, String mobile) {
        this.name = name;
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public String getMobile() {
        return mobile;
    }

    @Override
    public String toString() {
        return name + " (" + mobile + ")";
    }
}