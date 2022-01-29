package ad.orm.hibernate.service;

import ad.orm.hibernate.dao.ClienteDao;
import ad.orm.hibernate.dao.ClienteDaoImpl;
import ad.orm.hibernate.domain.Cliente;

public class ClienteService {
    private ClienteDao clienteDao;
    public ClienteService(){
        clienteDao = new ClienteDaoImpl();
    }
    public void save(Cliente cliente){
        clienteDao.insert(cliente);
    }
    public void delete(int idCliente){ //todo
        clienteDao.delete(getClienteById(idCliente).getCod_cliente());

    }
    public Cliente getClienteById(int id){
        return clienteDao.read(id);
    }
    public void update(Cliente cliente){
        clienteDao.update(cliente);
    }
}
