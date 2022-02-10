package com.gestion.magasin.service;

import java.util.List;

import com.gestion.magasin.entities.Produit;

public interface ProduitService {
	public Produit persistProduit (Produit p); 
	public void deleteProduit (Long id); 
	public List<Produit> getAllProduits(); 
	public Produit findProduitByTd( Long id); 
	public List<Produit> findProduitsByNom(String nom);
	public List<Produit> findProduitsByCat(Long id);
}
