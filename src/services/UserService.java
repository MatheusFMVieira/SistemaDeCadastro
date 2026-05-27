package services;

import java.util.ArrayList;
import java.util.List;

import entities.User;
import interfaces.UserRepository;

public class UserService  implements UserRepository{
    private List<User> listarUsuarios = new ArrayList<>();

    @Override
    public void cadastrar(User user) {
        listarUsuarios.add(user);
    }

    @Override
    public List<User> listar() {
        return listarUsuarios;
    }

    @Override
    public User buscarPorId(int id) {
        for(User user : listarUsuarios){
            if(user.getId() == id){
                return user;
            }
        }
        return null;
    }

    @Override
    public boolean remover(int id) {
        User user = buscarPorId(id);
        if(user != null){
            listarUsuarios.remove(user);
            return true;
        }
        return false;
    }

    @Override
    public boolean atualizar(User userAtualizado) {
        User userCadastrados = buscarPorId(userAtualizado.getId());
        if(userCadastrados != null ){
            userCadastrados.setNome(userAtualizado.getNome());
            userCadastrados.setIdade(userAtualizado.getIdade());
            userCadastrados.setEmail(userAtualizado.getEmail());
            return true;
        }
        return false;
    }
}
