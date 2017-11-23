package com.example.shbae.tddsample;


import android.support.annotation.NonNull;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by shbae on 2017-11-23.
 */

public class SortTest {

    @Test
    public void sortings() throws Exception {
        assertSorted(intList(), intList());
        assertSorted(intList(1), intList(1));
        assertSorted(intList(2, 1), intList(1, 2));
        assertSorted(intList(1, 3, 2), intList(1, 2, 3));
        assertSorted(intList(3, 2, 1), intList(1, 2, 3));
    }

    private void assertSorted(List<Integer> unsorted, List<Integer> sorted) {
        assertThat(sort(unsorted), is(sorted));
    }

    @NonNull
    private List<Integer> intList(Integer... ints) {
        return Arrays.asList(ints);
    }

    private List<Integer> sort(List<Integer> list) {

        for (int index = 0; index < list.size() - 1; index++)
            if (outOfOrder(list, index))
                swep(list, index);

        return list;
    }

    private boolean outOfOrder(List<Integer> list, int index) {
        return list.get(index) > list.get(index + 1);
    }

    private void swep(List<Integer> list, int index) {
        int temp = list.get(index);
        list.set(index, list.get(index + 1));
        list.set(index + 1, temp);
    }

}
