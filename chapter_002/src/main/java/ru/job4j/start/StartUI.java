package ru.job4j.start;

import ru.job4j.models.Item;

/**
 * @version $Id$
 * @since 0.1
 */
public class StartUI {
	/**
	 * Константа меню для добавления новой заявки.
	 */
	private static final String ADD = "0";

	/**
	 *	Константа для отображения всех заявок.
	 */
	private static final String SHOW_ALL = "1";

	/**
	 * Константа для редактирования заявки.
	 */
	private static final String EDIT = "2";

	/**
	 * Константа для удаления заявки.
	 */
	private static final String DELETE = "3";

	/**
	 * Константа для поиска заявки по id.
	 */
	private static final String FIND_BY_ID = "4";

	/**
	 * Константа для поиска заявки по наименованию.
	 */
	private static final String FIND_BY_NAME = "5";

	/**
	 * Константа для выхода из цикла.
	 */
	private static final String EXIT = "6";
	/**
	 * Получение данных от пользователя.
	 */
	private final Input input;

	/**
	 * Хранилище заявок.
	 */
	private final Tracker tracker;

	/**
	 * Конструтор инициализирующий поля.
	 * @param input ввод данных.
	 * @param tracker хранилище заявок.
	 */
	public StartUI(Input input, Tracker tracker) {
		this.input = input;
		this.tracker = tracker;
	}

	/**
	 * Основой цикл программы.
	 */
	public void init() {
		boolean exit = false;
		while (!exit) {
			this.showMenu();
			String answer = this.input.ask("Введите пункт меню : ");
			if (ADD.equals(answer)) {
				this.createItem();
			} else if (SHOW_ALL.equals(answer)) {
				for (Item item : this.tracker.getAll()) {
					System.out.println(item.getName() + " " + item.getId());
				}
			} else if (EDIT.equals(answer)) {
				this.tracker.replace(
						this.input.ask("Введите id заявки которую нужно заменить : "),
						this.tracker.findById(this.input.ask("Введите id заявки для замены : "))
				);
			} else if (DELETE.equals(answer)) {
				this.tracker.delete(this.input.ask("Введите id заявки которую нужно удалить : "));
			} else if (FIND_BY_ID.equals(answer)) {
				Item item = this.tracker.findById(this.input.ask("Введите id заявки для поиска : "));
				System.out.println("------------  заявка с getId : " + item.getId() + " " + item.getName() + "-----------");
			} else if (FIND_BY_NAME.equals(answer)) {
				Item item = this.tracker.findByName(this.input.ask("Введите name заявки для поиска : "));
				System.out.println("------------  заявка с getId : " + item.getId() + " " + item.getName() + "-----------");
			} else if (EXIT.equals(answer)) {
				exit = true;
			} else {
				System.out.println("Неверный пункт меню.");
			}
		}
	}

	/**
	 * Метод реализует добавленяи новый заявки в хранилище.
	 */
	private void createItem() {
		System.out.println("------------ Добавление новой языки --------------");
		String name = this.input.ask("Введите имя заявки :");
		String desc = this.input.ask("Введите описание заявки :");
		Item item = new Item(name, desc);
		this.tracker.add(item);
		System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
	}

	private void showMenu() {
		System.out.println("Menu.");
		System.out.println("0. Add new Item");
		System.out.println("1. Show all items");
		System.out.println("2. Edit item");
		System.out.println("3. Delete item");
		System.out.println("4. Find item by Id");
		System.out.println("5. Find items by name");
		System.out.println("6. Exit Program");
	}

	/**
	 * Запускт программы.
	 * @param args
	 */
	public static void main(String[] args) {
		new StartUI(new ConsoleInput(), new Tracker()).init();
	}
}