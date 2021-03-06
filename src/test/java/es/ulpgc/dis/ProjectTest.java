package es.ulpgc.dis;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static es.ulpgc.dis.Project.getWorkLoadProjects;
import static org.junit.Assert.assertEquals;

public class ProjectTest {

    @Test
    public void test_zero()
    {
        ProjectManager projectManager0 = new ProjectManager();
        ProjectManager projectManager1 = new ProjectManager();

        Project projectA = new Project("Project A", projectManager0);
        Project projectB = new Project("Project B", projectManager1);

        Developer developer0 = new Developer("Jessica", "Jones");
        developer0.setWorkLoad((int) (1800.0 * 0.75 * 0.5)); // part time 75% in two projects
        developer0.addProject(projectA);
        developer0.addProject(projectB);

        Developer developer1 = new Developer("Charlie", "Taylor");
        developer1.setWorkLoad(1800); // full time in one project
        developer1.addProject(projectA);

        Developer developer2 = new Developer("William", "Brown");
        developer2.setWorkLoad((int) (1800.0 * 0.5)); // full time in two projects
        developer2.addProject(projectA);
        developer2.addProject(projectB);

        Developer developer3 = new Developer("Sophie", "Wilson");
        developer3.setWorkLoad((int) (1800.0 * 0.5)); // part time 50%
        developer3.addProject(projectB);

        Developer developer4 = new Developer("Emily", "Yhomas");
        developer4.setWorkLoad((int) (1800.0 * 0.5)); // part time 50% in one project
        developer4.addProject(projectB);


        projectManager0.setWorkLoad(1800); // full time in one project
        projectManager0.setFirstName("James");
        projectManager0.setLastName("Johnson");
        projectManager0.addManagedDeveloper(developer0);
        projectManager0.addManagedDeveloper(developer1);
        projectManager0.addManagedDeveloper(developer2);


        projectManager1.setWorkLoad((int) (1800.0 * 0.5)); // part time 50% in one project
        projectManager1.setFirstName("Isabella");
        projectManager1.setLastName("Smith");
        projectManager1.addManagedDeveloper(developer0);
        projectManager1.addManagedDeveloper(developer2);
        projectManager1.addManagedDeveloper(developer3);
        projectManager1.addManagedDeveloper(developer4);

        List<Project> projects = new ArrayList<Project>();
        projects.add(projectA);
        projects.add(projectB);

        Map<String, Integer> workLoadProjects = getWorkLoadProjects(projects);

        assertEquals(5175, (int) workLoadProjects.get("Project A"));
        assertEquals(4275, (int) workLoadProjects.get("Project B"));
    }

}