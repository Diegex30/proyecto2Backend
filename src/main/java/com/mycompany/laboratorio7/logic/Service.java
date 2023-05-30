
package com.mycompany.laboratorio7.logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Service {
    private static Service uniqueInstance;
    
    public static Service instance(){
        if (uniqueInstance == null){
            uniqueInstance = new Service();
        }
        return uniqueInstance; 
    }

    HashMap<String,Usuario> usuarios;
    
    private Service(){
        usuarios = new HashMap();
        Usuario c;
        c=new Usuario("111", "123", 1);
        usuarios.put(c.user, c);
         
        c=new Usuario("222", "123", 2);
        usuarios.put(c.user, c);
        
        c=new Usuario("333", "123", 1);
        usuarios.put(c.user, c);  
    }

    public Usuario read(String name)throws Exception{
        Usuario c = usuarios.get(name);
        if (c!=null) return c;
        else throw new Exception("User does not exist");
    }
    
    public boolean verificar(String user, String pass){
        Usuario c = usuarios.get(user);
        if (c!=null)
            if(c.getPass() == pass)
                return true;
        return false;
    }

    public List<Usuario> find(String patron){
        return usuarios.values().stream().
                filter( c-> c.user.contains(patron)).
                collect(Collectors.toList());
    }
    

    public void delete(String name){
        usuarios.remove(name);
    }
   
}
