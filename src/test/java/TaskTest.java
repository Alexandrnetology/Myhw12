import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    @Test
    public void shouldGetTask() {
        Task task = new Task(5);
        int expected = task.id;
        int actual = task.getId();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldGetSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Купить молоко");
        String expected = simpleTask.title;
        String actual = simpleTask.getTitle();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldMatchesSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Купить молоко");

        boolean expected = true;
        boolean actual = simpleTask.matches("молоко");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldMatchesSimpleTaskFalse() {
        SimpleTask simpleTask = new SimpleTask(5, "Купить ,батон");

        boolean expected = false;
        boolean actual = simpleTask.matches("молоко");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldGetEpic() {
        Epic epic = new Epic(4, new String[]{"Молоко", "Яйца", "Хлеб"});
        String[] expected = epic.subtasks;
        String[] actual = epic.getSubtasks();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldMatchesEpic() {

        Epic epic = new Epic(5, new String[]{"Молоко", "Яйца", "Хлеб"});

        boolean expected = true;
        boolean actual = epic.matches("Хлеб");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldMatchesEpicFalse() {

        Epic epic = new Epic(5, new String[]{"Молоко", "Яйца", "Хлеб"});

        boolean expected = false;
        boolean actual = epic.matches("Печенье");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldGetMeeting() {
        Meeting meeting = new Meeting(555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        String[] expected = {meeting.getProject(), meeting.getTopic(), meeting.getStart()};
        String[] actual = {meeting.getProject(), meeting.getTopic(), meeting.getStart()};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldMatchesMeeting() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        boolean expected = true;
        boolean actual = meeting.matches("Выкатка");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldMatchesMeetingFalse() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        boolean expected = false;
        boolean actual = meeting.matches("Баранка");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldMatchesTask() {
        Task task = new Task(4);
        boolean expected = false;
        boolean actual = task.matches("5");

        Assertions.assertEquals(expected, actual);
    }
}

