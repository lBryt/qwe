package ru.job4j.start;

import org.junit.Test;
import ru.job4j.models.Item;

import java.util.Collections;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription");
        tracker.add(item);
        assertThat(tracker.getAll()[0], is(item));
    }

    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription");
        tracker.add(previous);
        Item next = new Item("test2", "testDescription2");
        next.setId(previous.getId());
        tracker.replace(previous.getId(), next);
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();     // создаём Tracker
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});   //создаём StubInput с последовательностью действий
        new StartUI(input, tracker).init();     //   создаём StartUI и вызываем метод init()
        assertThat(tracker.getAll()[0].getName(), is("test name")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
    }

    @Test
    public void whenGetAllItemsThemReturnArrayWithItemsNotEqualsNull() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription");
        tracker.add(item);
        Item[] expected = {item};
        assertThat(tracker.getAll(), is(expected));
    }

    @Test
    public void whenDeleteFromArrayItemsThenArrayIsOneLess() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription");
        Item delete = new Item("test2", "testDescription");
        tracker.add(item);
        tracker.add(delete);
        tracker.delete(delete.getId());
        Item[] expected = {item};
        assertThat(tracker.getAll(), is(expected));
    }
    @Test
    public void whenFindExistItemByIdThemReturnFoundItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription");
        tracker.add(item);
        assertThat(tracker.findById(item.getId()), is(item));
    }

    @Test
    public void whenFindNoExistItemByIdThemReturnEmptyItem() {
        Tracker tracker = new Tracker();
        assertThat(tracker.findById("EmptyValue"), is(Item.EMPTY));
    }

    @Test
    public void whenFindExistItemByNameThemReturnFoundItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription");
        tracker.add(item);
        assertThat(tracker.findByName(item.getName()), is(item));
    }
    @Test
    public void whenFindNoExistItemByNameThemReturnEmptyItem() {
        Tracker tracker = new Tracker();
        assertThat(tracker.findByName("EmptyValue"), is(Item.EMPTY));
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
        Item item = tracker.add(new Item("test name", "desc"));
        //создаём StubInput с последовательностью действий
        Input input = new StubInput(new String[]{"1", item.getId(), "test name", "desc", "6"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.findById(item.getId()).getName(), is("test name"));
    }
}