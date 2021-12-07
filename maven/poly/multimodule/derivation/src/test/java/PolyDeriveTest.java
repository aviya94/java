import static org.junit.jupiter.api.Assertions.*;

class PolyDeriveTest {
private PolyDerive polyDerive;
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        polyDerive=new PolyDerive();
    }

    @org.junit.jupiter.api.Test
    void derive() {
        Polynomial result =polyDerive.derive(new Polynomial(5,3,8,3));
        System.out.println(result);
    }
}