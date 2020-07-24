package com.example.fakultetweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.fakultetweb.repository.*;
import model.*;
import java.util.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value="/skontroler")
public class StudentController {
	
	@Autowired
	PredmetRepository pr;
	@Autowired
	KorisnikRepository kr;
	@Autowired
	UlogaRepository ur;
	@Autowired
	SemestarRepository sr;
	@Autowired
	IspitRepository ir;
	
	
	@RequestMapping(value="/semestriStudenta", method=RequestMethod.GET)
	public String semestriStudenta (HttpServletRequest request) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalNameString = authentication.getName();
		Korisnik korisnik = kr.findByKorisnickoIme(currentPrincipalNameString);
		int idKorisnik=korisnik.getIdKorisnik();
		List<Semestar> semestri=sr.getSemestreStudenta(idKorisnik);
		request.getSession().setAttribute("semestri", semestri);
		return "sviSemestriStudenta";
	}
	
	@RequestMapping(value="/predmetiStudenta", method=RequestMethod.GET)
	public String predmetiStudenta(HttpServletRequest request, Integer idSemestar) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalNameString = authentication.getName();
		Korisnik korisnik = kr.findByKorisnickoIme(currentPrincipalNameString);
		int idKorisnik=korisnik.getIdKorisnik();
		List<Predmet> predmeti=pr.getPredmeteKorisnika(idKorisnik, idSemestar);
		request.getSession().setAttribute("predmeti", predmeti);
		return "sviPredmetiStudenta";
	}
	
	@RequestMapping(value="/prijavaIspita", method=RequestMethod.GET)
	public String prijavaIspita(HttpServletRequest request) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalNameString = authentication.getName();
		Korisnik korisnik = kr.findByKorisnickoIme(currentPrincipalNameString);
		int idKorisnik=korisnik.getIdKorisnik();
		List<Predmet> predmeti=pr.getPredmete(idKorisnik);
		request.getSession().setAttribute("predmetiS", predmeti);
		return "prijavaIspita";
	}
	
	@RequestMapping(value="/potvrdaPrijavaIspita", method=RequestMethod.POST)
	public String potvrdaPrijavaIspita(@RequestParam("cbox") List<Integer> predmets,HttpServletRequest request) {
		if(predmets!=null) {
			for(int idP:predmets) {	
					String porukaGreska=null;
					String porukaI=null;
					
					Predmet predmet=pr.findById(idP).get();
					if(predmet.getIspits().size()==0) {
						Ispit ispit=new Ispit();
						ispit.setPredmet(predmet);
						Ispit sacuvani=ir.save(ispit);
						if(sacuvani!=null) {
							porukaI="Ispiti su uspesno prijavljeni!" ;
						}else {
							porukaI="Greska! Prijava ispita nije izvrsena uspesno!";
						}
						request.getSession().setAttribute("porukaI", porukaI);
					}else {
						porukaGreska="Vec ste prijavili ispit za izabrani predmet!";
						request.getSession().setAttribute("porukaG", porukaGreska);
					}
					
					
				}
		}
		return "prijavaIspita";
	}
	
	
	

}
