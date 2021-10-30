package parser;

public interface Parser<T> {
    T parser(String line);
}
