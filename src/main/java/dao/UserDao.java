package dao;


import model.User;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    private List<User> users;
    private  static  int id=1;

    public UserDao() {
        this.users=new ArrayList<>();
        this.users.add(new User(id++,"Tom","Jones"));
        this.users.add(new User(id++,"Bob","Bones"));
        this.users.add(new User(id++,"Roy","Dones"));
        this.users.add(new User(id++,"Bill","Kones"));
        this.users.add(new User(id++,"Max","Fones"));
    }
    public List<User> index(){
        return  users;
    }
    public  User show(int id){
        return users.stream().filter(user -> user.getId()==id).findAny().orElse(null);
    }
    public  void save(String name, String sureName) {
        users.add(new User(id++,name,sureName));
    }
    public  void update(int id, User updateUser) {
        User userToBeUdated = show(id);
        userToBeUdated.setName(updateUser.getName());
        userToBeUdated.setSureName(updateUser.getSureName());
    }
    public  void delete(int id) {
        users.removeIf(p->p.getId()==id);
    }
}
