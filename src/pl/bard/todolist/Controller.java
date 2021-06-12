package pl.bard.todolist;

import pl.bard.todolist.datamodel.TodoItem;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    private List<TodoItem> todoItems;

    public void initialize() {
//        for testing purposes
        TodoItem item1 = new TodoItem("Coding Exercise", "Do a next module of java Course",
                LocalDate.of(2021, Month.JUNE, 13));
        TodoItem item2 = new TodoItem("Doctor appointment", "See, Dr. and some random text",
                LocalDate.of(2021, Month.JULY, 15));
        TodoItem item3 = new TodoItem("Order a package from site X", "Some random and unnecessary data",
                LocalDate.of(2021, Month.APRIL, 13));
        TodoItem item4 = new TodoItem("Pickup friend from airport", "Pickup friends from airport",
                LocalDate.of(2021, Month.JANUARY, 15));
        TodoItem item5 = new TodoItem("Preparing for competition", "Run run run and win",
                LocalDate.of(2021, Month.OCTOBER, 21));

        todoItems = new ArrayList<>();
        todoItems.add(item1);
        todoItems.add(item2);
        todoItems.add(item3);
        todoItems.add(item4);
        todoItems.add(item5);

    }

}
