package com.gestion.magasin.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.magasin.entities.Categorie;

public interface CategorieRepository extends JpaRepository<Categorie,Long>{
	public List <Categorie> findByNomContains(String nom);

}
