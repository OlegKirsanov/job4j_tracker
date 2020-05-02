package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    @Override
    public String name() {
        return "Delete An Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("--- Delete An Item ---");
        String id = input.askStr("Enter Id: ");
        if (tracker.delete(id)) {
            System.out.println("Delete was successful!");
        } else {
            System.out.println("Error!");
        }
        System.out.println();
        return true;
    }
}
