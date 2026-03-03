package database_sample;

/**
 * id: int, auto_increment </br>
 * name: varchar(255) </br>
 * className: varchar(20)
 */
public class TestDatabase {

    private final int id;
    private final String name;
    private final String className;

    public TestDatabase(int id, String name, String className) {
        this.id = id;
        this.name = name;
        this.className = className;
    }

    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getClassName() {
        return className;
    }


}
