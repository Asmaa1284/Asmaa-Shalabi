package com.kani.springBoot.service;

import java.util.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.support.ReflectivePropertyAccessor.OptimalPropertyAccessor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.kani.springBoot.entity.Customer;
import com.kani.springBoot.entity.Medicine;
import com.kani.springBoot.exception.MedecineNotFoundException;

import com.kani.springBoot.repositry.MedicineRepository;

import jakarta.transaction.Transactional;

@Service
@Component
@Transactional
public class MedicineServiceImpl implements MedicineService{
	@Autowired
 private MedicineRepository medrep;
	@Override
	public Medicine addNewMed(Medicine medicine) {
		 medrep.save(medicine);
		return medicine;
	}

	@Override
	public Medicine deleteMedicine(int id) throws MedecineNotFoundException {
		 Optional<Medicine> med= medrep.findById(id);
		 med.orElseThrow(()->(new MedecineNotFoundException ("No Medicine with this I.D")));
		 medrep.deleteById(id);
		return med.get();
	}

	@Override
	public Medicine getMed(int id) throws MedecineNotFoundException {
		 Optional<Medicine> med= medrep.findById(id);
		 med.orElseThrow(()->(new MedecineNotFoundException ("No Medicine with this I.D")));
		
		
		return med.get();
	}

	@Override
	public Medicine updateMed(Medicine medicine, int id) throws MedecineNotFoundException {
		Optional<Medicine>find= medrep.findById(id);
		if(find.isPresent()) {
		  Medicine medUpdated= find.get();
		  //custUpdated.setiD(customer.getiD());
		  medUpdated.setCompany(medicine.getCompany());
		  medUpdated.setIngridients(medicine.getIngridients());
		  medUpdated.setName(medicine.getName());
		  medUpdated.setTypeOfMed(medicine.getTypeOfMed());
		  medUpdated.setCate(medicine.getCate());
		  medUpdated.setPrice(medicine.getPrice());
		   medrep.save(medUpdated);
		
		return medUpdated;
		}
		return find.orElseThrow(()->(new MedecineNotFoundException("Medicine Not Found")));
	}

	@Override
	public List<Medicine> getAllMeds() throws MedecineNotFoundException {
		List<Medicine> list= medrep.findAll();
		if(list.isEmpty()) {
			throw new MedecineNotFoundException("No Medecine Here");
		}
		return list;
	}

	@Override
	public List<Medicine> getMedByCat(int id) {
		List<Medicine> list= medrep.findMedByCate(id);
		if(list.isEmpty()) {
			throw new MedecineNotFoundException("No Med with this category id");
		}
		return list;
	}

	@Override
	public long getQuantityByName(String name) {
		long count= medrep.findAll().stream().filter(med-> med.getName().equalsIgnoreCase(name)).count();
		return count;
	}

	@Override
	public Medicine getByName(String name) {
		Medicine me=medrep.findByName(name).get();
		return me;
	}
	

}
