package ru.job4j.isp.menu;

import java.util.*;

public class SimpleMenu implements Menu {
    private final List<MenuItem> rootElements = new ArrayList<>();

    @Override
    public boolean add(String parentName, String childName, ActionDelegate actionDelegate) {
        boolean rsl = false;
        if (findItem(childName).isEmpty()) {
            if (Objects.equals(parentName, ROOT)) {
                rootElements.add(new SimpleMenuItem(childName, actionDelegate));
                rsl = true;
            } else {
                Optional<ItemInfo> itemInfoParent = findItem(parentName);
                if (itemInfoParent.isPresent()) {
                    SimpleMenuItem menuItem = (SimpleMenuItem) itemInfoParent.get().menuItem;
                    menuItem.addChildren(new SimpleMenuItem(childName, actionDelegate));
                    rsl = true;
                }
            }
        }
        return rsl;
    }

    @Override
    public Optional<MenuItemInfo> select(String itemName) {
        return findItem(itemName).map(itemInfo -> new MenuItemInfo(itemInfo.menuItem, itemInfo.number));
    }

    @Override
    public Iterator<MenuItemInfo> iterator() {
        return new Iterator<>() {
            private final DFSIterator dfsIterator = new DFSIterator();

            @Override
            public boolean hasNext() {
                return dfsIterator.hasNext();
            }

            @Override
            public MenuItemInfo next() {
                ItemInfo itemInfo = dfsIterator.next();
                return new MenuItemInfo(itemInfo.menuItem, itemInfo.number);
            }
        };
    }

    private Optional<ItemInfo> findItem(String name) {
        Optional<ItemInfo> rsl = Optional.empty();
        DFSIterator it = new DFSIterator();
        while (it.hasNext()) {
            ItemInfo itemInfo = it.next();
            if (name.equals(itemInfo.menuItem.getName())) {
                rsl = Optional.of(itemInfo);
                break;
            }
        }
        return rsl;
    }

    private static class SimpleMenuItem implements MenuItem {
        private final String name;
        private final List<MenuItem> children = new ArrayList<>();
        private final ActionDelegate actionDelegate;

        public SimpleMenuItem(String name, ActionDelegate actionDelegate) {
            this.name = name;
            this.actionDelegate = actionDelegate;
        }

        public void addChildren(MenuItem children) {
            this.children.add(children);
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public List<MenuItem> getChildren() {
            return children;
        }

        @Override
        public ActionDelegate getActionDelegate() {
            return actionDelegate;
        }
    }

    /**
     * Итератор созданный на основе этого класса позволяет связать каждый элемент меню с порядковым номером
     * и вернуть через последовательные вызовы next() древовидную структуру меню.
     */
    private class DFSIterator implements Iterator<ItemInfo> {
        Deque<MenuItem> stack = new LinkedList<>();
        Deque<String> numbers = new LinkedList<>();

        DFSIterator() {
            int number = 1;
            for (MenuItem menuItem : rootElements) {
                stack.addLast(menuItem);
                numbers.addLast(String.valueOf(number++).concat("."));
            }
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public ItemInfo next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            MenuItem current = stack.removeFirst();
            String lastNumber = numbers.removeFirst();
            List<MenuItem> children = current.getChildren();
            int currentNumber = children.size();
            ListIterator<MenuItem> it = children.listIterator(children.size());
            while (it.hasPrevious()) {
                stack.addFirst(it.previous());
                numbers.addFirst(lastNumber.concat(String.valueOf(currentNumber--).concat(".")));
            }
            return new ItemInfo(current, lastNumber);
        }
    }

    private static class ItemInfo {
        private final MenuItem menuItem;
        private final String number;

        public ItemInfo(MenuItem menuItem, String number) {
            this.menuItem = menuItem;
            this.number = number;
        }
    }
}
