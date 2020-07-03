package de.dhbwka.studentenfutter.servlets;

import de.dhbwka.studentenfutter.bean.RecipeSearchResultBean;
import de.dhbwka.studentenfutter.search.RecipeSearchSelector;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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

            @Override
            public int getPriority() {
                return 3;
            }
        });
        selectors.add(new RecipeSearchSelector(".*", "name", "Rezepte") {
            @Override
            protected String toSQLPattern(String search) {
                return "%" + search + "%";
            }

            @Override
            public int getPriority() {
                return 0;
            }
        });
        selectors.add(new RecipeSearchSelector("(\\w|\u00E4|\u00C4|\u00F6|\u00D6|\u00FC|\u00DC)*", "category", "Kategorien") {
            @Override
            protected String toSQLPattern(String search) {
                return "%" + search + "%";
            }

            @Override
            public int getPriority() {
                return 1;
            }
        });
        selectors.add(new RecipeSearchSelector(".*", "author", "Autoren") {
            @Override
            protected String toSQLPattern(String search) {
                return "%" + search + "%";
            }

            @Override
            public int getPriority() {
                return 2;
            }
        });
    }

    @Override
    protected void handleDoGet(HttpServletRequest req, HttpServletResponse res) throws Exception {
        var search = req.getParameter("search").stripLeading().stripTrailing();

        var access = getDataAccess();
        var recipesSearchResult = selectors.stream()
                .filter(selector -> selector.matches(search))
                .sorted(Comparator.comparing(RecipeSearchSelector::getPriority))
                .map(selector -> new RecipeSearchResultBean(selector.getPrettyColumnName(), selector.select(access, search)))
                .filter(searchResult -> !searchResult.getRecipeCards().isEmpty())
                .collect(Collectors.toList());

        req.setAttribute("search", search);
        req.setAttribute("recipeSearchResult", recipesSearchResult);
        req.getRequestDispatcher("/jsp/recipes_list.jsp").forward(req, res);
    }
}
