import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class TodosTest {

    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void searchWhenOneTask() {

        SimpleTask task1 = new SimpleTask(1, "завтрак");
        SimpleTask task2 = new SimpleTask(2, "обед");
        SimpleTask task3 = new SimpleTask(3, "ужин");

        Todos todos = new Todos();
        todos.add(task2);
        todos.add(task1);
        todos.add(task3);

        Task[] expected = {task1};
        Task[] actual = todos.search("завтрак");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void searchWhenOverOneTask() {

        SimpleTask task1 = new SimpleTask(1, "завтрак");
        SimpleTask task2 = new SimpleTask(2, "обед");
        SimpleTask task3 = new SimpleTask(3, "обед");

        Todos todos = new Todos();
        todos.add(task2);
        todos.add(task1);
        todos.add(task3);

        Task[] expected = {task2, task3};
        Task[] actual = todos.search("обед");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void searchNotTask() {

        SimpleTask task1 = new SimpleTask(1, "завтрак");
        SimpleTask task2 = new SimpleTask(2, "обед");
        SimpleTask task3 = new SimpleTask(3, "обед");

        Todos todos = new Todos();
        todos.add(task2);
        todos.add(task1);
        todos.add(task3);

        Task[] expected = {};
        Task[] actual = todos.search("ужин");

        Assertions.assertArrayEquals(expected, actual);

    }
}



