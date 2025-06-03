package com.karthikyadavmudike.learn_spring_boot.MedicalHistory;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicalHistoryService {
	
	@Autowired
	private MedicalHistoryRepository repo;
	
	List<String> findAllByPatientId(Long id)
	{
		List<MedicalHistory> list = repo.findAll();
		List<String> list2 = new ArrayList<>();
		
		for(int i=0;i<list.size();i++)
		{
			if(list.get(i).getPatientId()==id)
			{
				list2.add(list.get(i).getRecord());
			}
		}
		return list2;
	}
}
