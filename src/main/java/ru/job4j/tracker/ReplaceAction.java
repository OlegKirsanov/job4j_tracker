package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
    @Override
    public String name() {
        return "Replace An Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("--- Replace An Item ---");
        String id = input.askStr("Enter Id: ");
        Item item = new Item();
        String name = input.askStr("Enter a new name: ");
        item.setName(name);
        if (tracker.replace(id, item)) {
            System.out.println("Replace was successful!");
        } else {
            System.out.println("Error!");
        }
        System.out.println();
        return true;
    }
}
