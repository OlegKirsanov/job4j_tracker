package ru.job4j.tracker;

public class FindByNameAction implements UserAction {
    @Override
    public String name() {
        return "Find An Item By Name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("--- Find An Item By Name ---");
        String name = input.askStr("Enter name: ");
        Item[] items = tracker.findByName(name);
        if (items.length != 0) {
            for(int index = 0; index < items.length; index++) {
                Item current = items[index];
                System.out.print(current.toString());
            }
        } else {
            System.out.print("No Items found!");
        }
        System.out.println();
        return true;
    }
}
