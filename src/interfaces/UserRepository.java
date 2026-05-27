package interfaces;

import java.util.List;
import entities.User;

public interface UserRepository {
    void cadastrar(User user);
    List<User> listar();
    User buscarPorId(int id);
    boolean remover(int id);
    boolean atualizar(User user);
}
