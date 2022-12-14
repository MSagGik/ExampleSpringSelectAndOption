package ru.msaggik.spring.models;


import javax.validation.constraints.*;

public class Person {
    private int id;
    @NotEmpty(message = "Name should not be empty") // аннотация исключения пустого имени (сообщение ошибки)
    @Size(min = 2, max = 500, message = "Name should be between 2 and 30 characters") // аннотация длины имени
    private String name;
    // дополнительные поля
    @Min(value = 0, message = "Age should be greater than 0") // ограничение минимального возраста
    private int age;
    @NotEmpty(message = "Name should not be empty")
    @Email(message = "Email should be valid") // валидность адреса электронной почты
    private String email;
    // добавление нового поля адреса
    // формат адреса: Страна, Город, Индекс (6 цифр)
    @Pattern(regexp = "[A-Z]\\w+, [A-Z]\\w+, \\d{6}",
            message = "Your address should be in this format: Country, City, Postal Code (6 digits)")
    // аннотация того, что поле соответствует опред. паттерну (использ. регул. выражения)
    private String address;

    public Person() {
    }

    public Person(int id, String name, int age, String email, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
