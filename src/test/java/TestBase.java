import manager.ApplicationManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.IOException;

public class TestBase {
    protected final ApplicationManager applicationManager = new ApplicationManager();

    @BeforeEach

    public void setupPage() throws InterruptedException, IOException {

        applicationManager.init();

    }

    @AfterEach

    public void closePage() {

       applicationManager.close();

    }
}
