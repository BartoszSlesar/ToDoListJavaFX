package pl.bard.todolist.datamodel;

import javafx.collections.FXCollections;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;

public class TodoData {
    private static TodoData instance = new TodoData();
    private static String filename = "./Resources/TodoListItems.txt";
    private List<TodoItem> todoItems;
    private DateTimeFormatter formatter;

    //    return instance of our singleton class
    public static TodoData getInstance() {
        return instance;
    }

    //    prevent class to be instantiate
    private TodoData() {
        formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    }

    public List<TodoItem> getTodoItems() {
        return todoItems;
    }

    public void loadTodoItem() throws IOException {

        todoItems = FXCollections.observableArrayList();
        Path path = Paths.get(filename);

        String input;
        try (BufferedReader br = Files.newBufferedReader(path)) {
            while ((input = br.readLine()) != null) {
                String[] itemPieces = input.split("\t");

                String shortDescription = itemPieces[0];
                String details = itemPieces[1];

                String dateString = itemPieces[2];
                LocalDate date = LocalDate.parse(dateString, formatter);
                TodoItem todoItem = new TodoItem(shortDescription, details, date);
                todoItems.add(todoItem);
            }

        }
    }

    public void storeTodoItems() throws IOException {
        Path path = Paths.get(filename);

        try (BufferedWriter bw = Files.newBufferedWriter(path)) {
            Iterator<TodoItem> iter = todoItems.iterator();
            while (iter.hasNext()) {
                TodoItem item = iter.next();
                bw.write(String.format("%s\t%s\t%s",
                        item.getShortDescription(),
                        item.getDetails(),
                        item.getDeadline("dd.MM.yyyy")));
                bw.newLine();
            }

        }
    }


}
