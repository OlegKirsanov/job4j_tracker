package ru.job4j.tracker;

public class StartUI {
    public static void createItem(Input input, Tracker tracker) {
        System.out.println("--- Create a new Item ---");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
        System.out.println("Item was added!");
        System.out.println();
    }

    public static void showItems(Tracker tracker) {
        Item[] items = tracker.findAll();
        for(int index = 0; index < items.length; index++) {
            Item current = items[index];
            System.out.println("Id: " + current.getId() + " name: " + current.getName());
        }
        System.out.println();
    }

    public static void replaceItem(Input input, Tracker tracker) {
        System.out.println("--- Edit an Item ---");
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
    }

    public static void deleteItem(Input input, Tracker tracker) {
        System.out.println("--- Delete an Item ---");
        String id = input.askStr("Enter Id: ");
        if (tracker.delete(id)) {
            System.out.println("Delete was successful!");
        } else {
            System.out.println("Error!");
        }
        System.out.println();
    }

    public static void findItemById(Input input, Tracker tracker) {
        System.out.println("--- Find an Item by Id ---");
        String id = input.askStr("Enter Id: ");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println("Item found!");
            System.out.println("Id: " + item.getId() + " name: " + item.getName());
        } else {
            System.out.println("No Items found!");
        }
        System.out.println();
    }

    public static void findItemByName(Input input, Tracker tracker) {
        System.out.println("--- Find an Item by Name ---");
        String name = input.askStr("Enter name: ");
        Item[] items = tracker.findByName(name);
        if (items.length != 0) {
            for(int index = 0; index < items.length; index++) {
                Item current = items[index];
                System.out.println("Id: " + current.getId() + " name: " + current.getName());
            }
        } else {
            System.out.println("No Items found!");
        }
        System.out.println();
    }

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            StartUI.showMenu();
            int select = input.askInt("Select: ");
            if (select == 0) {
                StartUI.createItem(input, tracker);
            } else if (select == 1) {
                StartUI.showItems(tracker);
            } else if (select == 2) {
                StartUI.replaceItem(input, tracker);
            } else if (select == 3) {
                StartUI.deleteItem(input, tracker);
            } else if (select == 4) {
                StartUI.findItemById(input, tracker);
            } else if (select == 5) {
                StartUI.findItemByName(input, tracker);
            } else if (select == 6) {
                run = false;
            }
        }
    }

    private static void showMenu() {
        System.out.println("Menu:");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}
