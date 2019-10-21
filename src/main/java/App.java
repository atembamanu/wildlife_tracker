import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;

import static spark.Spark.get;
import static spark.Spark.staticFileLocation;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");

        get("/", (req, res)-> new ModelAndView(new HashMap<>(), "index.hbs"), new HandlebarsTemplateEngine());
    }
}
