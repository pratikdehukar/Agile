package com.agile.tool.repositories;

import com.agile.tool.entities.Project;
import com.agile.tool.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project ,Long> {

}
