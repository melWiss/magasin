package com.gestion.magasin.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Produit{

@Id @GeneratedValue(strategy = GenerationType.IDENTITY)

private Long id; private String nom;
private double prix;
private int quantite;
private String photo;
@ManyToOne
Categorie categorie;
}