package com.gestion.magasin.service;

import java.util.List;

import com.gestion.magasin.entities.Categorie;

public interface CategorieService {
	public Categorie persistCategorie (Categorie c); 
	public void deleteCategorie (Long id); 
	public List<Categorie> getAllCategories(); 
	public Categorie findCategorieByTd( Long id); 
	public List<Categorie> findCategoriesByNom(String nom);

}
