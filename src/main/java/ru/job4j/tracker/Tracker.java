package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Random;

public class Tracker {
    /**
     * Массив для хранения заявок.
     */
    private final Item[] items = new Item[100];

    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;

    /**
     * Метод добавления заявки в хранилище
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(generateId());
        items[position++] = item;
        return item;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     * @return Уникальный ключ.
     */
    private String generateId() {
        Random rm = new Random();
        return String.valueOf(rm.nextLong() + System.currentTimeMillis());
    }

    public Item[] findAll() {
        return Arrays.copyOf(items, position);
    }

    public Item[] findByName(String key) {
        Item[] tmp = new Item[position];
        int tmpIndex = 0;
        for (int index = 0; index < position; index++) {
            if (items[index].getName().equals(key)) {
                tmp[tmpIndex++] = items[index];
            }
        }
        return Arrays.copyOf(tmp, tmpIndex);
    }

    public Item findById(String id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    private int indexOf(String id) {
        int rsl = -1;
        for(int index = 0; index < position; index++) {
            if (items[index].getId().equals(id)) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(String id, Item item) {
        int replaceIndex = indexOf(id);
        boolean result = false;
        if(replaceIndex != -1) {
            items[replaceIndex].setName(item.getName());
            result = true;
        }
        return result;
    }

    public boolean delete(String id) {
        int index = indexOf(id);
        int size = position - index - 1;
        System.arraycopy(items, index + 1, items, index, size);
        items[position - 1] = null;
        position--;
        return true;
    }
}
