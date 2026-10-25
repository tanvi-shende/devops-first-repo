package app.webapp;

import org.junit.Test;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.Assert.assertTrue;

public class WebPageTest {

    @Test
    public void indexPageShouldExistAndNotBeEmpty() throws Exception {
        Path page = Path.of("src/main/webapp/index.html");

        assertTrue("index.html must exist", Files.exists(page));
        assertTrue("index.html must not be empty",
                   Files.size(page) > 0);
    }
}
