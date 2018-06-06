package ru.job4j.start;

import ru.job4j.models.Item;

import java.util.ArrayList;
import java.util.List;

public class MenuTracker {

    private Input input;
    private Tracker tracker;
    private List<UserAction> actions = new ArrayList<>();


    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void addAction(UserAction action) {
        this.actions.add(action);
    }

    public void fillActions() {
        this.actions.add(this.new AddItem(0, "Add new item."));
        this.actions.add(this.new ShowItems(1, "Show all items."));
        this.actions.add(this.new EditItem(2, "Edit the new item."));
        this.actions.add(this.new Delete(3, "Please, enter the task's id for deleting: "));
        this.actions.add(this.new FindById(4, "Find item by Id."));
        this.actions.add(this.new FindByName(5, "Find items by name"));
    }
    
    public int[] getRange() {
        int[] result = new int[this.actions.size()];
        for (int index = 0; index != this.actions.size(); index++) {
            result[index] = index;
        }
        return result;
    }

    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }

    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    private class AddItem extends BaseAction {
        public AddItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Please, enter the task's name: ");
            String desk = input.ask("Please, enter the task's desk: ");
            String author = input.ask("Please, enter the task's author: ");
            tracker.add(new Item(name, desk, author));
        }
    }

    private class ShowItems extends BaseAction {
        public ShowItems(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            for (Item item : tracker.getAll()) {
                System.out.println(String.format("%s. %s", item.getId(), item.getName()));
            }
        }
    }

    private class EditItem extends BaseAction  {
        public EditItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Please, enter the task's id: ");
            String name = input.ask("Please, enter the task's name: ");
            String desk = input.ask("Please, enter the task's desk: ");
            Item task = new Item(name, desk);
            task.setId(id);
            tracker.edit(task);
        }
    }

    private class Delete extends BaseAction {
        public Delete(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Please, enter the task's id for deleting: ");
            tracker.delete(id);
        }
    }

    private class FindById extends BaseAction {
        public FindById(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Please, enter the task's id for searching: ");
            Item item = tracker.findById(id);
            System.out.println(String.format("%s. %s", item.getName(), item.getId()));
        }
    }

    private class FindByName extends BaseAction {
        public FindByName(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Please, enter the task's name for searching: ");
            Item item = tracker.findByName(id);
            System.out.println(String.format("%s. %s", item.getName(), item.getId()));
        }
    }
}
