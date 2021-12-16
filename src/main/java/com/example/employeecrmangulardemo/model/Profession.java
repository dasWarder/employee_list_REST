package com.example.employeecrmangulardemo.model;

public enum Profession {
    SOFTWARE_ENGINEER("Software Engineer"),
    PM("Product Manager"),
    HR("Human Resources"),
    QA("Quality Assurance"),
    CEO("Chief Executive Office");

    private String name;

    private Profession(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
