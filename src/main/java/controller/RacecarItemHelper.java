package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.RacecarItem;

public class RacecarItemHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("carconsolelist");
	public void addItem(RacecarItem car) {
		EntityManager em = emfactory.createEntityManager(); 
		em.getTransaction().begin();
		em.persist(car); 
		em.getTransaction().commit(); 
	}
	public List<RacecarItem> showAllCars() {
		EntityManager em = emfactory.createEntityManager(); 
		List<RacecarItem> cars = em.createQuery("SELECT i FROM RacecarItem i").getResultList(); 
		em.close(); 
		return cars; 
	}
	public void deleteItem(String make, String model, String series) { 
		EntityManager em = emfactory.createEntityManager(); 
		em.getTransaction().begin(); 
		TypedQuery<RacecarItem> query = em.createQuery("select i from RacecarItem i where i.make = :selectedMake and i.model = :selectedModel and i.series = :selectedSeries", RacecarItem.class); 
		
		query.setParameter("selectedMake", make);
		query.setParameter("selectedModel", model); 
		query.setParameter("selectedSeries", series);
		
		query.setMaxResults(1); 
		
		RacecarItem result = query.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit(); 
		em.close(); 
	}
	public RacecarItem searchByID(int id) {
		EntityManager em = emfactory.createEntityManager(); 
		em.getTransaction().begin(); 
		RacecarItem foundCar = em.find(RacecarItem.class, id); 
		em.close(); 
		return foundCar;
	}
	public List<RacecarItem> searchByMake(String make) { 
		EntityManager em = emfactory.createEntityManager(); 
		em.getTransaction().begin(); 
		TypedQuery<RacecarItem> query = em.createQuery("select i from RacecarItem i where i.make = :selectedMake", RacecarItem.class);
		query.setParameter("selectedMake", make); 
		
		List<RacecarItem> foundCars = query.getResultList(); 
		em.close(); 
		return foundCars;
	}
	public List<RacecarItem> searchByModel(String model) { 
		EntityManager em = emfactory.createEntityManager(); 
		em.getTransaction().begin(); 
		TypedQuery<RacecarItem> query = em.createQuery("select i from RacecarItem i where i.model = :selectedModel", RacecarItem.class);
		query.setParameter("selectedModel", model); 
		
		List<RacecarItem> foundCars = query.getResultList(); 
		em.close(); 
		return foundCars; 
	}
	public List<RacecarItem> searchBySeries(String series) {
		EntityManager em = emfactory.createEntityManager(); 
		em.getTransaction().begin(); 
		TypedQuery<RacecarItem> query = em.createQuery("select i from RacecarItem i where i.series = :selectedSeries", RacecarItem.class);
		query.setParameter("selectedSeries", series); 
		List<RacecarItem> foundCars = query.getResultList(); 
		em.close(); 
		return foundCars; 
	}
	public List<RacecarItem> searchByCylinderArrangement(String engine) {
		EntityManager em = emfactory.createEntityManager(); 
		em.getTransaction().begin(); 
		TypedQuery<RacecarItem> query = em.createQuery("select i from RacecarItem i where i.arrangement =:selectedEngine", RacecarItem.class);
		query.setParameter("selectedEngine", engine); 
		
		List<RacecarItem> foundCars = query.getResultList(); 
		em.close(); 
		return foundCars; 
	}
	public List<RacecarItem> searchByEngineDisplacement(String displacement) { 
		EntityManager em = emfactory.createEntityManager(); 
		em.getTransaction().begin(); 
		TypedQuery<RacecarItem> query = em.createQuery("select i from RacecarItem i where i.displacement = :selectedDisplacement", RacecarItem.class); 
		query.setParameter("selectedDisplacement",  displacement); 
		List<RacecarItem> foundCars = query.getResultList(); 
		em.close(); 
		return foundCars; 		
	}
	public List<RacecarItem> searchByHorsePower(int horsePower) {
		EntityManager em = emfactory.createEntityManager(); 
		em.getTransaction().begin(); 
		TypedQuery<RacecarItem> query = em.createQuery("select i from RacecarItem i where i.horsePower >= :selectedHorsepower", RacecarItem.class);
		query.setParameter("selectedHorsepower", horsePower); 
		List<RacecarItem> foundCars = query.getResultList(); 
		em.close(); 
		return foundCars; 
	}
	public void updateItem(RacecarItem car) { 
		EntityManager em = emfactory.createEntityManager(); 
		em.getTransaction().begin();
		
		em.merge(car); 
		em.getTransaction().commit(); 
		em.close(); 
	}
	public void cleanUp() { 
		emfactory.close(); 
	}
}
