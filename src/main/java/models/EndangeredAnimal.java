package models;

import db.DB;
import helpers.Endangered;
import helpers.WildAnimals;
import org.sql2o.Connection;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class EndangeredAnimal extends WildAnimals implements Endangered {

    public static final String DATABASE_TYPE = "endangeredAnimal";

    public EndangeredAnimal(String name, String health, String age) {
        this.name = name;
        this.dateAdded = new Timestamp(new Date().getTime());
        this.health = health;
        this.age = age;
        type = DATABASE_TYPE;
    }

    public static String getDatabaseType() {
        return DATABASE_TYPE;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Timestamp dateAdded) {
        this.dateAdded = dateAdded;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EndangeredAnimal)) return false;
        EndangeredAnimal that = (EndangeredAnimal) o;
        return getId() == that.getId() &&
                getName().equals(that.getName()) &&
                getDateAdded().equals(that.getDateAdded()) &&
                getHealth().equals(that.getHealth()) &&
                getAge().equals(that.getAge());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getDateAdded(), getHealth(), getAge());
    }

    @Override
    public void saveEndangered() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO animals (name, health, age, dateadded, type) VALUES (:name, :health, :age, :timestamp, :type) ";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("name", getName())
                    .addParameter("health", getHealth())
                    .addParameter("age", getAge())
                    .addParameter("type", type)
                    .addParameter("timestamp", getDateAdded())
                    .executeUpdate()
                    .getKey();
        }

    }

    public static List<EndangeredAnimal> getEndangeredAnimals() {
        String sql = "SELECT * FROM animals WHERE type =:type;";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("type", getDatabaseType())
                    .executeAndFetch(EndangeredAnimal.class);
        }
    }

    @Override
    public int getId() {
        return id;
    }

    public static EndangeredAnimal find(int id) {
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM animals where id =:id;";
            return con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(EndangeredAnimal.class);
        }
    }
}
