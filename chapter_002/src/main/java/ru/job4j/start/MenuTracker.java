package ru.job4j.start;

import ru.job4j.models.Item;

class EditItem implements UserAction {
    @Override
    public int key() {
        return 2;
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

    @Override
    public String info() {
        return String.format("%s. %s", this.key(), "Edit the new item.");
    }
}
public class MenuTracker {

    private Input input;
    private Tracker tracker;
    private UserAction[] actions = new UserAction[6];

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public MenuTracker() {

    }

    public void fillActions() {
        this.actions[0] = this.new AddItem();
        this.actions[1] = new MenuTracker.ShowItems();
        this.actions[2] = new EditItem();
        this.actions[3] = new MenuTracker.Delete();
        this.actions[4] = new FindById();
        this.actions[5] = new FindByName();
    }
    
    public int[] getRange() {
        int[] result = new int[this.actions.length];
        for (int index = 0; index != this.actions.length; index++) {
            result[index] = index;
        }
        return result;
    }

    public void select(int key) {
        this.actions[key].execute(this.input, this.tracker);
    }

    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    private class AddItem implements UserAction {
        @Override
        public int key() {
            return 0;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Please, enter the task's name: ");
            String desk = input.ask("Please, enter the task's desk: ");
            String author = input.ask("Please, enter the task's author: ");
            tracker.add(new Item(name, desk, author));
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Add new item.");
        }
    }

    private static class ShowItems implements UserAction {
        @Override
        public int key() {
            return 1;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            for (Item item : tracker.getAll()) {
                System.out.println(String.format("%s. %s", item.getId(), item.getName()));
            }
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Show all items.");
        }
    }

    private static class Delete implements UserAction {
        @Override
        public int key() {
            return 3;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Please, enter the task's id for deleting: ");
            tracker.delete(id);
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Deleting item.");
        }
    }

    private static class FindById implements UserAction {
        @Override
        public int key() {
            return 4;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Please, enter the task's id for searching: ");
            Item item = tracker.findById(id);
            System.out.println(String.format("%s. %s", item.getName(), item.getId()));
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Find item by Id.");
        }
    }

    private static class FindByName implements UserAction {
        @Override
        public int key() {
            return 5;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Please, enter the task's name for searching: ");
            Item item = tracker.findByName(id);
            System.out.println(String.format("%s. %s", item.getName(), item.getId()));
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Find items by name");
        }
    }
}
