package grademanager.view;

import grademanager.model.Dto;

import static grademanager.resource.R.*;

import java.util.InputMismatchException;

public class Modify implements View {

	@Override
	public void display() {
		System.out.println("::::::::::::::: 수정 기능 :::::::::::::::");
		System.out.print("수정할 학생의 고유번호를 입력해주세요 >> ");
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
			System.out.println("수정할 데이터를 찾을 수 없습니다!");
			display();
		} else {
			System.out.println("수정할 데이터를 찾았습니다!");
			Dto dto = new Dto();
			dto.setIdx(idx);
			System.out.print("이름을 입력해주세요 >> ");
			dto.setName(scan.next());
			int tmp = 0;
			try {
				while (true) {
					System.out.print("국어 성적을 입력해주세요(0~100) >> ");
					tmp = scan.nextInt();
					if (0 <= tmp && tmp <= 100) {
						dto.setKor(tmp);
						break;
					} else {
						System.out.println("[경고] 0~100 사이의 점수를 입력해주세요!");
					}
				}
				while (true) {
					System.out.print("수학 성적을 입력해주세요(0~100) >> ");
					tmp = scan.nextInt();
					if (0 <= tmp && tmp <= 100) {
						dto.setMath(tmp);
						break;
					} else {
						System.out.println("[경고] 0~100 사이의 점수를 입력해주세요!");
					}
				}

				while (true) {
					System.out.print("영어 성적을 입력해주세요(0~100) >> ");
					tmp = scan.nextInt();
					if (0 <= tmp && tmp <= 100) {
						dto.setEng(tmp);
						break;
					} else {
						System.out.println("[경고] 0~100 사이의 점수를 입력해주세요!");
					}
				}
			} catch (InputMismatchException ime) {
				scan.nextLine();
				System.out.println("[경고] 숫자만 입력해주세요!");
				display();
			}
			dto.setTotal();
			dto.setAvg();
			dto.setGrade();
			mapper.put("modify", dto);
			System.out.println("--------------------수정 완료!-----------------------");

		}

	}

}
