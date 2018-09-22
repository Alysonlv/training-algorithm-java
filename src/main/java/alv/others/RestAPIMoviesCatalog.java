package alv.others;
/*
 * Created by Alyson Vasconcelos - 20/05/2018
 */

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class RestAPIMoviesCatalog {

    public static void main(String[] args) {
        String[] titles = getMovieTitles("Spiderman");

        for (String title : titles) {
            System.out.println(title);
        }
    }

    /*
    https://jsonmock.hackerrank.com/api/movies/search/?Title=spiderman&page=2
     */

    /*
     * Complete the function below.
     */

    class Movie {
        String Poster;
        String Title;
        String Type;
        int Year;
        String imdbID;
    }


    class Catalog {
        int page;
        int per_page;
        int total;
        int total_pages;

        List<Movie> data;
    }

    static String builtAddress(String title, int page) {
        StringBuilder address = new StringBuilder("https://jsonmock.hackerrank.com/api/movies/search/?Title=");
        address.append(title);
        address.append("&page=").append(page);

        return address.toString();
    }

    static Catalog getCatalog(String substr, int page) {
        Catalog catolog = null;
        String address = builtAddress(substr, page);

        try {

            URL url = new URL(address);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String output = br.readLine();


            if (output != null) {
                Gson gson = new Gson();
                catolog = gson.fromJson(output, Catalog.class);
            }

            conn.disconnect();

        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }

        return catolog;
    }

    static String[] getMovieTitles(String substr) {
        Catalog catalog =  getCatalog(substr, 1);
        List<String> titles = new ArrayList<>();

        if (catalog != null) {
            titles = new ArrayList<>();
            builtListTitles(titles, catalog.data);

            if (catalog.total_pages > 1) {
                for (int i = 2; i <= catalog.total_pages; i++) {
                    catalog = getCatalog(substr, i);

                    builtListTitles(titles, catalog.data);
                }
            }

        }

        Collections.sort(titles);

        return titles.toArray(new String[titles.size()]);

    }

    static void builtListTitles(List<String> titles, List<Movie> movies) {
        for(Movie data : movies) {
            titles.add(data.Title);
        }
    }

}
