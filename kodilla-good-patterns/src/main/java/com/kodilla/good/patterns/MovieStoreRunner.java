package com.kodilla.good.patterns;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MovieStoreRunner {
    public static void main(String[] args) {
        Map<String, List<String>> moviesWithTranslations = MovieStore.getMovies();
//version 1
        String result = moviesWithTranslations.entrySet()
                .stream()
                .map(title -> title.getKey() + "!" + title.getValue().stream().collect(Collectors.joining("!")))
                .collect(Collectors.joining("!"));
        System.out.println(result);
//version 2
        System.out.println();
        moviesWithTranslations.entrySet()
                .stream()
                .map(title -> title.getKey() + "!" + title.getValue().stream().collect(Collectors.joining("!")))
                .forEach(System.out::println);
    }
}
