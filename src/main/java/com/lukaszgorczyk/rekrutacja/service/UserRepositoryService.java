package com.lukaszgorczyk.rekrutacja.service;

import com.lukaszgorczyk.rekrutacja.model.Branch;
import com.lukaszgorczyk.rekrutacja.model.UserRepository;
import com.lukaszgorczyk.rekrutacja.model.UserRepositoryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserRepositoryService {

    @Autowired
    private RestTemplate template = new RestTemplate();

    public List<UserRepository> findAllRepo(String userName) {
        UserRepositoryWrapper[] wrappedRepos = template.getForObject("https://api.github.com/users/" + userName + "/repos", UserRepositoryWrapper[].class);
        return transmitWrappedRepos(wrappedRepos);
    }

    private List<UserRepository> transmitWrappedRepos(UserRepositoryWrapper[] wrappedRepos) {
        List<UserRepository> userRepositoriesList = new ArrayList<>();
        for (int i = 0; i < wrappedRepos.length; i++) {
            if (wrappedRepos[i].getFork()) {
                continue;
            } else {
                userRepositoriesList.add(new UserRepository(
                        wrappedRepos[i].getName(),
                        wrappedRepos[i].getOwner().getLogin(),
                        getBranchesFromRepo(wrappedRepos[i].getName(), wrappedRepos[i].getOwner().getLogin())));
            }
        }
        return userRepositoriesList;
    }

    private Branch[] getBranchesFromRepo(String repositoryName, String userName) {

        Branch[] repositoryBranchesList = template.getForObject("https://api.github.com/repos/" + userName + "/" + repositoryName + "/branches", Branch[].class);
        return repositoryBranchesList;
    }
}
