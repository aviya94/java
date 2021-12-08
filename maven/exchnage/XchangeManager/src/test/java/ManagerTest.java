import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {
    private Manager manager;

    @BeforeEach
    void setUp() {
        manager = new Manager("IL");
    }

    @Test
    void convert() {
        var res = manager.convert("USD", "EUR", new BigDecimal(100));
        System.out.println(res);
    }
}