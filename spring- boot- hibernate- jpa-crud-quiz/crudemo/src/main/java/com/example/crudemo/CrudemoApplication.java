package com.example.crudemo;

import com.example.crudemo.dao.QuestionDAO;
import com.example.crudemo.entity.Question;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudemoApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(QuestionDAO questionDAO) {

		return runner -> {
//			createQuestion(questionDAO);
//
//			createMultipleQuestions(questionDAO);
//
//			readQuestion(questionDAO);
//
//			queryForQuestion(questionDAO);
//
			queryForQuestionsById(questionDAO);
//
//			updateQuestion(questionDAO);
//
//			deleteQuestion(questionDAO);
//
//			deleteAllQuestion(questionDAO);
		};
	}

	private void deleteAllQuestion(QuestionDAO questionDAO) {

		System.out.println("Deleting all Questions");
		int numRowsDeleted = questionDAO.deleteAll();
		System.out.println("Deleted row count: " + numRowsDeleted);	}

	private void deleteQuestion(QuestionDAO questionDAO) {

		int studentId = 2;
		System.out.println("Deleting question id: " + studentId);
		questionDAO.delete(studentId);
	}

	private void updateQuestion(QuestionDAO questionDAO) {

		// retrieve student based on the id: primary key
		int studentId = 1;
		System.out.println("Getting Question with id: " + studentId);
		Question myQuestion = questionDAO.findById(studentId);

		// change first name to "John"
		System.out.println("Updating content ...");
		myQuestion.setContent("What is infinity?");

		// update the question
		questionDAO.update(myQuestion);

		// display the updated question
		System.out.println("Updated Question: " + myQuestion);
	}

	private void queryForQuestion(QuestionDAO questionDAO) {

		List<Question> myQuestion = questionDAO.findAll();
		for (Question tempQuestion : myQuestion){

			System.out.println(tempQuestion);
		}

	}

	private void queryForQuestionsById(QuestionDAO questionDAO) {

		// get a list of questions
		List<Question> theQuestions = questionDAO.findByTopic(10);

		// display list of questions
		for (Question tempQuestion : theQuestions) {
			System.out.println(tempQuestion);
		}
	}

	private void createMultipleQuestions(QuestionDAO questionDAO) {

		// create multiple questions
		System.out.println("Creating 3 question objects ...");
		Question tempQuestion1 = new Question(10, 1, "What is pi");
		Question tempQuestion2 = new Question(11, 2, "What is pi/2");
		Question tempQuestion3 = new Question(11, 3, "What is pi/3");

		// save the question objects
		System.out.println("Saving the questions ...");
		questionDAO.save(tempQuestion1);
		questionDAO.save(tempQuestion2);
		questionDAO.save(tempQuestion3);
	}

	private void createQuestion(QuestionDAO questionDAO) {

		// create the question object
		System.out.println("Creating new question object ...");
		Question tempQuestion = new Question(13, 3, "What is pi/4");

		// save the question object
		System.out.println("Saving the question ...");
		questionDAO.save(tempQuestion);

		// display id of the saved question
		System.out.println("Saved question. Generated id: " + tempQuestion.getId());
	}

	private void readQuestion(QuestionDAO questionDAO){

		// create  a question object
		Question tempQuestion = new Question(11, 3, "What is pi/6");
		// save the question

		questionDAO.save(tempQuestion);
		// display id of the saved question
		int theId = tempQuestion.getId();
		System.out.println("Displaying Question id: " + theId);

		// retrieve question based on the id: primary key

		System.out.println("Retrieving question with id: " + theId);
		Question question = questionDAO.findById(theId);
		// display question
		System.out.println("Displaying Question: " + question);


	}
}

