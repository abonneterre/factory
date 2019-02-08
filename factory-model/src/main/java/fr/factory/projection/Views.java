package fr.factory.projection;


public class Views {
	public static class Common {
		
	}
	
	public static class Lieu extends Common {
		
	}
	
	public static class LieuWithUtilisateur extends Lieu {
		
	}
	
	public static class Reservation extends Common{
		
	}
	
	public static class ReservationWithActivite extends Reservation{
		
	}


	public static class Categorie extends Common {
	}
	public static class Activite extends Common {
	}
	public static class ActiviteWithCategorie extends Activite {
	}
	public static class ActiviteWithCategorieAndReservations extends ActiviteWithCategorie {
	}
	public static class	ActiviteWithCategorieAndReservationsAndLieu extends ActiviteWithCategorieAndReservations {
	}
	public static class Proposition extends Common {
	}
	

}
