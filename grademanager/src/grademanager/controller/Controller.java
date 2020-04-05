package grademanager.controller;

import static grademanager.resource.R.*;

import grademanager.model.Dto;

public class Controller {

	public void search() {
		search.display();
		mapper.put("search[]", dao.readSome((Dto) mapper.get("search")));
		search.display((Dto[]) mapper.get("search[]"));
	}

	public void service() {
		mapper.put("no", 0);
		if ((Integer) mapper.get("no") == 0) {
			menu.display();
		}
		switch ((Integer) mapper.get("no")) {
		case 1:
			input.display();
			dao.create((Dto) mapper.get("input"));
			dao.rank();
			break;
		case 2:
			mapper.put("output", dao.readAll());
			output.display();
			break;
		case 3:
			search();
			break;
		case 4:
			search();
			modify.display();
			dao.update((Dto)mapper.get("modify"));
			dao.rank();
			break;
		case 5:
			search();
			delete.display();
			dao.delete((Dto)mapper.get("delete"));
			dao.rank();
			break;
		case 6:
			mapper.put("sort", dao.sort());
			rank.display();
			break;
		case 7:
			System.out.println("프로그램을 종료합니다!");
			System.exit(0);
			break;

		}
		mapper.put("no", 0);
		service();
	}

}
