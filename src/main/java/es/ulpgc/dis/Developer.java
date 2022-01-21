package es.ulpgc.dis;

import java.util.ArrayList;
import java.util.List;

public class Developer {
    private final String firstName;
    private final String lastName;
    private List<Project> projects;
    private int workLoad;

    public Developer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.projects = new ArrayList<Project>();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public int getWorkLoad() {
        return workLoad;
    }

    public void setWorkLoad(int workLoad) {
        this.workLoad = workLoad;
    }

    public void addProject(Project project){
        this.projects.add(project);
    }
}
