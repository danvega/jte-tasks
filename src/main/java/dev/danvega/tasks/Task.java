package dev.danvega.tasks;

import java.util.UUID;

public class Task {
    private final String id;
    private final String description;

    public Task(String description) {
        this.id = UUID.randomUUID().toString();
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }
}
