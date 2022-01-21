package es.ulpgc.dis;

import java.util.*;

public class Project {
    private final String name;
    private final ProjectManager projectManager;

    public Project(String name, ProjectManager projectManager) {
        this.name = name;
        this.projectManager = projectManager;
    }

    public Map<String, Integer> getWorkLoadProjects(List<Project> projects) {
        Map<String, Integer> workLoadProjects = new HashMap<String, Integer>();
        for (Project project: projects) {
            int workLoad = 0;
            workLoad += project.projectManager.getWorkLoad();
            List<Developer> managedTeam = project.projectManager.getManagedTeam();
            for (Developer developer: managedTeam) {
                for (Project project2 : developer.getProjects()) {
                    if (project.name.equals(project2.name)) {
                        workLoad += developer.getWorkLoad();
                    }
                }
            }
            workLoadProjects.put(project.name, workLoad);
        }
        return workLoadProjects;
    }

}
