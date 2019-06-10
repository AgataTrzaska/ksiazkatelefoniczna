package app.commons;

public interface Mapper<F, T> {

    T map(F from);
    F reverse(T to);
}