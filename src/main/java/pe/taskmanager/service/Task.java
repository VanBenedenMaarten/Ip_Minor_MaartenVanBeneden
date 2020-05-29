package pe.taskmanager.service;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Task {
    @Id
    @GeneratedValue
    private Long id;
    private String title, description;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateDue;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title is not allowed to be empty");
        }
        this.title = title;
    }

    public LocalDate getDateDue() {
        return dateDue;
    }

    public void setDateDue(String dateDue) {
        LocalDate date = LocalDate.parse(dateDue);
        if (date.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Date due can't be in the past");
        }
        this.dateDue = date;
    }

    public void setDateDue(LocalDate dateDue) {
        if (dateDue.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Date due can't be in the past");
        }
        this.dateDue = dateDue;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        if (id < 0) {
            throw new IllegalArgumentException("Id can't be negative");
        }
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description == null || description.trim().isEmpty()) {
            throw new IllegalArgumentException("Title is not allowed to be empty");
        }
        this.description = description;
    }
}
