import java.math.BigDecimal;
import java.math.MathContext;

public class CurrencyConverter {

    public BigDecimal Convert(Currency from, Currency to, BigDecimal amount) {
        var res = amount.multiply(from.rate().divide(to.rate(), MathContext.DECIMAL128));
        return res;
    }
}
