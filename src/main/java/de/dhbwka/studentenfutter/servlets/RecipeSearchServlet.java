package de.dhbwka.studentenfutter.servlets;

import de.dhbwka.studentenfutter.bean.RecipeSearchResultBean;
import de.dhbwka.studentenfutter.search.RecipeSearchSelector;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/recipes")
public class RecipeSearchServlet extends AbstractServlet {
    List<RecipeSearchSelector> selectors;

    @Override
    public void init() {
        selectors = new ArrayList<>();
        selectors.add(new RecipeSearchSelector("\\d{1,9}", "id_recipe", "ID's") {
            @Override
            protected String toSQLPattern(String search) {
                return search;
            }
        });
        selectors.add(new RecipeSearchSelector(".*", "name", "Namen") {
            @Override
            protected String toSQLPattern(String search) {
                return "%" + search + "%";
            }
        });
        selectors.add(new RecipeSearchSelector("\\w*", "category", "Kategorien") {
            @Override
            protected String toSQLPattern(String search) {
                return "%" + search + "%";
            }
        });
        selectors.add(new RecipeSearchSelector("\\w*", "author", "Autoren") {
            @Override
            protected String toSQLPattern(String search) {
                return "%" + search + "%";
            }
        });
    }

    @Override
    protected void handleDoGet(HttpServletRequest req, HttpServletResponse res) throws Exception {
        var search = req.getParameter("search").stripLeading().stripTrailing();
        var recipesSearchResult = new ArrayList<>();
        var access = getDataAccess();
        selectors.stream()
                .filter(selector -> selector.matches(search))
                .forEach(selector -> {
                    var recipes = selector.select(access, search);
                    if (!recipes.isEmpty()) {
                        recipesSearchResult.add(
                                new RecipeSearchResultBean(selector.getPrettyColumnName(), recipes));
                    }
                });

        req.setAttribute("search", search);
        req.setAttribute("recipeSearchResult", recipesSearchResult);
        req.getRequestDispatcher("/jsp/recipes_list.jsp").forward(req, res);
    }
}
