package database_sample;

public class Main {

    public static void main(String[] args) {
        DatabaseConnector connector = DatabaseConnector.getInstance();
        var data = connector.getData(1);
        System.out.println(data.getID() + ":" + data.getName() + ":" + data.getClassName());
    }
}
