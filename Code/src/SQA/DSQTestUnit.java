package SQA;

import org.junit.Test;

import java.util.ArrayList;

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

    @Test
    public void testGetGradesByRubricName()
    {
        Controller c = new Controller();
        c.addGrade("test",new Rubric("test"));
        assertEquals(1,c.getGradesByRubricName("test").size());
    }

    @Test
    public void testGetGradesByRubricNameNotFound()
    {
        Controller c = new Controller();
        c.addGrade("test",new Rubric("test"));
        assertTrue(c.getGradesByRubricName("fail").isEmpty());
    }

    @Test
    public void testRubricSummary()
    {
        Controller c = new Controller();
        Rubric init = new Rubric("Code");
        init.criteria.add(new Criterion("Design",0));
        init.criteria.add(new Criterion("Implementation",0));
        init.criteria.add(new Criterion("Documentation",0));
        init.criteria.add(new Criterion("Testing",0));

        c.rubrics.add(init);

        Rubric initRubric = new Rubric("Code");
        ArrayList<Criterion> initGrade =  new ArrayList<Criterion>();
        initGrade.add(new Criterion("Design",2));
        initGrade.add(new Criterion("Implementation",4));
        initGrade.add(new Criterion("Testing",4));
        initGrade.add(new Criterion("Documentation",2));
        initRubric.setCriteria(initGrade);
        c.grades.add(new Grade("Stephen Byrne",initRubric));

        assertEquals(3.0,c.getRubricScoreAverage("Code"),0.1);
        assertEquals(2,c.getRubricMin("Code"));
        assertEquals(4,c.getRubricMax("Code"));
        assertEquals(1.0,c.getRubricStdDev("Code"),1);

    }

    @Test
    public void testCriterionSummary()
    {
        Controller c = new Controller();
        Rubric init = new Rubric("Code");
        init.criteria.add(new Criterion("Design",0));
        init.criteria.add(new Criterion("Implementation",0));
        init.criteria.add(new Criterion("Documentation",0));
        init.criteria.add(new Criterion("Testing",0));

        c.rubrics.add(init);

        Rubric initRubric = new Rubric("Code");
        ArrayList<Criterion> initGrade =  new ArrayList<Criterion>();
        initGrade.add(new Criterion("Design",2));
        initGrade.add(new Criterion("Implementation",4));
        initGrade.add(new Criterion("Testing",4));
        initGrade.add(new Criterion("Documentation",2));
        initRubric.setCriteria(initGrade);
        c.grades.add(new Grade("Stephen Byrne",initRubric));

        assertEquals(2.0,c.getCriteriaAvg("Design"),1);
        assertEquals(2,c.getCriterionMin("Design"));
        assertEquals(2,c.getCriterionMax("Design"));
        assertEquals(0.0,c.getCriterionStdDev("Design"),1);

    }















}
