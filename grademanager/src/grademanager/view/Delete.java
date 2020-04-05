package grademanager.view;

import static grademanager.resource.R.mapper;
import static grademanager.resource.R.scan;

import java.util.InputMismatchException;

import grademanager.model.Dto;

public class Delete implements View {

	@Override
	public void display() {
		System.out.println("::::::::::::::: 삭제 기능 :::::::::::::::");
		System.out.print("삭제할 학생의 고유번호를 입력해주세요 >> ");
		int idx = 0;
		try {
			idx = scan.nextInt();
		} catch (InputMismatchException ime) {
			System.out.println("숫자만 입력하세요!");
			scan.nextLine();
			display();
		}

		boolean flag = false;
		for (int i = 0; i < ((Dto[]) mapper.get("search[]")).length; i++) {
			if (idx == ((Dto[]) mapper.get("search[]"))[i].getIdx()) {
				flag = true;
				break;
			}
		}
		if (!flag) {
			System.out.println("삭제할 데이터를 찾을 수 없습니다!");
			display();
		} else {
			System.out.println("삭제할 데이터를 찾았습니다!");
			Dto dto = new Dto();
			dto.setIdx(idx);
			mapper.put("delete", dto);
			System.out.println("--------------------삭제 완료!-----------------------");

		}
	}

}
