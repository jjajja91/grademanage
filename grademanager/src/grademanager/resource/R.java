package grademanager.resource;

import java.util.Scanner;

import grademanager.controller.Controller;
import grademanager.model.Dao;
import grademanager.view.Delete;
import grademanager.view.Input;
import grademanager.view.Menu;
import grademanager.view.Modify;
import grademanager.view.Output;
import grademanager.view.Rank;
import grademanager.view.Search;

public interface R {
	
	int MAX = 100;
	Scanner scan = new Scanner(System.in);
	
	Controller controller = new Controller();
	Map mapper = new Map();
	Menu menu = new Menu();
	Input input = new Input();
	Output output = new Output();
	Search search = new Search();
	Modify modify = new Modify();
	Delete delete = new Delete();
	Rank rank = new Rank();
	
	Dao dao = Dao.getInstance();
	

}
