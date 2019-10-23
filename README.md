# Wildlife Tracker
Spark application that allows users to input endangered animals and thriving or normal animals then submit sightings containing locations and the ranger name.
## Author

* **Atemba Emmanuel** 


## Demo
[View Demo Here](https://www.figma.com/file/6Rn3RY4SLzjzIJmSFwF38z/wildlife_traceker?node-id=0%3A1)


## Getting Started

Clone this repository to your local machine to get Started

Github: [https://github.com/atembamanu/wildlife_tracker.git](https://github.com/atembamanu/wildlife_tracker.git)

### Prerequisites

You need the following installed on your machine
- java
- JDK - Java Development Kit
- Maven
- Gradle
- An IDE - Intellij


To confirm run the following command on linux
```
$ java --version       //java version
$ mvn --version        //maven version
$ gradle --version     //gradle version
```

## Installing

After cloning to your local machine navigate to the folder you cloned into and open it with intellij.
* Navigate into the ``` src/main/java/App.java ``` and click run in intellij.
* Go to your browser and type ``` localhost:4567 ```

## Running the Tests 

Create a test class for running tests in the application.

This is a sample test that tests if the getter method works

```
   @Test
    public void find_findSightingWithId_true(){
        Sighting sighting1 = newSightingHelper();
        Sighting sighting2 = newSightingHelper2();
        sighting1.saveSighting();
        sighting2.saveSighting();
        assertEquals(Sighting.find(sighting2.getId()), sighting2);
    }

```

Create Credentials file to store your username and pass

```
public class Credentials {
    public static final String username = "username";
    public static final String pass = "passs!";
}

```
creating tables in PgAdmin4

```
CREATE TABLE public.sightings
(
    id integer NOT NULL DEFAULT nextval('sightings_id_seq'::regclass),
    location character varying COLLATE pg_catalog."default",
    rangername character varying COLLATE pg_catalog."default",
    animalid integer,
    datespotted timestamp without time zone,
    CONSTRAINT sightings_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)

CREATE TABLE public.animals
(
    id integer NOT NULL DEFAULT nextval('animals_id_seq'::regclass),
    name character varying COLLATE pg_catalog."default",
    health character varying COLLATE pg_catalog."default",
    age character varying COLLATE pg_catalog."default",
    dateadded timestamp without time zone,
    type character varying COLLATE pg_catalog."default",
    CONSTRAINT animals_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
```

## Built With

* [Java](https://www.java.com/) - The language used
* [Intellij Idea](https://www.jetbrains.com/idea/) - Intergated development
* [Spark]() - Framework


## Contributing
If you want to put out a pull request you first have to send us the sample code that you want to add to our repository for cross-checking before we allow the pull.

## Versioning

We use [Github](https://github.com/) for versioning. This is the first version of this application

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details
