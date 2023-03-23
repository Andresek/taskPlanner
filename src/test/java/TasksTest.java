import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TasksTest {

    @Test
    public void matchesSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(45, "Стирка");
        Todos todos = new Todos();

        todos.add(simpleTask);

        boolean expected = true;
        boolean actual = simpleTask.matches("Стирка");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void matchesEpic() {

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(15, subtasks);
        Todos todos = new Todos();

        todos.add(epic);

        boolean expected = true;
        boolean actual = epic.matches("Хлеб");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void matchesMeetingContainsTopic() {

        Meeting meeting = new Meeting(32, "Сбор урожая", "Светлый путь", "В 06:00");
        Todos todos = new Todos();

        todos.add(meeting);

        boolean expected = true;
        boolean actual = meeting.matches("Сбор урожая");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void matchesMeetingContainsProject() {

        Meeting meeting = new Meeting(32, "Сбор урожая", "Светлый путь", "В 06:00");
        Todos todos = new Todos();

        todos.add(meeting);

        boolean expected = true;
        boolean actual = meeting.matches("Светлый путь");

        Assertions.assertEquals(expected, actual);
    }


}
