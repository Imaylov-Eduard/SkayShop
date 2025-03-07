package org.skypro.skyshop.search;

import java.util.*;

public class SearchEngine {
    private final Set<Searchable> searchables;

    public SearchEngine() {
        this.searchables = new HashSet<>();
    }

    public void add(Searchable searchable) {
        searchables.add(searchable);
    }

    public Set<Searchable> search(String query) {
        Set<Searchable> results = new TreeSet<>(new SearchableComparator());
        for (Searchable searchable : searchables) {
            if (searchable != null && searchable.getSearchTerm().contains(query)) {
                results.add(searchable);
            }
        }
        return results;
    }

    public Searchable findBestMatch(String query) throws BestResultNotFound {
        Searchable bestMatch = null;
        int maxCount = 0;

        for (Searchable searchable : searchables) {
            if (searchable != null) {
                String searchTerm = searchable.getSearchTerm();
                int count = countSubstringOccurrences(searchTerm, query);
                if (count > maxCount) {
                    maxCount = count;
                    bestMatch = searchable;
                }
            }
        }

        if (bestMatch == null) {
            throw new BestResultNotFound("Не найдено подходящего результата для запроса: " + query);
        }

        return bestMatch;
    }

    private int countSubstringOccurrences(String str, String substring) {
        int count = 0;
        int index = 0;
        while ((index = str.indexOf(substring, index)) != -1) {
            count++;
            index += substring.length();
        }
        return count;
    }

    private static class SearchableComparator implements Comparator<Searchable> {
        @Override
        public int compare(Searchable s1, Searchable s2) {
            int lengthComparison = Integer.compare(s2.getName().length(), s1.getName().length());
            if (lengthComparison != 0) {
                return lengthComparison;
            }
            return s1.getName().compareTo(s2.getName());
        }
    }
}