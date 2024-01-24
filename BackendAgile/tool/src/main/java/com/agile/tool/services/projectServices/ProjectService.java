package com.agile.tool.services.projectServices;


import com.agile.tool.entities.Project;
import com.agile.tool.repositories.ProjectRepository;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project saveProject(Project project) throws BadRequestException {
        if (project.getCompanyName() == null || project.getCompanyName().isEmpty()) {
            throw new BadRequestException("Company is required");
        }
        return projectRepository.save(project);
    }


}
