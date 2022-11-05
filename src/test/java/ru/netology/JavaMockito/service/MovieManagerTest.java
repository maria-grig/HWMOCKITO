package ru.netology.JavaMockito.service;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import ru.netology.JavaMockito.sevice.MovieManager;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MovieManagerTest {

    @Test
    public void shouldShowAllMovies() {
        MovieManager manager = new MovieManager();
        manager.add("first");
        manager.add("second");
        manager.add("third");

        String[] expected = {"first", "second", "third"};
        String[] actual = manager.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowLastMovies() {
        MovieManager manager = new MovieManager(10);
        manager.add("first");
        manager.add("second");
        manager.add("third");
        String[] expected = {"third", "second", "first"};
        String[] actual = manager.findLast();
        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldShowLastMoviesIfMoviesMoreLimits() {
        MovieManager manager = new MovieManager(10);
        manager.add("1");
        manager.add("2");
        manager.add("3");
        manager.add("4");
        manager.add("5");
        manager.add("6");
        manager.add("7");
        manager.add("8");
        manager.add("9");
        manager.add("10");
        manager.add("11");
        String[] expected = {"11", "10", "9", "8", "7", "6", "5", "4", "3", "2"};
        String[] actual = manager.findLast();
        assertArrayEquals(expected, actual);
    }
}
