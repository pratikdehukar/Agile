package com.agile.tool.controllers;


import com.agile.tool.dtos.ProjectCreateDTO;
import com.agile.tool.entities.Project;
import com.agile.tool.entities.User;
import com.agile.tool.services.projectServices.ProjectService;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth/project")
@CrossOrigin("*")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    public ProjectController(ProjectService projectService){
        this.projectService = projectService;
    }


    @PostMapping("/create")
    public ResponseEntity<Project> createProject(@RequestBody ProjectCreateDTO projectCreateDTO) throws BadRequestException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();

        Project project = new Project();
        project.setProjectName(projectCreateDTO.getProjectName());
        project.setCompanyName(projectCreateDTO.getCompanyName());

        project.setCreatedBy(user);

        Project savedProject = projectService.saveProject(project);

        return new ResponseEntity<>(savedProject, HttpStatus.CREATED);
    }


}
