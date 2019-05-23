package by.training.entity;

public enum Role {
    ADMINISTRATOR("администратор"),
    USER("пользователь");

    private String name;

    private Role(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return ordinal();
    }

    public static Role getById(int id) {
        return Role.values()[id];
    }
}
