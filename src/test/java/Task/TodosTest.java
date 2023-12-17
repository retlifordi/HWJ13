package Task;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TodosTest {
    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
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

        Task[] actual = todos.findAll();
        Task[] expected = { simpleTask, epic, meeting };


        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testWhenFewTaskFound() {
        SimpleTask simpleTask = new SimpleTask(5, "Купить Молоко");

        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
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

        Task[] actual = todos.search("Молоко");
        Task[] expected = { simpleTask, epic };


        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void testWhenTaskNotFound() {
        SimpleTask simpleTask = new SimpleTask(5, "Купить Молоко");

        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] actual = todos.search("Slon");
        Task[] expected = {  };


        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void testWhenOneTaskFound() {
        SimpleTask simpleTask = new SimpleTask(5, "Купить Молоко");

        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
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

        Task[] actual = todos.search("Яйца");
        Task[] expected = { epic };


        Assertions.assertArrayEquals(expected, actual);
    }
}
