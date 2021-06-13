package pl.bard.todolist;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import pl.bard.todolist.datamodel.TodoData;
import pl.bard.todolist.datamodel.TodoItem;

import java.time.LocalDate;

public class DialogController {
//    TODO Add ability to modify Data

    @FXML
    private TextField shortDescriptionField;
    @FXML
    private TextArea detailsAreaField;
    @FXML
    private DatePicker deadlinePicker;

    public TodoItem processResults() {
        String shortDescription = shortDescriptionField.getText().trim();
        String details = detailsAreaField.getText().trim();
        LocalDate deadlineValue = deadlinePicker.getValue();

        TodoItem newItem = new TodoItem(shortDescription, details, deadlineValue);
        TodoData.getInstance().addTodoItem(newItem);
        return newItem;

    }

}
