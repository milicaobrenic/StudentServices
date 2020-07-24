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
@RequestMapping(value="/pkontroler")
public class ProfesorController {

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
	@Autowired
	RokRepository rr;
	
	@RequestMapping(value="/ispitiStudenta", method=RequestMethod.GET)
	public String sviIspiti(HttpServletRequest request, Integer idKorisnik) {
		List<Ispit> ispiti=ir.getIspiteStudenta(idKorisnik);
		request.getSession().setAttribute("ispiti", ispiti);
		return "unosOcene";
	}
	
	@RequestMapping(value="/sviStudenti", method=RequestMethod.GET)
	public String prijavljeniStudenti(HttpServletRequest request) {
		List<Korisnik> studenti=kr.getStudente("STUDENT");
		request.getSession().setAttribute("studenti", studenti);
		return "prikazStudenata";
	}
	
	@RequestMapping(value="/upisOcene", method=RequestMethod.POST)
	public String upisOcene(HttpServletRequest request, Integer idIspit, String ocena) {
		Ispit ispit=ir.findById(idIspit).get();
		ispit.setOcena(ocena);
		String porukaOcena=null;
		Ispit sacuvani=ir.save(ispit);
		if(sacuvani!=null) {
			porukaOcena="Ocena je uspesno uneta!";
		}else {
			porukaOcena="Greska... Ocena nije uneta.";
		}
		request.getSession().setAttribute("porukaOcena", porukaOcena);
		return "unosOcene";
	}
	
	@RequestMapping(value="/sviIspiti", method=RequestMethod.GET)
	public String sviIspiti(HttpServletRequest request) {
		List<Ispit> ispiti=ir.findAll();
		request.getSession().setAttribute("ispitiP",ispiti);
		return "prikazIspita";
	}
	
	@RequestMapping(value="/sviPredmeti", method=RequestMethod.GET)
	public String sviPredmeti(HttpServletRequest request) {
		List<Predmet> predmeti=pr.findAll();
		request.getSession().setAttribute("predmetiP",predmeti);
		List<Rok> rokovi=rr.findAll();
		request.getSession().setAttribute("rokoviP",rokovi);
		return "dodavanjeNovogIspita";
	}
	
	@RequestMapping(value="/dodavanjeIspita", method=RequestMethod.POST)
	public String dodavanjeIspita(HttpServletRequest request, String opis, Integer idPredmet, Integer idRok) {
		Ispit ispit=new Ispit();
		ispit.setOpis(opis);
		Predmet p=pr.findById(idPredmet).get();
		ispit.setPredmet(p);
		Rok rok=rr.findById(idRok).get();
		ispit.setRok(rok);
		String porukaIspit=null;
		Ispit sacuvani=ir.save(ispit);
		if(sacuvani!=null) {
			porukaIspit="Ispit je uspesno sacuvan!";
		}else {
			porukaIspit="Greska... Ispit nije sacuvan.";
		}
		request.getSession().setAttribute("porukaIspit", porukaIspit);
		return "dodavanjeNovogIspita";
	}
	
}
