package bootcamp.todoapp.ToDoApp;

import bootcamp.todoapp.ToDoApp.model.TodoItem;
import bootcamp.todoapp.ToDoApp.model.TodoRespositry;
import lombok.extern.java.Log;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@DataJpaTest
@Log
public class TodoRepositoryIntegrationTest {

    @Autowired
    TodoRespositry repository;

    @Test
    public void testFindByText() {
        log.info("Test Find by test executing.");

        // given
        Date startTest = new Date();
        TodoItem item = new TodoItem("Novi todo 123");
        item.setCreatedTS(startTest);
        repository.save(item);

        // when
        TodoItem found = repository.findByText("Novi todo 123");

        // then
        Assert.assertEquals(found.getCreatedTS().getTime(), startTest.getTime());
    }
}
