package com.example.todo;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<Todo> todos = new ArrayList<>();

        todos.add(new Todo("Learn Java"));
        todos.add(new Todo("Setup Jenkins CI/CD"));
        todos.add(new Todo("Integrate SonarQube Analysis"));

        todos.get(0).completeTask(); // Mark first task complete

        System.out.println("Todo List:");
        for (Todo todo : todos) {       
            System.out.println(todo);
        }
    }
}
