package principal;

public class App {
	
	static int total = 0;

	public static void main(String[] args) throws InterruptedException {
		/*
		 * Processus: programme en cours d'exécution
		 * Thread: unités physique d'exécution d'une tâche
		 * 
		 * Le multi threading permet d'obtenir des applications non bloquantes
		 */
		
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Tâche1..........."+Thread.currentThread().getName());
				
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Tâche2..........."+Thread.currentThread().getName());
				
			}
		});
		
		t1.start();
		t2.start();
		
		t1.join(); //join: mets en attente le thread principale
		t2.join();
		
		System.out.println("Tâche principale..............."+Thread.currentThread().getName());
		
		System.out.println(">>>> Gestion des accès conccurrentiels à une ressource partagée:");
		
		Thread th1 = new Thread(App::addMillion);
		Thread th2 = new Thread(App::addMillion);
		Thread th3 = new Thread(App::addMillion);
		
		th1.start();
		th2.start();
		th3.start();
		
		th1.join();
		th2.join();
		th3.join();
		
		System.out.println("Total = "+total);

		//Tâche asynchrone est une tâche exécutée par un thread à part
	}
	
	//méthode qui peut être exécutée en mode asynchrone
	public synchronized static void addMillion() {
		for (int i = 0; i < 1000000; i++) {
			total++;
		}
	}

}
