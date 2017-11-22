package com.example.shbae.tddsample;

import android.support.annotation.NonNull;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


/**
 * Created by shbae on 2017-11-22.
 */

public class NamerInverterTest {
    @Test
    public void given_null___returns_empty_string() throws Exception {
        assertThat(invert(null), is(""));
    }

    @Test
    public void given_simple_name___returns_simple_name() throws Exception {
        assertThat(invert("Name"), is("Name"));
    }

    @Test
    public void given_first_last___returns_last_first() throws Exception {
        assertThat(invert("First Last"), is("Last, First"));
    }

    @Test
    public void given_simple_name_with_leading_spaces___returns_simple_name() throws Exception {
        assertThat(invert(" Name"), is("Name"));
    }

    @Test
    public void given_first_last_with_multiple_spaces_between___returns_last_first() throws Exception {
        assertThat(invert("First   Last"), is("Last, First"));
    }

    @Test
    public void given_honorific_and_first_last___returns_last_first() throws Exception {
        assertThat(invert("Mr. First Last"), is("Last, First"));
        assertThat(invert("Mrs. First Last"), is("Last, First"));
    }

    @Test
    public void given_post_nominals_exists___post_nominals_stays_at_end() throws Exception {
        assertThat(invert("First Last Sr."), is("Last, First Sr."));
        assertThat(invert("First Last BS. Phd."), is("Last, First BS. Phd."));
    }

    @Test
    public void integrated_case() throws Exception {
        assertThat(invert("   Rober Martin III esq.  "), is("Martin, Rober III esq."));
    }

    private String invert(String name) {
        return new NameInverter(name).invoke();
    }

    private class NameInverter {
        private String name;

        public NameInverter(String name) {
            this.name = name;
        }

        public String invoke() {
            if (name == null || name.isEmpty())
                return "";

            List<String> names = removeHonorifics(name);
            if (names.size() == 1)
                return names.get(0);

            if (names.size() == 2 )
                return String.format("%s, %s", names.get(1), names.get(0));

            String postNominal = getPostNominals(names);
            return String.format("%s, %s %s", names.get(1), names.get(0), postNominal.trim());
        }

        private boolean isHonorific(String names) {
            //return names.equals("Mr.") || names.equals("Mrs.");
            return names.matches("Mr\\.|Mrs\\.");
        }

        @NonNull
        private ArrayList<String> splitNames(String name) {
            return new ArrayList<>(Arrays.asList(name.trim().split("\\s+")));
        }

        @NonNull
        private List<String> removeHonorifics(String name) {
            List<String> names = splitNames(name);
            if (names.size() > 1 && isHonorific(names.get(0)))
                names.remove(0);
            return names;
        }

        @NonNull
        private String getPostNominals(List<String> names) {
            String postNominal = "";
            for (int i = 2; i < names.size(); i++) {
                postNominal += " " + names.get(i);
            }
            return postNominal;
        }
    }
}
