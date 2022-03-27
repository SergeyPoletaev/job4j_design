package ru.job4j.jdbc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.StringJoiner;

public class TableEditor implements AutoCloseable {
    private final Properties properties;
    private Connection connection;

    public TableEditor(Properties properties) throws SQLException, ClassNotFoundException {
        this.properties = properties;
        initConnection();
    }

    public static String getTableScheme(Connection connection, String tableName) throws Exception {
        var rowSeparator = "-".repeat(30).concat(System.lineSeparator());
        var header = String.format("%-15s|%-15s%n", "NAME", "TYPE");
        var buffer = new StringJoiner(rowSeparator, rowSeparator, rowSeparator);
        buffer.add(header);
        try (var statement = connection.createStatement()) {
            var selection = statement.executeQuery(String.format(
                    "select * from %s limit 1", tableName
            ));
            var metaData = selection.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                buffer.add(String.format("%-15s|%-15s%n",
                        metaData.getColumnName(i), metaData.getColumnTypeName(i))
                );
            }
        }
        return buffer.toString();
    }

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader =
                     new BufferedReader(
                             new FileReader("data/app.properties", StandardCharsets.UTF_8))) {
            Properties properties = new Properties();
            properties.load(reader);
            try (TableEditor tableEditor = new TableEditor(properties)) {
                String tableName = "autos";
                String columnName = "model";
                String newColumnName = "power";
                tableEditor.createTable(tableName);
                printSchema(tableEditor, tableName);
                tableEditor.addColumn(tableName, columnName, "text");
                printSchema(tableEditor, tableName);
                tableEditor.renameColumn(tableName, columnName, newColumnName);
                printSchema(tableEditor, tableName);
                tableEditor.dropColumn(tableName, newColumnName);
                printSchema(tableEditor, tableName);
                tableEditor.dropTable(tableName);
            }
        }
    }

    private static void printSchema(TableEditor tableEditor, String tableName) throws Exception {
        System.out.println(getTableScheme(tableEditor.connection, tableName));
    }

    private void initConnection() throws SQLException, ClassNotFoundException {
        Class.forName(properties.getProperty("connection.driver_class"));
        String url = properties.getProperty("connection.url");
        String login = properties.getProperty("connection.username");
        String password = properties.getProperty("connection.password");
        connection = DriverManager.getConnection(url, login, password);
    }

    public void createTable(String tableName) throws SQLException {
        try (Statement statement = getStatement()) {
            String sql = String.format("create table if not exists %s()", tableName);
            statement.execute(sql);
        }
    }

    public void dropTable(String tableName) throws SQLException {
        try (Statement statement = getStatement()) {
            String sql = String.format("drop table if exists %s", tableName);
            statement.execute(sql);
        }
    }

    public void addColumn(String tableName, String columnName, String type) throws SQLException {
        try (Statement statement = getStatement()) {
            String sql = String.format("alter table %s add column %s %s", tableName, columnName, type);
            statement.execute(sql);
        }
    }

    public void dropColumn(String tableName, String columnName) throws SQLException {
        try (Statement statement = getStatement()) {
            String sql = String.format("alter table %s drop column %s", tableName, columnName);
            statement.execute(sql);
        }
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) throws SQLException {
        try (Statement statement = getStatement()) {
            String sql = String.format("alter table %s rename column %s to %s", tableName, columnName, newColumnName);
            statement.execute(sql);
        }
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }

    private Statement getStatement() throws SQLException {
        return connection.createStatement();
    }
}
