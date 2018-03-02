package hu.gaborbalazs.cyberdojo;

import java.util.List;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;

public class AnagramsTest {

    private Anagrams anagrams;
    
    @Before
    public void setUp() {
        anagrams = new Anagrams();
    }
    
    @Test
    public void test() {
        List<String> retval = anagrams.getAnagrams("");
        assertEquals(retval.size(), 0);
    }
}
