package com.gestion.magasin.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.gestion.magasin.entities.Produit;
import com.gestion.magasin.service.CategorieService;
import com.gestion.magasin.service.ProduitService;

@Controller
@RequestMapping("/produit/")
public class ProduitController {
	private String uploadDirectory = System.getProperty("user.dir") + "/src/main/resources/static/photos";
	@Autowired
	ProduitService produitService;
	@Autowired
	CategorieService categorieService;

	@GetMapping("all")
	public String index(Model model) {
		// System.out.println("-----------------------------------------------");
		model.addAttribute("produits", produitService.getAllProduits());
		model.addAttribute("nombre", produitService.getAllProduits().size());
		model.addAttribute("categories", categorieService.getAllCategories());
		return "index";
	}

	@GetMapping("add")
	public String showForm(Model model) {
		model.addAttribute("categories", categorieService.getAllCategories());
		return "addProduit";
	}

	@PostMapping("add")
	public String addProduit(Produit p, @RequestParam("file") MultipartFile multipartFile) {
		System.out.println(multipartFile);
		String fileName = multipartFile.getOriginalFilename();
		Path fileNameAndPath = Paths.get(uploadDirectory, fileName);

		try {
			Files.write(fileNameAndPath, multipartFile.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}

		p.setPhoto(fileName);
		produitService.persistProduit(p);
		return "redirect:/produit/all";
	}
	/*
	 * @PostMapping("add") public String addProduit(Produit p) {
	 * produitService.persistProduit(p); return "redirect:/produit/all"; }
	 */

	@GetMapping("delete/{id}")
	public String suppProduit(@PathVariable Long id) {
		produitService.deleteProduit(id);
		return "redirect:/produit/all";
	}

	@GetMapping("edit/{id}")
	public String editProduit(@PathVariable Long id, Model model) {
		model.addAttribute("produit", produitService.findProduitByTd(id));
		model.addAttribute("categories", categorieService.getAllCategories());
		return "editProduit";
	}

	@GetMapping("detail/{id}")
	public String detailProduit(@PathVariable Long id, Model model) {
		model.addAttribute("produit", produitService.findProduitByTd(id));
		model.addAttribute("categories", categorieService.getAllCategories());
		return "detailProduit";
	}

	@PostMapping("update")
	public String updateProduit(Produit p) {
		produitService.persistProduit(p);
		return "redirect:/produit/all";
	}

	@PostMapping("search")
	public String updateProduit(@RequestParam String nom, Model model) {
		model.addAttribute("produits", produitService.findProduitsByNom(nom));
		model.addAttribute("nombre", produitService.getAllProduits().size());
		return "index";
	}

	@PostMapping("filtre")
	public String filtreProduit(@RequestParam Long categorie, Model model) {
		model.addAttribute("produits", produitService.findProduitsByCat(categorie));
		model.addAttribute("categories", categorieService.getAllCategories());
		model.addAttribute("nombre", produitService.getAllProduits().size());
		return "index";
	}
}
