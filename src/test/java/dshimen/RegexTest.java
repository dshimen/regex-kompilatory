package dshimen;

import org.junit.Assert;
import org.junit.Test;

import static dshimen.Main.analyzeString;

public class RegexTest {
    @Test
    public void regexTest(){
        //(aa)*bb(a|b)(a)?
        Assert.assertTrue(analyzeString("aabbaa"));
        Assert.assertTrue(analyzeString("aabba"));
        Assert.assertTrue(analyzeString("aabbb"));
        Assert.assertTrue(analyzeString("aaaabbaa"));
        Assert.assertTrue(analyzeString("aaaaaabbaa"));
        Assert.assertTrue(analyzeString("aaaaaabbb"));
        Assert.assertTrue(analyzeString("aaaaaabba"));
        Assert.assertTrue(analyzeString("aaaaaabbba"));
        Assert.assertTrue(analyzeString("aaaaaabbaa"));
        Assert.assertFalse(analyzeString("abbaa"));
        Assert.assertFalse(analyzeString("aabaa"));
        Assert.assertFalse(analyzeString("aabbbb"));
        Assert.assertFalse(analyzeString("baabbaa"));
        Assert.assertFalse(analyzeString("aabbaab"));
        Assert.assertFalse(analyzeString("aabbbbbb"));
        Assert.assertFalse(analyzeString("aaaaaaaaaa"));
        Assert.assertFalse(analyzeString("bbbbbbb"));
        Assert.assertFalse(analyzeString("kompilatory"));
        Assert.assertFalse(analyzeString("uksw"));
        System.out.println("Testy przebiegly poprawnie");
    }
}
