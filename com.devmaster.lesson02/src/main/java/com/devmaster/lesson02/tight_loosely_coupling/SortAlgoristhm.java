package com.devmaster.lesson02.tight_loosely_coupling;

import java.util.Arrays;

public interface SortAlgoristhm {
    void sort(int[] arr);
}


class  LooselyBubbleSortAlgoristhm implements SortAlgoristhm {

    @Override
    public void sort(int[] arr) {
        System.out.println("Sorted ...");
        Arrays.stream(arr).sorted().forEach(System.out::println);
    }
}