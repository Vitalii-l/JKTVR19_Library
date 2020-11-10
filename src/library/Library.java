/*
 * Ветка saveToBase
 * подключение к базе данных
 * и созхранение сущностей в базу
 * Шаги:
 * 1. Добавить библиотеки (EclipseLink ) и драйвер БД
 * 2. Добавить аннотацию @Entity, @Id, @GeneratedValue к полям классов сущностей.
 * 3. Создание БД с помощью phpMyAdmin
 * 4. 
 * 5. В persistence.xml 
 * 6. Создаем файл-менеджер сохранения в базе
 * 7. 
 */
package library;

/**
 *
 * @author pupil
 */
public class Library {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        App app = new App();
        app.run();
    }
    
}
