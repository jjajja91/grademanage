package grademanager.view;

import grademanager.model.Dto;
import static grademanager.resource.R.*;

import java.util.InputMismatchException;

public class Input implements View {

	@Override
	public void display() {
		System.out.println("::::::::::::::: 입력 기능 :::::::::::::::");
		Dto dto = new Dto();
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
		mapper.put("input", dto);
		System.out.println("--------------------입력 완료!-----------------------");

	}

}
