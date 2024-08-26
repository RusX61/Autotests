package utils;

import com.google.gson.Gson;
import model.SendPageDataItem;
import org.openqa.selenium.json.TypeToken;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class DataProvider {

    private DataProvider() {
    }

    public static Iterator<Object[]> sendPageTestData() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/sendPageData.json"))) {
            String json = "";
            String line = reader.readLine();
            while (line != null) {
                json += line;
                line = reader.readLine();
            }
            Gson gson = new Gson();
            List<SendPageDataItem> sendPageDataItem = gson.fromJson(json, new TypeToken<List<SendPageDataItem>>() {
            }.getType());
            return sendPageDataItem.stream().map((g) -> new Object[]{g}).toList().iterator();
        }
    }
}