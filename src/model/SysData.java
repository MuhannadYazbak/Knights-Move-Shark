package model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONObject;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.nio.file.Files;
import java.nio.file.Paths;


public class SysData {
	private  ObservableList<Question> questions; 
	static SysData data = null;
	private SysData() {
		questions = FXCollections.observableArrayList();
	}
	public static SysData getInstance() {
		if(data == null)
			data = new SysData();
		return data;
	}
	
	
	public ObservableList<Question> getQuestions() {
		return getInstance().questions;
	}
	public void setQuestions(ObservableList<Question> questions) {
		getInstance().questions = questions;
	}
	/**
	 * add a new question to questions.
	 * @param text the String of the question
	 */
	public void addQuestion(Question q) {
		getInstance().questions.add(q);
	}
	public void writeToJson() throws IOException {
		//add existing questions
//		String resourceName ="/questions.json";
//		String loc = new String(System.getProperty("user.dir")+"\\questions.json");
//        File file1 = new File(loc);
//        if(file1.exists()) {+
//        	readQuestions();
//        }

        JSONObject finalOutput = new JSONObject();
		JSONArray QuestionList = new JSONArray();
        

        
		
		
		for (Question q: questions) {
			JSONObject questionObject = new JSONObject();
			questionObject.put("question", q.getText());
			JSONArray array = new JSONArray();
			
			//ObservableList<Answer> array =q.getAnswers();
			for(Answer a:q.getAnswers()) {
				array.put(a.getAnswerText());
			}
			questionObject.put("answers", array);
			questionObject.put("correct_ans", (q.getRightAnswer()));
			questionObject.put("level", q.getDiff());
			questionObject.put("team", "Shark");

			
			
		    QuestionList.put(questionObject);
		}
		//finalOutput.put("questions", QuestionList);
		finalOutput.append("questions", QuestionList);
      
        try (FileWriter file = new FileWriter("questions.json")) {
            //We can write any JSONArray or JSONObject instance to the file
            file.write((finalOutput).toString()); 
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	public void readQuestions() throws IOException {
		
		String loc = new String(System.getProperty("user.dir")+"\\questions.json");
        File file = new File(loc);
       
        String content = new String(Files.readAllBytes(Paths.get(file.toURI())));
        //System.out.println(content);
        JSONObject jsonContent = new JSONObject(content);
        JSONArray jsonQuestions = jsonContent.getJSONArray("questions").getJSONArray(0);
        //JSONArray jsonArrayQuestion = jsonQuestions.getJSONArray("question");
        //int questionId = 0;
        System.out.println(jsonQuestions.length());
        for (int i = 0; i<jsonQuestions.length();i++) {
        	JSONObject question =  (jsonQuestions.getJSONObject(i));
        	//questionId = i+1;
        	//jsonQuestions.get
        	String questionName=question.getString("question");
        	String author = "";
        	
        	Difficulty level = Difficulty.valueOf(question.getString("level"));
        	//System.out.println(questionName+" "+ level);
        	JSONArray answers = new JSONArray();
        	answers = question.getJSONArray("answers");
        	ObservableList<Answer>  answersArray = FXCollections.observableArrayList();
        	int correctAnsw =  question.getInt("correct_ans");
        	
        	for(int j=0;j<answers.length();j++) {
        		if(correctAnsw==j+1) {
        		}
        		answersArray.add(new Answer(answers.getString(j) ));
        	}
        	
        	
        	Question q =new Question(questionName,level, answersArray,correctAnsw, author);
        	if(!SysData.getInstance().getQuestions().contains(q)) {
        		getInstance().questions.add(q);
    		}
        	
        	
        	
        }

	}
	
	
	public void readJson() throws IOException {
		String loc = new String(System.getProperty("user.dir")+"\\questions.json");
        File file = new File(loc);
        String content = new String(Files.readAllBytes(Paths.get(file.toURI())));
        //System.out.println(content);
        JSONObject jsonContent = new JSONObject(content);
        JSONArray jsonQuestions = jsonContent.getJSONArray("questions");
        System.out.println(jsonQuestions.length());
        for (int i = 0; i<jsonQuestions.length();i++) {
        	JSONObject question = (JSONObject) jsonQuestions.get(i);
        	String questionName=question.getString("question");
        	String level = question.getString("level");
        	System.out.println(questionName+" "+ level);
        	
        }

	}
	/**
	 * remove a question from questions.
	 * @param id the ID of the question to be removed
	 * @return true if the wanted question was removed, false otherwise.
	 */
	public boolean removeQuestion(Question question) {
		for (Question q : questions) {
			if (q.getId()== question.getId()) {
				questions.remove(q);
				return true;
			}
		}
		return false;
	}
	public int getQuestionIdByText(String text) {
		for (Question q: questions) {
			if(q.getText().equals(text))
				return q.getId();
		}
		return 0;
	}


}
