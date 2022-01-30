package ad.orm.hibernate.service;

import ad.orm.hibernate.dao.ClienteDao;
import ad.orm.hibernate.dao.ClienteDaoImpl;
import ad.orm.hibernate.domain.Cliente;
import ad.orm.hibernate.domain.Contacto_cliente;

import java.util.List;

public class ClienteService {

    private ClienteDao clienteDao;

    public ClienteService(){
        clienteDao = new ClienteDaoImpl();
    }

    public void save(Cliente cliente){
        clienteDao.insert(cliente);
    }

    public void saveContacto(Contacto_cliente contacto_cliente){
        clienteDao.insertContacto(contacto_cliente);
    }

    public void delete(int idCliente){ //todo
        clienteDao.delete(getClienteById(idCliente).getCod_cliente());

    }
    public Cliente getClienteById(int id){
        return clienteDao.read(id);
    }

    public Contacto_cliente getContactoClienteById(int id){
        return clienteDao.readContacto(id);
    }

    public List<Cliente> readAll() {
        return  clienteDao.readAll();
    }

    public void update(Cliente cliente){
        clienteDao.update(cliente);
    }

    public void updateContacto(Contacto_cliente contacto_cliente){
        clienteDao.updateContacto(contacto_cliente);
    }
}
