package proyectozombie.Users;

import java.util.ArrayList;

public class UserDataBase {

    protected ArrayList<User> listaUsuarios;

    public UserDataBase() {
        listaUsuarios= new ArrayList<User>();
    }
    public ArrayList<User> getListaUsuarios() {
        return listaUsuarios;
    }



    public boolean agregarUsuario(User usuario){
        return (listaUsuarios.add(usuario));
    }

    public boolean eliminarUsuario(User usuario){
        return (listaUsuarios.remove(usuario));
    }

    public User getUser(String userName){
        for (User usuario: listaUsuarios) {
            if(usuario.getName().equals(userName)) return usuario;
        }
        return null;
    }
}
