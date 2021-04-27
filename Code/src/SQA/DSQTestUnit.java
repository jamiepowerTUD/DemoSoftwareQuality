package SQA;

import org.junit.Test;

import static org.junit.Assert.*;

public class DSQTestUnit
{



    @Test
    public void testNewRubric()
    {
        Rubric rubric = new Rubric("test");
        assertTrue(rubric instanceof Rubric);
    }

    @Test
    public void testNewCriterion()
    {
        Criterion criterion = new Criterion("test",5);
        assertTrue(criterion instanceof Criterion);
    }

    @Test
    public void testGetRubric()
    {
        Controller c = new Controller();
        Rubric rub = new Rubric("test");
        c.rubrics.add(rub);
        assertEquals(rub, c.getRubricbyName("test"));
    }

    @Test
    public void testGetRubricFail()
    {
        Controller c = new Controller();
        Rubric rub = new Rubric("test");
        c.rubrics.add(rub);
        assertNull(c.getRubricbyName("fail"));
    }

    @Test
    public void testAddCriterion()
    {
        Controller c = new Controller();
        Rubric rub = new Rubric("test");
        c.rubrics.add(rub);
        assertEquals("Criteria Added",c.addCriterion("test","test"));
    }







}
