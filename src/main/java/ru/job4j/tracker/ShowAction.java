package ru.job4j.tracker;

public class ShowAction implements UserAction {
    @Override
    public String name() {
        return "Show All Items";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("--- Show All Items ---");
        Item[] items = tracker.findAll();
        for(int index = 0; index < items.length; index++) {
            Item current = items[index];
            System.out.println(current.toString());
        }
        System.out.println();
        return true;
    }
}

