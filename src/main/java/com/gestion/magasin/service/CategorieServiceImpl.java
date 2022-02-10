package com.gestion.magasin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.magasin.entities.Categorie;
import com.gestion.magasin.repository.CategorieRepository;
@Service
public class CategorieServiceImpl implements CategorieService {
	@Autowired
	CategorieRepository categorieRepository;

	@Override
	public List<Categorie> getAllCategories() {
		return categorieRepository.findAll();
	}

	@Override
	public void deleteCategorie(Long id) {
		categorieRepository.deleteById(id);
	}

	@Override
	public Categorie persistCategorie(Categorie p) {
		// TODO Auto-generated method stub
		return categorieRepository.save(p);
	}
	@Override
	public Categorie findCategorieByTd(Long id) {
		// TODO Auto-generated method stub
		return categorieRepository.getById(id);
	}

	@Override
	public List<Categorie> findCategoriesByNom(String nom) {
		// TODO Auto-generated method stub
		return categorieRepository.findByNomContains(nom);
	}

	

}
