package ru.job4j.tracker;

public class CreateAction implements UserAction {
    @Override
    public String name() {
        return "Create A New Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("--- Create A New Item ---");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
        System.out.println("Item was added!");
        System.out.println();
        return true;
    }
}
