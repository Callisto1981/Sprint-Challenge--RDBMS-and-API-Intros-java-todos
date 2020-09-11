package com.lambdaschool.todos.services;

import com.lambdaschool.todos.models.Todos;
import com.lambdaschool.todos.repository.TodosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service(value = "todosService")
public class TodosServiceImpl implements TodosService
{
    @Autowired
    TodosRepository todosrepos;
    @Override
    public void markComplete(long todoid)
    {
        Todos todos = todosrepos.findById(todoid)
            .orElseThrow(()-> new EntityNotFoundException("Id " + todoid + " Not Found!"));
        todos.setCompleted(true);
    }
}
