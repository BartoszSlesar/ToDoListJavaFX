package pl.bard.todolist.datamodel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TodoItem {

    private String shortDescription;
    private String details;
    private LocalDate deadline;

    public TodoItem(String shortDescription, String details, LocalDate deadline) {
        this.shortDescription = shortDescription;
        this.details = details;
        this.deadline = deadline;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getDeadline() {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("d MMMM, yyyy");
        return deadline.toString();
    }

    public String getDeadline(String format) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern(format);

        return df.format(deadline);
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        return shortDescription;
    }
}
