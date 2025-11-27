package association;

/**
 * Classes filles: ClientDbImpl, ClientFichierImpl
 */
public interface IClient {
	
	void insert(Client c);
	void delete(Client c);
	void update(Client c);

}
