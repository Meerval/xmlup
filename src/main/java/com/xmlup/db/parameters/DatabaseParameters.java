package com.xmlup.db.parameters;

public class DatabaseParameters {
    private final String CONNECTION_URL;
    private final String USERNAME;
    private final String PASSWORD;

    public DatabaseParameters(String connectionUrl, String username, String password) {
        this.CONNECTION_URL = connectionUrl;
        this.USERNAME = username;
        this.PASSWORD = password;
    }

    public String getUsername() {
        return USERNAME;
    }

    public String getPassword() {
        return PASSWORD;
    }

    public String getConnectionUrl() {
        return CONNECTION_URL;
    }


    @Override
    public String toString() {
        return "Database{" +
                "connectionUrl='" + CONNECTION_URL + '\'' +
                ", username='" + USERNAME + '\'' +
                ", password='" + PASSWORD + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DatabaseParameters that = (DatabaseParameters) o;

        if (!getConnectionUrl().equals(that.getConnectionUrl())) return false;
        if (!getUsername().equals(that.getUsername())) return false;
        return getPassword().equals(that.getPassword());
    }

    @Override
    public int hashCode() {
        int result = getConnectionUrl().hashCode();
        result = 31 * result + getUsername().hashCode();
        result = 31 * result + getPassword().hashCode();
        return result;
    }
}
