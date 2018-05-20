package ru.job4j.start;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.models.Item;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {
    private Tracker tracker;
    private Item item;

    @Before
    public void init() {
        tracker = new Tracker();
        item = new Item("test1", "testDescription");
    }

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        tracker.add(item);
        assertThat(tracker.getAll()[0], is(item));
    }

    @Test
    public void whenReplaceNameThenReturnNewName() {
        tracker.add(item);
        Item next = new Item("test2", "testDescription2");
        next.setId(item.getId());
        tracker.replace(item.getId(), next);
        assertThat(tracker.findById(item.getId()).getName(), is("test2"));
    }

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});   //создаём StubInput с последовательностью действий
        new StartUI(input, tracker).init();     //   создаём StartUI и вызываем метод init()
        assertThat(tracker.getAll()[0].getName(), is("test name")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
    }

    @Test
    public void whenGetAllItemsThemReturnArrayWithItemsNotEqualsNull() {
        tracker.add(item);
        Item[] expected = {item};
        assertThat(tracker.getAll(), is(expected));
    }

    @Test
    public void whenDeleteFromArrayItemsThenArrayIsOneLess() {
        Item delete = new Item("test2", "testDescription");
        tracker.add(item);
        tracker.add(delete);
        tracker.delete(delete.getId());
        Item[] expected = {item};
        assertThat(tracker.getAll(), is(expected));
    }
    @Test
    public void whenFindExistItemByIdThemReturnFoundItem() {
        tracker.add(item);
        assertThat(tracker.findById(item.getId()), is(item));
    }

    @Test
    public void whenFindNoExistItemByIdThemReturnEmptyItem() {
        assertThat(tracker.findById("EmptyValue"), is(Item.EMPTY));
    }

    @Test
    public void whenFindExistItemByNameThemReturnFoundItem() {
        tracker.add(item);
        assertThat(tracker.findByName(item.getName()), is(item));
    }
    @Test
    public void whenFindNoExistItemByNameThemReturnEmptyItem() {
        assertThat(tracker.findByName("EmptyValue"), is(Item.EMPTY));
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        tracker.add(item);
        Input input = new StubInput(new String[]{"1", item.getId(), "test1", "testDescription2", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("test1"));
    }
}