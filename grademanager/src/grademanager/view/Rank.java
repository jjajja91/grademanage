package grademanager.view;

import static grademanager.resource.R.mapper;

import grademanager.model.Dto;

public class Rank implements View {

	@Override
	public void display() {
		System.out.println("::::::::::::::: 정렬 기능 :::::::::::::::");
		if((Dto[])mapper.get("sort")==null){
			System.out.println("출력할 내용이 없습니다!");
			return;
		}
		
		if(((Dto[])mapper.get("sort")).length==0){
			System.out.println("출력할 내용이 없습니다!");
			return;
		}
		System.out.println("-------------------------------------------------------------------------");
		System.out.println("[고유번호\t이름\t국어\t수학\t영어\t총점\t평균\t학점\t등수\t]");
		for(Dto d : (Dto[])mapper.get("sort")){
			System.out.println(d);
		}
		System.out.println("-------------------------------- 정렬 완료! --------------------------------");

	}

}
