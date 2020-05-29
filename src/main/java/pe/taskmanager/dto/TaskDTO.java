package pe.taskmanager.dto;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

public class TaskDTO {
    private Long id;
    @NotEmpty
    private String title;
    @NotEmpty
    private String description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description == null || description.trim().isEmpty()) {
            throw new IllegalArgumentException("Title is not allowed to be empty");
        }
        this.description = description;
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
}
