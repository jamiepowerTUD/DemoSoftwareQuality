package SQA;

import org.junit.Test;

import static org.junit.Assert.*;

public class DSQTestUnit
{


    @Test
    public void testNewRubric()
    {
        Controller c = new Controller();
        Rubric rubric = c.addRubric("test");
        assertNotNull(rubric);
    }

    @Test
    public void testNewCriterion()
    {
        Controller c = new Controller();
        Criterion criterion = c.createCriterion("test");
        assertNotNull(criterion);
    }

    @Test
    public void gradeStudent()
    {
        Controller c = new Controller();
        String name = "student" ;
        Rubric rubric = new Rubric("test");
        assertNotNull(c.addGrade(name, rubric));
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

    @Test
    public void testAddCriterionToFullRubric()
    {
        Controller c = new Controller();
        Rubric rub = new Rubric("test");
        c.rubrics.add(rub);

        for(int i = 0 ; i < 10 ; i ++)
        {
            c.addCriterion("test","test");
        }
        assertEquals("Rubric Full",c.addCriterion("test","test"));
    }


    @Test
    public void testAddCriterionToNoRubric()
    {
        Controller c = new Controller();
        assertEquals("Rubric not found",c.addCriterion("test","test"));
    }

    @Test
    public void testInputIsString()
    {
        Controller c = new Controller();
        assertTrue(c.validateString("test"));
    }

    @Test
    public void testInputIsNotStringWithInt()
    {
        Controller c = new Controller();
        assertFalse(c.validateString("032"));
    }

    @Test
    public void testInputIsNotStringWithDouble()
    {
        Controller c = new Controller();
        assertFalse(c.validateString("0.3"));
    }


    @Test
    public void testInputWithEmptyString()
    {
        Controller c = new Controller();
        assertFalse(c.validateString(""));
    }

    @Test
    public void validateScorePass()
    {
        Controller c = new Controller();
        assertTrue(c.validateScore("3"));
    }

    @Test
    public void validateScoreFail()
    {
        Controller c = new Controller();
        assertFalse(c.validateScore("0"));
    }

    @Test
    public void validateScoreWithString()
    {
        Controller c = new Controller();
        assertFalse(c.validateScore("test"));
    }

    @Test
    public void testListAllRubrics()
    {
        Controller c = new Controller();
        assertEquals(c.rubrics,c.listAllRubrics());
    }

    @Test
    public void testListAllRubricsBySize()
    {
        Controller c = new Controller();
        c.addRubric("test");
        assertEquals(1,c.listAllRubrics().size());
    }



    @Test
    public void testListAllGrades()
    {
        Controller c = new Controller();
        assertEquals(c.grades,c.listAllGrades());
    }

    @Test
    public void testListAllGradesBySize()
    {
        Controller c = new Controller();
        c.addGrade("test",new Rubric("test"));
        assertEquals(1,c.listAllGrades().size());
    }









}
