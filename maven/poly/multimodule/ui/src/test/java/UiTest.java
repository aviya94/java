import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UiTest {
private Ui ui;
    @BeforeEach
    void setUp() {
        ui=new Ui();
    }

    @Test
    void runUi() {
        ui.runUi();
    }
}