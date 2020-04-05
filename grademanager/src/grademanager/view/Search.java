package grademanager.view;

import static grademanager.resource.R.*;

import grademanager.model.Dto;

public class Search implements View {

	@Override
	public void display() {
		System.out.println("::::::::::::::: 검색 기능 :::::::::::::::");
		System.out.print("검색할 이름을 입력해 주세요 >> ");
		Dto dto = new Dto();
		dto.setName(scan.next());
		mapper.put("search", dto);
		
	}
	
	public void display(Dto[] arr){
		if((Dto[])mapper.get("search[]")==null){
			System.out.println("일치하는 내용이 없습니다!");
			mapper.put("no",0);
			controller.service();
		}
		
		if(((Dto[])mapper.get("search[]")).length==0){
			System.out.println("일치하는 내용이 없습니다!");
			mapper.put("no",0);
			controller.service();
		}
		System.out.println("-------------------------------------------------------------------------");
		System.out.println("[고유번호\t이름\t국어\t수학\t영어\t총점\t평균\t학점\t등수\t]");
		for(Dto d : (Dto[])mapper.get("search[]")){
			System.out.println(d);
		}
		System.out.println("-------------------------------- 검색 완료! --------------------------------");

	}

}
