import model.Course;
import model.Professor;
import model.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //System.out.println("Hello world!");

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
        EntityManager manager = factory.createEntityManager();

        Course course1 = new Course("Algebra", 6);
        Course course2 = new Course("Geometrie", 6);

        Professor professor = new Professor("john", Arrays.asList(course1, course2));

        Student student1 = new Student("istvan");
        student1.addCourse(course1);
        student1.addCourse(course2);

        manager.getTransaction().begin();

       // manager.persist(student1);

        //save an entity
        //manager.persist(professor);

        //run a sql query
//        Query query = manager.createNativeQuery("select id, ects, name from course where name=:course_name", Course.class);
//        query.setParameter("course_name", "DB");
//        Course foundCourse = (Course) query.getSingleResult();
//        System.out.println(foundCourse.toString());

        //update an entity
//        Query query = manager.createNativeQuery("select id, ects, name from course where name=:course_name", Course.class);
//        query.setParameter("course_name", "DB");
//        Course foundCourse = (Course) query.getSingleResult();
//        foundCourse.setName("DB2");

        Course course = manager.find(Course.class, 2); //find by id
        manager.remove(course); //delete an entity


        System.out.println(course.toString());

        manager.getTransaction().commit();
    }


}