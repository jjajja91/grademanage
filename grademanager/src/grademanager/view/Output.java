package grademanager.view;

import static grademanager.resource.R.*;

import grademanager.model.Dto;

public class Output implements View {

	@Override
	public void display() {
		System.out.println("::::::::::::::: 출력 기능 :::::::::::::::");
		if((Dto[])mapper.get("output")==null){
			System.out.println("출력할 내용이 없습니다!");
			return;
		}
		
		if(((Dto[])mapper.get("output")).length==0){
			System.out.println("출력할 내용이 없습니다!");
			return;
		}
		System.out.println("-------------------------------------------------------------------------");
		System.out.println("[고유번호\t이름\t국어\t수학\t영어\t총점\t평균\t학점\t등수\t]");
		for(Dto d : (Dto[])mapper.get("output")){
			System.out.println(d);
		}
		System.out.println("-------------------------------- 출력 완료! --------------------------------");
	}

}
