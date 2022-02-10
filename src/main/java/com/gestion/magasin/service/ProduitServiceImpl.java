package com.gestion.magasin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.magasin.entities.Produit;
import com.gestion.magasin.repository.ProduitRepository;

@Service
public class ProduitServiceImpl implements ProduitService {
	@Autowired
	ProduitRepository produitRepository;

	@Override
	public List<Produit> getAllProduits() {
		return produitRepository.findAll();
	}

	@Override
	public Produit persistProduit(Produit p) {
		return produitRepository.save(p);
	}

	@Override
	public void deleteProduit(Long id) {
		produitRepository.deleteById(id);
	}

	@Override
	public Produit findProduitByTd(Long id) {
		return produitRepository.getById(id);
	}

	@Override
	public List<Produit> findProduitsByNom(String nom) {
		return produitRepository.findByNomContains(nom);
	}

	@Override
	public List<Produit> findProduitsByCat(Long id) {
		return produitRepository.rechercheParCategorie(id);
	}
}
