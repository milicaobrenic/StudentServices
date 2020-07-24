package com.example.fakultetweb.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.fakultetweb.repository.*;

import model.*;

@Controller
@RequestMapping(value="/askontroler")
public class AsistentController {

	@Autowired
	PredmetRepository pr;
	@Autowired
	KorisnikRepository kr;
	@Autowired
	IspitRepository ir;
	@Autowired
	BodoviRepository br;
	
	@RequestMapping(value="/predmetiAsistenta", method=RequestMethod.GET)
	public String predmetiAsistenta(HttpServletRequest request) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalNameString = authentication.getName();
		Korisnik korisnik = kr.findByKorisnickoIme(currentPrincipalNameString);
		int idKorisnik=korisnik.getIdKorisnik();
		List<Predmet> predmetiAsistenta=pr.getPredmete(idKorisnik);
		request.getSession().setAttribute("predmetiA", predmetiAsistenta);
		return "sviPredmetiAsistenta";
	}
	
	@RequestMapping(value="/prikazStudenata", method=RequestMethod.GET)
	public String prikazStudenata(HttpServletRequest request, Integer idPredmet) {
		List<Korisnik> studenti=kr.getStudenteZaPredmet(idPredmet, "STUDENT");
		request.getSession().setAttribute("studentiP", studenti);
		return "prikazStudenataZaPredmet";
	}
	
	@RequestMapping(value="/ispitiStudenta", method=RequestMethod.GET)
	public String sviIspiti(HttpServletRequest request, Integer idKorisnik) {
		List<Ispit> ispiti=ir.getIspiteStudenta(idKorisnik);
		request.getSession().setAttribute("ispitiB", ispiti);
		return "unosBodova";
	}
	
	@RequestMapping(value="/upisivanjeBodova", method=RequestMethod.POST)
	public String upisivanjeBodova(HttpServletRequest request, Integer idIspit, String kolokvijumi, String usmeni, String ukupno) {
		Ispit ispit=ir.findById(idIspit).get();
		Bodovi bodovi=new Bodovi();
		bodovi.setKolokvijumi(kolokvijumi);
		bodovi.setUsmeniIspit(usmeni);
		bodovi.setUkupno(ukupno);
		bodovi.setIspit(ispit);
		String porukaB=null;
		Bodovi sacuvano=br.save(bodovi);
		if(sacuvano!=null) {
			porukaB="Bodovi su uspesno sacuvani!";
		}else {
			porukaB="Greska... Bodovi nisu sacuvani.";
		}
		request.getSession().setAttribute("porukaB", porukaB);
		return "unosBodova";
	}
	
}
