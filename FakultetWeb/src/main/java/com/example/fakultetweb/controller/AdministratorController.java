package com.example.fakultetweb.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.fakultetweb.repository.*;
import model.*;
import java.util.*;

@Controller
@RequestMapping(value="/akontroler")
public class AdministratorController {

	@Autowired
	PredmetRepository pr;
	@Autowired
	KorisnikRepository kr;
	@Autowired
	UlogaRepository ur;
	@Autowired
	SemestarRepository sr;
	
	@RequestMapping(value="/prikazKorisnika" , method=RequestMethod.GET)
	public String prikazKorisnika(HttpServletRequest request) {
		List<Korisnik> sviKorisnici=kr.findAll();
		request.getSession().setAttribute("sviKorisnici", sviKorisnici);
		return "prikazSvihKorisnika";
	}
	
	@RequestMapping(value="/dodavanjeKorisnika" , method=RequestMethod.POST)
	public String dodavanjeKorisnika(HttpServletRequest request, String ime, String prezime, String korisnickoIme,
			String lozinka, String uloga, String jmbg) {
		Korisnik k=null;
		if(uloga.equalsIgnoreCase("PROFESOR") || uloga.equalsIgnoreCase("STUDENT") || uloga.equalsIgnoreCase("ASISTENT") || uloga.equalsIgnoreCase("ADMINISTRATOR")) {
			k=new Korisnik();
			k.setIme(ime);
			k.setPrezime(prezime);
			k.setKorisnickoIme(korisnickoIme);
			k.setJmbg(jmbg);
			k.setLozinka(lozinka);
			Uloga u=ur.findByNaziv(uloga);
			k.setUloga(u);	
			String porukaKorisnik=null;
			Korisnik sacuvani=kr.save(k);
			if(sacuvani!=null) {
				porukaKorisnik="Novi korisnik je uspesno sacuvan!";
			}else {
				porukaKorisnik="Greska.. Korisnik nije sacuvan.";
			}
			request.getSession().setAttribute("porukaKorisnik", porukaKorisnik);
		}else {
			String porukaGreskaK="Uneli ste nepostojecu ulogu!";
			request.getSession().setAttribute("porukaGreskaK", porukaGreskaK);
		}
		return "dodavanjeNovogKorisnika";
	}
	
	@RequestMapping(value="/prikazPredmeta", method=RequestMethod.GET)
	public String prikazPredmeta(HttpServletRequest request) {
		List<Predmet> sviPredmeti=pr.findAll();
		request.getSession().setAttribute("sviPredmeti", sviPredmeti);
		return "prikazSvihPredmeta";
	}
	
	@RequestMapping(value="/prikazSemestara", method=RequestMethod.GET)
	public String prikazProfesora(HttpServletRequest request) {
		List<Semestar> semestri=sr.findAll();
		request.getSession().setAttribute("sviSemestri", semestri);
		return "dodavanjeNovogPredmeta";
	}
	
	@RequestMapping(value="/dodavanjePredmeta" , method=RequestMethod.POST)
	public String dodavanjeKorisnika(HttpServletRequest request, String naziv, String opis, String brojEspb, Integer idSemestar) {
		Predmet p=new Predmet();
		p.setNaziv(naziv);
		p.setOpis(opis);
		p.setBrojEspb(brojEspb);
		Semestar semestar=sr.findById(idSemestar).get();
		p.setSemestar(semestar);
		
		String porukaPredmet=null;
		Predmet sacuvani=pr.save(p);
		if(sacuvani!=null) {
			porukaPredmet="Predmet je uspesno sacuvan!";
		}else {
			porukaPredmet="Greska...Predmet nije sacuvan.";
		}
		request.getSession().setAttribute("porukaPredmet", porukaPredmet);
		return "dodavanjeNovogPredmeta";
	}
	
	
	
}
