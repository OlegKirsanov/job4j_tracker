package ru.job4j.tracker;

public class FindByIdAction implements UserAction {
    @Override
    public String name() {
        return "Find An Item By Id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("--- Find An Item By Id ---");
        String id = input.askStr("Enter Id: ");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println("Item found!");
            System.out.println(item.toString());
        } else {
            System.out.println("No Items found!");
        }
        System.out.println();
        return true;
    }
}
