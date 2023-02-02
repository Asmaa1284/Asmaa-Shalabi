package com.kani.springBoot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kani.springBoot.entity.Medicine;
import com.kani.springBoot.exception.MedecineNotFoundException;


@Service
public interface MedicineService {
	Medicine addNewMed(Medicine medicine);
	Medicine deleteMedicine(int id) throws MedecineNotFoundException;
	Medicine getMed(int id) throws MedecineNotFoundException;
	Medicine updateMed(Medicine medicine,int id) throws MedecineNotFoundException;
	List<Medicine>getMedByCat(int id);
	List<Medicine> getAllMeds() throws MedecineNotFoundException;
	Medicine getByName(String name);
	long getQuantityByName(String name);
}
