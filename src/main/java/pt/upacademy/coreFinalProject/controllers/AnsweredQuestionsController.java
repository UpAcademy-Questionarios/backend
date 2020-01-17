package pt.upacademy.coreFinalProject.controllers;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Path;

import pt.upacademy.coreFinalProject.Repositories.AnsweredQuestionsRepository;
import pt.upacademy.coreFinalProject.Services.AnsweredQuestionsService;
import pt.upacademy.coreFinalProject.models.AnsweredQuestions;

@Path("answeredquestions")
@RequestScoped
public class AnsweredQuestionsController extends EntityController_<AnsweredQuestionsService, AnsweredQuestionsRepository, AnsweredQuestions>{

}