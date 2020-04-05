package grademanager.view;

import static grademanager.resource.R.*;

import java.util.InputMismatchException;

public class Menu implements View {

	@Override
	public void display() {
		System.out.println(":::::::::::: 성적관리프로그램 ::::::::::::");
		System.out.println("1.입력 2.출력 3.검색 4.수정 5.삭제 6.정렬 7.종료");
		System.out.print("Choice >> ");
		try {
			mapper.put("no", scan.nextInt());
		} catch (InputMismatchException ime) {
			scan.nextLine();
			mapper.put("no", -1);
		}

	}

}
