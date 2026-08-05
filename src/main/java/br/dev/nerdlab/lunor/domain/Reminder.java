package br.dev.nerdlab.lunor.domain;

import java.time.LocalDateTime;
import java.util.UUID;

public class Reminder {

    private final UUID id;
    private String title;
    private LocalDateTime dueDate;
    private boolean isCompleted;

    
    public Reminder(String title, LocalDateTime dueDate) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.dueDate = dueDate;
        this.isCompleted = false;
    }

    public Reminder(UUID id, String title, LocalDateTime dueDate, boolean isCompleted) {
        this.id = id;
        this.title = title;
        this.dueDate = dueDate;
        this.isCompleted = isCompleted;
    }

    public void complete(){
        this.isCompleted = true;
    }

    public UUID getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public LocalDateTime getDueDate() {
        return dueDate;
    }
    public boolean isCompleted() {
        return isCompleted;
    }
    
    
    
}
