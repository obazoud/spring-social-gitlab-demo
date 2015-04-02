package com.github.burningduck.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.gitlab.api.Gitlab;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author p.hoeffling
 */
@Controller
@RequestMapping(value = "/gitlab")
public class GitlabController {
    
    private final Gitlab gitlab;

    @Autowired
    public GitlabController(Gitlab gitlab) {
        this.gitlab = gitlab;
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public String getIndexPage(Model model) {
        model.addAttribute("profile", gitlab.profileOperations().getProfile());
        return "gitlab/index";
    }

    
    @RequestMapping(value = "/projects", method = RequestMethod.GET)
    public String getProjectsPage(Model model) {
        model.addAttribute("projects", gitlab.projectOperations().getProjectsAccessibleByCurrentUser());
        return "gitlab/projects";
    }

    
    
    
}
