package perso.challenges.crackthecode.arraysandstring;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

/**
 * User: sennen
 * Date: 01/05/2014
 * Time: 22:07
 */
public class StringsTest {
    @Test
    public void testNotUnique() throws Exception {
        assertFalse(Strings.hasOnlyUniqueChars("abccdI"));
    }

    @Test
    public void testUnique() throws Exception {
        assertTrue(Strings.hasOnlyUniqueChars("abcde"));
    }

    @Test
    public void testReverse() throws Exception {
        assertEquals("edcba", Strings.reverse("abcde"));
        assertEquals("gfedcba", Strings.reverse("abcdefg"));
        assertEquals("hgfedcba", Strings.reverse("abcdefgh"));
    }

    @Test
    public void testDeleteDuplicate() throws Exception {
        assertEquals("abcdI", Strings.removeDuplicate("aaaabccdI"));
        assertEquals("abcde", Strings.removeDuplicate("abcde"));
    }

    @Test
    public void testAnagrams() throws Exception {
        assertFalse(Strings.areAnagrams("abcdI", null));
        assertFalse(Strings.areAnagrams(null, "aaaabccdI"));
        assertFalse(Strings.areAnagrams(null, null));
        assertFalse(Strings.areAnagrams("abcdI", "aaaabccdI"));
        assertFalse(Strings.areAnagrams("ercba", "abcde"));
        assertTrue(Strings.areAnagrams("edcba", "abcde"));
    }

    @Test
    public void testIsRotation() throws Exception {
        assertTrue(Strings.areRotations ("waterbottle", "erbottlewat"));
        assertFalse(Strings.areRotations ("watrbottle", "erbolewat"));
    }
}
